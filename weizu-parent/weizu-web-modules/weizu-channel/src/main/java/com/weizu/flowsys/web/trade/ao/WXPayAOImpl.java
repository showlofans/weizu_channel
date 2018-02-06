package com.weizu.flowsys.web.trade.ao;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weizu.flowsys.api.weizu.charge.ChargeDTO;
import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.core.util.NumberTool;
import com.weizu.flowsys.operatorPg.enums.AccountTypeEnum;
import com.weizu.flowsys.operatorPg.enums.EpEncodeTypeEnum;
import com.weizu.flowsys.operatorPg.enums.OrderPathEnum;
import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
import com.weizu.flowsys.operatorPg.enums.ScopeCityEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.util.OrderUril;
import com.weizu.flowsys.web.activity.ao.RateDiscountAO;
import com.weizu.flowsys.web.activity.dao.RateDiscountDao;
import com.weizu.flowsys.web.activity.pojo.RateDiscountPo;
import com.weizu.flowsys.web.agency.ao.ChargeAccountAo;
import com.weizu.flowsys.web.agency.dao.ChargeRecordDaoInterface;
import com.weizu.flowsys.web.agency.dao.impl.ChargeAccountDao;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.agency.pojo.ChargeRecordPo;
import com.weizu.flowsys.web.channel.ao.ExchangePlatformAO;
import com.weizu.flowsys.web.channel.ao.ProductCodeAO;
import com.weizu.flowsys.web.channel.dao.ChannelChannelDao;
import com.weizu.flowsys.web.channel.dao.ChannelDiscountDao;
import com.weizu.flowsys.web.channel.dao.ExchangePlatformDaoInterface;
import com.weizu.flowsys.web.channel.dao.OperatorPgDaoInterface;
import com.weizu.flowsys.web.channel.pojo.ChannelChannelPo;
import com.weizu.flowsys.web.channel.pojo.ChannelDiscountPo;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.flowsys.web.channel.pojo.OneCodePo;
import com.weizu.flowsys.web.channel.pojo.ProductCodePo;
import com.weizu.flowsys.web.trade.PurchaseUtil;
import com.weizu.flowsys.web.trade.WXPayUtil;
import com.weizu.flowsys.web.trade.constant.WXPayConfig;
import com.weizu.flowsys.web.trade.dao.AccountPurchaseDao;
import com.weizu.flowsys.web.trade.dao.ChargeLogDao;
import com.weizu.flowsys.web.trade.dao.PurchaseDao;
import com.weizu.flowsys.web.trade.pojo.AccountPurchasePo;
import com.weizu.flowsys.web.trade.pojo.PgChargeVO;
import com.weizu.flowsys.web.trade.pojo.PurchasePo;
import com.weizu.web.foundation.http.HttpRequest;

/**
 * @description: 微信支付业务
 * @projectName:weizu-channel
 * @className:WXPayAOImpl.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年2月1日 上午10:31:15
 * @version 1.0
 */
@Service(value="wXPayAO")
public class WXPayAOImpl implements WXPayAO {

	@Resource
	private ChargeAccountAo chargeAccountAo;
	@Resource
	private PurchaseDao purchaseDAO;
	@Resource
	private ChargeAccountDao chargeAccountDao;
	@Resource
	private ChargeRecordDaoInterface chargeRecordDao;
	@Resource
	private ExchangePlatformAO exchangePlatformAO;
	@Resource
	private ExchangePlatformDaoInterface exchangePlatformDao;
	@Resource
	private RateDiscountAO rateDiscountAO;
	@Resource
	private RateDiscountDao rateDiscountDao; 
	
	@Resource
	private ChannelDiscountDao channelDiscountDao;
	@Resource
	private ChannelChannelDao channelChannelDao; 
//	@Resource
//	private OperatorPgDaoInterface operatorPgDao;
	@Resource
	private ProductCodeAO productCodeAO;
	
	@Resource
	private AccountPurchaseDao accountPurchaseDao;
	@Resource
	private AccountPurchaseAO accountPurchaseAO;
	@Resource
	private ChargeLogDao chargeLogDao;
	
	private Logger logger = Logger.getLogger("PurchaseAOImpl");
	
