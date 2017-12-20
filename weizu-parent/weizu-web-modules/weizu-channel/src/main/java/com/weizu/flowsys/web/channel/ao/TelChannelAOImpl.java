package com.weizu.flowsys.web.channel.ao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.core.util.NumberTool;
import com.weizu.flowsys.operatorPg.enums.AgencyTagEnum;
import com.weizu.flowsys.operatorPg.enums.BindStateEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelStateEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelUseStateEnum;
import com.weizu.flowsys.operatorPg.enums.HuaServiceTypeEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.util.StringUtil2;
import com.weizu.flowsys.web.activity.dao.ITelRateDao;
import com.weizu.flowsys.web.activity.pojo.TelRatePo;
import com.weizu.flowsys.web.agency.dao.ChargeAccountDaoInterface;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
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
	@Resource
	private ITelRateDao telRateDao;
	@Resource
	private ChargeAccountDaoInterface chargeAccountDao;
	
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
					//判断该编码类型通道是否存在
					
					telChannelPo.setTelProductId(telProId);
					boolean hasExist = checkTelChannel(telChannelPo);
					if(!hasExist){
						TelChannelPo telParams = new TelChannelPo(telCD, telProId, telChannelPo.getBillType(), lastAccess, telChannelPo.getTelchannelUseState());
						telParams.setTelchannelState(ChannelStateEnum.CLOSE.getValue());
						telChannelList.add(telParams);
					}else{
						return res;
					}
					
				}
				addRes = telChannelDao.batchAddTelChannel(telChannelList);
				if(addRes > 0){
					res = "success";
				}
			}
		}
		return res;
	}

	/**
	 * @description: 查看是否已存在该类型 通道（在使用状态）
	 * @param telChannelPo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月30日 下午2:41:45
	 */
	private boolean checkTelChannel(TelChannelPo telChannelPo) {
		
		//telChannelPo.setTelchannelUseState(ChannelUseStateEnum.OPEN.getValue());
		Map<String,Object> params = getParamsByPo(telChannelPo);
		boolean hasExist = false;
		if(telChannelPo.getTelchannelUseState() != null && ChannelUseStateEnum.OPEN.getValue().equals(telChannelPo.getTelchannelUseState())){
			long res = telChannelDao.countTelChanenl(params);//查看是否存在开通的通道
			if(res > 0){
				hasExist = true;
			}
		}
		return hasExist;
	}

	private Map<String, Object> getParamsByPo(TelChannelPo telChannelPo) {
		Map<String,Object> params = new HashMap<String, Object>();
		if(telChannelPo.getTelProductId() != null){
			params.put("telProductId", telChannelPo.getTelProductId());
		}
		if(telChannelPo.getBillType() != null){
			params.put("billType", telChannelPo.getBillType());
		}
		if(telChannelPo.getTelchannelUseState() != null){
			params.put("telchannelUseState", telChannelPo.getTelchannelUseState());
		}
		return params;
	}

	@Override
	public Pagination<TelChannelParams> getTelChannel(
			TelChannelParams telParams, PageParam pageParams) {
//		if(telParams.getRateFor() == null){//超管通道
//			telParams.setRateFor(AgencyTagEnum.DATA_USER.getValue());
//		}
		Map<String,Object> params = getParamsByTelPara(telParams);
		long totalRecord = 0;
		Integer serviceType = telParams.getServiceType();
		//没有结果重新设置查询参数和页面参数
		if(serviceType == null){//默认没有市内，加载省内，没有省内，加载全国
			serviceType = HuaServiceTypeEnum.CITY.getValue();
			do{
				params.put("serviceType", serviceType);
				totalRecord = telChannelDao.countTelChanenl(params);
				if(serviceType == 0){//到全国就设置退出
					totalRecord = totalRecord == 0 ? 1:totalRecord;
				}
				serviceType-- ;
			}while(totalRecord == 0);
			serviceType++;
			telParams.setServiceType(serviceType); //设置页面参数
		}else{
			params.put("serviceType", telParams.getServiceType());
			totalRecord = telChannelDao.countTelChanenl(params);
		}
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
//		Pagination<TelChannelParams> pagination = new Pagination<TelChannelParams>(records, totalRecord, pageNoLong, pageSize);
		return new Pagination<TelChannelParams>(records, totalRecord, pageNoLong, pageSize);
	}
	

	@Override
	public Pagination<TelChannelParams> getAgencyTelChannel(
			PageParam pageParams, TelChannelParams telChannelParams, Integer agencyId) {
		Map<String,Object> params = getParamsByTelPara(telChannelParams);
		if(AgencyTagEnum.PLATFORM_USER.getValue().equals(telChannelParams.getRateFor())){
			params.put("platformUser", AgencyTagEnum.PLATFORM_USER.getValue());
		}else if(AgencyTagEnum.DATA_USER.getValue().equals(telChannelParams.getRateFor())){
			params.put("dataUser", AgencyTagEnum.DATA_USER.getValue());//添加接口绑定的时候设置
		}
//		params.put("rateFor", AgencyTagEnum.PLATFORM_USER.getValue());
		params.put("agencyId", agencyId);
		long totalRecord = 0;
		Integer serviceType = telChannelParams.getServiceType();
		int rateFor = telChannelParams.getRateFor();
		boolean isPlatUser = AgencyTagEnum.PLATFORM_USER.getValue().equals(telChannelParams.getRateFor());
		//没有结果重新设置查询参数和页面参数
		if(serviceType == null){//默认没有市内，加载省内，没有省内，加载全国
			serviceType = HuaServiceTypeEnum.CITY.getValue();
			AgencyTagEnum[] agencyEs = AgencyTagEnum.values();
			do{
				params.put("serviceType", serviceType);
				for (int i = 0; i < agencyEs.length; i++) {
					if(isPlatUser){
						rateFor = AgencyTagEnum.PLATFORM_USER.getValue();
						params.put("platformUser", AgencyTagEnum.PLATFORM_USER.getValue());
						params.put("dataUser", null);
					}else{
						rateFor = AgencyTagEnum.DATA_USER.getValue();
						params.put("dataUser", AgencyTagEnum.DATA_USER.getValue());
						params.put("platformUser", null);
					}
					
					totalRecord = telChannelDao.countMyTelChannel(params);
					if(totalRecord != 0){
						telChannelParams.setRateFor(rateFor);
						break;
					}else{
						isPlatUser = !isPlatUser;
					}
				}
				
				if(serviceType == 0){//到全国就设置退出
					break;
//					totalRecord = totalRecord == 0 ? 1:totalRecord;
				}
				serviceType-- ;
			}while(totalRecord == 0);
			if(totalRecord > 0){
				serviceType++;
			}else{
				serviceType = HuaServiceTypeEnum.PROVINCE.getValue();
			}
			telChannelParams.setServiceType(serviceType); //设置页面参数
		}else{
			params.put("serviceType", telChannelParams.getServiceType());
			totalRecord = telChannelDao.countMyTelChannel(params);
		}
		
		int pageSize = 10;
		long pageNoLong = 1l;
		if(pageParams != null){
			pageSize = pageParams.getPageSize();
			pageNoLong = pageParams.getPageNoLong();
			long startLongNum = (pageNoLong-1)*pageSize;
			params.put("start", startLongNum);
			params.put("end", pageSize);
		}
		List<TelChannelParams> records = telChannelDao.getMyTelChannel(params);
		for (TelChannelParams telChannelParams2 : records) {
			telChannelParams2.setTelchannelPrice(NumberTool.mul(telChannelParams2.getTelchannelDiscount(), telChannelParams2.getChargeValue()));
		}
		
		return new Pagination<TelChannelParams>(records, totalRecord, pageNoLong, pageSize);
	}
	
	private Map<String,Object> getParamsByTelPara(TelChannelParams telParams){
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
//		if(telParams.getServiceType() != null){
//			params.put("serviceType", telParams.getServiceType());
//		}
		if(telParams.getOperatorName() != null){
			params.put("operatorName", telParams.getOperatorName());
		}
		if(telParams.getChargeValue() != null){
			params.put("chargeValue", telParams.getChargeValue());
		}
		if(StringHelper.isNotEmpty(telParams.getLimitDescription())){
			params.put("limitDescription", telParams.getLimitDescription());
		}
//		if(telParams.getRateFor() != null){
//		}else{
//			
//		}
		return params;
	}

	@Override
	public TelChannelParams selectByIdType(Long telChannelId,
			Integer serviceType) {
		Map<String,Object> telCParams = new HashMap<String, Object>();
		if(telChannelId != null){
			telCParams.put("id", telChannelId);
		}
		if(serviceType != null){
			telCParams.put("serviceType", serviceType);
		}
		TelChannelParams telChannelParams = telChannelDao.selectByIdType(telCParams);
		return telChannelParams;
	}

	@Transactional
	@Override
	public String editTelChannel(TelChannelPo telChannelPo, Integer ifUpdateRate) {
		String resStr = "error";
		Long telChannelId = telChannelPo.getId();
		if(telChannelId != null){
			//更新话费通道信息
			int res = telChannelDao.updateLocal(telChannelPo);
			boolean ifUpTelRate = ifUpdateRate != null && ifUpdateRate == 1;
			if(ifUpTelRate){
				List<TelRatePo> telRateList = telRateDao.list(new WherePrams("telchannel_id", "=", telChannelId));
				if(telRateList != null && telRateList.size() > 0){
					//批量更新折扣
					TelChannelPo getTelChannel = telChannelDao.get(telChannelId);
					//与数据库通道折扣不一样
					boolean isUpdate = !getTelChannel.getTelchannelDiscount().equals(telChannelPo.getTelchannelDiscount()) && res > 0;
					if(isUpdate){
						for (TelRatePo telRatePo : telRateList) {
							Double oldCd = getTelChannel.getTelchannelDiscount();
							Double editDiscount = NumberTool.sub(telChannelPo.getTelchannelDiscount(), oldCd);//差数
							telRatePo.setActiveDiscount(NumberTool.add(telRatePo.getActiveDiscount(), editDiscount));
							res += telRateDao.updateLocal(telRatePo);
						}
						res -= 1;
					}
				}
				if(res > 0){
					resStr = "success";
				}
			}else{
				resStr = "success";
			}
		}
		return resStr;
	}

	@Override
	public String delTelChannelById(Long telChannelId) {
		int res = telChannelDao.del(telChannelId);
		String resStr = "error";
		if(res > 0){
			resStr = "success";
		}
		return resStr;
	}

