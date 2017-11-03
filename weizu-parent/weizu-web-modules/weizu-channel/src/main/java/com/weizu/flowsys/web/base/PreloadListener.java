package com.weizu.flowsys.web.base;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.Query;
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
		
//		MBeanServer mb = ManagementFactory.getPlatformMBeanServer();
		
//		Set<ObjectName> objs = mb.queryNames(new ObjectName("*:type=Connector,*"),  
//	            Query.match(Query.attr("protocol"), Query.value("HTTP/1.1")));  
//	    String hostname = InetAddress.getLocalHost().getHostName();  
//	    InetAddress[] addresses = InetAddress.getAllByName(hostname);  
////	    ArrayList<String> endPoints = Lists.newArrayList();  
//	    for (Iterator<ObjectName> i = objs.iterator(); i.hasNext(); ) {  
//	        ObjectName obj = i.next();  
//	        String scheme = mb.getAttribute(obj, "scheme").toString();  
//	        String port = obj.getKeyProperty("port");  
//	        for (InetAddress addr : addresses) {  
//	            String host = addr.getHostAddress();  
//	            String ep = scheme + "://" + host + ":" + port;  
//	        }  
//	    }  
		
//		System.out.println("1231212123121312121322");
	}

}