	@Transactional
	@Override
	public Long purchase(PgChargeVO pgChargeVO, String openid) {
		Integer accountId = pgChargeVO.getAccountId();
		ChargeAccountPo accountPo = chargeAccountAo.getAccountById(accountId);
//		pgChargeVO.setFromAgencyName(accountPo.getAgencyName());
		RateDiscountPo ratePo = rateDiscountDao.get(pgChargeVO.getRateId());
		if(ratePo != null){
			long channelId = ratePo.getChannelId();
			PurchasePo purchasePo = new PurchasePo(pgChargeVO.getChargeTel(), pgChargeVO.getPgId().toString(), pgChargeVO.getChargeTelDetail());
			purchasePo.setPurchaseFor(pgChargeVO.getChargeFor());
			purchasePo.setAccountId(accountId);
			purchasePo.setOrderIdFrom(openid);//将来源id设置为openid
			String orderResultDetail = "等待支付";
			
			/**包体原价*/
			Double chargeValue = pgChargeVO.getChargeValue();
			ChannelChannelPo channel = channelChannelDao.get(new WherePrams("id", "=", channelId));
			ExchangePlatformPo epPo = null;
			ProductCodePo dataPo = null;
			if(channel != null){
				purchasePo.setChannelName(channel.getChannelName());
				epPo = exchangePlatformAO.getEpById(channel.getEpId());
				purchasePo.setEpId(epPo.getId());
					if(EpEncodeTypeEnum.WITH_CODE.getValue().equals(epPo.getEpEncodeType())){
						String scopeCityCode = ScopeCityEnum.QG.getValue();
						if(!pgChargeVO.getServiceType().equals(ServiceTypeEnum.NATION_WIDE.getValue())){
							Map<String,Object> scopeMap = PurchaseUtil.getScopeCityByCarrier(purchasePo.getChargeTelDetail());
							if(scopeMap != null){
								scopeCityCode = scopeMap.get("scopeCityCode").toString();
							}else{
								System.out.println("获得地区编码失败");
							}
						}
//						String scopeCityCode = StringHelper.isNotEmpty(chargeTelDetail)?PurchaseUtil.getScopeCityByCarrier(chargeTelDetail).get("scopeCityCode").toString():null;
						dataPo = productCodeAO.getOneProductCode(new OneCodePo(scopeCityCode, epPo.getId(), Integer.parseInt(purchasePo.getPgId())));
					}else{
						dataPo = productCodeAO.getOneProductCodeByPg(Integer.parseInt(purchasePo.getPgId()));
					}
//					dataPo = productCodeAO.getOneProductCode(new OneCodePo(scopeCityCode,channel.getEpId(), Integer.parseInt(purchasePo.getPgId())));
					if(dataPo == null){
						System.out.println("编码未配置");
						return null;
					}
//				}
			}else{
				System.out.println("通道不存在");
				return null;
			}
			Long orderId = null;
			Long currentTime = System.currentTimeMillis();
			try {
				OrderUril ou1 = new OrderUril(1);
				orderId = ou1.nextId();
				purchasePo.setOrderId(orderId);//设置订单号
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			purchasePo.setChargeValue(chargeValue);
			purchasePo.setOrderAmount(pgChargeVO.getOrderAmount());
			purchasePo.setOrderArriveTime(currentTime);
			
			Map<String, Object> telMap = PurchaseUtil.getOperatorsByTel(purchasePo.getChargeTel());
			String chargeTelCity = null;
			if(telMap != null)
			{
				chargeTelCity = telMap.get("chargeTelCity").toString();
				purchasePo.setChargeTelCity(chargeTelCity);
			}else{
				logger.config("调用接口异常，设置城市异常");
				System.out.println("调用接口异常，设置城市异常");
				return null;
			}
			purchasePo.setOrderResult(OrderStateEnum.DAICHONG.getValue());//不在等待中，无法手动失败，成功）
			purchasePo.setOrderResultDetail(orderResultDetail);
			
			int purResult = purchaseDAO.addPurchase(purchasePo);
			int billType = ratePo.getBillType();//票务全部使用费率配置的票务
			//更新消费记录表（先更新账户余额，再更新订单，最后更新记录）
			/**账户信息的更新结果*/
			int recordRes = 0;
			/**充值前余额*/
			Double agencyBeforeBalance = accountPo.getAccountBalance();
			/**充值额（）*/
			Double orderAmount = NumberTool.mul(ratePo.getActiveDiscount(), chargeValue);
			accountPo.addBalance(orderAmount,-1);
			/** 更新登录用户账户信息**/
			recordRes = chargeAccountAo.updateAccount(accountPo);
			Integer orderState = OrderStateEnum.CHARGING.getValue();
			if(recordRes > 0){
				Long channelDiscountId = ratePo.getChannelDiscountId();			//折扣id
				if(recordRes > 0){//开始把第一个消费记录，连接加上，
					/** 向消费记录表插入登陆用户数据 */
					chargeRecordDao.add(new ChargeRecordPo(currentTime, orderAmount,
							agencyBeforeBalance, accountPo.getAccountBalance(), 
							AccountTypeEnum.DECREASE.getValue(), accountId,  pgChargeVO.getChargeFor() , orderId));
					/**再向下游返回回调，并更新数据库中订单表中返回时间和返回结果*/
					int orderPath = OrderPathEnum.WEB_PAGE.getValue();
					Long recordId = chargeRecordDao.nextId() -1;
					
					AccountPurchasePo app = new AccountPurchasePo(accountId, orderId, channelDiscountId, orderAmount, accountId, recordId, orderAmount, accountPo.getAgencyName(), orderPath, orderState);
					app.setOrderStateDetail("等待支付");
					app.setApDiscount(ratePo.getActiveDiscount());
					int aapAddRes = accountPurchaseDao.add(app);
					if(aapAddRes == 0){
						return null;
					}
				}
			}else{
				logger.config("更新账户表失败");
			}
			ChargeAccountPo superAccountPo = chargeAccountDao.getRootAccountById(accountId, billType);
			String fromAgencyName = accountPo.getAgencyName();
			ChannelDiscountPo cdisPo = channelDiscountDao.get(ratePo.getChannelDiscountId());
			billType = cdisPo.getBillType();
			agencyBeforeBalance = superAccountPo.getAccountBalance();
			Double orderPrice = NumberTool.mul(chargeValue, ratePo.getActiveDiscount());//价格
			orderAmount = NumberTool.mul(chargeValue, cdisPo.getChannelDiscount());//成本
			agencyBeforeBalance = NumberTool.add(agencyBeforeBalance, orderPrice);//之前加上价格
			Double agencyAfterBalance = NumberTool.sub(agencyBeforeBalance, orderAmount);
			superAccountPo.setAccountBalance(agencyAfterBalance);
			chargeAccountAo.updateAccount(superAccountPo);
			chargeRecordDao.add(new ChargeRecordPo(System.currentTimeMillis(), orderAmount,
					agencyBeforeBalance, agencyAfterBalance, 
					AccountTypeEnum.DECREASE.getValue(), superAccountPo.getId(),  pgChargeVO.getChargeFor() , orderId));
			Long recordId = chargeRecordDao.nextId() -1;
			
			/**再向下游返回回调，并更新数据库中订单表中返回时间和返回结果*/
			int orderPath = OrderPathEnum.CHILD_WEB_PAGE.getValue();
			//ChannelDiscountPo cdPo = channelDiscountDao.get(ratePo.getChannelDiscountId());
			AccountPurchasePo app = new AccountPurchasePo(superAccountPo.getId(), orderId, cdisPo.getId(), orderAmount,accountId,recordId, orderPrice, fromAgencyName, orderPath, orderState);
			app.setOrderStateDetail("等待支付");
			app.setApDiscount(cdisPo.getChannelDiscount());
			int supperAPPAdd = accountPurchaseDao.add(app);
			if(supperAPPAdd > 0 && purResult > 0){
				return orderId;
			}
		}
		return null;
	}

	@Override
	public String refund(PurchasePo purchasePo) {
		Map<String,Object> reqMap = new TreeMap<String,Object>();
		reqMap.put("appid", WXPayConfig.APPID);
		 reqMap.put("mch_id", WXPayConfig.MCH_ID);
		 reqMap.put("nonce_str", WXPayUtil.getNonce_str());
		 reqMap.put("out_trade_no", purchasePo.getOrderId());
		 reqMap.put("out_refund_no", purchasePo.getOrderId());
		 Integer totalFee = (int) NumberTool.mul(100, purchasePo.getOrderAmount());
		 reqMap.put("total_fee", totalFee); //订单总金额，单位为分
		 reqMap.put("refund_fee", totalFee); //订单总金额，单位为分
		 reqMap.put("refund_desc", purchasePo.getOrderResultDetail()); //订单总金额，单位为分
		 String result = "error";
		 try {
			String reqStr = WXPayUtil.map2Xml(reqMap);
			 System.out.println("微信请求参数："+ reqStr);
			  String resultXml = HttpRequest.sendPost(WXPayConfig.REFUND_URL, reqStr);
			  
			  Map<String,Object> map = WXPayUtil.readStringXmlOut(resultXml);
			  System.out.println("微信请求返回:" + resultXml);
			  String returnCode = WXPayUtil.getReturnCode(resultXml);
			  if(map != null){
				  if("SUCCESS".equals(returnCode)){
					  String resultCode = map.get("result_code").toString();
					  if("SUCCESS".equals(resultCode)){//提交请求成功
						  result = "success";
					  }else{
						  System.out.println(map.get("err_code").toString() + "<----->" + map.get("err_code_des").toString());
					  }
					  System.out.println("退款平台订单号:"+ map.get("out_trade_no").toString());
					  System.out.println("sign签名:"+ map.get("sign").toString());
					  System.out.println("退款单号:"+ map.get("refund_id").toString());
					  System.out.println("退款金额:"+ map.get("refund_fee").toString());
				  }else{
					  System.out.println(returnCode + ":"+map.get("return_msg").toString());
				  }
			  }
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
		 return result;
	}
	
}
