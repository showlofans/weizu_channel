package com.weizu.flowsys.web.activity.ao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weizu.flowsys.core.util.hibernate.util.StringHelper;
import com.weizu.flowsys.web.activity.dao.impl.ServiceScopeDao;
import com.weizu.flowsys.web.activity.pojo.ServiceScopePo;

/**
 * @description:流量范围AO层接口实现类
 * @projectName:crud
 * @className:ServiceScopeAOImpl.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月10日 下午2:51:25
 * @version 1.0
 */
@Service(value="serviceScopeAO")
public class ServiceScopeAOImpl implements ServiceScopeAO {

	@Resource
	private ServiceScopeDao serviceScopeDao;
	
	/**
	 * @description:查询所有运营商类型
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月10日 下午2:53:35
	 */
	@Override
	public List listOperatorType() {
		return serviceScopeDao.listOperatorType();
	}

	/**
	 * @description:查询所有城市
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月10日 下午2:53:55
	 */
	@Override
	public List listScopeCityName() {
		return serviceScopeDao.listScopeCityName();
	}

	/**
	 * @description:查询所有业务类型
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月10日 下午2:53:59
	 */
	@Override
	public List listServiceType() {
		return serviceScopeDao.listServiceType();
	}

	/**
	 * @description:通过参数查询范围Id（方便更新通道表的服务范围ID）
	 * @param params
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月10日 下午2:54:12
	 */
	@Override
	public String getServiceScopeId(ServiceScopePo serviceScopePo) {
		Map<String,Object> params = getParamsMap(serviceScopePo);
		return serviceScopeDao.getServiceScopeId(params);
	}

	/**
	 * @description:根据范围实体获得查询参数
	 * @param serviceScopePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月10日 下午3:09:12
	 */
	private Map<String, Object> getParamsMap(ServiceScopePo serviceScopePo) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		if(serviceScopePo.getOperatorType() != null){
			paramsMap.put("operatorType", serviceScopePo.getOperatorType());
		}
		if(serviceScopePo.getServiceType() != null){
			paramsMap.put("serviceType", serviceScopePo.getServiceType());
		}
		if(StringHelper.isNotEmpty(serviceScopePo.getScopeCityName())){
			paramsMap.put("scopeCityName", serviceScopePo.getScopeCityName());
		}
		if(StringHelper.isNotEmpty(serviceScopePo.getScopeCityCode())){
			paramsMap.put("scopeCityCode", serviceScopePo.getScopeCityCode());
		}
		
		return paramsMap;
	}

	/**
	 * @description:一次性初始化范围数据库表
	 * @param list
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月11日 下午6:03:50
	 */
	@Override
	public int scope_addList(List<ServiceScopePo> list) {
		return serviceScopeDao.scope_addList(list);
	}

}
