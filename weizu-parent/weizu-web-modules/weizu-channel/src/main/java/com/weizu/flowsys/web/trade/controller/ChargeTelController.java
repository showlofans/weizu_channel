package com.weizu.flowsys.web.trade.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.weizu.flowsys.operatorPg.enums.AgencyTagEnum;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.TelServiceTypeEnum;
import com.weizu.flowsys.operatorPg.enums.PgServiceTypeEnum;
import com.weizu.flowsys.operatorPg.enums.TelChannelTagEnum;
import com.weizu.flowsys.operatorPg.enums.TelchargeSpeedEnum;
import com.weizu.flowsys.web.activity.ao.TelRateAO;
import com.weizu.flowsys.web.activity.dao.ITelRateDao;
import com.weizu.flowsys.web.activity.pojo.RateDiscountPo;
import com.weizu.flowsys.web.activity.pojo.TelRatePo;
import com.weizu.flowsys.web.agency.ao.AgencyAO;
import com.weizu.flowsys.web.agency.ao.ChargeAccountAo;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.channel.dao.ITelChannelDao;
import com.weizu.flowsys.web.channel.pojo.ChannelDiscountPo;
import com.weizu.flowsys.web.channel.pojo.TelChannelParams;
import com.weizu.flowsys.web.channel.pojo.TelChannelPo;
import com.weizu.flowsys.web.channel.pojo.TelProductPo;
import com.weizu.flowsys.web.trade.ao.PurchaseAO;
import com.weizu.flowsys.web.trade.pojo.GetTelRatePo;
import com.weizu.flowsys.web.trade.pojo.TelChargeVO;
import com.weizu.flowsys.web.trade.url.ChargeTelURL;

/**
 * @description: 话费充值控制层
 * @projectName:weizu-channel
 * @className:ChargeTelController.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年12月2日 上午9:37:50
 * @version 1.0
 */
@Controller
@RequestMapping(value=ChargeTelURL.MODEL_NAME)
public class ChargeTelController {
	
	@Resource
	private TelRateAO telRateAO;
	@Resource
	private ITelRateDao telRateDao;
	
	@Resource
	private ChargeAccountAo chargeAccountAO;
	@Resource
	private ITelChannelDao telChannelDao;
	
	@Resource
	private AgencyAO agencyAO;
	@Resource
	private PurchaseAO purchaseAO;
	
	/**
	 * @description: 跳转到话费充值页面
	 * @param msg
	 * @param request
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月30日 下午5:24:58
	 */
	@RequestMapping(value=ChargeTelURL.TEL_CHARGE_PAGE)
	public ModelAndView telChargePage(@RequestParam(value="msg",required=false)String msg,HttpServletRequest request){
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		Map<String,Object> resultMap = new HashMap<String,Object>();
		if(agencyVO != null){
			resultMap.put("telchargeSpeedEnums", TelchargeSpeedEnum.toList());
			resultMap.put("huaServiceTypeEnum", TelServiceTypeEnum.toList());
			resultMap.put("telChannelTagEnums", TelChannelTagEnum.toList());
			return new ModelAndView("/trade/tel_charge_page","resultMap",resultMap);
		}else{
			return new ModelAndView("error", "errorMsg", "当前登录用户不合法");
		}
	}
	
	/**
	 * @description: 异步获得话费充值编码和折扣
	 * @param telProductPo
	 * @param request
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月1日 下午2:48:10
	 */
	@ResponseBody
	@RequestMapping(value=ChargeTelURL.AJAX_CHARGE_TELPC)
	public String ajaxTelpc(HttpServletRequest request,TelChannelParams telParams){
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		String jsonStr = "";
		if(agencyVO != null){
			Map<String,Object> resultMap = new HashMap<String, Object>();
//			if(telParams.getRateFor() == null){
//				telParams.setRateFor(agencyVO.getAgencyTag());
//			}
//				telParams.setRateFor(AgencyTagEnum.PLATFORM_USER.getValue());
			telRateAO.getRateForCharge(resultMap,telParams,agencyVO.getId(),agencyVO.getRootAgencyId());
//			if(getRateList != null && getRateList.size() > 0){
//				resultMap.put("getRateList", getRateList);
//			}else{
//				resultMap.put("msg", "没有该话费折扣");
//			}
			jsonStr = JSON.toJSONString(resultMap);
			
		}else{
			//model.addAttribute("errorMsg", "当前登录用户不合法");
			jsonStr = "error";
		}
		return jsonStr;
	}
	
	/**
	 * @description: 话费充值
	 * @param request
	 * @param pcVO
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月2日 下午1:53:10
	 */
	@ResponseBody
	@RequestMapping(value = ChargeTelURL.TEL_CHARGE,produces = "text/text;charset=UTF-8")
	public String telCharge(HttpServletRequest request,TelChargeVO tcVO){
		String res = "error";
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(agencyVO != null){
//			String scopeCityCode = ScopeCityEnum.QG.getValue();
//			if(!pcVO.getServiceType().equals(ServiceTypeEnum.NATION_WIDE.getValue())){
//				Map<String,Object> scopeMap = PurchaseUtil.getScopeCityByCarrier(pcVO.getChargeTelDetail());
//				scopeCityCode = scopeMap.get("scopeCityCode").toString();
//			}
			ChargeAccountPo accountPo = null;
			Long telchannelId = null;
			if(!agencyVO.getRootAgencyId().equals(0)){
				TelRatePo telRatePo = telRateDao.get(tcVO.getTelRateId());
				if(telRatePo != null){
					accountPo = chargeAccountAO.getAccountByAgencyId(agencyVO.getId(), telRatePo.getBillType());
					telchannelId = telRatePo.getTelchannelId();
				}
			}else{//超管测试通道，通过通道折扣提单
				TelChannelPo tcPo = telChannelDao.get(tcVO.getTelchannelId());
				if(tcPo!=null && BillTypeEnum.BUSINESS_INDIVIDUAL.getValue().equals(tcPo.getBillType())){
					accountPo = chargeAccountAO.getAccountByAgencyId(agencyVO.getId(), tcPo.getBillType());
					telchannelId = tcPo.getId();
				}
			}
			boolean isAccess = agencyAO.checkIdByPass(agencyVO.getId(), agencyVO.getUserPass());
			if(!isAccess || !agencyVO.getId().equals(accountPo.getAgencyId())){
				res = "当前登陆用户不合法";
//				return new ModelAndView("error", "errorMsg", "当前登陆用户不合法");
			}
			tcVO.setAccountId(accountPo.getId());
			tcVO.setFromAgencyName(agencyVO.getUserName());
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
			tcVO.setTelchannelId(telchannelId);
			
			//充值
			tcVO.setChargeFor(PgServiceTypeEnum.TELCHARGE.getValue());
			res = purchaseAO.purchase(tcVO, accountPo);
//			referURL = "/flowsys/chargePg/purchase_list.do?orderResult=2";
//			resultMap.put("referURL", referURL);
//			resultMap.put("pageMsg", pageMsg);
//			return new ModelAndView("/trade/charge_result_page", "resultMap", resultMap);
		}else{
			res = "系统维护之后，用户未登陆！！";
		}
		
		return res;
	}

}
