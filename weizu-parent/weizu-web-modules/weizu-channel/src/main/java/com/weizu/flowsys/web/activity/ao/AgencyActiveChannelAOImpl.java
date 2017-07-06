package com.weizu.flowsys.web.activity.ao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.weizu.web.foundation.DateUtil;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ScopeCityEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.dao.AgencyActiveChannelDao;
import com.weizu.flowsys.web.activity.pojo.AgencyActiveChannelPo;
import com.weizu.flowsys.web.activity.pojo.DiscountPo;
import com.weizu.flowsys.web.activity.pojo.RateDiscountPo;
import com.weizu.flowsys.web.channel.pojo.ChannelChannelPo;
import com.weizu.flowsys.web.channel.pojo.ChannelDiscountPo;
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
		initRateDiscountStr(records);
		return new Pagination<AgencyActiveChannelPo>(records, toatalRecord, pageNo, pageSize);
	}
	
	
	/**
	 * @description: 初始化代理商绑定通道列表页面运营商的折扣
	 * @param records
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月6日 上午10:16:36
	 */
	private void initRateDiscountStr(List<AgencyActiveChannelPo> records) {
		for (AgencyActiveChannelPo activePo : records) {
			List<RateDiscountPo>  list = activePo.getRateList();
			StringBuffer discount0 = new StringBuffer("{");
			StringBuffer discount1 = new StringBuffer("{");
			StringBuffer discount2 = new StringBuffer("{");
			for (RateDiscountPo ratePo : list) {
				String code = ratePo.getScopeCityCode();
				String ScopeCityName = ScopeCityEnum.getEnum(code).getDesc();	//城市名
				int operatorType = ratePo.getOperatorType();
				if(operatorType == OperatorTypeEnum.MOBILE.getValue())
				{
					discount0.append("\""+ScopeCityName+"\":\""+ratePo.getActiveDiscount()+"\",");
				}else if(operatorType == OperatorTypeEnum.TELECOME.getValue())
				{
					discount2.append("\""+ScopeCityName+"\":\""+ratePo.getActiveDiscount()+"\",");
				}else//联通
				{
					discount1.append("\""+ScopeCityName+"\":\""+ratePo.getActiveDiscount()+"\",");
				}
			}
			
			String dis0Str = discount0.append("}").toString();
//			String dis0 = dis0Str.substring(0,dis0Str.lastIndexOf(","));
//			channelChannelPo.setDiscount0(dis0);
			String dis1Str = discount1.append("}").toString();
//			String dis1 = dis1Str.substring(0,dis1Str.lastIndexOf(","));
//			channelChannelPo.setDiscount0(dis0);
			String dis2Str = discount2.append("}").toString();
//			String dis2 = dis2Str.substring(0,dis2Str.lastIndexOf(","));
			activePo.setDiscountPo(new DiscountPo(dis0Str, dis1Str, dis2Str));
			
			//初始化时间
			String activeTimeStr = DateUtil.formatAll(activePo.getActiveTime());
			activePo.setActiveTimeStr(activeTimeStr);
		}
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
