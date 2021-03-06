package com.weizu.flowsys.web.channel.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.operatorPg.enums.ChannelUseStateEnum;
import com.weizu.flowsys.web.channel.dao.OperatorPgDaoInterface;
import com.weizu.flowsys.web.channel.pojo.OneCodePo;
import com.weizu.flowsys.web.channel.pojo.OperatorPgDataPo;
import com.weizu.flowsys.web.channel.pojo.PgDataPo;
import com.weizu.flowsys.web.http.entity.PgProductPo;
import com.weizu.web.foundation.String.StringHelper;

/**
 * @description:流量包dao
 * @projectName:crud
 * @className:OperatorPgDao.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年4月26日 下午12:01:22
 * @version 1.0
 */
@Repository(value="operatorPgDao")
public class OperatorPgDao extends DaoImpl<PgDataPo, Integer> implements OperatorPgDaoInterface {
	@Resource
	private SqlSessionTemplate sqlSessionTemplateASS;
	
	/**
	 * @description:重载Add方法，批量添加
	 * @param list
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年4月26日 下午12:00:02
	 */
	@Override
	public int add(List<OperatorPgDataPo> list) {
		long startId = nextId();
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setId(Integer.valueOf(startId + i + ""));
		}
		return sqlSessionTemplateASS.insert("operatorPg_addList", list);
	}

	/**
	 * @description:根据分页参数获得流量列表
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年4月28日 下午3:35:32
	 */
	@Override
	public List<PgDataPo> list(Map<String, Object> paramsMap) {
		
		return sqlSessionTemplateASS.selectList("pgList_select",paramsMap);
	}

	@Override
	public int count_list(Map<String, Object> paramsMap) {
		
		return sqlSessionTemplateASS.selectOne("pgList_size",paramsMap);
	}

	/**
	 * @description:根据运营商类型查询通道规格列表
	 * @param operatorType
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月16日 上午11:59:23
	 */
	@Override
	public List getPgInCode(Map<String, Object> paramsMap) {
		return sqlSessionTemplateASS.selectList("getPgInCode", paramsMap);
	}
	@Override
	public List listPgIds(Map<String, Object> paramsMap) {
		return sqlSessionTemplateASS.selectList("listPgIds", paramsMap);
	}

	/**
	 * @description: 通过运营商类型查询购买包体list 
	 * @param operatorType
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月26日 下午5:46:25
	 */
	@Override
	public List<OperatorPgDataPo> pgList_forPurchase(int operatorType) {
		
		return sqlSessionTemplateASS.selectList("pgList_forPurchase_type", operatorType);
	}

	/**
	 * @description:通过流量包参数查询购买包体list 
	 * @param operatorPgPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月6日 下午4:52:24
	 */
	@Override
	public List<OperatorPgDataPo> pgList_forPurchase(
			OperatorPgDataPo operatorPgPo,String scopeCityCode,Integer agencyId) {
		Map<String,Object> params = getParamsMap(operatorPgPo);
		params.put("agencyId", agencyId);
		params.put("scopeCityCode", scopeCityCode);
		return sqlSessionTemplateASS.selectList("pgList_forPurchase_po", params);
	}
	/**
	 * @description: 得到添加编码的包体列表
	 * @param operatorPgPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年8月2日 下午5:20:57
	 */
	@Override
	public List<OperatorPgDataPo> pgList_forPurchase(
			OperatorPgDataPo operatorPgPo) {
		Map<String,Object> params = getParamsMap(operatorPgPo);
		return sqlSessionTemplateASS.selectList("pgList_forPurchase_po", params);
	}
	
	@Override
	public List<OperatorPgDataPo> pgList_forPurchase(Map<String, Object> params) {
		return sqlSessionTemplateASS.selectList("pgList_forPurchase_po", params);
	}
	
	private Map<String,Object> getParamsMap(OperatorPgDataPo operatorPgPo){
		Map<String, Object> params = new HashMap<String, Object>();
//		if(StringHelper.isNotEmpty(operatorPgPo.getOperatorName()))
//		{
//			params.put("operatorName", operatorPgPo.getOperatorName());
//		}
		if(operatorPgPo.getServiceType() != null)
		{
			params.put("serviceType", operatorPgPo.getServiceType());
		}
		if(operatorPgPo.getOperatorType() != null)
		{
			params.put("operatorType", operatorPgPo.getOperatorType());
		}
		if(operatorPgPo.getChannelId() != null)
		{
			params.put("channelId", operatorPgPo.getChannelId());
		}
		return params;
	}
	/**
	 * @description: 查询某个平台没有设置产品编码的包体
	 * @param epId
	 * @param serviceType
	 * @param operatorType
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年8月5日 下午1:44:31
	 */
	@Override
	public List<OperatorPgDataPo> listPgListNotInPcode(Map<String,Object> params) {
		return sqlSessionTemplateASS.selectList("listPgListNotInPcode", params);
	}
	@Override
	public List<OperatorPgDataPo> listPgListInPcode(Map<String,Object> map) {
		/*Map<String, Object> params = new HashMap<String, Object>();
		params.put("serviceType", serviceType);
		params.put("operatorType", operatorType);
		params.put("epEngId", epEngId);*/
		return sqlSessionTemplateASS.selectList("listPgListInPcode", map);
	}

	@Override
	public List<PgDataPo> getPgByChanel(Map<String, Object> map) {
		return sqlSessionTemplateASS.selectList("getPgByChanel", map);
	}

	@Override
	public List<PgDataPo> pg_list_for_purchase(Map<String, Object> map) {
		return sqlSessionTemplateASS.selectList("pg_list_for_purchase", map);
	}

	@Override
	public List<PgProductPo> getProductPgList(Map<String, Object> map) {
		return sqlSessionTemplateASS.selectList("getProductPgList", map);
	}

	@Override
	public PgDataPo getPgByOrderId(Long purchaseId) {
		return sqlSessionTemplateASS.selectOne("getPgByOrderId", purchaseId);
	}

}
