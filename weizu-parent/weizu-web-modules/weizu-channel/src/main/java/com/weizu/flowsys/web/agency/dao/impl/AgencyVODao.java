package com.weizu.flowsys.web.agency.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.web.agency.dao.AgencyVODaoInterface;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;

@Repository("agencyVODao")
public class AgencyVODao extends DaoImpl<AgencyBackwardVO, Integer> implements AgencyVODaoInterface {
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
	@Override
	public int updateByAgencyPO(AgencyBackwardPo agencyBackwardPo) {
		
		return sqlSessionTemplateASS.update("updateByAgencyPO",agencyBackwardPo);
	}

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
	
}
