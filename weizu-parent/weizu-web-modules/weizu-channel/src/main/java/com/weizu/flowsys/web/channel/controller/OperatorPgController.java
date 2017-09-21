package com.weizu.flowsys.web.channel.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.PgInServiceEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.channel.ao.OperatorPgAO;
import com.weizu.flowsys.web.channel.pojo.OperatorPgDataPo;
import com.weizu.flowsys.web.channel.pojo.PgDataPo;
import com.weizu.flowsys.web.channel.url.OperatorPgURL;
import com.weizu.flowsys.web.http.ao.ValiUser;
import com.weizu.web.foundation.String.StringHelper;

@Controller
@RequestMapping(value = OperatorPgURL.MODOE_NAME)
public class OperatorPgController {
	@Resource
	private OperatorPgAO operatorPgAO;
	@Resource
	private ValiUser valiUser;
	

//	@RequestMapping(value = "initPg.do")
//	public ModelAndView initPg() {
//		int result = operatorPgAO.addPgList();
//
//		if (result > 0) {
//			return new ModelAndView("index");
//		} else {
//			return new ModelAndView("operator_pg_list", "msg", result);
//		}
//	}
//
//	@RequestMapping(value = "listNextPg")
//	@ResponseBody
//	public String listNextPg(
//			@RequestParam(value = "aoData", required = false) String aoData) {
//		// System.out.println(http.getQueryString());
//		// Map<String, Object> paramsMap = operatorPgAO.getOperatorPgParams(
//		// operatorPgDataPo, aoData);
//		// Map<String, Object> resultMap = operatorPgAO.listPg(paramsMap);
//
//		Map<String, Object> resultMap = operatorPgAO.testAOParams(aoData);
//		JSONObject.toJSON(resultMap);
//		String result = JSONObject.toJSONString(resultMap,
//				SerializerFeature.WriteNullStringAsEmpty);
//
//		// FastJsonJsonView view = new FastJsonJsonView();
//		//
//		// view.setAttributesMap(resultMap);
//		// return new ModelAndView(view);
//
//		// resultMap.put("operatorPgDataPo", operatorPgDataPo);
//		// System.out.println(start+" "+length);
//		return result;
//	}
//
//	@RequestMapping(value = "listAjaxPg")
//	@ResponseBody
//	public String listPgg(
//			@RequestParam(value = "aoData", required = false) String aoData,
//			OperatorPgDataPo operatorPgDataPo) {
//		// System.out.println(http.getQueryString());
//		Map<String, Object> paramsMap = new HashMap<String, Object>();
//		// 调用带页码和每页大小的方法
//		paramsMap = operatorPgAO.getOperatorPgParams(operatorPgDataPo, aoData);
//		Map<String, Object> resultMap = operatorPgAO.listPg(paramsMap);
//
//		// FastJsonJsonView view = new FastJsonJsonView();
//		//
//		// view.setAttributesMap(resultMap);
//		// return new ModelAndView(view);
//		// resultMap.put("operatorPgDataPo", operatorPgDataPo);
//		// System.out.println(start+" "+length);
//		JSONObject.toJSON(resultMap);
//		String result = JSONObject.toJSONString(resultMap,
//				SerializerFeature.WriteNullStringAsEmpty);
//		return result;
//	}

//	@RequestMapping(value = "testAoData")
//	@ResponseBody
//	public String testAoData(
//			@RequestParam(value = "aoData", required = false) String aoData) {
//		JSONArray jsonarray = JSONArray.parseArray(aoData);
//		String sEcho = null;
//		String sort_th = null; // 被排序的列
//		String sort_type = null; // 排序的方向 "desc" 或者 "asc".
//		String start = null; // 排序的方向 "desc" 或者 "asc".
//		String length = null; // 排序的方向 "desc" 或者 "asc".
//		for (int i = 0; i < jsonarray.size(); i++) {
//			JSONObject obj = (JSONObject) jsonarray.get(i);
//			System.out.println(obj.get("name") + ":"
//					+ obj.get("value").toString());
//			if (obj.get("name").equals("sEcho"))
//				sEcho = obj.get("value").toString();
//			if (obj.get("name").equals("iSortCol_0"))
//				sort_th = obj.get("value").toString();
//			if (obj.get("name").equals("sSortDir_0"))
//				sort_type = obj.get("value").toString();
//			if (obj.get("name").equals("iDisplayStart"))
//				start = obj.get("value").toString();
//			if (obj.get("name").equals("iDisplayLength"))
//				length = obj.get("value").toString();
//		}
//		JSONObject getObj = new JSONObject();
//
//		Map<String, Object> resultMap = operatorPgAO
//				.listPg(new HashMap<String, Object>());
//
//		resultMap.put("sEcho", Integer.parseInt(sEcho) + 1);
//		resultMap.put("iTotalRecords", 100);
//		resultMap.put("iTotalDisplayRecords", 100);
//		if (StringHelper.isNotEmpty(sort_th)) {
//			getObj.put("aaData", resultMap);
//			System.out.println("select * from tt limit "
//					+ start
//					+ ","
//					+ length
//					+ "order by "
//					+ "" + " " + sort_type + ";");// 打印limit语句
//		}
//		return getObj.toString();
//	}

//	@RequestMapping(value = "testHttp")
//	public ModelAndView testHttp(PageTag pageTag,OperatorPgDataPo operatorPgDataPo) {
////		System.out.println(http.getQueryString());
//		Map<String, Object> paramsMap = operatorPgAO
//				.getOperatorPgParams(pageTag,operatorPgDataPo);
//		
//		
//		Map<String, Object> resultMap = operatorPgAO.listPg(paramsMap,pageTag);
//		
//		if(pageTag== null){
//			System.out.println("pageTag is null");
//		}else{
//			int m = pageTag.getPageIndex();
//			System.out.println("pageIndex:"+m);
//		}
//		return new ModelAndView("operator_pg_list", "resultMap", resultMap);
//	}
	
