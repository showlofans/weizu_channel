package com.weizu.flowsys.web.agency.ao;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.operatorPg.enums.AgencyTagEnum;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.BindStateEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.util.UUIDGenerator;
import com.weizu.flowsys.web.activity.dao.impl.RateBackwardDaoImpl;
import com.weizu.flowsys.web.activity.pojo.AgencyActiveRateDTO;
import com.weizu.flowsys.web.activity.pojo.RateBackwardPo;
import com.weizu.flowsys.web.agency.dao.AgencyVODaoInterface;
import com.weizu.flowsys.web.agency.dao.impl.AgencyVODao;
import com.weizu.flowsys.web.agency.dao.impl.ChargeAccountDao;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.web.foundation.DateUtil;
import com.weizu.web.foundation.MD5;
import com.weizu.web.foundation.String.StringHelper;

@Service("agencyAO")
public class AgencyAOImpl implements AgencyAO {

	@Resource
	private AgencyVODaoInterface agencyVODao;
//	@Resource
//	private AgencyVODao agencyVODao;
	@Resource
	private RateBackwardDaoImpl rateBackwardDao;
	@Resource
	private ChargeAccountDao chargeAccountDao;
	@Resource
	private ChargeAccountAo chargeAccountAO;

	/**
	 * @description:注册平台代理商（账户）
	 * @param agencyBackward
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月24日 下午5:02:16
	 */
	@Transactional
	@Override
	public AgencyBackwardVO addAgency(AgencyBackwardPo agencyBackward) {
		//是否存在该邀请码，如果存在返回该邀请码所属的代理商id
		
		Integer code = agencyVODao.getAgencyIdByVerifyCode(agencyBackward.getVerifyCode());
		if(code != null){//注册商户之前绑定父代理商
			agencyBackward.setRootAgencyId(code);
			agencyBackward.setVerifyCode("");//置空邀请码
			agencyBackward.setCreateTime(System.currentTimeMillis());
			agencyBackward.setAgencyTag(AgencyTagEnum.PLATFORM_USER.getValue());
			int addAgency = agencyVODao.add(agencyBackward);
			//利用nextId函数获得当前注册代理商id,同时注册一个账户
			int agencyId = (int) (agencyVODao.nextId()-1);//适用于自动增长
			ChargeAccountPo chargePo = new ChargeAccountPo();
			chargePo.setBillType(BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());//默认开通对私账户
			chargePo.setAgencyId(agencyId);
			chargePo.setCreateTime(agencyBackward.getCreateTime());
			chargePo.setAgencyName(agencyBackward.getUserName());
			int addCharge = chargeAccountDao.add(chargePo);
			
			int result = addAgency + addCharge;//要求一定要大于2
			if(result < 2){
				return null;
			}else{//返回VO实体
				agencyBackward.setId(agencyId);
				AgencyBackwardVO agencyVO = getVOByPo(agencyBackward);
				agencyVO.setAccountBalance(0.00d);
				agencyVO.setAccountCredit(0.00d);
				return agencyVO;
			}
		}else{
			return null;
		}
	}

	/**
	 * @description:封装VO实体
	 * @param agencyBackward
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月25日 上午10:31:06
	 */
	@Override
	public AgencyBackwardVO getVOByPo(AgencyBackwardPo agencyBackward) {
		if(agencyBackward == null){
			return null;
		}
		AgencyBackwardVO agencyVO = new AgencyBackwardVO(agencyBackward.getId(),
				agencyBackward.getRootAgencyId(), agencyBackward.getUserName(), 
				agencyBackward.getUserRealName(), agencyBackward.getUserPass(), 
				agencyBackward.getAgencyTel(), agencyBackward.getUserEmail(), 
				agencyBackward.getAgencyIp(), agencyBackward.getCreateTime(), 
				agencyBackward.getVerifyCode());
		agencyVO.setCallBackIp(agencyBackward.getCallBackIp());
		agencyVO.setOtherContact(agencyBackward.getOtherContact());
//		setOtherContact(agencyBackward.getRootAgencyId(),agencyVO);
		
//		if(agencyBackward.getRootAgencyId() != 0){
//			String qq = agencyVODao.get(agencyBackward.getRootAgencyId()).getOtherContact();//富代理商的qq
//			agencyVO.setOtherContact(qq);
//		}else{
//			agencyVO.setOtherContact(agencyBackward.getOtherContact());
//		}
		return agencyVO;
	}

//	public void setOtherContact(Integer rootAgencyId,AgencyBackwardVO agencyVO){
//		if(rootAgencyId != 0){
//			String qq = agencyVODao.get(rootAgencyId).getOtherContact();//富代理商的qq
//			agencyVO.setOtherContact(qq);
//		}else{
//			agencyVO.setOtherContact(agencyBackward.getOtherContact());
//		}
//	}
	
