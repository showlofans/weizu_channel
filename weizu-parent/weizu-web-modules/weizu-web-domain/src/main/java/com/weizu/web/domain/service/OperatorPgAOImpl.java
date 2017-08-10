package com.weizu.web.domain.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.weizu.web.foundation.String.StringHelper;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.weizu.web.domain.dao.OperatorPgDaoInterface;
import com.weizu.web.domain.dto.OperatorPgDataPo;
import com.weizu.web.domain.enums.OperatorNameEnum;
import com.weizu.web.domain.enums.OperatorTypeEnum;
import com.weizu.web.domain.enums.PgInServiceEnum;
import com.weizu.web.domain.enums.PgSizeEnum;
import com.weizu.web.domain.enums.ServiceTypeEnum;

@Service(value="operatorPgAO")
public class OperatorPgAOImpl implements OperatorPgAO {

	@Resource
	private OperatorPgDaoInterface operatorPgDao;

	@Transactional(isolation = Isolation.SERIALIZABLE)
	public int addPgList() {
		List<OperatorPgDataPo> opdps = new LinkedList<OperatorPgDataPo>();
			return 0;
		}

	/**
	 * @description:根据对应的运营商类型设置名称
	 * @param type
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年4月26日 下午12:18:15
	 */
	private String getOperatorNameByType(int type) {
		String name = "";
		switch (type) {
		case 0 :
			name = OperatorNameEnum.CHINAMOBILE.getValue();
			break;
		case 1:
			name = OperatorNameEnum.CHINALINK.getValue();
			break;
		case 2:
			name = OperatorNameEnum.CHINATELECOME.getValue();
			break;

		default:
			break;
		}
		return name;
	}

	/**
	 * @description:获得流量包列表
	 * @param params
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年4月27日 下午5:21:24
	 */
	public Map<String,Object> listNextPg(Map<String,Object> params) {
		Map<String,Object> resultMap = new HashMap<String, Object>();
		
		
//		Pagination<OperatorPgDataPo> resultList = getPgList(params);
		List<OperatorPgDataPo> resultList = operatorPgDao.list(params);	
//		List<OperatorPgDataPo> list = resultList.getCurrData();
		resultMap.put("pgInEnums", PgInServiceEnum.toList());
		resultMap.put("pgTypeEnums", OperatorTypeEnum.toList());
		
		//分页参数
		int totalElements = operatorPgDao.count_list(params);
		resultMap.put("iTotalRecords",  totalElements);//总记录数
//		resultMap.put("sEcho",  params.get("sEcho").toString());//??
		int pageSize = Integer.parseInt(params.get("pageSize").toString());
		resultMap.put("sEcho", params.get("sEcho").toString());
		if(pageSize > 0 )
		{
			int totalPage = (totalElements + pageSize - 1) / pageSize;
//			resultMap.put("iTotalRecords", totalPage);	//总页数
		}
		
		resultMap.put("pg_list", resultList);
		return resultMap;
	}
	/**
	 * @description:加载流量列表
	 * @param params
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月5日 上午9:32:43
	 */
	
	/**
	 * @description:封装流量查询参数
	 * @param operatorPgDataPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年4月28日 上午9:46:44
	 */
	public Map<String,Object> getOperatorPgParams(OperatorPgDataPo operatorPgDataPo,String aoData)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		if(StringHelper.isNotEmpty(operatorPgDataPo.getOperatorName()))
		{
			params.put("operatorName", operatorPgDataPo.getOperatorName());
		}
		if(StringHelper.isNotEmpty(operatorPgDataPo.getPgName()))
		{
			params.put("pgName", operatorPgDataPo.getPgName());
		}
		if(operatorPgDataPo.getServiceType() != null)
		{
			params.put("serviceType", operatorPgDataPo.getServiceType());
		}
		if(operatorPgDataPo.getOperatorType() != null)
		{
			params.put("operatorType", operatorPgDataPo.getOperatorType());
		}
		if(operatorPgDataPo.getPgInService() != null)
		{
			params.put("pgInService", operatorPgDataPo.getPgInService());
		}
		if(operatorPgDataPo.getPgPrice() != null)
		{
			params.put("pgPrice", operatorPgDataPo.getPgPrice());
		}
		if(operatorPgDataPo.getPgSize() != null)
		{
			params.put("pgSize", operatorPgDataPo.getPgSize());
		}
		
		if(StringHelper.isNotEmpty(aoData))
		{
			
			
		    String sEcho = null;
		    int iDisplayStart = 0; // 起始索引
		    int iDisplayLength = 0; // 每页显示的行数
		    JSONArray jsonarray = JSONArray.parseArray(aoData);
		    for (int i = 0; i < jsonarray.size(); i++) {
		        JSONObject obj = (JSONObject) jsonarray.get(i);
		        if (obj.get("name").equals("sEcho"))
		            sEcho = obj.get("value").toString();
		 
		        if (obj.get("name").equals("iDisplayStart"))
		            iDisplayStart = obj.getIntValue("value");
		 
		        if (obj.get("name").equals("iDisplayLength"))
		            iDisplayLength = obj.getIntValue("value");
		        System.out.println(obj.get("name")+":"+obj.get("value").toString());
		    }
			params.put("pageIndex", iDisplayStart);
			params.put("pageSize", iDisplayLength);
			params.put("sEcho", sEcho);
		}
		else{
			System.out.println("aoData is null");
			params.put("pageIndex", 0);
			params.put("pageSize", 10);
			params.put("sEcho", 1);
		}
	    
