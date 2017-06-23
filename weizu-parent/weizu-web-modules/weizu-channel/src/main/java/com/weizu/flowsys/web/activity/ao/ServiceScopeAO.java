package com.weizu.flowsys.web.activity.ao;

import java.util.List;
import java.util.Map;

import com.weizu.flowsys.web.activity.pojo.ServiceScopePo;

/**
 * @description:流量范围AO层接口
 * @projectName:crud
 * @className:ServiceScopeAO.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月10日 下午2:49:35
 * @version 1.0
 */
public interface ServiceScopeAO {
	/**
	 * @description:查询所有运营商类型
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月10日 下午2:16:05
	 */
	List listOperatorType();
	/**
	 * @description:查询所有城市
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月10日 下午2:22:14
	 */
	List listScopeCityName();
	/**
	 * @description:查询所有业务类型
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月10日 下午2:23:33
	 */
	List listServiceType();
	
	/**
	 * @description:根据范围实体获得查询参数
	 * @param serviceScopePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月10日 下午3:08:30
	 */
//	Map<String,Object> getParamsMap(ServiceScopePo serviceScopePo);
	
	/**
	 * @description:通过参数查询范围Id（方便更新通道表的服务范围ID）
	 * @param params
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月10日 下午2:25:15
	 */
	String getServiceScopeId(ServiceScopePo serviceScopePo);
	
	/**
	 * @description: 一次性初始化范围数据库表 
	 * @param list
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月11日 下午6:01:26
	 */
	int scope_addList(List<ServiceScopePo> list);
}
