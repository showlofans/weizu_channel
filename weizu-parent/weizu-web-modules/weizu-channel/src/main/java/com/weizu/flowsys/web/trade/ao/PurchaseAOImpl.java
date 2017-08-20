package com.weizu.flowsys.web.trade.ao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.weizu.api.outter.enums.ChargeStatusEnum;

import com.aiyi.base.pojo.PageParam;
import com.alibaba.fastjson.JSON;
import com.weizu.flowsys.api.base.ChargeDTO;
import com.weizu.flowsys.api.base.facet.IChargeFacet;
import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.core.util.NumberTool;
import com.weizu.flowsys.operatorPg.enums.AccountTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelStateEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelUseStateEnum;
import com.weizu.flowsys.operatorPg.enums.OrderPathEnum;
import com.weizu.flowsys.operatorPg.enums.OrderResultEnum;
import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
import com.weizu.flowsys.util.OrderUril;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.util.StringUtil2;
import com.weizu.flowsys.web.activity.dao.RateDiscountDao;
import com.weizu.flowsys.web.activity.pojo.RateDiscountPo;
import com.weizu.flowsys.web.agency.ao.AgencyAO;
import com.weizu.flowsys.web.agency.ao.ChargeAccountAo;
import com.weizu.flowsys.web.agency.dao.AgencyVODaoInterface;
import com.weizu.flowsys.web.agency.dao.impl.AgencyBackwardDao;
import com.weizu.flowsys.web.agency.dao.impl.ChargeAccountDao;
import com.weizu.flowsys.web.agency.dao.impl.ChargeRecordDao;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.agency.pojo.ChargeRecordPo;
import com.weizu.flowsys.web.channel.ao.ExchangePlatformAO;
import com.weizu.flowsys.web.channel.ao.OperatorPgAO;
import com.weizu.flowsys.web.channel.ao.ProductCodeAO;
import com.weizu.flowsys.web.channel.dao.ChannelChannelDao;
import com.weizu.flowsys.web.channel.pojo.ChannelChannelPo;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.flowsys.web.channel.pojo.OneCodePo;
import com.weizu.flowsys.web.channel.pojo.ProductCodePo;
import com.weizu.flowsys.web.http.ParamsEntityWeiZu;
import com.weizu.flowsys.web.http.weizu.OrderStateResult;
import com.weizu.flowsys.web.trade.PurchaseUtil;
import com.weizu.flowsys.web.trade.dao.AgencyPurchaseDao;
import com.weizu.flowsys.web.trade.dao.PurchaseDao;
import com.weizu.flowsys.web.trade.pojo.AgencyPurchasePo;
import com.weizu.flowsys.web.trade.pojo.PgChargeVO;
import com.weizu.flowsys.web.trade.pojo.PurchasePo;
import com.weizu.flowsys.web.trade.pojo.PurchaseVO;
import com.weizu.web.foundation.DateUtil;
import com.weizu.web.foundation.String.StringHelper;
import com.weizu.web.foundation.http.HttpRequest;

@Service(value="purchaseAO")
public class PurchaseAOImpl implements PurchaseAO {

	@Resource
	private PurchaseDao purchaseDAO;
	@Resource
	private ChargeAccountDao chargeAccountDao;
	@Resource
	private ChargeRecordDao chargeRecordDao;
	@Resource
	private ChargeAccountAo chargeAccountAO;
//	@Resource
//	private ChannelForwardAO channelForwardAO;
//	@Resource
//	private ChannelForwardDaoInterface channelForwardDao;
	@Resource
	private ChannelChannelDao channelChannelDao; 
	@Resource
	private ExchangePlatformAO exchangePlatformAO;
	@Resource
	private OperatorPgAO operatorPgAO;
	@Resource
	private ProductCodeAO productCodeAO;
//	@Resource
//	private RateDiscountAO rateDiscountAO;
	@Resource
	private RateDiscountDao rateDiscountDao; 
//	@Resource
//	private AgencyBackwardDao agencyBackwardDao;
//	@Resource
//	private AgencyAO agencyAO;
	@Resource
	private AgencyVODaoInterface agencyVODao;
	
	@Resource
	private AgencyPurchaseDao agencyPurchaseDao;
	
	private Logger logger = Logger.getLogger("PurchaseAOImpl");
//	@Resource
//	private ChargeFacade chargeFacade;
	
	/**
	 * @description: 根据页面订单参数初始化订单实体
	 * @param pcVO
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年8月4日 下午3:16:02
	 */
	private PurchasePo initPurchase(PgChargeVO pcVO) {
		return new PurchasePo(pcVO.getChargeTel(), pcVO.getPgId(), pcVO.getChargeTelDetail());
	}
	
