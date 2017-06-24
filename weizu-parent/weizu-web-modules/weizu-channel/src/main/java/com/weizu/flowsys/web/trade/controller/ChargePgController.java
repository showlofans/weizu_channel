package com.weizu.flowsys.web.trade.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import org.weizu.web.foundation.DateUtil;

import com.aiyi.base.pojo.PageParam;
import com.alibaba.fastjson.JSON;
import com.weizu.flowsys.core.util.NumberTool;
import com.weizu.flowsys.core.util.hibernate.util.StringHelper;
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.OrderPathEnum;
import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.pojo.OperatorScopeVO;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.channel.ao.ChannelForwardAO;
import com.weizu.flowsys.web.channel.ao.OperatorPgAO;
import com.weizu.flowsys.web.channel.ao.ProductCodeAO;
import com.weizu.flowsys.web.channel.pojo.BestChannelPO;
import com.weizu.flowsys.web.channel.pojo.OneCodePo;
import com.weizu.flowsys.web.channel.pojo.OperatorPgDataPo;
import com.weizu.flowsys.web.trade.PurchaseUtil;
import com.weizu.flowsys.web.trade.ao.PurchaseAO;
import com.weizu.flowsys.web.trade.pojo.PurchasePo;
import com.weizu.flowsys.web.trade.pojo.PurchaseVO;
import com.weizu.flowsys.web.trade.url.ChargePgURL;

/**
 * @description:流量充值管理
 * @projectName:crud
 * @className:ChargePgController.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月3日 上午11:15:59
 * @version 1.0
 */
@Controller
@RequestMapping(value = ChargePgURL.MODEL_NAME)
public class ChargePgController {
	@Resource
	private OperatorPgAO operatorPgAO;
	@Resource
	private ChannelForwardAO channelForwardAO;
	@Resource
	private ProductCodeAO productCodeAO;
	@Resource
	private PurchaseAO purchaseAO;
	
	
	/**
	 * @description:流量充值
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月26日 下午4:58:40
	 */
	@RequestMapping(value = ChargePgURL.PG_CHARGE)
	public ModelAndView pgCharge(HttpServletRequest request,PurchasePo purchasePo){
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		ChargeAccountPo accountPo = (ChargeAccountPo)request.getSession().getAttribute("chargeAccount");
		if(agencyVO != null){
			purchasePo.setAgencyId(agencyVO.getId());
			purchasePo.setOrderArriveTime(System.currentTimeMillis());
			
			Integer purResult = purchaseAO.purchase(purchasePo,accountPo);
//			if(purResult == OrderResultEnum.SUCCESS.getCode())
//			{
				return purchaseList(request, new PurchaseVO(), "1");
//			}else{
//				return null;
//			}
		}
		
		return null;
	}
	
