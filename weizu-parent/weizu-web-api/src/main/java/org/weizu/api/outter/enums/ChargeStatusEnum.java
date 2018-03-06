package org.weizu.api.outter.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 对下充值接口状态枚举
 * @projectName:weizu-web-api
 * @className:ChargeStatusEnum.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月26日 下午2:04:18
 * @version 1.0
 */
public enum ChargeStatusEnum {
	
	/**
	 * 用户验证失败
	 */
	AUTHENTICATION_FAILURE("用户验证失败",0),
	/**
	 * 系统内部错误
	 */
	CHARGE_INNER_ERROR("服务器内部错误",5000),
	/**
	 * 充值提交成功
	 */
	CHARGE_SUCCESS("success",5001),
	/**
	 * 欠费等待
	 */
	LACK_OF_BALANCE("余额不足",5002),
	/**
	 * 缺少通道配置
	 */
	SCOPE_RATE_UNDEFINED("缺少通道配置",5003),
	/**
	 * 通道禁止提单
	 */
	CHANNEL_CLOSED("通道暂停，接口暂停",5004),//	通道关停
	/**
	 * 票务类型错误
	 */
	INVALID_BILL_TYPE("票务类型错误",5005),
	/**
	 * 包体参数必须为整数
	 */
	INT_REQUIRED("包体参数必须为整数(包体大小;包体范围;运营商类型)",5007),
	/**
	 * 充值包体不存在
	 */
	PG_NOT_FOUND("充值包体不存在",5008),
	/**
	 * 归属地接口调用异常
	 */
	CITY_NOT_FOUND("手机号归属地查询异常",5009),
	
	/**
	 * 出现可疑重复订单
	 */
	HAS_DOUBLE_PURCHAE("出现可疑重复订单",5010),
	/**
	 * 上游出现错误
	 */
	API_ERROR("上游出现错误",5011);
	
	
	
	private String desc;
	private Integer value;
	
	private ChargeStatusEnum(String desc, Integer value) {
		this.desc = desc;
		this.value = value;
	}

	/**
	 * @description:通过枚举值获取枚举
	 * @param value
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年4月26日 下午12:33:32
	 */
	public static ChargeStatusEnum getEnum(Integer value)
	{

		if(value == null){
			return null;
		}
		ChargeStatusEnum resultEnum = null;

		// 获取附件类型枚举数组
		ChargeStatusEnum[] enumArray = ChargeStatusEnum.values();

		for (ChargeStatusEnum chargeStatusEnum : enumArray)
		{
			if(value == chargeStatusEnum.getValue())
			{
				resultEnum = chargeStatusEnum;
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
		ChargeStatusEnum[] enumArray = ChargeStatusEnum.values();

		// 定义枚举MAP
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>(enumArray.length);

		for (ChargeStatusEnum chargeStatusEnum : enumArray)
		{
			String key = String.valueOf(getEnum(chargeStatusEnum.getValue()));

			Map<String, Object> ChargeStatusMap = new HashMap<String, Object>(2);
			ChargeStatusMap.put("desc", chargeStatusEnum.getDesc());
			ChargeStatusMap.put("value", chargeStatusEnum.getValue());

			enumMap.put(key, ChargeStatusMap);
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
		ChargeStatusEnum[] enumArray = ChargeStatusEnum.values();

		// 定义枚举list
		List<Map<String, Object>> operatorNameMapList = new ArrayList<Map<String, Object>>(enumArray.length);

		for (ChargeStatusEnum chargeStatusEnum : enumArray)
		{
			Map<String, Object> ChargeStatusMap = new HashMap<String, Object>(2);
			ChargeStatusMap.put("desc", chargeStatusEnum.getDesc());
			ChargeStatusMap.put("value", chargeStatusEnum.getValue());

			operatorNameMapList.add(ChargeStatusMap);
		}

		return operatorNameMapList;
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
