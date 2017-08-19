package com.weizu.flowsys.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.weizu.flowsys.core.beans.Po;
import com.weizu.flowsys.web.trade.pojo.PurchaseVO;

public class ClassUtil {
	/**
	 * @description: 比较两个页面订单对象的属性值是否相等
	 * @param obj1
	 * @param obj2
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月18日 下午12:06:41
	 */
	public static boolean contrastObj(Object obj1, Object obj2) {
	    boolean isEquals = true;
	    if (obj1 instanceof PurchaseVO && obj2 instanceof PurchaseVO ) {
	    	PurchaseVO po1 = (PurchaseVO) obj1;
	    	PurchaseVO po2 = (PurchaseVO) obj2;
//	        List textList = new ArrayList<String>();
	        try {
	            Class clazz = po1.getClass();
	            Field[] fields = po1.getClass().getDeclaredFields();
	            for (Field field : fields) {
	                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
	                
	                Method getMethod = pd.getReadMethod();
	                Object o1 = getMethod.invoke(po1);
	                Object o2 = getMethod.invoke(po2);
	                String s1 = "";
	                String s2 = "";
	               //转成字符串的方式不一样，Integer类型直接加“”
	                if(field.getGenericType().toString().equals(
	                	      "class java.lang.String")){
	                	
	                	if(o1 != null){
	                		s1 = o1.toString().trim();
	                	}
	                	if(o2 != null){
	                		s2 = o2.toString().trim();
	                	}
	                }else if(field.getGenericType().toString().equals("class java.lang.Integer")){
	                		if(o1 != null){
		                		s1 = (Integer) o1+"";
		                	}
		                	if(o2 != null){
		                		s2 = (Integer) o2+"";
		                	}
	                }else if(field.getGenericType().toString().equals("class java.lang.Long")){
	                	if(o1 != null){
	                		s1 = (Long) o1+"";
	                	}
	                	if(o2 != null){
	                		s2 = (Long) o2+"";
	                	}
	                }else if(field.getGenericType().toString().equals("class java.lang.Double")){
	                	if(o1 != null){
	                		s1 = (Double) o1+"";
	                	}
	                	if(o2 != null){
	                		s2 = (Double) o2+"";
	                	}
	                }//其他属性类型不判断，默认相等
	                if (!s1.equals(s2.toString())) {
	                    isEquals = false;
	                    break;
//	                    textList.add(getMethod.getName() + ":" + "false");
	                } else {
//	                    textList.add(getMethod.getName() + ":" + "true");
	                }
	            }
	        } catch (Exception e) {
	        	System.out.println(e);
	        }
//	        for (Object object : textList) {
//	            System.out.println(object);
//	        }
	    }
	    return isEquals;
	}
}
