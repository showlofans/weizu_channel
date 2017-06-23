package com.weizu.flowsys.web.trade;

import java.util.HashMap;
import java.util.Map;

import com.weizu.flowsys.operatorPg.enums.ScopeCityEnum;

public class PurchaseUtil {
	
	/**
	 * @description: 通过归属地得到地区信息
	 * @param carrier
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月17日 上午11:44:29
	 */
	public static Map<String, Object> getScopeCityByCarrier(String carrier){
		if(carrier != null){
		for ( Map<String,Object> map : ScopeCityEnum.toList()) {
				if (map.get("desc").toString().contains(carrier.substring(0,2))) {
					Map<String, Object> resultMap = new HashMap<String, Object>(); 
					resultMap.put("scopeCityCode", map.get("value").toString());
					resultMap.put("scopeCityName", map.get("desc").toString());
					return resultMap;
				}
			}
		}
		return null;
	}

}