//	@Override
//	public Pagination<TelRatePo> getMyTelRateList(PageParam pageParams,
//			Integer childAccountId, Integer contextAgencyId) {
//		Map<String,Object> paramsMap = new HashMap<String, Object>();
//		
//		if(contextAgencyId != null)
//		{
//			paramsMap.put("agencyId", contextAgencyId);
//		}
//		
//		paramsMap.put("bindState", BindStateEnum.BIND.getValue());
//		paramsMap.put("channelUseState", ChannelUseStateEnum.OPEN.getValue());
//		
//		return null;
//	}

	@Override
	public void getChildAgencyTelChannel(
			PageParam pageParams, TelChannelParams telChannelParams,
			Integer agencyId, Integer childAccountId, Map<String,Object> resultMap) {
		ChargeAccountPo childAccountPo = chargeAccountDao.get(childAccountId);
		resultMap.put("childAccountPo", childAccountPo);
		
		Map<String,Object> params = getParamsByTelPara(telChannelParams);
		if(AgencyTagEnum.PLATFORM_USER.getValue().equals(telChannelParams.getRateFor())){
			params.put("platformUser", AgencyTagEnum.PLATFORM_USER.getValue());
		}else if(AgencyTagEnum.DATA_USER.getValue().equals(telChannelParams.getRateFor())){
			params.put("dataUser", AgencyTagEnum.DATA_USER.getValue());//添加接口绑定的时候设置
		}
//		params.put("rateFor", AgencyTagEnum.PLATFORM_USER.getValue());
		params.put("agencyId", agencyId);
		long totalRecord = 0;
		Integer serviceType = telChannelParams.getServiceType();
		int rateFor = telChannelParams.getRateFor();
		boolean isPlatUser = AgencyTagEnum.PLATFORM_USER.getValue().equals(telChannelParams.getRateFor());
		//没有结果重新设置查询参数和页面参数
		if(serviceType == null){//默认没有市内，加载省内，没有省内，加载全国
			serviceType = HuaServiceTypeEnum.CITY.getValue();
			AgencyTagEnum[] agencyEs = AgencyTagEnum.values();
			do{
				params.put("serviceType", serviceType);
				for (int i = 0; i < agencyEs.length; i++) {
					if(isPlatUser){
						rateFor = AgencyTagEnum.PLATFORM_USER.getValue();
						params.put("platformUser", AgencyTagEnum.PLATFORM_USER.getValue());
						params.put("dataUser", null);
					}else{
						rateFor = AgencyTagEnum.DATA_USER.getValue();
						params.put("dataUser", AgencyTagEnum.DATA_USER.getValue());
						params.put("platformUser", null);
					}
					
					totalRecord = telChannelDao.countMyTelChannel(params);
					if(totalRecord != 0){
						telChannelParams.setRateFor(rateFor);
						break;
					}else{
						isPlatUser = !isPlatUser;
					}
				}
				
				if(serviceType == 0){//到全国就设置退出
					break;
//					totalRecord = totalRecord == 0 ? 1:totalRecord;
				}
				serviceType-- ;
			}while(totalRecord == 0);
			if(totalRecord > 0){
				serviceType++;
			}else{
				serviceType = HuaServiceTypeEnum.PROVINCE.getValue();
			}
			telChannelParams.setServiceType(serviceType); //设置页面参数
		}else{
			params.put("serviceType", telChannelParams.getServiceType());
			totalRecord = telChannelDao.countMyTelChannel(params);
		}
		
		int pageSize = 10;
		long pageNoLong = 1l;
		if(pageParams != null){
			pageSize = pageParams.getPageSize();
			pageNoLong = pageParams.getPageNoLong();
			long startLongNum = (pageNoLong-1)*pageSize;
			params.put("start", startLongNum);
			params.put("end", pageSize);
		}
		List<TelChannelParams> records = telChannelDao.getMyTelChannel(params);
		for (TelChannelParams telChannelParams2 : records) {
			telChannelParams2.setTelchannelPrice(NumberTool.mul(telChannelParams2.getTelchannelDiscount(), telChannelParams2.getChargeValue()));
		}
//		return null;
	}


}
