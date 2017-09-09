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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aiyi.base.pojo.PageParam;
import com.alibaba.fastjson.JSON;
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ScopeCityEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;
import com.weizu.flowsys.web.channel.ao.AgencyEpAO;
import com.weizu.flowsys.web.channel.ao.ProductCodeAO;
import com.weizu.flowsys.web.channel.pojo.AgencyEpPo;
import com.weizu.flowsys.web.channel.pojo.OperatorPgDataPo;
import com.weizu.flowsys.web.channel.pojo.ProductCodePo;
import com.weizu.flowsys.web.channel.url.ProductCodeURL;
import com.weizu.web.foundation.String.StringHelper;

/**
 * @description:产品编码管理
 * @projectName:crud
 * @className:ProductCodeController.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月8日 下午12:18:17
 * @version 1.0
 */
@Controller
@RequestMapping(value = ProductCodeURL.MODOE_NAME)
public class ProductCodeController {
	
	@Resource
	private ProductCodeAO productCodeAO;
	@Resource
	private AgencyEpAO agencyEpAO;
	
	
	/**
	 * @description:跳转到产品列表添加页面
	 * @param pageTitle
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月9日 上午9:49:00
	 */
	@RequestMapping(value = ProductCodeURL.PRODUCTCODE_ADD_PAGE)
	public ModelAndView addProdouctCodePage(String pageTitle,Integer epId, HttpServletRequest request){
		Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("pageTitle", pageTitle);
		//查询所有平台名称
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(agencyVO != null){
			List<AgencyEpPo> epList = agencyEpAO.getAgencyEpByAgencyId(agencyVO.getId());
			resultMap.put("epList", epList);
			//判断前台是否穿了平台id过来，没有就默认取第一个
			if(epId == null && epList != null && epList.size() > 0){
				epId = epList.get(0).getEpId();
			}
			List<OperatorPgDataPo> pgList = productCodeAO.initPgList(epId,0, 0);//默认移动全国流量
			resultMap.put("pgList", pgList);
			resultMap.put("operatorType", 0);
			resultMap.put("serviceType", 0);
			resultMap.put("scopeCityEnums", ScopeCityEnum.toList());
			resultMap.put("pgTypeEnums", OperatorTypeEnum.toList());
			resultMap.put("serviceTypeEnums", ServiceTypeEnum.toList());
			resultMap.put("epId", epId);
//		resultMap.put("epId", Integer.parseInt(epId));
//		operatorPgAO.l
			return new ModelAndView("/channel/productCode_add_page", "resultMap", resultMap);
		}else{
			return new ModelAndView("error", "errorMsg", "系统维护之后，用户未登陆！！");
		}
	}
	
	/**
	 * @description: 产品编码添加
	 * @param productCodePo
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月9日 上午10:32:48
	 */
	@RequestMapping(value = ProductCodeURL.PRODUCT_CODE_ADD)
	public void addProdouctCode(ProductCodePo productCodePo,HttpServletResponse response,HttpServletRequest request){
		String result = productCodeAO.addProduct(productCodePo);
		request.getSession().setAttribute("epId", productCodePo.getEpId());//修改默认加载的平台编码列表
		request.getSession().setAttribute("product_add", productCodePo);
		
		try {
			response.getWriter().print(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @description:筛选出包体列表
	 * @param operatorType
	 * @param serviceType
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月9日 上午10:51:09
	 */
	@RequestMapping(value = ProductCodeURL.AJAX_PG_LIST)
	public void ajaxPgList(String operatorType, String serviceType, Integer epId,HttpServletResponse response){
		if(StringHelper.isNotEmpty(serviceType) && StringHelper.isNotEmpty(operatorType)){
			 //这句话的意思，是让浏览器用utf8来解析返回的数据  
			response.setHeader("Content-type", "text/html;charset=UTF-8");  
			//这句话的意思，是告诉servlet用UTF-8转码，而不是用默认的ISO8859  
			response.setCharacterEncoding("UTF-8");
			List<OperatorPgDataPo> pgList = productCodeAO.initPgList(epId,Integer.parseInt(serviceType), Integer.parseInt(operatorType));
			try {
				response.getWriter().print(JSON.toJSONString(pgList));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * @description: 验证通道下是否存在一样的编码
	 * @param operatorType
	 * @param serviceType
	 * @param response
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月9日 下午5:29:41
	 */
	@RequestMapping(value = ProductCodeURL.PRODUCT_CODE_EXIST)
	public void ajaxPcExist(ProductCodePo productCodePo, HttpServletResponse response){
		if(StringHelper.isNotEmpty(productCodePo.getProductCode()) && productCodePo.getEpId() != null){
			boolean result = productCodeAO.existProductCode(productCodePo.getEpId(), productCodePo.getProductCode());
			try {
				response.getWriter().print(result);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * @description: 获得产品编码列表
	 * @param productPo
	 * @param request
	 * @param pageNo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月8日 下午12:23:11
	 */
	@RequestMapping(value = ProductCodeURL.PRODUCT_CODE_LIST)
	public ModelAndView getProductCode(ProductCodePo productCodePo,HttpServletRequest request,@RequestParam(value = "pageNo", required = false)String pageNo)
	{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(agencyVO != null){
			List<AgencyEpPo> epList = agencyEpAO.getAgencyEpByAgencyId(agencyVO.getId());
			resultMap.put("epList", epList);
			//提交表单，对接平台参数绝对不为空；为空说明第一次加载
			Pagination<ProductCodePo> pagination = null;
			if(epList.size() != 0){
				if(productCodePo == null || productCodePo.getEpId() == null){
					productCodePo = new ProductCodePo();
					Object sessionEpId = request.getSession().getAttribute("epId");
					if(sessionEpId != null){
						productCodePo.setEpId(Integer.parseInt(sessionEpId.toString()));
					}else{
						productCodePo.setEpId(epList.get(0).getEpId());//默认加载第一个平台的编码
					}
	//				if(productCodePo.getOperatorType() == null){
	//					productCodePo.setOperatorType(0);//默认加载移动
	//				}
				}
				PageParam pageParam = null;
				if(StringHelper.isNotEmpty(pageNo)){
					pageParam  = new PageParam(Integer.parseInt(pageNo), 10);
				}else{
					pageParam = new PageParam(1, 10);
				}
				pagination = productCodeAO.getProductCode(productCodePo, pageParam);
				resultMap.put("pagination", pagination);
			}else{
				pagination = new Pagination<ProductCodePo>(null, 0, 1, 10);
				resultMap.put("pagination", pagination);
			}
			//List<ExchangePlatformPo> epList = 
			resultMap.put("operatorTypeEnums", OperatorTypeEnum.toList());
			resultMap.put("serviceTypeEnums", ServiceTypeEnum.toList());
			resultMap.put("searchParam", productCodePo);
			resultMap.put("scopeCityEnums", ScopeCityEnum.toList());
			return new ModelAndView("/channel/product_code_list", "resultMap", resultMap);
		}else{
			return new ModelAndView("error", "errorMsg", "系统维护之后，用户未登陆！！");
		}
		
	}
	
	/**
	 * @description: 删除产品编码
	 * @param codeId
	 * @param response
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月1日 下午3:45:48
	 */
	@RequestMapping(value=ProductCodeURL.PRODUCTCODE_DELETE)
	public void deleteProductCode(String codeId,HttpServletResponse response){
		
		int delResult = productCodeAO.deleteProductCode(codeId);
		try {
			if(delResult > 0 )
			{
				response.getWriter().print("success");
			}
			else{
				response.getWriter().print("error");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
