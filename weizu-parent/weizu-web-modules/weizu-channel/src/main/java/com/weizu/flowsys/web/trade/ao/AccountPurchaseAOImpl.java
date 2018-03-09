package com.weizu.flowsys.web.trade.ao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weizu.flowsys.api.singleton.orderState.ResponseJsonDTO;
import com.weizu.flowsys.api.singleton.orderState.SendCallBackUtil;
import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.core.util.NumberTool;
import com.weizu.flowsys.operatorPg.enums.AccountTypeEnum;
import com.weizu.flowsys.operatorPg.enums.CallBackEnum;
import com.weizu.flowsys.operatorPg.enums.EventTypeEnum;
import com.weizu.flowsys.operatorPg.enums.LoginStateEnum;
import com.weizu.flowsys.operatorPg.enums.OrderResultEnum;
import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
import com.weizu.flowsys.web.agency.ao.ChargeAccountAo;
import com.weizu.flowsys.web.agency.dao.AgencyVODaoInterface;
import com.weizu.flowsys.web.agency.dao.impl.ChargeAccountDao;
import com.weizu.flowsys.web.agency.dao.impl.ChargeRecordDao;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.agency.pojo.ChargeRecordPo;
import com.weizu.flowsys.web.log.AccountEventPo;
import com.weizu.flowsys.web.log.dao.IAccountEventDao;
import com.weizu.flowsys.web.system_base.ao.SystemConfAO;
import com.weizu.flowsys.web.system_base.pojo.SystemConfPo;
import com.weizu.flowsys.web.trade.WXPayUtil;
import com.weizu.flowsys.web.trade.constant.WXPayConfig;
import com.weizu.flowsys.web.trade.dao.AccountPurchaseDao;
import com.weizu.flowsys.web.trade.dao.PurchaseDao;
import com.weizu.flowsys.web.trade.pojo.AccountPurchasePo;
import com.weizu.flowsys.web.trade.pojo.PurchasePo;
import com.weizu.flowsys.web.trade.pojo.PurchaseVO;
import com.weizu.web.foundation.String.StringHelper;

@Service(value="accountPurchaseAO")
public class AccountPurchaseAOImpl implements AccountPurchaseAO {

	@Resource
	private AccountPurchaseDao accountPurchaseDao;
	@Resource
	private PurchaseDao purchaseDAO;
	@Resource
	private ChargeAccountDao chargeAccountDao;
	@Resource
	private ChargeRecordDao chargeRecordDao;
	@Resource
	private AgencyVODaoInterface agencyVODao;
	@Resource
	private SendCallBackUtil sendCallBack;
	@Resource
	private SystemConfAO systemConfAO;
	@Resource
	private ChargeAccountAo chargeAccountAO;
	@Resource
	private IAccountEventDao accountEventDao;
	
	@Resource
	private WXPayAO wXPayAO;
	