	/**
	 * @description:编辑代理商
	 * @param agencyBackward
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月22日 下午5:09:19
	 */
	@Transactional
	@Override
	public int updateAgency(AgencyBackwardVO agencyBackwardVO) {
		//主要取信用值和代理商id
//		ChargeAccountPo chargeAccountPo =  chargeAccountAO.getAccountByAgencyId(agencyBackwardVO.getId(),BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
//		ChargeAccountPo chargeAccountPo1 =  chargeAccountAO.getAccountByAgencyId(agencyBackwardVO.getId(),BillTypeEnum.CORPORATE_BUSINESS.getValue());
//		chargeAccountPo.setAccountCredit(agencyBackwardVO.getAccountCredit());
//		chargeAccountPo1.setAccountCredit(agencyBackwardVO.getAccountCredit());
		
//		chargeAccountDao.updateByAgencyId(chargeAccountPo);//更新信用值信息
//		chargeAccountDao.updateByAgencyId(chargeAccountPo1);//更新信用值信息
		//取代理商的其他信息
		int upresult = agencyVODao.updateLocal(getPoByVo(agencyBackwardVO),new WherePrams("id", "=", agencyBackwardVO.getId()));
//		int upresult = agencyVODao.updateByAgencyPO(getPoByVo(agencyBackwardVO));
		return upresult;
	}

	private AgencyBackwardPo getPoByVo(AgencyBackwardVO agencyBackward) {
		AgencyBackwardPo agencyPo = new AgencyBackwardPo(agencyBackward.getId(), 
				agencyBackward.getRootAgencyId(), agencyBackward.getUserName(), 
				agencyBackward.getUserPass(), agencyBackward.getUserRealName(), 
				agencyBackward.getAgencyTel(), agencyBackward.getUserEmail(), 
				agencyBackward.getAgencyIp(), 
				agencyBackward.getAccountCredit(), 
				System.currentTimeMillis(), agencyBackward.getVerifyCode());
		agencyPo.setOtherContact(agencyBackward.getOtherContact());
		return agencyPo;
	}

	/**
	 * @description:账户登陆
	 * @param agencyBackward
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月25日 上午10:03:08
	 */
	@Override
	public Map<String,Object> login(AgencyBackwardPo agencyBackward) {
		String userPass = agencyBackward.getUserPass(); 
		Map<String,Object> resultMap = new HashMap<String, Object>();
		AgencyBackwardPo resultAgency = agencyVODao.get(new WherePrams("user_name", "=", agencyBackward
				.getUserName()));
		if(resultAgency != null)
		{
			
			if(resultAgency.getUserPass().equals(userPass))
			{
				resultMap.put("msg", "success");
				resultMap.put("entity", resultAgency);
				return resultMap;
			}
			else
			{
				resultMap.put("msg", "登录密码不正确!!");
				return resultMap;
			}
		}
		else
		{
			resultMap.put("msg", "该用户名不存在！");
			return resultMap;
		}
	}

	/**
	 * @description:通过根代理商获得子代理商列表
	 * @param rootAgencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月6日 下午12:14:54
	 */
	@Override
	public List<AgencyBackwardPo> ListAgencyByRoot(int rootAgencyId) {
		return agencyVODao.list(new WherePrams("root_agency_id", "=", rootAgencyId));
	}

