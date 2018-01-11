package com.weizu.flowsys.web.channel.ao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.aiyi.base.pojo.PageParam;
import com.aiyi.base.pojo.PageTag;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.weizu.flowsys.api.weizu.charge.PgProductParams;
import com.weizu.flowsys.core.util.NumberTool;
import com.weizu.flowsys.operatorPg.enums.ChannelUseStateEnum;
import com.weizu.flowsys.operatorPg.enums.EpEncodeTypeEnum;
import com.weizu.flowsys.operatorPg.enums.OperatorNameEnum;
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.PgInServiceEnum;
import com.weizu.flowsys.operatorPg.enums.PgServiceTypeEnum;
import com.weizu.flowsys.operatorPg.enums.PgSizeEnum;
import com.weizu.flowsys.operatorPg.enums.ScopeCityEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.channel.dao.ChannelDiscountDao;
import com.weizu.flowsys.web.channel.dao.ExchangePlatformDaoInterface;
import com.weizu.flowsys.web.channel.dao.impl.OperatorPgDao;
import com.weizu.flowsys.web.channel.pojo.ChargeChannelParamsPo;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.flowsys.web.channel.pojo.OneCodePo;
import com.weizu.flowsys.web.channel.pojo.OperatorPgDataPo;
import com.weizu.flowsys.web.channel.pojo.PgDataPo;
import com.weizu.flowsys.web.channel.pojo.SuperPurchaseParam;
import com.weizu.flowsys.web.http.entity.PgProduct;
import com.weizu.flowsys.web.trade.PurchaseUtil;
import com.weizu.web.foundation.String.StringHelper;

@Service("operatorPgAO")
public class OperatorPgAOImpl implements OperatorPgAO {

	@Resource
	private OperatorPgDao operatorPgDao;
	@Resource
	private ChannelDiscountDao channelDiscountDao;
	@Resource
	private ExchangePlatformDaoInterface exchangePlatformDao;

