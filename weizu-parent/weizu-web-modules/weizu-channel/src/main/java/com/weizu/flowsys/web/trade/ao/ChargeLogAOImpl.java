package com.weizu.flowsys.web.trade.ao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.core.annotation.po.TraMethod;
import com.weizu.flowsys.operatorPg.enums.IsExceptionEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.trade.dao.ChargeLogDao;
import com.weizu.flowsys.web.trade.dao.PurchaseDao;
import com.weizu.flowsys.web.trade.pojo.ChargeLog;
import com.weizu.flowsys.web.trade.pojo.PurchasePo;
import com.weizu.web.foundation.DateUtil;
import com.weizu.web.foundation.String.StringHelper;

/**
 * @description: 接口冲单日志业务层
 * @projectName:weizu-channel
 * @className:ChargeLogAOImpl.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年1月13日 下午2:04:09
 * @version 1.0
 */
@Service(value="chargeLogAO")
public class ChargeLogAOImpl implements ChargeLogAO {

	@Resource
	private ChargeLogDao chargeLogDao;
	@Resource
	private PurchaseDao purchaseDAO;
	
	@Override
	public Pagination<ChargeLog> list(ChargeLog chargeLog, PageParam pageParam, Integer isException) {
		
		Map<String,Object> params = getMapByLog(chargeLog,isException);
		Long totalRecordLong = chargeLogDao.countChargeLog(params);
		if(totalRecordLong <= 0 && chargeLog.getStartTimeStr() == null){
			params.put("startTime", null);
			chargeLog.setStartTimeStr("");
			totalRecordLong = chargeLogDao.countChargeLog(params);
		}
		int pageSize = pageParam.getPageSize();
		Long pageNoLong = pageParam.getPageNoLong();
		params.put("start", (pageNoLong-1) * pageSize);
		params.put("end", pageSize);
		List<ChargeLog> records = chargeLogDao.listChargeLog(params);
		for (ChargeLog chargeLog2 : records) {
			chargeLog2.setChargeTimeStr(DateUtil.formatAll(chargeLog2.getChargeTime()));
		}
		return new Pagination<ChargeLog>(records, totalRecordLong, pageNoLong, pageSize);
	}
	
	/**
	 * @description: 初始化count参数
	 * @param chargeLog
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月13日 下午2:19:49
	 */
	Map<String,Object> getMapByLog(ChargeLog chargeLog, Integer isException){
		Map<String,Object> paramsMap = new HashMap<String, Object>();
		
		
		if(StringHelper.isNotEmpty(chargeLog.getLogOutContent())){
			paramsMap.put("logOutContent", chargeLog.getLogOutContent());
		}
		if(StringHelper.isNotEmpty(chargeLog.getLogInContent())){
			paramsMap.put("logInContent", chargeLog.getLogInContent());
		}
		if(chargeLog.getOrderId() != null){
			PurchasePo purPo = purchaseDAO.getOnePurchase(chargeLog.getOrderId());
			if(purPo != null && purPo.getSecondOrderId() != null){
				paramsMap.put("secondOrderId", purPo.getSecondOrderId());
			}
			paramsMap.put("orderId", chargeLog.getOrderId());
		}else{
			if(IsExceptionEnum.POSITIVE.getValue().equals(isException)){
				paramsMap.put("orderIdIsNull", "orderIdIsNull");
			}else if(IsExceptionEnum.NEGATIVE.getValue().equals(isException)){
				paramsMap.put("orderIdIsNotNull", "orderIdIsNotNull");
			}
		}
		if(StringHelper.isNotEmpty(chargeLog.getChargeTel())){
			paramsMap.put("chargeTel", chargeLog.getChargeTel());
		}

//		Integer chargeStatus = chargeLog.getChargeStatus();
//		if(chargeStatus != null){
//			if()
//			
//			if(IsExceptionEnum.POSITIVE.equals(chargeStatus)){//正常
//				//看有没有方向，有方向，按照方向去设置其他在该方向上的正常编码
//				paramsMap.put("chargeStatus", chargeLog.getChargeDirection());
//				
//			}else{
//				
//			}
//		}else{
//			
//		}
//		paramsMap.put("chargeStatus", chargeLog.getChargeDirection());
		if(chargeLog.getChargeStatus() != null){
			paramsMap.put("chargeStatus", chargeLog.getChargeStatus());
		}
		if(chargeLog.getChargeDirection() != null){
			paramsMap.put("chargeDirection", chargeLog.getChargeDirection());
		}
		String startTimeStr = chargeLog.getStartTimeStr();
		String endTimeStr = chargeLog.getEndTimeStr();
		
		if(startTimeStr == null && endTimeStr == null && chargeLog.getOrderId() == null){
			Long startTime = DateUtil.getStartTime().getTime();
			paramsMap.put("startTime", startTime);
			chargeLog.setStartTimeStr(DateUtil.formatAll(startTime));
			Long endTime = DateUtil.getEndTime().getTime();
			paramsMap.put("endTime", endTime);
			chargeLog.setEndTimeStr(DateUtil.formatAll(endTime));
		}else{
			if(StringHelper.isNotEmpty(startTimeStr)){
				Long startTime = DateUtil.strToDate(startTimeStr, null).getTime();
				paramsMap.put("startTime", startTime);
			}
			if(StringHelper.isNotEmpty(endTimeStr)){
				Long endTime = DateUtil.strToDate(chargeLog.getEndTimeStr(), null).getTime();
				paramsMap.put("endTime", endTime);
			}
		}
		
//		if(startTimeStr == null){
//			Long startTime = DateUtil.getStartTime().getTime();
//			paramsMap.put("startTime", startTime);
//			chargeLog.setStartTimeStr(DateUtil.formatAll(startTime));
//		}else if("".equals(startTimeStr)){
////			paramsMap.put("startTime", startTime);
//		}else{
//			Long startTime = DateUtil.strToDate(startTimeStr, null).getTime();
//			paramsMap.put("startTime", startTime);
//		}
//		if(endTimeStr == null){
//			Long endTime = DateUtil.getEndTime().getTime();
//			paramsMap.put("endTime", endTime);
//			chargeLog.setEndTimeStr(DateUtil.formatAll(endTime));
//		}else if("".equals(endTimeStr)){
////			paramsMap.put("startTime", startTime);
//		}else{
//			Long endTime = DateUtil.strToDate(chargeLog.getEndTimeStr(), null).getTime();
//			paramsMap.put("endTime", endTime);
//		}
		
//		else{
//			paramsMap.put("startTime", null);
//		}
//		Long startTime = DateUtil.strToDate(chargeLog.getStartTimeStr(), null).getTime();
//		paramsMap.put("startTime", startTime);
		
//		if(StringHelper.isNotEmpty(chargeLog.getEndTimeStr())){
//			Long endTime = DateUtil.strToDate(chargeLog.getEndTimeStr(), null).getTime();
//			paramsMap.put("endTime", endTime);
//		}else{
//			paramsMap.put("endTime", null);
//		}
		return paramsMap;
	}

	@Transactional
	@Override
	public String delChargeLog(ChargeLog chargeLog, Integer isException) {
		Map<String,Object> params = getMapByLog(chargeLog,isException);
		Long totalRecordLong = chargeLogDao.countChargeLog(params);
		if(totalRecordLong <= 0){
			params.put("startTime", null);
			chargeLog.setStartTimeStr("");
//			totalRecordLong = chargeLogDao.countChargeLog(params);
		}
		int res = chargeLogDao.delChargeLog(params);
		String msg = "error";
		if(res > 0){
			msg = "success"; 
		}
		
		return msg;
	}

}
