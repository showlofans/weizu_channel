package com.weizu.flowsys.web.agency.ao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.aiyi.base.pojo.PageParam;
import com.aiyi.base.pojo.PurchasePo;
import com.weizu.flowsys.core.util.NumberTool;
import com.weizu.flowsys.operatorPg.enums.AccountTypeEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.agency.dao.impl.ChargeAccountDao;
import com.weizu.flowsys.web.agency.dao.impl.ChargeRecordDao;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.agency.pojo.ChargeRecordPo;
import com.weizu.flowsys.web.agency.pojo.ConsumeRecordPo;
import com.weizu.web.foundation.DateUtil;
import com.weizu.web.foundation.String.StringHelper;

@Service("chargeRecordAO")
public class ChargeRecordAoImpl implements ChargeRecordAO {
	@Resource
	private ChargeRecordDao chargeRecordDao;
	
	@Resource 
	private ChargeAccountAo chargeAccountAO;
	
	@Resource
	private ChargeAccountDao chargeAccountDao;
	
	
	
	
	/**
	 * @description:修改代理商账户信息
	 * @param chargeRecordPo
	 * @param agnecyId 当前登陆的代理商id
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月10日 下午12:23:46
	 */
	@Transactional(isolation = Isolation.SERIALIZABLE)
	@Override
	public int updateAccount(Integer accountId, Double chargeAmount,Integer loginContextId) {
		ChargeAccountPo chargeAccountPo = chargeAccountDao.get(accountId);
		
//		if(chargeRecordPo.getBillType() == BillTypeEnum.CORPORATE_BUSINESS.getValue()){
//			
//		}
		
//		int accountId = chargeRecordPo.getAccountId();
		ChargeAccountPo loginAccountPo = chargeAccountDao.selectByAgencyId(loginContextId, chargeAccountPo.getBillType());
		/****************修改登陆账户********************/
		/**充值前余额*/
		double agencyBeforeBalance = loginAccountPo.getAccountBalance();
		/**充值额（两个修改是共用的）*/
		/** 向消费记录表插入登陆用户数据 */
		chargeRecordDao.add(new ChargeRecordPo(System
				.currentTimeMillis(), chargeAmount,
				agencyBeforeBalance, NumberTool.sub(agencyBeforeBalance, chargeAmount), 
				AccountTypeEnum.DECREASE.getValue(), loginAccountPo.getId(),1,null));
		
		/** 更新登录用户账户信息**/
		loginAccountPo.addBalance(chargeAmount,-1);
		chargeAccountAO.updateAccount(loginAccountPo);
		
		
		/****************修改子代理商账户********************************************/
		
//		int accountId = chargeRecordPo.getAccountId();

		/** 数据库取出来的的账户对象 */
//		ChargeAccountPo chargeAccountPo = chargeAccountDao.selectByAgencyId(chargeRecordPo.getAgencyId(),chargeRecordPo.getBillType());
		
		/**充值前余额*/
		double beforeBalance = chargeAccountPo.getAccountBalance();
		
		/** 向消费记录表插入数据 */
		double afterBalance = NumberTool.add(beforeBalance, chargeAmount);
		
		int resultMsg = chargeRecordDao.add(new ChargeRecordPo(System
				.currentTimeMillis(), chargeAmount,
				beforeBalance, afterBalance, 
				AccountTypeEnum.INCREASE.getValue(), chargeAccountPo.getId(),1,null));

		/** 更新账户表的余额值 */
//		chargeAccountPo.addBalance(chargeAmount,0);
		chargeAccountPo.setAccountBalance(afterBalance);
		int resultMsg2 = chargeAccountAO.updateAccount(chargeAccountPo);
		return resultMsg + resultMsg2 - 1 ;
	}