	@Transactional(isolation = Isolation.SERIALIZABLE)
	@Override
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
			name = OperatorNameEnum.CHINAMOBILE.getDesc();
			break;
		case 1:
			name = OperatorNameEnum.CHINALINK.getDesc();
			break;
		case 2:
			name = OperatorNameEnum.CHINATELECOME.getDesc();
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
//	@Override
//	public Map<String,Object> listNextPg(Map<String,Object> params) {
//		Map<String,Object> resultMap = new HashMap<String, Object>();
//		
//		
////		Pagination<OperatorPgDataPo> resultList = getPgList(params);
//		List<OperatorPgDataPo> resultList = operatorPgDao.list(params);	
////		List<OperatorPgDataPo> list = resultList.getCurrData();
//		resultMap.put("pgInEnums", PgInServiceEnum.toList());
//		resultMap.put("pgTypeEnums", OperatorTypeEnum.toList());
//		
//		//分页参数
//		int totalElements = operatorPgDao.count_list(params);
//		resultMap.put("iTotalRecords",  totalElements);//总记录数
////		resultMap.put("sEcho",  params.get("sEcho").toString());//??
//		int pageSize = Integer.parseInt(params.get("pageSize").toString());
//		resultMap.put("sEcho", params.get("sEcho").toString());
//		if(pageSize > 0 )
//		{
//			int totalPage = (totalElements + pageSize - 1) / pageSize;
////			resultMap.put("iTotalRecords", totalPage);	//总页数
//		}
//		
//		resultMap.put("pg_list", resultList);
//		return resultMap;
//	}
	/**
	 * @description:加载第一页流量列表
	 * @param params
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月5日 上午9:32:43
	 */
	@Override
	public Map<String,Object> listPg(Map<String,Object> params) {
//		Pagination<OperatorPgDataPo> resultList = getPgList(params);
//		List<OperatorPgDataPo> list = resultList.getCurrData();
		Map<String,Object> resultMap = new HashMap<String, Object>();
		List<PgDataPo> resultList = operatorPgDao.list(params);	
		
		resultMap.put("pgInEnums", PgInServiceEnum.toList());
		resultMap.put("pgTypeEnums", OperatorTypeEnum.toList());
		resultMap.put("pg_list", resultList);
		//分页参数
		int totalElements = operatorPgDao.count_list(params);
		resultMap.put("totalPageRow",  totalElements);//总记录数
		PageTag pageTag= new PageTag();
		pageTag.setTotalRows(totalElements);
		resultMap.put("totalPage",  pageTag.getTotalPage());//总记录数
		
//		if(params.get("currentPage"))
		resultMap.put("currentPage",  1);//把当前页设定为第一页
		resultMap.put("pageSize",  10);//总记录数
		
		return resultMap;
	}
	/**
	 * @description:加载流量列表
	 * @param params
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月5日 上午9:32:43
	 */
//	@Override
//	public Map<String,Object> listPg(Map<String,Object> params,PageTag pageTag) {
////		Pagination<OperatorPgDataPo> resultList = getPgList(params);
////		List<OperatorPgDataPo> list = resultList.getCurrData();
//		Map<String,Object> resultMap = new HashMap<String, Object>();
////		params.put("start", value)
//		List<OperatorPgDataPo> resultList = operatorPgDao.list(params);	
//		
//		resultMap.put("pgInEnums", PgInServiceEnum.toList());
//		resultMap.put("pgTypeEnums", OperatorTypeEnum.toList());
//		resultMap.put("pg_list", resultList);
//		//把分页参数返回到页面当中
//		int totalElements = operatorPgDao.count_list(params);
//		
//		if(pageTag != null){
//			pageTag = new PageTag();
//			resultMap.put("currentPage",  pageTag.getPageIndex());
//			resultMap.put("pageSize",  pageTag.getPageSize());
//		}else{
//			resultMap.put("currentPage",  1);//把当前页设定为第一页
//			resultMap.put("pageSize",  10);//总记录数
//		}
//		pageTag.setTotalRows(totalElements);
//		resultMap.put("totalPageCount",  pageTag.getTotalPage());//总记录数
//		
//		return resultMap;
//	}
	/*private Pagination<OperatorPgDataPo> getPgList(final Map<String,Object> params){
		
		int pageIndex = Integer.parseInt(params.get("pageIndex").toString());
		int pageSize = Integer.parseInt(params.get("pageSize").toString());
		
		return new DefaultPagination<OperatorPgDataPo>(pageIndex, pageSize, new QueryHandler<OperatorPgDataPo>() {

			@Override
			public int getTotalElements() {
				// TODO Auto-generated method stub
				return operatorPgDao.count_list(params);
			}

			@Override
			public List<OperatorPgDataPo> getCurrData(int pageIndex,
					int pageSize) {
				// TODO Auto-generated method stub
				params.put("pageIndex", pageIndex);
				params.put("pageSize", pageSize);
				return operatorPgDao.list(params);
			}
		});
	}*/
	
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
		if(operatorPgDataPo.getCirculateWay() != null)
		{
			params.put("circulateWay", operatorPgDataPo.getCirculateWay());
		}
		if(operatorPgDataPo.getPgType() != null)
		{
			params.put("pgType", operatorPgDataPo.getPgType());
		}
//		if(operatorPgDataPo.getPgServiceType() != null)
//		{
//			params.put("pgServiceType", operatorPgDataPo.getPgServiceType());
//		}else{//默认
//			params.put("pgServiceType", PgServiceTypeEnum.PGCHARGE.getValue());
//			
//		}
		if(StringHelper.isNotEmpty(operatorPgDataPo.getPgValidity()))
		{
			params.put("pgValidity", operatorPgDataPo.getPgValidity());
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
	public Map<String,Object> getOperatorPgParams(PageTag pageTag,OperatorPgDataPo operatorPgDataPo)
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
		int start = pageTag.getPageIndex() * pageTag.getPageSize();
		params.put("start", start);
		params.put("end", start + pageTag.getPageSize());
		return params;
	}
	@Override
	public int[] getPageParams(String aoData) {
		JSONArray jsonarray = JSONArray.parseArray(aoData);
		 
	    String sEcho = null;
	    int iDisplayStart = 0; // 起始索引
	    int iDisplayLength = 0; // 每页显示的行数
	 
	    for (int i = 0; i < jsonarray.size(); i++) {
	        JSONObject obj = (JSONObject) jsonarray.get(i);
	        if (obj.get("name").equals("sEcho"))
	            sEcho = obj.get("value").toString();
	 
	        if (obj.get("name").equals("iDisplayStart"))
	            iDisplayStart = obj.getIntValue("value");
	 
	        if (obj.get("name").equals("iDisplayLength"))
	            iDisplayLength = obj.getIntValue("value");
	    }
	    int[] resultArr = new int[]{iDisplayStart,iDisplayLength};
		return resultArr;
	}

