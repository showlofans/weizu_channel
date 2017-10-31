package com.weizu.flowsys.web.trade.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.weizu.flowsys.core.util.NumberTool;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelTypeEnum;
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.OrderPathEnum;
import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
import com.weizu.flowsys.operatorPg.enums.PgTypeEnum;
import com.weizu.flowsys.operatorPg.enums.PgValidityEnum;
import com.weizu.flowsys.operatorPg.enums.ScopeCityEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.util.ClassUtil;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.ao.RateDiscountAO;
import com.weizu.flowsys.web.activity.dao.RateDiscountDao;
import com.weizu.flowsys.web.activity.pojo.RateDiscountPo;
import com.weizu.flowsys.web.agency.ao.AgencyAO;
import com.weizu.flowsys.web.agency.ao.ChargeAccountAo;
import com.weizu.flowsys.web.agency.dao.ChargeAccountDaoInterface;
import com.weizu.flowsys.web.agency.dao.impl.ChargeAccountDao;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.channel.ao.OperatorPgAO;
import com.weizu.flowsys.web.channel.ao.ProductCodeAO;
import com.weizu.flowsys.web.channel.dao.ChannelChannelDao;
import com.weizu.flowsys.web.channel.dao.ChannelDiscountDao;
import com.weizu.flowsys.web.channel.pojo.ChannelDiscountPo;
import com.weizu.flowsys.web.channel.pojo.ChargeChannelParamsPo;
import com.weizu.flowsys.web.channel.pojo.ChargeChannelPo;
import com.weizu.flowsys.web.channel.pojo.OperatorPgDataPo;
import com.weizu.flowsys.web.channel.pojo.PgDataPo;
import com.weizu.flowsys.web.channel.pojo.SpecialCnelType;
import com.weizu.flowsys.web.channel.pojo.SpecialOpdType;
import com.weizu.flowsys.web.channel.pojo.SuperPurchaseParam;
import com.weizu.flowsys.web.trade.PurchaseUtil;
import com.weizu.flowsys.web.trade.ao.AccountPurchaseAO;
import com.weizu.flowsys.web.trade.ao.PurchaseAO;
import com.weizu.flowsys.web.trade.pojo.PgChargeVO;
import com.weizu.flowsys.web.trade.pojo.PurchaseVO;
import com.weizu.flowsys.web.trade.pojo.TotalResult;
import com.weizu.flowsys.web.trade.url.ChargePgURL;
import com.weizu.web.foundation.String.StringHelper;

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
//	@Resource
//	private ChannelForwardAO channelForwardAO;
	@Resource
	private ProductCodeAO productCodeAO;
	@Resource
	private PurchaseAO purchaseAO;
//	@Resource
//	private PurchaseDao purchaseDAO;
	
	@Resource
	private RateDiscountAO rateDiscountAO;
	@Resource
	private RateDiscountDao rateDiscountDao;
	
	@Resource
	private AccountPurchaseAO agencyPurchaseAO;
	@Resource
	private AgencyAO agencyAO;
	@Resource
	private ChannelChannelDao channelChannelDao;
	
	@Resource
	private ChannelDiscountDao channelDiscountDao;
	@Resource
	private ChargeAccountAo chargeAccountAO;