	@Transactional
	@Override
	public String updatePurchaseState(PurchasePo purchasePo1) {
		int ap = 0;
		int pur = 0;
		Long realBackTime = purchasePo1.getOrderBackTime();
		if(realBackTime == null){
			realBackTime = System.currentTimeMillis();
			purchasePo1.setOrderBackTime(System.currentTimeMillis());
		}
		Integer orderResult = purchasePo1.getOrderResult();
		Long orderId = purchasePo1.getOrderId();//参数订单号id
		PurchasePo purchasePo = purchaseDAO.getOnePurchase(orderId);
		orderId = purchasePo.getOrderId();
		purchasePo1.setOrderId(purchasePo.getOrderId()); //得到真正从下级代理商传过来的orderId
		String orderResultDetail = purchasePo1.getOrderResultDetail();
		
		//失败直接返款判定
		boolean unchargeNotSave = orderResult == OrderStateEnum.UNCHARGE.getValue();
		String res = "error";
		
		if(unchargeNotSave || WXPayConfig.ACCOUNTID.equals(purchasePo.getAccountId())){//接口失败，微信用户或者设置了保存订单，设置为充值等待
			SystemConfPo syspo = systemConfAO.getByKey("fail_back");
			boolean setWait = syspo != null && StringHelper.isNotEmpty(syspo.getConfValue()) && CallBackEnum.NEGATIVE.getValue().equals(Integer.parseInt(syspo.getConfValue()));
			if(setWait){//失败设置为充值等待
				//更新连接表//不是成功和失败，就是进行
				ap = accountPurchaseDao.batchUpdateState(orderId, OrderStateEnum.CHARGING.getValue(), OrderStateEnum.CHARGING.getDesc());
				orderResult = OrderStateEnum.CHARGING.getValue();
				purchasePo1.setHasCallBack(OrderResultEnum.SUCCESS.getCode());
				purchasePo1.setOrderResult(OrderStateEnum.DAICHONG.getValue());
//				purchasePo1.setOrderResultDetail("失败设为等待");
				//更新订单表
				pur = purchaseDAO.updatePurchaseState(purchasePo1);//等待，但是原因显示失败的原因
			}else if(purchasePo != null && purchasePo.getOrderResult() != null && orderResult !=  purchasePo.getOrderResult()){//清除已经返款的记录
				List<AccountPurchasePo> list = accountPurchaseDao.list(new WherePrams("purchase_id", "=", orderId));
//				Double agencyAfterBalance = 0.0d;
					int batchAddCrt = 0;
					if(list != null && list.size() > 0){
						List<ChargeRecordPo> recordPoList = new LinkedList<ChargeRecordPo>();
						List<AccountPurchasePo> apPoList = new LinkedList<AccountPurchasePo>();
						Long recordId = chargeRecordDao.nextId();		//没添加的消费记录Id
						
						for (AccountPurchasePo accountPurchasePo : list) {
//							Integer accountId = accountPurchasePo.getaccountId();
//							int billType = accountPurchasePo.getBillType();
//							ChargeAccountPo accountPo = chargeAccountDao.get(new WherePrams("account_id", "=", accountId).and("bill_type", "=", billType));
							Integer accountId = accountPurchasePo.getAccountId();
							if(accountId != null){
								//查看是否存在补款记录
								//一个代理商账号，一个订单号只能有一笔补款的消费记录
								ChargeRecordPo recordPo = chargeRecordDao.get(new WherePrams("account_type", "=", AccountTypeEnum.Replenishment.getValue()).and("account_id", "=", accountId).and("purchase_id", "=", orderId));
								ChargeRecordPo consumePo = chargeRecordDao.get(new WherePrams("account_type", "=", AccountTypeEnum.DECREASE.getValue()).and("account_id", "=", accountId).and("purchase_id", "=", orderId));
								//有过扣款记录,并且要补的金额和扣款金额一致，并且没有补款记录或者有补款记录但是补款和消费金额是一致的（方便处理并发带来的异常补款）
								Double orderAmount = accountPurchasePo.getOrderAmount();
								boolean needSet = consumePo != null && orderAmount.equals(consumePo.getRechargeAmount()) && (recordPo == null || (consumePo.getRechargeAmount().equals(recordPo.getRechargeAmount())));
								if(needSet){//没有补款记录就可以补款
									ChargeAccountPo accountPo = chargeAccountDao.get(accountId);
									Double accountBeforeBalance = accountPo.getAccountBalance();
//									Double accountAfterBalance = NumberTool.add(accountBeforeBalance,orderAmount);
//									accountPo.setAccountBalance(NumberTool.add(orderAmount, accountBeforeBalance));
//									accountPo.setAccountBalance(accountAfterBalance);
//									int accountUpRes = chargeAccountDao.updateLocal(accountPo, new WherePrams("id","=",accountId));
									int accountUpRes =  chargeAccountAO.updateAccount(accountId,orderAmount);
									if(accountUpRes > 0){
										ChargeAccountPo accountAfterPo = chargeAccountDao.get(accountId);
										//一个代理商账号，一个订单号只能有一笔补款的消费记录
										recordPoList.add(new ChargeRecordPo(realBackTime, orderAmount,
												accountBeforeBalance, accountAfterPo.getAccountBalance(), 
												AccountTypeEnum.Replenishment.getValue(), accountId,  1 , orderId));
										//根据已有的扣款记录去添加补款记录
										AccountPurchasePo apPo = accountPurchaseDao.getAPByAccountType(orderId, accountId, AccountTypeEnum.DECREASE.getValue());
										apPo.setRecordId(recordId);
										apPoList.add(apPo);
										recordId++ ;
									}
								}
//								AccountPurchasePo apPo = new AccountPurchasePo(accountId, orderId, rateDiscountId, orderAmount, fromAccountId, recordId, orderPrice, fromAgencyName, orderPlatformPath, orderState)
							}
						}
						batchAddCrt = chargeRecordDao.crt_addList(recordPoList);		//批量添加补款记录信息
						accountPurchaseDao.ap_addList(apPoList);		//
						//更新连接表
						ap = accountPurchaseDao.batchUpdateState(orderId, orderResult, orderResultDetail);
//						purchasePo1.setHasCallBack(OrderResultEnum.SUCCESS.getCode());
						//更新订单表(只更新超管的订单详情)
						pur = purchaseDAO.updatePurchaseState(purchasePo1);//orderId, realBackTime, orderResult, orderResultDetail, purchasePo1.getOrderIdApi()
					}
			}else{
//				System.out.println("订单不存在");
				res = "success";
			}
			
		}else{
			if(!orderResult.equals(OrderStateEnum.CHARGED.getValue())){
				//更新连接表//不是成功和失败，就是进行
				ap = accountPurchaseDao.batchUpdateState(orderId, OrderStateEnum.CHARGING.getValue(), OrderStateEnum.CHARGING.getDesc());
				orderResult = OrderStateEnum.CHARGING.getValue();
			}else{
				ap = accountPurchaseDao.batchUpdateState(orderId, orderResult, OrderStateEnum.CHARGED.getDesc());
			}
			purchasePo1.setHasCallBack(OrderResultEnum.SUCCESS.getCode());
			//更新订单表
			pur = purchaseDAO.updatePurchaseState(purchasePo1);
		}
		if(purchasePo != null){
			if(StringHelper.isNotEmpty(purchasePo.getAgencyCallIp())){
				sendCallBack.sendCallBack(new ResponseJsonDTO(orderId, purchasePo.getOrderIdFrom(), orderResult, "系统推送"+orderResultDetail, System.currentTimeMillis(),purchasePo.getChargeTel()), purchasePo.getAgencyCallIp());
			}else{
				AgencyBackwardPo agencyPo = agencyVODao.getAgencyByAccountId(purchasePo.getAccountId());
				if(agencyPo != null && StringHelper.isNotEmpty(agencyPo.getCallBackIp()) && !orderResult.equals(OrderStateEnum.CHARGING.getValue())){//不是充值进行，才返回调
					sendCallBack.sendCallBack(new ResponseJsonDTO(orderId, purchasePo.getOrderIdFrom(), orderResult, "系统推送"+orderResultDetail, System.currentTimeMillis(),purchasePo.getChargeTel()), agencyPo.getCallBackIp());
				}
			}
		}
		
		if(pur + ap > 1){
			res = "success";
		}
		return res;
	}

