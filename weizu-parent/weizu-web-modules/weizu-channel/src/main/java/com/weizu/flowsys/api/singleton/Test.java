package com.weizu.flowsys.api.singleton;

import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;


public class Test {

	public static void main(String[] args) {
		BaseInterface bi = SingletonFactory.getSingleton("Weizu", new BaseP("1","2","1",1,new ExchangePlatformPo()));
//		bi.initSpecialP("1","1.0","GET"); //在接口实现类中自己调用的方法
		bi.charge();
	}

}
