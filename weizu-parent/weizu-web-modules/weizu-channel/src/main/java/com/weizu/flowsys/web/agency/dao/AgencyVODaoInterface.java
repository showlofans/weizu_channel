package com.weizu.flowsys.web.agency.dao;

import java.util.List;
import java.util.Map;

import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;

public interface AgencyVODaoInterface {
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
	 * @description: 更新密码
	 * @param paramMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月11日 上午10:19:04
	 */
//	int updateUserPass(Map<String,Object> paramMap);
}