//	@Resource
//	private ChannelDiscountAO channelDiscountAO;
	/**
	 * @description:获得流量包购买列表
	 * @param response
	 * @param operatorType
	 * @author:POP产品研发部 宁强
	 * @throws UnsupportedEncodingException 
	 * @createTime:2017年5月31日 下午12:04:22
	 */
	@RequestMapping(value=ChargePgURL.PG_CHARGE_PAGE)
	public ModelAndView pg_charge_page(@RequestParam(value="msg",required=false)String msg,HttpServletRequest request){
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		Map<String,Object> resultMap = new HashMap<String,Object>();
		if(agencyVO != null){
			if(agencyVO.getRootAgencyId() != 0){
				List<SpecialCnelType> specialCnelList = channelChannelDao.getSpecialCnelType(ChannelTypeEnum.ORDINARY.getValue());
				
				List<SpecialOpdType> specialOpdList = channelChannelDao.getSpecialOpdType(new SpecialOpdType(PgTypeEnum.PGDATA.getValue(), PgValidityEnum.MONTH_DAY_DATA.getValue()));
				
				List<Long> agnecyCnelList = rateDiscountDao.getChannelByAgency(agencyVO.getId());
				
				resultMap.put("pgTypeEnums", PgTypeEnum.toSpecialList(specialOpdList, agnecyCnelList));					//
				resultMap.put("pgValidityEnums", PgValidityEnum.toSpecialList(specialOpdList, agnecyCnelList));			//
				resultMap.put("channelTypeEnums", ChannelTypeEnum.toSpecialList(specialCnelList, agnecyCnelList));		//
			}else{
				resultMap.put("pgTypeEnums", PgTypeEnum.toList());					//
				resultMap.put("pgValidityEnums", PgValidityEnum.toList());			//
				resultMap.put("channelTypeEnums", ChannelTypeEnum.toList());		//
			}
			
			resultMap.put("serviceTypeEnum", ServiceTypeEnum.toList());
//		Map<String,Object> params = new HashMap<String,Object>();
			resultMap.put("pageMsg", msg);
			return new ModelAndView("/trade/pg_charge_page","resultMap",resultMap);
		}else{
			return new ModelAndView("error", "errorMsg", "当前登录用户不合法");
		}
	}
	/** 
	 * @description: 充值页面异步获得充值通道
	 * <br>页面： pg_charge_page
	 * @param ccpp
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月28日 下午3:58:05
	 */
	@ResponseBody
	@RequestMapping(value=ChargePgURL.AJAX_CHARGE_CHANNEL)
	public String ajaxChargeChannel(ChargeChannelParamsPo ccpp){
		List<ChargeChannelPo> chargeList = purchaseAO.ajaxChargeChannel(ccpp);
		String listJsonStr = JSON.toJSONString(chargeList);
		return listJsonStr;
	}
	
	/**
	 * @description:页面单个流量充值
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月26日 下午4:58:40
	 */
	@RequestMapping(value = ChargePgURL.PG_CHARGE)
	public ModelAndView pgCharge(HttpServletRequest request,PgChargeVO pcVO){
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(agencyVO != null){
//			String scopeCityCode = ScopeCityEnum.QG.getValue();
//			if(!pcVO.getServiceType().equals(ServiceTypeEnum.NATION_WIDE.getValue())){
//				Map<String,Object> scopeMap = PurchaseUtil.getScopeCityByCarrier(pcVO.getChargeTelDetail());
//				scopeCityCode = scopeMap.get("scopeCityCode").toString();
//			}
			ChargeAccountPo accountPo = null;
			if(!agencyVO.getRootAgencyId().equals(0)){
				RateDiscountPo ratePo = rateDiscountDao.get(pcVO.getRateId());
				if(ratePo != null){
					accountPo = chargeAccountAO.getAccountByAgencyId(agencyVO.getId(), ratePo.getBillType());
				}
			}else{//超管测试通道，通过通道折扣提单
				ChannelDiscountPo cdPo = channelDiscountDao.get(pcVO.getCdisId());//new WherePrams("channel_id", "=", pcVO.getChannelId()).and("scope_city_code", "=", scopeCityCode)
				if(cdPo!=null && cdPo.getBillType().equals(BillTypeEnum.BUSINESS_INDIVIDUAL.getValue())){
					accountPo = chargeAccountAO.getAccountByAgencyId(agencyVO.getId(), cdPo.getBillType());
				}
			}
			boolean isAccess = agencyAO.checkIdByPass(agencyVO.getId(), agencyVO.getUserPass());
			if(!isAccess || !agencyVO.getId().equals(accountPo.getAgencyId())){
				return new ModelAndView("error", "errorMsg", "当前登陆用户不合法");
			}
			pcVO.setAccountId(accountPo.getId());
			pcVO.setFromAgencyName(agencyVO.getUserName());
//			purchasePo.setOrderArriveTime(System.currentTimeMillis());
//			ChargeAccountPo accountPo = (ChargeAccountPo)request.getSession().getAttribute("chargeAccount");
//			if(purchasePo.getBillType()==BillTypeEnum.BUSINESS_INDIVIDUAL.getValue())
//			{
//				accountPo = (ChargeAccountPo)request.getSession().getAttribute("chargeAccount");
//			}else if(purchasePo.getBillType()==BillTypeEnum.CORPORATE_BUSINESS.getValue())
//			{
//				accountPo = (ChargeAccountPo)request.getSession().getAttribute("chargeAccount1");
//			}
			Map<String, Object> resultMap = new HashMap<String, Object>();
			String pageMsg = "";
			String referURL = "";
			pageMsg = purchaseAO.purchase(pcVO, accountPo);
			referURL = "/flowsys/chargePg/purchase_list.do?orderResult=2";
			resultMap.put("referURL", referURL);
			resultMap.put("pageMsg", pageMsg);
			return new ModelAndView("/trade/charge_result_page", "resultMap", resultMap);
		}
		return new ModelAndView("error", "errorMsg", "系统维护之后，用户未登陆！！");
	}
	
	/**
	 * @description:ajax获得流量购买所需的数据
	 * @param tel
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月26日 下午5:49:56
	 */
