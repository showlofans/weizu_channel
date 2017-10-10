package com.weizu.flowsys.web.agency.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.web.agency.ao.BankAccountAO;
import com.weizu.flowsys.web.agency.dao.BankAccountDaoInterface;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;
import com.weizu.flowsys.web.agency.pojo.BankAccountPo;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.agency.url.BankAccountURL;

@Controller
@RequestMapping(value=BankAccountURL.MODEL_NAME)
public class BankAccountController {

	@Resource
	private BankAccountAO bankAccountAO;
	@Resource
	private BankAccountDaoInterface bankAccountDao;
	
	@RequestMapping(value=BankAccountURL.BANK_LIST)
	public ModelAndView listBankAccount(HttpServletRequest request){
		AgencyBackwardVO agencyVo = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		if(agencyVo != null){
			bankAccountAO.getBankList(agencyVo.getId(), resultMap);
		}
		return new ModelAndView("/bank/bank_list", "resultMap", resultMap);
	}
	
	/**
	 * @description: 银行卡添加页面
	 * @param request
	 * @param billType
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月9日 下午3:44:33
	 */
	@RequestMapping(value=BankAccountURL.ADD_BANK_PAGE)
	public ModelAndView addBankAccountPage(HttpServletRequest request,Integer billType){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("billType", billType);
		return new ModelAndView("/bank/bank_add", "resultMap", resultMap);
	}
	/**
	 * @description: 添加银行卡
	 * @param request
	 * @param bankPo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月9日 下午3:46:34
	 */
	@RequestMapping(value=BankAccountURL.ADD_BANK)
	@ResponseBody
	public String addBankAccount(HttpServletRequest request,BankAccountPo bankPo){
		if(BillTypeEnum.CORPORATE_BUSINESS.getValue().equals(bankPo.getBillType())){
			ChargeAccountPo accountPo1 = (ChargeAccountPo)request.getSession().getAttribute("chargeAccount1");
			if(accountPo1 != null){
				bankPo.setAccountId(accountPo1.getId());
				//添加银行卡
				return bankAccountAO.addBank(bankPo);
			}
		}else{
			ChargeAccountPo accountPo = (ChargeAccountPo)request.getSession().getAttribute("chargeAccount");
			if(accountPo != null){
				bankPo.setAccountId(accountPo.getId());
				//添加银行卡
				return bankAccountAO.addBank(bankPo);
			}
		}
		return "error";
		
	}
	
	/**
	 * @description: 银行卡编辑页面
	 * @param request
	 * @param billType
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月9日 下午4:18:55
	 */
	@RequestMapping(value=BankAccountURL.EDIT_BANK_PAGE)
	public ModelAndView editBankAccountPage(HttpServletRequest request,Long id){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		BankAccountPo bankPo = bankAccountDao.get(id);
		resultMap.put("bankPo", bankPo);
		return new ModelAndView("/bank/bank_edit", "resultMap", resultMap);
	}
	/**
	 * @description: 编辑银行卡i信息
	 * @param request
	 * @param id
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月9日 下午4:22:30
	 */
	@RequestMapping(value=BankAccountURL.EDIT_BANK)
	@ResponseBody
	public String editBankAccount(HttpServletRequest request,BankAccountPo bankPo){
		int res = bankAccountDao.updateLocal(bankPo, new WherePrams("id", "=", bankPo.getId()));
		if(res > 0){
			return "success";
		}else{
			return "error";
		}
	}
	/**
	 * @description: 删除银行卡
	 * @param request
	 * @param id
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月9日 下午4:42:31
	 */
	@RequestMapping(value=BankAccountURL.DEL_BANK)
	@ResponseBody
	public String delBankAccount(HttpServletRequest request,Long id){
		int res = bankAccountDao.del(id);
		if(res > 0){
			return "success";
		}else{
			return "error";
		}
	}
	
	
	
}
