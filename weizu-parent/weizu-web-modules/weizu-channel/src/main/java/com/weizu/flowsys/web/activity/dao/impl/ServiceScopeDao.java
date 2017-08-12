package com.weizu.flowsys.web.activity.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.web.activity.dao.ServiceScopeDaoInterface;
import com.weizu.flowsys.web.activity.pojo.ServiceScopePo;

/**
 * @description:流量包业务范围dao层
 * @projectName:crud
 * @className:ServiceScopeDao.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月10日 下午2:14:41
 * @version 1.0
 */
@Repository(value="serviceScopeDao")
public class ServiceScopeDao extends DaoImpl<ServiceScopePo, String> implements
		ServiceScopeDaoInterface {
	
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * @description:查询所有运营商类型
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月10日 下午2:26:44
	 */
	@Override
	public List listOperatorType() {
		
		return sqlSessionTemplate.selectList("listOperatorType");
	}

	/**
	 * @description:查询所有城市
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月10日 下午2:26:54
	 */
	@Override
	public List listScopeCityName() {

		return sqlSessionTemplate.selectList("listScopeCityName");
	}

	/**
	 * @description:查询所有业务类型
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月10日 下午2:27:03
	 */
	@Override
	public List listServiceType() {

		return sqlSessionTemplate.selectList("listServiceType");
	}

	/**
	 * @description:通过参数查询范围Id（方便更新通道表的服务范围ID）
	 * @param params
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月10日 下午2:27:18
	 */
	@Override
	public String getServiceScopeId(Map<String, Object> params) {
		
		return sqlSessionTemplate.selectOne("getServiceScopeId", params);
	}

	/**
	 * @description:一次性初始化范围数据库表
	 * @param list
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月11日 下午6:02:08
	 */
	@Override
	public int scope_addList(List<ServiceScopePo> list) {
		return sqlSessionTemplate.insert("scope_addList", list);
	}
	
}
