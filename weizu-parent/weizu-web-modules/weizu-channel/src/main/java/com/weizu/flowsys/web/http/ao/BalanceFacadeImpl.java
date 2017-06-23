package com.weizu.flowsys.web.http.ao;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.weizu.api.outter.facade.BalanceFacade;
import org.weizu.api.outter.pojo.BalanceDTO;

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
public class BalanceFacadeImpl implements BalanceFacade {

	@Resource
	private ValiUser valiUser;
	
	@Resource
	private ChargeAccountAo chargeAccountAO;
	
	/**
	 * @description: 余额查询接口实现
	 * @param userName
	 * @param sign
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月23日 下午4:37:30
	 */
	@Override
	public BalanceDTO myBalance(String userName, String sign) {
		AgencyBackwardPo backPo = valiUser.findAgency(userName, sign);
		BalanceDTO balanceDTO = null;
		if(backPo == null)
		{
			balanceDTO = new BalanceDTO(0, "用户验证失败","0","0");
		}
		else
		{
			ChargeAccountPo account = chargeAccountAO.getAccountByAgencyId(backPo.getId());
			balanceDTO = new BalanceDTO(1, "用户验证成功",account.getAccountBalance() + "",account.getAccountCredit()+ "");
		}
		return balanceDTO;
	}

}
