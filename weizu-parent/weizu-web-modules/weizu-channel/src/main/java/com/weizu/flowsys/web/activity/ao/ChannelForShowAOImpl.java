package com.weizu.flowsys.web.activity.ao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.web.activity.dao.IChannelForShowDao;
import com.weizu.flowsys.web.activity.pojo.ChannelForShowPo;
import com.weizu.web.foundation.DateUtil;
import com.weizu.web.foundation.String.StringHelper;

/**
 * @description: 展示通道AO层
 * @projectName:weizu-channel
 * @className:ChannelForShowAOImpl.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年12月30日 上午10:27:39
 * @version 1.0
 */
@Service(value="channelForShowAO")
public class ChannelForShowAOImpl implements ChannelForShowAO {
	@Resource
	private IChannelForShowDao channelForShowDao;
	
	@Override
	public List<ChannelForShowPo> listShowRate(ChannelForShowPo channelForShowPo) {
		WherePrams where = getWhereByPo(channelForShowPo);
		List<ChannelForShowPo> showRateList = channelForShowDao.list(where);
		for (ChannelForShowPo channelForShowPo2 : showRateList) {
			channelForShowPo2.setLastAccessStr(DateUtil.formatPramm(channelForShowPo2.getLastAccess(), "yyyy-MM-dd HH:mm:ss"));
		}
		return showRateList;
	}
	
	private WherePrams getWhereByPo(ChannelForShowPo channelForShowPo){
		WherePrams where = new WherePrams("1", "=", 1);
		if(StringHelper.isNotEmpty(channelForShowPo.getScopeCityCode())){
			where.and("scope_city_code", "=", channelForShowPo.getScopeCityCode());
		}
		if(StringHelper.isNotEmpty(channelForShowPo.getChannelCompany())){
			where.and("channel_company", "like", channelForShowPo.getChannelCompany());
		}
		if(StringHelper.isNotEmpty(channelForShowPo.getBussinessMan())){
			where.and("bussiness_man", "=", channelForShowPo.getBussinessMan());
		}
		if(channelForShowPo.getChannelBill() != null){
			where.and("channel_bill", "=", channelForShowPo.getChannelBill());
		}
		if(channelForShowPo.getOperatorType() != null){
			where.and("operator_type", "=", channelForShowPo.getOperatorType());
		}
		if(channelForShowPo.getServiceType() != null){
			where.and("service_type", "=", channelForShowPo.getServiceType());
		}
		if(channelForShowPo.getLimitPrice() != null){
			where.and("limit_price", "=", channelForShowPo.getLimitPrice());
		}
		where.orderBy("operator_type");
		where.orderBy("last_access desc");
		return where;
	}

}
