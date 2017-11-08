
package com.weizu.flowsys.web.http.ao;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.operatorPg.enums.ChannelTypeEnum;
import com.weizu.flowsys.operatorPg.enums.PgServiceTypeEnum;
import com.weizu.flowsys.operatorPg.enums.PgTypeEnum;
import com.weizu.flowsys.operatorPg.enums.PgValidityEnum;
import com.weizu.flowsys.web.agency.dao.AgencyVODaoInterface;
import com.weizu.flowsys.web.agency.dao.impl.AgencyBackwardDao;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
import com.weizu.flowsys.web.channel.dao.impl.OperatorPgDao;
import com.weizu.flowsys.web.channel.pojo.OperatorPgDataPo;
import com.weizu.flowsys.web.channel.pojo.PgDataPo;
import com.weizu.web.foundation.MD5;
import com.weizu.web.foundation.String.StringHelper;
import com.weizu.web.foundation.hash.Hash;

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
//	@Resource
//	private AgencyBackwardDao agencyBackwardDao;
	@Resource
	private AgencyVODaoInterface agencyVODao;
	@Resource
	private OperatorPgDao operatorPgDao;
	
	
	/**
	 * @description: 看代理商是否能传单
	 * @param userName
	 * @param sign 用户传过来的经指定md5加密过的认证参数
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月16日 下午2:12:25
	 */
	public AgencyBackwardPo findAgency(String userName,String sign){
		//userapikey作为参数穿进去
		
//		AgencyBackwardPo backPo1 = agencyBackwardDao.get(new WherePrams("user_name","=",userName));
		AgencyBackwardPo backPo = agencyVODao.getSecondAgency(userName);
		if(backPo == null){
			return null;
		}
		
		String backAPIKey = backPo.getUserApiKey();
		String dataUserPass = Hash.BASE_UTIL.decode(backPo.getUserPass());
		
		String rightSign = null;
		try {
			rightSign = MD5.getMd5("userName="+backPo.getUserName()+"&userPass="+dataUserPass+"&apikey="+backAPIKey,null,null);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
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
	public PgDataPo findPg(PgDataPo pgDataPo)
	{
		WherePrams whereP = new WherePrams("service_type", "=", pgDataPo.getServiceType()).and("pg_size", "=", pgDataPo.getPgSize()).and("operator_type", "=", pgDataPo.getOperatorType());
		if(pgDataPo.getPgServiceType() == null){//默认使用流量包
			whereP.and("pg_service_type", "=", PgServiceTypeEnum.PGCHARGE.getValue());
		}
		else{//是否话费和流量都用同样的接口进行充值
			whereP.and("pg_service_type", "=", pgDataPo.getPgServiceType());
		}
		if(pgDataPo.getPgType() == null){//默认使用流量包
			whereP.and("pg_type", "=", PgTypeEnum.PGDATA.getValue());
		}else{
			whereP.and("pg_type", "=", pgDataPo.getPgType());
		}
		if(pgDataPo.getCirculateWay() == null){//默认使用流量包
			whereP.and("circulate_way", "=", ChannelTypeEnum.ORDINARY.getValue());
		}else{
			whereP.and("circulate_way", "=", pgDataPo.getCirculateWay());
		}
		
		if(StringHelper.isEmpty(pgDataPo.getPgValidity())){//默认使用月包
			whereP.and("pg_validity", "=", PgValidityEnum.MONTH_DAY_DATA.getValue());
		}else{
			whereP.and("pg_validity", "=", pgDataPo.getPgValidity());
		}
		
		
		
		
		
		PgDataPo pgData = operatorPgDao.get(whereP);
		return pgData;
	}
	
}
