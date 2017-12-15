package com.weizu.flowsys.web.agency.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpContext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ConfirmStateEnum;
import com.weizu.flowsys.operatorPg.enums.ConfirmStateTransferEnum;
import com.weizu.flowsys.operatorPg.enums.EventTypeEnum;
import com.weizu.flowsys.operatorPg.enums.LoginStateEnum;
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.PgInServiceEnum;
import com.weizu.flowsys.util.AddressUtils;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.ao.OperatorDiscountAO;
import com.weizu.flowsys.web.activity.ao.RateBackwardAO;
import com.weizu.flowsys.web.activity.dao.impl.RateBackwardDaoImpl;
import com.weizu.flowsys.web.agency.ao.AgencyAO;
import com.weizu.flowsys.web.agency.ao.ChargeAccountAo;
import com.weizu.flowsys.web.agency.ao.ChargeRecordAO;
import com.weizu.flowsys.web.agency.dao.BankAccountDaoInterface;
import com.weizu.flowsys.web.agency.dao.impl.ChargeAccountDao;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.agency.pojo.CompanyCredentialsPo;
import com.weizu.flowsys.web.agency.pojo.TransferMsgVo;
import com.weizu.flowsys.web.agency.url.AgencyURL;
import com.weizu.flowsys.web.log.AccountEventPo;
import com.weizu.flowsys.web.log.ao.AccountEventAO;
import com.weizu.flowsys.web.log.dao.IAccountEventDao;
import com.weizu.web.foundation.DateUtil;
import com.weizu.web.foundation.VerifyCodeUtils;
import com.weizu.web.foundation.String.StringHelper;

@Controller
@RequestMapping(value = AgencyURL.MODEL_NAME)
public class AgencyController {
	// 默认返回的路径是jsp/.jsp
	@Resource
	private AgencyAO agencyAO;
	@Resource
	private RateBackwardAO rateBackwardAO;
	@Resource
	private ChargeRecordAO chargeRecordAO;
	@Resource
	private ChargeAccountDao chargeAccountDao;
	@Resource
	private ChargeAccountAo chargeAccountAO;
	@Resource
	private RateBackwardDaoImpl rateBackwardDao;
	@Resource
	private OperatorDiscountAO operatorDiscountAO;
	@Resource
	private BankAccountDaoInterface bankAccountDao;
	@Resource
	private AddressUtils addressUtils;
	@Resource
	private IAccountEventDao accountEventDao;
	
	@Resource
	private AccountEventAO accountEventAO;
	
	
//	/**
//	 * @description:添加代理商跳转链接
//	 * @param agencyBackward
//	 * @return
//	 * @author:POP产品研发部 宁强
//	 * @createTime:2017年4月20日 下午12:41:11
//	 */
//	@RequestMapping(value = "/index.html")
//	public ModelAndView registAgency() {
//		return new ModelAndView("index");
//	}

//	/**
//	 * @description:添加代理商跳转链接
//	 * @param agencyBackward
//	 * @return
//	 * @author:POP产品研发部 宁强
//	 * @createTime:2017年4月20日 下午12:41:11
//	 */
//	@RequestMapping(value = "add")
//	public String add() {
//		// return new ModelAndView("index");
//		return "/login";
//	}

//	/**
//	 * @description:添加代理商
//	 * @param agencyBackward
//	 * @return
//	 * @author:POP产品研发部 宁强
//	 * @createTime:2017年4月20日 下午12:51:01
//	 */
//	@RequestMapping(value = "save")
//	public ModelAndView registAgency(AgencyBackwardPo agencyBackward) {
//		agencyAO.addAgency(agencyBackward);
//		return new ModelAndView("first");
//	}

