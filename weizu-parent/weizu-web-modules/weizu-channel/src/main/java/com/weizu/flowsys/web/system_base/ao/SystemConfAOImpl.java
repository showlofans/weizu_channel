package com.weizu.flowsys.web.system_base.ao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.operatorPg.enums.CallBackEnum;
import com.weizu.flowsys.web.system_base.dao.SystemConfDaoInterface;
import com.weizu.flowsys.web.system_base.pojo.SystemConfPo;
import com.weizu.flowsys.web.system_base.url.ConfConstants;
import com.weizu.web.foundation.DateUtil;
import com.weizu.web.foundation.String.StringHelper;

/**
 * @description: 系统参数配置业务层
 * @projectName:weizu-channel
 * @className:SystemConfAOImpl.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年1月23日 下午3:35:01
 * @version 1.0
 */
@Service(value="systemConfAO")
public class SystemConfAOImpl implements SystemConfAO {

	@Resource
	private SystemConfDaoInterface systemConfDao;
	
	@Override
	public void getConf(SystemConfPo systemConfPo, Map<String,Object> resultMap) {
		WherePrams where = new WherePrams("1", "=", 1);
		if(StringHelper.isNotEmpty(systemConfPo.getConfKey())){
			where.and("conf_key", "like", systemConfPo.getConfKey());
		}
		if(StringHelper.isNotEmpty(systemConfPo.getConfValue())){
			where.and("conf_value", "like", systemConfPo.getConfValue());
		}
		if(StringHelper.isNotEmpty(systemConfPo.getConfDesc())){
			where.and("conf_desc", "like", systemConfPo.getConfDesc());
		}
		
		List<SystemConfPo> list = systemConfDao.list(where);
		for (SystemConfPo systemConfPo2 : list) {
			systemConfPo2.setLastAccessStr(DateUtil.formatAll(systemConfPo2.getLastAccess()));
//			systemConfPo2.setLastAccessStr(DateUtil.formatPramm(systemConfPo2.getLastAccess(), "yyyy-MM-dd"));
			String key = systemConfPo2.getConfKey();
			if(ConfConstants.FAIL_BACK.equals(key)){
				if(StringHelper.isNotEmpty(systemConfPo2.getConfValue())){
					int confValue = Integer.parseInt(systemConfPo2.getConfValue());
					if(CallBackEnum.POSITIVE.getValue().equals(confValue)){
						systemConfPo2.setConfDetail("是");
					}else{
						systemConfPo2.setConfDetail("否");
					}
				}
				resultMap.put("failBack", systemConfPo2);
			}
			else if(ConfConstants.CHARGETELTIMES_IN_ONEDAY.equals(key)){
				resultMap.put("chargeTelTimesInOneDay", systemConfPo2);
			}
			
		}
//		return list;
	}

	@Override
	public SystemConfPo getByKey(String confKey) {
		WherePrams where = new WherePrams("conf_key", "=", confKey);
		SystemConfPo systemConfPo =systemConfDao.get(where);
		return systemConfPo;
	}

}
