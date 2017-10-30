package com.weizu.flowsys.web.channel.dao;

import java.util.List;
import java.util.Map;

import com.weizu.flowsys.core.dao.Dao;
import com.weizu.flowsys.web.channel.pojo.OneCodePo;
import com.weizu.flowsys.web.channel.pojo.OperatorPgDataPo;
import com.weizu.flowsys.web.channel.pojo.PgDataPo;

public interface OperatorPgDaoInterface extends Dao<PgDataPo, Integer> {
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
	List<PgDataPo> list(Map<String,Object> paramsMap);
	
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
	 * @description: 查询购买包体list
	 * @param params
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月6日 上午11:42:02
	 */
	List<OperatorPgDataPo> pgList_forPurchase(Map<String, Object> params);
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
	 * @description: 根据运营商类型查询通道规格列表
	 * @param oneCodePo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月25日 下午5:46:18
	 */
	List getPgInCode(OneCodePo oneCodePo);
	
	/**
	 * @description: 查询某个平台没有设置产品编码的包体
	 * @param epId
	 * @param serviceType
	 * @param operatorType
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年8月5日 下午1:43:45
	 */
	List<OperatorPgDataPo> listPgListNotInPcode(Map<String,Object> params);
	
	List<OperatorPgDataPo> listPgListInPcode(Map<String,Object> map);
	
	/**
	 * @description: 通过通道id和包体其他参数得到超管的充值包体参数
	 * @param map
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月28日 下午5:26:36
	 */
	List<PgDataPo> getPgByChanel(Map<String,Object> map);
	
//	Pagination<OperatorPgDataPo> list();
}
