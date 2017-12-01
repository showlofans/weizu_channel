package com.weizu.flowsys.web.activity.ao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weizu.flowsys.operatorPg.enums.HuaServiceTypeEnum;
import com.weizu.flowsys.web.activity.dao.ITelRateDao;
import com.weizu.flowsys.web.channel.pojo.TelProductPo;
import com.weizu.flowsys.web.trade.pojo.GetTelRatePo;
import com.weizu.web.foundation.String.StringHelper;

@Service(value="telRateAO")
public class TelRateAOImpl implements TelRateAO {

	@Resource
	private ITelRateDao telRateDao;
	
	
	@Override
	public List<GetTelRatePo> getRateForCharge(TelProductPo telProductPo) {
		Map<String,Object> map = getMapByTPP(telProductPo);
		List<GetTelRatePo> telRateList = telRateDao.getTelRateForCharge(map);
		return telRateList;
	}


	private Map<String, Object> getMapByTPP(TelProductPo telPo) {
		Map<String,Object> params = new HashMap<String,Object>();
		Integer serviceType = telPo.getServiceType();
		if(serviceType != null){
			params.put("serviceType", serviceType);

			boolean cityProIn = StringHelper.isNotEmpty(telPo.getProvinceid()); //加入省市参数必须的条件
			boolean cityIn = serviceType.equals(HuaServiceTypeEnum.CITY.getValue()) && StringHelper.isNotEmpty(telPo.getCityid());//加入市的条件
			boolean provinceIn = serviceType.equals(HuaServiceTypeEnum.PROVINCE.getValue()) || cityIn ;//加入省份参数条件
			
			if(provinceIn && cityProIn){
				params.put("provinceid", telPo.getProvinceid());
			}
			if(cityIn && cityProIn){
				params.put("cityid", telPo.getCityid());
			}
		}
		
		if(telPo.getChargeSpeed() != null){
			params.put("chargeSpeed", telPo.getChargeSpeed());
		}
		if(telPo.getOperatorName() != null){//todo
			params.put("operatorName", telPo.getOperatorName());
		}
		if(telPo.getChargeValue() != null){
			params.put("chargeValue", telPo.getChargeValue());
		}
		
		return params;
	}

}
