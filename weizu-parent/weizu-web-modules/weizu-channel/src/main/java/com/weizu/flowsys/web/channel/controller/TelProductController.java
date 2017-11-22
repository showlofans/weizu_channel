package com.weizu.flowsys.web.channel.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aiyi.base.pojo.PageParam;
import com.alibaba.fastjson.JSON;
import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelUseStateEnum;
import com.weizu.flowsys.operatorPg.enums.HuaServiceTypeEnum;
import com.weizu.flowsys.operatorPg.enums.OperatorNameEnum;
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.operatorPg.enums.TelchannelTypeEnum;
import com.weizu.flowsys.operatorPg.enums.TelchargeSpeedEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.channel.ao.TelProductAO;
import com.weizu.flowsys.web.channel.dao.ExchangePlatformDaoInterface;
import com.weizu.flowsys.web.channel.dao.IProcincesDAO;
import com.weizu.flowsys.web.channel.dao.ITelProductDao;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.flowsys.web.channel.pojo.ProductCodePo;
import com.weizu.flowsys.web.channel.pojo.Provinces;
import com.weizu.flowsys.web.channel.pojo.TelProductPo;
import com.weizu.flowsys.web.channel.url.ProductCodeURL;
import com.weizu.flowsys.web.channel.url.TelChannelURL;
import com.weizu.flowsys.web.channel.url.TelProductURL;
import com.weizu.web.foundation.String.StringHelper;

@Controller
@RequestMapping(value=TelProductURL.MODOE_NAME)
public class TelProductController {
	
	@Resource
	private TelProductAO telProductAO;
	
	@Resource
	private ITelProductDao telProductDao;
	
	@Resource
	private IProcincesDAO procincesDAO;
	
	@Resource
	private ExchangePlatformDaoInterface exchangePlatformDao;
	
	
	
	/**
	 * @description: 获得价值列表
	 * @param telProductPo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月11日 下午3:11:35
	 */
	@ResponseBody
	@RequestMapping(value=TelProductURL.AJAX_GET_CODE)
	public String ajaxGetProductList(TelProductPo telProductPo){
		List<TelProductPo> paramsList = telProductAO.listTelProduct(telProductPo);
		String jsonStr = JSON.toJSON(paramsList).toString();
		System.out.println(jsonStr);
		return jsonStr;
	}
	
	/**
	 * @description: 话费编码添加页面
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月11日 下午3:58:14
	 */
	@RequestMapping(value=TelProductURL.TELPRODUCT_ADD_PAGE)
	public ModelAndView telProductAddPage(TelProductPo telProductPo){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("operatoerNameEnums", OperatorNameEnum.toList());
		resultMap.put("serviceTypeEnums", HuaServiceTypeEnum.toList());
		resultMap.put("telchargeSpeedEnums", TelchargeSpeedEnum.toList());
		WherePrams whereEp = null;
		if(StringHelper.isNotEmpty(telProductPo.getEpName())){
			whereEp = new WherePrams("ep_name", "like", telProductPo.getEpName());
		}
		List<ExchangePlatformPo> epList = exchangePlatformDao.list(whereEp);
		if(epList != null && epList.size() > 0 ){
			resultMap.put("epList", epList);
			resultMap.put("epId", epList.get(0).getId());
		}
		
		List<Provinces> provinces = procincesDAO.getProvinces();
		resultMap.put("telProductPo", telProductPo);
		resultMap.put("provinces", provinces);
//		resultMap.put("provincesJson", JSON.toJSONString(provinces));
		return new ModelAndView("/tel_channel/telproduct_add_page", "resultMap", resultMap);
	}
	/**
	 * @description:话费编码列表
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月11日 下午3:59:09
	 */
	@RequestMapping(value=TelProductURL.TELPRODUCT_LIST)
	public ModelAndView telProductList(TelProductPo telProductPo,@RequestParam(value = "pageNoLong", required = false)Long pageNoLong){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("operatorNameEnums", OperatorNameEnum.toList());
		resultMap.put("serviceTypeEnums", HuaServiceTypeEnum.toList());
		resultMap.put("telchargeSpeedEnums", TelchargeSpeedEnum.toList());
		resultMap.put("chargeTelEnums", TelchannelTypeEnum.toList());			//话费基本类型枚举
		PageParam pageParam = null;
		if(pageNoLong != null){
			pageParam  = new PageParam(pageNoLong, 10);
		}else{
			pageParam = new PageParam(1l, 10);
		}
		if(telProductPo.getServiceType() == null){//默认加载市内的
			telProductPo.setServiceType(HuaServiceTypeEnum.CITY.getValue());
		}
		
		Pagination<TelProductPo> pagination = telProductAO.listTelProduct(telProductPo, pageParam);
		resultMap.put("pagination", pagination);
		
		List<Provinces> provinces = procincesDAO.getProvinces();
		resultMap.put("provinces", provinces);
		resultMap.put("params", telProductPo);
//		resultMap.put("provincesJson", JSON.toJSONString(provinces));
		return new ModelAndView("/tel_channel/telproduct_list", "resultMap", resultMap);
	}
	
	/**
	 * @description: 添加话费产品编码
	 * @param telProductPo
	 * @param response
	 * @param request
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月11日 下午4:07:21
	 */
	@RequestMapping(value = TelProductURL.TELPRODUCT_ADD)
	public void addTelProduct(TelProductPo telProductPo,HttpServletResponse response,HttpServletRequest request){
		String result = telProductAO.addTelProduct(telProductPo);
		try {
			response.getWriter().print(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @description: 异步获得编码有编码的话费列表 
	 * @param telProductPo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月14日 下午12:49:47
	 */
	@RequestMapping(value=TelProductURL.AJAX_GET_CODE,method=RequestMethod.GET)
	@ResponseBody
	public String ajaxGetCode(TelProductPo telProductPo){
		List<TelProductPo> telProList = telProductAO.listTelProduct(telProductPo);
		String jsonStr = JSON.toJSONString(telProList);
		
		return jsonStr;
	}
	
//	@RequestMapping(value = TelProductURL.TELPRODUCT_EXIST)
//	public void ajaxPcExist(TelProductPo telProductPo, HttpServletResponse response){
//		boolean result = telProductAO.existCode(telProductPo);
//		//productCodeAO.existProductCode(productCodePo);
//		try {
//			response.getWriter().print(result);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	
	
	
	
	
	
}
