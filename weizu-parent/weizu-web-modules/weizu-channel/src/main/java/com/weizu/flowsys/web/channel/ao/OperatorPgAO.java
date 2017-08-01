package com.weizu.flowsys.web.channel.ao;

import java.util.List;
import java.util.Map;

import com.aiyi.base.pojo.PageParam;
import com.aiyi.base.pojo.PageTag;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.channel.pojo.OperatorPgDataPo;

public interface OperatorPgAO {
	/**
	 * @description:添加一些用于测试的流量包记录到数据库
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年4月26日 上午11:34:12
	 */
	int addPgList();
	
	/**
	 * @description:列出用于测试的流量包列表
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年4月26日 上午11:35:13
	 */
	Map<String,Object> listPg(Map<String,Object> params);
	Pagination<OperatorPgDataPo> listFirstPg(Map<String,Object> params);
	Map<String,Object> listPg(Map<String,Object> params,PageTag pageTag);
	Pagination<OperatorPgDataPo> listPg(Map<String,Object> params,PageParam pageParam);
	Map<String,Object> listNextPg(Map<String,Object> params);
	
	/**
	 * @description:封装流量查询参数
	 * @param operatorPgDataPo
	 * @param aoData
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年4月28日 下午12:14:54
	 */
	Map<String,Object> getOperatorPgParams(OperatorPgDataPo operatorPgDataPo,String aoData);
	Map<String,Object> getOperatorPgParams(OperatorPgDataPo operatorPgDataPo);
	Map<String,Object> getOperatorPgParams(PageTag pageTag,OperatorPgDataPo operatorPgDataPo);
	Pagination<OperatorPgDataPo> getOperatorPgParams(PageParam pageParam,OperatorPgDataPo operatorPgDataPo);
	
	/**
	 * @description:把客户端传过来的json分页数据解析出来
	 * @param aoData
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年4月28日 下午2:58:39
	 */
	int[] getPageParams(String aoData);
	
	Map<String,Object> testAOParams(String aoData);
	
	/**
	 * @description:增加流量包
	 * @param operatorPgDataPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月16日 上午9:04:56
	 */
	String addPg(OperatorPgDataPo operatorPgDataPo);
	/**
	 * @description:删除流量包
	 * @param operatorPgDataPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月16日 上午9:04:56
	 */
	String delPg(Integer pgId);
	
	/**
	 * @description: 通过id获得流量包实体
	 * @param pgId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月17日 上午11:31:54
	 */
	OperatorPgDataPo getPgById(Integer pgId);
	
	/**
	 * @description:根据运营商类型查询通道规格列表
	 * @param operatorType
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月16日 上午11:59:00
	 */
	List pgSizeList(int operatorType);
	
	/**
	 * @description:通道规格列表变成Str
	 * @param operatorType
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月16日 下午12:38:59
	 */
	String pgSizeStr(Integer operatorType,Integer servict);
	/**
	 * @description:通道规格列表变成Str
	 * @param operatorType
	 * @param serviceType
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月27日 上午11:37:57
	 */
	List pgSizeList(Integer operatorType,Integer serviceType);
	
	/**
	 * @description:通过运营商类型查询购买包体list
	 * @param operatorType
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月26日 下午5:44:29
	 */
	List<OperatorPgDataPo> pgList_forPurchase(String operatorType);
	/**
	 * @description:通过参数查询购买包体list
	 * @param operatorType
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月26日 下午5:44:29
	 */
	List<OperatorPgDataPo> pgList_forPurchase(OperatorPgDataPo operatorPgPo,Integer agencyId);
	
//	boolean checkScopeIsAccept(Integer loginAgencyId, String scopeCityName);
}
