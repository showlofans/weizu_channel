package com.weizu.flowsys.web.channel.ao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.channel.dao.impl.AgencyEpDAOImpl;
import com.weizu.flowsys.web.channel.dao.impl.ExchangePlatformDao;
import com.weizu.flowsys.web.channel.pojo.AgencyEpPo;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;

/**
 * @description:上级对接平台管理业务层
 * @projectName:crud
 * @className:ExchangePlatformAOImpl.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月11日 下午12:41:38
 * @version 1.0
 */
@Service(value="exchangePlatformAO")
public class ExchangePlatformAOImpl implements ExchangePlatformAO {

	@Resource
	private ExchangePlatformDao exchangePlatformDao;
	@Resource
	private AgencyEpDAOImpl agencyEpDAO;
	
	
	/**
	 * @description:通过平台名查找平台对象
	 * @param name
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月11日 下午12:46:25
	 */
	@Override
	public ExchangePlatformPo getEpByEpName(String epName) {
		
		return exchangePlatformDao.getEpByEpName(epName);
	}
	/**
	 * @description:获得所有平台名称
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月8日 下午1:00:04
	 */
	@Override
	public List<ExchangePlatformPo> getSimpleEp() {
		return exchangePlatformDao.getSimpleEp();
	}
	
	/**
	 * @description:平台添加
	 * @param exchangePlatformPo
	 * @param agencyId
	 * @param agencyName
	 * @return success/error
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月8日 下午6:20:07
	 */
	@Transactional
	@Override
	public String addEp(ExchangePlatformPo exchangePlatformPo, int agencyId,String agencyName) {
		int epId = new Long(exchangePlatformDao.nextId()).intValue();
//		exchangePlatformPo.setId(epId);
		int res2 = exchangePlatformDao.add(exchangePlatformPo);
		int res1 = agencyEpDAO.add(new AgencyEpPo(agencyId, agencyName, epId, exchangePlatformPo.getEpName()));
		if((res1 + res2) >= 2){
			return "success";
		}else{
			return "error";
		}
	}
	/**
	 * @description:获得所有平台列表
	 * @param agencyId
	 * @param ep
	 * @param pageParam
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月8日 下午4:38:32
	 */
	@Override
	public Pagination<ExchangePlatformPo> getEp(int agencyId,
			ExchangePlatformPo ep, PageParam pageParam) {
//		Map<String, Object> paramsMap = getMapByEntity(channelForwardPo);
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("agencyId", agencyId);
		int toatalRecord = exchangePlatformDao.countEp(paramsMap);
		int pageSize = 10;
		int pageNo = 1;
		if(pageParam != null){
			pageSize = pageParam.getPageSize();
			pageNo = pageParam.getPageNo();
			paramsMap.put("start", (pageNo-1)*pageSize);
			paramsMap.put("end", pageSize);
		}
		List<ExchangePlatformPo> records = exchangePlatformDao.getEp(paramsMap);
		return new Pagination<ExchangePlatformPo>(records, toatalRecord, pageNo, pageSize);
	}
	/**
	 * @description: 通过id得到平台信息
	 * @param id
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月17日 上午11:08:14
	 */
	@Override
	public ExchangePlatformPo getEpById(Integer id) {
		return exchangePlatformDao.get(id);
	}

}
