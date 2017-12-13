package com.weizu.flowsys.api.hsingleton;

import com.weizu.flowsys.api.singleton.BaseInterface;
import com.weizu.flowsys.api.singleton.BaseP;
import com.weizu.flowsys.api.singleton.company.Lefeng;
import com.weizu.flowsys.api.singleton.company.Lljypt;
import com.weizu.flowsys.api.singleton.company.Weizu;

/**
 * @description: 话费接口仓库
 * @projectName:weizu-channel
 * @className:SingletonFactory.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年12月4日 上午11:51:39
 * @version 1.0
 */
public class HSingletonFactory {
	
	/**
	 * @description: 根据英文标志获得话费接口实例对象
	 * @param epEngId
	 * @param baseParams
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月4日 上午11:53:34
	 */
	public static BaseInterface getSingleton(String epEngId,BaseP baseParams){
//		if(HuaConstants.WEIZU_ENG.equals(epEngId))
//		{
//			return Weizu.getInstance(epEngId, baseParams);
//		}else if(HuaConstants.LLJYPT_ENG.equals(epEngId) || HuaConstants.LLJYPT_ENG_0.equals(epEngId)){
//			return Lljypt.getInstance(epEngId, baseParams);
//		}else if(HuaConstants.LEFENG_ENG.equals(epEngId)){
//			return Lefeng.getInstance(epEngId, baseParams);
//		}
		
		return null;
	}
}
