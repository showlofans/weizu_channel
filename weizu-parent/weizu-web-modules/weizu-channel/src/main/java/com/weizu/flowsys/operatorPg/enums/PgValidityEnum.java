package com.weizu.flowsys.operatorPg.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.weizu.flowsys.web.channel.pojo.SpecialOpdType;

/**
 * @description: 包体有效期枚举
 * @projectName:weizu-channel
 * @className:PgValidityEnum.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年10月25日 下午3:39:31
 * @version 1.0
 */
public enum PgValidityEnum {
	
	/**
	 * 月包
	 */
	MONTH_DAY_DATA("月包", "30"),
	/**
	 * 1日包
	 */
	ONE_DAY_DATA("今日包", "01"),
	/**
	 * 24小时包
	 */
	TWEENTYFOUR_HOURS("24小时包", "24"),
	/**
	 * 3日包
	 */
	THREE_DAY_DATA("3日包", "03"),
	/**
	 * 7日包
	 */
	SEVEN_DAY_DATA("7日包", "07"),
	/**
	 * 季度包
	 */
	ONE_SEASON_DATA("季度包", "90"),
	/**
	 * 半年包
	 */
	HALF_YEAR_DATA("半年包", "180"),
	/**
	 * 年包
	 */
	ONE_YEAR_DATA("年包", "365");
	

	/** 描述 */
	private String desc;

	/** 枚举值 */
	private String value;

	private PgValidityEnum(String desc, String value)
	{
		this.desc = desc;
		this.value = value;
	}
	
	/**
	 * @description: 通过值，获得键
	 * @param desc
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年8月2日 上午11:49:03
	 */
	public static String getValueByDesc(String desc){
		PgValidityEnum[] enumAry = PgValidityEnum.values();
		for (PgValidityEnum scopeCityEnum : enumAry) {
			if(scopeCityEnum.desc.contains(desc) ){
				return scopeCityEnum.value;
			}
		}
		return null;
	}
	
	/**
	 * @description: 获得值数组
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月6日 下午3:49:25
	 */
	public static String[] getValues(){
		PgValidityEnum[] enumAry = PgValidityEnum.values();
		String [] valueArray = new String[enumAry.length];
		for (int i = 0; i < enumAry.length; i++) {
			valueArray[i] = enumAry[i].getValue();
		}
		return valueArray;
	}
	
	/**
	 * @description: 获得特别的备注
	 * @param value
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月27日 下午12:23:22
	 */
	public static String getSpecialDesc(String value){
		// 获取附件类型枚举数组
		PgValidityEnum[] enumArray = PgValidityEnum.values();
		for (PgValidityEnum PgValidityEnum : enumArray) {
			if(PgValidityEnum.getValue().equals(value)  && !PgValidityEnum.getValue().equals(PgValidityEnum.MONTH_DAY_DATA.getValue())){
				return PgValidityEnum.getDesc();
			}
		}
		return null;
	}

	public static PgValidityEnum getEnum(String value)
	{
		PgValidityEnum resultEnum = null;
		PgValidityEnum[] enumAry = PgValidityEnum.values();

		for (int i = 0; i < enumAry.length; i++)
		{
			if (enumAry[i].getValue().equals(value))
			{
				resultEnum = enumAry[i];
				break;
			}
		}

		return resultEnum;
	}

	public static Map<String, Map<String, Object>> toMap()
	{
		PgValidityEnum[] ary = PgValidityEnum.values();
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>();

		for (int num = 0; num < ary.length; num++)
		{
			Map<String, Object> map = new HashMap<String, Object>();
			String key = String.valueOf(getEnum(ary[num].getValue()));
			map.put("desc", ary[num].getDesc());
			map.put("value", ary[num].getValue());

			enumMap.put(key, map);
		}

		return enumMap;
	}

	public static List<Map<String, Object>> toList()
	{
		PgValidityEnum[] ary = PgValidityEnum.values();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		for (int i = 0; i < ary.length; i++)
		{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("desc", ary[i].getDesc());
			map.put("value", ary[i].getValue());

			list.add(map);
		}

		return list;
	}
	
	public static List<Map<String, Object>> toSpecialList(List<SpecialOpdType> specialOpdList, List<Long> agnecyCnelList)
	{
		if(specialOpdList == null || specialOpdList.size() == 0){
			return null;
		}
		PgValidityEnum[] enumArray = PgValidityEnum.values();
		Set<String> result = new HashSet<String>();
		
		Set<String> allPgValidity = new HashSet<String>();
		for (PgValidityEnum pgValidityEnum : enumArray) {
			allPgValidity.add(pgValidityEnum.getValue()) ;
		}
		// 定义枚举list
		List<Map<String, Object>> attachmentTypeMapList = new ArrayList<Map<String, Object>>(enumArray.length);
		Map<String, Object> pgInServiceMap1 = new HashMap<String, Object>(2);
		pgInServiceMap1.put("desc", PgValidityEnum.MONTH_DAY_DATA.getDesc());
		pgInServiceMap1.put("value", PgValidityEnum.MONTH_DAY_DATA.getValue());
		attachmentTypeMapList.add(pgInServiceMap1);
		
		Set<String> getPgValidity = new HashSet<String>();	//set2
		
		for (Long agencyCnelId : agnecyCnelList) {
			for (SpecialOpdType opdType : specialOpdList) {
				if(opdType.getChannelId() == agencyCnelId && !opdType.getPgValidity().equals(PgValidityEnum.MONTH_DAY_DATA.getValue())){
					getPgValidity.add(opdType.getPgValidity());
				}
			}
		} 
		//差集运算
		result.clear();
        result.addAll(allPgValidity);
        result.retainAll(getPgValidity);
//        System.out.println("差集：" + result);
        
		//根据两个集合获得差集
		 Iterator<String> i = result.iterator();//先迭代出来  
		 while(i.hasNext()){//遍历  
			 String pgValidity =  i.next();
			 for (PgValidityEnum pgValidityEnum : enumArray) {
//	            System.out.println(i.next()); 
	            if(pgValidity.equals(pgValidityEnum.getValue())){
	            	Map<String, Object> pgInServiceMap = new HashMap<String, Object>(2);
	            	pgInServiceMap.put("desc", pgValidityEnum.getDesc());
	            	pgInServiceMap.put("value", pgValidityEnum.getValue());
	            	attachmentTypeMapList.add(pgInServiceMap);
	            }
	        }  
		}
		
		
		
//		for (Long agencyCnelId : agnecyCnelList) {
//			for (SpecialOpdType opdType : specialOpdList) {
//				if(opdType.getChannelId() == agencyCnelId){
//					PgValidityEnum pgInServiceEnum = getEnum(opdType.getPgValidity());
//					if(pgInServiceEnum != null){
//						Map<String, Object> pgInServiceMap = new HashMap<String, Object>(2);
//						pgInServiceMap.put("desc", pgInServiceEnum.getDesc());
//						pgInServiceMap.put("value", pgInServiceEnum.getValue());
//						attachmentTypeMapList.add(pgInServiceMap);
//					}
//				}
//			}
//		} 
		return attachmentTypeMapList;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	public String getDesc()
	{
		return desc;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}

}
