package com.weizu.flowsys.web.channel.ao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.api.hsingleton.HSingletonFactory;
import com.weizu.flowsys.api.singleton.BalanceDTO;
import com.weizu.flowsys.api.singleton.BaseInterface;
import com.weizu.flowsys.api.singleton.BaseP;
import com.weizu.flowsys.api.singleton.SingletonFactory;
import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.CallBackEnum;
import com.weizu.flowsys.operatorPg.enums.OrderResultEnum;
import com.weizu.flowsys.operatorPg.enums.PgServiceTypeEnum;
import com.weizu.flowsys.util.ClassUtil;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.util.StringUtil2;
import com.weizu.flowsys.web.channel.dao.ExchangePlatformDaoInterface;
import com.weizu.flowsys.web.channel.dao.impl.AgencyEpDAOImpl;
import com.weizu.flowsys.web.channel.pojo.AgencyEpPo;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.web.foundation.DateUtil;
import com.weizu.web.foundation.String.StringHelper;
import com.weizu.web.foundation.hash.Hash;

/**
 * @description:上级对接平台管理业务层
 * @projectName:crud
 * @className:ExchangePlatformAOImpl.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月11日 下午12:41:38
 * @version 1.0
 */
@Service(value="exchangePlatformAO")
public class ExchangePlatformAOImpl implements ExchangePlatformAO {

	@Resource
	private ExchangePlatformDaoInterface exchangePlatformDao;
	@Resource
	private AgencyEpDAOImpl agencyEpDAO;
	
	
	/**
	 * @description:通过平台名查找平台对象
	 * @param name
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月11日 下午12:46:25
	 */
	@Override
	public ExchangePlatformPo getEpByEpName(String epName) {
		ExchangePlatformPo exchangePlatformPo = exchangePlatformDao.getEpByEpName(epName);
		if(exchangePlatformPo != null){
			String dataUserPass = Hash.BASE_UTIL.decode(exchangePlatformPo.getEpUserPass());
			exchangePlatformPo.setEpUserPass(dataUserPass);
		}
		return exchangePlatformPo;
	}
	/**
	 * @description:获得所有平台名称
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月8日 下午1:00:04
	 */
	@Override
	public List<ExchangePlatformPo> getSimpleEp() {
		return exchangePlatformDao.getSimpleEp();
	}
	