	@Override
	public Map<String, Object> testAOParams(String aoData) {
		Map<String, Object> params = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if(StringHelper.isNotEmpty(aoData))
		{
			JSONArray jsonarray = JSONArray.parseArray(aoData);
		    String sEcho = null;
		    int iDisplayStart = 0; // 起始索引
		    int iDisplayLength = 0; // 每页显示的行数
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
		  //为操作次数加1
			int  initEcho = Integer.parseInt(sEcho)+1;
			params.put("iTotalRecords", iDisplayLength);
			params.put("iTotalDisplayRecords", iDisplayLength);
			params.put("sEcho", initEcho);
		}
		else{
			System.out.println("aoData is null");
			params.put("pageIndex", 0);
			params.put("pageSize", 10);
			params.put("sEcho", 1);
		}
		
//		int count = operatorPgDao.count_list(getOperatorPgParams())
//		
//		params.put("iTotalRecords", iDisplayLength);
//		params.put("iTotalDisplayRecords", iDisplayLength);
//		params.put("sEcho", initEcho);
		return resultMap;
	}

	/**
	 * @description:列出用于测试的流量包列表
	 * @param params
	 * @param pageParam
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月15日 下午4:57:04
	 */
	@Override
	public Pagination<PgDataPo> listPg(OperatorPgDataPo operatorPgDataPo,
			PageParam pageParam) {
		Map<String, Object> params = getOperatorPgParams(operatorPgDataPo);
		if(params == null){
			params = new HashMap<String, Object>();
		}
		int pageNo = pageParam.getPageNo();
		int pageSize = pageParam.getPageSize();
		//把分页参数返回到页面当中
		int totalElements = operatorPgDao.count_list(params);
		params.put("start", (pageNo-1) * pageSize);
		params.put("end", pageSize);
		List<PgDataPo> recordList = operatorPgDao.list(params);
		return new Pagination<PgDataPo>(recordList, totalElements, pageNo, pageSize);
	}

