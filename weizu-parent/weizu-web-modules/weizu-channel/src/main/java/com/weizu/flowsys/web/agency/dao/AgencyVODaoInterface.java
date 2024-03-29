package com.weizu.flowsys.web.agency.dao;

import java.util.List;
import java.util.Map;

import com.weizu.flowsys.core.dao.Dao;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;

/**
 * @description:
 * @projectName:weizu-channel
 * @className:AgencyVODaoInterface.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年11月23日 下午3:59:29
 * @version 1.0
 */
public interface AgencyVODaoInterface extends Dao<AgencyBackwardPo, Integer> {
	
	/**
	 * @description: 查看代理商有没有子代理商
	 * @param userName
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月5日 上午10:23:11
	 */
	int countSecondAgency(String userName);
	
	List<AgencyBackwardPo> getChildrenAgency(String userName);
	/**
	 * @description:查询代理商列表
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月22日 下午5:20:34
	 */
	List<AgencyBackwardVO> selectByAgencyVO(Map<String,Object> map);
	
	/**
	 * @description:更新代理商信息
	 * @param agencyBackwardPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月22日 下午5:29:42
	 */
//	int updateByAgencyPO(AgencyBackwardPo agencyBackwardPo);
	
	/**
	 * @description:更新自己的账户信息
	 * @param agencyBackwardVO
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月24日 下午5:58:20
	 */
	int updateByAgencyVO(AgencyBackwardVO agencyBackwardVO);
	
	/**
	 * @description:登陆之后查询所有信息（放到session中的loginContext信息）
	 * @param agencyBackwardPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月24日 下午6:16:22
	 */
	AgencyBackwardVO selectAgencyByPo(AgencyBackwardPo agencyBackwardPo);
	
	
	
	/**
	 * @description: 查询代理商个数 
	 * @param agencyBackwardVO
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月22日 下午5:40:13
	 */
	int countByAgencyVO(Map<String,Object> paramsMap);
	
	/**
	 * @description:通过邀请码查询（父级）代理商 id
	 * @param verifyCode
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月24日 下午5:09:50
	 */
	Integer getAgencyIdByVerifyCode (String verifyCode);
	
	/**
	 * @description: 查询是否id属于二级代理商以下(限制登陆用户权限)
	 * @param agencyId
	 * @return 1，属于
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月3日 上午10:20:20
	 */
	int checkSecondAgency(int agencyId);
	
	/**
	 * @description:  查询解绑流量折扣的代理商 
	 * @param map
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月17日 下午2:52:44
	 */
	List<AgencyBackwardVO> getUnbindAgency(Map<String,Object> paramsMap);
	/**
	 * @description:  查询解绑话费折扣的代理商 
	 * @param map
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月17日 下午2:52:44
	 */
	List<AgencyBackwardVO> getUnbindTelAgency(Map<String,Object> paramsMap);
	
	/**
	 * @description: 查询没有绑定流量折扣的代理商
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月18日 上午11:07:08
	 */
	List<AgencyBackwardVO> getNoBAgency(Map<String,Object> paramsMap);
	/**
	 * @description: 查询没有绑定话费折扣的代理商
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月18日 上午11:07:08
	 */
	List<AgencyBackwardVO> getNoBTelAgency(Map<String,Object> paramsMap);
	
	
	
	/**
	 * @description:  查询解绑的代理商个数
	 * @param rootAgencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月17日 下午3:22:12
	 */
	int countUnbindAgency(Map<String, Object> paramsMap);
	
	/**
	 * @description:查询解绑话费折扣的代理商个数
	 * @param paramsMap
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月23日 下午3:59:07
	 */
	int countUnbindTelAgency(Map<String, Object> paramsMap);
	
	
	/**
	 * @description: 查询没有绑定的代理商个数
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月18日 上午11:07:22
	 */
	int countNoBAgency(Map<String, Object> paramsMap);
	
	/**
	 * @description:查询没有绑定话费折扣的代理商个数
	 * @param paramsMap
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月23日 下午3:59:35
	 */
	int countNoBTelAgency(Map<String, Object> paramsMap);
	/**
	 * @description: 获得名字列表
	 * @param params
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月18日 下午3:35:09
	 */
	List<AgencyBackwardPo> getBatchAgency(AgencyBackwardPo params);
	
	/**
	 * @description: 更新密码
	 * @param paramMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月11日 上午10:19:04
	 */
//	int updateUserPass(Map<String,Object> paramMap);
	
	/** 查询是否属于二级代理商（接口用户）,是否可以通过接口传单 
	 * @param paramMap
	 * @return null
	 */
	AgencyBackwardPo getSecondAgency(String userName);
	/**
	 * @description: 查询是否属于二级代理商,通过页面传单的时候是否需要判断余额
	 * @param agencyId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月19日 下午6:02:02
	 */
	AgencyBackwardPo getSecondAgency(Integer agencyId);
	
	/**
	 * @description: 通过代理商id查询父级代理商实体
	 * @param agencyId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月19日 下午4:44:38
	 */
	AgencyBackwardPo getRootAgencyById(int agencyId);
	
	/**
	 * @description: 更新密码
	 * @param agencyId
	 * @param userPass
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月18日 下午2:33:54
	 */
	int updatePass(Integer agencyId,String userPass);
	
	/**
	 * @description:更新用户类型
	 * @param agencyId
	 * @param agencyTag
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月18日 下午6:02:51
	 */
	int updateAgencyTag(Integer agencyId,Map<String,Object> params);
	
	/**
	 * @description:查看邀请码是否符合条件
	 * @param verifyCode
	 * @param agencyName 待验证代理商名称
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月23日 上午11:47:05
	 */
	Integer checkVerifyCode(String verifyCode,String agencyName);
	
	/**
	 * @description: 通过账户id获得代理商实体
	 * @param accountId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月1日 下午3:23:20
	 */
	AgencyBackwardPo getAgencyByAccountId(Integer accountId);
}
