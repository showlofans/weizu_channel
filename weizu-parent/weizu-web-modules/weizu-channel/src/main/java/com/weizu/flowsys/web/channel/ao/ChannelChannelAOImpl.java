package com.weizu.flowsys.web.channel.ao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.operatorPg.enums.ChannelStateEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelUseStateEnum;
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.PgServiceTypeEnum;
import com.weizu.flowsys.operatorPg.enums.PgTypeEnum;
import com.weizu.flowsys.operatorPg.enums.PgValidityEnum;
import com.weizu.flowsys.operatorPg.enums.ScopeCityEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.dao.RateDiscountDao;
import com.weizu.flowsys.web.activity.pojo.DiscountPo;
import com.weizu.flowsys.web.channel.dao.ChannelChannelDao;
import com.weizu.flowsys.web.channel.dao.ChannelDiscountDao;
import com.weizu.flowsys.web.channel.dao.ICnelBindPgDao;
import com.weizu.flowsys.web.channel.dao.OperatorPgDaoInterface;
import com.weizu.flowsys.web.channel.pojo.ChannelChannelPo;
import com.weizu.flowsys.web.channel.pojo.ChannelDiscountPo;
import com.weizu.flowsys.web.channel.pojo.CnelBindPgPo;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.flowsys.web.channel.pojo.PgDataPo;
import com.weizu.flowsys.web.http.ao.ValiUser;
import com.weizu.web.foundation.DateUtil;
import com.weizu.web.foundation.String.StringHelper;

@Service(value="channelChannelAO")
public class ChannelChannelAOImpl implements ChannelChannelAO {

	@Resource
	private ChannelChannelDao channelChannelDao;
	@Resource
	private ICnelBindPgDao cnelBindPgDao; 
	@Resource
	private ChannelDiscountDao channelDiscountDao;
	@Resource
	private ChannelDiscountAO channelDiscountAO;
	@Resource
	private ValiUser valiUser;
	@Resource
	private OperatorPgDaoInterface operatorPgDao;
//	@Resource
//	private RateDiscountDao rateDiscountDao;
	
	
	@Override
	public ExchangePlatformPo getEpByChannelId(Long channelId) {
		
		return channelChannelDao.getEpByChannelId(channelId);
	}

	@Override
	@Transactional
	public int updateChannelUseState(String channelId, String channelUseState) {
		Long id = Long.parseLong(channelId);
		int useState = Integer.parseInt(channelUseState);
		
		if(ChannelUseStateEnum.CLOSE.getValue() == useState)
		{
			useState = ChannelUseStateEnum.OPEN.getValue();
		}else{
			useState = ChannelUseStateEnum.CLOSE.getValue();
		}
		
		return channelChannelDao.updateChannelUseState(id, useState);
	}

	@Transactional
	@Override
	public int updateChannelState(String channelId, String channelState) {
		Long id = Long.parseLong(channelId);
		int cState = Integer.parseInt(channelState);
		
		if(ChannelStateEnum.CLOSE.getValue() == cState)
		{
			cState = ChannelStateEnum.OPEN.getValue();
		}else{
			cState = ChannelStateEnum.CLOSE.getValue();
		}
		
		return channelChannelDao.updateChannelState(id, cState);
	}

	@Override
	public int deleteChannel(String channelId) {
		Long id = Long.parseLong(channelId);
//		rateDiscountDao.del(new WherePrams("channel_id", "=", channelId));
		return channelChannelDao.del(id);
	}