	/**
	 * @description:封装查询参数
	 * @param agencyBackward
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月6日 下午12:28:40
	 */
	@Override
	public Map<String, Object> getSearchParam(AgencyBackwardVO agencyBackward) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if(agencyBackward != null){
			if(StringHelper.isNotEmpty(agencyBackward.getUserName())){
				resultMap.put("userName", agencyBackward.getUserName());
			}
			if(agencyBackward.getAgencyTag() != null){
				resultMap.put("agencyTag", agencyBackward.getAgencyTag());
			}
			if(agencyBackward.getBillType() != null){
				resultMap.put("billType", agencyBackward.getBillType());
			}
		}
		return resultMap;
	}

	/**
	 * @description:通过根代理商获得子代理商分页列表
	 * @param rootAgencyId 根代理商ID
	 * @param searchMap
	 * @param pageParam
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月8日 上午10:05:09
	 */
	@Override
	public Pagination<AgencyBackwardVO> ListAgencyByRoot(int rootAgencyId,
			AgencyBackwardVO agencyBackwardVO, PageParam pageParam) {
		
		int pageNo = pageParam.getPageNo();
		int pageSize = pageParam.getPageSize();
		
		/**为得到总记录数而准备参数 whereParams*/
//		WherePrams whereParams = new WherePrams("root_agency_id","=",rootAgencyId);
		Map<String, Object> searchMap = getSearchParam(agencyBackwardVO);
//		if(searchMap.get("userName") != null){
//			String userName = searchMap.get("userName").toString();
//			whereParams.and("user_name", "like", userName);
//		}
		agencyBackwardVO.setRootAgencyId(rootAgencyId);
		int totalRecord = agencyVODao.countByAgencyVO(agencyBackwardVO);
//		whereParams.limit(pageNo * pageSize, pageSize);
		
		/**得到分页记录*/
		searchMap.put("start", (pageNo-1) * pageSize);
		searchMap.put("end", pageSize);
		searchMap.put("rootAgencyId", rootAgencyId);
		List<AgencyBackwardVO> records = agencyVODao.selectByAgencyVO(searchMap);
//		List<RateBackwardPo> rateList = rateBackwardDao.selectByRootId(rootAgencyId,BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());//查一遍rate列表
//		List<RateBackwardPo> billRateList = rateBackwardDao.selectByRootId(rootAgencyId,BillTypeEnum.CORPORATE_BUSINESS.getValue());//查一遍rate列表
		//根据引用直接修改值，不需要重新放到一个新的list当中
		for (AgencyBackwardVO agencyBackwardVO2 : records) {
			if(agencyBackwardVO2.getCreateTime() != null){
				agencyBackwardVO2.setCreateTimeStr(DateUtil.formatAll(agencyBackwardVO2.getCreateTime()));
			}
//			for (RateBackwardPo rateBackwardPo : rateList) {//在内存中初始化
//				if(rateBackwardPo.getId() == agencyBackwardVO2.getRateId()){
//					agencyBackwardVO2.setRateName(rateBackwardPo.getRateName());
//				}
//			}
//			for (RateBackwardPo rateBackwardPo : billRateList) {//在内存中初始化
//				if(rateBackwardPo.getId() == agencyBackwardVO2.getBillRateId()){
//					agencyBackwardVO2.setBillRateName(rateBackwardPo.getRateName());
//				}
//			}
		}
//		List<AgencyBackwardPo> records = agencyVODao.list(whereParams);
		
		return new Pagination<AgencyBackwardVO>(records, totalRecord, pageNo, pageSize);
	}

	/**
	 * @description:编辑代理商信息准备参数
	 * @param agBackwardPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月22日 上午10:58:05
	 */
	@Override
	public Map<String, Object> prepareParam(AgencyBackwardPo agBackwardPo) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if(agBackwardPo != null){
//			Long rateId = agBackwardPo.getRateId();
//			ChargeAccountPo accPo = chargeAccountDao.selectByAgencyId(agBackwardPo.getId());
//			if(accPo != null){
//				resultMap.put("accountCredit", accPo.getAccountCredit());
//				//po.setAccountCredit(accPo.getAccountCredit());
//			}
//			RateBackwardPo rateBackPo = rateBackwardDao.get(rateId);
//			if(rateBackPo != null){
////				po.setRateName(rateBackPo.getRateName());
//				resultMap.put("rateName", rateBackPo.getRateName());
//			}
			try {
				if(StringHelper.isNotEmpty(agBackwardPo.getUserRealName())){
					agBackwardPo.setUserRealName(new String(agBackwardPo.getUserRealName().getBytes("iso-8859-1"), "utf-8"));
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			List<RateBackwardPo> rateList = rateBackwardDao.selectByRootId(agBackwardPo.getRootAgencyId(),BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());//查一遍rate列表
			List<RateBackwardPo> billRateList = rateBackwardDao.selectByRootId(agBackwardPo.getRootAgencyId(),BillTypeEnum.CORPORATE_BUSINESS.getValue());//查一遍rate列表
			resultMap.put("rateList", rateList);//费率列表
			resultMap.put("billRateList", billRateList);//费率列表
			resultMap.put("agencyPo", agBackwardPo);
		}
		return resultMap;
	}

	/**
	 * @description:编辑代理商信息准备参数
	 * @param id
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月22日 下午4:08:47
	 */
	@Override
	public Map<String, Object> prepareParam(String id) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if(StringHelper.isNotEmpty(id)){
			AgencyBackwardPo agBackwardPo = agencyVODao.get(Integer.parseInt(id));
			if(agBackwardPo != null){
				if(StringHelper.isEmpty(agBackwardPo.getUserApiKey()) && agBackwardPo.getAgencyTag() == AgencyTagEnum.DATA_USER.getValue())
				{
					UUIDGenerator generator = new UUIDGenerator();
					String uuid = generator.generate().toString();
	//				String md5ApiKey = MD5.getMd5(agBackwardPo.getUserName())
					agBackwardPo.setUserApiKey(uuid);
					int res = agencyVODao.update(agBackwardPo);//更新代理商apikey信息
					if(res < 1)//没有更新成功也不展示出来
					{
						agBackwardPo.setUserApiKey("");//不能让页面提交过来
					}
				}else if(agBackwardPo.getAgencyTag() == AgencyTagEnum.PLATFORM_USER.getValue()){
					agBackwardPo.setUserApiKey("没有");
				}
				//取随便一家的信用值，因为对公对私的信用额统一了
//				ChargeAccountPo chargeAccountPo = chargeAccountAO.getAccountByAgencyId(Integer.parseInt(id),BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
			
//				agBackwardPo.setAccountCredit(chargeAccountPo.getAccountCredit());//设置信用值
				
//				List<RateBackwardPo> list = rateBackwardDao.selectByRootId(agBackwardPo.getRootAgencyId(),BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
//				List<RateBackwardPo> billList = rateBackwardDao.selectByRootId(agBackwardPo.getRootAgencyId(),BillTypeEnum.CORPORATE_BUSINESS.getValue());
//				resultMap.put("rateList", list);//费率列表
//				resultMap.put("billRateList", billList);//带票费率列表
				resultMap.put("agencyPo", agBackwardPo);
			}
		}
		
		return resultMap;
	}

	/**
	 * @description:通过代理商id获得该代理商的邀请码
	 * @param id
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月23日 下午4:10:10
	 */
	@Override
	public String getVerifyCodeById(int id) {
		return agencyVODao.get(id).getVerifyCode();//返回数据库里面的邀请码
	}

	/**
	 * @description:通过id找到代理商实体
	 * @param id
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月27日 上午10:24:34
	 */
	@Override
	public AgencyBackwardPo getAgencyById(Integer id) {
//		if(StringHelper.isNotEmpty(id)){
//			int intId = Integer.parseInt(id);
			return agencyVODao.get(id);
//		}
//		return null;
	}
	/**
	 * @description: 查询是否id属于二级代理商以下(限制登陆用户权限)
	 * @param agencyId
	 * @return 1，属于
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月3日 上午10:25:19
	 */
	@Override
	public int checkNextSecondAgency(int agencyId) {
		return agencyVODao.checkSecondAgency(agencyId);
	}

	/**
	 * @description: 修改密码
	 * @param agencyId
	 * @param enterPass
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月11日 上午10:11:02
	 */
	@Override
	public int updatePass(int agencyId, String enterPass) {
		AgencyBackwardPo agencyPo = new AgencyBackwardPo();
		agencyPo.setUserPass(enterPass);
		agencyPo.setId(agencyId);
		
//		agencyVODao.updateLocal(agencyPo,new WherePrams("id", "=", agencyId));
		return agencyVODao.updatePass(agencyId, enterPass);
	}

	/**
	 * @description: 查询没有绑定的代理商
	 * @param rootAgencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月17日 下午3:20:44
	 */
	@Override
	public Pagination<AgencyBackwardVO> getUnbindAgency(int rootAgencyId, AgencyActiveRateDTO aardto, PageParam pageParam) {
		Map<String, Object> paramsMap = getUnbindMapByEntity(aardto);
		paramsMap.put("rootAgencyId", rootAgencyId);
		List<AgencyBackwardVO> records = null;
		int totalRecord = 0;
		int pageSize = 10;
		int pageNo = 1;
		
		
		if(aardto.getBindState() == BindStateEnum.NO.getValue()){
			totalRecord = agencyVODao.countNoBAgency(paramsMap);
			if(pageParam != null){
				pageSize = pageParam.getPageSize();
				pageNo = pageParam.getPageNo();
			}
			paramsMap.put("start", (pageNo-1)*pageSize);
			paramsMap.put("end", pageSize);
			records = agencyVODao.getNoBAgency(paramsMap);
		}else{
			totalRecord = agencyVODao.countUnbindAgency(paramsMap);
			if(pageParam != null){
				pageSize = pageParam.getPageSize();
				pageNo = pageParam.getPageNo();
			}
			paramsMap.put("start", (pageNo-1)*pageSize);
			paramsMap.put("end", pageSize);
			records = agencyVODao.getUnbindAgency(paramsMap);
		}
		
		for (AgencyBackwardVO agencyBackwardVO2 : records) {
			if(agencyBackwardVO2.getCreateTime() != null){
				agencyBackwardVO2.setCreateTimeStr(DateUtil.formatAll(agencyBackwardVO2.getCreateTime()));
			}
		}
		return new Pagination<AgencyBackwardVO>(records, totalRecord, pageNo, pageSize);
	}

	/**
	 * @description: 封装查询参数
	 * @param aardto
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月18日 上午11:01:45
	 */
	private Map<String, Object> getUnbindMapByEntity(AgencyActiveRateDTO aardto) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		if(aardto.getRateDiscountId() != null){
			paramsMap.put("rateDiscountId", aardto.getRateDiscountId());
		}
		if(aardto.getAgencyTag() != null){
			paramsMap.put("agencyTag", aardto.getAgencyTag());
		}
