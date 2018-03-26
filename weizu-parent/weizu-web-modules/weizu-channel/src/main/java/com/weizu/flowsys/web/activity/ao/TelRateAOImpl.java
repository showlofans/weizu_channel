package com.weizu.flowsys.web.activity.ao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weizu.flowsys.operatorPg.enums.AgencyTagEnum;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.CallBackEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelStateEnum;
import com.weizu.flowsys.operatorPg.enums.TelServiceTypeEnum;
import com.weizu.flowsys.operatorPg.enums.TelChannelTagEnum;
import com.weizu.flowsys.web.activity.dao.ITelRateDao;
import com.weizu.flowsys.web.activity.pojo.TelRatePo;
import com.weizu.flowsys.web.channel.ao.TelChannelAO;
import com.weizu.flowsys.web.channel.dao.ITelChannelDao;
import com.weizu.flowsys.web.channel.pojo.TelChannelParams;
import com.weizu.flowsys.web.channel.pojo.TelChannelPo;
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
	@Resource
	private TelChannelAO telChannelAO;
	@Override
	public void getRateForCharge(Map<String,Object> resultMap, TelChannelParams telChannelParams, Integer agencyId, Integer rootAgencyId) {
		Map<String,Object> params = getParamsByTelChannel(telChannelParams);
//		int rateFor = telChannelParams.getRateFor();
//		if(AgencyTagEnum.PLATFORM_USER.getValue().equals(telChannelParams.getRateFor())){
//			params.put("platformUser", AgencyTagEnum.PLATFORM_USER.getValue());
//		}else if(AgencyTagEnum.DATA_USER.getValue().equals(telChannelParams.getRateFor())){
//			params.put("dataUser", AgencyTagEnum.DATA_USER.getValue());//添加接口绑定的时候设置
//		}
//		Integer platUser = AgencyTagEnum.PLATFORM_USER.getValue();
		
//		boolean isPlatUser = AgencyTagEnum.PLATFORM_USER.getValue().equals(telChannelParams.getRateFor());
//		AgencyTagEnum[] agencyEs = AgencyTagEnum.values();
		
		
//		if(rootAgencyId != null && rootAgencyId != 0){//不是超管
//			params.put("rateForPlatform", CallBackEnum.POSITIVE.getValue());
//		}
//		rateFor = AgencyTagEnum.PLATFORM_USER.getValue();
		
//		for (int i = 0; i < agencyEs.length; i++) {
//			if(isPlatUser){
//				rateFor = AgencyTagEnum.PLATFORM_USER.getValue();
//				params.put("platformUser", AgencyTagEnum.PLATFORM_USER.getValue());
//				params.put("dataUser", null);
//			}else{
//				rateFor = AgencyTagEnum.DATA_USER.getValue();
//				params.put("dataUser", AgencyTagEnum.DATA_USER.getValue());
//				params.put("platformUser", null);
//			}
//			totalRecord = telChannelDao.countMyTelChannel(params);
//			if(totalRecord != 0){
//				if(AgencyTagEnum.DATA_USER.getValue().equals(rateFor)){
//					ifData = true;
//				}
//				if(ifData){
//					Map<String,Object> cloneMap = getParamsByTelChannel(telChannelParams);
//					cloneMap.put("dataUser", AgencyTagEnum.DATA_USER.getValue());
//					cloneMap.put("platformUser", null);
//					long ifDataRes = telChannelDao.countMyTelChannel(cloneMap);
//					if(ifDataRes > 0){
//						ifData = true;
//					}
//				}
//				break;
//			}else{
//				isPlatUser = !isPlatUser;
//			}
//		}
		if(rootAgencyId == 0){//超管，获取通道折扣
			params.put("telchannelState", ChannelStateEnum.OPEN.getValue());
			List<GetTelRatePo> telRateList = telChannelDao.getTelChannelForCharge(params);
			if(telRateList != null && telRateList.size() > 0){
				resultMap.put("getRateList", telRateList);
			}else{
				resultMap.put("msg", "没有该话费折扣");
			}
		}else{
			long totalRecord = 0;
//			boolean ifData = false;
			params.put("agencyId", agencyId);
			params.put("rootAgencyId", rootAgencyId);
			params.put("platformUser", AgencyTagEnum.PLATFORM_USER.getValue());
			params.put("dataUser", null);
			totalRecord = telRateDao.countTelRateForCharge(params);
			if(totalRecord > 0){
				List<GetTelRatePo> telRateList = telRateDao.getTelRateForCharge(params);
				resultMap.put("getRateList", telRateList);
//			if(ifData){
//				resultMap.put("dataUser", "yes");
//			}
			}else{
				resultMap.put("msg", "没有该话费折扣");
			}
		}
		
//		return telRateList;
	}
	private Map<String,Object> getParamsByTelChannel(TelChannelParams telParams){
		Map<String,Object> params = new HashMap<String,Object>();
		Integer serviceType = telParams.getServiceType();
		if(serviceType != null){
			params.put("serviceType", serviceType);

			boolean cityProIn = StringHelper.isNotEmpty(telParams.getProvinceid()); //加入省市参数必须的条件
			boolean cityIn = serviceType.equals(TelServiceTypeEnum.CITY.getValue()) && StringHelper.isNotEmpty(telParams.getCityid());//加入市的条件
			boolean provinceIn = serviceType.equals(TelServiceTypeEnum.PROVINCE.getValue()) || cityIn ;//加入省份参数条件
			
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
	@Transactional
	@Override
	public String delTelRateById(Long telRateId, Boolean isSupperAgency, Integer agencyId) {
		String resStr = "error";
		TelRatePo telRatePo = telRateDao.get(telRateId);
		if(telRatePo == null || telRateId == null){
			return resStr;
		}
		
		//判断是否需要编辑通道的状态
		TelRatePo telRatePoTag = null;
		Map<String,Object> paramsMap = new HashMap<String, Object>();
		Integer billTypeTag = null;
		paramsMap.put("createAgency", agencyId);
		paramsMap.put("rateFor", AgencyTagEnum.PLATFORM_USER.getValue());
		if(isSupperAgency){
			TelChannelPo telChannelPo = telChannelDao.get(telRatePo.getTelchannelId());
			billTypeTag =  telChannelPo.getBillType();
			//超管：一条通道只能配置一个平台折扣
			paramsMap.put("noParent", "noParent");
			paramsMap.put("telchannelId", telRatePo.getTelchannelId());
		}else{
			paramsMap.put("activeId", telRatePo.getActiveId());
		}
		if(BillTypeEnum.BUSINESS_INDIVIDUAL.getValue().equals(billTypeTag)){
			paramsMap.put("billType", BillTypeEnum.CORPORATE_BUSINESS.getValue());
		}else{
			paramsMap.put("billType", BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
		}
		telRatePoTag = telRateDao.getTelRateByParams(paramsMap);
		int rateFor = telRatePo.getRateFor();
		
		//如果删除的折扣是平台级折扣，修改话费通道为未配置平台折扣
		if(TelChannelTagEnum.PLATFORM_USER.getValue().equals(rateFor) && telRatePoTag == null){
			if(isSupperAgency){
				String result = telChannelAO.editTelChannel(new TelChannelPo(telRatePo.getTelchannelId(), CallBackEnum.NEGATIVE.getValue()), 0);
				if(!"success".equals(result)){
					return resStr;
				}
			}else{
				//添加平台级折扣要更新上一级折扣的平台标识
				TelRatePo activeRatePo = telRateDao.get(telRatePo.getActiveId());
				activeRatePo.setRateForPlatform(CallBackEnum.POSITIVE.getValue());
				telRateDao.updateLocal(activeRatePo);
			}
		}
		
//		if(TelChannelTagEnum.PLATFORM_USER.getValue().equals(rateFor)){//平台级折扣，直接按照通道来删除
//			telRateDao.del(new WherePrams("telchannel_id", "=", telRatePo.getTelchannelId()).and("rate_for", "=", rateFor));//删除所有通道绑定的折扣
//		}else{//数据级折扣，则级联删除
//		}
		//统一用级联删除
		long res = telRateDao.delByIteratorFun(telRateId);
//		int res = telRateDao.del(telRateId);
			
		if(res > 0){
			resStr = "success";
		}
		return resStr;
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
