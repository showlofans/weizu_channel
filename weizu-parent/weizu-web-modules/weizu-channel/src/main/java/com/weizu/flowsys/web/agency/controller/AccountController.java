package com.weizu.flowsys.web.agency.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.weizu.web.foundation.DateUtil;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.core.util.hibernate.util.StringHelper;
import com.weizu.flowsys.operatorPg.enums.AccountTypeEnum;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.agency.ao.AgencyAO;
import com.weizu.flowsys.web.agency.ao.ChargeAccountAo;
import com.weizu.flowsys.web.agency.ao.ChargeRecordAO;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.agency.pojo.ChargeRecordPo;
import com.weizu.flowsys.web.agency.pojo.ConsumeRecordPo;
import com.weizu.flowsys.web.agency.url.AccountURL;
import com.weizu.flowsys.web.agency.util.FileUpload;

/**
 * @description:代理商账户管理
 * @projectName:crud
 * @className:AccountController.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月2日 上午10:00:14
 * @version 1.0
 */
@Controller
@RequestMapping(value=AccountURL.MODEL_NAME)
public class AccountController {
	@Resource
	private ChargeRecordAO chargeRecordAO;
	@Resource
	private ChargeAccountAo chargeAccountAO;
	@Resource
	private AgencyAO agencyAO;
	
	/**
	 * @description:跳转到账户充值界面
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月8日 上午9:20:06
	 */
	@RequestMapping(value = AccountURL.ADD_CHARGE_PAGE)
	public ModelAndView addCharge(HttpServletRequest request, String userName,
			int agencyId) {

		// String agencyId = request.getParameter("agencyId").trim().toString();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("agencyUserName", userName); // 代理商名字
		resultMap.put("agencyId", agencyId); // 代理商ID
		resultMap.put("billTypeEnum", BillTypeEnum.toList());
		resultMap.put("billType", BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());//默认对私
		resultMap.put("chargeAccount",chargeAccountAO.getAccountByAgencyId(agencyId,BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()));//通过代理商Id获得充值账户基本信息
		resultMap.put("chargeAccount1",chargeAccountAO.getAccountByAgencyId(agencyId,BillTypeEnum.CORPORATE_BUSINESS.getValue()));//通过代理商Id获得充值账户基本信息
		return new ModelAndView("account/add_charge", "resultMap", resultMap);
	}

