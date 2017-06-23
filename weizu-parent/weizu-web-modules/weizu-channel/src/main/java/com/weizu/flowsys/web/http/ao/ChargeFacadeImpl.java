package com.weizu.flowsys.web.http.ao;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.weizu.api.outter.facade.ChargeFacade;
import org.weizu.api.outter.pojo.charge.ChargeDTO;
import org.weizu.api.outter.pojo.charge.ChargeParams;

import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
import com.weizu.flowsys.web.channel.pojo.OperatorPgDataPo;

/**
 * @description: 充值对外接口实现类
 * @projectName:weizu-channel
 * @className:ChargeFacadeImpl.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月23日 下午4:41:42
 * @version 1.0
 */
@Service("chargeFacade")
public class ChargeFacadeImpl implements ChargeFacade {

	@Resource
	private ValiUser valiUser;
	
	/**
	 * @description: 充值接口
	 * @param chargeParams
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月23日 下午4:41:57
	 */
	/**
	 * @description:
	 * @param chargeParams
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月23日 下午5:18:01
	 */
	@Override
	public ChargeDTO charge(ChargeParams chargeParams) {
		ChargeDTO chargeDTO = null;
		AgencyBackwardPo backPo = valiUser.findAgency(chargeParams.getUsername(), chargeParams.getSign());
		
		OperatorPgDataPo pgData = null;
		try {
			int scope = Integer.parseInt(chargeParams.getScope());
			int pgSize = Integer.parseInt(chargeParams.getFlowsize());
			pgData = valiUser.findPg(scope, pgSize);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return new ChargeDTO(7, "数据参数格式不对", null);
		}
		//充值用户不合法
		if(backPo == null)
		{
			chargeDTO = new ChargeDTO(0, "用户验证失败", null);
		}
		//充值流量包体不存在
		else if(pgData == null)
		{
			chargeDTO = new ChargeDTO(8, "充值包体不存在", null);
		}else
		{//充值并返回最新的订单（状态）
			
		}
		
		return chargeDTO;
	}

}
