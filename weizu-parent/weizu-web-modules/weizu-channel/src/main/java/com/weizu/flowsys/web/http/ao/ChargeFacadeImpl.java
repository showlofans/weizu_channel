package com.weizu.flowsys.web.http.ao;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.weizu.api.facet.charge.ChargeBase;
import org.weizu.api.facet.charge.ChargeFactory;
import org.weizu.api.facet.charge.ChargePageOrder;
import org.weizu.api.facet.charge.impl.ChargeParamsPage;
import org.weizu.api.facet.charge.impl.ChargeResultPage;
import org.weizu.api.facet.orderState.OrderStateBase;
import org.weizu.api.facet.orderState.OrderStateFactory;
import org.weizu.api.facet.orderState.impl.OrderStateParamsPage;
import org.weizu.api.facet.orderState.impl.OrderStateResultPage;
import org.weizu.api.outter.enums.ChargeStatusEnum;
import org.weizu.api.outter.facade.ChargeFacade;
import org.weizu.api.outter.pojo.charge.ChargeDTO;
import org.weizu.api.outter.pojo.charge.ChargeOrder;
import org.weizu.api.outter.pojo.charge.ChargeParams;

import com.weizu.flowsys.core.util.NumberTool;
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.OrderPathEnum;
import com.weizu.flowsys.operatorPg.enums.ScopeCityEnum;
import com.weizu.flowsys.util.OrderUril;
import com.weizu.flowsys.web.activity.dao.IOperatorDiscountDao;
import com.weizu.flowsys.web.activity.dao.impl.OperatorDiscountDaoImpl;
import com.weizu.flowsys.web.activity.pojo.OperatorDiscountPo;
import com.weizu.flowsys.web.activity.pojo.OperatorScopeVO;
import com.weizu.flowsys.web.agency.dao.impl.AgencyBackwardDao;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
import com.weizu.flowsys.web.channel.ao.ChannelForwardAO;
import com.weizu.flowsys.web.channel.ao.ProductCodeAO;
import com.weizu.flowsys.web.channel.dao.impl.ChannelForwardDao;
import com.weizu.flowsys.web.channel.dao.impl.ExchangePlatformDao;
import com.weizu.flowsys.web.channel.pojo.BestChannelPO;
import com.weizu.flowsys.web.channel.pojo.ChannelForwardPo;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.flowsys.web.channel.pojo.OneCodePo;
import com.weizu.flowsys.web.channel.pojo.OperatorPgDataPo;
import com.weizu.flowsys.web.channel.pojo.ProductCodePo;
import com.weizu.flowsys.web.trade.PurchaseUtil;
import com.weizu.flowsys.web.trade.dao.PurchaseDao;
import com.weizu.flowsys.web.trade.pojo.PurchasePo;

/**
 * @description: 充值对外接口实现类
 * @projectName:weizu-channel
 * @className:ChargeFacadeImpl.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月23日 下午4:41:42
 * @version 1.0
 */
@Service("chargeFacade")
public class ChargeFacadeImpl implements ChargeFacade {

	@Resource
	private ValiUser valiUser;
	@Resource
	private AgencyBackwardDao agencyBackwardDao;
	
	@Resource
	private IOperatorDiscountDao operatorDiscountDao;
	
	@Resource
	private ChannelForwardAO channelForwardAO;
	
	@Resource
	private ProductCodeAO productCodeAO;
	
	@Resource
	private ExchangePlatformDao exchangePlatformDao;
	@Resource
	private ChannelForwardDao channelForwardDao;
	@Resource
	private PurchaseDao purchaseDAO;
	
