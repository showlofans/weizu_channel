package com.weizu.flowsys.web.channel.ao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.weizu.web.foundation.StringUtil;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.core.util.hibernate.util.StringHelper;
import com.weizu.flowsys.operatorPg.enums.ScopeCityEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.util.StringUtil2;
import com.weizu.flowsys.web.activity.pojo.OperatorScopeVO;
import com.weizu.flowsys.web.activity.pojo.ScopeDiscount;
import com.weizu.flowsys.web.base.ATT;
import com.weizu.flowsys.web.channel.dao.impl.ChannelForwardDao;
import com.weizu.flowsys.web.channel.pojo.BestChannelPO;
import com.weizu.flowsys.web.channel.pojo.ChannelForwardPo;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;

/**
 * @description:对上通道接口实现
 * @projectName:crud
 * @className:ChannelForwardAOImpl.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月11日 上午9:32:20
 * @version 1.0
 */
@Service("channelForwardAO")
public class ChannelForwardAOImpl implements ChannelForwardAO {

	@Resource
	private ChannelForwardDao channelForwardDao;
	
//	@Resource
//	private ServiceScopeAO serviceScopeAO;
	
	/**
	 * @description:批量添加通道
	 * @param list
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月11日 上午9:32:11
	 */
	@Transactional(isolation = Isolation.SERIALIZABLE)
	@Override
	public int channel_addList(List<ChannelForwardPo> list) {
		
		return channelForwardDao.channel_addList(list);
	}
	/**
	 * @description:通道如果是多个，将实体变为多个通道
	 * @param channelForwardPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月11日 上午10:23:01
	 */
	@Override
	public List<ChannelForwardPo> initAddListByPo(
			ChannelForwardPo channelForwardPo) {
		List<ChannelForwardPo> list = new LinkedList<ChannelForwardPo>();
		if(channelForwardPo.getDiscountList().size() > 0){
			/**初始化要添加的list*/
			for (ScopeDiscount scopeDiscount : channelForwardPo.getDiscountList()) {
				if(scopeDiscount != null ){
					ChannelForwardPo addPo = channelForwardPo.clone();
					//			System.out.println(scopeDiscount.getScopeCityName());
					//获得城市编码
					String scopeCityCode = scopeDiscount.getScopeCityName();
					//设置通道名
					addPo.setChannelName(addPo.getChannelName()+"-"+ScopeCityEnum.getEnum(scopeCityCode).getDesc());
					//设置城市名
					addPo.setScopeCityName(ScopeCityEnum.getEnum(scopeCityCode).getDesc());
					//设置折扣
					addPo.setChannelDiscount(StringUtil2.getDiscount(scopeDiscount.getChannelDiscount()));
					
					/**通过城市编码，运营商类型和服务类型，直接拼接服务范围ID*/
//					ServiceScopePo serviceScopePo = new ServiceScopePo();
					StringBuffer sb =new StringBuffer(scopeCityCode);
					sb.append(addPo.getOperatorType());
					sb.append(addPo.getServiceType());
					//设置服务范围ID
					addPo.setServiceId(sb.toString());
					list.add(addPo);
				}
			}
		}
		return list;
	}
	