	/**
	 * @description:ajax获得流量购买所需的数据
	 * @param tel
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月26日 下午5:49:56
	 */
	@RequestMapping(value = ChargePgURL.AJAX_PURCHASE_PG)
	public ModelAndView ajaxGetPurchasePg(String tel){
		
		return null;
	}
	/**
	 * @description:获得流量包购买列表
	 * @param response
	 * @param operatorType
	 * @author:POP产品研发部 宁强
	 * @throws UnsupportedEncodingException 
	 * @createTime:2017年5月31日 下午12:04:22
	 */
	@RequestMapping(value=ChargePgURL.PGLIST_FORPURCHASE)
	public void pgList_forPurchase(HttpServletResponse response,String operatorName,String serviceType) throws UnsupportedEncodingException{
		OperatorPgDataPo oppo = new OperatorPgDataPo();
//		for (OperatorTypeEnum typeEnum : OperatorTypeEnum.values()) {
//			if(operatorType.contains(typeEnum.getDesc())){//中国移动包涵移动
//				oppo.setOperatorType(typeEnum.getValue());
//			}
//		}
//		operatorName = new String(operatorName.getBytes("iso-8859-1"), "utf-8");
		oppo.setOperatorName(operatorName.trim());
		oppo.setServiceType(Integer.parseInt(serviceType.trim()));
		List<OperatorPgDataPo> list = operatorPgAO.pgList_forPurchase(oppo);
		try {
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print(JSON.toJSONString(list));
			System.out.println(JSON.toJSONString(list));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @description:获得流量包购买列表
	 * @param response
	 * @param operatorType
	 * @author:POP产品研发部 宁强
	 * @throws UnsupportedEncodingException 
	 * @createTime:2017年5月31日 下午12:04:22
	 */
	@RequestMapping(value=ChargePgURL.PG_CHARGE_PAGE)
	public ModelAndView pg_charge_page(HttpServletResponse response) throws UnsupportedEncodingException{
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("serviceTypeEnum", ServiceTypeEnum.toList());
		
		return new ModelAndView("/trade/pg_charge_page","resultMap",resultMap);
	}
	
	/**
	 * @description: 获得流量充值的采购金额
	 * @param dataPo
	 * @param purchasePo
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月10日 下午4:24:29
	 */
	@RequestMapping(value= ChargePgURL.AJAX_PURCHASE_PRICE)
	public void ajaxPurchassPrice(HttpServletRequest request, OperatorPgDataPo dataPo,String carrier,HttpServletResponse response){
		try {
			AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
//			carrier = new String(carrier.getBytes("iso-8859-1"),"utf-8");
			
			int pgSize = dataPo.getPgSize();
			int serviceType = dataPo.getServiceType();
			Map<String, Object> scopeCityMap = PurchaseUtil.getScopeCityByCarrier(carrier);
			String scopeCityCode = scopeCityMap.get("scopeCityCode").toString();//地区编码
			String scopeCityName = scopeCityMap.get("scopeCityName").toString();//地区名
			int operatorType = -1;//运营商类型
			for (Map<String,Object> map  : OperatorTypeEnum.toList()) {
				if(carrier != null){
					System.out.println(carrier);
					if (carrier.contains(map.get("desc").toString())) {
						operatorType = Integer.parseInt(map.get("value").toString()) ;
						break;
					}
				}
			}
			Map<String, Object> resultMap = new HashMap<String, Object>();
			if(agencyVO != null){
				OperatorScopeVO operatorScopeVO = new OperatorScopeVO(scopeCityName,agencyVO.getId(),operatorType);
				BestChannelPO bestChannel = channelForwardAO.getBestChannel(operatorScopeVO);
				if(bestChannel != null){
					if(productCodeAO.getOneProductCode(new OneCodePo(scopeCityCode, pgSize, operatorType, serviceType, bestChannel.getEpd())) != null)
					{
						//并且存在该包体编码dataPo.getPgPrice() * bestChannel.getChannelDiscount()
						resultMap.put("price", NumberTool.mul(dataPo.getPgPrice(),bestChannel.getChannelDiscount()));
						resultMap.put("channel_id", bestChannel.getChanneld());
						response.getWriter().print(JSON.toJSONString(resultMap));
					}else{//編碼不存在
						resultMap.put("price", dataPo.getPgPrice());
						response.getWriter().print(JSON.toJSONString(resultMap));
//						response.getWriter().print(dataPo.getPgPrice());
					}
				}else{//沒有該地區的最优通道
					response.getWriter().print(dataPo.getPgPrice());
				}
			}
			
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @description: 查询订单列表
	 * @param request
	 * @param purchaseVO
	 * @param pageNo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月13日 下午1:20:59
	 */
	@RequestMapping(value = ChargePgURL.PURCHASE_LIST)
	public ModelAndView purchaseList(HttpServletRequest request, PurchaseVO purchaseVO, @RequestParam(value="pageNo",required=false)String pageNo){
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(agencyVO != null){
			purchaseVO.setRootAgencyId(agencyVO.getId());//设置为当前登陆用户的订单
		}
		PageParam pageParam = null;
		if(StringHelper.isNotEmpty(pageNo)){
			pageParam = new PageParam(Integer.parseInt(pageNo), 10) ;
		}else{//初始化开始时间和结束时间
			purchaseVO.setArriveStartTimeStr(DateUtil.formatAll(DateUtil.getStartTime()));
			purchaseVO.setArriveEndTimeStr(DateUtil.formatAll(DateUtil.getEndTime()));
			pageParam = new PageParam(1, 10);
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Pagination<PurchaseVO> pagination = purchaseAO.getPurchase(purchaseVO, pageParam);
		resultMap.put("pagination", pagination);
		resultMap.put("searchParams", purchaseVO);
		resultMap.put("operatorTypeEnums", OperatorTypeEnum.toList());
		resultMap.put("orderPathEnums", OrderPathEnum.toList());
		resultMap.put("orderStateEnums", OrderStateEnum.toList());
		return new ModelAndView("/trade/purchase_list", "resultMap", resultMap);
	}
}
