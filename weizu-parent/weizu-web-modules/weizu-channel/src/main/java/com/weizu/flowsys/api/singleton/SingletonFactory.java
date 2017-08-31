package com.weizu.flowsys.api.singleton;

import com.weizu.flowsys.api.singleton.company.Lljypt;
import com.weizu.flowsys.api.singleton.company.Weizu;

public class SingletonFactory {
	/**
	 * @description: 根据英文标志获得接口实例对象
	 * @param epEngId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月26日 上午9:43:04
	 */
	public static BaseInterface getSingleton(String epEngId,BaseP baseParams){
		if(MyConstants.WEIZU_ENG.equals(epEngId))
		{
			return Weizu.getInstance(epEngId, baseParams);
		}
		if(MyConstants.LLJYPT_ENG.equals(epEngId) || MyConstants.LLJYPT_ENG_0.equals(epEngId)){
			return Lljypt.getInstance(epEngId, baseParams);
		}
		
		return null;
	}
}
