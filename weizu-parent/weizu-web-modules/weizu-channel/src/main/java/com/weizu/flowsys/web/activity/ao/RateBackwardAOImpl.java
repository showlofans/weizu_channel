package com.weizu.flowsys.web.activity.ao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.core.util.hibernate.util.StringHelper;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.dao.impl.RateBackwardDaoImpl;
import com.weizu.flowsys.web.activity.pojo.RateBackwardPo;

@Service(value="rateBackwardAO")
public class RateBackwardAOImpl implements RateBackwardAO {

	@Resource
	private RateBackwardDaoImpl rateBackwardDao;
	/**
	 * @description:添加费率
	 * @param ratePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月19日 下午5:22:38
	 */
	@Override
	public int addRateBackward(RateBackwardPo ratePo) {
		
		return rateBackwardDao.add(ratePo);
	}
	/**
	 * @description:查询费率列表
	 * @param rateBackwardPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月20日 下午2:46:26
	 */
	@Override
	public Pagination<RateBackwardPo> selectByPo(RateBackwardPo rateBackwardPo,PageParam pageParam) {
		Map<String,Object> paramsMap = getMapByPo(rateBackwardPo);
		int totalRecord = rateBackwardDao.countByPo(paramsMap);
		
		int pageNo = pageParam.getPageNo();
		int pageSize = pageParam.getPageSize();
		//把分页参数返回到页面当中
		paramsMap.put("start", (pageNo-1) * pageSize);
		paramsMap.put("end", pageSize);
		List<RateBackwardPo> records = rateBackwardDao.selectByPagePo(paramsMap);
			
		return new Pagination<RateBackwardPo>(records, totalRecord, pageNo, pageSize);
	}
	
	private Map<String,Object> getMapByPo(RateBackwardPo rateBackwardPo){
		Map<String,Object> resultMap = new HashMap<String, Object>();
		if(rateBackwardPo != null)
		{
			
		if(rateBackwardPo.getRootAgencyId() != null)
		{
			resultMap.put("rootAgencyId", rateBackwardPo.getRootAgencyId());
		}
		if(StringHelper.isNotEmpty(rateBackwardPo.getRatePrice0()))
		{
			resultMap.put("ratePrice0", rateBackwardPo.getRatePrice0());
		}
		if(StringHelper.isNotEmpty(rateBackwardPo.getRatePrice1()))
		{
			resultMap.put("ratePrice1", rateBackwardPo.getRatePrice1());
		}
		if(StringHelper.isNotEmpty(rateBackwardPo.getRatePrice2()))
		{
			resultMap.put("ratePrice2", rateBackwardPo.getRatePrice2());
		}
		if(StringHelper.isNotEmpty(rateBackwardPo.getRateName()))
		{
			resultMap.put("rateName", rateBackwardPo.getRateName());
		}
		}
		
		
		return resultMap;
	}
	/**
	 * @description:查询全部费率列表
	 * @param rootAgencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月22日 上午10:54:15
	 */
	@Override
	public List<RateBackwardPo> selectByRootId(Integer rootAgencyId) {
		
		return rateBackwardDao.selectByRootId(rootAgencyId);
	}
	@Override
	public RateBackwardPo getByPoId(Long id) {
		return rateBackwardDao.get(id);
	}

}
