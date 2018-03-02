package com.weizu.flowsys.web.agency.ao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.aiyi.base.pojo.PageParam;
import com.aiyi.base.pojo.PurchasePo;
import com.weizu.flowsys.core.util.NumberTool;
import com.weizu.flowsys.operatorPg.enums.AccountTypeEnum;
import com.weizu.flowsys.operatorPg.enums.AgencyLevelEnum;
import com.weizu.flowsys.operatorPg.enums.AgencyTagEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.agency.dao.impl.ChargeAccountDao;
import com.weizu.flowsys.web.agency.dao.impl.ChargeRecordDao;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.agency.pojo.ChargeRecordPo;
import com.weizu.flowsys.web.agency.pojo.ConsumeRecordPo;
import com.weizu.flowsys.web.agency.pojo.GroupAgencyRecordPo;
import com.weizu.flowsys.web.agency.pojo.GroupAgencyRecordVo;
import com.weizu.flowsys.web.trade.pojo.PurchaseVO;
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
	 * @description: 加款
	 * @param chargeAccountPo 要加的账户
	 * @param chargeAmount 
	 * @param loginAccountPo 要减的账户
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年2月25日 下午4:42:24
	 */
	@Transactional(isolation = Isolation.SERIALIZABLE)
	@Override
	public int chargeAccount(ChargeAccountPo chargeAccountPo, Double chargeAmount,ChargeAccountPo loginAccountPo) {
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
		if(AgencyLevelEnum.SUPPER_USER.getValue() == consumeRecordPo.getShowModel()){
			params.put("supperAgencyId", contextAgencyId);
		}else{
			params.put("agencyId", contextAgencyId);
		}
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
		if(StringHelper.isNotEmpty(consumeRecordPo.getChargeTel())){
			params.put("chargeTel", consumeRecordPo.getChargeTel());
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
		
//		String contextAgencyName = contextAgency.getUserName();
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
	@Override
	public HSSFWorkbook exportConsumeRecord(Integer contextAgencyId,ConsumeRecordPo consumeRecordPo)
	{
		HSSFWorkbook hbook = null;
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
			}else if(" ".equals(consumeRecordPo.getStartTimeStr().trim())){
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
		List<ConsumeRecordPo> records = chargeRecordDao.getConsume(params);
		if(records != null){
			
			String[] header =
			{ "所属代理商", "订单号", "手机号", "交易前余额", "交易费用", "交易后余额", "交易类型" ,  "交易时间" };

			hbook = new HSSFWorkbook();

			HSSFSheet hSheet = hbook.createSheet();

			hSheet.setColumnWidth(0, 35 * 80);
			hSheet.setColumnWidth(1, 35 * 150);
			hSheet.setColumnWidth(2, 35 * 100);
			
			hSheet.setColumnWidth(3, 35 * 100);
			hSheet.setColumnWidth(4, 35 * 100);
			hSheet.setColumnWidth(5, 35 * 100);
			hSheet.setColumnWidth(6, 35 * 80);
			hSheet.setColumnWidth(7, 35 * 200);
			HSSFRow hRow = hSheet.createRow(0);

			HSSFCellStyle style = hbook.createCellStyle();
			style.setFillForegroundColor(HSSFColor.LIME.index);
			style.setFillBackgroundColor(HSSFColor.GREEN.index);
			for (int i = 0; i < header.length; i++)
			{
				HSSFCell hCell = hRow.createCell(i);
				hCell.setCellStyle(style);
				hCell.setCellType(HSSFCell.CELL_TYPE_STRING);
				hCell.setCellValue(header[i]);
			}

			int i = 0;
			//String tradeType = "";				// 台账类型
			//String tradeNo = "";				// 交易号
			//初始化时间(引用变量)
//			for (ConsumeRecordPo consumeRecordPo2 : records) {
//				consumeRecordPo2.setRemittanceTimeStr(DateUtil.formatAll(consumeRecordPo2.getRemittanceTime()));
//			}
			for (ConsumeRecordPo consumeRecordPo2 : records)
			{
				i++;
				hRow = hSheet.createRow(i);
				//代理商名称
				hRow.createCell(0).setCellValue(consumeRecordPo2.getUserName());
				//订单号
				hRow.createCell(1).setCellValue(consumeRecordPo2.getPurchaseId().toString());

//				else if (r.getTradeType().equals("2"))
//				{
//					tradeType = "补款";
//				}
				// 充值号码
				hRow.createCell(2).setCellValue(consumeRecordPo2.getChargeTel());
//
//				if (r.getTradeType().equals("2") || r.getTradeType().equals("3"))
//				{
//					tradeNo = r.getTradeId() + "";
//				}
//				else
//				{
//					tradeNo = r.getTradeNo();
//				}
				// "交易前余额", "交易费用", "交易后余额", "交易类型" ,  "交易时间"

				// 交易前余额
				hRow.createCell(3).setCellValue(NumberTool.round(consumeRecordPo2.getChargeBefore(), 3));
				
				// 交易费用
				hRow.createCell(4).setCellValue(NumberTool.round(consumeRecordPo2.getRechargeAmount(), 3));
				// 交易后余额
				hRow.createCell(5).setCellValue(NumberTool.round(consumeRecordPo2.getChargeAfter(), 3));
				//交易类型
				hRow.createCell(6).setCellValue(AccountTypeEnum.getEnum(consumeRecordPo2.getAccountType()).getDesc() );
			
				// 订单完成时间
				hRow.createCell(7).setCellValue(DateUtil.formatAll(consumeRecordPo2.getRemittanceTime()));
				
			}
		}

//			hRow = hSheet.createRow(i + 1);
//
//			hRow.createCell(0).setCellValue("实付金额：" + returnMap.get("alreadyPayAmt"));
//			hRow.createCell(1).setCellValue("应付金额：" + returnMap.get("shouldPayAmt"));
//			hRow.createCell(2).setCellValue("冻结金额：" + returnMap.get("freezingAmount"));
//			hRow.createCell(3).setCellValue("金额期初：" + returnMap.get("preAmt"));
//			hRow.createCell(4).setCellValue("可用金额：" + returnMap.get("userfulAmount"));
//
//			Map<String, Object> params = new HashMap<String, Object>();
//			params.put("memberId", memberId);
//			Pagination<InvoiceAccount> invoiceAccountPage = invoiceAccountService.queryPageInvoiceAccount(new PageParam(1, 15), params);
//
//			if (invoiceAccountPage != null && invoiceAccountPage.getTotalCount() > 0)
//			{
//				InvoiceAccount a = invoiceAccountPage.getRecordList().get(0);
//				String preInvoiceRecord = VelocityTool.getPreInvoiceRecord(a.getMemberId());
//
//				hRow.createCell(5).setCellValue("应收票额：" + NumberTool.formatNumber(a.getPreBalance(), "###,###,##0.00"));
//				hRow.createCell(6).setCellValue("已收票额：" + NumberTool.formatNumber(NumberUtils.sub(a.getBalance(), NumberUtils.parseDouble(preInvoiceRecord)), "###,###,##0.00"));
//				hRow.createCell(7).setCellValue("票额期初：" + NumberTool.formatNumber(NumberUtils.parseDouble(preInvoiceRecord), "###,###,##0.00"));
//				hRow.createCell(8).setCellValue("欠票票额：" + NumberTool.formatNumber(NumberUtils.sub(a.getPreBalance(), a.getBalance()), "###,###,##0.00"));
//			}
		
		return hbook;
	}
	
	@Override
	public List<GroupAgencyRecordVo> groupAgencyRecord(Integer contextAgencyId,
			ConsumeRecordPo consumeRecordPo) {
		//consumeRecordPo.setShowModel(AgencyLevelEnum.SUPPER_USER.getValue());			//超管模式开启统计
		Map<String, Object> params = getMapByConsume(consumeRecordPo,contextAgencyId); //
		params.put("accountType", null);//统计需要忽略消费类型
		if(consumeRecordPo.getStartTimeStr() == null){
			Long dateUtilStartTime = null;
			dateUtilStartTime = Long.parseLong(params.get("startTime").toString());
			consumeRecordPo.setStartTimeStr(DateUtil.formatAll(dateUtilStartTime));
		}else if("".equals(consumeRecordPo.getStartTimeStr().trim())){
			params.put("startTime",null);
		}
		if(StringHelper.isEmpty(consumeRecordPo.getEndTimeStr())){
			Long dateUtilEndTime = Long.parseLong(params.get("endTime").toString());
			consumeRecordPo.setEndTimeStr(DateUtil.formatAll(dateUtilEndTime));
		}
		List<GroupAgencyRecordPo> list = chargeRecordDao.groupAgencyRecord(params);
		if(!(list.size() > 0 ) ){//今天没查到，查所有的记录
			params.put("startTime",null);
			consumeRecordPo.setStartTimeStr("");
			if(StringHelper.isEmpty(consumeRecordPo.getEndTimeStr())){
				params.put("endTime", System.currentTimeMillis());
				consumeRecordPo.setEndTimeStr(DateUtil.formatAll(System.currentTimeMillis()));
			}
			list = chargeRecordDao.groupAgencyRecord(params);
		}
		//设置页面列表
		List<GroupAgencyRecordVo> volist = new LinkedList<GroupAgencyRecordVo>();
		if(list.size() > 0 ){
			//处理重复的集合临时变量
			Map<String,Object> agencyMap = new HashMap<String, Object>();//key是代理商名称，value是vo实体（临时变量）
			
			for (GroupAgencyRecordPo groupAgencyRecordPo : list) {
				String agencyName = groupAgencyRecordPo.getAgencyName();
				GroupAgencyRecordVo vo = null;
				if(AccountTypeEnum.DECREASE.getValue().equals(groupAgencyRecordPo.getAccountType())){
					Object objVO = agencyMap.get(agencyName);
					if(objVO == null){//没有设置补款实体()
						vo = new GroupAgencyRecordVo(groupAgencyRecordPo.getAgencyName(), groupAgencyRecordPo.getAccountId(), groupAgencyRecordPo.getBillType(), 0l, groupAgencyRecordPo.getNumb(), groupAgencyRecordPo.getTotalAmount(), 0.0d, groupAgencyRecordPo.getNumb(),groupAgencyRecordPo.getTotalAmount() );
						agencyMap.put(agencyName, vo);
					}else{//之前有了补款为主的统计实体
						vo = (GroupAgencyRecordVo)objVO;//补款为主的统计实体
						//添加扣款和实际扣款i信息
						vo.setDecreaseNumb(groupAgencyRecordPo.getNumb());////当前总数设置为扣款总数
						vo.setNumb(groupAgencyRecordPo.getNumb() - vo.getNumb());  //扣款总笔数减去补款总笔数 == 实际扣款笔数
						vo.setDecreaseAmount(groupAgencyRecordPo.getTotalAmount());//当前总金额设置为扣款总金额
						vo.setTotalAmount(NumberTool.sub(groupAgencyRecordPo.getTotalAmount(), vo.getTotalAmount()));////扣款总金额减去补款总金额 == 实际扣款总金额
					}
				}else if(AccountTypeEnum.Replenishment.getValue().equals(groupAgencyRecordPo.getAccountType())){
					Object objVO = agencyMap.get(agencyName);
					if(objVO == null){//没有设置扣款实体()
						vo = new GroupAgencyRecordVo(groupAgencyRecordPo.getAgencyName(), groupAgencyRecordPo.getAccountId(), groupAgencyRecordPo.getBillType(), groupAgencyRecordPo.getNumb(), 0l, 0.0d,groupAgencyRecordPo.getTotalAmount(), groupAgencyRecordPo.getNumb(),groupAgencyRecordPo.getTotalAmount() );
						agencyMap.put(agencyName, vo);
					}else{//之前有了扣款为主的统计实体
						vo = (GroupAgencyRecordVo)objVO;//扣款为主的统计实体
						//添加扣款和实际扣款i信息
						vo.setReplenishmentNumb(groupAgencyRecordPo.getNumb());////当前总数设置为补款总数
						vo.setNumb(vo.getNumb() - groupAgencyRecordPo.getNumb());  //扣款总笔数减去补款总笔数 == 实际扣款笔数
						vo.setReplenishmentAmount(groupAgencyRecordPo.getTotalAmount());//当前总金额设置为补款总金额
						vo.setTotalAmount(NumberTool.sub(vo.getTotalAmount(), groupAgencyRecordPo.getTotalAmount()));////扣款总金额减去补款总金额 == 实际扣款总金额
					}
				}
			}
			//将map集合中的对象都取出来，放入list中
			for (String key : agencyMap.keySet()) {
				GroupAgencyRecordVo obj = (GroupAgencyRecordVo)agencyMap.get(key);
				if(!obj.getDecreaseNumb().equals(0)){
					Double realOrderPer = NumberTool.mul(100, NumberTool.div(obj.getNumb() , obj.getDecreaseNumb(),4));
					obj.setRealOrderPer(realOrderPer);
				}
				volist.add(obj);
			}
		}
		return volist;
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
//		if(chargeRecordPo.getChargeFor() != null){
//			params.put("chargeFor", chargeRecordPo.getChargeFor());
//		}
		
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