	/**
	 * @description: 账户充值记录
	 * @param pageNo
	 * @param request
	 * @param chargeRecordPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月2日 上午10:12:46
	 */
	@RequestMapping(value= AccountURL.CHARGE_LIST)
	public ModelAndView getChargeList(@RequestParam(value = "pageNo", required = false) String pageNo,
			HttpServletRequest request,ChargeRecordPo chargeRecordPo){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		PageParam pageParam = null;
		if(StringHelper.isNotEmpty(pageNo)){
			pageParam = new PageParam(Integer.parseInt(pageNo), 10);
		}else{
			chargeRecordPo.setStartTimeStr(DateUtil.formatAll(DateUtil.getStartTime()));
			chargeRecordPo.setEndTimeStr(DateUtil.formatAll(DateUtil.getEndTime()));
			pageParam = new PageParam(1, 10);
		}
		AgencyBackwardVO agencyVo = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(agencyVo != null){
			chargeRecordPo.setAccountType(AccountTypeEnum.INCREASE.getValue());
			Pagination<ChargeRecordPo> pagination =  chargeRecordAO.listChargeRecord(agencyVo.getId(), chargeRecordPo, pageParam);
			resultMap.put("pagination", pagination);
			resultMap.put("billTypeEnum", BillTypeEnum.toList());
			resultMap.put("accountTypeEnum", AccountTypeEnum.toList());
			//点击金额进入连接，自动填充代理商名称
			if(chargeRecordPo.getUserName() == null && chargeRecordPo.getAgencyId() != null){
				AgencyBackwardPo agencyPO = agencyAO.getAgencyById(chargeRecordPo.getAgencyId()+"");
				if(agencyPO != null){
					chargeRecordPo.setUserName(agencyPO.getUserName());
				}
			}
			resultMap.put("searchParams", chargeRecordPo);
		}
		return new ModelAndView("/account/charge_list", "resultMap", resultMap);
	}
	/**
	 * @description: 消费记录
	 * @param pageNo
	 * @param request
	 * @param chargeRecordPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月27日 下午5:09:11
	 */
	@RequestMapping(value= AccountURL.CONSUME_LIST)
	public ModelAndView getConsumeList(@RequestParam(value = "pageNo", required = false) String pageNo,
			HttpServletRequest request,ConsumeRecordPo consumeRecordPo){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		PageParam pageParam = null;
		if(StringHelper.isNotEmpty(pageNo)){
			pageParam = new PageParam(Integer.parseInt(pageNo), 10);
		}else{
			consumeRecordPo.setStartTimeStr(DateUtil.formatAll(DateUtil.getStartTime()));
			consumeRecordPo.setEndTimeStr(DateUtil.formatAll(DateUtil.getEndTime()));
			pageParam = new PageParam(1, 10);
		}
		AgencyBackwardVO agencyVo = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(agencyVo != null){
			Pagination<ConsumeRecordPo> pagination =  chargeRecordAO.listConsumeRecord(agencyVo.getId(), consumeRecordPo, pageParam);
			resultMap.put("pagination", pagination);
			resultMap.put("billTypeEnum", BillTypeEnum.toList());
			resultMap.put("accountTypeEnum", AccountTypeEnum.toList());
			//点击金额进入连接，自动填充代理商名称
			if(consumeRecordPo.getUserName() == null && consumeRecordPo.getAgencyId() != null){
				AgencyBackwardPo agencyPO = agencyAO.getAgencyById(consumeRecordPo.getAgencyId()+"");
				if(agencyPO != null){
					consumeRecordPo.setUserName(agencyPO.getUserName());
				}
			}
			resultMap.put("searchParams", consumeRecordPo);
		}
		return new ModelAndView("/account/consume_list", "resultMap", resultMap);
	}
	
	/**
	 * @description: 账户充值
	 * @param chargeRecordPo
	 * @param request
	 * @param response
	 * @throws IOException
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月2日 上午10:14:30
	 */
	@RequestMapping(value = AccountURL.ADD_CHARGE)
	public void goCharge(ChargeRecordPo chargeRecordPo,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		ChargeAccountPo accountPo = null;
		if(chargeRecordPo.getBillType() == BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()){
			accountPo = (ChargeAccountPo)request.getSession().getAttribute("chargeAccount");
		}else{
			accountPo = (ChargeAccountPo)request.getSession().getAttribute("chargeAccount1");
		}
		int result = chargeRecordAO.updateAccount(chargeRecordPo, accountPo);
		
		if(result > 0){
			ChargeAccountPo agencyAccountPo = null;
			if(chargeRecordPo.getBillType() == BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()){
				agencyAccountPo = (ChargeAccountPo)request.getSession().getAttribute("chargeAccount");
			}else{
				agencyAccountPo = (ChargeAccountPo)request.getSession().getAttribute("chargeAccount1");
			}
			agencyAccountPo.addBalance(chargeRecordPo.getRechargeAmount(),-1);//session中的引用变量
			response.getWriter().print("success");
		}else{
			response.getWriter().print("error");
		}
		
		//再从子代理商账户扣
		/*if(agencyVo != null){
			try {
				ChargeRecordPo chargeRecordPo2 = chargeRecordPo.clone();
				chargeRecordPo2.setAgencyId(agencyVo.getId());
				chargeRecordPo2.setAccountType(1);//给上家扣款
				//int updateResult = chargeRecordAO.updateContextAccount(chargeRecordPo2);//现从当前账户扣
				ChargeAccountPo chargeAccount = chargeAccountAO.getAccountByAgencyId(agencyVo.getId());
				
				if(updateResult + addResult >= 2){
					request.getSession().setAttribute("chargeAccount", chargeAccount);//更新当前显示账户信息
					
				}else{
					
				}
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			
		}else{
			response.getWriter().print("error");
		}*/
	}
	
