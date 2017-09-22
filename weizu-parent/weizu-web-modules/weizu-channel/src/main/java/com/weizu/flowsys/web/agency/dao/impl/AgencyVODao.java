package com.weizu.flowsys.web.agency.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.operatorPg.enums.AgencyTagEnum;
import com.weizu.flowsys.web.agency.dao.AgencyVODaoInterface;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;

@Repository("agencyVODao")
public class AgencyVODao extends DaoImpl<AgencyBackwardPo, Integer> implements AgencyVODaoInterface {
	@Resource
	private SqlSessionTemplate sqlSessionTemplateASS;

	/**
	 * @description:
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月22日 下午5:20:42
	 */
	@Override
	public List<AgencyBackwardVO> selectByAgencyVO(Map<String,Object> map) {
		return sqlSessionTemplateASS.selectList("selectByAgencyVO",map);
	}

	/**
	 * @description:更新代理商信息
	 * @param agencyBackwardPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月22日 下午5:29:07
	 */
//	@Override
//	public int updateByAgencyPO(AgencyBackwardPo agencyBackwardPo) {
//		
//		return sqlSessionTemplateASS.update("updateByAgencyPO",agencyBackwardPo);
//	}

	/**
	 * @description: 查询代理商个数 
	 * @param agencyBackwardVO
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月22日 下午5:40:50
	 */
	@Override
	public int countByAgencyVO(AgencyBackwardVO agencyBackwardVO) {
		
		return sqlSessionTemplateASS.selectOne("countByAgencyVO",agencyBackwardVO);
	}

	/**
	 * @description:通过邀请码查询代理商 id
	 * @param verifyCode
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月24日 下午5:10:12
	 */
	@Override
	public Integer getAgencyIdByVerifyCode(String verifyCode) {
			//因为注册的时间不一样，所以生成的随机数邀请码也不一样
		return sqlSessionTemplateASS.selectOne("getAgencyIdByVerifyCode",verifyCode);//asset-只有一个结果
	}

	@Override
	public int updateByAgencyVO(AgencyBackwardVO agencyBackwardVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AgencyBackwardVO selectAgencyByPo(AgencyBackwardPo agencyBackwardPo) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @description: 查询是否id属于二级代理商以下(限制登陆用户权限)
	 * @param agencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月3日 上午10:21:06
	 */
	@Override
	public int checkSecondAgency(int agencyId) {
		return sqlSessionTemplateASS.selectOne("checkSecondAgency",agencyId);//asset-只有一个结果
	}

	/**
	 * @description:  查询没有绑定的代理商 
	 * @param map
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月17日 下午2:53:11
	 */
	@Override
	public List<AgencyBackwardVO> getUnbindAgency(Map<String,Object> paramsMap) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("bindState", bindState);
//		map.put("rootAgencyId", rootAgencyId);
		return sqlSessionTemplateASS.selectList("getUnbindAgency", paramsMap);
	}

	/**
	 * @description:  查询没有绑定的代理商 
	 * @param rootAgencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月17日 下午3:22:38
	 */
	@Override
	public int countUnbindAgency(Map<String, Object> paramsMap) {
//		Map<String,Object> map = new HashMap<String, Object>();
//		map.put("rootAgencyId", rootAgencyId);
//		map.put("rateDiscountId", rateDiscountId);
		return sqlSessionTemplateASS.selectOne("countUnbindAgency", paramsMap);
	}

	/**
	 * @description: 查询没有绑定的代理商
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月18日 上午11:38:00
	 */
	@Override
	public List<AgencyBackwardVO> getNoBAgency(Map<String, Object> paramsMap) {
		return sqlSessionTemplateASS.selectList("getNoBAgency", paramsMap);
	}

	/**
	 * @description: 查询没有绑定的代理商个数
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月18日 上午11:38:12
	 */
	@Override
	public int countNoBAgency(Map<String, Object> paramsMap) {
		return sqlSessionTemplateASS.selectOne("countNoBAgency", paramsMap);
	}

	/**
	 * @description: 获得名字列表
	 * @param params
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月18日 下午3:35:43
	 */
	@Override
	public List<AgencyBackwardPo> getBatchAgency(AgencyBackwardPo params) {
		return sqlSessionTemplateASS.selectList("getBatchAgency", params);
	}

	/**
	 * @description: 查询是否属于二级代理商（接口用户）,是否可以通过接口传单
	 * @param paramMap
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月15日 下午4:10:56
	 */
	@Override
	public AgencyBackwardPo getSecondAgency(String userName) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userName", userName);
		paramMap.put("agencyTag", AgencyTagEnum.DATA_USER.getValue());
//		AgencyBackwardPo agencyPo = get(new WherePrams("user_name", "=", userName).and("agency_tag", "=", AgencyTagEnum.DATA_USER.getValue()));
		return sqlSessionTemplateASS.selectOne("getSecondAgency", paramMap);
	}
	@Override
	public AgencyBackwardPo getSecondAgency(Integer agencyId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", agencyId);
		return sqlSessionTemplateASS.selectOne("getSecondAgency", paramMap);
	}

	@Override
	public AgencyBackwardPo getRootAgencyById(int agencyId) {
		
		return sqlSessionTemplateASS.selectOne("getRootAgencyById", agencyId);
	}

	@Override
	public int updatePass(Integer agencyId, String userPass) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", agencyId);
		params.put("userPass", userPass);
		return sqlSessionTemplateASS.update("updatePass", params);
	}

	@Override
	public int updateAgencyTag(Integer agencyId, Integer agencyTag) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", agencyId);
		params.put("agencyTag", agencyTag);
		return sqlSessionTemplateASS.update("updateAgencyTag", params);
	}

	/**
	 * @description:  更新密码
	 * @param paramMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月11日 上午10:20:17
	 */
//	@Override
//	public int updateUserPass(Map<String, Object> paramMap) {
//		
//		return 0;
//	}
	
}
