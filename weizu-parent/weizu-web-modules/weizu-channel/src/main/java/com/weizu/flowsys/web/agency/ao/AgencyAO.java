package com.weizu.flowsys.web.agency.ao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.pojo.AccountActiveRateDTO;
import com.weizu.flowsys.web.activity.pojo.TelrateBindAccountPo;
import com.weizu.flowsys.web.activity.pojo.TelrateBindAccountVO;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;


public interface AgencyAO {

	/**
	 * @description:注册代理商，把代理商相关信息放入session当中
	 * @param agencyBackward
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年4月19日 下午4:42:07
	 */
	Integer addAgency(HttpSession httpSession,AgencyBackwardPo agencyBackward);
	/**
	 * @description:修改代理商
	 * @param agencyBackward
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年4月19日 下午4:42:55
	 */
	int updateAgency(AgencyBackwardVO agencyBackwardVO);
	
	/**
	 * @description: 修改代理商
	 * @param agencyBackwardPo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年2月24日 下午6:23:48
	 */
	int updateAgency(AgencyBackwardPo agencyBackwardPo);
	
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
//	Map<String,Object> prepareParam(AgencyBackwardPo agBackwardPo);
	
	/**
	 * @description:编辑代理商信息准备参数
	 * @param id
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月22日 下午4:07:13
	 */
	AgencyBackwardPo prepareParam(Integer id);
	
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
	AgencyBackwardPo getAgencyById(Integer id);
	
	/**
	 * @description: 通过账户id获得代理商信息
	 * @param accountId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月21日 下午2:47:08
	 */
	AgencyBackwardPo getAgencyByAccountId(Integer accountId);
	
	/**
	 * @description:通过账户id获得父级代理商信息
	 * @param accountId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月25日 上午11:26:54
	 */
	AgencyBackwardPo getRootAgencyByAccountId(Integer accountId);
	
	
	
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
	int checkNextSecondAgency(int agencyId);
	
	/**
	 * @description:查看是否是二级代理商
	 * @param agencyId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月22日 下午1:12:24
	 */
	boolean checkSecondAgency(int agencyId);
	
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
	 * @description: remote验证邀请码是否存在
	 * @param verifiCode
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月3日 下午2:48:14
	 */
	boolean checkVerifiCode(String verifiCode); 
	
	
	
	/**
	 * @description: 查看登陆用户是否合法（密码是否正确）
	 * @param agencyId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月22日 上午10:59:48
	 */
	Boolean checkIdByPass(int agencyId,String userPass);
	
	/**
	 * @description: 查询没有绑定的代理商
	 * @param rootAgencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月17日 下午3:21:21
	 */
	Pagination<AgencyBackwardVO> getUnbindAgency(int billTypeRate, int rootAgencyId, AccountActiveRateDTO aardto, PageParam pageParam);
	
	/**
	 * @description: 查询没有绑定话费折扣的代理商
	 * @param billTypeRate
	 * @param rootAgencyId
	 * @param telrateBindAccountPo
	 * @param pageParam
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月23日 下午3:57:13
	 */
	Pagination<AgencyBackwardVO> getUnbindTelAgency( int rootAgencyId, TelrateBindAccountVO telrateBindAccountVO, PageParam pageParam);
	
	
	
	/**
	 * @description: 查询没有绑定或者已经解绑的的代理商不分页列表
	 * @param billTypeRate
	 * @param rootAgencyId
	 * @param aardto
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月20日 下午3:24:09
	 */
	List<AgencyBackwardVO> getUnbindAgencyList(int billTypeRate, int rootAgencyId, AccountActiveRateDTO aardto);
	/**
	 * @description: 查询没有绑定或者已经解绑话费折扣的代理商不分页列表
	 * @param billTypeRate
	 * @param rootAgencyId
	 * @param aardto
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月20日 下午3:24:09
	 */
	List<AgencyBackwardVO> getUnbindTelAgencyList(int rootAgencyId, TelrateBindAccountVO telrateBindAccountVO);
	
	
	
	/**
	 * @description:查看邀请码是否符合条件
	 * @param verifyCode
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月23日 上午11:47:05
	 */
	Boolean checkVerifyCode(String verifyCode,String userName);
	
	/**
	 * @description: 获得客户端登陆ip地址
	 * @param request
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月7日 上午9:14:26
	 */
//	String getLoginIpAddress(HttpServletRequest request);
	
}