	@Transactional
	@Override
	public String updatePurchaseStateByMe(Long orderId, Integer orderResult,
			String orderResultDetail, Long realBackTime) {
		int ap = 0;
		int pur = 0;
		if(realBackTime == null){
			realBackTime = System.currentTimeMillis();
		}
		PurchasePo purchasePo = purchaseDAO.getOnePurchase(orderId);
		boolean isWechat = purchasePo.getAccountId().equals(WXPayConfig.ACCOUNTID);
		if(orderResult == OrderStateEnum.UNCHARGE.getValue()){//手动失败，要返款
			
			if(purchasePo != null && purchasePo.getOrderResult() != null && OrderStateEnum.UNCHARGE.getValue() !=  purchasePo.getOrderResult()){//清除已经返款的记录
				if(isWechat && pur > 0){//wechat账户的订单
					String refundRes = wXPayAO.refund(purchasePo);
					if("success".equals(refundRes)){
						orderResultDetail = "微信退款请求提交成功。";
					}else{
						//微信退款请求失败 需要再次手动失败，所以放在充值等待当中
						orderResult = OrderStateEnum.DAICHONG.getValue();
						orderResultDetail = "微信退款请求提交失败!";
					}
				}
				List<AccountPurchasePo> list = accountPurchaseDao.list(new WherePrams("purchase_id", "=", orderId));
//				Double agencyAfterBalance = 0.0d;
					int batchAddCrt = 0;
					if(list != null && list.size() > 0){
						if(OrderStateEnum.DAICHONG.getValue() != orderResult){//微信请求退款失败
							List<ChargeRecordPo> recordPoList = new LinkedList<ChargeRecordPo>();
							List<AccountPurchasePo> apList = new LinkedList<AccountPurchasePo>();
							long recordId = chargeRecordDao.nextId();
							for (AccountPurchasePo accountPurchasePo : list) {
//							Integer agencyId = agencyPurchasePo.getAgencyId();
//							int billType = agencyPurchasePo.getBillType();
//							ChargeAccountPo accountPo = chargeAccountDao.get(new WherePrams("agency_id", "=", agencyId).and("bill_type", "=", billType));
								Integer accountId = accountPurchasePo.getAccountId();
								
								if(accountId != null){
									//一个代理商账号，一个订单号只能有一笔补款的消费记录
//									ChargeRecordPo recordPo = chargeRecordDao.get(new WherePrams("account_type", "=", AccountTypeEnum.Replenishment.getValue()).and("account_id", "=", accountId).and("purchase_id", "=", orderId));
									//获得退费类型 
									ChargeRecordPo recordPo = chargeRecordDao.get(accountPurchasePo.getRecordId()) ;
									ChargeRecordPo consumePo = chargeRecordDao.get(new WherePrams("account_type", "=", AccountTypeEnum.DECREASE.getValue()).and("account_id", "=", accountId).and("purchase_id", "=", orderId));
									//有过扣款记录,并且要补的金额和扣款金额一致，并且没有补款记录或者有补款记录但是补款和消费金额是一致的（方便处理并发带来的异常补款）
									Double orderAmount = accountPurchasePo.getOrderAmount();
									boolean needSet = consumePo != null && orderAmount.equals(consumePo.getRechargeAmount()) && (recordPo == null || (consumePo.getRechargeAmount().equals(recordPo.getRechargeAmount())));
									if(needSet){
										ChargeAccountPo accountPo = chargeAccountDao.get(accountId);
//									Double orderAmount = accountPurchasePo.getOrderAmount();
										Double accountBeforeBalance = accountPo.getAccountBalance();
//										Double accountAfterBalance = NumberTool.add(accountBeforeBalance,orderAmount);
//										accountPo.setAccountBalance(NumberTool.add(orderAmount, accountBeforeBalance));
//										accountPo.setAccountBalance(accountAfterBalance);
//										int accountUpRes = chargeAccountDao.updateLocal(accountPo, new WherePrams("id","=",accountId));
										int accountUpRes = chargeAccountAO.updateAccount(accountId,orderAmount);
										if(accountUpRes > 0){
											ChargeAccountPo accountAfterPo = chargeAccountDao.get(accountId);
											recordPoList.add(new ChargeRecordPo(realBackTime, orderAmount,
													accountBeforeBalance, accountAfterPo.getAccountBalance(), 
													AccountTypeEnum.Replenishment.getValue(), accountId,  recordPo.getChargeFor() , orderId));
//										chargeAccountDao.updateLocal(accountPo, new WherePrams("id","=",accountId));
											//更新连接表
											ap = accountPurchaseDao.batchUpdateState(orderId, orderResult, orderResultDetail);
										}
//								Long appId = accountPurchaseDao.nextId();
										//同样的订单消费再添加一笔消费记录
										AccountPurchasePo appPo = accountPurchasePo.clone();
										appPo.setRecordId(recordId);
										appPo.setOrderState(orderResult);
										appPo.setOrderStateDetail(OrderStateEnum.getEnum(orderResult).getDesc());
										apList.add(appPo);
										recordId++;
									}
								}
							}
							batchAddCrt = chargeRecordDao.crt_addList(recordPoList);		//批量添加补款记录信息
							ap = accountPurchaseDao.ap_addList(apList);
						}
						//更新订单表(只更新超管的订单详情)
						pur = purchaseDAO.updatePurchaseState(new PurchasePo(orderId, null, realBackTime, orderResult, null, orderResultDetail));
						
					}
			}else{
				System.out.println("订单不存在");
				return "error";
			}
			
		}else{
			//更新连接表
			ap = accountPurchaseDao.batchUpdateState(orderId, orderResult, orderResultDetail);
			//更新订单表
			pur = purchaseDAO.updatePurchaseState(new PurchasePo(orderId, null, realBackTime, orderResult, null, orderResultDetail));
		}
		if(purchasePo != null && !isWechat){
			if(StringHelper.isNotEmpty(purchasePo.getAgencyCallIp())){
				sendCallBack.sendCallBack(new ResponseJsonDTO(orderId, purchasePo.getOrderIdFrom(), orderResult, "（手动推送）"+orderResultDetail, System.currentTimeMillis(),purchasePo.getChargeTel()), purchasePo.getAgencyCallIp());
			}else{
				AgencyBackwardPo agencyPo = agencyVODao.getAgencyByAccountId(purchasePo.getAccountId());
				if(agencyPo != null && StringHelper.isNotEmpty(agencyPo.getCallBackIp()) && !orderResult.equals(OrderStateEnum.CHARGING.getValue())){//不是充值进行，才返回调
					sendCallBack.sendCallBack(new ResponseJsonDTO(orderId, purchasePo.getOrderIdFrom(), orderResult, "（手动推送）"+orderResultDetail, System.currentTimeMillis(),purchasePo.getChargeTel()), agencyPo.getCallBackIp());
				}
			}
		}
		if(pur + ap > 1){
			return "success";
		}
		return "error";
	}