//	@RequestMapping(value = ChargePgURL.AJAX_PURCHASE_PG)
//	public ModelAndView ajaxGetPurchasePg(String tel){
//		
//		return null;
//	}
	/**
	 * @description:获得流量包购买列表
	 * @param response
	 * @param operatorType
	 * @author:POP产品研发部 宁强
	 * @throws UnsupportedEncodingException 
	 * @createTime:2017年5月31日 下午12:04:22
	 */
	@ResponseBody
	@RequestMapping(value=ChargePgURL.PGLIST_FORPURCHASE)
	public String pgList_forPurchase(HttpServletRequest request, HttpServletResponse response,
			ChargeChannelParamsPo ccpp) throws UnsupportedEncodingException{
//		OperatorPgDataPo oppo = new OperatorPgDataPo();
//		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		ChargeAccountPo accountPo = (ChargeAccountPo)request.getSession().getAttribute("chargeAccount");//用不带票账户充值
		String carrier = ccpp.getCarrier();//江西移动
		int sLength = carrier.length();
//		List<OperatorPgDataPo> list = new ArrayList<OperatorPgDataPo>();
		if(sLength>2){
//			if(sLength>2 && agencyVO != null){
//			List<PgDataPo> pgList = rateDiscountAO.getPgListForPurchase(ccpp, agencyVO.getId(), true);
//			String listJsonStr = JSON.toJSONString(pgList);
////		System.out.println(listJsonStr);
//			return listJsonStr;
			String scopeCityName = carrier.substring(0,sLength-2);//地区参数
			if(accountPo != null){
				Integer accountId = accountPo.getId();
				boolean isAccept = rateDiscountAO.checkScopeIsAccept(accountId, scopeCityName);
				if(isAccept){//如果包涵该地区，就加载包体列表
//					String oType = carrier.substring(sLength-2,sLength); //获得operatorType:运营商类型参数，移动
//					int opType = OperatorTypeEnum.getValueByDesc(oType);//运营商类型
//					oppo.setOperatorType(opType);
//					oppo.setOperatorName(carrier);
//					if(StringHelper.isEmpty(serviceType)){
//						
//					}
//					int sType = Integer.parseInt(serviceType.trim());
					RateDiscountPo ratePo = rateDiscountAO.getRateForCharge(ccpp, accountId,false);//获得对私的充值费率
//					oppo.setServiceType(sType);
					if(ratePo != null){
						ChargeChannelParamsPo ccpp1 = new ChargeChannelParamsPo(carrier, ccpp.getServiceType(), ratePo.getChannelId());
//						ccpp.setBillType(BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
						List<PgDataPo> pgList = purchaseAO.getPgByChanel(ratePo.getChannelId());
						Double activeDiscount = ratePo.getActiveDiscount();
						Long channelId = ratePo.getChannelId();
						List<OperatorPgDataPo> chargeList = initByPgList(pgList);
						for (OperatorPgDataPo operatorPgDataPo : chargeList) {//初始化第一个折扣，折扣id和包体价格
							operatorPgDataPo.setRteId(ratePo.getId());
							operatorPgDataPo.setRteDis(activeDiscount);
							operatorPgDataPo.setChannelId(channelId);
							operatorPgDataPo.setPgDiscountPrice(NumberTool.mul(activeDiscount, operatorPgDataPo.getPgPrice()));
						}
						String listJsonStr = JSON.toJSONString(chargeList);
//						System.out.println(listJsonStr);
						return listJsonStr;
					}else{
						System.out.println("没有找到该地区费率");
					}
				}
			}
		}
		return "";
//		Map<String,Object> map = new HashMap<String, Object>();
//		map.put("pgList", list);
////		map.put("ratePo", rateDiscountPo);
//		try {
//			response.setContentType("text/html;charset=UTF-8");
//			response.getWriter().print(JSON.toJSONString(map));
//			System.out.println(JSON.toJSONString(list));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	/**
	 * @description: 把pgData换成oeratorPgDataPo
	 * @param pgList
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月26日 上午11:25:32
	 */
	private List<OperatorPgDataPo> initByPgList(List<PgDataPo> pgList) {
		List<OperatorPgDataPo> dataList = new LinkedList<OperatorPgDataPo>();
		for (PgDataPo pgDataPo : pgList) {
			dataList.add(new OperatorPgDataPo(pgDataPo.getId(), pgDataPo.getOperatorType(), pgDataPo.getOperatorName(), pgDataPo.getPgSize(), pgDataPo.getPgPrice(), pgDataPo.getPgName(), pgDataPo.getPgInService(), pgDataPo.getServiceType(), pgDataPo.getPgType(), pgDataPo.getPgValidity(),pgDataPo.getCirculateWay()));
		}
		return dataList;
	}

	@RequestMapping(value=ChargePgURL.PGLIST_SUPER_FORPURCHASE)
	public void pgList_super_forPurchase(HttpServletRequest request, HttpServletResponse response,String operatorName,String serviceType,String epEngId) throws UnsupportedEncodingException{
//		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
//		for (OperatorTypeEnum typeEnum : OperatorTypeEnum.values()) {
//			if(operatorType.contains(typeEnum.getDesc())){//中国移动包涵移动
//				oppo.setOperatorType(typeEnum.getValue());
//			}
//		}
//		operatorName = new String(operatorName.getBytes("iso-8859-1"), "utf-8");
		String carrier = operatorName.trim();//江西移动
		int sLength = carrier.length();
		List<OperatorPgDataPo> list = new ArrayList<OperatorPgDataPo>();
//		RateDiscountPo rateDiscountPo = null;
		Map<String,Object> map = new HashMap<String, Object>();
		if(sLength>2){
//			String scopeCityName = carrier.substring(0,sLength-2);//地区参数
//			Map<String,Object> scopeMap = PurchaseUtil.getScopeCityByCarrier(carrier);
//			String scopeCityCode = scopeMap.get("scopeCityCode").toString();
//			int sType = Integer.parseInt(serviceType.trim());
//			String oType = carrier.substring(sLength-2,sLength); //获得operatorType:运营商类型参数，移动
//			int opType = OperatorTypeEnum.getValueByDesc(oType);
			
			map = operatorPgAO.getBy(new SuperPurchaseParam(carrier, serviceType, epEngId));
			
//			if(agencyVO != null){
//				Integer contextId = agencyVO.getId();
//				boolean isAccept = rateDiscountAO.checkScopeIsAccept(contextId, scopeCityName);
//				if(isAccept){//如果包涵该地区，就加载包体列表
//					String oType = carrier.substring(sLength-2,sLength); //获得operatorType:运营商类型参数，移动
//					int opType = OperatorTypeEnum.getValueByDesc(oType);//运营商类型
//					oppo.setOperatorType(opType);
////					oppo.setOperatorName(carrier);
//					int sType = Integer.parseInt(serviceType.trim());
//					oppo.setServiceType(sType);
//					rateDiscountPo = rateDiscountAO.getRateForCharge(sType, carrier, contextId);
//				}
//			}
		}
		try {
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print(JSON.toJSONString(map));
//			System.out.println(JSON.toJSONString(list));
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	public void ajaxPurchassPrice(HttpServletRequest request, Double pgPrice, ChargeChannelParamsPo ccpp,HttpServletResponse response){
		try {
//			AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
			ChargeAccountPo accountPo = (ChargeAccountPo)request.getSession().getAttribute("chargeAccount");//用不带票账户充值
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
			if(accountPo != null){
				RateDiscountPo ratePo = rateDiscountAO.getRateForCharge(ccpp, accountPo.getId(), false);//获得对私的充值费率
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
	 * @description: 异步获得充值包体列表
	 * @param ccpp
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月29日 上午9:14:43
	 */
	@ResponseBody
	@RequestMapping(value=ChargePgURL.AJAX_CHARGE_PG)
	public String ajaxChargePg(ChargeChannelParamsPo ccpp){
		List<PgDataPo> chargeList = purchaseAO.getPgByChanel(ccpp);
		String listJsonStr = JSON.toJSONString(chargeList);
//		System.out.println(listJsonStr);
		return listJsonStr;
	}
	
	/**
	 * @description: 查询订单列表
	 * @param request
	 * @param purchaseVO
	 * @param pageNo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @throws CloneNotSupportedException 
	 * @createTime:2017年6月13日 下午1:20:59
	 */
	@SuppressWarnings("restriction")
	@RequestMapping(value = ChargePgURL.PURCHASE_LIST)
	public ModelAndView purchaseList(HttpServletRequest request, PurchaseVO purchaseVO, @RequestParam(value="pageNoLong",required=false)Long pageNoLong){
		HttpSession httpSession = request.getSession();
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)httpSession.getAttribute("loginContext");
		if(agencyVO != null){
			purchaseVO.setAgencyId(agencyVO.getId());//设置为当前登陆用户的订单
		}else{
			return new ModelAndView("error", "errorMsg", "系统维护之后，用户未登陆！！");
		}
		PageParam pageParam = null;
		Pagination<PurchaseVO> pagination = null;
		if(pageNoLong != null){
			pageParam = new PageParam(pageNoLong, 10) ;
		}else{//初始化开始时间和结束时间
			
			pageParam = new PageParam(1l, 10);
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		pagination = purchaseAO.getPurchase(resultMap,purchaseVO, pageParam);//
		resultMap.put("pagination", pagination);
		resultMap.put("operatorTypeEnums", OperatorTypeEnum.toList());
		resultMap.put("billTypeEnums", BillTypeEnum.toList());
		resultMap.put("orderPathEnums", OrderPathEnum.toList());
		resultMap.put("orderStateEnums", OrderStateEnum.toList());
		ModelAndView model = new ModelAndView("/trade/purchase_list", "resultMap", resultMap);
		if(purchaseVO.getOrderState() == null){
			return model;
		}else{
			switch (purchaseVO.getOrderState()) {
			case 0://充值失败
				model = new ModelAndView("/trade/charge_failure_list", "resultMap", resultMap);
				break;
			case 1://充值成功
				int callTag = 0; 
				if(httpSession.getAttribute("lastSearch") == null){
					httpSession.setAttribute("lastSearch", purchaseVO);
					//没有搜索过，就可以统计一遍
					callTag = 1;
				}else{
					PurchaseVO pvo = (PurchaseVO)httpSession.getAttribute("lastSearch");
					PurchaseVO pvoC = pvo.clone();
					PurchaseVO sample = purchaseVO.clone();
					ignoreEndTime(pvoC,sample);
					if(!ClassUtil.contrastObj(pvoC, sample)){
						callTag = 1;
						//查询参数不相等，就把新的purhcaeVO放到lastSearch中
						httpSession.setAttribute("lastSearch", purchaseVO);
					}
				}
				List<PurchaseVO> records = purchaseAO.getPurchase(purchaseVO);
				if(callTag == 1 && records != null && records.size() > 0){
					System.out.println(callTag +"-开始统计总扣款");
					TotalResult tot = purchaseAO.getTotalResultFromSuccess(purchaseVO);
					Double totalCost = 0.00d;
					for (PurchaseVO purchaseVO2 : records) {
						totalCost = NumberTool.add(totalCost, purchaseVO2.getOrderAmount());
					}
					tot.setTotalCost(totalCost);
					System.out.println("总成本："+totalCost);
					httpSession.setAttribute("tot", tot);
				}
//				else{
//					httpSession.setAttribute("tot", null);
//				}
				
				
				model = new ModelAndView("/trade/charge_success_list", "resultMap", resultMap);
				break;
			case 2://充值进行
				model = new ModelAndView("/trade/charging_list", "resultMap", resultMap);
				break;
			case 4://待充
				model = new ModelAndView("/trade/charge_wait_list", "resultMap", resultMap);
				break;
			default:
				break;
			}
		}
		
		return model;
	}
	
	/**
	 * @description: 让两个对象忽略结束时间进行比较
	 * @param pvo
	 * @param purchaseVO
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月18日 上午11:21:22
	 */
	private void ignoreEndTime(PurchaseVO pvo, PurchaseVO sample) {
		boolean can = StringHelper.isNotEmpty(sample.getBackEndTimeStr()) && StringHelper.isNotEmpty(pvo.getBackEndTimeStr());
		if(can){
			String sampleEndTimeStr = sample.getBackEndTimeStr().trim();
			String pvoEndTimeStr = pvo.getBackEndTimeStr().trim();
			if(!sampleEndTimeStr.equals(pvoEndTimeStr)){
				String sampleTagTime = sampleEndTimeStr.substring(0, sampleEndTimeStr.indexOf(" "));
				String pvoTagTime = pvoEndTimeStr.substring(0, pvoEndTimeStr.indexOf(" "));
				if(sampleTagTime.equals(pvoTagTime)){
					sample.setBackEndTimeStr(sampleTagTime);
					pvo.setBackEndTimeStr(sampleTagTime);
				}
			}
		}
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
		String updateRes = agencyPurchaseAO.updatePurchaseStateByMe(orderId, orderResult, orderResultDetail,null);
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().print(updateRes);
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
	/**
	 * @description: 异步重新提交订单<br>来源：charge_wait.jsp
	 * @param request
	 * @param orderId
	 * @param accountId
	 * @param chargeTelDetail
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月14日 上午10:02:32
	 */
	@ResponseBody
	@RequestMapping(value=ChargePgURL.AJAX_COMMIT_ORDER)
	public String ajaxCommitOrder(HttpServletRequest request,Long orderId,Integer accountId,String chargeTelDetail){
//		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession() .getAttribute("loginContext");
//		ChannelDiscountPo cd = channelDiscountDao.getCDbyAP(orderId, agencyId);
//		
//		RateDiscountPo ratePo = rateDiscountAO.getRateForCharge(cd.getServiceType(), chargeTelDetail, agencyId, billTypeRate);
		String ajaxRes = purchaseAO.ajaxCommitOrder(orderId, accountId, chargeTelDetail);
		
		return ajaxRes;
	}
	/**
	 * @description: 充值等待批量提交订单
	 * @param purchaseVO
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月18日 下午4:05:52
	 */
	@ResponseBody
	@RequestMapping(value=ChargePgURL.BATCH_COMMIT_ORDER)
	public String batchCommitOrder(PurchaseVO purchaseVO){
		
		
		return "error";
	}
	
	
	
}
