package com.weizu.flowsys.web.http.ao;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.weizu.api.outter.enums.BalanceCheckEnum;

import com.weizu.flowsys.api.singleton.BalanceDTO;
import com.weizu.flowsys.api.weizu.facet.IBalanceFacet;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.web.agency.ao.ChargeAccountAo;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;

/**
 * @description:  余额查询接口实现类
 * @projectName:weizu-channel
 * @className:BalanceFacadeImpl.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月23日 下午4:37:44
 * @version 1.0
 */
@Service(value="balanceFacade")
public class BalanceFacadeImpl implements IBalanceFacet {

	@Resource
	private ValiUser valiUser;
	
	@Resource
	private ChargeAccountAo chargeAccountAO;
	
	/**
	 * @description: 余额查询接口实现
	 * @param userName
	 * @param sign
	 * @param billType
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月23日 下午4:37:30
	 */
	@Override
	public BalanceDTO myBalance(String userName, String sign,Integer billType) {
		AgencyBackwardPo backPo = valiUser.findAgency(userName, sign);
		BalanceDTO balanceDTO = null;
		BalanceCheckEnum bcEnum = null;
		if(backPo == null)
		{
			bcEnum = BalanceCheckEnum.AUTHENTICATION_FAILURE;
			balanceDTO = new BalanceDTO(null,bcEnum.getValue(), bcEnum.getDesc(), billType);
		}
		else
		{
			ChargeAccountPo account = null;
			if(BillTypeEnum.BUSINESS_INDIVIDUAL.getValue() != billType && BillTypeEnum.CORPORATE_BUSINESS.getValue() != billType)
			{
				bcEnum = BalanceCheckEnum.BILL_TYPE_ERROR;
				balanceDTO = new BalanceDTO(null,bcEnum.getValue(), bcEnum.getDesc(), billType);
				return balanceDTO;
			}else{
				if(BillTypeEnum.BUSINESS_INDIVIDUAL.getValue() == billType){
					account = chargeAccountAO.getAccountByAgencyId(backPo.getId(),BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
				}else if(BillTypeEnum.CORPORATE_BUSINESS.getValue() == billType){
					account = chargeAccountAO.getAccountByAgencyId(backPo.getId(),BillTypeEnum.CORPORATE_BUSINESS.getValue());
				}
				if(account == null){
					bcEnum = BalanceCheckEnum.ACCOUNT_NOT_FOUND;
					balanceDTO = new BalanceDTO(null, bcEnum.getValue(), bcEnum.getDesc(), billType);
				}else{
					bcEnum = BalanceCheckEnum.AUTHENTICATION_SUCCESS;
					balanceDTO = new BalanceDTO(account.getAccountBalance(), bcEnum.getValue(), bcEnum.getDesc(), billType);
				}
			}
		}
		return balanceDTO;
	}

}
