package com.weizu.flowsys.web.activity.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.operatorPg.enums.BindStateEnum;
import com.weizu.flowsys.web.activity.dao.AccountActiveRateDao;
import com.weizu.flowsys.web.activity.pojo.AccountActiveRateDTO;
import com.weizu.flowsys.web.activity.pojo.AccountActiveRatePo;

@Repository(value="AccountActiveRateDao")
public class AccountActiveRateDaoImpl extends DaoImpl<AccountActiveRatePo, Long> implements
		AccountActiveRateDao {

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * @description: 查询代理商参与的活动通道
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 下午6:09:51
	 */
	@Override
	public List<AccountActiveRatePo> listActive(Map<String, Object> paramsMap) {
		return sqlSessionTemplate.selectList("listActive",paramsMap);
	}

	/**
	 * @description: 根据参数获得总记录数
	 * @param activePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 下午6:12:04
	 */
	@Override
	public int countActive(AccountActiveRatePo activePo) {
		return sqlSessionTemplate.selectOne("countActive", activePo);
	}

	/**
	 * @description: 查询代理商参与的活动通道(不分页)
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月7日 下午7:09:00
	 */
	@Override
	public List<AccountActiveRatePo> listActiveDiscount(
			Map<String, Object> paramsMap) {
		
		return sqlSessionTemplate.selectList("listActiveDiscount",paramsMap);
	}

	/**
	 * @description: 更新绑定状态
	 * @param activeId
	 * @param bindState
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月8日 下午12:00:59
	 */
	@Override
	public int updateBindState(long activeId, int bindState) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("id", activeId);
		paramsMap.put("bindState", bindState);
		if(BindStateEnum.UNBIND.getValue() == bindState){
			paramsMap.put("activeTime", 0);//解绑设置活动时间为0
		}else{
			paramsMap.put("activeTime", System.currentTimeMillis());//解绑设置活动时间为0
		}
		return sqlSessionTemplate.update("updateBindState", paramsMap);
	}

	/**
	 * @description: 查询分页费率列表
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月13日 上午10:57:23
	 */
	@Override
	public List<AccountActiveRatePo> listActiveRate(
			Map<String, Object> paramsMap) {
		return sqlSessionTemplate.selectList("listActiveRate", paramsMap);
	}

	/**
	 * @description: 查询费率记录数
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月13日 上午10:57:35
	 */
	@Override
	public Long countActiveRate(Map<String, Object> paramsMap) {
		return sqlSessionTemplate.selectOne("countActiveRate", paramsMap);
	}

	/**
	 * @description: 批量更新绑定状态（根据折扣id，批量解除绑定）
	 * @param rateDiscountId
	 * @param bindState
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月17日 上午10:12:07
	 */
	@Override
	public int batchUpdateBindState(long rateDiscountId, int bindState, int[] agencyIds) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("rateDiscountId", rateDiscountId);
		paramsMap.put("bindState", bindState);
		paramsMap.put("agencyIds", agencyIds);
		if(BindStateEnum.UNBIND.getValue() == bindState){
			paramsMap.put("activeTime", 0);//解绑设置活动时间为0
		}else{
			paramsMap.put("activeTime", System.currentTimeMillis());//解绑设置活动时间为0
		}
		paramsMap.put("agencyIds", agencyIds);
		return sqlSessionTemplate.update("updateBindState", paramsMap);
	}

	/**
	 * @description: 获得所有的绑定了该折扣的代理商
	 * @param rateDiscountId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月18日 上午9:40:27
	 */
	@Override
	public List<AccountActiveRatePo>  listBindAgency(long rateDiscountId) {
		return sqlSessionTemplate.selectList("listBindAgency",rateDiscountId);
	}

	/**
	 * @description: 批量绑定
	 * @param list
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月18日 下午3:53:02
	 */
	@Override
	public int batch_bindList(List<AccountActiveRateDTO> list) {
		return sqlSessionTemplate.insert("batch_bindList", list);
	}

	/**
	 * @description:  批量更新绑定状态（根据折扣id，批量解除绑定）
	 * @param rateDiscountId
	 * @param bindState
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月20日 上午9:59:21
	 */
	@Override
	public int batchUpdateBindState(long rateDiscountId, int bindState) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("rateDiscountId", rateDiscountId);
		paramsMap.put("bindState", bindState);
		return sqlSessionTemplate.update("updateBindState", paramsMap);
	}

}
