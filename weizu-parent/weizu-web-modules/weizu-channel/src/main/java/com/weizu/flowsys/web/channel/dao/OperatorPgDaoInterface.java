package com.weizu.flowsys.web.channel.dao;

import java.util.List;
import java.util.Map;

import com.weizu.flowsys.web.channel.pojo.OperatorPgDataPo;

public interface OperatorPgDaoInterface {
	/**
	 * @description:添加一些用于测试的流量包记录到数据库
	 * @param list
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年4月26日 上午11:49:32
	 */
	int add(List<OperatorPgDataPo> list);
	
	/**
	 * @description:查询流量包数据列表
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年4月27日 下午4:11:24
	 */
	List<OperatorPgDataPo> list(Map<String,Object> paramsMap);
	
	/**
	 * @description:通过运营商类型查询购买包体list
	 * @param operatorType
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月26日 下午5:44:29
	 */
	List<OperatorPgDataPo> pgList_forPurchase(int operatorType);
	
	
	/**
	 * @description: 通过参数实体和登陆id查询购买包体list
	 * @param operatorPgPo
	 * @param agencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年8月1日 下午6:24:24
	 */
	List<OperatorPgDataPo> pgList_forPurchase(OperatorPgDataPo operatorPgPo,String scopeCityCode,Integer agencyId);
	/**
	 * @description: 得到添加编码的包体列表
	 * @param operatorPgPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年8月2日 下午5:20:32
	 */
	List<OperatorPgDataPo> pgList_forPurchase(OperatorPgDataPo operatorPgPo);
	
	/**
	 * @description:根据参数查询总记录数
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年4月28日 下午1:00:03
	 */
	int count_list(Map<String,Object> paramsMap);
	
	/**
	 * @description:根据运营商类型查询通道规格列表
	 * @param operatorType
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月16日 上午11:59:00
	 */
	List pgSizeList(Integer operatorType,Integer serviceType);
	
//	Pagination<OperatorPgDataPo> list();
}
