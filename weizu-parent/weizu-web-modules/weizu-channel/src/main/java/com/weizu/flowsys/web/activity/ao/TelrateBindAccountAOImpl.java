package com.weizu.flowsys.web.activity.ao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.operatorPg.enums.PgServiceTypeEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.dao.ITelRateDao;
import com.weizu.flowsys.web.activity.dao.ITelrateBindAccountDao;
import com.weizu.flowsys.web.activity.pojo.TelRatePo;
import com.weizu.flowsys.web.activity.pojo.TelrateBindAccountPo;
import com.weizu.flowsys.web.activity.pojo.TelrateBindAccountVO;
import com.weizu.flowsys.web.channel.dao.ITelChannelDao;
import com.weizu.flowsys.web.channel.dao.ITelProductDao;
import com.weizu.flowsys.web.channel.pojo.TelChannelParams;
import com.weizu.web.foundation.String.StringHelper;

/**
 * @description: 代理商账户和话费折扣绑定业务实现
 * @projectName:weizu-channel
 * @className:TelrateBindAccountAOImpl.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年11月16日 下午5:21:17
 * @version 1.0
 */
@Service(value="telrateBindAccountAO")
public class TelrateBindAccountAOImpl implements TelrateBindAccountAO {

	@Resource
	private ITelProductDao telProductDao;
	@Resource
	private ITelRateDao telRateDao;
	@Resource
	private ITelChannelDao telChannelDao;
	@Resource
	private ITelrateBindAccountDao telrateBindAccountDao;
	
	
	@Override
	public void getBindList(Map<String, Object> resultMap, PageParam pageParam,
			TelrateBindAccountVO tbaVO) {
		//页面通道信息
		Map<String,Object> telCParams = new HashMap<String, Object>();
		if(tbaVO.getTelchannelId() != null){
			telCParams.put("id", tbaVO.getTelchannelId());
		}
		if(tbaVO.getServiceType() != null){
			telCParams.put("serviceType", tbaVO.getServiceType());
		}
		TelChannelParams telChannelParams = telChannelDao.selectByIdType(telCParams);
		resultMap.put("telChannelParams", telChannelParams);
		
		//加载费率列表
		List<TelRatePo> telrateList = telRateDao.listByTelRatePo(new TelRatePo(tbaVO.getBillType(), tbaVO.getTelchannelId(), PgServiceTypeEnum.TELCHARGE.getValue()));
		resultMap.put("telrateList", telrateList);
		
		//默认使用第一个费率加载列表
		if(telrateList != null && telrateList.size() > 0){
			//初始化页面参数
			TelRatePo firstTelRate = telrateList.get(0);
			tbaVO.setBillType(firstTelRate.getBillType());
			tbaVO.setTelRateId(firstTelRate.getId());
			
			WherePrams where = new WherePrams("tel_rate_id", "=", firstTelRate.getId());
			if(StringHelper.isNotEmpty(tbaVO.getAgencyName())){
				where.and("agency_name", "like", tbaVO.getAgencyName());
			}
			
			//初始化分也信息
			Long totalRecord = telrateBindAccountDao.count(where);
			if(pageParam != null){
				int pageSize = pageParam.getPageSize();
				long pageNoLong = pageParam.getPageNoLong();
				long startLongNum = (pageParam.getPageNoLong()-1)*pageSize;
				where.limit(startLongNum, pageSize);
				List<TelrateBindAccountPo> records = telrateBindAccountDao.list(where);
				Pagination<TelrateBindAccountPo> pagination = new Pagination<TelrateBindAccountPo>(records, totalRecord, pageNoLong, pageSize);
				resultMap.put("pagination", pagination);
				resultMap.put("tbaVO", tbaVO);
			}
		}
	}
}