	/**
	 * @description:增加流量包
	 * @param operatorPgDataPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月16日 上午9:05:27
	 */
	@Override
	public String addPg(PgDataPo operatorPgDataPo) {
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
		operatorPgDataPo.setPgServiceType(PgServiceTypeEnum.PGCHARGE.getValue());
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
//	@Override
//	public List pgSizeList(int operatorType) {
//		return operatorPgDao.pgSizeList(operatorType,null,null);
//	}
	
	/**
	 * @description:通道规格列表变成Str
	 * @param operatorType
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月16日 下午12:38:12
	 */
	@Override
	public String pgSizeStr(OneCodePo oneCodePo){
		StringBuffer pgBuffer = new StringBuffer();
		String pgSizeStr = "";
		Integer epId = oneCodePo.getEpId();
		if(epId != null){
			Map<String,Object> params = new HashMap<String, Object>();
			ExchangePlatformPo platformPo = exchangePlatformDao.get(epId);
			if(oneCodePo.getOperatorType() != null){
				params.put("operatorType", oneCodePo.getOperatorType());
			}
			if(oneCodePo.getServiceType() != null){
				params.put("serviceType", oneCodePo.getServiceType());
			}
			if(oneCodePo.getPgType() != null){
				params.put("pgType", oneCodePo.getPgType());
			}
			if(StringHelper.isNotEmpty(oneCodePo.getPgValidity())){
				params.put("pgValidity", oneCodePo.getPgValidity());
			}
			if(oneCodePo.getCirculateWay() != null){
				params.put("circulateWay", oneCodePo.getCirculateWay());
			}
			List<Integer> pgSizes = null;
			if(EpEncodeTypeEnum.WITHOUT_CODE.getValue().equals(platformPo.getEpEncodeType())){//无编码
				pgSizes = operatorPgDao.listPgIds(params);
			}else{
				if(StringHelper.isNotEmpty(oneCodePo.getScopeCityCode())){
					params.put("scopeCityCode", oneCodePo.getScopeCityCode());
				}
				params.put("epId", epId);
				pgSizes = operatorPgDao.getPgInCode(params);
			}
			if(pgSizes != null && pgSizes.size() > 0){
				for (int i = 0; i < pgSizes.size(); i++) {
					pgBuffer.append(pgSizes.get(i));
					if(i != (pgSizes.size()-1)){
						pgBuffer.append("& ");
					}
				}
				pgSizeStr = pgBuffer.toString();
			}
		}
		return pgSizeStr;
	}

	/**
	 * @description:通道规格列表变成Str
	 * @param operatorType
	 * @param serviceType
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月27日 上午11:38:19
	 */
//	@Override
//	public List<Integer> pgSizeList(Integer operatorType,Integer serviceType,Integer epId,String scopeCityCode) {
//		return operatorPgDao.getPgInCode(operatorType,serviceType,epId,scopeCityCode);
//	}

	/**
	 * @description:通过运营商类型查询购买包体list
	 * @param operatorType
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月31日 下午12:07:25
	 */
	@Override
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
	@Override
	public List<OperatorPgDataPo> pgList_forPurchase(
			OperatorPgDataPo operatorPgPo,String scopeCityCode,Integer agencyId) {
		
		if(operatorPgPo != null){
			List<OperatorPgDataPo> list = operatorPgDao.pgList_forPurchase(operatorPgPo,scopeCityCode,agencyId);
			for (OperatorPgDataPo operatorPgDataPo : list) {
				operatorPgDataPo.setPgDiscountPrice(NumberTool.mul(operatorPgDataPo.getPgPrice(), operatorPgDataPo.getRteDis()));
			}
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
	@Override
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
	@Override
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
	@Override
	public PgDataPo getPgById(Integer pgId) {
		return operatorPgDao.get(pgId);
	}

	@Override
	public Map<String, Object> getBy(SuperPurchaseParam spp) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> params = getMapForBy(spp);
//		WherePrams where = new WherePrams("operator_type", "=", spp.getOperatorType());
//		where.and("service_type", "=", spp.getSerType());
//		where.and("scope_city_code", "=", spp.getScopeCityCode());
//		List<ChannelDiscountPo> discountList = channelDiscountDao.list(where);
//		resultMap.put("discountList", discountList);
		
		List<OperatorPgDataPo> pgList = operatorPgDao.listPgListInPcode(params);
		for (OperatorPgDataPo operatorPgDataPo : pgList) {
			operatorPgDataPo.setPgDiscountPrice(NumberTool.mul(operatorPgDataPo.getPgPrice(), operatorPgDataPo.getCdis()));
		}
		resultMap.put("pgList", pgList);
		
		return resultMap;
	}
	
	private Map<String, Object> getMapForBy(SuperPurchaseParam spp){
		Map<String, Object> params = new HashMap<String, Object>();
		String carrier = spp.getCarrier();
		if(StringHelper.isNotEmpty(carrier)){
			int sLength = carrier.length();
			Map<String,Object> scopeMap = PurchaseUtil.getScopeCityByCarrier(carrier);
			String scopeCityCode = scopeMap.get("scopeCityCode").toString();
			params.put("scopeCityCode", scopeCityCode);
			spp.setScopeCityCode(scopeCityCode);
			String oType = carrier.substring(sLength-2,sLength); //获得operatorType:运营商类型参数，移动
			int opType = OperatorTypeEnum.getValueByDesc(oType);
			params.put("operatorType", opType);
			spp.setOperatorType(opType);
		}
		if(StringHelper.isNotEmpty(spp.getServiceType())){
			int sType = Integer.parseInt(spp.getServiceType().trim());
			params.put("serviceType", sType);
			spp.setSerType(sType);
		}
		if(StringHelper.isNotEmpty(spp.getEpEngId())){
			params.put("epEngId", spp.getEpEngId());
		}
		return params;
	}

	@Override
	public List<PgDataPo> pg_list_for_purchase(ChargeChannelParamsPo ccpp,
			Integer agencyId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("agencyId", agencyId);
		if(ccpp.getOperatorType() != null){
			params.put("operatorType", ccpp.getOperatorType());
		}
		if(ccpp.getServiceType() != null){
			params.put("serviceType", ccpp.getServiceType());
			if(ServiceTypeEnum.NATION_WIDE.getValue() != ccpp.getServiceType()){
				if(ccpp.getScopeCityCode() != null){
					params.put("scopeCityCode", ccpp.getScopeCityCode());
				}
			}else{
				params.put("scopeCityCode", ScopeCityEnum.QG.getValue());
			}
		}
		
		if(ccpp.getChannelType() != null){
			params.put("channelType", ccpp.getChannelType());
		}
		if(ccpp.getPgType() != null){
			params.put("pgType", ccpp.getPgType());
		}
		if(StringHelper.isNotEmpty(ccpp.getPgValidity())){
			params.put("pgValidity", ccpp.getPgValidity());
		}
		params.put("pgServiceType", PgServiceTypeEnum.PGCHARGE.getValue());
		params.put("channelUseState", ChannelUseStateEnum.OPEN.getValue());
		List<PgDataPo> pgList = operatorPgDao.pg_list_for_purchase(params);
		return pgList;
	}

//	@Override
//	public PgProduct getPgProductList(PgProductParams pgParams) {
//		Map<String,Object> map = new HashMap<String,Object>();
////		map.put("agencyId", pgParams.get);
//		map.put("bindState", );
//		map.put("channelUseState", ChannelUseStateEnum.OPEN.getValue());
//		
//		operatorPgDao.getProductPgList(map);
//		
//		return null;
//	}
	
//	private Map<String,Object> getParamsByCCPP(ChargeChannelParamsPo ccpp){
//		Map<String, Object> params = new HashMap<String, Object>();
//		if(ccpp.getOperatorType() != null){
//			params.put("operatorType", ccpp.getOperatorType());
//		}
//		if(ccpp.getServiceType() != null){
//			params.put("serviceType", ccpp.getServiceType());
//		}
//		if(ccpp.getScopeCityCode() != null){
//			params.put("scopeCityCode", ccpp.getScopeCityCode());
//		}
//		
//		if(ccpp.getChannelType() != null){
//			params.put("channelType", ccpp.getChannelType());
//		}
//		if(ccpp.getPgType() != null){
//			params.put("pgType", ccpp.getPgType());
//		}
//		if(StringHelper.isNotEmpty(ccpp.getPgValidity())){
//			params.put("pgValidity", ccpp.getPgValidity());
//		}
//		return params;
//	}

}
