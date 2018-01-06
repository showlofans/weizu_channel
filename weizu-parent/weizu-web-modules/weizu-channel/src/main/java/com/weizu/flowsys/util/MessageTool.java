package com.weizu.flowsys.util;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.weizu.flowsys.operatorPg.enums.ConfirmStateEnum;
import com.weizu.flowsys.operatorPg.enums.ConfirmStateTransferEnum;
import com.weizu.flowsys.web.agency.ao.ChargeAccountAo;
import com.weizu.flowsys.web.agency.dao.BankAccountDaoInterface;
import com.weizu.flowsys.web.agency.pojo.CompanyCredentialsPo;
import com.weizu.flowsys.web.agency.pojo.TransferMsgVo;

/**
 * @description: 消息管理类
 * @projectName:weizu-channel
 * @className:MessageTool.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年1月6日 上午11:24:30
 * @version 1.0
 */
@Service("messageTool")
public class MessageTool {
	@Resource
	private BankAccountDaoInterface bankAccountDao;
	@Resource
	private ChargeAccountAo chargeAccountAO;

	/**
	 * @description: 设置消息属性
	 * @param session
	 * @param agencyId
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月6日 上午11:27:38
	 */
	public void setMsg(Integer agencyId, HttpSession session){
		int msgNum = 0;//总消息数
		//认证审核消息
		List<CompanyCredentialsPo> list = chargeAccountAO.getUnconfirmedAccount(agencyId,ConfirmStateEnum.ON_CONFIRM.getValue());
		int unconfirmSize = 0;
		if(list != null && list.size() > 0){
			//session.setAttribute("unconfirm", list.get(0));
			unconfirmSize = list.size();
		}
		//转账消息
		List<TransferMsgVo> transferMsgList = bankAccountDao.getTransferMsg(agencyId, ConfirmStateTransferEnum.ON_CONFIRM.getValue());
		if(transferMsgList != null && transferMsgList.size() > 0){
			for (TransferMsgVo transferMsgVo : transferMsgList) {
				msgNum += transferMsgVo.getTfnum();
			}
		}
		msgNum += unconfirmSize;//认证审核消息
		session.setAttribute("transferMsgList", transferMsgList);
		session.setAttribute("unconfirmSize", unconfirmSize);
		session.setAttribute("msgNum", msgNum);
	}
}
