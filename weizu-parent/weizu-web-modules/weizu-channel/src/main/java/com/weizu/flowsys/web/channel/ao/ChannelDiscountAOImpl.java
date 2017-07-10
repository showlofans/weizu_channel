package com.weizu.flowsys.web.channel.ao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.channel.dao.ChannelDiscountDao;
import com.weizu.flowsys.web.channel.pojo.ChannelDiscountPo;

@Service(value="channelDiscountAO")
public class ChannelDiscountAOImpl implements ChannelDiscountAO {

	@Resource
	private ChannelDiscountDao channelDiscountDao;
	
	/**
	 * @description: 获得分页折扣列表
	 * @param cdp
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月10日 上午11:58:37
	 */
	@Override
	public Pagination<ChannelDiscountPo> getDiscountList(ChannelDiscountPo cdp,PageParam pageParam) {
		Map<String, Object> paramsMap = getMapByEntity(cdp);
		
		int toatalRecord = channelDiscountDao.countDiscount(paramsMap);
		int pageSize = 10;
		int pageNo = 1;
		if(pageParam != null){
			pageSize = pageParam.getPageSize();
			pageNo = pageParam.getPageNo();
			paramsMap.put("start", (pageNo-1)*pageSize);
			paramsMap.put("end", pageSize);
		}
		
		List<ChannelDiscountPo> records = channelDiscountDao.getDiscountList(paramsMap);
		
		return new Pagination<ChannelDiscountPo>(records, toatalRecord, pageNo, pageSize);
	}

	@Override
	public Map<String, Object> getMapByEntity(ChannelDiscountPo cdp) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		if(cdp.getChannelId() != null){
			paramsMap.put("channelId", cdp.getChannelId());
		}
		if(cdp.getDiscountType() != null){
			paramsMap.put("discountType", cdp.getDiscountType());
		}
		return paramsMap;
	}

}
