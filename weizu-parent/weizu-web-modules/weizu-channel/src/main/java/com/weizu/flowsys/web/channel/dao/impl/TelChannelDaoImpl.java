package com.weizu.flowsys.web.channel.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.operatorPg.enums.AgencyTagEnum;
import com.weizu.flowsys.operatorPg.enums.BindStateEnum;
import com.weizu.flowsys.operatorPg.enums.CallBackEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelUseStateEnum;
import com.weizu.flowsys.web.channel.dao.ITelChannelDao;
import com.weizu.flowsys.web.channel.pojo.TelChannelParams;
import com.weizu.flowsys.web.channel.pojo.TelChannelPo;

/**
 * @description: 话费通道dao层实现类
 * @projectName:weizu-channel
 * @className:TelChannelDaoImpl.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年11月14日 下午4:06:30
 * @version 1.0
 */
@Repository(value="telChannelDao")
public class TelChannelDaoImpl extends DaoImpl<TelChannelPo, Long> implements ITelChannelDao {

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int batchAddTelChannel(List<TelChannelPo> telChannelList) {
		return sqlSessionTemplate.insert("batchAddTelChannel", telChannelList);
	}

	@Override
	public List<TelChannelParams> getTelChannel(Map<String, Object> params) {
		
		return sqlSessionTemplate.selectList("getTelChannel", params);
	}

	@Override
	public Long countTelChanenl(Map<String, Object> params) {
		return sqlSessionTemplate.selectOne("countTelChanenl", params);
	}

	@Override
	public TelChannelParams selectByIdType(Map<String, Object> params) {
		return sqlSessionTemplate.selectOne("selectByIdType", params);
	}

	@Override
	public List<TelChannelParams> getMyTelChannel(Map<String, Object> params) {
		return sqlSessionTemplate.selectList("getMyTelChannel", params);
	}

	@Override
	public Long countMyTelChannel(Map<String, Object> params) {
		params.put("positive", CallBackEnum.POSITIVE.getValue());//bindSide
		params.put("negative", CallBackEnum.NEGATIVE.getValue());//话费折扣添加黑名单用户
		params.put("bind", BindStateEnum.BIND.getValue());//绑定状态
		params.put("useOpen", ChannelUseStateEnum.OPEN.getValue());
		return sqlSessionTemplate.selectOne("countMyTelChannel",params);
	}
	

}