	/**
	 * @description: 充值接口
	 * @param chargeParams
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月23日 下午4:41:57
	 */
	@Transactional
	@Override
	public ChargeDTO charge(ChargeParams chargeParams) {
		ChargeDTO chargeDTO = null;
		AgencyBackwardPo backPo = valiUser.findAgency(chargeParams.getUsername(), chargeParams.getSign());
		
		Map<String, Object> resMap = PurchaseUtil.getOperatorsByTel(chargeParams.getNumber());
		
		OperatorPgDataPo pgData = null;
		int otype = -1;
		ChargeStatusEnum chargeEnum = null;
		try {
			int scope = Integer.parseInt(chargeParams.getScope());
			int pgSize = Integer.parseInt(chargeParams.getFlowsize());
			otype = Integer.parseInt(resMap.get("operatorType").toString());
			pgData = valiUser.findPg(scope, pgSize,otype);//
		} catch (NumberFormatException e) {
			e.printStackTrace();
			chargeEnum = ChargeStatusEnum.INT_REQUIRED;
			return new ChargeDTO(chargeEnum.getValue(),chargeEnum.getDesc(), null);
		} 
		//充值用户不合法
		if(backPo == null)
		{
			chargeEnum = ChargeStatusEnum.AUTHENTICATION_FAILURE;
			chargeDTO = new ChargeDTO(chargeEnum.getValue(),chargeEnum.getDesc(), null);
		}
		//充值流量包体不存在
		else if(pgData == null)
		{
			chargeEnum = ChargeStatusEnum.PG_NOT_FOUND;
			chargeDTO = new ChargeDTO(chargeEnum.getValue(),chargeEnum.getDesc(), null);
		}else
		{//充值并返回最新的订单（状态）
			PurchasePo purchasePo = new PurchasePo();
			
			purchasePo.setOrderArriveTime(System.currentTimeMillis());
			String scopeName = resMap.get("scopeName").toString();
			String chargeTelCity = resMap.get("chargeTelCity").toString();
			String chargeTelDetail = resMap.get("chargeTelDetail").toString();
			purchasePo.setChargeTel(chargeParams.getNumber());
			
			OperatorDiscountPo operatorDiscountPo = new OperatorDiscountPo();
			operatorDiscountPo.setScopeName(scopeName);
			Long rateId = backPo.getRateId();
			operatorDiscountPo.setRateId(rateId);
			OperatorDiscountPo discountPo = operatorDiscountDao.selectOneDiscountByPo(operatorDiscountPo);
			
			Double rateDisccount = discountPo.getDiscount();//费率折扣
			
			purchasePo.setChargeTelCity(chargeTelCity);
			purchasePo.setChargeTelDetail(chargeTelDetail);
			
			int pgId = pgData.getId();
			Double orderAmount = NumberTool.mul(pgData.getPgPrice(), rateDisccount);
			
			purchasePo.setPgId(pgId);
			purchasePo.setOrderAmount(orderAmount);
			
			/*******************最优通道*******************/
			String scopeCityCode = "";
			for (Map<String, Object> cityMap : ScopeCityEnum.toList()) {
				String cityName = cityMap.get("desc").toString();
				if(cityName.contains(scopeName))
				{
					scopeCityCode = cityMap.get("value").toString();
				}
			}
			BestChannelPO bestChannel = channelForwardAO.getBestChannel(new OperatorScopeVO(scopeName, backPo.getId(), otype));
			if(bestChannel  != null){
				
				ProductCodePo product =  productCodeAO.getOneProductCode(new OneCodePo(scopeCityCode, pgData.getPgSize(), pgData.getOperatorType(), pgData.getServiceType(),bestChannel.getEpd()));
				if(product != null){
					ExchangePlatformPo epPo = exchangePlatformDao.get(bestChannel.getEpd());
					ChargeBase chargeBase = ChargeFactory.getChargeBase(bestChannel.getEpName());
					//充值
					ChargeResultPage chargeResultPage = chargeBase.charge(new ChargeParamsPage(epPo.getEpPurchaseIp(), epPo.getEpName(), epPo.getEpUserName(), epPo.getEpApikey(), chargeParams.getNumber(), product.getProductCode()));
					ChargePageOrder chargePageOrder = chargeResultPage.getChargePageOrder();
					if(chargePageOrder != null)
					{
						/**订单信息添加*/
						OrderUril ou1 = new OrderUril(2);
						try {
							purchasePo.setOrderId(ou1.nextId());//设置订单号
						} catch (Exception e) {
							e.printStackTrace();
						}
						purchasePo.setOrderPlatformPath(OrderPathEnum.CHARGE_SOCKET.getValue());
						purchasePo.setAgencyId(backPo.getId());
						purchasePo.setRootAgencyId(backPo.getRootAgencyId());
						
						purchasePo.setOrderBackTime(chargePageOrder.getOrderBackTime());
						purchasePo.setOrderIdApi(chargePageOrder.getTransaction_id());
						//查看订单状态
						OrderStateBase orderStatePage = OrderStateFactory.getOrderStateBase(epPo.getEpName());
						OrderStateResultPage osrp = orderStatePage.getOrderState(new OrderStateParamsPage(epPo.getPgdataCheckIp(), chargePageOrder.getTransaction_id(), epPo.getEpName(), epPo.getEpUserName(), epPo.getEpApikey()));
						purchasePo.setOrderResult(osrp.getPageOrder().getStatus());
						purchasePo.setOrderResultDetail(osrp.getPageOrder().getMsg());
					}
				}
				int channelId = bestChannel.getChanneld();//
				Double channelDiscount = bestChannel.getChannelDiscount();
				Double channelAmount = NumberTool.mul(pgData.getPgPrice(), channelDiscount);//通道交易增加额
				purchasePo.setChannelId(channelId);
				ChannelForwardPo channelPo = channelForwardDao.get(channelId);
				channelPo.setId(channelId);
				channelPo.addTotalUse();
				channelPo.addTotalAmount(channelAmount);
				int channelRes = channelForwardDao.update(channelPo);
				//更新订单表
				int purResult = purchaseDAO.addPurchase(purchasePo);
				if(channelRes + purResult >= 2){
					ChargeOrder chargeOrder = new ChargeOrder(purchasePo.getOrderId()+"", purchasePo.getChargeTel(), pgData.getPgSize()+"");
					chargeEnum = ChargeStatusEnum.AUTHENTICATION_FAILURE;
					chargeDTO = new ChargeDTO(chargeEnum.getValue(),chargeEnum.getDesc(), chargeOrder);
				}
			}
		}
		return chargeDTO;
	}

}