//		if(aardto.getBindState() != null){
//			paramsMap.put("bindState", aardto.getBindState());
//		}
		if(StringHelper.isNotEmpty(aardto.getAgencyName())){
			paramsMap.put("userName", aardto.getAgencyName());
		}
		return paramsMap;
	}

	@Override
	public boolean checkName(String name) {
		long res = agencyVODao.count(new WherePrams("user_name", "=", name));
		if(res > 0){
			return false;//已经存在，不允许再次注册,显示提示错误信息
		}
		return true;
	}

	@Override
	public AgencyBackwardPo getRootAgencyById(Integer agencyId) {
		return agencyVODao.getRootAgencyById(agencyId);
	}

	@Override
	public AgencyBackwardPo getAgencyByAccountId(Integer accountId) {
		ChargeAccountPo accountPo = chargeAccountDao.get(accountId);
		if(accountPo != null){
			AgencyBackwardPo agencyPo = agencyVODao.get(accountPo.getAgencyId());
			return agencyPo;
		}
		return null;
	}

	@Override
	public Boolean checkIdByPass(int agencyId,String userPass) {
		AgencyBackwardPo resultAgency = agencyVODao.get(agencyId);
		if(resultAgency != null)
		{
			if(resultAgency.getUserPass().equals(userPass))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean checkSecondAgency(int agencyId) {
		AgencyBackwardPo agency = agencyVODao.getSecondAgency(agencyId);
		if(agency != null){
			return true;
		}
		return false;
	}
}
