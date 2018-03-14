package com.weizu.flowsys.web.activity.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.operatorPg.enums.AgencyTagEnum;
import com.weizu.flowsys.operatorPg.enums.BindStateEnum;
import com.weizu.flowsys.operatorPg.enums.CallBackEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelUseStateEnum;
import com.weizu.flowsys.operatorPg.enums.TelChannelTagEnum;
import com.weizu.flowsys.web.activity.dao.ITelRateDao;
import com.weizu.flowsys.web.activity.pojo.TelRatePo;
import com.weizu.flowsys.web.trade.pojo.GetTelRatePo;

/**
 * @description: 话费折扣Dao
 * @projectName:weizu-channel
 * @className:TelRateDaoImpl.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年11月16日 下午3:26:34
 * @version 1.0
 */
@Repository(value="telRateDao")
public class TelRateDaoImpl extends DaoImpl<TelRatePo, Long> implements ITelRateDao {

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<TelRatePo> listByTelRatePo(TelRatePo telRatePo) {
		WherePrams where = new WherePrams("1", "=", "1");
		if(telRatePo.getTelchannelId() != null){
			where.and("telchannel_id", "=", telRatePo.getTelchannelId());
		}
		if(telRatePo.getBillType() != null){
			where.and("bill_type", "=", telRatePo.getBillType());
		}
		if(telRatePo.getRateFor() != null){
			where.and("rate_for", "=", telRatePo.getRateFor());
		}
		return list(where);
	}

	@Override
	public List<GetTelRatePo> getTelRateForCharge(Map<String, Object> map) {
		map.put("positive", CallBackEnum.POSITIVE.getValue());//bindSide
		map.put("negative", CallBackEnum.NEGATIVE.getValue());//话费折扣添加黑名单用户
		map.put("bind", BindStateEnum.BIND.getValue());//绑定状态
		map.put("useOpen", ChannelUseStateEnum.OPEN.getValue());
		return sqlSessionTemplate.selectList("getTelRateForCharge", map);
	}

	@Override
	public TelRatePo getPlatTelRateById(Long telRateId, Integer contextId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("telRateId", telRateId);
		map.put("createAgency", contextId);
		map.put("platformUser", TelChannelTagEnum.PLATFORM_USER.getValue());
		return sqlSessionTemplate.selectOne("getPlatTelRateById", map);
	}

	@Override
	public long delByIteratorFun(Long telRateId) {
		return sqlSessionTemplate.delete("delByIteratorFun", telRateId);
	}

	@Override
	public TelRatePo getTelRateByParams(Map<String, Object> map) {
		return sqlSessionTemplate.selectOne("getTelRateByParams", map);
	}


}