	/**
	 * @description:根据前台传的字符串转成相应的折扣
	 * @param channelDiscount
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月12日 下午4:19:50
	 */
	private Double getDiscount(String channelDiscount){
		double discount = 1.00d;
		if(channelDiscount != null){
			if(channelDiscount.substring(0).equals("0") || channelDiscount.trim().length() == 1){//只有一个数字，或者第一个数字是0
				discount = StringUtil.getDouble(channelDiscount)/ATT.SINGLE_NUMBER_DIVIDE;
			}else if(channelDiscount.trim().length() == 2){//有两位数字
				discount = StringUtil.getDouble(channelDiscount)/ATT.DOUBLE_NUMBER_DIVIDE;
			}else if(channelDiscount.trim().length() == 3){
				discount = StringUtil.getDouble(channelDiscount)/ATT.TRIPLE_NUMBER_DIVIDE;
			}
		}
		return discount;
	}
	/**
	 * @description:查询通道列表
	 * @param pageParam
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月16日 下午3:17:39
	 */
	@Override
	public Pagination<ChannelForwardPo> listChannel(PageParam pageParam,
			ChannelForwardPo channelForwardPo) {
//		String channelName = paramsMap.get("channelName").toString();
//		String channelName = paramsMap.get("channelState").toString();
//		String channelName = paramsMap.get("channelName").toString();
		Map<String, Object> paramsMap = getMapByEntity(channelForwardPo);
		
		int toatalRecord = channelForwardDao.count_channel(paramsMap);
		int pageSize = 10;
		int pageNo = 1;
		if(pageParam != null){
			pageSize = pageParam.getPageSize();
			pageNo = pageParam.getPageNo();
			paramsMap.put("start", (pageNo-1)*pageSize);
			paramsMap.put("end", pageSize);
		}
		List<ChannelForwardPo> records = channelForwardDao.listChannel(paramsMap);
		//初始化业务类型并返回
		for (ChannelForwardPo channelForwardPo2 : records) {
			String serviceId = channelForwardPo2.getServiceId();
			if(StringHelper.isNotEmpty(channelForwardPo2.getServiceId())){
				channelForwardPo2.setServiceType(Integer.parseInt(serviceId.substring(3)));
			}
		}
		
		return new Pagination<ChannelForwardPo>(records, toatalRecord, pageNo, pageSize);
	}
	
	/**
	 * @description:通过实体封装参数
	 * @param channelForwardPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月16日 下午3:58:17
	 */
	@Override
	public Map<String, Object> getMapByEntity(ChannelForwardPo channelForwardPo) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		
		if(channelForwardPo != null){
			if(StringHelper.isNotEmpty(channelForwardPo.getChannelName()))
			{
				paramsMap.put("channelName", channelForwardPo.getChannelName());
			}
			if(channelForwardPo.getChannelState() != null)
			{
				paramsMap.put("channelState", channelForwardPo.getChannelState());
			}
			if(StringHelper.isNotEmpty(channelForwardPo.getScopeCityName()))
			{
				paramsMap.put("scopeCityName", channelForwardPo.getScopeCityName());
			}
			if(channelForwardPo.getAgencyId() != null)
			{
				paramsMap.put("agencyId", channelForwardPo.getAgencyId());
			}
		}
		
		return paramsMap;
	}
	/**
	 * @description:通过实体封装参数(最优通道)
	 * @param operatorScopeVO
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月18日 上午11:15:51
	 */
	@Override
	public Map<String, Object> getMapByEntity(OperatorScopeVO operatorScopeVO) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if(StringHelper.isNotEmpty(operatorScopeVO.getScopeCityName())){
			resultMap.put("scopeCityName",operatorScopeVO.getScopeCityName());
		}
		if(operatorScopeVO.getAid() != null){
			resultMap.put("aid", operatorScopeVO.getAid());
		}
		if(StringHelper.isNotEmpty(operatorScopeVO.getAgencyId())){
			resultMap.put("aid", Integer.parseInt(operatorScopeVO.getAgencyId()));
		}
		
		if(operatorScopeVO.getOtype() != null ){
			resultMap.put("otype", operatorScopeVO.getOtype());
		}
		if(StringHelper.isNotEmpty(operatorScopeVO.getOperatorType())){
			resultMap.put("otype", Integer.parseInt(operatorScopeVO.getOperatorType()) );
		}
		return resultMap;
	}
	/**
	 * @description:获得最优通道
	 * @param operatorScopeVO
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月18日 上午11:15:48
	 */
	@Override
	public BestChannelPO getBestChannel(OperatorScopeVO operatorScopeVO) {
		Map<String, Object> paramsMap = getMapByEntity(operatorScopeVO);
		BestChannelPO bestChannelPO =  channelForwardDao.getBestChannel(paramsMap);
		//把0.22折扣换成22折扣
		if(bestChannelPO != null && bestChannelPO.getChannelDiscount() !=null ){
			String str = StringUtil2.getDiscountVO(bestChannelPO.getChannelDiscount());
			bestChannelPO.setDiscount(str.substring(0,str.indexOf(".")));
		}
		return bestChannelPO;
	}
	/**
	 * @description: 通过通道ID找到所属平台
	 * @param channelId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月26日 下午1:38:18
	 */
	@Override
	public ExchangePlatformPo getEpByChannelId(Integer channelId) {
		
		return channelForwardDao.getEpByChannelId(channelId);
	}
	

}