	/**
	 * @description: 对公账户开通页面
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月30日 下午3:34:19
	 */
	@RequestMapping(value=AccountURL.OPEN_COMPANY_ACCOUNT_PAGE)
	public ModelAndView openCompanyAccountPage(){
		
		
		return new ModelAndView("/account/open_company_account_page");
	}
	/**
	 * @description: 开通对公账户
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月30日 下午4:03:56
	 */
	@RequestMapping(value=AccountURL.OPEN_COMPANY_ACCOUNT)
	public ModelAndView openCompanyAccount(@RequestParam("certification_img") MultipartFile file, ChargeAccountPo chargeAccountPo,HttpServletRequest request){
		AgencyBackwardVO agencyVo = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(agencyVo != null)
		{
			chargeAccountPo.setAgencyId(agencyVo.getId());
//			String realPath=request.getSession().getServletContext().getRealPath("/");
			
			String realPath = "";
			try {
				realPath = FileUpload.uploadFile(file, request);
				System.out.println(realPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
			chargeAccountPo.setCertificationImg(realPath);
			int createRes = chargeAccountAO.createCompanyAccount(realPath, chargeAccountPo,file);
			if(createRes > 0){
				ChargeAccountPo chargeAccount =  (ChargeAccountPo)request.getSession().getAttribute("chargeAccount");
				chargeAccount.setBillType(BillTypeEnum.CORPORATE_BUSINESS.getValue());
				request.getSession().setAttribute("chargeAccount", chargeAccount);
			}
			return new ModelAndView("/account/open_company_account_page");
		}
		return new ModelAndView("/account/open_company_account_page");
	}
	
	/**
	 * @description: 账户信息
	 * @param request
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月3日 上午11:33:37
	 */
	@RequestMapping(value=AccountURL.ACCOUNT_INFO)
	public ModelAndView accountInfo(HttpServletRequest request){
//		AgencyBackwardVO agencyVo = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
//		ChargeAccountPo chargeAccount = (ChargeAccountPo)request.getSession().getAttribute("chargeAccount");
//		ChargeAccountPo chargeAccount1 = (ChargeAccountPo)request.getSession().getAttribute("chargeAccount1");
//		Map<String,Object> resultMap = new HashMap<String, Object>();
		
		return new ModelAndView("/account/account_info");
//		return new ModelAndView("/account/account_info","resultMap",resultMap);
	}
	/**
	 * @description: 账户信息更新
	 * @param request
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月3日 上午11:56:01
	 */
	@RequestMapping(value=AccountURL.ACCOUNT_INFO_EDIT)
	@ResponseBody
	public void editAccountInfo(HttpServletRequest request,ChargeAccountPo chargeAccount,HttpServletResponse response){
		AgencyBackwardVO agencyVo = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
//		Map<String,Object> resultMap = new HashMap<String, Object>();
		chargeAccount.setAgencyId(agencyVo.getId());
		int res = chargeAccountAO.updateAccount(chargeAccount);
		try {
			if(res > 0 )
			{
				//更新session中相关账户信息
				if(chargeAccount.getBillType() == BillTypeEnum.BUSINESS_INDIVIDUAL.getValue())
				{
//					ChargeAccountPo chargeAccount0 =  (ChargeAccountPo)request.getSession().getAttribute("chargeAccount");
//					chargeAccount0.setBillType(BillTypeEnum.CORPORATE_BUSINESS.getValue());
					request.getSession().setAttribute("chargeAccount", chargeAccount);
				}else if(chargeAccount.getBillType() == BillTypeEnum.BUSINESS_INDIVIDUAL.getValue())
				{
//					ChargeAccountPo chargeAccount1 =  (ChargeAccountPo)request.getSession().getAttribute("chargeAccount1");
//					chargeAccount1.setBillType(BillTypeEnum.CORPORATE_BUSINESS.getValue());
					request.getSession().setAttribute("chargeAccount1", chargeAccount);
				}
				
				response.getWriter().print("success");
			}
			else
			{
				response.getWriter().print("error");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		return new ModelAndView("/account/account_info","resultMap",resultMap);
	}
	
}