	/**
	 * @description:用户登陆
	 * @param agencyBackward
	 * @param httpSession
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月6日 下午12:17:07
	 */
	@RequestMapping(value = AgencyURL.LOGIN)
	public ModelAndView login(AgencyBackwardPo agencyBackward,
			HttpServletRequest request, Model model) {
		if (null == agencyBackward) {
			System.out.println("执行goLogin");
		}
		Map<String, Object> resultMap = agencyAO.login(agencyBackward);
		AgencyBackwardPo resultPo = (AgencyBackwardPo) resultMap.get("entity");// 获得返回的登陆实体
		String resultMsg = resultMap.get("msg").toString();
		//一定要分开来查，不能连表查
		if (resultPo != null && "success".equals(resultMsg)) {
			ChargeAccountPo chargeAccountPo1 = chargeAccountAO
					.getAccountByAgencyId(resultPo.getId(),BillTypeEnum.CORPORATE_BUSINESS.getValue());
			
			HttpSession session = request.getSession();
			Map<String,Object> addressMap  = addressUtils.getAddresses(request, "utf-8");
			String address = addressMap.get("address").toString();
			Boolean isSupperUser = resultPo.getRootAgencyId() == 0;
			System.out.println(address);
			if(isSupperUser && !("南昌市".equals(address)  || "内网IP".equals(address))){//|| "上海市".equals(address)
				Map<String,Object> loginMap = new HashMap<String, Object>();
				loginMap.put("userName", agencyBackward.getUserName());
				loginMap.put("userPass", agencyBackward.getUserPass());
				loginMap.put("msg", "该账号已限制登陆地区");
				return new ModelAndView("/agency/login_page", "loginMap", loginMap);
//				model.addAttribute(loginMap);
//				return "/agency/login_page";
			}else{
				String eventIp = addressMap.get("ip").toString();
				//得到上一次的登陆日志
				
				WherePrams where = new WherePrams("agency_id", "=", resultPo.getId()).and("event_state", "=", LoginStateEnum.ING.getValue());
				where.orderBy("event_time",WherePrams.DESC);
				where.limit(0, 1);
				//已经拦截了等出去的登陆
				AccountEventPo eventPo = accountEventAO.getLastByAgency(resultPo.getId(), EventTypeEnum.AGENCY_LOGIN.getValue());
				if(eventPo != null){
					session.setAttribute("loginIpAddress", eventPo.getEventLocation());
					session.setAttribute("loginTime", eventPo.getEventTime()==null?System.currentTimeMillis():DateUtil.formatAll(eventPo.getEventTime()));
				}else{
					session.setAttribute("loginIpAddress", address);
				}
				
				//添加登陆日志
				accountEventDao.add(new AccountEventPo(resultPo.getId(), EventTypeEnum.AGENCY_LOGIN.getValue(), System.currentTimeMillis(), address, eventIp, LoginStateEnum.ING.getValue()+""));
//				int logAdd = accountEventDao.add(new AccountEventPo(resultPo.getId(), EventTypeEnum.AGENCY_LOGIN.getValue(), System.currentTimeMillis(), address, eventIp, LoginStateEnum.ING.getValue()));
//				System.out.println("日志成功添加："+logAdd);
			}
			
			if(chargeAccountPo1 == null && isSupperUser){//超管登陆的时候，默认如果没有对公账户，就给他创建一个对公账户
				chargeAccountPo1 = new ChargeAccountPo(resultPo.getId(), 0.00d, BillTypeEnum.CORPORATE_BUSINESS.getValue(), System.currentTimeMillis(), agencyBackward.getUserName());
				chargeAccountAO.createAccount(chargeAccountPo1);//给超管创建一个
			}
			//对私账户
			ChargeAccountPo chargeAccountPo = chargeAccountAO
					.getAccountByAgencyId(resultPo.getId(),BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
			AgencyBackwardVO agencyVO = agencyAO.getVOByPo(resultPo);
			session.setMaxInactiveInterval(24*60*60);//一天
			//注册的时候已经保证了可以进行表连接
			session.setAttribute("chargeAccount", chargeAccountPo);//对私
			session.setAttribute("chargeAccount1", chargeAccountPo1);//对公
			
			String agencyIp = agencyBackward.getAgencyIp();
			if(StringHelper.isNotEmpty(agencyIp) && "telLogin".equals(agencyIp)){
				session.setAttribute("telLogin", agencyIp);//对公
			}
			
//			List<RateBackwardPo> rateList = rateBackwardDao.selectByRootId(resultPo.getId());
			session.setAttribute("loginContext", agencyVO);// 保存登陆实体到session中
			
			if(agencyAO.checkNextSecondAgency(agencyVO.getId()) == 1){
				//设置访问权限为限制(三级代理商)
				session.setAttribute("power", "limited");
				ChargeAccountPo parentChargeAccount = chargeAccountAO
						.getAccountByAgencyId(resultPo.getRootAgencyId(),BillTypeEnum.CORPORATE_BUSINESS.getValue());
				if(parentChargeAccount != null){//父亲代理商有对公账户
					session.setAttribute("companyAccount", "yes");
				}else{
					session.setAttribute("companyAccount", "no");//设置代理商不能开通对公账户
				}
			}
			else{
				session.setAttribute("power", "no");
			}
			session.setAttribute("loginContext", agencyVO);// 保存登陆实体到session中
			/**设置消息*/
			int msgNum = 0;
			List<CompanyCredentialsPo> list = chargeAccountAO.getUnconfirmedAccount(resultPo.getId(),ConfirmStateEnum.ON_CONFIRM.getValue());
			if(list != null && list.size() > 0){
				session.setAttribute("unconfirm", list.get(0));
				session.setAttribute("unconfirmSize", list.size());
				msgNum += list.size();
			}
			List<TransferMsgVo> transferMsgList = bankAccountDao.getTransferMsg(resultPo.getId(), ConfirmStateTransferEnum.ON_CONFIRM.getValue());
			if(transferMsgList != null && transferMsgList.size() > 0){
				session.setAttribute("transferMsgList", transferMsgList);
				for (TransferMsgVo transferMsgVo : transferMsgList) {
					msgNum += transferMsgVo.getTfnum();
				}
//				msgNum += transferMsgList.size();
			}
			
			session.setAttribute("msgNum", msgNum);
			
			return new ModelAndView("/agency/login_page");// 返回登录人主要账户信息（余额，透支额）
//			return "/agency/login_page";
		} else {//保留参数
			Map<String,Object> loginMap = new HashMap<String, Object>();
			loginMap.put("userName", agencyBackward.getUserName());
			loginMap.put("userPass", agencyBackward.getUserPass());
			loginMap.put("msg", resultMsg);
//			model.addAttribute(loginMap);
//			return "/agency/login_page";
			return new ModelAndView("/agency/login_page", "loginMap", loginMap);
		}
	}
	/**
	 * @description: 首页控制
	 * @param request
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月9日 上午9:08:19
	 */
//	@RequestMapping(value=AgencyURL.INDEX)
//	public String goIndex(HttpServletRequest request) {
////		request.get
//		AgencyBackwardVO agencyVo = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
//		if(agencyVo == null){
//			return "/agency/login_page";
//		}
//		return "index";
//	}

	/**
	 * @description: 跳转到注册页面
	 * @param request
	 * @param rootAgencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月3日 上午11:35:33
	 */
	@RequestMapping(value = AgencyURL.REGISTER_PAGE)
	public ModelAndView registerPage(AgencyBackwardPo agencyBackward,HttpServletRequest request,@RequestParam(value="rootAgencyId",required=false)String rootAgencyId) {
		
		if(StringHelper.isNotEmpty(rootAgencyId)){//适用于自动生成的页面
			request.getSession().setAttribute("rootAgencyId", rootAgencyId);
		}
		Map<String,Object> resultMap = new HashMap<String, Object>();
		resultMap.put("reg", agencyBackward);
		return new ModelAndView("/agency/register_page","resultMap",resultMap);
	}
	
	/**
	 * @description: 首页展示信息
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月7日 下午6:45:53
	 */
	@RequestMapping(value = AgencyURL.WELCOME)
	public ModelAndView welcomePage(HttpServletRequest request){
		
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		String power = request.getSession().getAttribute("power").toString();
		if("limited".equals(power))
		{//三级代理商
			
		}
//		chargeAccountAO.
		Map<String,Object> resultMap = new HashMap<String, Object>();
		resultMap.put("OperatorTypeEnums", OperatorTypeEnum.toList());
		
		return new ModelAndView("/agency/welcome_page","resultMap",resultMap);
	}
	/**
	 * @description: 修改密码页面
	 * @param request
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月11日 上午9:44:18
	 */
	@RequestMapping(value = AgencyURL.RESET_PASS_PAGE)
	public ModelAndView resetPassPage(HttpServletRequest request, @RequestParam(value="agencyId",required = false)String agencyId, String tag){
		Map<String,Object> resultMap = new HashMap<String, Object>();
		resultMap.put("tag", tag);
		resultMap.put("agencyId", agencyId);
		return new ModelAndView("/agency/reset_pass_page","resultMap",resultMap);
	}
	/**
	 * @description: 重置密码
	 * @param request
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月11日 上午10:08:24
	 */
	@RequestMapping(value = AgencyURL.RESET_PASS)
	public void resetPass(HttpServletRequest request, String enterPass,String tag, @RequestParam(value="agencyId",required = false)String agencyId, HttpServletResponse response){
		int aid = 0;
		AgencyBackwardVO agencyVo = null;
		if(tag != "1" && StringHelper.isNotEmpty(agencyId)){//修改下级代理商
			aid = Integer.parseInt(agencyId);
		}else{//修改自己的密码
 			agencyVo = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
			aid = agencyVo.getId();
		}
		int res = agencyAO.updatePass(aid, enterPass);
		try {
			if(res < 1){
				response.getWriter().print("error");
			}else{
				if(agencyVo != null){//修改自己的密码
					agencyVo.setUserPass(enterPass);
					request.getSession().setAttribute("loginContext", agencyVo);
				}
				response.getWriter().print("success");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @description:查询自己的邀请码信息
	 * @param request
	 * @param verifySize
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月20日 上午9:48:07
	 */
	@RequestMapping(value= AgencyURL.GET_VERIFY_CODE)
	public void getVerifyCode(HttpServletRequest request,
			HttpServletResponse response,@RequestParam(value="verifySize",required=false)String verifySize) throws IOException, ServletException {
		AgencyBackwardVO agencyVo = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		
		if(agencyVo != null){
			//String verifyCode = agencyAO.getVerifyCodeById(agencyVo.getId());//邀请码
			String verifyCode = null;
			if(StringHelper.isEmpty(verifySize)){
				verifyCode = agencyVo.getUserName();
			}else{
				boolean check = true;
				do{
					verifyCode = VerifyCodeUtils.generateVerifyCode(Integer.parseInt(verifySize));
					//通过了代理商表中代理商名称和邀请码验证，就可以
					check = agencyAO.checkVerifyCode(verifyCode, agencyVo.getUserName());
				}while(!check);
			}
			agencyVo.setVerifyCode(verifyCode);//更新rootAgency的邀请码字段
			if(agencyAO.updateAgency(agencyVo) <= 0){
				verifyCode = "添加邀请码失败！";
			}
			response.getWriter().print(verifyCode); 
		}else{
			switchAccount(request);//返回到注册页面
		}
		//先查一遍数据库看有没有邀请码，没有就生成指定位数的邀请码，并更新数据库，
		//如果有就返回邀请码直接读出来
	}
	
	

	/**
	 * @description:自己信息编辑页面（除费率，信用，余额）
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月23日 下午4:40:27
	 */
	@RequestMapping(value = AgencyURL.AGENCY_INFO)
	public ModelAndView myselfInfoPage(HttpServletRequest request) {
		AgencyBackwardVO agencyVo = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		
		if(agencyVo != null){
//			agencyAO.get
			Map<String, Object> resultMap = agencyAO.login(new AgencyBackwardPo(agencyVo.getUserName(), agencyVo.getUserPass()));
			AgencyBackwardPo resultPo = (AgencyBackwardPo) resultMap.get("entity");
			AgencyBackwardVO agencyVO = agencyAO.getVOByPo(resultPo);
			request.getSession().setAttribute("loginContext", agencyVO);
//			if(StringHelper.isEmpty(agencyVo.getVerifyCode())){//数据库中没有邀请码信息（注册时的邀请码：已经被置空）
//				String verifyCode = "";
//				verifyCode = VerifyCodeUtils.generateVerifyCode(VerifyCodeUtils.DEFAULT_SIZE);
//				agencyAO.checkVerifyCode(verifyCode, userName)
//				
//				agencyVo.setVerifyCode(verifyCode);
//				if(agencyAO.updateAgency(agencyVo) <= 0){//更新数据库中邀请码信息
//					verifyCode = "初始化邀请码失败！";
//				}else{
//					request.getSession().setAttribute("loginContext", agencyVo);//重新设置session中loginContext
//				}
//			}
			return new ModelAndView("/agency/agency_info");
		}else{
			return new ModelAndView("/agency/login_page");
		}
		
		//取代理商邀请码信息
		//先取相应代理商的邀请码信息，如果没有的话就自动生成并更新数据库,和修改session loginContext
		//如果有，就返回到loginContext中
		//修改session中的loginContext的verifyCode属性
		
	}
	
	@RequestMapping(value = AgencyURL.LOGIN_PAGE)
	public ModelAndView loginPage(String userName,String userPass) {
		Map<String,Object> loginMap = new HashMap<String, Object>();
		loginMap.put("userName", userName);
		loginMap.put("userPass", userPass);
		return new ModelAndView("/agency/login_page", "loginMap", loginMap);
	}

	/**
	 * @description:注册平台代理商（账户）
	 * @param agencyBackward
	 * @param httpSession
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月5日 下午4:54:39
	 */
	@RequestMapping(value = AgencyURL.REGISTER)
	public ModelAndView register(AgencyBackwardPo agencyBackward,
			HttpServletRequest request) {
		if (null == agencyBackward) {
			System.out.println("执行goRegister");
			return new ModelAndView("/agency/register_page");
		} else {
			Map<String, Object> map = agencyAO.login(agencyBackward);//判断用户名是否存在
			String msg = map.get("msg").toString();
			if(!"该用户名不存在！".equals(msg)){
				Map<String, Object> resultMap = new HashMap<String, Object>();
				resultMap.put("reg", agencyBackward);
				resultMap.put("msg","用户名"+agencyBackward.getUserName()+"或者手机号已注册，不需要重复注册" + msg);
				return new ModelAndView("/agency/register_page","resultMap",resultMap);
			}
			//注册用户
			HttpSession httpSession = request.getSession();
			Integer regRes = agencyAO.addAgency(httpSession,agencyBackward);
			
			if(PgInServiceEnum.OPEN.getValue().equals(regRes) ){
//				if(agencyAO.checkNextSecondAgency(agencyVO.getId()) == 1){
//					//设置访问权限为限制
//					httpSession.setAttribute("power", "limited");
//				}
//				else{
//					httpSession.setAttribute("power", "no");
//				}
//				httpSession.setAttribute("loginContext", agencyVO);
				return new ModelAndView("index");
			}else{
				Map<String, Object> resultMap = new HashMap<String, Object>();
				String regMsg = ""; 
				if(regRes == null){
					regMsg = "邀请码不存在";
				}else{
					regMsg = "账户信息添加失败";
				}
				resultMap.put("msg", regMsg);
				resultMap.put("reg", agencyBackward);
				return new ModelAndView("/agency/register_page","resultMap",resultMap);
			}
			
//			if (regRes != null) {
////				if(agencyAO.checkNextSecondAgency(agencyVO.getId()) == 1){
////					//设置访问权限为限制
////					httpSession.setAttribute("power", "limited");
////				}
////				else{
////					httpSession.setAttribute("power", "no");
////				}
////				httpSession.setAttribute("loginContext", agencyVO);
//				return new ModelAndView("index");
//			}else{
//				Map<String, Object> resultMap = new HashMap<String, Object>();
//				String regMsg = ""; 
//				if(PgInServiceEnum.CLOSE.getValue().equals(regRes) ){
//					regMsg = "邀请码不存在";
//				} else {
//					regMsg = "账户信息添加失败";
//				}
//				resultMap.put("msg", regMsg);
//				resultMap.put("reg", agencyBackward);
//				return new ModelAndView("/agency/register_page","resultMap",resultMap);
//			}
		}
	}

	/**
	 * @description:退出当前登陆用户
	 * @param httpSession
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月6日 下午12:16:57
	 */
	@RequestMapping(value = AgencyURL.LOGOUT)
	public ModelAndView switchAccount(HttpServletRequest request) {
		AgencyBackwardVO agencyBackwardVO = (AgencyBackwardVO) request.getSession()
				.getAttribute("loginContext");
		if (agencyBackwardVO != null) {
			int res = accountEventAO.updateLastByAgency(agencyBackwardVO.getId(), EventTypeEnum.AGENCY_LOGIN.getValue(), LoginStateEnum.ED.getValue()+"");
			if(res > 0){
				request.getSession().removeAttribute("loginContext");
			}
		}
		return new ModelAndView("/agency/login_page");
	}

	/**
	 * @description:查询子代理商列表
	 * @param pageNo
	 * @param searchAgencyVO
	 * @param request
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月3日 下午12:24:00
	 */
	@RequestMapping(value = AgencyURL.CHILD_AGENCY_LIST)
	public ModelAndView getAgencyList(
			@RequestParam(value = "pageNo", required = false) Integer pageNo,
			AgencyBackwardVO searchAgencyVO, HttpServletRequest request) {
		
		AgencyBackwardVO agencyBackwardVo = (AgencyBackwardVO) request.getSession()
				.getAttribute("loginContext");

		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		PageParam pageParam = null;
		if (pageNo != null) {
			pageParam = new PageParam(pageNo, 10);
		} else {
			pageParam = new PageParam(1, 10);
		}
		
		// agencyAO.ListAgencyByRoot(agencyBackwardPo.getId());
		if(agencyBackwardVo == null){
			return new ModelAndView("error", "errorMsg", "系统维护之后，用户未登陆！！");
		}
			Pagination<AgencyBackwardVO> pagination = agencyAO.ListAgencyByRoot(
					agencyBackwardVo.getId(), searchAgencyVO, pageParam);
			resultMap.put("pagination", pagination);
			resultMap.put("params", searchAgencyVO);
			resultMap.put("billTypeEnums", BillTypeEnum.toList());
			return new ModelAndView("/agency/child_agency_list", "resultMap", resultMap);
	}

	/**
	 * @description:异步验证用户名是否存在
	 * @param userName
	 * @param request
	 * @param response
	 * @throws IOException
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月25日 下午12:10:38
	 */
	@RequestMapping(value= AgencyURL.REGISTER_CHECK_NAME)
	public void checkName(String userName,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
//		AgencyBackwardPo po = new AgencyBackwardPo();
//		po.setUserName(new String(userName.getBytes("iso-8859-1"), "utf-8"));
//		po.setUserName(userName);
//		Map<String, Object> map = agencyAO.login(po);
//		String msg = map.get("msg").toString();
//		if (! "该用户名不存在！".equals(msg)) {
//			response.getWriter().print(false);
//		}else{
//			response.getWriter().print(true);
//		}
		boolean isExist = agencyAO.checkName(userName);
		try {
			response.getWriter().print(isExist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@ResponseBody
	@RequestMapping(value= AgencyURL.REGISTER_CHECK_CODE)
	public Boolean checkCode(String verifyCode,
			HttpServletRequest request, HttpServletResponse response)
					throws IOException {
		boolean isExist = agencyAO.checkVerifiCode(verifyCode);
		return isExist;
	}
	
	/**
	 * @description:调到号码归属地查询页面
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月17日 下午5:42:23
	 */
	@RequestMapping(value= AgencyURL.GET_TEL_LOCATION)
	public ModelAndView newFile(){
		return new ModelAndView("/NewFile");
	}
	
	/**
	 * @description:子代理商信息编辑页面
	 * @param request
	 * @param po
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月22日 上午10:14:54
	 */
	@RequestMapping(value= AgencyURL.CHILD_AGENCY_EDIT_PAGE)
	public ModelAndView editAgencyPage(HttpServletRequest request,Integer id){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		AgencyBackwardPo agencyPo = agencyAO.prepareParam(id);
		resultMap.put("agencyPo", agencyPo);
		return  new ModelAndView("/agency/child_agency_edit", "resultMap", resultMap);
	}
	/**
	 * @description:修改代理商信息（子代理商）
	 * @param po
	 * @param request
	 * @param response
	 * @throws IOException
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月22日 下午3:40:36
	 */
	@RequestMapping(value = AgencyURL.AGENCY_EDIT)
	@ResponseBody
	public void editAgency(AgencyBackwardVO vo,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		
//		ChargeAccountPo chargeAccountPo = (ChargeAccountPo) request.getSession().getAttribute("chargeAccount");//对私
//		ChargeAccountPo chargeAccountPo1 = (ChargeAccountPo) request.getSession().getAttribute("chargeAccount1");//对公
		int result = agencyAO.updateAgency(vo);
		if(result > 0){
			AgencyBackwardVO agencyVO = agencyAO.getVOByPo(agencyAO.getAgencyById(vo.getId()));
			request.getSession().setAttribute("loginContext", agencyVO);
			response.getWriter().print("success");
		}else{
			response.getWriter().print("error");
		}
	}
	@RequestMapping(value = AgencyURL.CHILD_AGENCY_EDIT)
	@ResponseBody
	public void editChildAgency(AgencyBackwardVO vo,
			HttpServletRequest request, HttpServletResponse response)
					throws IOException {
//		ChargeAccountPo chargeAccountPo = (ChargeAccountPo) request.getSession().getAttribute("chargeAccount");//对私
//		ChargeAccountPo chargeAccountPo1 = (ChargeAccountPo) request.getSession().getAttribute("chargeAccount1");//对公
		int result = agencyAO.updateAgency(vo);
		if(result > 0){
			response.getWriter().print("success");
		}else{
			response.getWriter().print("error");
		}
	}
}
