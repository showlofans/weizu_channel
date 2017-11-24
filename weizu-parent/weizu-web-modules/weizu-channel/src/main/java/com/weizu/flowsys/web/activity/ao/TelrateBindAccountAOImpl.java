package com.weizu.flowsys.web.activity.ao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.operatorPg.enums.AgencyTagEnum;
import com.weizu.flowsys.operatorPg.enums.BindStateEnum;
import com.weizu.flowsys.operatorPg.enums.CallBackEnum;
import com.weizu.flowsys.operatorPg.enums.PgServiceTypeEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.dao.ITelRateDao;
import com.weizu.flowsys.web.activity.dao.ITelrateBindAccountDao;
import com.weizu.flowsys.web.activity.dao.ITelrateBindAccountVODao;
import com.weizu.flowsys.web.activity.pojo.AccountActiveRateDTO;
import com.weizu.flowsys.web.activity.pojo.AccountActiveRatePo;
import com.weizu.flowsys.web.activity.pojo.TelRatePo;
import com.weizu.flowsys.web.activity.pojo.TelrateBindAccountPo;
import com.weizu.flowsys.web.activity.pojo.TelrateBindAccountVO;
import com.weizu.flowsys.web.agency.ao.AgencyAO;
import com.weizu.flowsys.web.agency.dao.ChargeAccountDaoInterface;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;
import com.weizu.flowsys.web.channel.dao.ITelChannelDao;
import com.weizu.flowsys.web.channel.dao.ITelProductDao;
import com.weizu.flowsys.web.channel.pojo.TelChannelParams;
import com.weizu.web.foundation.DateUtil;
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
	@Resource
	private ITelrateBindAccountVODao telrateBindAccountVODao;
	
	@Resource
	private AgencyAO agencyAO;
	
	@Override
	public void getBindList(Map<String, Object> resultMap, PageParam pageParam,
			TelrateBindAccountVO tbaVO) {
		
		//加载费率列表
		List<TelRatePo> telrateList = telRateDao.listByTelRatePo(new TelRatePo(tbaVO.getBillType(), tbaVO.getTelchannelId(), AgencyTagEnum.DATA_USER.getValue()));
		resultMap.put("telrateList", telrateList);
		
		//默认使用第一个费率加载列表
		if(telrateList != null && telrateList.size() > 0){
			//在没有搜索条件的情况下，初始化页面查询参数
			TelRatePo firstTelRate = telrateList.get(0);
			if(tbaVO.getBillType() == null){
				tbaVO.setBillType(firstTelRate.getBillType());
			}
			if(tbaVO.getTelRateId() == null){
				tbaVO.setTelRateId(firstTelRate.getId());
			}
			WherePrams where = new WherePrams("tel_rate_id", "=", firstTelRate.getId());
			if(StringHelper.isNotEmpty(tbaVO.getAgencyName())){
				where.and("agency_name", "like", tbaVO.getAgencyName());
			}
			where.and("bind_state", "=", BindStateEnum.BIND.getValue());
			
			//初始化分页信息
			Long totalRecord = telrateBindAccountDao.count(where);
			if(pageParam != null){
				int pageSize = pageParam.getPageSize();
				long pageNoLong = pageParam.getPageNoLong();
				long startLongNum = (pageParam.getPageNoLong()-1)*pageSize;
				where.limit(startLongNum, pageSize);
				List<TelrateBindAccountPo> records = telrateBindAccountDao.list(where);
				for (TelrateBindAccountPo telrateBindAccountPo : records) {
					String activeTimeStr = DateUtil.formatAll(telrateBindAccountPo.getActiveTime());
					telrateBindAccountPo.setActiveTimeStr(activeTimeStr);
				}
				Pagination<TelrateBindAccountPo> pagination = new Pagination<TelrateBindAccountPo>(records, totalRecord, pageNoLong, pageSize);
				resultMap.put("pagination", pagination);
			}
		}else{
			List<AccountActiveRatePo> nullList = new ArrayList<AccountActiveRatePo>();
			Pagination<AccountActiveRatePo> pagination = new Pagination<AccountActiveRatePo>(nullList, 0, 1, 10);
			resultMap.put("pagination", pagination);
		}
		resultMap.put("tbaVO", tbaVO);//利用费率搜索参数
	}

