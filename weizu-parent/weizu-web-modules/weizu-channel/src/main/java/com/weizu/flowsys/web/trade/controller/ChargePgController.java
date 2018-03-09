package com.weizu.flowsys.web.trade.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.core.util.NumberTool;
import com.weizu.flowsys.operatorPg.enums.AccountTypeEnum;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelTypeEnum;
import com.weizu.flowsys.operatorPg.enums.EpEncodeTypeEnum;
import com.weizu.flowsys.operatorPg.enums.EventTypeEnum;
import com.weizu.flowsys.operatorPg.enums.TelServiceTypeEnum;
import com.weizu.flowsys.operatorPg.enums.LoginStateEnum;
import com.weizu.flowsys.operatorPg.enums.OperatorNameEnum;
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.OrderPathEnum;
import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
import com.weizu.flowsys.operatorPg.enums.PgServiceTypeEnum;
import com.weizu.flowsys.operatorPg.enums.PgTypeEnum;
import com.weizu.flowsys.operatorPg.enums.PgValidityEnum;
import com.weizu.flowsys.operatorPg.enums.ScopeCityEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.operatorPg.enums.TelchargeSpeedEnum;
import com.weizu.flowsys.util.ClassUtil;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.util.StringUtil2;
import com.weizu.flowsys.web.activity.ao.RateDiscountAO;
import com.weizu.flowsys.web.activity.dao.RateDiscountDao;
import com.weizu.flowsys.web.activity.pojo.RateDiscountPo;
import com.weizu.flowsys.web.agency.ao.AgencyAO;
import com.weizu.flowsys.web.agency.ao.ChargeAccountAo;
import com.weizu.flowsys.web.agency.dao.ChargeAccountDaoInterface;
import com.weizu.flowsys.web.agency.dao.impl.ChargeAccountDao;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.channel.ao.ExchangePlatformAO;
import com.weizu.flowsys.web.channel.ao.OperatorPgAO;
import com.weizu.flowsys.web.channel.ao.ProductCodeAO;
import com.weizu.flowsys.web.channel.dao.ChannelChannelDao;
import com.weizu.flowsys.web.channel.dao.ChannelDiscountDao;
import com.weizu.flowsys.web.channel.dao.ExchangePlatformDaoInterface;
import com.weizu.flowsys.web.channel.pojo.ChannelDiscountPo;
import com.weizu.flowsys.web.channel.pojo.ChargeChannelParamsPo;
import com.weizu.flowsys.web.channel.pojo.ChargeChannelPo;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.flowsys.web.channel.pojo.OneCodePo;
import com.weizu.flowsys.web.channel.pojo.OperatorPgDataPo;
import com.weizu.flowsys.web.channel.pojo.PgDataPo;
import com.weizu.flowsys.web.channel.pojo.ProductCodePo;
import com.weizu.flowsys.web.channel.pojo.SpecialCnelType;
import com.weizu.flowsys.web.channel.pojo.SpecialOpdType;
import com.weizu.flowsys.web.channel.pojo.SuperPurchaseParam;
import com.weizu.flowsys.web.http.ao.ValiUser;
import com.weizu.flowsys.web.log.AccountEventPo;
import com.weizu.flowsys.web.log.ao.AccountEventAO;
import com.weizu.flowsys.web.log.dao.IAccountEventDao;
import com.weizu.flowsys.web.trade.PurchaseUtil;
import com.weizu.flowsys.web.trade.ao.AccountPurchaseAO;
import com.weizu.flowsys.web.trade.ao.PurchaseAO;
import com.weizu.flowsys.web.trade.pojo.PgBatchChargeVO;
import com.weizu.flowsys.web.trade.pojo.PgChargeVO;
import com.weizu.flowsys.web.trade.pojo.PurchaseVO;
import com.weizu.flowsys.web.trade.pojo.TotalResult;
import com.weizu.flowsys.web.trade.url.ChargePgURL;
import com.weizu.web.foundation.DateUtil;
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
	private AccountPurchaseAO accountPurchaseAO;
	@Resource
	private AgencyAO agencyAO;
	@Resource
	private ChannelChannelDao channelChannelDao;
	
	@Resource
	private ChannelDiscountDao channelDiscountDao;
	@Resource
	private ChargeAccountAo chargeAccountAO;
	@Resource
	private ExchangePlatformAO exchangePlatformAO;
	@Resource
	private ExchangePlatformDaoInterface exchangePlatformDao;
	@Resource
	private IAccountEventDao accountEventDao;
	@Resource
	private AccountEventAO accountEventAO;
	
	@Resource
	private ValiUser valiUser;
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
	@ResponseBody
	@RequestMapping(value = ChargePgURL.PG_CHARGE,produces = "text/text;charset=UTF-8")
	public String pgCharge(HttpServletRequest request,PgChargeVO pcVO){
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		String res = "error";
		if(agencyVO != null){
//			String scopeCityCode = ScopeCityEnum.QG.getValue();
//			if(!pcVO.getServiceType().equals(ServiceTypeEnum.NATION_WIDE.getValue())){
//				Map<String,Object> scopeMap = PurchaseUtil.getScopeCityByCarrier(pcVO.getChargeTelDetail());
//				scopeCityCode = scopeMap.get("scopeCityCode").toString();
//			}
			ChargeAccountPo accountPo = null;
			Long channelId = null;
			if(!agencyVO.getRootAgencyId().equals(0)){
				RateDiscountPo ratePo = rateDiscountDao.get(pcVO.getRateId());
				if(ratePo != null){
					accountPo = chargeAccountAO.getAccountByAgencyId(agencyVO.getId(), ratePo.getBillType());
					channelId = ratePo.getChannelId();
				}
			}else{//超管测试通道，通过通道折扣提单
				ChannelDiscountPo cdPo = channelDiscountDao.get(pcVO.getCdisId());//new WherePrams("channel_id", "=", pcVO.getChannelId()).and("scope_city_code", "=", scopeCityCode)
				if(cdPo!=null && cdPo.getBillType().equals(BillTypeEnum.BUSINESS_INDIVIDUAL.getValue())){
					accountPo = chargeAccountAO.getAccountByAgencyId(agencyVO.getId(), cdPo.getBillType());
					channelId = cdPo.getChannelId();
				}
			}
			boolean isAccess = agencyAO.checkIdByPass(agencyVO.getId(), agencyVO.getUserPass());
			if(!isAccess || !agencyVO.getId().equals(accountPo.getAgencyId())){
				res = "当前登陆用户不合法";
//				return new ModelAndView("error", "errorMsg", "当前登陆用户不合法");
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
//			Map<String, Object> resultMap = new HashMap<String, Object>();
//			String pageMsg = "";
//			String referURL = "";
			pcVO.setChannelId(channelId);
			
			//充值
			pcVO.setChargeFor(PgServiceTypeEnum.PGCHARGE.getValue());
			res = purchaseAO.purchase(pcVO, accountPo);
//			referURL = "/flowsys/chargePg/purchase_list.do?orderResult=2";
//			resultMap.put("referURL", referURL);
//			resultMap.put("pageMsg", pageMsg);
//			return new ModelAndView("/trade/charge_result_page", "resultMap", resultMap);
		}
		return res;
//		return new ModelAndView("error", "errorMsg", "系统维护之后，用户未登陆！！");
	}
	/**
	 * @description: 流量包批量购买
	 * @param request
	 * @param pcVO
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月19日 下午2:08:12
	 */
	@ResponseBody
	@RequestMapping(value = ChargePgURL.PG_BATCH_CHARGE,produces = "text/text;charset=UTF-8")
	public String pgBatchCharge(HttpServletRequest request,PgBatchChargeVO pbcVO){
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		String res = "error";
		if(agencyVO != null){
			ChargeAccountPo accountPo = null;
			Long channelId = null;
			if(!agencyVO.getRootAgencyId().equals(0)){
				RateDiscountPo ratePo = rateDiscountDao.get(pbcVO.getRateId());
				if(ratePo != null){
					accountPo = chargeAccountAO.getAccountByAgencyId(agencyVO.getId(), ratePo.getBillType());
					channelId = ratePo.getChannelId();
				}
			}else{//超管测试通道，通过通道折扣提单
				ChannelDiscountPo cdPo = channelDiscountDao.get(pbcVO.getCdisId());//new WherePrams("channel_id", "=", pcVO.getChannelId()).and("scope_city_code", "=", scopeCityCode)
				if(cdPo!=null && cdPo.getBillType().equals(BillTypeEnum.BUSINESS_INDIVIDUAL.getValue())){
					accountPo = chargeAccountAO.getAccountByAgencyId(agencyVO.getId(), cdPo.getBillType());
					channelId = cdPo.getChannelId();
				}
			}
			boolean isAccess = agencyAO.checkIdByPass(agencyVO.getId(), agencyVO.getUserPass());
			if(!isAccess || !agencyVO.getId().equals(accountPo.getAgencyId())){
				res = "当前登陆用户不合法";
//				return new ModelAndView("error", "errorMsg", "当前登陆用户不合法");
			}
			Double orderAmount = NumberTool.div(pbcVO.getOrderAmount(), pbcVO.getTotalNum());
			Double chargeValue = NumberTool.div(pbcVO.getChargeValue(), pbcVO.getTotalNum());
			
			String[] chargeTelArr = pbcVO.getChargeTelArray().split(",");
//			res = "success";
			for (String chargeTel : chargeTelArr) {
				PgChargeVO pcVO = new PgChargeVO(channelId, chargeTel, pbcVO.getCarrier(), orderAmount, chargeValue, pbcVO.getPgId(), pbcVO.getServiceType(), pbcVO.getRateId(), pbcVO.getCdisId());
				pcVO.setAccountId(accountPo.getId());
				pcVO.setFromAgencyName(agencyVO.getUserName());
				//充值
				pcVO.setChargeFor(PgServiceTypeEnum.PGCHARGE.getValue());
				res = purchaseAO.purchase(pcVO, accountPo);
				if(!"success".equals(res)){//有成功的
					break;
				}
			}
		}
		return res;
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
	 * @description:代理商获得流量包购买列表
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
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
//		ChargeAccountPo accountPo = (ChargeAccountPo)request.getSession().getAttribute("chargeAccount");//用不带票账户充值
		String carrier = ccpp.getCarrier();//江西移动
		if(StringHelper.isNotEmpty(carrier) && carrier.length() > 2){
			
			String desc = carrier.substring(carrier.length()-2);
			int operatorType = OperatorTypeEnum.getValueByDesc(desc);
			ccpp.setOperatorType(operatorType);		//设置运营商类型
			
			String scopeCityCode = ScopeCityEnum.getValueByCarrier(carrier);
			//PurchaseUtil.getScopeCityByCarrier(carrier)
			
			if(StringHelper.isNotEmpty(scopeCityCode) && agencyVO != null){
				ccpp.setScopeCityCode(scopeCityCode);//设置地区编码
				
				List<PgDataPo> chargeList = operatorPgAO.pg_list_for_purchase(ccpp, agencyVO.getId());
				String listJsonStr = JSON.toJSONString(chargeList);
				return listJsonStr;
			}
		}
		
//		int sLength = carrier.length();
////		List<OperatorPgDataPo> list = new ArrayList<OperatorPgDataPo>();
//		if(sLength>2){
////			if(sLength>2 && agencyVO != null){
////			List<PgDataPo> pgList = rateDiscountAO.getPgListForPurchase(ccpp, agencyVO.getId(), true);
////			String listJsonStr = JSON.toJSONString(pgList);
//////		System.out.println(listJsonStr);
////			return listJsonStr;
//			String scopeCityName = carrier.substring(0,sLength-2);//地区参数
//			if(accountPo != null){
//				Integer accountId = accountPo.getId();
//				boolean isAccept = rateDiscountAO.checkScopeIsAccept(accountId, scopeCityName);
//				if(isAccept){//如果包涵该地区，就加载包体列表
////					String oType = carrier.substring(sLength-2,sLength); //获得operatorType:运营商类型参数，移动
////					int opType = OperatorTypeEnum.getValueByDesc(oType);//运营商类型
////					oppo.setOperatorType(opType);
////					oppo.setOperatorName(carrier);
////					if(StringHelper.isEmpty(serviceType)){
////						
////					}
////					int sType = Integer.parseInt(serviceType.trim());
//					RateDiscountPo ratePo = rateDiscountAO.getRateForCharge(ccpp, accountId,false);//获得对私的充值费率
////					oppo.setServiceType(sType);
//					if(ratePo != null){
//						ChargeChannelParamsPo ccpp1 = new ChargeChannelParamsPo(carrier, ccpp.getServiceType(), ratePo.getChannelId());
////						ccpp.setBillType(BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
//						List<PgDataPo> pgList = purchaseAO.getPgByChanel(ratePo.getChannelId());
//						Double activeDiscount = ratePo.getActiveDiscount();
//						Long channelId = ratePo.getChannelId();
//						List<OperatorPgDataPo> chargeList = initByPgList(pgList);
//						for (OperatorPgDataPo operatorPgDataPo : chargeList) {//初始化第一个折扣，折扣id和包体价格
//							operatorPgDataPo.setRteId(ratePo.getId());
//							operatorPgDataPo.setRteDis(activeDiscount);
//							operatorPgDataPo.setChannelId(channelId);
//							operatorPgDataPo.setPgDiscountPrice(NumberTool.mul(activeDiscount, operatorPgDataPo.getPgPrice()));
//						}
//						String listJsonStr = JSON.toJSONString(chargeList);
////						System.out.println(listJsonStr);
//						return listJsonStr;
//					}else{
//						System.out.println("没有找到该地区费率");
//					}
//				}
//			}
//		}
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
			dataList.add(new OperatorPgDataPo(pgDataPo.getId(), pgDataPo.getOperatorType(), pgDataPo.getOperatorName(), pgDataPo.getPgSize(), pgDataPo.getPgPrice(), pgDataPo.getPgName(), pgDataPo.getPgInService(), pgDataPo.getServiceType(), pgDataPo.getPgType(), pgDataPo.getPgValidity(),pgDataPo.getCirculateWay(),pgDataPo.getPgServiceType()));
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
	@ResponseBody
	@RequestMapping(value= ChargePgURL.AJAX_PURCHASE_PRICE)
	public String ajaxPurchassPrice(HttpServletRequest request, Double chargeValue,Integer serviceType,String carrier,Long channelId, Integer pgId, HttpServletResponse response){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(agencyVO != null){
			if(agencyVO.getRootAgencyId() == 0){//超管利用通道提测试订单
				ChannelDiscountPo cdPo = channelDiscountDao.get(new WherePrams("channel_id", "=", channelId));
				if(cdPo != null){
					Double purchasePrice = NumberTool.mul(chargeValue, cdPo.getChannelDiscount());//利率后的价格
					resultMap.put("price", purchasePrice);
					resultMap.put("cdId", cdPo.getId());			//	折扣id
					resultMap.put("billType", cdPo.getBillType());
					
					ExchangePlatformPo platformPo = exchangePlatformDao.getEpByCDiscountId(cdPo.getId());
					if(platformPo != null){
						String scopeCityCode = ScopeCityEnum.QG.getValue();
						if(serviceType != ServiceTypeEnum.NATION_WIDE.getValue()){
							scopeCityCode = ScopeCityEnum.getValueByCarrier(carrier);
						}
//						ProductCodePo code = productCodeAO.getOneProductCode(new OneCodePo(scopeCityCode, platformPo.getId(), pgId));
						ProductCodePo code = null;
						if(EpEncodeTypeEnum.WITH_CODE.equals(platformPo.getEpEncodeType())){
							code = productCodeAO.getOneProductCode(new OneCodePo(scopeCityCode, platformPo.getId(), pgId));
						}else{
							code = productCodeAO.getOneProductCodeByPg(pgId);
						}
						resultMap.put("productCode", code.getProductCode());
					}
					resultMap.put("msg", "success");
					resultMap.put("channelId", cdPo.getChannelId());
					resultMap.put("rateDiscount", cdPo.getChannelDiscount());	//折扣
					return JSON.toJSONString(resultMap);
				}
				
			}else{//不是超管
				RateDiscountPo ratePo = rateDiscountAO.getPriceByPg(pgId, agencyVO.getId(),channelId,BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
				if(ratePo != null){
					ChargeAccountPo accountPo = chargeAccountAO.getAccountByAgencyId( agencyVO.getId(), ratePo.getBillType());
					if(accountPo != null){
						Double purchasePrice = NumberTool.mul(chargeValue, ratePo.getActiveDiscount());//利率后的价格
						if(accountPo.getAccountBalance() >= purchasePrice){//可以扣款，提单，充值
							resultMap.put("price", purchasePrice);
							resultMap.put("rateDiscountId", ratePo.getId());			//	折扣id
							resultMap.put("billType", ratePo.getBillType());
							
							ExchangePlatformPo platformPo = exchangePlatformDao.getEpByCDiscountId(ratePo.getChannelDiscountId());
							if(platformPo != null){
								String scopeCityCode = ScopeCityEnum.QG.getValue();
								if(serviceType != ServiceTypeEnum.NATION_WIDE.getValue()){
									scopeCityCode = ScopeCityEnum.getValueByCarrier(carrier);
								}
//								ProductCodePo code = productCodeAO.getOneProductCode(new OneCodePo(scopeCityCode, platformPo.getId(), pgId));
								ProductCodePo code = null;
								if(EpEncodeTypeEnum.WITH_CODE.equals(platformPo.getEpEncodeType())){
									code = productCodeAO.getOneProductCode(new OneCodePo(scopeCityCode, platformPo.getId(), pgId));
								}else{
									code = productCodeAO.getOneProductCodeByPg(pgId);
								}
								if(code != null){
									resultMap.put("productCode", code.getProductCode());
									resultMap.put("channelId", ratePo.getChannelId());
									resultMap.put("rateDiscount", ratePo.getActiveDiscount());	//折扣
									resultMap.put("msg", "success");	
									
								}else{
									resultMap.put("price", chargeValue);
									resultMap.put("msg", "未配置产品编码");//
								}
							}
						}else{
							resultMap.put("price", chargeValue);
							resultMap.put("msg", ChargeStatusEnum.LACK_OF_BALANCE.getValue());//欠费等待
						}
						return JSON.toJSONString(resultMap);
					}
				}
			}
			
		}else{
			System.out.println("未登录");
		}
		return "";
			
//			ChargeAccountPo accountPo = (ChargeAccountPo)request.getSession().getAttribute("chargeAccount");//用不带票账户充值
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
//			try {
//			Map<String, Object> resultMap = new HashMap<String, Object>();
//			if(accountPo != null){
//				RateDiscountPo ratePo = rateDiscountAO.getRateForCharge(ccpp, accountPo.getId(), false);//获得对私的充值费率
//				if(chargeValue != null && ratePo != null){//判断余额
//					Double purchasePrice = NumberTool.mul(chargeValue, ratePo.getActiveDiscount());//利率后的价格
//					ChargeAccountPo account1 = (ChargeAccountPo)request.getSession().getAttribute("chargeAccount");
//					if(account1.getAccountBalance() >= purchasePrice){//可以扣款，提单，充值
//						resultMap.put("price", purchasePrice);
//						resultMap.put("rateDiscountId", ratePo.getId());			//	折扣id
//						//resultMap.put("billTypeRate", ratePo.getBillType());		//折扣票务类型
////						resultMap.put("msg", OrderStateEnum);//欠费等待
////						resultMap.put("billType", bestChannel.getBillType());
////						response.getWriter().print(JSON.toJSONString(resultMap));
//					}else{
//						resultMap.put("price", chargeValue);
//						resultMap.put("msg", ChargeStatusEnum.LACK_OF_BALANCE.getValue());//欠费等待
//					}
//					resultMap.put("channelId", ratePo.getChannelId());
//					resultMap.put("rateDiscount", ratePo.getActiveDiscount());	//折扣
//					response.getWriter().print(JSON.toJSONString(resultMap));
//				}
				
				
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
//		} 
//		catch (UnsupportedEncodingException e1) {
//			e1.printStackTrace();
//		}catch (IOException e) {
//			e.printStackTrace();
//		}
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
	public String ajaxChargePg(Long channelId){
		List<PgDataPo> chargeList = purchaseAO.getPgByChanel(channelId);
		String listJsonStr = JSON.toJSONString(chargeList);
//		System.out.println(listJsonStr);
		return listJsonStr;
	}
	/**
	 * @description: 查询订单流向的平台
	 * @param channelId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月16日 上午11:22:47
	 */
	@ResponseBody
	@RequestMapping(value=ChargePgURL.EP_IN_PURCHASE)
	public String ajaxEp(Long orderId){
//		List<PgDataPo> chargeList = purchaseAO.getPgByChanel(channelId);
//		if(StringHelper.isNotEmpty(orderId)){};
		ExchangePlatformPo epPo = exchangePlatformDao.getEpInPurchase(orderId);
		String epJsonStr = JSON.toJSONString(epPo);
//		System.out.println(listJsonStr);
		return epJsonStr;
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
		if(purchaseVO.getPurchaseFor() == null){
			purchaseVO.setPurchaseFor(PgServiceTypeEnum.PGCHARGE.getValue());
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		pagination = purchaseAO.getPurchase(resultMap,purchaseVO, pageParam);//
		resultMap.put("pagination", pagination);
		resultMap.put("operatorTypeEnums", OperatorTypeEnum.toList());
		resultMap.put("operatorNameEnums", OperatorNameEnum.toList());
		resultMap.put("telChargeSpeedEnums",  TelchargeSpeedEnum.toList());
		
		resultMap.put("billTypeEnums", BillTypeEnum.toList());
		resultMap.put("orderPathEnums", OrderPathEnum.toList());
		resultMap.put("orderStateEnums", OrderStateEnum.toList());
		resultMap.put("serviceTypeEnums", ServiceTypeEnum.toList());
		resultMap.put("huaServiceTypeEnums", TelServiceTypeEnum.toList());  //话费业务类型
		resultMap.put("pgServiceTypeEnums", PgServiceTypeEnum.toList());	//充值业务类型
		resultMap.put("pgcharge", PgServiceTypeEnum.PGCHARGE.getValue());	//充值业务类型
		
		
		ModelAndView model = new ModelAndView("/trade/purchase_list", "resultMap", resultMap);
		
		Boolean isSuper = agencyVO.getRootAgencyId() == 0;
		Boolean getBackOringinal = (purchaseVO.getOrderState() == null && !isSuper) || (purchaseVO.getOrderResult() == null && isSuper);
		
		if(getBackOringinal){//状态为空的已经鸳鸯返回了
			return model;
		}else{//状态应该都不为空
			Integer state = null;
			if(isSuper){
				state = purchaseVO.getOrderResult();
			}else{
				state = purchaseVO.getOrderState();
			}
			switch (state) {
			case 0://充值失败
				model = new ModelAndView("/trade/charge_failure_list", "resultMap", resultMap);
				break;
			case 1://充值成功
				int callTag = 0; 
				//不统计的情况：记录数一样，并且搜索条件也一样的，就不重新统计
				///需要统计的情况：记录数不一样，搜索条件不一样
				Map<String,Object> dataMap = purchaseAO.getPurchaseMap(purchaseVO);
				Long totalRecord = 0l;
				if(dataMap.get("totalRecord") != null){
					totalRecord = Long.parseLong(dataMap.get("totalRecord").toString());
				}
				Long sessionTotal = 0l;
				if(httpSession.getAttribute("sessionTotal") != null){
					sessionTotal = Long.parseLong(httpSession.getAttribute("sessionTotal").toString());
				}
				
				if(httpSession.getAttribute("lastSearch") == null){//统计最初的数据
					if(totalRecord != 0){
						httpSession.setAttribute("sessionTotal", totalRecord);
					}
					httpSession.setAttribute("lastSearch", purchaseVO);
					//没有搜索过，就可以统计一遍
					callTag = 1;
				}else{//
					PurchaseVO pvo = (PurchaseVO)httpSession.getAttribute("lastSearch");
					PurchaseVO pvoC = pvo.clone();
					PurchaseVO sample = purchaseVO.clone();
					ignoreEndTime(pvoC,sample);
					if(!ClassUtil.contrastObj(pvoC, sample) || !totalRecord.equals(sessionTotal)){//搜索参数不一样进行统计//看session中的总记录数和查出来的总记录数是否相等，不相等，就进行重新统计
						callTag = 1;
						//查询参数不相等，就把新的purhcaeVO放到lastSearch中
						httpSession.setAttribute("lastSearch", purchaseVO);
						httpSession.setAttribute("sessionTotal", totalRecord);
					}
				}
				
				if(dataMap.get("records") != null){
					List<PurchaseVO> records = (List<PurchaseVO>)dataMap.get("records");
					//进行统计
					if(callTag == 1  && records.size() > 0){
						System.out.println(callTag +"-开始统计总扣款");
						TotalResult tot = purchaseAO.getTotalResultFromSuccess(purchaseVO);
						Double totalCost = 0.00d;
//						for (PurchaseVO purchaseVO2 : records) {
//							totalCost = NumberTool.add(totalCost, purchaseVO2.getOrderAmount());
//						}
//						tot.setTotalCost(totalCost);
						System.out.println("总成本："+totalCost);
						httpSession.setAttribute("tot", tot);
					}
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
				AccountEventPo accountEventPo = accountEventAO.getLastByAgency(agencyVO.getId(), EventTypeEnum.BATCH_COMMIT_ORDER.getValue());
				if(accountEventPo != null){
					resultMap.put("batchCommitTimeStr", DateUtil.formatAll(accountEventPo.getEventTime()));
				}
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
//	@ResponseBody
	public void updatePurchaseState(Long orderId,Integer orderResult, String orderResultDetail,HttpServletResponse response){
		String updateRes = accountPurchaseAO.updatePurchaseStateByMe(orderId, orderResult, orderResultDetail,null);
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().print(updateRes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @description: 手动退款（不更新订单状态，更新订单详情）
	 * @param orderId
	 * @param orderResult
	 * @param orderResultDetail
	 * @param response
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年2月5日 上午9:21:13
	 */
	@RequestMapping(value=ChargePgURL.REFUND)
//	@ResponseBody
	public void refund(Long orderId,Integer orderResult, String orderResultDetail,HttpServletResponse response){
		String updateRes = accountPurchaseAO.refund(orderId, orderResult, orderResultDetail, System.currentTimeMillis());
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
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("serviceTypeEnums", ServiceTypeEnum.toList());
		return new ModelAndView("/trade/pg_batch_charge_page","resultMap",resultMap);
	}
	@RequestMapping(value = ChargePgURL.TEL_BATCH_IMPORT_TXT, method = RequestMethod.POST)
	@ResponseBody
	public void importTelBatch(HttpServletRequest request, MultipartFile uploadFile,HttpServletResponse response)
	{
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(agencyVO != null){
			boolean isSupperRoot = agencyVO.getRootAgencyId() == 0;
			try
			{
				if (uploadFile != null && !uploadFile.isEmpty())
				{
					String uploadFileName = uploadFile.getOriginalFilename();
//				boolean isAccess = uploadFileName.contains("10000")
					uploadFileName = uploadFileName.substring(0,uploadFileName.indexOf("."));
					String epName = "";
					if(isSupperRoot){//超管把平台部分去掉
						epName = uploadFileName.substring(0, uploadFileName.indexOf("_")) ;//超管默认第一个为提单平台名称
						uploadFileName = uploadFileName.substring(uploadFileName.indexOf("_")+1);
					}
					Map<String, Object> map = PurchaseUtil.getServiceScopeByName(uploadFileName);
					if(map == null){
						map = new HashMap<String, Object>();
//						map.put("msg", "名称不规范（江西移动_省漫游_100）");
						map.put("msg", "没有该业务类型");
					}else{//做其他判定,设定msg的值
						boolean tagOther =uploadFileName.contains("_");
						String pgSizeStr = uploadFileName.substring(uploadFileName.lastIndexOf("_")+1); 
						int pgSize = -1;
						try {
							pgSize = Integer.parseInt(pgSizeStr);
							map.put("pgSize", pgSize);
						} catch (NumberFormatException e) {
							tagOther = false;
							e.printStackTrace();
						}
						if(!tagOther){
							map.put("msg", "名称不规范（江西移动_省漫游_100）");
						}
						
						//判定号码是否与文件名一致
						InputStream input = uploadFile.getInputStream();
						
						String carrier = map.get("carrier").toString();
						int serviceType = Integer.parseInt(map.get("serviceType").toString());
						
						int operatorType = Integer.parseInt(map.get("operatorType").toString());
						ChargeAccountPo accountPo = chargeAccountAO.getAccountByAgencyId(agencyVO.getId(), BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
						PgDataPo pgData = valiUser.findPg(new PgDataPo(operatorType,  pgSize, serviceType, null,null,null));//,,,PgServiceTypeEnum.PGCHARGE.getValue()
						if(pgData == null){
							map.put("msg", "包体不存在，导入失败");
						}else{
							map.put("pgData", pgData);
							Double activeDiscount = null;
							if(!isSupperRoot){
								RateDiscountPo ratePo = rateDiscountAO.getRateForCharge(new ChargeChannelParamsPo(carrier, serviceType, null,null,null,pgSize) , accountPo.getId(),true);
								if(ratePo != null){//只有费率
									activeDiscount = ratePo.getActiveDiscount();
									map.put("ratePo", ratePo);
								}else{
									map.put("msg", "未配置折扣，导入失败");
								}
							}else{
								if(StringHelper.isNotEmpty(epName)){
									ExchangePlatformPo platformPo = exchangePlatformAO.getEpByEpName(epName);
									if(platformPo != null){
										ChargeChannelParamsPo ccpp = new ChargeChannelParamsPo(carrier, serviceType, null,null,null,pgSize);
										ccpp.setEpName(epName);
										List<ChargeChannelPo> chargeList = purchaseAO.ajaxChargeChannel(ccpp);
										if(chargeList != null && chargeList.size() > 0){
											activeDiscount = 1d;//让折扣不为空,继续进行
											map.put("chargeList", chargeList);
										}
									}else{
										map.put("msg", "平台名称未找到，导入失败");
									}
								}else{
									map.put("msg", "名称不规范（河南硕朗_江西移动_省漫游_100），导入失败");
								}
							}
							if(activeDiscount != null){
								InputStreamReader isr = new InputStreamReader(input);
								BufferedReader br = new BufferedReader(isr);
								String line="";
								StringBuffer sb = new StringBuffer();
								int successSize = 0;
								int errorSize = 0;
//								long size = uploadFile.getSize();
//							System.out.println(size);
								String wrongNumber = "";
								String doubleNumber = "";
								
								//根据折扣设置包体是否足够
								Double accountBalance = accountPo.getAccountBalance();
								double pgPrice = pgData.getPgPrice();
								double pgDiscountPrice = NumberTool.mul(pgData.getPgPrice(), activeDiscount);
								Double telCharge = 0d;
								Double pgTotalPrice = 0d;
								
								String msgDesc = "";
								while ((line=br.readLine())!=null) {
									Map<String,Object> carrierMap = PurchaseUtil.getOperatorsByTel(line.trim());
									if(carrierMap == null){
										wrongNumber = line.trim();
										break;
									}
									String chargeTelDetail = carrierMap.get("chargeTelDetail").toString();
//									System.out.println("carrier:"+carrier+",chargeTelDetail"+ chargeTelDetail);
									if(chargeTelDetail.equals(carrier)){//手机号得到的归属地和文件名得到的归属地一致
										String tempStr = sb.toString();
										if(tempStr.contains(line)){//前面的号码包含了新加的号码
											doubleNumber = line;
											break;
										}
										if(!isSupperRoot){//验证余额
											telCharge = NumberTool.add(pgDiscountPrice, telCharge); 
											pgTotalPrice = NumberTool.add(pgPrice,pgTotalPrice); 
											if(telCharge > accountBalance){//余额不足
												msgDesc = ",余额不足";
												break;
											}
										}
										sb.append(line);
										sb.append(",");
										successSize++;
									}else{
										errorSize++;
									}
								}
								br.close();
								isr.close();
								input.close();
								if(StringHelper.isNotEmpty(wrongNumber)){
									map.put("msg", wrongNumber + ",号码文本格式不对（归属地查询失败），导入失败");
								}
								else if(StringHelper.isNotEmpty(doubleNumber)){
									map.put("msg", doubleNumber + "出现多次,导入失败");
								}
								else if(successSize > 0){
									map.put("msg", "success");
									map.put("totalNum", successSize);
									map.put("telData", sb.toString());
									if(!isSupperRoot){
										map.put("pgPrice", pgTotalPrice);
										map.put("orderAmount", telCharge);//总成本
									}
									map.put("msgDesc", "导入失败"+errorSize+"条,导入成功条数："+ successSize+msgDesc);
								}else{
									map.put("msg", "导入失败");
								}
							}
						}
					}
					
//				String msg = "success";
//				String scopeCode = uploadFileName.substring(uploadFileName.indexOf("_")+1);
//				String scopeCityCode = scopeCode.substring(0,2);
//				String operator = scopeCode.substring(2,uploadFileName.lastIndexOf("."));
//				int operatorType = -1;
//				if(uploadFileName.contains("10000")){
//					operatorType = OperatorTypeEnum.TELECOME.getValue();
//				}else if(uploadFileName.contains("10010")){
//					operatorType = OperatorTypeEnum.LINK.getValue();
//				}else if(uploadFileName.contains("10086")){
//					operatorType = OperatorTypeEnum.MOBILE.getValue();
//				}
//				if(operatorType == -1){
//					msg = "名称不规范(tel_地区编码+运营商客服电话)";
//				}
//				
//				if("success".equals(msg) || ScopeCityEnum.getEnum(scopeCityCode) == null){//运营商或者地区编码不对
//					long size = uploadFile.getSize();
//					System.out.println(size);
//	//				byte[] data = new byte[(int) size];
//					InputStream input = uploadFile.getInputStream();
//					
//					InputStreamReader isr = new InputStreamReader(input);
//					BufferedReader br = new BufferedReader(isr);
//					 String line="";
//	//			        String[] arrs=null;
//					 StringBuffer sb = new StringBuffer();
//			        while ((line=br.readLine())!=null) {
//			        	sb.append(line);
//	//		        	sb.append(",");
//	//			            arrs=line.split(",");
//	//			            arrs=line;
//	//			            System.out.println(arrs[0] + " : " + arrs[1] + " : " + arrs[2]);
//			        }
//				        br.close();
//				        isr.close();
//				        input.close();
//	//			        fis.close();
//					
//	//				input.read(data);
//	//				File folder = new File(request.getSession().getServletContext().getRealPath("/") + "telTxt/");
//	//				if (!folder.exists())
//	//				{
//	//					folder.mkdir();
//	//				}
//					
//					String ExName = uploadFileName.substring(uploadFileName.lastIndexOf("."), uploadFileName.length());
//	//				File outFile = new File(request.getSession().getServletContext().getRealPath("/") + "telTxt/" + context.getLoginUID() + ExName);
//	//				
//	//				if (!outFile.exists())
//	//				{
//	//					outFile.createNewFile();
//	//				}
//	//				FileOutputStream outStream = new FileOutputStream(outFile);
//	
//	//				outStream.write(data);
//	//				outStream.close();
//				
//					String scopeCity = ScopeCityEnum.getEnum(scopeCityCode).getDesc();
//					String carrier = scopeCity.substring(0, scopeCity.length()-2) + OperatorTypeEnum.getEnum(operatorType);//carrier
//					map.put("carrier", carrier);//江西移动
//					map.put("telData", sb.toString());
////					response.getWriter().print(sb.toString());
//				}else{
//					msg = "运营商或者地区编码不对";
//				}
//				map.put("msg", msg);
					String jsonStr = JSON.toJSONString(map);
					response.setCharacterEncoding("utf-8");
					response.getWriter().print(jsonStr);
//				returnMessage = invoiceAccountAO.importPreInvoiceAccount(outFile, context.getLoginName(), context.getLoginUID());
				}
			}
			catch (IOException e)
			{
//			returnMessage = MgtConstants.MSG_PROGRAM_EXCEPTION_IMPORT_ERROR;
				e.printStackTrace();
			}
			
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
	public String batchCommitOrder(PurchaseVO purchaseVO, HttpServletRequest request){
		String res = "error";
		HttpSession httpSession = request.getSession();
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)httpSession.getAttribute("loginContext");
		if(agencyVO != null){
			purchaseVO.setAgencyId(agencyVO.getId());//设置为当前登陆用户的订单
			//只有待冲的单子可以批量提交
			if(purchaseVO.getOrderResult().equals(OrderStateEnum.DAICHONG.getValue())){
				res = purchaseAO.batchCommitOrder(purchaseVO);
				//添加批量提交事务日志
				accountEventDao.add(new AccountEventPo(agencyVO.getId(), EventTypeEnum.BATCH_COMMIT_ORDER.getValue(), System.currentTimeMillis(), "江西南昌", "120.55.162.224", purchaseVO.getAgencyName()));
			}
		}
		return res;
	}
	/**
	 * @description: 批量将订单返回失败/成功
	 * @param purchaseVO
	 * @param request
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月23日 下午5:35:40
	 */
	@ResponseBody
	@RequestMapping(value=ChargePgURL.BATCH_CHANGE_ORDER)
	public String batchChangeOrder(PurchaseVO purchaseVO, HttpServletRequest request){
		String res = "error";
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(agencyVO != null && agencyVO.getRootAgencyId() == 0){
			purchaseVO.setAgencyId(agencyVO.getId());//设置为当前登陆用户的订单
			//只有待冲的单子可以批量提交
			res = purchaseAO.batchChangeOrderState(purchaseVO);
		}
		return res;
	}
	/**
	 * @description: 批量推送订单
	 * @param purchaseVO
	 * @param request
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月7日 下午5:31:59
	 */
	@ResponseBody
	@RequestMapping(value=ChargePgURL.BATCH_PUSH_ORDER,produces = "application/json;charset=utf-8")
	public String batchPushOrder(PurchaseVO purchaseVO, HttpServletRequest request){
		String res = "error";
		HttpSession httpSession = request.getSession();
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)httpSession.getAttribute("loginContext");
		if(agencyVO != null){
			purchaseVO.setAgencyId(agencyVO.getId());//设置为当前登陆用户的订单
			res = purchaseAO.batchPushOrder(purchaseVO);
		}
		return res;
	}
	
	
	/**
	 * @description: 导出订单列表
	 * @param purchaseVO
	 * @param response
	 * @param request
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月7日 下午3:05:58
	 */
	@RequestMapping(value=ChargePgURL.EXPORT_CHARGED_LIST, method=RequestMethod.GET)
	public void exportChargedList(PurchaseVO purchaseVO,HttpServletResponse response,HttpServletRequest request){
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(agencyVO != null){
			purchaseVO.setAgencyId(agencyVO.getId());//设置为当前登陆用户的订单
//			purchaseVO.setChargeFor(PgServiceTypeEnum.PGCHARGE.getValue());
			if(PgServiceTypeEnum.getEnum(purchaseVO.getPurchaseFor()) != null){
				HSSFWorkbook hbook = purchaseAO.exportChargedList(purchaseVO, agencyVO.getAgencyTag()); 
				if (hbook != null)
				{
					try
					{
						request.setCharacterEncoding("UTF-8");
						response.reset();
						response.setCharacterEncoding("UTF-8");
						response.setContentType("application/msexcel;charset=UTF-8");
						StringBuffer fileNameSb = new StringBuffer();
						fileNameSb.append(agencyVO.getUserName());
						fileNameSb.append("-");
						fileNameSb.append(PgServiceTypeEnum.getEnum(purchaseVO.getPurchaseFor()).getDesc());
						fileNameSb.append("-");
						fileNameSb.append("成功订单记录");
						fileNameSb.append(DateUtil.formatPramm(new Date(), "yyyy-MM-dd"));
						fileNameSb.append(".xls");
						response.addHeader("Content-Disposition", "attachment;filename=\"" + new String((fileNameSb.toString()).getBytes("GBK"), "ISO8859_1")
						+ "\"");
						OutputStream outputStream = response.getOutputStream();
						hbook.write(outputStream);
						outputStream.flush();
						outputStream.close();
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			}
		}else{
			try {
				response.getOutputStream().print("alert('导出失败，未登录')");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	
}
