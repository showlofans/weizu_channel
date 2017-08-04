package com.weizu.flowsys.web.agency.ao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.weizu.web.foundation.DateUtil;

import com.aiyi.base.pojo.PageParam;
import com.aiyi.base.pojo.PurchasePo;
import com.weizu.flowsys.core.util.NumberTool;
import com.weizu.flowsys.core.util.hibernate.util.StringHelper;
import com.weizu.flowsys.operatorPg.enums.AccountTypeEnum;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.agency.dao.impl.ChargeAccountDao;
import com.weizu.flowsys.web.agency.dao.impl.ChargeRecordDao;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.agency.pojo.ChargeRecordPo;
import com.weizu.flowsys.web.agency.pojo.ConsumeRecordPo;

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
	public int updateAccount(ChargeRecordPo chargeRecordPo,ChargeAccountPo loginAccountPo) {
		
//		if(chargeRecordPo.getBillType() == BillTypeEnum.CORPORATE_BUSINESS.getValue()){
//			
//		}
		
//		int accountId = chargeRecordPo.getAccountId();
//		ChargeAccountPo accountPo = chargeAccountDao.get(accountId);
		/****************修改登陆账户********************/
		/**充值前余额*/
		double agencyBeforeBalance = loginAccountPo.getAccountBalance();
		/**充值额（两个修改是共用的）*/
		double chargeAmount = chargeRecordPo.getRechargeAmount();
		/** 向消费记录表插入登陆用户数据 */
		chargeRecordDao.add(new ChargeRecordPo(System
				.currentTimeMillis(), chargeAmount,
				agencyBeforeBalance, NumberTool.sub(agencyBeforeBalance, chargeAmount), 
				chargeRecordPo.getBillType(),AccountTypeEnum.DECREASE.getValue(), loginAccountPo.getId(), loginAccountPo.getAgencyId(),1));
		
		/** 更新登录用户账户信息**/
		loginAccountPo.addBalance(chargeAmount,-1);
		chargeAccountAO.updateAccount(loginAccountPo);
		
		
		/****************修改子代理商账户********************************************/
		
//		int accountId = chargeRecordPo.getAccountId();

		/** 数据库取出来的的账户对象 */
//		ChargeAccountPo chargeAccountPo = chargeAccountDao.selectByAgencyId(chargeRecordPo.getAgencyId(),chargeRecordPo.getBillType());
		ChargeAccountPo chargeAccountPo = chargeAccountDao.get(chargeRecordPo.getAccountId());
		/**充值前余额*/
		double beforeBalance = chargeAccountPo.getAccountBalance();
		
		/** 向消费记录表插入数据 */
		int resultMsg = chargeRecordDao.add(new ChargeRecordPo(System
				.currentTimeMillis(), chargeAmount,
				beforeBalance, NumberTool.add(beforeBalance, chargeAmount), 
				chargeRecordPo.getBillType(),chargeRecordPo.getAccountType(), chargeAccountPo.getId(), chargeRecordPo.getAgencyId(),1));

		/** 更新账户表的余额值 */
		chargeAccountPo.addBalance(chargeAmount,0);
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
	public Pagination<ChargeRecordPo> listChargeRecord(Integer contextAgencyId,
			ChargeRecordPo chargeRecordPo, PageParam pageParam) {
		
		Map<String, Object> params = getMapByEntity(chargeRecordPo);
		
		params.put("contextAgencyId", contextAgencyId);
		int totalRecords = chargeRecordDao.countRecord(params);
		
		int pageSize = pageParam.getPageSize();
		int pageNo = pageParam.getPageNo();
		
		params.put("start", (pageNo-1) * pageSize);
		params.put("end", pageSize);
		List<ChargeRecordPo> records = chargeRecordDao.listChargeRecord(params);
		//初始化时间(引用变量)
		for (ChargeRecordPo chargeRecordPo2 : records) {
			chargeRecordPo2.setRemittanceTimeStr(DateUtil.formatAll(chargeRecordPo2.getRemittanceTime()));
		}
		
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
		if(consumeRecordPo.getStartTime() != null){
			params.put("startTime", consumeRecordPo.getStartTime());
		}
//		else{//设置当天开始时间
//			params.put("startTime", DateUtil.getStartTime().getTime());
//		}
		if(consumeRecordPo.getEndTime() != null){
			params.put("endTime", consumeRecordPo.getEndTime());
		}
//		else{//设置当天结束时间
//			params.put("endTime", DateUtil.getEndTime().getTime());
//		}
		if(consumeRecordPo.getAccountType() != null){
			params.put("accountType", consumeRecordPo.getAccountType());
		}
		if(consumeRecordPo.getChargeTel() != null){
			params.put("chargeTel", consumeRecordPo.getChargeTel());
		}
		
		if(consumeRecordPo.getAgencyId() != null){
			params.put("agencyId", consumeRecordPo.getAgencyId());
		}else if(contextAgencyId != null){
			params.put("contextAgencyId", contextAgencyId);
			
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
	public Pagination<ConsumeRecordPo> listConsumeRecord(Integer contextAgencyId,ConsumeRecordPo consumeRecordPo, PageParam pageParam) {
		Map<String, Object> params = getMapByConsume(consumeRecordPo,contextAgencyId);
		
		int totalRecords = chargeRecordDao.countConsume(params);
		
		int pageSize = pageParam.getPageSize();
		int pageNo = pageParam.getPageNo();
		
		params.put("start", (pageNo-1) * pageSize);
		params.put("end", pageSize);
		List<ConsumeRecordPo> records = chargeRecordDao.getConsume(params);
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
		if(chargeRecordPo.getStartTime() != null){
			params.put("startTime", chargeRecordPo.getStartTime());
		}
//		else{//设置当天开始时间
//			params.put("startTime", DateUtil.getStartTime().getTime());
//		}
		if(chargeRecordPo.getEndTime() != null){
			params.put("endTime", chargeRecordPo.getEndTime());
		}
//		else{//设置当天结束时间
//			params.put("endTime", DateUtil.getEndTime().getTime());
//		}
		if(chargeRecordPo.getAccountType() != null){
			params.put("accountType", chargeRecordPo.getAccountType());
		}
		
		if(chargeRecordPo.getAgencyId() != null){
			params.put("agencyId", chargeRecordPo.getAgencyId());
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