//	@Override
//	public int batchBindAllAgency(int rootAgencyId, TelrateBindAccountVO tbaVO,
//			int updateBindState) {
//		int res = 0;
//		List<AgencyBackwardVO> agencyList = agencyAO.getUnbindTelAgencyList(rootAgencyId, tbaVO);
//		if(agencyList != null && agencyList.size() > 0){
//			if(BindStateEnum.UNBIND.getValue().equals(tbaVO.getBindState())){//原先的状态是解绑状态
//				int[] accountIds = new int[agencyList.size()];
//				for (int i = 0; i < agencyList.size(); i++) {
//					accountIds[i] = agencyList.get(i).getAccountId();
//				}
//				res = telrateBindAccountDao.batchUpdateBindTelState(tbaVO.getTelRateId(), updateBindState, accountIds);
//			}else{
//				List<TelrateBindAccountPo> list = new LinkedList<TelrateBindAccountPo>();
//				for (AgencyBackwardVO agencyBackwardVO : agencyList) {
//					TelrateBindAccountPo telBindPo = new TelrateBindAccountPo(agencyBackwardVO.getAccountId(), agencyBackwardVO.getUserName(), tbaVO.getTelRateId(),  System.currentTimeMillis(), updateBindState, CallBackEnum.POSITIVE.getValue(),tbaVO.getBindAgencyId());
////					AccountActiveRateDTO aardtoq = new AccountActiveRateDTO(agencyBackwardVO.getAccountId(), agencyBackwardVO.getUserName(), aardto.getRateDiscountId(), System.currentTimeMillis(), updateBindState, aardto.getBindAgencyId());
//					list.add(telBindPo);
//				}
//				res = telrateBindAccountDao.batchInsert(list);
//			}
//		}
//		return res;
//	}

	@Override
	public int batchBindAllTelAgency(int rootAgencyId,
			TelrateBindAccountVO tbaVO, int updateBindState) {
		int res = 0;
		List<AgencyBackwardVO> agencyList = agencyAO.getUnbindTelAgencyList(rootAgencyId, tbaVO);
		if(agencyList != null && agencyList.size() > 0){
			
			if(BindStateEnum.UNBIND.getValue().equals(tbaVO.getBindState())){//原先的状态是解绑状态
				int[] accountIds = new int[agencyList.size()];
				for (int i = 0; i < agencyList.size(); i++) {
					accountIds[i] = agencyList.get(i).getAccountId();
				}
				res = telrateBindAccountDao.batchUpdateBindTelState(tbaVO.getTelRateId(), updateBindState, accountIds);
			}else{
				List<TelrateBindAccountPo> list = new LinkedList<TelrateBindAccountPo>();
				for (AgencyBackwardVO agencyBackwardVO : agencyList) {
					TelrateBindAccountPo telBindPo = new TelrateBindAccountPo(agencyBackwardVO.getAccountId(), agencyBackwardVO.getUserName(), tbaVO.getTelRateId(),  System.currentTimeMillis(), updateBindState, CallBackEnum.POSITIVE.getValue(),tbaVO.getBindAgencyId());
//					AccountActiveRateDTO aardtoq = new AccountActiveRateDTO(agencyBackwardVO.getAccountId(), agencyBackwardVO.getUserName(), aardto.getRateDiscountId(), System.currentTimeMillis(), updateBindState, aardto.getBindAgencyId());
					list.add(telBindPo);
				}
				res = telrateBindAccountDao.batchInsert(list);
			}
		}
		
		return res;
	}
	
	@Resource
	private ChargeAccountDaoInterface chargeAccountDao;

	@Override
	public int batchBindAgency(TelrateBindAccountVO telrateBindAccountVO) {
		String accountIdst = telrateBindAccountVO.getAccountIds();
		if(StringHelper.isNotEmpty(accountIdst)){
			String [] accountIdsi = accountIdst.split(",");
			int[] accountIds = new int[accountIdsi.length];
			String[]agencyNames = new String[accountIdsi.length];
			Long telRateId = telrateBindAccountVO.getTelRateId();
			for (int i = 0; i < accountIdsi.length; i++) {
				accountIds[i] = Integer.parseInt(accountIdsi[i]);
				agencyNames[i] = chargeAccountDao.get(accountIds[i]).getAgencyName();
				//判断是否已经添加了该绑定
				TelrateBindAccountPo telRateBindPo = telrateBindAccountDao.get(new WherePrams("account_id", "=", accountIds[i]).and("tel_rate_id", "=", telRateId).and("bind_state", "=", BindStateEnum.BIND.getValue()));
				if(telRateBindPo != null){//已经添加过，就不再往list中添加了
					accountIds[i] = accountIds[accountIds.length-1];//把最后一个元素替代指定的元素
					accountIds = Arrays.copyOf(accountIds, accountIds.length-1);//数组缩容
					agencyNames[i] = agencyNames[accountIds.length-1];
					agencyNames = Arrays.copyOf(agencyNames, agencyNames.length-1);//数组缩容
				}
			}
			
			List<TelrateBindAccountPo> list = new LinkedList<TelrateBindAccountPo>();
			for (int i = 0; i < agencyNames.length; i++) {
//				TelrateBindAccountPo telRateBindPo = new AccountActiveRateDTO(accountIds[i], agencyNames[i], rateDiscountId, System.currentTimeMillis(), BindStateEnum.BIND.getValue(), aardto.getBindAgencyId());
				TelrateBindAccountPo telRateBindPo = new TelrateBindAccountPo(accountIds[i], agencyNames[i], telRateId, System.currentTimeMillis(), BindStateEnum.BIND.getValue(), CallBackEnum.POSITIVE.getValue(), telrateBindAccountVO.getBindAgencyId());
				list.add(telRateBindPo);
			}
			return telrateBindAccountDao.batchInsert(list);
//			AgencyBackwardPo agencyPo = new AgencyBackwardPo();
//			agencyPo.setAgencyIds(agencyIds);
//			List<AgencyBackwardPo> list = agencyVODao.getBatchAgency(agencyPo);
		}
		return 0;
	}

	@Override
	public int batchUpdateBindState(TelrateBindAccountVO telrateBindAccountVO) {
		if(telrateBindAccountVO.getBindState() == BindStateEnum.BIND.getValue()){//绑定
			String accountIdst = telrateBindAccountVO.getAccountIds();
			if(StringHelper.isNotEmpty(accountIdst)){
				String [] accountIdsi = accountIdst.split(",");
				int[] accountIds = new int[accountIdsi.length];
				for (int i = 0; i < accountIds.length; i++) {
					accountIds[i] = Integer.parseInt(accountIdsi[i]);
				}
				return telrateBindAccountDao.batchUpdateBindTelState(telrateBindAccountVO.getTelRateId(), telrateBindAccountVO.getBindState(), accountIds);
			}else{
				return -1;
			}
		}else{//解绑
			return telrateBindAccountDao.batchUpdateBindTelState(telrateBindAccountVO.getTelRateId(), telrateBindAccountVO.getBindState());
		}
	}

	@Override
	public int updateBindState(TelrateBindAccountPo telrateBindAccountPo) {
		int res = telrateBindAccountDao.updateLocal(telrateBindAccountPo);
		return res;
	}
}
