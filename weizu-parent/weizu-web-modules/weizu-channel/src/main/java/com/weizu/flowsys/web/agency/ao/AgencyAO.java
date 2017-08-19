package com.weizu.flowsys.web.agency.ao;

import java.util.List;
import java.util.Map;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.pojo.AgencyActiveRateDTO;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;


public interface AgencyAO {

	/**
	 * @description:注册代理商
	 * @param agencyBackward
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年4月19日 下午4:42:07
	 */
	AgencyBackwardVO addAgency(AgencyBackwardPo agencyBackward);
	/**
	 * @description:修改代理商
	 * @param agencyBackward
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年4月19日 下午4:42:55
	 */
	int updateAgency(AgencyBackwardVO agencyBackwardVO);
	
	/**
	 * @description:登陆
	 * @param agencyBackward
	 * @return	结果集
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年4月22日 上午9:45:55
	 */
	Map<String,Object> login(AgencyBackwardPo agencyBackward);
	
	/**
	 * @description:通过根代理商获得子代理商列表
	 * @param rootAgencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月6日 下午12:12:56
	 */
	List<AgencyBackwardPo> ListAgencyByRoot(int rootAgencyId);
	
	/**
	 * @description:通过根代理商获得子代理商分页列表
	 * @param rootAgencyId
	 * @param searchMap
	 * @param pageParam
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月6日 下午12:33:50
	 */
	Pagination<AgencyBackwardVO> ListAgencyByRoot(int rootAgencyId,AgencyBackwardVO agencyBackwardVO,PageParam pageParam); 
	
	/**
	 * @description:封装查询参数
	 * @param agencyBackward
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月6日 下午12:25:40
	 */
	Map<String,Object> getSearchParam(AgencyBackwardVO agencyBackward);
	
	/**
	 * @description:编辑代理商信息准备参数
	 * @param agBackwardPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月22日 上午10:57:15
	 */
	Map<String,Object> prepareParam(AgencyBackwardPo agBackwardPo);
	
	/**
	 * @description:编辑代理商信息准备参数
	 * @param id
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月22日 下午4:07:13
	 */
	Map<String,Object> prepareParam(String id);
	
	/**
	 * @description:通过代理商id获得该代理商的邀请码
	 * @param id
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月23日 下午4:09:35
	 */
	String getVerifyCodeById(int id);
	
	AgencyBackwardVO getVOByPo(AgencyBackwardPo agencyBackward);
	
	/**
	 * @description:通过id找到代理商实体
	 * @param id
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月27日 上午10:23:55
	 */
	AgencyBackwardPo getAgencyById(String id);
	
	/**
	 * @description: 获得父级代理商的实体
	 * @param id
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月19日 下午4:34:17
	 */
	AgencyBackwardPo getRootAgencyById(Integer id);
	
	
	/**
	 * @description: 查询是否id属于二级代理商以下(限制登陆用户权限)
	 * @param agencyId
	 * @return 1，属于
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月3日 上午10:20:20
	 */
	int checkSecondAgency(int agencyId);
	
	/**
	 * @description: 修改密码
	 * @param agencyId
	 * @param enterPass
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月11日 上午10:10:43
	 */
	int updatePass(int agencyId,String enterPass);
	
	/**
	 * @description: remote验证用户名是否存在
	 * @param name
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月17日 上午11:27:54
	 */
	boolean checkName(String name); 
	
	/**
	 * @description: 查询没有绑定的代理商
	 * @param rootAgencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月17日 下午3:21:21
	 */
	Pagination<AgencyBackwardVO> getUnbindAgency(int rootAgencyId, AgencyActiveRateDTO aardto, PageParam pageParam);
	
}
