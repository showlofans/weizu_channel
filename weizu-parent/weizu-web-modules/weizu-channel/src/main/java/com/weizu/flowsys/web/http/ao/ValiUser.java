
package com.weizu.flowsys.web.http.ao;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.web.agency.dao.impl.AgencyBackwardDao;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
import com.weizu.flowsys.web.channel.dao.impl.OperatorPgDao;
import com.weizu.flowsys.web.channel.pojo.OperatorPgDataPo;
import com.weizu.web.foundation.MD5;

/**
 * @description: 验证调用接口用户是否合法
 * @projectName:weizu-channel
 * @className:ValiUser.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月23日 下午2:56:08
 * @version 1.0
 */
@Service(value="valiUser")
public class ValiUser {
	@Resource
	private AgencyBackwardDao agencyBackwardDao;
	@Resource
	private OperatorPgDao operatorPgDao;
	
	/**
	 * @description: 看代理商是否能传单
	 * @param agencyPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月23日 下午3:02:43
	 */
	public AgencyBackwardPo findAgency(String userName,String sign){
		//userapikey作为参数穿进去
		AgencyBackwardPo backPo = agencyBackwardDao.get(new WherePrams("user_name","=",userName));
		if(backPo == null){
			return null;
		}
		
		//用sign得到apikey
		
		String backAPIKey = backPo.getUserApiKey();
		String rightSign = MD5.getMd5(backAPIKey);
		if(rightSign.equals(sign)){
			return backPo;
		}else{
			return null;
		}
	}
	
	/**
	 * @description: 验证流量包是否存在
	 * @param scope
	 * @param operatorType
	 * @param pgSize
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月23日 下午4:59:55
	 */
	public OperatorPgDataPo findPg(int scope, int pgSize, int operatorType)
	{
		OperatorPgDataPo pgData = operatorPgDao.get(new WherePrams("service_type", "=", scope).and("pg_size", "=", pgSize).and("operator_type", "=", operatorType));
		return pgData;
	}
	
}
