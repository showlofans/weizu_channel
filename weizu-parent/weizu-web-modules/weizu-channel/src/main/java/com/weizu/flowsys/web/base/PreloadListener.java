package com.weizu.flowsys.web.base;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.weizu.web.foundation.DateUtil;

/**
 * @description: tomcat web应用启动之后运行的监听
 * @projectName:weizu-channel
 * @className:PreloadListener.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年10月24日 下午3:05:34
 * @version 1.0
 */
public class PreloadListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		 //destory operation 
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//init operation 
		ServletContext application = arg0.getServletContext();
		application.setAttribute("startupTime", DateUtil.formatAll());
//		System.out.println("1231212123121312121322");
	}

}