	/**
	 * @description:加载分页充值记录列表
	 * @param params
	 * @param pageParam
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月9日 上午11:10:30
	 */
	@Override
	public Pagination<ChargeRecordPo> listChargeRecord(Map<String, Object> resultMap, Integer contextAgencyId,
			ChargeRecordPo chargeRecordPo, PageParam pageParam) {
		
		Map<String, Object> params = getMapByEntity(chargeRecordPo);
		if(chargeRecordPo.getAccountId() == null){
			params.put("contextAgencyId", contextAgencyId);
		}
		
		int totalRecords = chargeRecordDao.countRecord(params);
		
		if(totalRecords == 0){
			if(StringHelper.isEmpty(chargeRecordPo.getStartTimeStr())){
				params.put("startTime",null);//解除开始时间限制
			}
			if(StringHelper.isEmpty(chargeRecordPo.getEndTimeStr())){
				params.put("endTime", System.currentTimeMillis());
				chargeRecordPo.setEndTimeStr(DateUtil.formatAll(System.currentTimeMillis()));
			}
			totalRecords = chargeRecordDao.countRecord(params);
		}else{
			if(StringHelper.isEmpty(chargeRecordPo.getStartTimeStr())){
				Long dateUtilStartTime = Long.parseLong(params.get("startTime").toString());
				chargeRecordPo.setStartTimeStr(DateUtil.formatAll(dateUtilStartTime));
			}
			if(StringHelper.isEmpty(chargeRecordPo.getEndTimeStr())){
				Long dateUtilEndTime = Long.parseLong(params.get("endTime").toString());
				chargeRecordPo.setEndTimeStr(DateUtil.formatAll(dateUtilEndTime));
			}
		}
		
		int pageSize = pageParam.getPageSize();
		int pageNo = pageParam.getPageNo();
		
		params.put("start", (pageNo-1) * pageSize);
		params.put("end", pageSize);
		List<ChargeRecordPo> records = chargeRecordDao.listChargeRecord(params);
		//初始化时间(引用变量)
		for (ChargeRecordPo chargeRecordPo2 : records) {
			chargeRecordPo2.setRemittanceTimeStr(DateUtil.formatAll(chargeRecordPo2.getRemittanceTime()));
		}
		
		resultMap.put("searchParams", chargeRecordPo);
		return new Pagination<ChargeRecordPo>(records,totalRecords,pageNo,pageSize);
	}
	
	/**
	 * @description: 封装查询参数
	 * @param chargeRecordPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月3日 下午5:19:30
	 */
	@Override
	public Map<String, Object> getMapByConsume(ConsumeRecordPo consumeRecordPo,Integer contextAgencyId) {
		Map<String, Object> params = new HashMap<String, Object>();
		if(StringHelper.isNotEmpty(consumeRecordPo.getUserName())){
			params.put("userName", consumeRecordPo.getUserName());
		}
		if(StringHelper.isEmpty(consumeRecordPo.getStartTimeStr()) ){
			params.put("startTime", DateUtil.getStartTime().getTime());
//			consumeRecordPo.setStartTimeStr(DateUtil.formatAll(DateUtil.getStartTime()));
		}else{
			Long startTime = DateUtil.strToDate(consumeRecordPo.getStartTimeStr(), null).getTime();
			params.put("startTime", startTime);
		}
		
		if(StringHelper.isEmpty(consumeRecordPo.getEndTimeStr())){
			params.put("endTime", DateUtil.getEndTime().getTime());
//			consumeRecordPo.setEndTimeStr(DateUtil.formatAll(DateUtil.getEndTime()));
		}else{
			Long endTime = DateUtil.strToDate(consumeRecordPo.getEndTimeStr(), null).getTime();
			params.put("endTime", endTime);
		}
		
		if(consumeRecordPo.getAccountType() != null){
			params.put("accountType", consumeRecordPo.getAccountType());
		}
		if(consumeRecordPo.getChargeTel() != null){
			params.put("chargeTel", consumeRecordPo.getChargeTel());
		}
		
		if(contextAgencyId != null){
			params.put("agencyId", contextAgencyId);
		}
		if(consumeRecordPo.getAccountId() != null){
			params.put("accountId", consumeRecordPo.getAccountId());
		}
		if(consumeRecordPo.getPurchaseId() != null){
			params.put("purchaseId", consumeRecordPo.getPurchaseId());
		}
//		if(contextAgencyId != null){
//			params.put("agencyId", contextAgencyId);
//		}
		if(consumeRecordPo.getChargeFor() != null){
			params.put("chargeFor", consumeRecordPo.getChargeFor());
		}
		if(consumeRecordPo.getBillType() != null){
			params.put("billType", consumeRecordPo.getBillType());
		}
		
		return params;
	}

