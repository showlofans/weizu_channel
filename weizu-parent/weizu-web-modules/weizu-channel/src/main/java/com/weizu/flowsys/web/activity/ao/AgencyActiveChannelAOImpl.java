package com.weizu.flowsys.web.activity.ao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.dao.AgencyActiveChannelDao;
import com.weizu.flowsys.web.activity.pojo.AgencyActiveChannelPo;
import com.weizu.flowsys.web.channel.pojo.ChannelChannelPo;
@Service(value="agencyActiveChannelAO")
public class AgencyActiveChannelAOImpl implements AgencyActiveChannelAO {

	@Resource
	private AgencyActiveChannelDao agencyActiveChannelDao;
	/**
	 * @description: 查询代理商参与的活动通道
	 * @param pageParam
	 * @param activePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 下午6:17:27
	 */
	@Override
	public Pagination<AgencyActiveChannelPo> listActive(PageParam pageParam,
			AgencyActiveChannelPo activePo) {
		Map<String, Object> paramsMap = getMapByEntity(activePo);
		
		int toatalRecord = agencyActiveChannelDao.countActive(activePo);
		int pageSize = 10;
		int pageNo = 1;
		if(pageParam != null){
			pageSize = pageParam.getPageSize();
			pageNo = pageParam.getPageNo();
			paramsMap.put("start", (pageNo-1)*pageSize);
			paramsMap.put("end", pageSize);
		}
		List<AgencyActiveChannelPo> records = agencyActiveChannelDao.listActive(paramsMap);
		return new Pagination<AgencyActiveChannelPo>(records, toatalRecord, pageNo, pageSize);
	}

	/**
	 * @description: 通过实体封装参数
	 * @param activePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 下午6:17:36
	 */
	@Override
	public Map<String, Object> getMapByEntity(AgencyActiveChannelPo activePo) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		return paramsMap;
	}

}
