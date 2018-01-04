package com.weizu.flowsys.web.agency.ao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.operatorPg.enums.AgencyTagEnum;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.BindStateEnum;
import com.weizu.flowsys.operatorPg.enums.PgInServiceEnum;
import com.weizu.flowsys.operatorPg.enums.TelChannelTagEnum;
import com.weizu.flowsys.util.AddressUtils;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.util.StringUtil2;
import com.weizu.flowsys.web.activity.dao.impl.RateBackwardDaoImpl;
import com.weizu.flowsys.web.activity.pojo.AccountActiveRateDTO;
import com.weizu.flowsys.web.activity.pojo.TelrateBindAccountVO;
import com.weizu.flowsys.web.agency.dao.AgencyVODaoInterface;
import com.weizu.flowsys.web.agency.dao.impl.ChargeAccountDao;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.web.foundation.DateUtil;
import com.weizu.web.foundation.String.StringHelper;
import com.weizu.web.foundation.hash.Hash;

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
//	@Resource
//	private AddressUtils addressUtils;

	/**
	 * @description:注册平台代理商（账户）
	 * @param agencyBackward
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月24日 下午5:02:16
	 */
	@Transactional
	@Override
	public Integer addAgency(HttpSession httpSession,AgencyBackwardPo agencyBackward) {
		//是否存在该邀请码，如果存在返回该邀请码所属的代理商id
		//获得父级代理商的id
		Integer code = agencyVODao.getAgencyIdByVerifyCode(agencyBackward.getVerifyCode());
		if(code != null){//注册商户之前绑定父代理商
			agencyBackward.setRootAgencyId(code);
			//把自己的代理商名称设为唯一邀请码，好像有风险，万一别人的代理商名称被
			agencyBackward.setVerifyCode(agencyBackward.getUserName());//置空父级代理商的邀请码，以便绕过绕过非空验证，设置自己的邀请码
			
			agencyBackward.setCreateTime(System.currentTimeMillis());
			agencyBackward.setAgencyTag(AgencyTagEnum.PLATFORM_USER.getValue());
			//用户密码加密
			String userPass = Hash.BASE_UTIL.encode(agencyBackward.getUserPass());
			agencyBackward.setUserPass(userPass);
			int addAgency = agencyVODao.add(agencyBackward);
			//利用nextId函数获得当前注册代理商id,同时新增一个对私一个账户
			//默认开通对私账户
			if(addAgency > 0){
				int agencyId = (int) (agencyVODao.nextId()-1);//适用于自动增长
				//设置代理商访问权限
				if(checkNextSecondAgency(agencyId) == 1){//一个代理商id找到了一条记录，并且这条记录满足三级代理商的条件
					httpSession.setAttribute("power", "limited");
				}else{
					httpSession.setAttribute("power", "no");
				}
				
				agencyBackward.setId(agencyId);
				AgencyBackwardVO agencyVO = getVOByPo(agencyBackward);
				httpSession.setAttribute("loginContext", agencyVO);
				ChargeAccountPo chargePo = new ChargeAccountPo(agencyId,agencyVO.getRootAgencyId(), 0.00d, BillTypeEnum.BUSINESS_INDIVIDUAL.getValue(), agencyBackward.getCreateTime(), agencyBackward.getUserName());
				int addCharge = chargeAccountDao.add(chargePo);
				if(addCharge > 0){
					int accountId = (int) (chargeAccountDao.nextId()-1);
					chargePo.setId(accountId);
					httpSession.setAttribute("chargeAccount",chargePo);
					return PgInServiceEnum.OPEN.getValue();
				}
			}
		}else{
			return null;
		}
		return PgInServiceEnum.CLOSE.getValue();//没有满足条件的默认返回失败
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
		String userPass = Hash.BASE_UTIL.decode(agencyBackward.getUserPass());
		AgencyBackwardVO agencyVO = new AgencyBackwardVO(agencyBackward.getId(),
				agencyBackward.getRootAgencyId(), agencyBackward.getUserName(), 
				agencyBackward.getUserRealName(),userPass , 
				agencyBackward.getAgencyTel(), agencyBackward.getUserEmail(), 
				agencyBackward.getAgencyIp(), agencyBackward.getCreateTime(), 
				agencyBackward.getVerifyCode(),agencyBackward.getCallBackIp(),agencyBackward.getOtherContact(),agencyBackward.getAgencyTag());
		agencyVO.setUserApiKey(agencyBackward.getUserApiKey());
		agencyVO.setAgencyMark(agencyBackward.getAgencyMark());
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
		agencyPo.setCallBackIp(agencyBackward.getCallBackIp());
		agencyPo.setAgencyMark(agencyBackward.getAgencyMark());
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
//		String userName = StringUtil2.filterString(agencyBackward.getUserName());
		String userName = agencyBackward.getUserName();
		//防sql注入
		if(StringHelper.isNotEmpty(userName)){
			WherePrams where = new WherePrams("user_name", "=", userName);
			AgencyBackwardPo resultAgency = null;
			if(StringHelper.isNotEmpty(agencyBackward.getAgencyTel())){//注册使用电话验证
				where = where.or("agency_tel", "=", agencyBackward.getAgencyTel());
			}
			resultAgency = agencyVODao.get(where);
			
			if(resultAgency != null)
			{
				String dataUserPass = Hash.BASE_UTIL.decode(resultAgency.getUserPass());
				
				if(dataUserPass.equals(userPass))
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
		}else{
			resultMap.put("msg", "请重新登陆");
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
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		if(agencyBackward != null){
			if(StringHelper.isNotEmpty(agencyBackward.getUserName())){
				paramsMap.put("userName", agencyBackward.getUserName());
			}
			if(agencyBackward.getAgencyTag() != null){
				//认证代理商只查对公，平台代理商只查对私
				if (AgencyTagEnum.DATA_USER.getValue().equals(agencyBackward.getAgencyTag())) {
//					paramsMap.put("billType", BillTypeEnum.CORPORATE_BUSINESS.getValue());
					paramsMap.put("agencyTag", agencyBackward.getAgencyTag());
				}else if(AgencyTagEnum.PLATFORM_USER.getValue().equals(agencyBackward.getAgencyTag())){
					paramsMap.put("billType", BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
				}
			}
			if(StringHelper.isNotEmpty(agencyBackward.getAgencyMark())){
				paramsMap.put("agencyMark", agencyBackward.getAgencyMark());
			}
//			if(agencyBackward.getBillType() != null){
//				paramsMap.put("billType", agencyBackward.getBillType());
//			}
//			else{//搜索平台用户列表中 不带票账户
//				paramsMap.put("billType", BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
//			}
		}
		return paramsMap;
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
//		agencyBackwardVO.setRootAgencyId(rootAgencyId);
		searchMap.put("rootAgencyId", rootAgencyId);
		int totalRecord = agencyVODao.countByAgencyVO(searchMap);
//		whereParams.limit(pageNo * pageSize, pageSize);
		
		/**得到分页记录*/
		searchMap.put("start", (pageNo-1) * pageSize);
		searchMap.put("end", pageSize);
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
//	@Override
//	public Map<String, Object> prepareParam(AgencyBackwardPo agBackwardPo) {
//		Map<String, Object> resultMap = new HashMap<String, Object>();
//		if(agBackwardPo != null){
////			Long rateId = agBackwardPo.getRateId();
////			ChargeAccountPo accPo = chargeAccountDao.selectByAgencyId(agBackwardPo.getId());
////			if(accPo != null){
////				resultMap.put("accountCredit", accPo.getAccountCredit());
////				//po.setAccountCredit(accPo.getAccountCredit());
////			}
////			RateBackwardPo rateBackPo = rateBackwardDao.get(rateId);
////			if(rateBackPo != null){
//////				po.setRateName(rateBackPo.getRateName());
////				resultMap.put("rateName", rateBackPo.getRateName());
////			}
//			try {
//				if(StringHelper.isNotEmpty(agBackwardPo.getUserRealName())){
//					agBackwardPo.setUserRealName(new String(agBackwardPo.getUserRealName().getBytes("iso-8859-1"), "utf-8"));
//				}
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			}
//			List<RateBackwardPo> rateList = rateBackwardDao.selectByRootId(agBackwardPo.getRootAgencyId(),BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());//查一遍rate列表
//			List<RateBackwardPo> billRateList = rateBackwardDao.selectByRootId(agBackwardPo.getRootAgencyId(),BillTypeEnum.CORPORATE_BUSINESS.getValue());//查一遍rate列表
//			resultMap.put("rateList", rateList);//费率列表
//			resultMap.put("billRateList", billRateList);//费率列表
//			resultMap.put("agencyPo", agBackwardPo);
//		}
//		return resultMap;
//	}

	/**
	 * @description:编辑代理商信息准备参数
	 * @param id
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月22日 下午4:08:47
	 */
	@Override
	public AgencyBackwardPo prepareParam(Integer id) {
		AgencyBackwardPo agBackwardPo = agencyVODao.get(id);
//		if(agBackwardPo != null){
//			if(StringHelper.isEmpty(agBackwardPo.getUserApiKey()) && agBackwardPo.getAgencyTag() == AgencyTagEnum.DATA_USER.getValue())
//			{
//				UUIDGenerator generator = new UUIDGenerator();
//				String uuid = generator.generate().toString();
////				String md5ApiKey = MD5.getMd5(agBackwardPo.getUserName())
//				agBackwardPo.setUserApiKey(uuid);
//				int res = agencyVODao.update(agBackwardPo);//更新代理商apikey信息
//				if(res < 1)//没有更新成功也不展示出来
//				{
//					agBackwardPo.setUserApiKey("");//不能让页面提交过来
//				}
//			}else if(agBackwardPo.getAgencyTag() == AgencyTagEnum.PLATFORM_USER.getValue()){
//				agBackwardPo.setUserApiKey("没有");
//			}
//			//取随便一家的信用值，因为对公对私的信用额统一了
////				ChargeAccountPo chargeAccountPo = chargeAccountAO.getAccountByAgencyId(Integer.parseInt(id),BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
//		
////				agBackwardPo.setAccountCredit(chargeAccountPo.getAccountCredit());//设置信用值
//			
////				List<RateBackwardPo> list = rateBackwardDao.selectByRootId(agBackwardPo.getRootAgencyId(),BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
////				List<RateBackwardPo> billList = rateBackwardDao.selectByRootId(agBackwardPo.getRootAgencyId(),BillTypeEnum.CORPORATE_BUSINESS.getValue());
////				resultMap.put("rateList", list);//费率列表
////				resultMap.put("billRateList", billList);//带票费率列表
//		}
		
		return agBackwardPo;
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
	@Transactional
	@Override
	public int updatePass(int agencyId, String enterPass) {
//		AgencyBackwardPo agencyPo = new AgencyBackwardPo();
		String dataUserPass = Hash.BASE_UTIL.encode(enterPass);
//		agencyPo.setUserPass(dataUserPass);
//		agencyPo.setId(agencyId);
		
//		agencyVODao.updateLocal(agencyPo,new WherePrams("id", "=", agencyId));
		return agencyVODao.updatePass(agencyId, dataUserPass);
	}

	/**
	 * @description: 查询没有绑定的代理商
	 * @param rootAgencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月17日 下午3:20:44
	 */
	@Override
	public Pagination<AgencyBackwardVO> getUnbindAgency(int billTypeRate, int rootAgencyId, AccountActiveRateDTO aardto, PageParam pageParam) {
		Map<String, Object> paramsMap = getUnbindMapByEntity(aardto);
		paramsMap.put("billType", billTypeRate);
		paramsMap.put("rootAgencyId", rootAgencyId);
		List<AgencyBackwardVO> records = null;
		int totalRecord = 0;
		int pageSize = 10;
		int pageNo = 1;
		
		if(aardto.getBindState() == BindStateEnum.NO.getValue()){//未绑定
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
	

	@Override
	public Pagination<AgencyBackwardVO> getUnbindTelAgency(
			int rootAgencyId, TelrateBindAccountVO telrateBindAccountVO,
			PageParam pageParam) {
		Map<String, Object> paramsMap = getUnbindTelMapByEntity(telrateBindAccountVO);
		paramsMap.put("billType", telrateBindAccountVO.getBillType());
		paramsMap.put("rootAgencyId", rootAgencyId);
		List<AgencyBackwardVO> records = null;
		int totalRecord = 0;
		int pageSize = 10;
		int pageNo = 1;
		if(BindStateEnum.NO.getValue().equals(telrateBindAccountVO.getBindState())){
			totalRecord = agencyVODao.countNoBTelAgency(paramsMap);
			if(pageParam != null){
				pageSize = pageParam.getPageSize();
				pageNo = pageParam.getPageNo();
			}
			paramsMap.put("start", (pageNo-1)*pageSize);
			paramsMap.put("end", pageSize);
			records = agencyVODao.getNoBTelAgency(paramsMap);
		}else{
			totalRecord = agencyVODao.countUnbindTelAgency(paramsMap);
			if(pageParam != null){
				pageSize = pageParam.getPageSize();
				pageNo = pageParam.getPageNo();
			}
			paramsMap.put("start", (pageNo-1)*pageSize);
			paramsMap.put("end", pageSize);
			records = agencyVODao.getUnbindTelAgency(paramsMap);
		}
		for (AgencyBackwardVO agencyBackwardVO2 : records) {
			if(agencyBackwardVO2.getCreateTime() != null){
				agencyBackwardVO2.setCreateTimeStr(DateUtil.formatAll(agencyBackwardVO2.getCreateTime()));
			}
		}
		return new Pagination<AgencyBackwardVO>(records, totalRecord, pageNo, pageSize);
	}
	
	@Override
	public List<AgencyBackwardVO> getUnbindTelAgencyList(
			int rootAgencyId, TelrateBindAccountVO telrateBindAccountVO) {
		Map<String, Object> paramsMap = getUnbindTelMapByEntity(telrateBindAccountVO);
		paramsMap.put("rootAgencyId", rootAgencyId);
		List<AgencyBackwardVO> records = null;
		if(BindStateEnum.NO.getValue().equals(telrateBindAccountVO.getBindState())){
			records = agencyVODao.getNoBTelAgency(paramsMap);
		}else{//与话费折扣解绑列表
			records = agencyVODao.getUnbindTelAgency(paramsMap);
		}
		return records;
	}

	/**
	 * @description: 封装话费绑定查询参数
	 * @param aardto
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月23日 下午3:51:15
	 */
	private Map<String, Object> getUnbindTelMapByEntity(TelrateBindAccountVO telrateBindAccountVO) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		if(telrateBindAccountVO.getTelRateId() != null){
			paramsMap.put("telRateId", telrateBindAccountVO.getTelRateId());
		}
		if(telrateBindAccountVO.getRateFor() != null){
			paramsMap.put("rateFor", telrateBindAccountVO.getRateFor());
		}else{
			paramsMap.put("rateFor", TelChannelTagEnum.DATA_USER.getValue());
			
		}
		///paramsMap.put("rateFor", TelChannelTagEnum.DATA_USER.getValue());
			
		if(telrateBindAccountVO.getBillType() != null){
			paramsMap.put("billType", telrateBindAccountVO.getBillType());
		}
//		if(aardto.getBindState() != null){
//			paramsMap.put("bindState", aardto.getBindState());
//		}
		if(StringHelper.isNotEmpty(telrateBindAccountVO.getAgencyMark())){
			paramsMap.put("agencyMark", telrateBindAccountVO.getAgencyMark());
		}
		if(StringHelper.isNotEmpty(telrateBindAccountVO.getAgencyName())){
			paramsMap.put("userName", telrateBindAccountVO.getAgencyName());
		}
		return paramsMap;
	}
	
	@Override
	public List<AgencyBackwardVO> getUnbindAgencyList(int billTypeRate,
			int rootAgencyId, AccountActiveRateDTO aardto) {
		Map<String, Object> paramsMap = getUnbindMapByEntity(aardto);
//		paramsMap.put("billType", billTypeRate);
		paramsMap.put("rootAgencyId", rootAgencyId);
		List<AgencyBackwardVO> records = null;
		if(aardto.getBindState() == BindStateEnum.NO.getValue()){
			records = agencyVODao.getNoBAgency(paramsMap);
		}else{//解绑列表
			records = agencyVODao.getUnbindAgency(paramsMap);
		}
		return records;
	}
	
	/**
	 * @description: 封装流量绑定查询参数
	 * @param aardto
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月18日 上午11:01:45
	 */
	private Map<String, Object> getUnbindMapByEntity(AccountActiveRateDTO aardto) {
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
		if(StringHelper.isNotEmpty(aardto.getAgencyMark())){
			paramsMap.put("agencyMark", aardto.getAgencyMark());
		}
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
	public boolean checkVerifiCode(String verifyCode) {
		long res = agencyVODao.count(new WherePrams("verify_code", "=", verifyCode));
		if(res > 0){
			return true;//邀请码存在，允许注册
		}
		return false;
	}

	@Override
	public AgencyBackwardPo getRootAgencyById(Integer agencyId) {
		return agencyVODao.getRootAgencyById(agencyId);
	}

	@Override
	public AgencyBackwardPo getRootAgencyByAccountId(Integer accountId) {
		ChargeAccountPo accountPo = chargeAccountDao.get(accountId);
		if(accountPo != null){
			AgencyBackwardPo agencyPo = agencyVODao.getRootAgencyById(accountPo.getAgencyId());
			return agencyPo;
		}
		return null;
	}
	@Override
	public AgencyBackwardPo getAgencyByAccountId(Integer accountId) {
		AgencyBackwardPo agencyPo = agencyVODao.getAgencyByAccountId(accountId);
		return agencyPo;
	}

	@Override
	public Boolean checkIdByPass(int agencyId,String userPass) {
		AgencyBackwardPo resultAgency = agencyVODao.get(agencyId);
		String dataUserPass = Hash.BASE_UTIL.decode(resultAgency.getUserPass());
		if(resultAgency != null)
		{
			if(dataUserPass.equals(userPass))
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

	@Override
	public Boolean checkVerifyCode(String verifyCode,String userName) {
		if(verifyCode != null){
			int resultNum = agencyVODao.checkVerifyCode(verifyCode,userName);
			if(resultNum > 0){
				return false;
			}
			return true;
		}else{
			return null;
		}
	}

//	@Override
//	public String getLoginIpAddress(HttpServletRequest request) {
//		String address = addressUtils.getAddresses(request, "utf-8");
//		return null;
//	}
}
