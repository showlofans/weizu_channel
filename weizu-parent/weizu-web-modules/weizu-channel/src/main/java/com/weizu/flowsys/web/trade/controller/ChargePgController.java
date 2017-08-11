package com.weizu.flowsys.web.trade.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.weizu.api.outter.enums.ChargeStatusEnum;

import com.aiyi.base.pojo.PageParam;
import com.alibaba.fastjson.JSON;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.OrderPathEnum;
import com.weizu.flowsys.operatorPg.enums.OrderResultEnum;
import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
import com.weizu.flowsys.operatorPg.enums.ScopeCityEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.ao.RateDiscountAO;
import com.weizu.flowsys.web.activity.pojo.RateDiscountPo;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.channel.ao.ChannelForwardAO;
import com.weizu.flowsys.web.channel.ao.OperatorPgAO;
import com.weizu.flowsys.web.channel.ao.ProductCodeAO;
import com.weizu.flowsys.web.channel.pojo.OperatorPgDataPo;
import com.weizu.flowsys.web.trade.ao.PurchaseAO;
import com.weizu.flowsys.web.trade.dao.AgencyPurchaseDao;
import com.weizu.flowsys.web.trade.pojo.PgChargeVO;
import com.weizu.flowsys.web.trade.pojo.PurchaseVO;
import com.weizu.flowsys.web.trade.url.ChargePgURL;
import com.weizu.web.foundation.DateUtil;
import com.weizu.web.foundation.String.StringHelper;
import com.weizu.web.foundation.core.util.NumberTool;

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
	@Resource
	private RateDiscountAO rateDiscountAO;
	@Resource
	private AgencyPurchaseDao agencyPurchaseDao;
	
	
	/**
	 * @description:流量充值
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月26日 下午4:58:40
	 */
	@RequestMapping(value = ChargePgURL.PG_CHARGE)
	public ModelAndView pgCharge(HttpServletRequest request,PgChargeVO pcVO){
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		ChargeAccountPo accountPo = (ChargeAccountPo)request.getSession().getAttribute("chargeAccount");
		if(agencyVO != null){
			pcVO.setAgencyId(agencyVO.getId());
//			purchasePo.setOrderArriveTime(System.currentTimeMillis());
//			ChargeAccountPo accountPo = (ChargeAccountPo)request.getSession().getAttribute("chargeAccount");
//			if(purchasePo.getBillType()==BillTypeEnum.BUSINESS_INDIVIDUAL.getValue())
//			{
//				accountPo = (ChargeAccountPo)request.getSession().getAttribute("chargeAccount");
//			}else if(purchasePo.getBillType()==BillTypeEnum.CORPORATE_BUSINESS.getValue())
//			{
//				accountPo = (ChargeAccountPo)request.getSession().getAttribute("chargeAccount1");
//			}
			if(pcVO.getOrderAmount() > accountPo.getAccountBalance()){//订单价格大于余额
				return pg_charge_page("余额不足，充值失败");
			}
			Integer purResult = purchaseAO.purchase(pcVO);
			if(purResult == OrderResultEnum.SUCCESS.getCode())
			{
				return purchaseList(request, new PurchaseVO(), "");
			}else{//重新选择通道充值
				return pg_charge_page("系统错误，充值失败");
			}
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
	public void pgList_forPurchase(HttpServletRequest request, HttpServletResponse response,String operatorName,String serviceType) throws UnsupportedEncodingException{
		OperatorPgDataPo oppo = new OperatorPgDataPo();
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
//		for (OperatorTypeEnum typeEnum : OperatorTypeEnum.values()) {
//			if(operatorType.contains(typeEnum.getDesc())){//中国移动包涵移动
//				oppo.setOperatorType(typeEnum.getValue());
//			}
//		}
//		operatorName = new String(operatorName.getBytes("iso-8859-1"), "utf-8");
		String carrier = operatorName.trim();//江西移动
		int sLength = carrier.length();
		List<OperatorPgDataPo> list = new ArrayList<OperatorPgDataPo>();
		if(sLength>2){
			String scopeCityName = carrier.substring(0,sLength-2);//地区参数
			if(agencyVO != null){
				boolean isAccept = rateDiscountAO.checkScopeIsAccept(agencyVO.getId(), scopeCityName);
				if(isAccept){//如果包涵该地区，就加载包体列表
					String oType = carrier.substring(sLength-2,sLength); //获得operatorType:运营商类型参数，移动
					int opType = OperatorTypeEnum.getValueByDesc(oType);//运营商类型
					oppo.setOperatorType(opType);
//					oppo.setOperatorName(carrier);
					oppo.setServiceType(Integer.parseInt(serviceType.trim()));
					list = operatorPgAO.pgList_forPurchase(oppo,ScopeCityEnum.getValueByDesc(scopeCityName), agencyVO.getId());
				}
			}
		}
		try {
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print(JSON.toJSONString(list));
			System.out.println(JSON.toJSONString(list));
		} catch (IOException e) {
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
	public ModelAndView pg_charge_page(@RequestParam(value="msg",required=false)String msg){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("serviceTypeEnum", ServiceTypeEnum.toList());
		
		return new ModelAndView("/trade/pg_charge_page","resultMap",resultMap);
	}
	
	/**
	 * @description: 获得流量充值的采购金额(通道)
	 * @param dataPo
	 * @param purchasePo
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月10日 下午4:24:29
	 */
//	@RequestMapping(value= ChargePgURL.AJAX_PURCHASE_PRICE)
//	public void ajaxPurchassPrice(HttpServletRequest request, OperatorPgDataPo dataPo,String carrier,HttpServletResponse response){
//		try {
//			AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
////			carrier = new String(carrier.getBytes("iso-8859-1"),"utf-8");
//			
//			int pgSize = dataPo.getPgSize();
//			int serviceType = dataPo.getServiceType();
//			Map<String, Object> scopeCityMap = PurchaseUtil.getScopeCityByCarrier(carrier);
//			String scopeCityCode = scopeCityMap.get("scopeCityCode").toString();//地区编码
//			String scopeCityName = scopeCityMap.get("scopeCityName").toString();//地区名
//			int operatorType = -1;//运营商类型
//			for (Map<String,Object> map  : OperatorTypeEnum.toList()) {
//				if(carrier != null){
//					System.out.println(carrier);
//					if (carrier.contains(map.get("desc").toString())) {
//						operatorType = Integer.parseInt(map.get("value").toString()) ;
//						break;
//					}
//				}
//			}
//			Map<String, Object> resultMap = new HashMap<String, Object>();
//			if(agencyVO != null){
//				OperatorScopeVO operatorScopeVO = new OperatorScopeVO(scopeCityName,agencyVO.getId(),operatorType);
//				BestChannelPO bestChannel = channelForwardAO.getBestChannel(operatorScopeVO);
//				if(bestChannel != null){
//					if(productCodeAO.getOneProductCode(new OneCodePo(scopeCityCode, pgSize, operatorType, serviceType, bestChannel.getEpd())) != null)
//					{
//						//并且存在该包体编码dataPo.getPgPrice() * bestChannel.getChannelDiscount()
//						resultMap.put("price", NumberTool.mul(dataPo.getPgPrice(),bestChannel.getChannelDiscount()));
//						resultMap.put("channelId", bestChannel.getChanneld());
//						resultMap.put("billType", bestChannel.getBillType());
//						response.getWriter().print(JSON.toJSONString(resultMap));
//					}else{//編碼不存在
//						resultMap.put("price", dataPo.getPgPrice());
//						response.getWriter().print(JSON.toJSONString(resultMap));
////						response.getWriter().print(dataPo.getPgPrice());
//					}
//				}else{//沒有該地區的最优通道
//					response.getWriter().print(dataPo.getPgPrice());
//				}
//			}
//			
//		} catch (UnsupportedEncodingException e1) {
//			e1.printStackTrace();
//		}catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	/**
	 * @description: 获得流量充值的采购金额(费率)
	 * @param request
	 * @param dataPo
	 * @param carrier
	 * @param response
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年8月2日 上午10:55:16
	 */
	@RequestMapping(value= ChargePgURL.AJAX_PURCHASE_PRICE)
	public void ajaxPurchassPrice(HttpServletRequest request, Double pgPrice, Integer serviceType,String carrier,HttpServletResponse response){
		try {
			AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
//			carrier = new String(carrier.getBytes("iso-8859-1"),"utf-8");
			
//			int pgSize = dataPo.getPgSize();
//			int serviceType = dataPo.getServiceType();
//			
//			int sLength = carrier.length();
//			String oType = carrier.substring(sLength-2,sLength); //获得operatorType:运营商类型参数，移动
//			String scopeCityName = carrier.substring(0,sLength-2);
//			int opType = OperatorTypeEnum.getValueByDesc(oType);//运营商类型
//			String scopeCityCode = ScopeCityEnum.getValueByDesc(scopeCityName);
//			Map<String, Object> scopeCityMap = PurchaseUtil.getScopeCityByCarrier(carrier);
//			String scopeCityCode = scopeCityMap.get("scopeCityCode").toString();//地区编码
//			String scopeCityName = scopeCityMap.get("scopeCityName").toString();//地区名
//			int operatorType = -1;//运营商类型
//			for (Map<String,Object> map  : OperatorTypeEnum.toList()) {
//				if(carrier != null){
//					System.out.println(carrier);
//					if (carrier.contains(map.get("desc").toString())) {
//						operatorType = Integer.parseInt(map.get("value").toString()) ;
//						break;
//					}
//				}
//			}
			Map<String, Object> resultMap = new HashMap<String, Object>();
			if(agencyVO != null){
				RateDiscountPo ratePo = rateDiscountAO.getRateForCharge(serviceType, carrier, agencyVO.getId());
				if(pgPrice != null && ratePo != null){//判断余额
					Double purchasePrice = NumberTool.mul(pgPrice, ratePo.getActiveDiscount());//利率后的价格
					ChargeAccountPo account1 = (ChargeAccountPo)request.getSession().getAttribute("chargeAccount");
					if(account1.getAccountBalance() >= purchasePrice){//可以扣款，提单，充值
						resultMap.put("price", purchasePrice);
						resultMap.put("rateDiscountId", ratePo.getId());			//	折扣id
						//resultMap.put("billTypeRate", ratePo.getBillType());		//折扣票务类型
//						resultMap.put("msg", OrderStateEnum);//欠费等待
//						resultMap.put("billType", bestChannel.getBillType());
//						response.getWriter().print(JSON.toJSONString(resultMap));
					}else{
						resultMap.put("price", pgPrice);
						resultMap.put("msg", ChargeStatusEnum.LACK_OF_BALANCE.getValue());//欠费等待
					}
					resultMap.put("channelId", ratePo.getChannelId());
					resultMap.put("rateDiscount", ratePo.getActiveDiscount());	//折扣
					response.getWriter().print(JSON.toJSONString(resultMap));
				}
				
				
//				OperatorScopeVO operatorScopeVO = new OperatorScopeVO(scopeCityName,agencyVO.getId(),operatorType);
//				BestChannelPO bestChannel = channelForwardAO.getBestChannel(operatorScopeVO);
//				if(bestChannel != null){
//					if(productCodeAO.getOneProductCode(new OneCodePo(scopeCityCode, pgSize, operatorType, serviceType, bestChannel.getEpd())) != null)
//					{
//						//并且存在该包体编码dataPo.getPgPrice() * bestChannel.getChannelDiscount()
//						resultMap.put("price", NumberTool.mul(dataPo.getPgPrice(),bestChannel.getChannelDiscount()));
//						resultMap.put("channelId", bestChannel.getChanneld());
//						resultMap.put("billType", bestChannel.getBillType());
//						response.getWriter().print(JSON.toJSONString(resultMap));
//					}else{//編碼不存在
//						resultMap.put("price", dataPo.getPgPrice());
//						response.getWriter().print(JSON.toJSONString(resultMap));
////						response.getWriter().print(dataPo.getPgPrice());
//					}
//				}else{//沒有該地區的最优通道
//					response.getWriter().print(dataPo.getPgPrice());
//				}
			}
		} 
		catch (UnsupportedEncodingException e1) {
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
			//充值成功使用充值时间
			if(purchaseVO.getOrderResult() != null && purchaseVO.getOrderResult() == OrderStateEnum.CHARGED.getValue()){
				purchaseVO.setBackStartTimeStr(DateUtil.formatAll(DateUtil.getStartTime()));
				purchaseVO.setBackEndTimeStr(DateUtil.formatAll(DateUtil.getEndTime()));
			}else{//其他状态使用到达时间
				purchaseVO.setArriveStartTimeStr(DateUtil.formatAll(DateUtil.getStartTime()));
				purchaseVO.setArriveEndTimeStr(DateUtil.formatAll(DateUtil.getEndTime()));
			}
			pageParam = new PageParam(1, 10);
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Pagination<PurchaseVO> pagination = purchaseAO.getPurchase(purchaseVO, pageParam);
		resultMap.put("pagination", pagination);
		resultMap.put("searchParams", purchaseVO);
		resultMap.put("operatorTypeEnums", OperatorTypeEnum.toList());
		resultMap.put("billTypeEnums", BillTypeEnum.toList());
		resultMap.put("orderPathEnums", OrderPathEnum.toList());
		resultMap.put("orderStateEnums", OrderStateEnum.toList());
		ModelAndView model = new ModelAndView("/trade/purchase_list", "resultMap", resultMap);
		if(purchaseVO.getOrderResult() == null){
			return model;
		}else{
			switch (purchaseVO.getOrderResult()) {
			case 0://充值失败
				model = new ModelAndView("/trade/charge_failure_list", "resultMap", resultMap);
				break;
			case 1://充值成功
				model = new ModelAndView("/trade/charge_success_list", "resultMap", resultMap);
				break;
			case 2://充值进行
				model = new ModelAndView("/trade/charging_list", "resultMap", resultMap);
				break;
			case 3://待充
				model = new ModelAndView("/trade/charge_wait_list", "resultMap", resultMap);
				break;
			default:
				break;
			}
		}
		
		return model;
	}
	
	/**
	 * @description: 推送订单状态
	 * @param orderId
	 * @param orderResult
	 * @param orderResultDetail
	 * @param response
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年8月5日 下午6:06:13
	 */
	@RequestMapping(value=ChargePgURL.UPDATE_PURCHASE_STATE)
	@ResponseBody
	public void updatePurchaseState(Long orderId,Integer orderResult, String orderResultDetail,HttpServletResponse response){
		int updateRes = agencyPurchaseDao.batchUpdateState(orderId, orderResult, orderResultDetail);
		response.setContentType("text/html;charset=utf-8");
		try {
			if(updateRes > 0)
			{
				response.getWriter().print("success");
			}else{
				response.getWriter().print("error");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @description: 批量充值页面
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月26日 下午4:58:54
	 */
	@RequestMapping(value=ChargePgURL.PG_BATCH_CHARGE_PAGE)
	public ModelAndView pgBatchPurchasePage(){
		return new ModelAndView("/trade/pg_batch_charge_page");
	}
	@RequestMapping(value = ChargePgURL.TEL_BATCH_IMPORT_TXT, method = RequestMethod.POST)
	@ResponseBody
	public void importTelBatch(HttpServletRequest request, MultipartFile uploadFile,HttpServletResponse response)
	{
//		BaseEmployeeLoginContext context = (BaseEmployeeLoginContext) request.getSession().getAttribute(BaseEmployeeLoginContext.LOGIN_CONTEXT_NAME);

		try
		{
			if (uploadFile != null && !uploadFile.isEmpty())
			{
				long size = uploadFile.getSize();
				System.out.println(size);
//				byte[] data = new byte[(int) size];
				InputStream input = uploadFile.getInputStream();
				
				InputStreamReader isr = new InputStreamReader(input);
				BufferedReader br = new BufferedReader(isr);
				 String line="";
//			        String[] arrs=null;
				 StringBuffer sb = new StringBuffer();
		        while ((line=br.readLine())!=null) {
		        	sb.append(line);
		        	sb.append(" ");
//			            arrs=line.split(",");
//			            arrs=line;
//			            System.out.println(arrs[0] + " : " + arrs[1] + " : " + arrs[2]);
		        }
			        br.close();
			        isr.close();
//			        fis.close();
				
//				input.read(data);
//				File folder = new File(request.getSession().getServletContext().getRealPath("/") + "telTxt/");
//				if (!folder.exists())
//				{
//					folder.mkdir();
//				}
				String uploadFileName = uploadFile.getOriginalFilename();
				String ExName = uploadFileName.substring(uploadFileName.lastIndexOf("."), uploadFileName.length());
//				File outFile = new File(request.getSession().getServletContext().getRealPath("/") + "telTxt/" + context.getLoginUID() + ExName);
//				
//				if (!outFile.exists())
//				{
//					outFile.createNewFile();
//				}
//				FileOutputStream outStream = new FileOutputStream(outFile);

//				outStream.write(data);
//				outStream.close();
				input.close();
				response.getWriter().print(sb.toString());
//				returnMessage = invoiceAccountAO.importPreInvoiceAccount(outFile, context.getLoginName(), context.getLoginUID());
			}
		}
		catch (IOException e)
		{
//			returnMessage = MgtConstants.MSG_PROGRAM_EXCEPTION_IMPORT_ERROR;
			e.printStackTrace();
		}
//		Map<String, Object> returnMap = new HashMap<String, Object>(2);
//		returnMap.put("message", returnMessage);
//		returnMap.put("refererURL", InvoiceAccountURL.MODEL_NAME + InvoiceAccountURL.INVOICE_ACCOUNT_LIST);
//		return new ModelAndView("success", "map", returnMap);
	}
}