	/**
	 * @description: 页面上充值
	 * @param purchasePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月12日 下午5:35:16
	 */
	@Transactional
	@Override
	public String purchase(PgChargeVO pcVO, Integer ap_agency_id) {
		/****************完成对所有上级代理商包括自己的订单与代理商的绑定********************/
		//已经当前登陆用户余额充足，开始充值流程
		//在订单信息完全添加完之后，再调用接口进行充值
		//先添加一个基本的，再批量添加父级代理商和订单的绑定
		PurchasePo purchasePo = initPurchase(pcVO);
		int agencyId = pcVO.getAgencyId();		//订单产生方代理商
		int orderResult = OrderStateEnum.CHARGING.getValue();		//默认订单状态
		int purResult = 0;
//		RateDiscountPo ratePo = rateDiscountAO.getRateForCharge(pcVO.getServiceType(), pcVO.getChargeTelDetail(), agencyId);
		RateDiscountPo ratePo = rateDiscountDao.get(pcVO.getRateId());
		int chargeRes = -1;			//充值状态
		if(ratePo != null){
			int billType = ratePo.getBillType();//票务全部使用费率配置的票务
			//更新消费记录表（先更新账户余额，再更新订单，最后更新记录）
			ChargeAccountPo accountPo = chargeAccountAO.getAccountByAgencyId(agencyId, billType);
			/**充值前余额*/
			double agencyBeforeBalance = 0d;
			/**充值额（）*/
			Double orderAmount = null;
			
			/**包体原价*/
			Double pgPrice = pcVO.getPgPrice();
			
			/**账户信息的更新结果*/
			int recordRes = 0;
			
			ChannelChannelPo channel = channelChannelDao.get(new WherePrams("id", "=", ratePo.getChannelId()));
			boolean isChannelUseStateStoped = channel.getChannelUseState() == ChannelUseStateEnum.CLOSE.getValue();//通道状态停止
			if(isChannelUseStateStoped){//通道使用状态暂停，不能提单
				return "产品待更新，产品暂不支持购买！！";
			}
			boolean isSecondAgency = agencyVODao.getSecondAgency(agencyId) == null ;
			//在二级代理商的情况下才去判断余额
			boolean ifLackBalance = isSecondAgency && pcVO.getOrderAmount() > accountPo.getAccountBalance();
			
			if(ifLackBalance){//订单价格大于余额
				return "余额不足，下单失败";
//				resultMap.put("referURL", "/flowsys/chargePg/purchase_list.do?orderResult=2");
			}else{
				/**充值前余额*/
				agencyBeforeBalance = accountPo.getAccountBalance();
				/**充值额（）*/
				orderAmount = NumberTool.mul(ratePo.getActiveDiscount(), pgPrice);
				accountPo.addBalance(orderAmount,-1);
				/** 更新登录用户账户信息**/
				recordRes = chargeAccountAO.updateAccount(accountPo);
				if(recordRes > 0){
					Long rateDiscountId = ratePo.getId();			//折扣id
					try {
						OrderUril ou1 = new OrderUril(1);
						Long orderId = ou1.nextId();
						purchasePo.setOrderId(orderId);//设置订单号
						purchasePo.setAgencyId(pcVO.getAgencyId());
						Long currentTime = System.currentTimeMillis();
						purchasePo.setOrderArriveTime(currentTime);
						purchasePo.setOrderResult(orderResult);
						purchasePo.setChannelId(ratePo.getChannelId());
	//					Map<String, Object> telMap = PurchaseUtil.getOperatorsByTel(purchasePo.getChargeTel());
	//					 String chargeTelCity = null;
	//					 if(telMap != null)
	//					{
	//						chargeTelCity = telMap.get("chargeTelCity").toString();
	//					}
	//					purchasePo.setChargeTelCity(chargeTelCity);
						purResult = purchaseDAO.addPurchase(purchasePo);
						
						if(purResult > 0){//开始把第一个消费记录，连接加上，
							/** 向消费记录表插入登陆用户数据 */
							Long nextIdRecord = chargeRecordDao.nextId();
							chargeRecordDao.add(new ChargeRecordPo(currentTime, orderAmount,
									agencyBeforeBalance, accountPo.getAccountBalance(), 
									billType,AccountTypeEnum.DECREASE.getValue(), accountPo.getId(), agencyId, 1 , orderId));
							/**再向下游返回回调，并更新数据库中订单表中返回时间和返回结果*/
							int orderPath = OrderPathEnum.WEB_PAGE.getValue();
							AgencyPurchasePo app = new AgencyPurchasePo(ap_agency_id, orderId, rateDiscountId, orderAmount, billType, orderAmount, pcVO.getFromAgencyName(), orderPath, orderResult);
							int aapAddRes = agencyPurchaseDao.add(app);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else{
					logger.config("更新账户表失败");
				}
				// 开始迭代添加父级代理商的账户扣款和消费记录，以及批量添加父级代理商和订单的绑定
				if(purResult > 0){//订单添加好了,开始迭代添加父级代理商的账户扣款和消费记录
					chargeRes = OrderResultEnum.SUCCESS.getCode();		//在全部上级都添加完了之后返回成功;
					List<AgencyPurchasePo> apPoList = new LinkedList<AgencyPurchasePo>();
					List<ChargeRecordPo> recordPoList = new LinkedList<ChargeRecordPo>();
					
					RateDiscountPo activeRatePo = null;		//父级费率对象
					RateDiscountPo ratePo1 = ratePo;		//子级费率对象
					
					AgencyBackwardPo rootAgencyPo = null;	//父级代理商实体
					AgencyBackwardPo agencyPo = null;	//子级代理商实体
					int contextAgencyId = agencyId ;		//子级代理商id
					
					//得到当前代理商和折扣的绑定实体，
					//然后根据父级得到父级折扣
					int whileStop = 0;
					Long orderId = purchasePo.getOrderId();
					Double balance = 0d;//差额:父费率减去子费率乘以价格
					while(ratePo1.getActiveId() != null){//没有找到第二级代理商，开始添加代理商和订单
						
						//重置ratePo为父级费率折扣;不为空
						//查询父级操作对象
						activeRatePo = rateDiscountDao.get(ratePo1.getActiveId());		
						rootAgencyPo = agencyVODao.getRootAgencyById(agencyId);
						agencyPo = agencyVODao.get(agencyId);
						String fromAgencyName = agencyPo.getUserName();
						accountPo  = chargeAccountDao.selectByAgencyId(rootAgencyPo.getId(), activeRatePo.getBillType());//重置为父级代理商的账户（无论是对公和对私都是有的）
						/**业务判断和添加**/
						/**充值额（）*/
//						orderAmount = NumberTool.mul(ratePo.getActiveDiscount(), pgPrice);
//						if(orderAmount > accountPo.getAccountBalance()){
//							orderResult = OrderStateEnum.DAICHONG.getValue();	//欠费等待
//							whileStop = 1;
//						}else{
//							orderResult = OrderStateEnum.CHARGING.getValue();		//充值进行
//						}
//						Long rateDiscountId = ratePo.getId();			//折扣id
						
//						if(whileStop == 1){//可以向上提单，但是不扣上面的款
//							int orderPath = OrderPathEnum.CHILD_WEB_PAGE.getValue();
////						AgencyPurchasePo app = new AgencyPurchasePo(agencyId, purchasePo.getOrderId(), null, null, billType, null, orderResult,ChargeStatusEnum.LACK_OF_BALANCE.getDesc(),orderPath);
////						apPoList.add(app);
//							break;
//						}else{
							/**充值前余额*/
							agencyBeforeBalance = accountPo.getAccountBalance();
							/**父费率减去子费率乘以价格，就是差价*/
							balance = NumberTool.mul(NumberTool.sub(activeRatePo.getActiveDiscount(), ratePo1.getActiveDiscount()), pgPrice);
							accountPo.addBalance(balance,1);
							/** 更新登录用户账户信息**/
							recordRes = chargeAccountAO.updateAccount(accountPo);
							if(recordRes > 0){
								/** 向消费记录表插入登陆用户数据 */
								Long nextIdRecord = chargeRecordDao.nextId();
								Long currentTime = System.currentTimeMillis();
								Double plusAmount = NumberTool.mul(ratePo1.getActiveDiscount(),pgPrice);
								Double minusAmount = NumberTool.mul(activeRatePo.getActiveDiscount(),pgPrice);
								agencyAfterBalance = NumberTool.add(agencyBeforeBalance,plusAmount);
								
								recordPoList.add(new ChargeRecordPo(System.currentTimeMillis(), plusAmount,
										agencyBeforeBalance, agencyAfterBalance, 
 										ratePo1.getBillType(),AccountTypeEnum.Replenishment.getValue(), accountPo.getId(), agencyId,1, orderId));
								agencyBeforeBalance += plusAmount;	//重置充值前的余额为补款后的余额
								agencyAfterBalance = NumberTool.sub(agencyBeforeBalance,minusAmount);
								recordPoList.add(new ChargeRecordPo(System.currentTimeMillis(), minusAmount,
										agencyBeforeBalance, agencyAfterBalance, 
 										activeRatePo.getBillType(),AccountTypeEnum.DECREASE.getValue(), accountPo.getId(), agencyId,1, orderId));	
								
// 								//chargeRecordDao.add(new ChargeRecordPo(System.currentTimeMillis(), orderAmount,
// 										agencyBeforeBalance, accountPo.getAccountBalance(), 
// 										billType,AccountTypeEnum.DECREASE.getValue(), accountPo.getId(), agencyId,1, purchasePo.getOrderId()));
								int orderPath = OrderPathEnum.CHILD_WEB_PAGE.getValue();
								AgencyPurchasePo app = new AgencyPurchasePo(ap_agency_id, orderId, activeRatePo.getId(), plusAmount, activeRatePo.getBillType(), minusAmount, fromAgencyName, orderPath, orderResult);
								apPoList.add(app);
							}
//						}
						//最后再循环一次，保证欠费等待的单子父级代理商能够看到，但是不能扣父级代理商的款和消费记录
//					if(whileStop > 0){//欠费等待
//						whileStop++ ;
//					}
							//由父变成子，进行迭代
							ratePo1 = activeRatePo;	
							agencyId = rootAgencyPo.getId();
					}
					if(apPoList.size() > 0){
						int batchAddApp = agencyPurchaseDao.ap_addList(apPoList);		//批量添加连接信息
						int batchAddCrt = chargeRecordDao.crt_addList(recordPoList);		//批量添加扣款记录信息
						//
						ChannelChannelPo channelPo = channelChannelDao.get(purchasePo.getChannelId());
						if(channelPo != null){
							ExchangePlatformPo epPo = exchangePlatformAO.getEpById(channelPo.getEpId());
							Map<String,Object> scopeMap = PurchaseUtil.getScopeCityByCarrier(purchasePo.getChargeTelDetail());
							String scopeCityCode = scopeMap.get("scopeCityCode").toString();
							ProductCodePo dataPo = productCodeAO.getOneProductCode(new OneCodePo(scopeCityCode,channelPo.getEpId(), purchasePo.getPgId()));
							if(dataPo == null){
								logger.config("编码未配置");
							}else if(batchAddApp > 0 && epPo != null){//开始走接口
								try {
//								 String epEngId = StringUtil2.toUpperClass(epPo.getEpEngId());
//								 String classRealPath = "com.weizu.flowsys.api.weizu."+epPo.getEpEngId()+"Charge";	//包完整路径
//								Class onwClass = Class.forName(classRealPath);
//								Constructor constructor = onwClass.getConstructor(String.class,String.class,String.class,String.class);
//								IChargeFacet chargeFacet = (IChargeFacet)constructor.newInstance(epPo.getEpPurchaseIp(),epPo.getEpApikey(),epPo.getEpUserName(),dataPo.getProductCode());
//								ChargeDTO chargeDTO = chargeFacet.charge();
									ChargeDTO chargeDTO = chargeByFacet(epPo,dataPo);
									System.out.println(chargeDTO.getOrderIdApi());//测试打印出对应平台的提单地址
									
									//判断是否正常提单,
									
									//充值之后更新订单的orderIdApi
//								purchasePo.setOrderIdApi(chargeDTO.getOrderIdApi());
//								int updatePur = purchaseDAO.updateLocal(purchasePo, new WherePrams("order_id", "=", purchasePo.getOrderId()));
//								if()
									
								} catch (ClassNotFoundException e) {
									e.printStackTrace();
								} catch (InstantiationException e) {
									e.printStackTrace();
								} catch (IllegalAccessException e) {
									e.printStackTrace();
								} catch (NoSuchMethodException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (SecurityException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IllegalArgumentException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (InvocationTargetException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							
						}
//					purchasePo.get
//					if(batchAddApp > 0 && dataPo.getProductCode()  != null){//订单信息完成之后，马上利用接口把订单通过通道传到上游
//						ChannelChannelPo channelPo = channelChannelDao.get(ratePo.getChannelId());
//						ExchangePlatformPo epPo = exchangePlatformAO.getEpById(channelPo.getEpId());
//						if(epPo != null){
//							ChargeBase chargeBase = ChargeFactory.getChargeBase(epPo.getEpName());
//							//
//							ChargeResultPage chargeResultPage = chargeBase.charge(new ChargeParamsPage(epPo.getEpPurchaseIp(), epPo.getEpName(), epPo.getEpUserName(), epPo.getEpApikey(), purchasePo.getChargeTel(), dataPo.getProductCode()));
//							
//							//初始化订单结果
//							ChargePageOrder chargePageOrder = chargeResultPage.getChargePageOrder();
//							if(chargePageOrder != null)
//							{
//								PurchasePo ppo = new PurchasePo();
////							ppo.setOrderId(purchasePo.getOrderId());
//								ppo.setOrderBackTime(chargePageOrder.getOrderBackTime());//订单充值返回时间
//								ppo.setOrderIdApi(chargePageOrder.getTransaction_id());	//接口订单号
//								ppo.setOrderResultDetail(chargeResultPage.tipMsg); 		//结果描述
//								purchaseDAO.updateLocal(ppo, new WherePrams("order_id", "=", purchasePo.getOrderId()));
//							}
//						}
//					}
					}
				}else{//第一批代理商和订单没有添加成功
					chargeRes = OrderStateEnum.UNCHARGE.getValue();
				}
			}
		}
		
		return null;
		
		
		
		
		/****************修改登陆用户的对私账户********************/
		
		
//		channelPo.setChannelTotalUse();
//		channelPo.addTotalUse();
//		channelPo.addTotalAmount(orderAmount);
//		int channelRes = channelForwardDao.update(channelPo);
		
		
//		/**订单信息添加*/
//		OrderUril ou1 = new OrderUril(1);
//		try {
//			purchasePo.setOrderId(ou1.nextId());//设置订单号
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		purchasePo.setOrderPlatformPath(OrderPathEnum.WEB_PAGE.getValue());
//		if(recordRes + channelRes -1 >0 && productCode  != null){
//			
//			ChargeBase chargeBase = ChargeFactory.getChargeBase(epPo.getEpName());
//			//
//			ChargeResultPage chargeResultPage = chargeBase.charge(new ChargeParamsPage(epPo.getEpPurchaseIp(), epPo.getEpName(), epPo.getEpUserName(), epPo.getEpApikey(), purchasePo.getChargeTel(), productCode));
//			
//			//初始化订单结果
//			ChargePageOrder chargePageOrder = chargeResultPage.getChargePageOrder();
//			if(chargePageOrder != null)
//			{
//				purchasePo.setOrderBackTime(chargePageOrder.getOrderBackTime());
//				purchasePo.setOrderIdApi(chargePageOrder.getTransaction_id());
//				//查看订单状态
//				OrderStateBase orderStatePage = OrderStateFactory.getOrderStateBase(epPo.getEpName());
//				OrderStateResultPage osrp = orderStatePage.getOrderState(new OrderStateParamsPage(epPo.getPgdataCheckIp(), chargePageOrder.getTransaction_id(), epPo.getEpName(), epPo.getEpUserName(), epPo.getEpApikey()));
//				purchasePo.setOrderResult(osrp.getPageOrder().getStatus());
//				purchasePo.setOrderResultDetail(osrp.getPageOrder().getMsg());
//				if(osrp == null){
////					Log
//					System.out.println("没有添加该公司代码");
//				}
//				System.out.println(osrp.getPageOrder().getCreated_at());
//				System.out.println(osrp.getPageOrder().getCharge_fee());
//				System.out.println(osrp.getPageOrder().getStatus());
//				//将订单状态写入充值状态中
////				chargePageOrder.getTransaction_id()
//			}
//			
////			OrderStateResult osr =  purchaseByWeizuAPI(new ParamsEntityWeiZu(epPo.getEpUserName(), purchasePo.getChargeTel(), product.getProductCode(), epPo.getEpApikey()));
//			
//			
//			purchasePo.setRootAgencyId(accountPo.getAgencyId());//设为当前登陆账户的订单
//			 Map<String, Object> telMap = PurchaseUtil.getOperatorsByTel(purchasePo.getChargeTel());
//			 String chargeTelCity = null;
//			 if(telMap != null)
//			{
//				chargeTelCity = telMap.get("chargeTelCity").toString();
//			}
//			purchasePo.setChargeTelCity(chargeTelCity);
//			purchasePo.setRecordId(nextIdRecord);
//			//更新订单表
//			int purResult = purchaseDAO.addPurchase(purchasePo);
////			purchasePo
//			
//			/**再向下游返回回调，并更新数据库中订单表中返回时间和返回结果*/
//			if(purResult > 0){
//				return OrderResultEnum.SUCCESS.getCode();
//			}else{
//				return OrderResultEnum.ERROR.getCode();
//			}
//		}else{
//			return OrderResultEnum.ERROR.getCode();
//		}
		
//		if(purResult + recordRes + channelRes - 2 > 0){
//			return OrderResultEnum.SUCCESS.getCode();
//		}else{
//			return OrderResultEnum.ERROR.getCode();
//		}
		
		
	}
	/**
	 * @description: 接口充值
	 * @param epPo
	 * @param dataPo
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月17日 下午5:36:19
	 */
	public ChargeDTO chargeByFacet(ExchangePlatformPo epPo,ProductCodePo dataPo) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		 String classRealPath = "com.weizu.flowsys.api.weizu."+epPo.getEpEngId()+"Charge";	//包完整路径
			Class onwClass = Class.forName(classRealPath);
			Constructor constructor = onwClass.getConstructor(String.class,String.class,String.class,String.class);
			IChargeFacet chargeFacet = (IChargeFacet)constructor.newInstance(epPo.getEpPurchaseIp(),epPo.getEpApikey(),epPo.getEpUserName(),dataPo.getProductCode());
			return chargeFacet.charge();
	}

	/**
	 * @description: 封装查询参数
	 * @param purchaseVO
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月13日 下午12:53:34
	 */
	@Override
	public Map<String, Object> getMapByPojo(PurchaseVO purchaseVO,Boolean isCharged) {
		//充值成功列表使用充值时间查询
		if(purchaseVO != null){
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			if(StringHelper.isNotEmpty(purchaseVO.getChargeTel())){
				paramsMap.put("chargeTel", purchaseVO.getChargeTel());
			}
			if(purchaseVO.getRootAgencyId() != null){
				paramsMap.put("agencyId", purchaseVO.getRootAgencyId());
			}
			if(purchaseVO.getBillType() != null){
				paramsMap.put("billType", purchaseVO.getBillType());
			}
			if(StringHelper.isNotEmpty(purchaseVO.getAgencyName())){
				paramsMap.put("agencyName", purchaseVO.getAgencyName());
			}
			if(purchaseVO.getOrderId() != null){
				paramsMap.put("orderId", purchaseVO.getOrderId());
			}
			if(purchaseVO.getOrderResult() != null){
				paramsMap.put("orderResult", purchaseVO.getOrderResult());
			}
			if(StringHelper.isNotEmpty(purchaseVO.getChargeTelDetail())){
				paramsMap.put("chargeTelDetail", purchaseVO.getChargeTelDetail());
			}
			if(purchaseVO.getOperatorType() != null){
				paramsMap.put("operatorType", purchaseVO.getOperatorType());
			}
			
			
			Long startTime = null;
			Long endTime = null;
			Long dateUtilStartTime = DateUtil.getStartTime().getTime();
			Long dateUtilEndTime = DateUtil.getEndTime().getTime();
			if(isCharged){//充值成功列表使用充值时间查询
				if(StringHelper.isEmpty(purchaseVO.getBackStartTimeStr())){//默认打开列表
					paramsMap.put("startTimeBack", dateUtilStartTime);
				}else{
					startTime = DateUtil.strToDate(purchaseVO.getBackStartTimeStr(), null).getTime();
					paramsMap.put("startTimeBack", startTime);
				}
				if(StringHelper.isEmpty(purchaseVO.getBackEndTimeStr())){//默认打开列表
					paramsMap.put("endTimeBack", dateUtilEndTime);
				}else{
					endTime = DateUtil.strToDate(purchaseVO.getBackEndTimeStr(), null).getTime();
					paramsMap.put("endTimeBack", endTime);
				}
			}else{//其他状态使用订单到达时间
				if(StringHelper.isEmpty(purchaseVO.getArriveStartTimeStr())){//默认打开列表
					paramsMap.put("startTime", dateUtilStartTime);
				}else{
					startTime = DateUtil.strToDate(purchaseVO.getArriveStartTimeStr(), null).getTime();
					paramsMap.put("startTime", startTime);
				}
				if(StringHelper.isEmpty(purchaseVO.getArriveEndTimeStr())){//默认打开列表
					paramsMap.put("endTime", dateUtilEndTime);
				}else{
					endTime = DateUtil.strToDate(purchaseVO.getArriveEndTimeStr(), null).getTime();
					paramsMap.put("endTime", endTime);
				}
			}
//			paramsMap.put("isCharged", isCharged);
			return paramsMap;
		}
		return null;
	}

	/**
	 * @description: 查询订单列表
	 * @param purchaseVO
	 * @param pageParam
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月13日 下午12:53:21
	 */
	@Override
	public Pagination<PurchaseVO> getPurchase(Map<String, Object> resultMap,PurchaseVO purchaseVO,
			PageParam pageParam) {
		Boolean isCharged = purchaseVO.getOrderResult() != null && purchaseVO.getOrderResult() == OrderStateEnum.CHARGED.getValue();
		Map<String, Object> paramsMap = getMapByPojo(purchaseVO,isCharged);
		int totalRecord = purchaseDAO.countPurchase(paramsMap);//今天的订单数量
		//设置总记录数和页面参数和查询参数
		totalRecord = resetTotalRecord(purchaseVO,paramsMap,isCharged,totalRecord);
		
		int pageSize = pageParam.getPageSize();
		int pageNo = pageParam.getPageNo();
		paramsMap.put("start", (pageNo-1) * pageSize);
		paramsMap.put("end", pageSize);
		
		List<PurchaseVO> records = purchaseDAO.getPurchase(paramsMap);
		//遍历每一个订单，查看它的订单状态
		for (PurchaseVO purchaseVO2 : records) {//格式化展示时间
//					ExchangePlatformPo purchaseEp = purchaseVO2.getEp();
//					
//					OrderStateBase orderStatePage = OrderStateFactory.getOrderStateBase(purchaseEp.getEpName());
//					
//					OrderStateResultPage osrp = orderStatePage.getOrderState(new OrderStateParamsPage(purchaseEp.getPgdataCheckIp(), purchaseVO2.getOrderIdApi(), purchaseEp.getEpName(), purchaseEp.getEpUserName(), purchaseEp.getEpApikey()));
//					//更新加载的订单状态信息
//					//判断是否与数据库中的数据相等,如果不相等，就更新页面和数据库信息
//					PageOrder pageOrder = osrp.getPageOrder();
//					//如果失败，把等待状态转换成未充状态
//					pageOrder.setStatus(ChargeFacadeImpl.getStatusByStatus(pageOrder.getStatus())); 
//					
//					//更新查看订单状态
//					checkOrderState(pageOrder, purchaseVO2);
			if(purchaseVO2.getOrderBackTime() != null)
			{
				purchaseVO2.setOrderBackTimeStr(DateUtil.formatAll(purchaseVO2.getOrderBackTime()));
			}
			if(purchaseVO2.getOrderArriveTime() != null){
				purchaseVO2.setOrderArriveTimeStr(DateUtil.formatAll(purchaseVO2.getOrderArriveTime()));
			}
		}
		resultMap.put("searchParams", purchaseVO);	//查询参数放入返回参数
		return new Pagination<PurchaseVO>(records, totalRecord, pageNo, pageSize);
	}

	
	/** 设置总记录数和页面参数和查询参数
	 * @param purchaseVO
	 * @param paramsMap
	 * @param isCharged
	 * @param totalRecord
	 * @return
	 */
	private int resetTotalRecord(PurchaseVO purchaseVO,
			Map<String, Object> paramsMap, Boolean isCharged, int totalRecord) {
		//在没有记录的情况下重置查询条件和查询参数
		if(totalRecord == 0){
			Long currentTime = System.currentTimeMillis();
			if(isCharged){
				if(StringHelper.isEmpty(purchaseVO.getBackStartTimeStr())){
					paramsMap.put("startTimeBack",null);
				}
				if(StringHelper.isEmpty(purchaseVO.getBackEndTimeStr())){
					purchaseVO.setBackEndTimeStr(DateUtil.formatAll(currentTime));
					paramsMap.put("endTimeBack", currentTime);
				}
			}else{//其他列表
				if(StringHelper.isEmpty(purchaseVO.getArriveStartTimeStr())){
					paramsMap.put("startTime",null);
				}
				if(StringHelper.isEmpty(purchaseVO.getArriveEndTimeStr())){
					paramsMap.put("endTime", currentTime);
					purchaseVO.setArriveEndTimeStr(DateUtil.formatAll(currentTime));
				}
			}
			totalRecord = purchaseDAO.countPurchase(paramsMap);//重置订单数量
		}else{//有记录条件下，设置页面参数
			Long dateUtilStartTime = null;
			Long dateUtilEndTime = null;
			if(isCharged){
				if(purchaseVO.getBackStartTimeStr() == null){
					dateUtilStartTime = Long.parseLong(paramsMap.get("startTimeBack").toString());
					purchaseVO.setBackStartTimeStr(DateUtil.formatAll(dateUtilStartTime));
				}else if("".equals(purchaseVO.getBackStartTimeStr().trim())){
					//为空或者值重新设置	
					paramsMap.put("startTimeBack", null);
					totalRecord = purchaseDAO.countPurchase(paramsMap);
				}
				if(StringHelper.isEmpty(purchaseVO.getBackEndTimeStr())){
					dateUtilEndTime = Long.parseLong(paramsMap.get("endTimeBack").toString());
					purchaseVO.setBackEndTimeStr(DateUtil.formatAll(dateUtilEndTime));
				}
			}else{
				if(purchaseVO.getArriveStartTimeStr() == null){
					dateUtilStartTime = Long.parseLong(paramsMap.get("startTime").toString());
					purchaseVO.setArriveStartTimeStr(DateUtil.formatAll(dateUtilStartTime));
				}else{
					//为空或者值重新设置
					if("".equals(purchaseVO.getArriveStartTimeStr().trim())){
						paramsMap.put("startTime", null);
						totalRecord = purchaseDAO.countPurchase(paramsMap);
					}
				}
				if(StringHelper.isEmpty(purchaseVO.getArriveEndTimeStr())){
					dateUtilEndTime = Long.parseLong(paramsMap.get("endTime").toString());
					purchaseVO.setArriveEndTimeStr(DateUtil.formatAll(dateUtilEndTime));
				}
			}
		}
		return totalRecord;
	}

	/** 初始化页面查询参数
	 * @param purchaseVO 初始化对象
	 * @param paramsMap 初始化数据源
	 */
//	private void initVO(PurchaseVO purchaseVO, Map<String, Object> paramsMap) {
//		Boolean isChargedList =  purchaseVO.getOrderResult() != null && purchaseVO.getOrderResult() == OrderStateEnum.CHARGED.getValue();
//		Long dateUtilStartTime = null;
//		Long dateUtilEndTime = null;
//		if(isChargedList){
//			if(StringHelper.isEmpty(purchaseVO.getBackStartTimeStr())){
//				dateUtilStartTime = Long.parseLong(paramsMap.get("startTimeBack").toString());
//				purchaseVO.setBackStartTimeStr(DateUtil.formatAll(dateUtilStartTime));
//			}
//			if(StringHelper.isEmpty(purchaseVO.getBackEndTimeStr())){
//				dateUtilEndTime = Long.parseLong(paramsMap.get("endTimeBack").toString());
//				purchaseVO.setBackEndTimeStr(DateUtil.formatAll(dateUtilEndTime));
//			}
//		}else{
//			if(StringHelper.isEmpty(purchaseVO.getArriveStartTimeStr())){
//				dateUtilStartTime = Long.parseLong(paramsMap.get("startTime").toString());
//				purchaseVO.setArriveStartTimeStr(DateUtil.formatAll(dateUtilStartTime));
//			}
//			if(StringHelper.isEmpty(purchaseVO.getArriveEndTimeStr())){
//				dateUtilEndTime = Long.parseLong(paramsMap.get("endTime").toString());
//				purchaseVO.setArriveEndTimeStr(DateUtil.formatAll(dateUtilStartTime));
//			}
//		}
//	}

	/**
	 * @description: 通过微族api充值
	 * @param paramsEntity
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月17日 上午11:23:33
	 */
	@Override
	public OrderStateResult purchaseByWeizuAPI(ParamsEntityWeiZu paramsEntity) {
		String resMsg = HttpRequest.sendGet("http://139.224.70.161:32001/api/v1/sendOrder", paramsEntity.toString());
		OrderStateResult osr = JSON.parseObject(resMsg, OrderStateResult.class);
		
		return osr;
	}
	/**
	 * @description:   更新查看订单状态
	 * @param pageOrder
	 * @param purchaseVO
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月26日 下午12:57:18
	 */
//	@Override
//	public int checkOrderState(PageOrder pageOrder, PurchaseVO purchaseVO) {
//		int updateRes = 0;
//		if(purchaseVO.getOrderResult() != pageOrder.getStatus())
//		{
//			purchaseVO.setOrderResult(pageOrder.getStatus());
//			//如果过
//			if(StringHelper.isEmpty(pageOrder.getMsg())){
//				for (OrderStateEnum enumt : OrderStateEnum.values()) {
//					if(pageOrder.getStatus() == enumt.getValue())
//					{
//						purchaseVO.setOrderResultDetail(enumt.getDesc());
//						break;
//					}
//				}
//			}else{
//				purchaseVO.setOrderResultDetail(pageOrder.getMsg());
//			}
//			String created_at_api = pageOrder.getCreated_at();
//			purchaseVO.setOrderBackTimeStr(created_at_api);
//			updateRes = purchaseDAO.updatePurchaseState(new PurchaseStateParams(purchaseVO.getOrderId(), DateUtil.strToDate(created_at_api, "").getTime() , purchaseVO.getOrderResult(), purchaseVO.getOrderResultDetail(),pageOrder.getTransaction_id()));
//		}
//		return updateRes;
//	}

	/**
	 * @description: 通过订单Id查询订单
	 * @param orderId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月26日 下午1:05:03
	 */
	@Override
	public PurchasePo getOnePurchase(long orderId) {
		return purchaseDAO.getOnePurchase(orderId);
	}

	

}