	/**
	 * @description: 添加通道
	 * @param channelPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 上午9:52:30
	 */
	@Transactional(isolation = Isolation.SERIALIZABLE)
	@Override
	public String channel_addList(ChannelChannelPo channelPo) {
		//初始化通道状态和使用状态
		channelPo.setChannelUseState(0);
		channelPo.setChannelState(0);
//		String serviceType = ServiceTypeEnum.getEnum(channelPo.getServiceType()).getDesc();
//		channelPo.setChannelName(serviceType +"-"+channelPo.getChannelName());
		
		StringBuffer specialTagSb = new StringBuffer();
		String cnelTypeS = ChannelTypeEnum.getSpecialDesc(channelPo.getChannelType());
		if(StringHelper.isNotEmpty(cnelTypeS)){
			specialTagSb.append(cnelTypeS);
		}
		String pgTypeS = PgTypeEnum.getSpecialDesc(channelPo.getPgType());
		if(StringHelper.isNotEmpty(pgTypeS)){
			specialTagSb.append("_").append(pgTypeS);
		}
		String pgValidityS = PgValidityEnum.getSpecialDesc(channelPo.getPgValidity());
		if(StringHelper.isNotEmpty(pgValidityS)){
			specialTagSb.append("_").append(pgValidityS);
		}
		channelPo.setSpecialTag(specialTagSb.toString());
		channelPo.setLastAccess(System.currentTimeMillis());
		int cnelAddRes = channelChannelDao.channel_addList(channelPo);
		String pgSizeStr = channelPo.getPgSize();
		String [] pgSize = pgSizeStr.split("&");
		List<CnelBindPgPo> cbpList = new LinkedList<CnelBindPgPo>();
		String cnelName = channelPo.getChannelName();
		
		/**根据包体规格字符串初始化通道包体列表*/
		for (String pgStr : pgSize) {
			int sType = channelPo.getServiceType();
			int oType = channelPo.getOperatorType();
			int pgSizeInt = Integer.parseInt(pgStr.trim());
			PgDataPo pgData = valiUser.findPg(new PgDataPo(oType, pgSizeInt, sType, channelPo.getPgType(), channelPo.getPgValidity(),channelPo.getChannelType()));//sType, pgSizeInt, oType
			if(pgData == null){
				System.out.println("通道添加，包体不存在");
				return "error";
			}
			Long cnelId = channelChannelDao.nextId() - 1;
			CnelBindPgPo cbp = new CnelBindPgPo(cnelId, pgData.getId(), cnelName, pgData.getPgName()) ;
			cbpList.add(cbp);
		}
		/**批量添加通道包体绑定*/
		int cbpd = 0;
		if(cbpList.size() > 0){
			cbpd = cnelBindPgDao.batchAddBind(cbpList);
		}
		
		if(cnelAddRes + cbpd > 1){
			return "success";
		}
		return "error";
	}

	@Override
	public Pagination<ChannelChannelPo> listChannel(PageParam pageParam,
			ChannelChannelPo channelChannelPo) {
		
		Map<String, Object> paramsMap = getMapByEntity(channelChannelPo);
		
		int toatalRecord = channelChannelDao.count_channel(paramsMap);
		int pageSize = 10;
		int pageNo = 1;
		if(pageParam != null){
			pageSize = pageParam.getPageSize();
			pageNo = pageParam.getPageNo();
			paramsMap.put("start", (pageNo-1)*pageSize);
			paramsMap.put("end", pageSize);
		}
		List<ChannelChannelPo> records = channelChannelDao.listChannel(paramsMap);
		
		initChannelDiscountStr(records);//, channelChannelPo.getPgSize(),toatalRecord
		//初始化scopeCityName,引用类型直接
//		for (ChannelChannelPo channelChannelPo2 : records) {
//			String scopeCityName = "";
//			for(ChannelDiscountPo channelDiscount: channelChannelPo2.getDiscountList())
//			if(StringHelper.isNotEmpty(channelDiscount.getScopeCityCode()))
//			{
//				for(Map<String, Object> cityMap : ScopeCityEnum.toList())
//				{
//					String cityName = cityMap.get("desc").toString();
//					if(cityName.contains(channelChannelPo2.getScopeCityName().trim()))//江西属于江西省
//					{
//						scopeCityName = cityMap.get("value").toString();
//						break;
//					}
//				}
//			}
//			channelChannelPo2.setScopeCityName(scopeCityName);
//		}
//		
		return new Pagination<ChannelChannelPo>(records, toatalRecord, pageNo, pageSize);
	}

