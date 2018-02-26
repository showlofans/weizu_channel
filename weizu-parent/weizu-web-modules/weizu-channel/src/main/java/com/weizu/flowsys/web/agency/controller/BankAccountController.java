package com.weizu.flowsys.web.agency.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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
import com.weizu.flowsys.core.annotation.po.TempField;
import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.CallBackEnum;
import com.weizu.flowsys.operatorPg.enums.ConfirmStateTransferEnum;
import com.weizu.flowsys.operatorPg.enums.InOrOutEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.agency.ao.AgencyAO;
import com.weizu.flowsys.web.agency.ao.BankAccountAO;
import com.weizu.flowsys.web.agency.ao.TransferRecAO;
import com.weizu.flowsys.web.agency.dao.BankAccountDaoInterface;
import com.weizu.flowsys.web.agency.dao.ChargeAccountDaoInterface;
import com.weizu.flowsys.web.agency.dao.ITransferRecDao;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;
import com.weizu.flowsys.web.agency.pojo.BankAccountPo;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.agency.pojo.TransferRecordPo;
import com.weizu.flowsys.web.agency.pojo.TransferRecordVO;
import com.weizu.flowsys.web.agency.url.BankAccountURL;

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
	@Resource
	private ChargeAccountDaoInterface chargeAccountDao;
	@Resource
	private AgencyAO agencyAO;
	
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
			bankAccountAO.getAttachBankList(accountId, agencyVo.getId(), resultMap);
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
				bankPo.setBaHide(CallBackEnum.NEGATIVE.getValue());
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
	
	
	
	/**
	 * @description:我的银行卡列表 (母卡列表)
	 * @param request
	 * @param baHIde
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年2月26日 上午9:30:12
	 */
	@RequestMapping(value=BankAccountURL.MY_BANK_LIST)
	public ModelAndView listBankAccount(HttpServletRequest request,@RequestParam(value="baHide",required=false)Integer baHIde){
		
		AgencyBackwardVO agencyVo = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		if(agencyVo != null){
			bankAccountAO.getMyBankList(agencyVo.getId(), baHIde, resultMap);
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
			//初始化列表信息
			bankAccountAO.getPlusBankList(agencyVo.getRootAgencyId(),accountId, resultMap);
		}else{
			return new ModelAndView("error", "errorMsg", "系统维护之后，用户未登陆！");
		}
		//
		BankAccountPo myBank = bankAccountAO.getBankPoById(id);//子代理商的银行卡id
		resultMap.put("myBank", myBank);
		//查询父级代理商
		AgencyBackwardPo rootAgency = agencyAO.getRootAgencyById(agencyVo.getRootAgencyId());
		resultMap.put("rootAgency", rootAgency);
		
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
	public ModelAndView addBankAccountPage(HttpServletRequest request,Integer accountId){
		Map<String,Object> resultMap = new HashMap<String,Object>();
//		resultMap.put("billType", billType);
		resultMap.put("accountId", accountId);
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
		if(bankPo.getAccountId() != null){
			ChargeAccountPo accountPo = chargeAccountDao.get(bankPo.getAccountId());
			if(accountPo != null){
				bankPo.setBillType(accountPo.getBillType());
				bankPo.setAccountId(accountPo.getId());
				//添加银行卡
				return bankAccountAO.addBank(bankPo);
			}
		}
//		if(BillTypeEnum.CORPORATE_BUSINESS.getValue().equals(bankPo.getBillType())){
//			ChargeAccountPo accountPo1 = (ChargeAccountPo)request.getSession().getAttribute("chargeAccount1");
//			if(accountPo1 != null){
//				bankPo.setAccountId(accountPo1.getId());
//				//添加银行卡
//				return bankAccountAO.addBank(bankPo);
//			}
//		}else{
//			ChargeAccountPo accountPo = (ChargeAccountPo)request.getSession().getAttribute("chargeAccount");
//			if(accountPo != null){
//				bankPo.setAccountId(accountPo.getId());
//				//添加银行卡
//				return bankAccountAO.addBank(bankPo);
//			}
//		}
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
	 * @description: 编辑所有子母银行卡i信息
	 * @param request
	 * @param id
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月9日 下午4:22:30
	 */
	@RequestMapping(value=BankAccountURL.EDIT_BANK)
	@ResponseBody
	public String editBankAccount(HttpServletRequest request,BankAccountPo bankPo){
		String msg = "error";
		if(bankPo.getId() != null){
			BankAccountPo paramsPo = bankAccountDao.get(bankPo.getId());
			if(paramsPo != null){
				int res = bankAccountDao.updateLocal(bankPo, new WherePrams("agency_id", "=", paramsPo.getAgencyId()).and("remittance_bank_account", "=", paramsPo.getRemittanceBankAccount()));
				if(res > 0){
					msg = "success";
				}
			}
		}
		return msg;
	}
	/**
	 * @description: 自己删除银行卡
	 * @param request
	 * @param id
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月9日 下午4:42:31
	 */
//	@Deprecated
//	@RequestMapping(value=BankAccountURL.DEL_BANK)
//	@ResponseBody
//	@Transactional
//	public String delBankAccount(HttpServletRequest request,Long id){
//		BankAccountPo bankPo = bankAccountDao.get(id);
//		//删除子母银行卡
//		int res = bankAccountDao.del(new WherePrams("agency_id", "=", bankPo.getAgencyId()).and("remittance_bank_account", "=", bankPo.getRemittanceBankAccount()));
//		if(res > 0){
//			return "success";
//		}else{
//			return "error";
//		}
//	}
	/**
	 * @description: 隐藏银行卡
	 * @param request
	 * @param id
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年2月25日 下午2:38:08
	 */
	@RequestMapping(value=BankAccountURL.DEL_BANK)
	@ResponseBody
	@Transactional
	public String hideBankAccount(HttpServletRequest request,Long id){
		BankAccountPo bankPo = bankAccountDao.get(id);
		String msg = "error";
		if(bankPo != null){
			bankPo.setBaHide(CallBackEnum.POSITIVE.getValue());//设为隐藏
			bankPo.setPolarity(CallBackEnum.POSITIVE.getValue());//改变银行卡的默认状态为不默认
			bankPo.setLastAccess(System.currentTimeMillis());
			int res = bankAccountDao.updateLocal(bankPo, new WherePrams("agency_id", "=", bankPo.getAgencyId()).and("remittance_bank_account", "=", bankPo.getRemittanceBankAccount()));
			//删除子母银行卡
//			int res = bankAccountDao.del(new WherePrams("agency_id", "=", bankPo.getAgencyId()).and("remittance_bank_account", "=", bankPo.getRemittanceBankAccount()));
			if(res > 0){
				msg = "success";
			}	
		}
		return msg;
	}
	/**
	 * @description: 银行卡上架/显示
	 * @param request
	 * @param id
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年2月26日 上午9:18:36
	 */
	@RequestMapping(value=BankAccountURL.SHOW_BANK)
	@ResponseBody
	@Transactional
	public String showBankAccount(HttpServletRequest request,Long id){
		BankAccountPo bankPo = bankAccountDao.get(id);
		String msg = "error";
		if(bankPo != null){
			bankPo.setBaHide(CallBackEnum.NEGATIVE.getValue());//设为隐藏
			bankPo.setLastAccess(System.currentTimeMillis());
			bankPo.setPolarity(CallBackEnum.NEGATIVE.getValue());//上架改变银行卡的默认状态为默认
			int res = bankAccountDao.updateLocal(bankPo, new WherePrams("agency_id", "=", bankPo.getAgencyId()).and("remittance_bank_account", "=", bankPo.getRemittanceBankAccount()));
			//删除子母银行卡
//			int res = bankAccountDao.del(new WherePrams("agency_id", "=", bankPo.getAgencyId()).and("remittance_bank_account", "=", bankPo.getRemittanceBankAccount()));
			if(res > 0){
				msg = "success";
			}	
		}
		return msg;
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
		
		//待确认转入==转账消息查看==更新消息记录数
		if(ConfirmStateTransferEnum.ON_CONFIRM.getValue().equals(confirmState) && InOrOutEnum.IN.getValue().equals(direction)){
			Pagination<TransferRecordVO> pagination = (Pagination<TransferRecordVO>)resultMap.get("pagination");
			List<TransferRecordVO> records = pagination.getRecords();
			if(records!= null){
				int unconfirmSize = records.size();
				if(unconfirmSize > 0){
					//request.getSession().setAttribute("unconfirmSize", 0);
					Object obj2 = request.getSession().getAttribute("msgNum");
					if(obj2 != null){
						int msgNum = (int)obj2;
						if(msgNum > 0){
							request.getSession().setAttribute("msgNum", msgNum-unconfirmSize);//设置总消息数
						}
						//request.getSession().setAttribute("unconfirm", null);//设置消息为不显示
					}
				}
			}
		}
		
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
