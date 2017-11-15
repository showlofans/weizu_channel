package com.weizu.flowsys.web.channel.ao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.operatorPg.enums.ChannelStateEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.util.StringUtil2;
import com.weizu.flowsys.web.channel.dao.ITelChannelDao;
import com.weizu.flowsys.web.channel.pojo.TelChannelParams;
import com.weizu.flowsys.web.channel.pojo.TelChannelPo;
import com.weizu.web.foundation.String.StringHelper;

/**
 * @description: 话费通道AO层实现
 * @projectName:weizu-channel
 * @className:TelChannelAOImpl.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年11月14日 下午4:07:16
 * @version 1.0
 */
@Service(value="telChannelAO")
public class TelChannelAOImpl implements TelChannelAO {

	@Resource
	private ITelChannelDao telChannelDao;
	
	@Transactional
	@Override
	public String addTelChannel(TelChannelPo telChannelPo) {
		String ids = telChannelPo.getIds();
		String discounts = telChannelPo.getDiscounts();
		int addRes = 0;
		String res = "error";
		
		if(StringHelper.isNotEmpty(ids) && StringHelper.isNotEmpty(discounts)){
			String [] idsi = ids.split(",");
			String [] discountsi = discounts.split(",");
			if(idsi.length == discountsi.length){
				//获得每一个编码id
//				long[] telProIds = new long[idsi.length];
//				double[]telCDs = new double[idsi.length];
				List<TelChannelPo> telChannelList = new LinkedList<TelChannelPo>();
				Long lastAccess = System.currentTimeMillis();
				for (int i = 0; i < idsi.length; i++) {
					long telProId = Long.parseLong(idsi[i]);
					double telCD = Double.parseDouble(discountsi[i]);
					telCD = StringUtil2.getDiscount(telCD);
					
					TelChannelPo telParams = new TelChannelPo(telCD, telProId, telChannelPo.getBillType(), lastAccess, telChannelPo.getTelchannelUseState());
					telParams.setTelchannelState(ChannelStateEnum.CLOSE.getValue());
					telChannelList.add(telParams);
				}
				addRes = telChannelDao.batchAddTelChannel(telChannelList);
				if(addRes > 0){
					res = "success";
				}
			}
		}
		return res;
	}

	@Override
	public Pagination<TelChannelParams> getTelChannel(
			TelChannelParams telParams, PageParam pageParams) {
		Map<String,Object> params = getParamsByPo(telParams);
		long totalRecord = telChannelDao.countTelChanenl(params);
		int pageSize = 10;
		long pageNoLong = 1l;
		if(pageParams != null){
			pageSize = pageParams.getPageSize();
			pageNoLong = pageParams.getPageNoLong();
			long startLongNum = (pageNoLong-1)*pageSize;
			params.put("start", startLongNum);
			params.put("end", pageSize);
		}
		List<TelChannelParams> records = telChannelDao.getTelChannel(params);
		return new Pagination<TelChannelParams>(records, totalRecord, pageNoLong, pageSize);
	}
	
	private Map<String,Object> getParamsByPo(TelChannelParams telParams){
		Map<String,Object> params = new HashMap<String, Object>();
		if(StringHelper.isNotEmpty(telParams.getEpName())){
			params.put("epName", telParams.getEpName());
		}
		if(StringHelper.isNotEmpty(telParams.getCityid())){
			params.put("cityid", telParams.getCityid());
		}
		if(StringHelper.isNotEmpty(telParams.getProvinceid())){
			params.put("provinceid", telParams.getProvinceid());
		}
		
		if(telParams.getTelchannelUseState() != null){
			params.put("telchannelUseState", telParams.getTelchannelUseState());
		}
		if(telParams.getTelchannelState() != null){
			params.put("telchannelState", telParams.getTelchannelState());
		}
		if(telParams.getBillType() != null){
			params.put("billType", telParams.getBillType());
		}
		if(telParams.getChargeSpeed() != null){
			params.put("chargeSpeed", telParams.getChargeSpeed());
		}
		if(telParams.getServiceType() != null){
			params.put("serviceType", telParams.getServiceType());
		}
		if(telParams.getOperatorName() != null){
			params.put("operatorName", telParams.getOperatorName());
		}
		if(telParams.getChargeValue() != null){
			params.put("chargeValue", telParams.getChargeValue());
		}
		if(StringHelper.isNotEmpty(telParams.getLimitDescription())){
			params.put("limitDescription", telParams.getLimitDescription());
		}
		return params;
	}

}
