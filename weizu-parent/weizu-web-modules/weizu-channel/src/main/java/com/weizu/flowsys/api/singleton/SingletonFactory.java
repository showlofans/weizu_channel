package com.weizu.flowsys.api.singleton;

import com.weizu.flowsys.api.singleton.company.Lefeng;
import com.weizu.flowsys.api.singleton.company.Lljypt;
import com.weizu.flowsys.api.singleton.company.Maiyuan;
import com.weizu.flowsys.api.singleton.company.Wantull;
import com.weizu.flowsys.api.singleton.company.Weizu;
import com.weizu.flowsys.api.singleton.company.Zxpay;

public class SingletonFactory {
	/**
	 * @description: 根据英文标志获得接口实例对象
	 * @param epEngId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月26日 上午9:43:04
	 */
	public static BaseInterface getSingleton(String epEngId,BaseP baseParams){
		
		BaseInterface bi = null;
		if(MyConstants.WEIZU_ENG.equals(epEngId))
		{
			bi = Weizu.getInstance(epEngId, baseParams);
		}else if(MyConstants.LLJYPT_ENG.equals(epEngId) || MyConstants.LLJYPT_ENG_0.equals(epEngId)){
			bi = Lljypt.getInstance(epEngId, baseParams);
		}else if(MyConstants.LEFENG_ENG.equals(epEngId)){
			bi = Lefeng.getInstance(epEngId, baseParams);
		}else if(MyConstants.WANTULL_ENG.equals(epEngId)|| MyConstants.WANTULL_ENG_0.equals(epEngId)){
			bi = Wantull.getInstance(epEngId, baseParams);
		}else if(MyConstants.MAIYUAN_ENG.equals(epEngId)){//|| MyConstants.WANTULL_ENG_0.equals(epEngId)
			bi = Maiyuan.getInstance(epEngId, baseParams);
		}else if(MyConstants.ZXPAY_ENG.equals(epEngId)){
			bi = Zxpay.getInstance(epEngId, baseParams);
		}
		
		return bi;
	}
}