	/**
	 * @description: 初始化通道列表页面运营商的折扣显示<br>
	 * 查询包体规格列表
	 * @param records
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 下午12:49:30
	 */
	private void initChannelDiscountStr(List<ChannelChannelPo> records) {//, String pgSize, int toatalRecord
//		boolean isPgSize = StringHelper.isNotEmpty(pgSize);
		for (ChannelChannelPo channelChannelPo : records) {
			if(channelChannelPo.getLastAccess() != null){
				channelChannelPo.setLastAccessStr(DateUtil.formatAll(channelChannelPo.getLastAccess()));
			}
			
			Map<String,Object> params = new HashMap<String, Object>();
//			if(isPgSize){
//				params.put("pgSize", Integer.parseInt(pgSize));
//			}
			params.put("channelId", channelChannelPo.getId());
			//初始化包体规格列表参数
			List<PgDataPo> pgList = operatorPgDao.getPgByChanel(params);
			boolean isRemoved = pgList == null || pgList.size() == 0;
			if(isRemoved){
//				Iterator<ChannelChannelPo> iterator = records.iterator();
//		        while(iterator.hasNext()){
//		        	ChannelChannelPo integer = iterator.next();
//		            if(integer==channelChannelPo)
//		                iterator.remove();   //注意这个地方
//		        }
//				toatalRecord--;//修改总记录数
			}
			else {//等同于包体不为空
				channelChannelPo.setPgList(pgList);
				channelChannelPo.setPgType(pgList.get(0).getPgType());
				channelChannelPo.setPgValidity(pgList.get(0).getPgValidity());
				List<ChannelDiscountPo>  list = channelChannelPo.getDiscountList();
				StringBuffer discount0 = new StringBuffer("{");
				StringBuffer discount1 = new StringBuffer("{");
				StringBuffer discount2 = new StringBuffer("{");
				if(list != null && list.size()>0){
					channelChannelPo.setServiceType(list.get(0).getServiceType());//初始化业务类型
					channelChannelPo.setOperatorType(list.get(0).getOperatorType());//初始化运营商类型
					channelChannelPo.setChannelType(list.get(0).getChannelType());//初始化通道类型
					for (ChannelDiscountPo channelDiscountPo : list) {
						String code = channelDiscountPo.getScopeCityCode();
						String ScopeCityName = ScopeCityEnum.getEnum(code).getDesc();	//城市名
						int operatorType = channelDiscountPo.getOperatorType();
						if(operatorType == OperatorTypeEnum.MOBILE.getValue())
						{
							discount0.append("\""+ScopeCityName+"\":\""+channelDiscountPo.getChannelDiscount()+"\",");
						}else if(operatorType == OperatorTypeEnum.TELECOME.getValue())
						{
							discount2.append("\""+ScopeCityName+"\":\""+channelDiscountPo.getChannelDiscount()+"\",");
						}else//联通
						{
							discount1.append("\""+ScopeCityName+"\":\""+channelDiscountPo.getChannelDiscount()+"\",");
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
					channelChannelPo.setDiscountPo(new DiscountPo(dis0Str, dis1Str, dis2Str));
					channelChannelPo.setBillType(list.get(0).getBillType());
				}
			
			}
		}
//		return toatalRecord;
	}

	/**
	 * @description: 通过实体封装参数
	 * @param operatorScopeVO
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 上午10:17:07
	 */
	@Override
	public Map<String, Object> getMapByEntity(ChannelChannelPo channelPo) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		
		if(channelPo != null){
			if(StringHelper.isNotEmpty(channelPo.getChannelName()))
			{
				paramsMap.put("channelName", channelPo.getChannelName());
			}
			if(channelPo.getChannelState() != null)
			{
				paramsMap.put("channelState", channelPo.getChannelState());
			}
			if(channelPo.getServiceType() != null){
				paramsMap.put("serviceType", channelPo.getServiceType());
			}
			if(StringHelper.isNotEmpty(channelPo.getScopeCityName()))
			{
				//江西属于江西省
				String scopeCityCode = ScopeCityEnum.getValueByDesc(channelPo.getScopeCityName().trim());
//				for(Map<String, Object> cityMap : ScopeCityEnum.toList())
//				{
//					String cityName = cityMap.get("desc").toString();
//					if(cityName.contains(channelPo.getScopeCityName().trim()))//江西属于江西省
//					{
//						scopeCityCode = cityMap.get("value").toString();
//					}
//				}
				paramsMap.put("scopeCityCode", scopeCityCode);
			}
//			if(StringHelper.isNotEmpty(channelPo.getScopeCityCode()))
//			{
//				paramsMap.put("scopeCityName", channelPo.getScopeCityCode());
//			}
			if(channelPo.getBelongAgencyId() != null)
			{
				paramsMap.put("belongAgencyId", channelPo.getBelongAgencyId());
			}
			if(channelPo.getId() != null){
				paramsMap.put("channelId", channelPo.getId());
			}
			if(StringHelper.isNotEmpty(channelPo.getEpName())){
				paramsMap.put("epName", channelPo.getEpName());
			}
			paramsMap.put("epFor", PgServiceTypeEnum.PGCHARGE.getValue());
			
			if(channelPo.getPgType() != null){
				paramsMap.put("pgType", channelPo.getPgType());
			}
			if(channelPo.getChannelType() != null){
				paramsMap.put("channelType", channelPo.getChannelType());
			}
			if(channelPo.getOperatorType() != null){
				paramsMap.put("operatorType", channelPo.getOperatorType());
			}
			if(StringHelper.isNotEmpty(channelPo.getPgValidity())){
				paramsMap.put("pgValidity", channelPo.getPgValidity());
			}
			if(StringHelper.isNotEmpty(channelPo.getPgSize())){
				paramsMap.put("pgSize", Integer.parseInt(channelPo.getPgSize()));
			}
		}
		
		return paramsMap;
	}

	@Transactional
	@Override
	public String editChannel(ChannelChannelPo channelPo, Integer ifUpdateRate) {
		List<ChannelDiscountPo> cdList = channelDiscountDao.list(new WherePrams("channel_id", "=", channelPo.getId()));//数据库绑定的折扣列表
		List<ChannelDiscountPo> getCDList = channelPo.getDiscountList();	//获得页面折扣列表
		String res = "";
		
		//设置通道折扣
		for (ChannelDiscountPo oldCd : cdList) {
			for (ChannelDiscountPo getCD : getCDList) {//最新折扣列表
				if(oldCd.getScopeCityCode().equals(getCD.getScopeCityCode())){//找到一样地区的折扣
					//更新这些地区的折扣
					//地区一样，那么通道折扣id一定也一样。
					getCD.setId(oldCd.getId());
					res = "success";//适应只更新带票与不带票的情况
					if(oldCd.getChannelDiscount().doubleValue() != getCD.getChannelDiscount().doubleValue()){//看是否一样
						initCDByChannelPo(channelPo,getCD);
						res = channelDiscountAO.updateChannelDiscount(getCD, ifUpdateRate);
					}
					break;//打破第一重循环，不再判断上一层的if
				}
			}
		}
		
		//修改通道名称
		int upCnel = channelChannelDao.updateLocal(channelPo, new WherePrams("id", "=", channelPo.getId()));
		if(!"success".equals(res) || upCnel <= 0){
			res = "error";
		}
		return res;
	}

	/**
	 * @description: 根据页面通道信息初始化通道折扣信息
	 * @param channelPo
	 * @param getCD
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月21日 下午4:23:56
	 */
	private void initCDByChannelPo(ChannelChannelPo channelPo,
			ChannelDiscountPo getCD) {
		getCD.setBillType(channelPo.getBillType());
		getCD.setServiceType(channelPo.getServiceType());
		getCD.setOperatorType(channelPo.getOperatorType());
		getCD.setChannelName(channelPo.getChannelName());
	}

	/**
	 * @description: 获得简易通道列表( agencyId,  billType)(id,name)
	 * @param channelForwardPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 下午3:47:32
	 */
//	@Override
//	public List<ChannelChannelPo> listChannel(Integer agencyId,Integer billType) {
//		Map<String,Object> paramsMap = new HashMap<String, Object>(3);
//		String[] scopeCityCodes = ScopeCityEnum.getValues();
//		//billtype在controller已经确认不为空
//		
//		paramsMap.put("belongAgencyId", agencyId);
//		paramsMap.put("billType", billType);
//		paramsMap.put("scopeCityCodes", scopeCityCodes);
//		
//		return channelChannelDao.listSimpleChannel(paramsMap);
//	}
	/**
	 * @description: 获得开通的简易通道列表( agencyId,  billType)(id,name)
	 * @param channelPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月6日 下午5:45:35
	 */
//	@Override
//	public List<ChannelChannelPo> listOpenChannel(ChannelChannelPo channelPo) {
//		Map<String,Object> paramsMap = new HashMap<String, Object>(5);
//		paramsMap.put("belongAgencyId", channelPo.getBelongAgencyId());
////		paramsMap.put("billType", channelPo.getBillType());
//		paramsMap.put("channelState", ChannelStateEnum.OPEN.getValue());//查找开通的通道
//		paramsMap.put("operatorType", channelPo.getOperatorType());
//		paramsMap.put("serviceType", channelPo.getServiceType());
//		paramsMap.put("scopeCityCode", channelPo.getScopeCityCode());
//		return channelChannelDao.listSimpleChannel(paramsMap);
//	}

}
