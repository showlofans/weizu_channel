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
import com.weizu.flowsys.operatorPg.enums.CallBackEnum;
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
	
	/**
	 * @description: 绑定银行卡
	 * @param request
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月11日 上午10:46:31
	 */
	@RequestMapping(value=BankAccountURL.ATTACH_BANK_PAGE)
	public ModelAndView attachBankAccountPage(HttpServletRequest request,Integer accountId){
		//当前子账户的父级代理商就是当前登陆用户
		AgencyBackwardVO agencyVo = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		request.getSession().setAttribute("childAccountId", accountId);
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		if(agencyVo != null){
			bankAccountAO.getAttachBankList(accountId, agencyVo.getId(), resultMap);;
		}
		return new ModelAndView("/bank/attach_bank_list", "resultMap", resultMap);
	}
	/**
	 * @description: 添加绑定
	 * @param request
	 * @param id
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月11日 下午3:29:34
	 */
	@RequestMapping(value=BankAccountURL.ATTACH_BANK)
	@ResponseBody
	public String attachBankAccount(HttpServletRequest request,Long id){
		//当前子账户的父级代理商就是当前登陆用户
		AgencyBackwardVO agencyVo = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		Object childAccountIdOjb = request.getSession().getAttribute("childAccountId");
		Integer chileAccountId = childAccountIdOjb == null ? null : Integer.parseInt(childAccountIdOjb.toString());
		BankAccountPo originalBankPo = bankAccountDao.get(id);
		if(originalBankPo != null){
			BankAccountPo bankPo = new BankAccountPo(id, chileAccountId, originalBankPo.getRemittanceWay(), originalBankPo.getRemittanceBankAccount(), originalBankPo.getAccountName(), null, agencyVo.getId(), CallBackEnum.POSITIVE.getValue(), CallBackEnum.POSITIVE.getValue());
			return bankAccountAO.attachBank(bankPo);
		}
		return "error";
	}
	/**
	 * @description:
	 * @param request
	 * @param id
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月11日 下午3:30:04
	 */
//	@RequestMapping(value = BankAccountURL.UNATTACH_BANK)
//	public String unattachBankAccount(HttpServletRequest request,Long id){
//		//当前子账户的父级代理商就是当前登陆用户
//		AgencyBackwardVO agencyVo = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
//		Object childAccountIdOjb = request.getSession().getAttribute("childAccountId");
//		Integer chileAccountId = childAccountIdOjb == null ? null : Integer.parseInt(childAccountIdOjb.toString());
//		BankAccountPo originalBankPo = bankAccountDao.get(id);
//		if(originalBankPo != null){
//			BankAccountPo bankPo = new BankAccountPo(id, chileAccountId, originalBankPo.getRemittanceWay(), originalBankPo.getRemittanceBankAccount(), originalBankPo.getAccountName(), null, agencyVo.getId(), CallBackEnum.POSITIVE.getValue(), 0);
//			return bankAccountAO.attachBank(bankPo);
//		}
//		return "error";
//	}
	
	
	
	@RequestMapping(value=BankAccountURL.MY_BANK_LIST)
	public ModelAndView listBankAccount(HttpServletRequest request){
		AgencyBackwardVO agencyVo = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		if(agencyVo != null){
			bankAccountAO.getMyBankList(agencyVo.getId(), resultMap);
		}
		return new ModelAndView("/bank/my_bank_list", "resultMap", resultMap);
	}
	
	/**
	 * @description: 加款 页面<br>页面来源：my_bank_list
	 * @param request
	 * @param billType
	 * @param id
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月10日 下午4:43:18
	 */
	@RequestMapping(value=BankAccountURL.PLUS_BANK_LIST)
	public ModelAndView listPlusBankAccount(HttpServletRequest request, Long id, Integer accountId){
		AgencyBackwardVO agencyVo = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		
		
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		BankAccountPo myBank = bankAccountAO.getBankPoById(id);
		if(myBank != null){
			if(agencyVo != null){
				bankAccountAO.getPlusBankList(agencyVo.getId(),myBank.getBillType(), resultMap);
			}
			resultMap.put("myBank", myBank);
		}
		resultMap.put("billTypeEnums", BillTypeEnum.toList());
		return new ModelAndView("/bank/plus_bank_list", "resultMap", resultMap);
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