	/**
	 * @description:平台添加
	 * @param exchangePlatformPo
	 * @param agencyId
	 * @param agencyName
	 * @return success/error
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月8日 下午6:20:07
	 */
	@Transactional
	@Override
	public String addEp(ExchangePlatformPo exchangePlatformPo) {
		
		String epEngId = StringUtil2.toUpperClass(exchangePlatformPo.getEpEngId());
		exchangePlatformPo.setEpEngId(epEngId);
		exchangePlatformPo.setLastAccess(System.currentTimeMillis());
		if(exchangePlatformPo.getEpCallBack() == null){
			exchangePlatformPo.setEpCallBack(CallBackEnum.NEGATIVE.getValue());
		}
		String epUserPass = Hash.BASE_UTIL.encode(exchangePlatformPo.getEpUserPass());
		exchangePlatformPo.setEpUserPass(epUserPass);
		int res = exchangePlatformDao.add(exchangePlatformPo);
		if(res > 0){
			return "success";
		}else{
			return "error";
		}
	}
//	@Override
//	public String addEp(ExchangePlatformPo exchangePlatformPo, int agencyId,String agencyName) {
////		exchangePlatformPo.setId(epId);
//		//查看看系统是否已经对接过该平台，如果对接过就不用添加该平台
//		ExchangePlatformPo epPo = exchangePlatformDao.get(new WherePrams("ep_name", "=", exchangePlatformPo.getEpName()));
//		int res2 = 0;
//		int epId = 0;
//		if(epPo == null)
//		{//有该平台名称的平台，但同时要保证用户名和密码apikey不一样
//			epId = new Long(exchangePlatformDao.nextId()).intValue();
//			
//			res2 = exchangePlatformDao.add(exchangePlatformPo);
//		}else{
//			epId = epPo.getId();
//			AgencyEpPo agencyEp = agencyEpDAO.get(new WherePrams("agency_id", "=", agencyId).and("ep_id", "=", epId));
//			if(agencyEp != null)
//			{
//				return "errorEp";
//			}
//		}
//		int res1 = agencyEpDAO.add(new AgencyEpPo(agencyId, agencyName, epId, exchangePlatformPo.getEpName()));
//		if((res1 + res2) >= 1){
//			return "success";
//		}else{
//			return "error";
//		}
//	}
	/**
	 * @description:获得所有平台列表
	 * @param agencyId
	 * @param ep
	 * @param pageParam
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月8日 下午4:38:32
	 */
//	@Override
//	public Pagination<ExchangePlatformPo> getEp(int agencyId,
//			ExchangePlatformPo ep, PageParam pageParam) {
////		Map<String, Object> paramsMap = getMapByEntity(channelForwardPo);
//		Map<String, Object> paramsMap = new HashMap<String, Object>();
//		paramsMap.put("agencyId", agencyId);
//		paramsMap.put("epName", ep.getEpName());
//		int toatalRecord = exchangePlatformDao.countEp(paramsMap);
//		int pageSize = 10;
//		int pageNo = 1;
//		if(pageParam != null){
//			pageSize = pageParam.getPageSize();
//			pageNo = pageParam.getPageNo();
//			paramsMap.put("start", (pageNo-1)*pageSize);
//			paramsMap.put("end", pageSize);
//		}
//		List<ExchangePlatformPo> records = exchangePlatformDao.getEp(paramsMap);
//		for (ExchangePlatformPo exchangePlatformPo : records) {//动态设置平台余额
////			exchangePlatformPo.setEpBalance(epBalance);
//			String lastAccessStr = DateUtil.formatPramm(exchangePlatformPo.getLastAccess(),"yyyy-MM-dd");
//			exchangePlatformPo.setLastAccessStr(lastAccessStr);
//		}
//		return new Pagination<ExchangePlatformPo>(records, toatalRecord, pageNo, pageSize);
//	}
	@Override
	public Pagination<ExchangePlatformPo> getEp(
			ExchangePlatformPo ep, PageParam pageParam) {
//		Map<String, Object> paramsMap = getMapByEntity(channelForwardPo);
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("epName", ep.getEpName());
		paramsMap.put("epFor", ep.getEpFor());
		if(ep.getId() != null){
			paramsMap.put("id", ep.getId());
		}
		int toatalRecord = exchangePlatformDao.countEp(paramsMap);
		int pageSize = 10;
		int pageNo = 1;
		if(pageParam != null){
			pageSize = pageParam.getPageSize();
			pageNo = pageParam.getPageNo();
			paramsMap.put("start", (pageNo-1)*pageSize);
			paramsMap.put("end", pageSize);
		}
		List<ExchangePlatformPo> records = exchangePlatformDao.getEp(paramsMap);
		for (ExchangePlatformPo exchangePlatformPo : records) {//动态设置平台余额
//			exchangePlatformPo.setEpBalance(epBalance);
			String lastAccessStr = DateUtil.formatPramm(exchangePlatformPo.getLastAccess(),"yyyy-MM-dd");
			exchangePlatformPo.setLastAccessStr(lastAccessStr);
			String dataUserPass = Hash.BASE_UTIL.decode(exchangePlatformPo.getEpUserPass());
			exchangePlatformPo.setEpUserPass(dataUserPass);
		}
		return new Pagination<ExchangePlatformPo>(records, toatalRecord, pageNo, pageSize);
	}
	/**
	 * @description: 通过id得到平台信息
	 * @param id
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月17日 上午11:08:14
	 */
	@Override
	public ExchangePlatformPo getEpById(Integer id) {
		ExchangePlatformPo exchangePlatformPo = exchangePlatformDao.get(id);
		return exchangePlatformPo;
	}
	/**
	 * @description: 更新平台信息
	 * @param epPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月26日 上午10:25:05
	 */
	@Transactional
	@Override
	public String updateEp(ExchangePlatformPo epPo) {
		String flag = "error";
		ExchangePlatformPo ep = exchangePlatformDao.get(epPo.getId());
		String engId = ep.getEpEngId();
		epPo.setEpEngId(StringUtil2.toUpperClass(epPo.getEpEngId()));
		if(ClassUtil.contrastObj(ep, epPo)){
			flag = "success";
		}
//		else if(checkEpName(epPo.getEpName()) ){//!engId.equals(epPo.getEpEngId()) && 
//			flag = "exist";
//		}
		else{//两个对象值不一样，并且英文标识不存在，或者和原来的不一样 就更新
			epPo.setLastAccess(System.currentTimeMillis());
			if(epPo.getEpCallBack() == null){
				epPo.setEpCallBack(CallBackEnum.NEGATIVE.getValue());
			}
			String epUserPass = Hash.BASE_UTIL.encode(epPo.getEpUserPass());
			epPo.setEpUserPass(epUserPass);
			int upRes = exchangePlatformDao.updateLocal(epPo);
			if(upRes > 0){
				flag = "success";
			}else{
				flag = "updateError";
			}
		}
		return flag;
	}
	/**
	 * @description: 清除平台信息
	 * @param epId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月26日 上午10:55:24
	 */
	@Transactional
	@Override
	public String delEp(String epId) {
		if(StringHelper.isNotEmpty(epId)){
			if(exchangePlatformDao.del(Integer.parseInt(epId)) > 0){
				return "success";
			}
		}
		return "error";
	}
	@Override
	public boolean checkEpName(String epName) {
		Map<String,Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("epNameEqual", epName);
		int res = exchangePlatformDao.countEp(paramsMap);
		if(res > 0 ){
			return true;
		}
		return false;
	}
//	@Override
//	public ExchangePlatformPo getEpByRateId(Long rateId) {
//		return exchangePlatformDao.getEpByRateId(rateId);
//	}
	@Override
	public String updateEpBalance() {
		String resMsg = "";
		int successNum = 0;
		int errorNum = 0;
		List<ExchangePlatformPo> platformList = exchangePlatformDao.list(new WherePrams("1", "=", 1));
		for (ExchangePlatformPo epPo : platformList) {
			Integer epFor = epPo.getEpFor();
			String epEngId = epPo.getEpEngId();
			BaseP baseP = new BaseP();
			baseP.setEpo(epPo);
			BaseInterface bi = null;
			if(PgServiceTypeEnum.PGCHARGE.getValue().equals(epFor)){//调用流量接口仓库
				bi = SingletonFactory.getSingleton(epEngId, baseP);
			}else if(PgServiceTypeEnum.TELCHARGE.getValue().equals(epFor)){
				bi = HSingletonFactory.getSingleton(epEngId, baseP);
			}
			String msg = epPo.getEpName() + ":余额更新失败";
			boolean successTag = false;  
			if(bi != null && bi.getBalance() != null){
				BalanceDTO balanceDTO = bi.getBalance();
				if(balanceDTO != null && OrderResultEnum.SUCCESS.getCode().equals(balanceDTO.getTipCode())){
					epPo.setEpBalance(balanceDTO.getAccountBalance());
					//更新平台余额
					int res = exchangePlatformDao.updateLocal(epPo);
					if(res > 0){
						msg = epPo.getEpName() + ":余额更新成功";
						successTag = true;
						successNum++;
					}
				}
			}
			if(!successTag){
				errorNum++;
			}
			System.out.println(msg);
		}
		resMsg = "更新成功"+successNum+"条，更新失败"+errorNum +"条";
		return resMsg;
	}

}
