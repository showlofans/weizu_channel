package com.weizu.flowsys.web.agency.dao;

import java.util.List;
import java.util.Map;

import com.weizu.flowsys.core.dao.Dao;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;

public interface AgencyVODaoInterface extends Dao<AgencyBackwardPo, Integer> {
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
	int updateByAgencyPO(AgencyBackwardPo agencyBackwardPo);
	
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
	int countByAgencyVO(AgencyBackwardVO agencyBackwardVO);
	
	/**
	 * @description:通过邀请码查询代理商 id
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
	 * @description:  查询解绑的代理商 
	 * @param map
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月17日 下午2:52:44
	 */
	List<AgencyBackwardVO> getUnbindAgency(Map<String,Object> paramsMap);
	
	/**
	 * @description: 查询没有绑定的代理商
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月18日 上午11:07:08
	 */
	List<AgencyBackwardVO> getNoBAgency(Map<String,Object> paramsMap);
	
	/**
	 * @description:  查询解绑的代理商个数
	 * @param rootAgencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月17日 下午3:22:12
	 */
	int countUnbindAgency(Map<String, Object> paramsMap);
	
	/**
	 * @description: 查询没有绑定的代理商个数
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月18日 上午11:07:22
	 */
	int countNoBAgency(Map<String, Object> paramsMap);
	
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
	AgencyBackwardPo getSecondAgency(String userName,String userAPIKey);
	
}