	@RequestMapping(value = OperatorPgURL.OPERATORPG_LIST)
	public ModelAndView testPage(@RequestParam(value = "pageNo", required = false)String pageNo,OperatorPgDataPo operatorPgDataPo) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		//界面查询的话保证serviceType不为空--没有点查询就用默认
//		if(operatorPgDataPo != null && operatorPgDataPo.getServiceType() == null){
//			operatorPgDataPo.setServiceType(0);//默认全国
//		}
		Map<String, Object> paramsMap = operatorPgAO
				.getOperatorPgParams(operatorPgDataPo);
		PageParam pageParam = null;
		if(StringHelper.isNotEmpty(pageNo)){
			pageParam = new PageParam(Integer.parseInt(pageNo), 10);
		}else{
			pageParam = new PageParam(1, 10);
		}
		Pagination<OperatorPgDataPo> pagination = operatorPgAO.listPg(paramsMap,pageParam);
		resultMap.put("pgInEnums", PgInServiceEnum.toList());
		resultMap.put("pgTypeEnums", OperatorTypeEnum.toList());
		resultMap.put("serviceTypeEnums", ServiceTypeEnum.toList());
		resultMap.put("params", operatorPgDataPo);
		resultMap.put("pagination", pagination);
		return new ModelAndView("/channel/operatorPg_list", "resultMap", resultMap);
	}
	
	
	
	/**
	 * @description:包体添加页面
	 * @param pageTitle
	 * @return
	 * @throws UnsupportedEncodingException
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月5日 下午2:32:33
	 */
	@RequestMapping(value = OperatorPgURL.PG_ADD_PAGE)
	public ModelAndView pg_add_page(@RequestParam(value = "pageTitle", required = false)String pageTitle) throws UnsupportedEncodingException{
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if(StringHelper.isNotEmpty(pageTitle)){
//			resultMap.put("pageTitle", new String(pageTitle.getBytes("ISO8859-1"), "utf-8"));
			resultMap.put("pageTitle", pageTitle);
		}
		resultMap.put("pgTypeEnums", OperatorTypeEnum.toList());
		resultMap.put("serviceTypeEnums", ServiceTypeEnum.toList());
		resultMap.put("pgInServiceEnums", PgInServiceEnum.toList());
		return new ModelAndView("/channel/pg_add_page", "resultMap", resultMap);
	}
	
	/**
	 * @description:流量包添加
	 * @param opp
	 * @return
	 * @author:POP产品研发部 宁强
	 * @throws IOException 
	 * @createTime:2017年5月16日 上午9:01:16
	 */
	@RequestMapping(value=OperatorPgURL.PG_ADD)
	@ResponseBody
	public void pg_add(PgDataPo opp,HttpServletResponse response) throws IOException{
		//添加失败的情况
//		Map<String, Object> resultMap = new HashMap<String, Object>();
//		resultMap.put("pageTitle", pageTitle);
//		resultMap.put("pgTypeEnums", OperatorTypeEnum.toList());
		
		response.getWriter().print(operatorPgAO.addPg(opp));
		
	}
	/**
	 * @description: 流量包删除
	 * @param opp
	 * @param response
	 * @throws IOException
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月15日 下午5:24:36
	 */
	@RequestMapping(value=OperatorPgURL.PG_DELETE)
	@ResponseBody
	public void pg_del(String pgId,HttpServletResponse response) throws IOException{
		if(StringHelper.isNotEmpty(pgId)){
			response.getWriter().print(operatorPgAO.delPg(Integer.parseInt(pgId)));
		}
	}
	/**
	 * @description: 验证流量包是否存在
	 * @param pgData
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月20日 上午9:52:14
	 */
	@ResponseBody
	@RequestMapping(value=OperatorPgURL.PG_EXIST)
	public Boolean existPg(OperatorPgDataPo pgData){
		if(valiUser.findPg(pgData.getServiceType(), pgData.getPgSize(), pgData.getOperatorType()) == null){
			return true;
		}else{
			return false;
		}
	}
	
}