		return params;
	}
	public Map<String,Object> getOperatorPgParams(OperatorPgDataPo operatorPgDataPo)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		if(operatorPgDataPo == null){
			return null;
		}
		if(StringHelper.isNotEmpty(operatorPgDataPo.getOperatorName()))
		{
			params.put("operatorName", operatorPgDataPo.getOperatorName());
		}
		if(StringHelper.isNotEmpty(operatorPgDataPo.getPgName()))
		{
			params.put("pgName", operatorPgDataPo.getPgName());
		}
		if(operatorPgDataPo.getServiceType() != null)
		{
			params.put("serviceType", operatorPgDataPo.getServiceType());
		}
		if(operatorPgDataPo.getOperatorType() != null)
		{
			params.put("operatorType", operatorPgDataPo.getOperatorType());
		}
		if(operatorPgDataPo.getPgInService() != null)
		{
			params.put("pgInService", operatorPgDataPo.getPgInService());
		}
		if(operatorPgDataPo.getPgPrice() != null)
		{
			params.put("pgPrice", operatorPgDataPo.getPgPrice());
		}
		if(operatorPgDataPo.getPgSize() != null)
		{
			params.put("pgSize", operatorPgDataPo.getPgSize());
		}
		
		return params;
	}
	/**
	 * @description:通过查询实体和分页实体，获得封装参数
	 * @param pageTag
	 * @param operatorPgDataPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月5日 上午9:43:50
	 */


	/**
	 * @description:列出用于测试的流量包列表
	 * @param params
	 * @param pageParam
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月15日 下午4:57:04
	 */

	/**
	 * @description:增加流量包
	 * @param operatorPgDataPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月16日 上午9:05:27
	 */
	public String addPg(OperatorPgDataPo operatorPgDataPo) {
		if(operatorPgDataPo != null){
			StringBuffer sb = new StringBuffer();
			if(StringHelper.isEmpty(operatorPgDataPo.getPgName())){
				if(operatorPgDataPo.getOperatorType() != null){
					String opName = OperatorTypeEnum.getEnum(operatorPgDataPo.getOperatorType()).getDesc();
					sb.append(opName + "");
				}
				if(operatorPgDataPo.getPgPrice() != null){
					sb.append(operatorPgDataPo.getPgPrice() + "元");
				}
				if(operatorPgDataPo.getPgSize() != null){
					sb.append(operatorPgDataPo.getPgSize() + "MB");
				}
				if(operatorPgDataPo.getServiceType() != null){
					if(operatorPgDataPo.getServiceType() != null){
						String serviceTypeName = ServiceTypeEnum.getEnum(operatorPgDataPo.getServiceType()).getDesc();
						sb.append(serviceTypeName);
					}
				}
				operatorPgDataPo.setPgName(sb.toString());
			}
		}
		int resultMsg = operatorPgDao.add(operatorPgDataPo);
		if(resultMsg > 0){
			return "success";
		}else{
			return "error";
		}
	}

	/**
	 * @description:根据运营商类型查询通道规格列表
	 * @param operatorType
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月16日 下午12:02:54
	 */
	public List pgSizeList(int operatorType) {
		return operatorPgDao.pgSizeList(operatorType,null);
	}
	
	/**
	 * @description:通道规格列表变成Str
	 * @param operatorType
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月16日 下午12:38:12
	 */
	public String pgSizeStr(Integer operatorType,Integer serviceType){
		return PgSizeEnum.initPgSizeList(pgSizeList(operatorType,serviceType));
	}

	/**
	 * @description:通道规格列表变成Str
	 * @param operatorType
	 * @param serviceType
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月27日 上午11:38:19
	 */
	public List pgSizeList(Integer operatorType,Integer serviceType) {
		return operatorPgDao.pgSizeList(operatorType,serviceType);
	}

	/**
	 * @description:通过运营商类型查询购买包体list
	 * @param operatorType
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月31日 下午12:07:25
	 */
	public List<OperatorPgDataPo> pgList_forPurchase(String operatorType) {
		if(StringHelper.isNotEmpty(operatorType)){
			for (OperatorTypeEnum typeEnum : OperatorTypeEnum.values()) {
				if(operatorType.contains(typeEnum.getDesc())){//中国移动包涵移动
					int otype = typeEnum.getValue();
					return operatorPgDao.pgList_forPurchase(otype);
				}
			}
		}
		return null;
	}

	/**
	 * @description:通过流量包参数查询购买包体list 
	 * @param operatorPgPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月6日 下午4:46:02
	 */
	public List<OperatorPgDataPo> pgList_forPurchase(
			OperatorPgDataPo operatorPgPo,String scopeCityCode,Integer agencyId) {
		
		if(operatorPgPo != null){
			List<OperatorPgDataPo> list = operatorPgDao.pgList_forPurchase(operatorPgPo,scopeCityCode,agencyId);
			
			return list;
		}
		return null;
	}
	/**
	 * @description: 得到添加编码的包体列表
	 * @param operatorPgPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年8月2日 下午5:21:07
	 */
	public List<OperatorPgDataPo> pgList_forPurchase(
			OperatorPgDataPo operatorPgPo) {
		
		if(operatorPgPo != null){
			List<OperatorPgDataPo> list = operatorPgDao.pgList_forPurchase(operatorPgPo);
			
			return list;
		}
		return null;
	}

	/**
	 * @description: 删除流量包
	 * @param pgId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月15日 下午5:27:10
	 */
	@Transactional
	public String delPg(Integer pgId) {
		if(operatorPgDao.del(pgId) > 0){
			return "success";
		}
		return null;
	}

	/**
	 * @description: 通过id获得流量包实体
	 * @param pgId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月17日 上午11:32:45
	 */
	public OperatorPgDataPo getPgById(Integer pgId) {
		return operatorPgDao.get(pgId);
	}

}
