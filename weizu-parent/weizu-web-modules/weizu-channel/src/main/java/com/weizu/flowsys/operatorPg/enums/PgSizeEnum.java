package com.weizu.flowsys.operatorPg.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:作为添加测试数据用
 * @projectName:crud
 * @className:PgSizeEnum.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月12日 下午6:58:49
 * @version 1.0
 */
public enum PgSizeEnum {
	
	TEN("10M",10),
	THIRTY("30M",30),
	FIFTY("50M",50),
	SEVENTY("70M",70),
	HUNDRED("100M",100),
	HUNDRED_FIFTY("150M",150),
	TWO_HUNDRED("200M",200),
	THREE_HUNDRED("300M",300),
	FIVE_HUNDRED("500M",500),
	SEVEN_HUNDRED("700M",700),
	THOUSAND("1G",1024),
	TWO_THOUSAND("2G",2048),
	THREE_THOUSAND("3G",3072),
	FOUR_THOUSAND("4G",4096),
	SIX_THOUSAND("6G",6144),
	ELEVEN_THOUSAND("11G",11264);
	
	private String desc;	//	描述
	private Integer value;	//包体大小
	private PgSizeEnum(String desc, Integer value) {
		this.desc = desc;
		this.value = value;
	}
	public static PgSizeEnum getEnum(Integer value)
	{
		if (value == null)
		{
			return null;
		}

		PgSizeEnum resultEnum = null;

		// 获取附件类型枚举数组
		PgSizeEnum[] enumArray = PgSizeEnum.values();

		for (PgSizeEnum pgSizeEnum : enumArray)
		{
			if(pgSizeEnum.getValue().equals(value))
			{
				resultEnum = pgSizeEnum;
				break;
			}
		}

		return resultEnum;
	}
	
	/**
	 * @description:将枚举转换为MAP，转换成的MAP的key值为枚举值，value值为一个MAP，包含desc和value两个key，值分别为枚举的desc和value值
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年4月26日 下午12:36:17
	 */
	public static Map<String, Map<String, Object>> toMap()
	{
		// 获取附件类型枚举数组
		PgSizeEnum[] enumArray = PgSizeEnum.values();

		// 定义枚举MAP
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>(enumArray.length);

		for (PgSizeEnum pgSizeEnum : enumArray)
		{
			String key = String.valueOf(getEnum(pgSizeEnum.getValue()));

			Map<String, Object> pgInServiceMap = new HashMap<String, Object>(2);
			pgInServiceMap.put("desc", pgSizeEnum.getDesc());
			pgInServiceMap.put("value", pgSizeEnum.getValue());

			enumMap.put(key, pgInServiceMap);
		}

		return enumMap;
	}
	
	/**
	 * @description:将枚举转换成list，其中每个值为一个Map，包含desc和value两个key，值分别为枚举的desc和value值
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年4月26日 下午12:36:27
	 */
	public static List<Map<String, Object>> toList()
	{
		// 获取附件类型枚举数组
		PgSizeEnum[] enumArray = PgSizeEnum.values();

		// 定义枚举list
		List<Map<String, Object>> attachmentTypeMapList = new ArrayList<Map<String, Object>>(enumArray.length);

		for (PgSizeEnum pgSizeEnum : enumArray)
		{
			Map<String, Object> pgInServiceMap = new HashMap<String, Object>(2);
			pgInServiceMap.put("desc", pgSizeEnum.getDesc());
			pgInServiceMap.put("value", pgSizeEnum.getValue());

			attachmentTypeMapList.add(pgInServiceMap);
		}

		return attachmentTypeMapList;
	}
	
	/**
	 * @description:将流量大小编码初始化成指定格式的字符串
	 * @param list
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月13日 下午5:55:49
	 */
	public static String initPgSizeList(){
		List<Map<String, Object>> list = toList();
		StringBuffer pgBuffer = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			pgBuffer.append(list.get(i).get("value").toString());
			if(i != (list.size()-1)){
				pgBuffer.append("& ");
			}
		}
		return pgBuffer.toString();
	}
	/**
	 * @description:将流量大小列表初始化成指定格式的字符串
	 * @param pgSizes
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月16日 下午12:17:40
	 */
	public static String initPgSizeList(List<Integer> pgSizes){
		StringBuffer pgBuffer = new StringBuffer();
//		List<Map<String, Object>> list = toList();
//		for(int i = 0; i < pgSizes.size(); i++){
//			int pgSize = (int)pgSizes.get(i);
//			for(int j = 0; j < list.size(); j++){
//				int value = (int)list.get(j).get("value");
//				if(value == pgSize){
//					String pgSizeDes = list.get(j).get("desc").toString();
//					pgBuffer.append(pgSizeDes);
//					if(i != pgSizes.size()-1 && j != list.size()-1){
//						pgBuffer.append("& ");
//					}
//				}
//			}
//		}
		if(pgSizes != null && pgSizes.size() > 0){
			for (int i = 0; i < pgSizes.size(); i++) {
				pgBuffer.append(pgSizes.get(i));
				if(i != (pgSizes.size()-1)){
					pgBuffer.append("& ");
				}
			}
			return pgBuffer.toString();
		}else{
			return "";
		}
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	
	
}
