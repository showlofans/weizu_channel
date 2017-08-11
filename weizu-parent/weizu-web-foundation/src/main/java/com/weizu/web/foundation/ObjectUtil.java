package com.weizu.web.foundation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @description:获取对象信息
 * @projectName:crud
 * @className:DeclairedObject.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月4日 下午4:13:51
 * @version 1.0
 */
public class ObjectUtil {
	/**
	 * 根据属性名获取属性值
	 * */
	public Object getFieldValueByName(String fieldName, Object o) {
		try {
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getter = "get" + firstLetter + fieldName.substring(1);
			Method method = o.getClass().getMethod(getter, new Class[] {});
			Object value = method.invoke(o, new Object[] {});
			return value;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * 获取属性名数组
	 * */
	public static String[] getFiledName(Object o) {
		Field[] fields = o.getClass().getDeclaredFields();
		String[] fieldNames = new String[fields.length];
		for (int i = 0; i < fields.length; i++) {
//			System.out.println(fields[i].getType());
			fieldNames[i] = fields[i].getName();
		}
		return fieldNames;
	}
//	public static void main(String[] args) {
//		OperatorPgDataPo op = new OperatorPgDataPo();
//		
//		String[] arr = ObjectUtil.getFiledName(OperatorPgDataPo.class);
//		for (String string : arr) {
//			System.out.println(string);
//		}
//	}

	/**
	 * 获取属性类型(type)，属性名(name)，属性值(value)的map组成的list
	 * */
	@SuppressWarnings({ "rawtypes", "unused" })
	public List<Map> getFiledsInfo(Object o) {
		Field[] fields = o.getClass().getDeclaredFields();
		String[] fieldNames = new String[fields.length];
		List<Map> list = new LinkedList<Map>();
		Map<String, Object> infoMap = null;
		for (int i = 0; i < fields.length; i++) {
			infoMap = new HashMap<String, Object>();
			infoMap.put("type", fields[i].getType().toString());
			infoMap.put("name", fields[i].getName());
			infoMap.put("value", getFieldValueByName(fields[i].getName(), o));
			list.add(infoMap);
		}
		return list;
	}

	/**
	 * 获取对象的所有属性值，返回一个对象数组
	 * */
	public Object[] getFiledValues(Object o) {
		String[] fieldNames = this.getFiledName(o);
		Object[] value = new Object[fieldNames.length];
		for (int i = 0; i < fieldNames.length; i++) {
			value[i] = this.getFieldValueByName(fieldNames[i], o);
		}
		return value;
	}
}
