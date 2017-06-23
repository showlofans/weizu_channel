package com.weizu.flowsys.web.channel.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;

/**
 * @description:对接平台管理接口
 * @projectName:crud
 * @className:ExchangePlatformDaoInterface.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月10日 上午10:45:38
 * @version 1.0
 */
public interface ExchangePlatformDaoInterface {
	/**
	 * @description:通过平台名查找平台对象
	 * @param name
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月11日 下午12:50:57
	 */
	ExchangePlatformPo getEpByEpName(@Param("epName")String epName);
	/**
	 * @description:获得所有平台名称
	 * @param name
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月11日 下午12:50:57
	 */
	List<ExchangePlatformPo> getSimpleEp();
	/**
	 * @description:获得所有平台
	 * @param name
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月11日 下午12:50:57
	 */
	List<ExchangePlatformPo> getEp(Map<String,Object> paramsMap);
	/**
	 * @description:获得所有平台总记录数
	 * @param name
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月11日 下午12:50:57
	 */
	int countEp(Map<String,Object> paramsMap);
}
