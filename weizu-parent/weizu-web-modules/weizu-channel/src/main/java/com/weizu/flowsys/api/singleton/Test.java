package com.weizu.flowsys.api.singleton;

import com.weizu.flowsys.web.channel.dao.impl.ExchangePlatformDao;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.web.foundation.DateUtil;


public class Test {

	public static void main(String[] args) {
//		BaseInterface bi = SingletonFactory.getSingleton("Weizu", new BaseP("1","2","1",1,new ExchangePlatformPo()));
////		bi.initSpecialP("1","1.0","GET"); //在接口实现类中自己调用的方法
//		bi.charge();
//		ExchangePlatformDao epPoDao = new ExchangePlatformDao();
//		ExchangePlatformPo epPo = epPoDao.get(43);
//		testLljypt(epPo);
		
		System.out.println(DateUtil.formatAll(1472196193429l));
		
	}
	
	/**
	 * @description:Lliypt 接口测试
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月30日 上午10:55:48
	 */
	public static void testLljypt(ExchangePlatformPo epPo){
//		ExchangePlatformPo epPo = epPoDao.
//		epPo.setEpOtherParams("merchant=10304&version=v100&clientId=10000");//对私账户
//		BaseInterface bi = SingletonFactory.getSingleton("Lljypt", new BaseP("pc123123","726633391352451072","15014369834",1,epPo));
		BaseInterface bi = SingletonFactory.getSingleton("Lljypt", new BaseP("pc123123","726633391352451072","15014369834",1,epPo));
		bi.getBalance();
		System.out.println(bi.toParams()); //http参数
	}

}