	/**
	 * @description: 加载分页消费记录列表
	 * @param contextAgencyId
	 * @param consumeRecordPo
	 * @param pageParam
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月3日 下午5:18:50
	 */
	@Override
	public Pagination<ConsumeRecordPo> listConsumeRecord(Map<String, Object> resultMap, Integer contextAgencyId,ConsumeRecordPo consumeRecordPo, PageParam pageParam) {
		Map<String, Object> params = getMapByConsume(consumeRecordPo,contextAgencyId);
		
		int totalRecords = chargeRecordDao.countConsume(params);
		
		if(totalRecords == 0){
			params.put("startTime",null);
			consumeRecordPo.setStartTimeStr("");
			if(StringHelper.isEmpty(consumeRecordPo.getEndTimeStr())){
				params.put("endTime", System.currentTimeMillis());
				consumeRecordPo.setEndTimeStr(DateUtil.formatAll(System.currentTimeMillis()));
			}
			totalRecords = chargeRecordDao.countConsume(params);
		}else{
			Long dateUtilStartTime = null;
			if(consumeRecordPo.getStartTimeStr() == null){
				dateUtilStartTime = Long.parseLong(params.get("startTime").toString());
				consumeRecordPo.setStartTimeStr(DateUtil.formatAll(dateUtilStartTime));
//				purchaseVO.setBackStartTimeStr(DateUtil.formatAll(dateUtilStartTime));
			}else if("".equals(consumeRecordPo.getStartTimeStr().trim())){
//				dateUtilStartTime = DateUtil.getStartTime().getTime();
//				params.put("startTime", dateUtilStartTime);
				params.put("startTime",null);
//				consumeRecordPo.setStartTimeStr(DateUtil.formatAll(dateUtilStartTime));
//				totalRecords = chargeRecordDao.countConsume(params);
			}
			
			if(StringHelper.isEmpty(consumeRecordPo.getEndTimeStr())){
				Long dateUtilEndTime = Long.parseLong(params.get("endTime").toString());
				consumeRecordPo.setEndTimeStr(DateUtil.formatAll(dateUtilEndTime));
//				purchaseVO.setBackEndTimeStr(DateUtil.formatAll(dateUtilEndTime));
			}
			totalRecords = chargeRecordDao.countConsume(params);
		}
		
		int pageSize = pageParam.getPageSize();
		int pageNo = pageParam.getPageNo();
		
		params.put("start", (pageNo-1) * pageSize);
		params.put("end", pageSize);
		List<ConsumeRecordPo> records = chargeRecordDao.getConsume(params);
		resultMap.put("searchParams", consumeRecordPo);
		//初始化时间(引用变量)
		for (ConsumeRecordPo consumeRecordPo2 : records) {
			consumeRecordPo2.setRemittanceTimeStr(DateUtil.formatAll(consumeRecordPo2.getRemittanceTime()));
		}
		
		return new Pagination<ConsumeRecordPo>(records,totalRecords,pageNo,pageSize);
	}

	/**
	 * @description:通过实体封装查询参数
	 * @param chargeRecordPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月9日 上午11:32:43
	 */
	@Override
	public Map<String, Object> getMapByEntity(ChargeRecordPo chargeRecordPo) {
		Map<String, Object> params = new HashMap<String, Object>();
		if(StringHelper.isNotEmpty(chargeRecordPo.getUserName())){
			params.put("userName", chargeRecordPo.getUserName());
		}
		
		if(StringHelper.isEmpty(chargeRecordPo.getStartTimeStr()) ){
			params.put("startTime", DateUtil.getStartTime().getTime());
//			chargeRecordPo.setStartTimeStr(DateUtil.formatAll(DateUtil.getStartTime()));
		}else{
			Long startTime = DateUtil.strToDate(chargeRecordPo.getStartTimeStr(), null).getTime();
			params.put("startTime", startTime);
		}
		
		if(StringHelper.isEmpty(chargeRecordPo.getEndTimeStr())){
			params.put("endTime", DateUtil.getEndTime().getTime());
//			chargeRecordPo.setEndTimeStr(DateUtil.formatAll(DateUtil.getEndTime()));
		}else{
			Long endTime = DateUtil.strToDate(chargeRecordPo.getEndTimeStr(), null).getTime();
			params.put("endTime", endTime);
		}
		
		if(chargeRecordPo.getAccountType() != null){
			params.put("accountType", chargeRecordPo.getAccountType());
		}
		
		/*if(chargeRecordPo.getAgencyId() != null){
			params.put("agencyId", chargeRecordPo.getAgencyId());
		}*/
		if(chargeRecordPo.getAccountId() != null){
			params.put("accountId", chargeRecordPo.getAccountId());
		}
		return params;
	}

	/**
	 * @description:购买流量
	 * @param purchasePo
	 * @return 充值状态
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月26日 下午6:01:54
	 */
	@Override
	public int purchasePg(PurchasePo purchasePo) {
		//代理商id和运营商类型，找到状态为正常的包体列表
		
		return 0;
	}

	/**
	 * @description:异步通过手机号获得充值的其他信息
	 * @param operatorType
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月26日 下午6:05:44
	 */
	@Override
	public Map<String, Object> ajaxGetPurchasePg(String telephone) {
		
		
		//包体列表 
		//通过手机号获得地区信息
		//获得该地区费率（折扣）
		
		return null;
	}
}
