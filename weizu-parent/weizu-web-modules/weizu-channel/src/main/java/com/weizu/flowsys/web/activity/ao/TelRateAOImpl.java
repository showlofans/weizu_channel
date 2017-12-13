package com.weizu.flowsys.web.activity.ao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weizu.flowsys.operatorPg.enums.AgencyTagEnum;
import com.weizu.flowsys.operatorPg.enums.HuaServiceTypeEnum;
import com.weizu.flowsys.operatorPg.enums.PgServiceTypeEnum;
import com.weizu.flowsys.web.activity.dao.ITelRateDao;
import com.weizu.flowsys.web.channel.dao.ITelChannelDao;
import com.weizu.flowsys.web.channel.pojo.TelChannelParams;
import com.weizu.flowsys.web.channel.pojo.TelProductPo;
import com.weizu.flowsys.web.trade.pojo.GetTelRatePo;
import com.weizu.web.foundation.String.StringHelper;

/**
 * @description: 话费折扣业务层实现
 * @projectName:weizu-channel
 * @className:TelRateAOImpl.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年12月2日 上午9:36:47
 * @version 1.0
 */
@Service(value="telRateAO")
public class TelRateAOImpl implements TelRateAO {

	@Resource
	private ITelRateDao telRateDao;
	
	@Resource
	private ITelChannelDao telChannelDao;
	@Override
	public void getRateForCharge(Map<String,Object> resultMap, TelChannelParams telChannelParams, Integer agencyId) {
		Map<String,Object> params = getParamsByTelChannel(telChannelParams);
		int rateFor = telChannelParams.getRateFor();
//		if(AgencyTagEnum.PLATFORM_USER.getValue().equals(telChannelParams.getRateFor())){
//			params.put("platformUser", AgencyTagEnum.PLATFORM_USER.getValue());
//		}else if(AgencyTagEnum.DATA_USER.getValue().equals(telChannelParams.getRateFor())){
//			params.put("dataUser", AgencyTagEnum.DATA_USER.getValue());//添加接口绑定的时候设置
//		}
//		Integer platUser = AgencyTagEnum.PLATFORM_USER.getValue();
		
		boolean isPlatUser = AgencyTagEnum.PLATFORM_USER.getValue().equals(telChannelParams.getRateFor());
		AgencyTagEnum[] agencyEs = AgencyTagEnum.values();
		
		
		long totalRecord = 0;
		boolean ifData = false;
		for (int i = 0; i < agencyEs.length; i++) {
			if(isPlatUser){
				rateFor = AgencyTagEnum.PLATFORM_USER.getValue();
				params.put("platformUser", AgencyTagEnum.PLATFORM_USER.getValue());
				params.put("dataUser", null);
			}else{
				rateFor = AgencyTagEnum.DATA_USER.getValue();
				params.put("dataUser", AgencyTagEnum.DATA_USER.getValue());
				params.put("platformUser", null);
			}
			totalRecord = telChannelDao.countMyTelChannel(params);
			if(totalRecord != 0){
				if(AgencyTagEnum.DATA_USER.getValue().equals(rateFor)){
					ifData = true;
				}
				if(isPlatUser){
					Map<String,Object> cloneMap = getParamsByTelChannel(telChannelParams);
					cloneMap.put("dataUser", AgencyTagEnum.DATA_USER.getValue());
					cloneMap.put("platformUser", null);
					long ifDataRes = telChannelDao.countMyTelChannel(cloneMap);
					if(ifDataRes > 0){
						ifData = true;
					}
				}
				break;
			}else{
				isPlatUser = !isPlatUser;
			}
		}
		if(totalRecord > 0){
			params.put("agencyId", agencyId);
			List<GetTelRatePo> telRateList = telRateDao.getTelRateForCharge(params);
			resultMap.put("getRateList", telRateList);
			if(ifData){
				resultMap.put("dataUser", "yes");
			}
		}else{
			resultMap.put("msg", "没有该话费折扣");
		}
//		return telRateList;
	}
	private Map<String,Object> getParamsByTelChannel(TelChannelParams telParams){
		Map<String,Object> params = new HashMap<String,Object>();
		Integer serviceType = telParams.getServiceType();
		if(serviceType != null){
			params.put("serviceType", serviceType);

			boolean cityProIn = StringHelper.isNotEmpty(telParams.getProvinceid()); //加入省市参数必须的条件
			boolean cityIn = serviceType.equals(HuaServiceTypeEnum.CITY.getValue()) && StringHelper.isNotEmpty(telParams.getCityid());//加入市的条件
			boolean provinceIn = serviceType.equals(HuaServiceTypeEnum.PROVINCE.getValue()) || cityIn ;//加入省份参数条件
			
			if(provinceIn && cityProIn){
				params.put("provinceid", telParams.getProvinceid());
			}
			if(cityIn && cityProIn){
				params.put("cityid", telParams.getCityid());
			}
		}
		
		if(StringHelper.isNotEmpty(telParams.getEpName())){
			params.put("epName", telParams.getEpName());
		}
//		if(StringHelper.isNotEmpty(telParams.getCityid())){
//			params.put("cityid", telParams.getCityid());
//		}
//		if(StringHelper.isNotEmpty(telParams.getProvinceid())){
//			params.put("provinceid", telParams.getProvinceid());
//		}
		
//		if(telParams.getTelchannelUseState() != null){
//			params.put("telchannelUseState", telParams.getTelchannelUseState());
//		}
//		if(telParams.getTelchannelState() != null){
//			params.put("telchannelState", telParams.getTelchannelState());
//		}
//		if(telParams.getBillType() != null){
//			params.put("billType", telParams.getBillType());
//		}
		if(telParams.getChargeSpeed() != null){
			params.put("chargeSpeed", telParams.getChargeSpeed());
		}
//		if(telParams.getServiceType() != null){
//			params.put("serviceType", telParams.getServiceType());
//		}
		if(telParams.getOperatorName() != null){
			params.put("operatorName", telParams.getOperatorName());
		}
//		if(telParams.getChargeValue() != null){
//			params.put("chargeValue", telParams.getChargeValue());
//		}
		return params;
	}

	
//	private Map<String, Object> getMapByTPP(TelProductPo telPo) {
//		Map<String,Object> params = new HashMap<String,Object>();
//		Integer serviceType = telPo.getServiceType();
//		if(serviceType != null){
//			params.put("serviceType", serviceType);
//
//			boolean cityProIn = StringHelper.isNotEmpty(telPo.getProvinceid()); //加入省市参数必须的条件
//			boolean cityIn = serviceType.equals(HuaServiceTypeEnum.CITY.getValue()) && StringHelper.isNotEmpty(telPo.getCityid());//加入市的条件
//			boolean provinceIn = serviceType.equals(HuaServiceTypeEnum.PROVINCE.getValue()) || cityIn ;//加入省份参数条件
//			
//			if(provinceIn && cityProIn){
//				params.put("provinceid", telPo.getProvinceid());
//			}
//			if(cityIn && cityProIn){
//				params.put("cityid", telPo.getCityid());
//			}
//		}
//		
//		if(telPo.getChargeSpeed() != null){
//			params.put("chargeSpeed", telPo.getChargeSpeed());
//		}
//		if(telPo.getOperatorName() != null){//todo
//			params.put("operatorName", telPo.getOperatorName());
//		}
//		if(telPo.getChargeValue() != null){
//			params.put("chargeValue", telPo.getChargeValue());
//		}
//		
//		return params;
//	}

}