	@Override
	public String refund(Long orderId, Integer orderResult,
			String orderResultDetail, Long realBackTime) {
		//更新连接表
		int ap = accountPurchaseDao.batchUpdateState(orderId, orderResult, orderResultDetail);
		//更新订单表
		int pur = purchaseDAO.updatePurchaseState(new PurchasePo(orderId, null, realBackTime, orderResult, null, orderResultDetail));
		
//		 purchaseDAO.getOnePurchase(orderId);
		
		//添加最新登陆日志
//		accountEventDao.add(new AccountEventPo(resultPo.getId(), EventTypeEnum.SUCCESS_REFUND.getValue(), System.currentTimeMillis(), "南昌", "120.55.162.224", orderId.toString()));
		
		if(pur + ap > 1){
			return "success";
		}
		return "error_refund";
	}

//	@Override
//	public String batchUpdatePurchaseState(PurchaseVO purchaseVO) {
//		String res = "error";
//		
//		
//		return res;
//	}

//	@Override
//	public String updatePurchaseStateByApi(String orderIdApi, Long orderId,
//			Integer orderResult, String orderResultDetail, Long realBackTime) {
//		int ap = 0;
//		int pur = 0;
//		if(!orderResult.equals(OrderStateEnum.CHARGED.getValue())){
//			//更新连接表//不是成功和失败，就是进行
//			ap = accountPurchaseDao.batchUpdateState(orderId, orderResult, OrderStateEnum.CHARGING.getDesc());
//		}else{
//			ap = accountPurchaseDao.batchUpdateState(orderId, orderResult, OrderStateEnum.CHARGED.getDesc());
//		}
//		//更新订单表
//		pur = purchaseDAO.updatePurchaseState(new PurchasePo(orderId, null, realBackTime, orderResult, null, orderResultDetail));
//		if(pur > 0){
//			return "success";
//		}
//		return "error";
//	}

}
