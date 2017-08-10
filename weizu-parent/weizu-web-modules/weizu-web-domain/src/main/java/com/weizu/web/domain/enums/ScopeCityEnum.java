package com.weizu.web.domain.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:服务范围省份枚举
 * @projectName:crud
 * @className:ScopeCityEnum.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月11日 下午5:44:12
 * @version 1.0
 */
public enum ScopeCityEnum {
	
	/**
	 * 北京市
	 */
	BJ("北京市", "01"),
	TJ("天津市", "02"),
	HB("河北省", "03"),
	SHANXI("山西省", "04"),
	NMGZZQ("内蒙古自治区", "05"),
	LN("辽宁省", "06"),
	JL("吉林省", "07"),
	HLJ("黑龙江省", "08"),
	SH("上海市", "09"),
	JS("江苏省", "10"),
	ZJ("浙江省", "11"),
	AH("安徽省", "12"),
	FJ("福建省", "13"),
	JX("江西省", "14"),
	SD("山东省", "15"),
	HN("河南省", "16"),
	HUB("湖北省", "17"),
	HUN("湖南省", "18"),
	GD("广东省", "19"),
	GXZZZZQ("广西壮族自治区", "20"),
	HAIN("海南省", "21"),
	SC("四川省", "22"),
	GZ("贵州省", "23"),
	YN("云南省", "24"),
	XZZZQ("西藏自治区", "25"),
	SX("陕西省", "26"),
	GS("甘肃省", "27"),
	QH("青海省", "28"),
	NXHZ("宁夏回族自治区", "29"),
	XJWWE("新疆维吾尔自治区", "30"),
	CQ("重庆市", "31"),
	/**
	 * 全国
	 */
	QG("全国", "32");
	

	/** 描述 */
	private String desc;

	/** 枚举值 */
	private String value;

	private ScopeCityEnum(String desc, String value)
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
	public static String getValueByDesc(String desct){
		ScopeCityEnum[] enumAry = ScopeCityEnum.values();
		for (ScopeCityEnum scopeCityEnum : enumAry) {
			if(scopeCityEnum.desc.contains(desct) ){
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
		ScopeCityEnum[] enumAry = ScopeCityEnum.values();
		String [] valueArray = new String[enumAry.length];
		for (int i = 0; i < enumAry.length; i++) {
			valueArray[i] = enumAry[i].getValue();
		}
		return valueArray;
	}

	public static ScopeCityEnum getEnum(String value)
	{
		ScopeCityEnum resultEnum = null;
		ScopeCityEnum[] enumAry = ScopeCityEnum.values();

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
		ScopeCityEnum[] ary = ScopeCityEnum.values();
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
		ScopeCityEnum[] ary = ScopeCityEnum.values();
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
