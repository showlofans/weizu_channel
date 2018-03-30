package com.weizu.flowsys.api.singleton;

import com.weizu.flowsys.api.singleton.company.Ctra;
import com.weizu.flowsys.api.singleton.company.Flux;
import com.weizu.flowsys.api.singleton.company.Hongjia;
import com.weizu.flowsys.api.singleton.company.KPool;
import com.weizu.flowsys.api.singleton.company.Lefeng;
import com.weizu.flowsys.api.singleton.company.LiuLiangHui;
import com.weizu.flowsys.api.singleton.company.Lljypt;
import com.weizu.flowsys.api.singleton.company.Maiyuan;
import com.weizu.flowsys.api.singleton.company.ShunYuan;
import com.weizu.flowsys.api.singleton.company.Wantull;
import com.weizu.flowsys.api.singleton.company.Weizu;
import com.weizu.flowsys.api.singleton.company.XingPeng;
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
		//微族公司英文标识
		if(MyConstants.WEIZU_ENG.equals(epEngId))
		{
			bi = Weizu.getInstance(epEngId, baseParams);
		}
		//行云流水对公
		else if(MyConstants.LLJYPT_ENG.equals(epEngId) || MyConstants.LLJYPT_ENG_0.equals(epEngId)){
			bi = Lljypt.getInstance(epEngId, baseParams);
		}
		//青岛网信乐疯平台
		else if(MyConstants.LEFENG_ENG.equals(epEngId)){
			bi = Lefeng.getInstance(epEngId, baseParams);
		}
		//河南趣闻-顽兔平台
		else if(MyConstants.WANTULL_ENG.equals(epEngId)|| MyConstants.WANTULL_ENG_0.equals(epEngId)){
			bi = Wantull.getInstance(epEngId, baseParams);
		}
		//仁智-迈远平台对私英文标志
		else if(MyConstants.MAIYUAN_ENG.equals(epEngId)){//|| MyConstants.WANTULL_ENG_0.equals(epEngId)
			bi = Maiyuan.getInstance(epEngId, baseParams);
		}
		//智信话充平台英文标志
		else if(MyConstants.ZXPAY_ENG.equals(epEngId)){
			bi = Zxpay.getInstance(epEngId, baseParams);
		}
		//红茄科技平台英文标志
		else if(MyConstants.HONGJIA_ENG.equals(epEngId)){
			bi = Hongjia.getInstance(epEngId, baseParams);
		}
		//流量汇平台英文标志
		else if(MyConstants.LIULIANGHUI_ENG.equals(epEngId)){
			bi = LiuLiangHui.getInstance(epEngId, baseParams);
		}
		//杭州弯流平台英文标志
		else if(MyConstants.CTRA_ENG.equals(epEngId)){
			bi = Ctra.getInstance(epEngId, baseParams);
		}
		//智胜新-生东网络-格科恒信息平台英文标志
		else if(MyConstants.FLUX_ENG.equals(epEngId)){
			bi = Flux.getInstance(epEngId, baseParams);
		}
		//江苏卡池-网池充值平台英文标志
		else if(MyConstants.KPOOL_ENG.equals(epEngId)){
			bi = KPool.getInstance(epEngId, baseParams);
		}
		//顺园平台英文标志
		else if(MyConstants.SHUNYUAN_ENG.equals(epEngId)){
			bi = ShunYuan.getInstance(epEngId, baseParams);
		}
		//兴芃平台英文标志
		else if(MyConstants.XINGPENG_ENG.equals(epEngId)){
			bi = XingPeng.getInstance(epEngId, baseParams);
		}
		
		return bi;
	}
}
