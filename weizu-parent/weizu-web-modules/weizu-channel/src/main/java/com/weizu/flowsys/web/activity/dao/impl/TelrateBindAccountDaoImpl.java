package com.weizu.flowsys.web.activity.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.operatorPg.enums.BindStateEnum;
import com.weizu.flowsys.web.activity.dao.ITelrateBindAccountDao;
import com.weizu.flowsys.web.activity.pojo.TelrateBindAccountPo;
import com.weizu.flowsys.web.activity.pojo.TelrateBindAccountVO;

/**
 * @description:
 * @projectName:weizu-channel
 * @className:TelrateBindAccountDaoImpl.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年11月16日 下午3:29:03
 * @version 1.0
 */
@Repository(value="telrateBindAccountDao")
public class TelrateBindAccountDaoImpl extends DaoImpl<TelrateBindAccountPo, Long> implements
		ITelrateBindAccountDao {

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int batchUpdateBindTelState(long telRateId, int bindState,
			int[] accountIds) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("telRateId", telRateId);
		paramsMap.put("bindState", bindState);
		paramsMap.put("accountIds", accountIds);
		if(BindStateEnum.UNBIND.getValue() == bindState){
			paramsMap.put("activeTime", 0);//解绑设置活动时间为0
		}else{
			paramsMap.put("activeTime", System.currentTimeMillis());//解绑设置活动时间为0
		}
		return sqlSessionTemplate.update("updateBindTelState", paramsMap);
	}
	
	@Override
	public int batchInsert(List<TelrateBindAccountPo> tbapList) {
		return sqlSessionTemplate.insert("batchInsertTBA", tbapList);
	}

	@Override
	public int batchUpdateBindTelState(long telRateId, int bindState) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("telRateId", telRateId);
		paramsMap.put("bindState", bindState);
		return sqlSessionTemplate.update("updateBindTelState", paramsMap);
	}

	@Override
	public int updateBindState(Map<String, Object> params) {
		return sqlSessionTemplate.update("updateBindTelState", params);
	}

//	@Override
//	public int batch_bindTelList(List<TelrateBindAccountPo> list) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	
	
}
