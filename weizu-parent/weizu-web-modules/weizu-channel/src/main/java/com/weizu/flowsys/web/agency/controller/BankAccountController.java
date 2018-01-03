package com.weizu.flowsys.web.agency.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.CallBackEnum;
import com.weizu.flowsys.operatorPg.enums.ConfirmStateTransferEnum;
import com.weizu.flowsys.operatorPg.enums.InOrOutEnum;
import com.weizu.flowsys.web.agency.ao.BankAccountAO;
import com.weizu.flowsys.web.agency.ao.TransferRecAO;
import com.weizu.flowsys.web.agency.dao.BankAccountDaoInterface;
import com.weizu.flowsys.web.agency.dao.ITransferRecDao;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;
import com.weizu.flowsys.web.agency.pojo.BankAccountPo;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.agency.pojo.TransferRecordPo;
import com.weizu.flowsys.web.agency.url.BankAccountURL;
import com.weizu.web.foundation.DateUtil;

@Controller
@RequestMapping(value=BankAccountURL.MODEL_NAME)
public class BankAccountController {

	@Resource
	private BankAccountAO bankAccountAO;
	@Resource
	private BankAccountDaoInterface bankAccountDao;
	@Resource
	private ITransferRecDao transferRecDao;
	@Resource
	private TransferRecAO transferRecAO;
	
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
		}else{
			return new ModelAndView("error", "errorMsg", "系统维护之后，用户未登陆！");
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
	public String attachBankAccount(HttpServletRequest request,Long id, HttpServletResponse response){
		//当前子账户的父级代理商就是当前登陆用户
		AgencyBackwardVO agencyVo = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(agencyVo == null){
			try {
				response.sendRedirect("error");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}else{
			Object childAccountIdOjb = request.getSession().getAttribute("childAccountId");
			Integer chileAccountId = childAccountIdOjb == null ? null : Integer.parseInt(childAccountIdOjb.toString());
			BankAccountPo originalBankPo = bankAccountDao.get(id);
			if(originalBankPo != null){
				BankAccountPo bankPo = new BankAccountPo(chileAccountId, originalBankPo.getRemittanceWay(), originalBankPo.getRemittanceBankAccount(), originalBankPo.getAccountName(), null, agencyVo.getId(), CallBackEnum.POSITIVE.getValue(), CallBackEnum.POSITIVE.getValue());
				return bankAccountAO.attachBank(bankPo);
			}
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
		}else{
			return new ModelAndView("error", "errorMsg", "系统维护之后，用户未登陆！");
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
		if(agencyVo != null){
			bankAccountAO.getPlusBankList(agencyVo.getRootAgencyId(),accountId, resultMap);
		}else{
			return new ModelAndView("error", "errorMsg", "系统维护之后，用户未登陆！");
		}
			
		BankAccountPo myBank = bankAccountAO.getBankPoById(id);//子代理商的银行卡id
		if(myBank != null){
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
//		resultMap.put("callBackEnums", CallBackEnum.toList());
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
		
//		bankAccountDao.getOriginalBankA(paramsMap)
		
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
	 * @description: 异步修改银行卡默认状态 my_bank_list
	 * @param id
	 * @param polarity
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月16日 上午11:13:33
	 */
	@RequestMapping(value=BankAccountURL.CHANGE_BANK_POLARITY)
	@ResponseBody
	public String changeBankPolarity(Long id, Integer polarity){
		String res = bankAccountAO.changeBankPolarity(id, polarity);
		return res;
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
	 * @description: 自己删除银行卡
	 * @param request
	 * @param id
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月9日 下午4:42:31
	 */
	@RequestMapping(value=BankAccountURL.DEL_BANK)
	@ResponseBody
	@Transactional
	public String delBankAccount(HttpServletRequest request,Long id){
		BankAccountPo bankPo = bankAccountDao.get(id);
		//删除子母银行卡
		int res = bankAccountDao.del(new WherePrams("agency_id", "=", bankPo.getAgencyId()).and("remittance_bank_account", "=", bankPo.getRemittanceBankAccount()));
		if(res > 0){
			return "success";
		}else{
			return "error";
		}
	}
	/**
	 * @description: 删除绑定银行卡
	 * @param request
	 * @param id
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月9日 下午4:42:31
	 */
	@RequestMapping(value=BankAccountURL.DEL_BANK_BIND)
	@ResponseBody
	@Transactional
	public String delBankBindAccount(Long id){
		//删除当前绑定类型银行卡
		int res = bankAccountDao.del(id);
		if(res > 0){
			return "success";
		}else{
			return "error";
		}
	}
	/**
	 * @description: 银行卡转账
	 * @param request
	 * @param id
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月12日 上午10:00:05
	 */
	@RequestMapping(value=BankAccountURL.TRANSFER_BANK)
	@ResponseBody
	public String transferBank(HttpServletRequest request,TransferRecordPo transferPo, HttpServletResponse response){
		AgencyBackwardVO agencyVo = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
			if(agencyVo == null){
				try {
				response.sendRedirect("error");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				transferPo.setFromAgencyId(agencyVo.getId());			
				String res = transferRecAO.transferBank(transferPo);
				return res;
			}
			return null;
//			return new ModelAndView("error", "errorMsg", "系统维护之后，用户未登陆！！");
	}
	
	/**
	 * @description: 获得银行卡转账记录列表
	 * @param bankId
	 * @param direction
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月12日 下午12:56:00
	 */
	@RequestMapping(value=BankAccountURL.TRANSFER_RECORD)
	public ModelAndView getTransferRecord(Long bankId,@RequestParam(value="direction",required=false)Integer direction,
			@RequestParam(value="pageNoLong",required=false)Long pageNoLong,
			@RequestParam(value="confirmState",required=false)Integer confirmState,
			HttpServletRequest request){
		AgencyBackwardVO agencyVo = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(agencyVo == null){
			return new ModelAndView("error", "errorMsg", "系统维护之后，用户未登陆！");
		}
		if(agencyVo.getRootAgencyId() == 0 && direction == null){//超管默认转入
			direction = InOrOutEnum.IN.getValue();
		}
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		PageParam pageParam = null;
		if(pageNoLong == null){
			pageParam = new PageParam(1l, 10);
		}else{
			pageParam = new PageParam(pageNoLong, 10);
		}
		
		transferRecAO.getTransferRec(bankId, direction,confirmState,pageParam, resultMap);
		
		BankAccountPo bankPo = bankAccountDao.get(bankId);
		resultMap.put("bankPo", bankPo);
		
		resultMap.put("inOrOutEnums", InOrOutEnum.toList());
		resultMap.put("confirmStateTransferEnums", ConfirmStateTransferEnum.toList());
		return new ModelAndView("/bank/transfer_record","resultMap",resultMap);
	}
	/**
	 * @description: 转账审核页面
	 * @param id
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月12日 下午5:37:44
	 */
	@RequestMapping(value=BankAccountURL.TRANSFER_CONFIRM_PAGE)
	public ModelAndView transferConfirmPage(Long id){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		TransferRecordPo transferPo = transferRecDao.get(id);
		resultMap.put("transferPo", transferPo);
		resultMap.put("confirmStateTransferEnums", ConfirmStateTransferEnum.toList());
		return new ModelAndView("/bank/transfer_confirm_page","resultMap",resultMap);
	}
	
	@RequestMapping(value=BankAccountURL.TRANSFER_CONFIRM)
	@ResponseBody
	public String transferConfirm(Long id, Integer confirmState){
		String msg = transferRecAO.confirmTransfer(id, confirmState);
//		if("success".equals(msg)){
//			//设置消息session中msgNum
//		}
		return msg;
	}
	
	
	
	
	
	
}
