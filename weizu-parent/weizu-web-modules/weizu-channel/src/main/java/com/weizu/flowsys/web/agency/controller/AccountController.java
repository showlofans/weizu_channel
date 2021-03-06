package com.weizu.flowsys.web.agency.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.operatorPg.enums.AccountTypeEnum;
import com.weizu.flowsys.operatorPg.enums.AgencyLevelEnum;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ConfirmStateEnum;
import com.weizu.flowsys.operatorPg.enums.PgServiceTypeEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.agency.ao.AgencyAO;
import com.weizu.flowsys.web.agency.ao.ChargeAccountAo;
import com.weizu.flowsys.web.agency.ao.ChargeRecordAO;
import com.weizu.flowsys.web.agency.ao.CompanyCredentialsAO;
import com.weizu.flowsys.web.agency.dao.CompanyCredentialsDao;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.agency.pojo.ChargeRecordPo;
import com.weizu.flowsys.web.agency.pojo.CompanyCredentialsPo;
import com.weizu.flowsys.web.agency.pojo.ConsumeRecordPo;
import com.weizu.flowsys.web.agency.pojo.GroupAgencyRecordVo;
import com.weizu.flowsys.web.agency.url.AccountURL;
import com.weizu.flowsys.web.trade.pojo.PurchaseVO;
import com.weizu.flowsys.web.trade.url.ChargePgURL;
import com.weizu.web.foundation.DateUtil;
import com.weizu.web.foundation.String.StringHelper;

/**
 * @description:代理商账户管理
 * @projectName:crud
 * @className:AccountController.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月2日 上午10:00:14
 * @version 1.0
 */
@Controller
@RequestMapping(value=AccountURL.MODEL_NAME)
public class AccountController {
	@Resource
	private ChargeRecordAO chargeRecordAO;
	@Resource
	private ChargeAccountAo chargeAccountAO;
	@Resource
	private AgencyAO agencyAO;
	@Resource
	private CompanyCredentialsAO companyCredentialsAO;
	@Resource
	private CompanyCredentialsDao companyCredentialsDao;
	
//	//属性值，单文件的情况，对应的是upload3.js中的name属性，name属性值为file，此时struts就可以获取到file的文件对象，不需要实例化，struts框架会自动注入对象值，打开调试窗口，看一下就明白了
//	private File file;
//	//单文件上传的文件名，spring上传特性，文件名格式为name属性+FileName
//	private String fileFileName;
	
	/**
	 * @description:跳转到账户充值界面
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月8日 上午9:20:06
	 */
	@RequestMapping(value = AccountURL.ADD_CHARGE_PAGE)
	public ModelAndView addCharge(HttpServletRequest request,
			int accountId) {

		// String agencyId = request.getParameter("agencyId").trim().toString();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		ChargeAccountPo accountPo = chargeAccountAO.getAccountById(accountId);//待充值的账户
		AgencyBackwardVO agencyVo = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(agencyVo != null && agencyVo.getRootAgencyId() != 0 && accountPo.getBillType() !=null){//不是超管，需要判断自己对应账户余额
			ChargeAccountPo loginAccountPo = chargeAccountAO.getAccountByAgencyId(agencyVo.getId(), accountPo.getBillType());
			if(loginAccountPo != null){
				resultMap.put("accountBalance", loginAccountPo.getAccountBalance()); // 代理商名字
			}
		}
		resultMap.put("accountPo", accountPo); // 代理商名字
//		resultMap.put("agencyId", agencyId); // 代理商ID
//		resultMap.put("accountId", accountId); // 代理商账户ID
		resultMap.put("billTypeEnum", BillTypeEnum.toList());
//		resultMap.put("billType", billType);//默认对私
//		if(billType == BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()){
//			resultMap.put("chargeAccount",chargeAccountAO.getAccountByAgencyId(agencyId,billType));//通过代理商Id获得充值账户基本信息
//		}else{
//			resultMap.put("chargeAccount1",chargeAccountAO.getAccountByAgencyId(agencyId,billType));//通过代理商Id获得充值账户基本信息
//		}
		return new ModelAndView("account/add_charge", "resultMap", resultMap);
	}

	/**
	 * @description: 账户充值记录
	 * @param pageNo
	 * @param request
	 * @param chargeRecordPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月2日 上午10:12:46
	 */
	@RequestMapping(value= AccountURL.CHARGE_LIST)
	public ModelAndView getChargeList(@RequestParam(value = "pageNo", required = false) String pageNo,
			HttpServletRequest request,ChargeRecordPo chargeRecordPo){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		PageParam pageParam = null;
		if(StringHelper.isNotEmpty(pageNo)){
			pageParam = new PageParam(Integer.parseInt(pageNo), 10);
		}else{
//			chargeRecordPo.setStartTimeStr(DateUtil.formatAll(DateUtil.getStartTime()));
//			chargeRecordPo.setEndTimeStr(DateUtil.formatAll(DateUtil.getEndTime()));
			pageParam = new PageParam(1, 10);
		}
		AgencyBackwardVO agencyVo = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(agencyVo != null){
			chargeRecordPo.setAccountType(AccountTypeEnum.INCREASE.getValue());
//			chargeRecordPo.setAgencyId(agencyVo.getId());
			Integer contextAgencyId = null;
			if(agencyVo.getRootAgencyId() != 0){//超管
				contextAgencyId = agencyVo.getId();
			}
			Pagination<ChargeRecordPo> pagination =  chargeRecordAO.listChargeRecord(resultMap, contextAgencyId, chargeRecordPo, pageParam);
			resultMap.put("pagination", pagination);
			resultMap.put("billTypeEnum", BillTypeEnum.toList());
			resultMap.put("accountTypeEnum", AccountTypeEnum.toList());
			//点击金额进入连接，自动填充代理商名称
			if(chargeRecordPo.getUserName() == null && chargeRecordPo.getAccountId() != null){
				AgencyBackwardPo agencyPO = agencyAO.getAgencyByAccountId(chargeRecordPo.getAccountId());
				if(agencyPO != null){
					chargeRecordPo.setUserName(agencyPO.getUserName());
//					chargeRecordPo.setUserRealName(agencyPO.getUserRealName());
				}
			}
			return new ModelAndView("/account/charge_list", "resultMap", resultMap);
		}else{
			return new ModelAndView("error", "errorMsg", "系统维护之后，用户未登陆！！");
		}
	}
	/**
	 * @description: 消费记录
	 * @param pageNo
	 * @param request
	 * @param chargeRecordPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月27日 下午5:09:11
	 */
	@RequestMapping(value= AccountURL.CONSUME_LIST)
	public ModelAndView getConsumeList(@RequestParam(value = "pageNo", required = false) String pageNo,
			@RequestParam(value = "groupWay", required = false) String groupWay,
			HttpServletRequest request,ConsumeRecordPo consumeRecordPo){
		PageParam pageParam = null;
		if(StringHelper.isNotEmpty(pageNo)){
			pageParam = new PageParam(Integer.parseInt(pageNo), 10);
		}else{
			pageParam = new PageParam(1, 10);
		}
		AgencyBackwardVO agencyVo = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if(agencyVo != null){
			Integer contextId = agencyVo.getId();
//			String contextAgencyName = agencyVo.getUserName();
//			consumeRecordPo.setAgencyId(contextId);
			if(consumeRecordPo.getChargeFor() == null){
				consumeRecordPo.setChargeFor(PgServiceTypeEnum.PGCHARGE.getValue());
			}
			if(consumeRecordPo.getShowModel() == null){
				if(agencyVo.getRootAgencyId() == 0){
					consumeRecordPo.setShowModel(AgencyLevelEnum.SUPPER_USER.getValue());
				}else{
					consumeRecordPo.setShowModel(AgencyLevelEnum.PLAT_USER.getValue());
				}
			}
			
			Pagination<ConsumeRecordPo> pagination =  chargeRecordAO.listConsumeRecord(resultMap,contextId,consumeRecordPo, pageParam);
			
			if(("yes".equals(groupWay) || StringHelper.isEmpty(pageNo)) && agencyVo.getRootAgencyId() == 0){
				List<GroupAgencyRecordVo> groupAgencyList =chargeRecordAO.groupAgencyRecord(contextId, consumeRecordPo);
//				if(groupAgencyList.size() > 0){
//					
//					for (GroupAgencyRecordVo groupAgencyRecordVo : groupAgencyList) {
//						
//					}
//				}
				resultMap.put("groupAgencyList", groupAgencyList);
			}
			resultMap.put("pagination", pagination);
			resultMap.put("billTypeEnums", BillTypeEnum.toList());
			resultMap.put("accountTypeEnums", AccountTypeEnum.toConsumeList());
			resultMap.put("pgServiceTypeEnums", PgServiceTypeEnum.toList());	//充值业务类型
			resultMap.put("agencyLevelEnums", AgencyLevelEnum.toList());	//充值业务类型
			//点击金额进入连接，自动填充代理商名称
			if(consumeRecordPo.getUserName() == null && consumeRecordPo.getAccountId() != null){
				AgencyBackwardPo agencyPO = agencyAO.getAgencyByAccountId(consumeRecordPo.getAccountId());
				if(agencyPO != null){
					consumeRecordPo.setUserName(agencyPO.getUserName());
				}
			}
			resultMap.put("searchParams", consumeRecordPo);	//充值业务类型
			return new ModelAndView("/account/consume_list", "resultMap", resultMap);
		}else{
			return new ModelAndView("error", "errorMsg", "系统维护之后，用户未登陆！！");
		}
	}
	
	/**
	 * @description: 导出账户消费记录
	 * @param purchaseVO
	 * @param response
	 * @param request
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年3月2日 下午4:09:27
	 */
	@RequestMapping(value=AccountURL.EXPORT_CONSUME_LIST, method=RequestMethod.GET)
	public void exportConsumeList(ConsumeRecordPo consumeRecordPo,HttpServletResponse response,HttpServletRequest request){
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(agencyVO != null){
			Integer contextId = agencyVO.getId();
//			String contextAgencyName = agencyVo.getUserName();
//			consumeRecordPo.setAgencyId(contextId);
			if(consumeRecordPo.getChargeFor() == null){
				consumeRecordPo.setChargeFor(PgServiceTypeEnum.PGCHARGE.getValue());
			}
			String exportAgencyName = "";
			if(consumeRecordPo.getShowModel() == null){
				if(agencyVO.getRootAgencyId() == 0){
					consumeRecordPo.setShowModel(AgencyLevelEnum.SUPPER_USER.getValue());
				}else{
					consumeRecordPo.setShowModel(AgencyLevelEnum.PLAT_USER.getValue());
					exportAgencyName = agencyVO.getUserName();//一般模式用当前登陆
				}
			}
			if(StringHelper.isNotEmpty(consumeRecordPo.getUserName())){
				exportAgencyName = consumeRecordPo.getUserName();
			}
//			purchaseVO.setChargeFor(PgServiceTypeEnum.PGCHARGE.getValue());
			HSSFWorkbook hbook = chargeRecordAO.exportConsumeRecord(contextId, consumeRecordPo); 
			if (hbook != null)
			{
				try
				{
					request.setCharacterEncoding("UTF-8");
					response.reset();
					response.setCharacterEncoding("UTF-8");
					response.setContentType("application/msexcel;charset=UTF-8");
					response.addHeader("Content-Disposition", "attachment;filename=\"" + new String((exportAgencyName+PgServiceTypeEnum.getEnum(consumeRecordPo.getChargeFor()).getDesc()+"订单消费记录" + DateUtil.formatPramm(new Date(), "yyyy-MM-dd") + ".xls").getBytes("GBK"), "ISO8859_1")
					+ "\"");
					OutputStream outputStream = response.getOutputStream();
					hbook.write(outputStream);
					outputStream.flush();
					outputStream.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}else{
			try {
				response.getOutputStream().print("alert('导出失败，未登录')");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * @description: 账户充值
	 * @param chargeRecordPo
	 * @param request
	 * @param response
	 * @throws IOException
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月2日 上午10:14:30
	 */
	@RequestMapping(value = AccountURL.ADD_CHARGE)
	public void goCharge(Integer accountId, Double rechargeAmount,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
//		ChargeAccountPo accountPo = null;
//		if(chargeRecordPo.getBillType() == BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()){
//			accountPo = (ChargeAccountPo)request.getSession().getAttribute("chargeAccount");
//		}else{
//			accountPo = (ChargeAccountPo)request.getSession().getAttribute("chargeAccount1");
//		}
		//利用消费记录代理商ID设置为当前登陆账户id
		int result = 0;
		AgencyBackwardVO agencyVo = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");//修改当前代理商账户
		if(agencyVo != null)
		{
			ChargeAccountPo chargeAccountPo = chargeAccountAO.getAccountById(accountId);
			if(chargeAccountPo != null){
				ChargeAccountPo loginAccountPo = chargeAccountAO.getAccountByAgencyId(agencyVo.getId(), chargeAccountPo.getBillType());
				result = chargeRecordAO.chargeAccount(chargeAccountPo,rechargeAmount, loginAccountPo);
			}
		}
		
		if(result > 0){
//			ChargeAccountPo agencyAccountPo = null;
//			if(chargeRecordPo.getBillType() == BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()){
//				agencyAccountPo = (ChargeAccountPo)request.getSession().getAttribute("chargeAccount");
//			}else{
//				agencyAccountPo = (ChargeAccountPo)request.getSession().getAttribute("chargeAccount1");
//			}
//			agencyAccountPo.addBalance(chargeRecordPo.getRechargeAmount(),-1);//session中的引用变量
			response.getWriter().print("success");
		}else{
			response.getWriter().print("error");
		}
		
		//再从子代理商账户扣
		/*if(agencyVo != null){
			try {
				ChargeRecordPo chargeRecordPo2 = chargeRecordPo.clone();
				chargeRecordPo2.setAgencyId(agencyVo.getId());
				chargeRecordPo2.setAccountType(1);//给上家扣款
				//int updateResult = chargeRecordAO.updateContextAccount(chargeRecordPo2);//现从当前账户扣
				ChargeAccountPo chargeAccount = chargeAccountAO.getAccountByAgencyId(agencyVo.getId());
				
				if(updateResult + addResult >= 2){
					request.getSession().setAttribute("chargeAccount", chargeAccount);//更新当前显示账户信息
					
				}else{
					
				}
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			
		}else{
			response.getWriter().print("error");
		}*/
	}
	
	/**
	 * @description: 对公账户开通页面
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月30日 下午3:34:19
	 */
	@RequestMapping(value=AccountURL.OPEN_COMPANY_ACCOUNT_PAGE)
	public ModelAndView openCompanyAccountPage(HttpServletRequest request){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		AgencyBackwardVO agencyVo = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(agencyVo != null)
		{
			CompanyCredentialsPo ccpo = companyCredentialsDao.checkCraatedByAgencyId(agencyVo.getId());
			resultMap.put("ccpo", ccpo);
			resultMap.put("confirmStateEnums", ConfirmStateEnum.toList());
			return new ModelAndView("/account/open_company_account_page","resultMap",resultMap);
		}
		return new ModelAndView("/account/open_company_account_page");
	}
	/**
	 * @description:审核对公账户页面
	 * @param request
	 * @param agencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月22日 下午5:13:20
	 */
	@RequestMapping(value=AccountURL.CONFIRM_COMPANY_ACCOUNT_PAGE)
	public ModelAndView confirmCompanyAccountPage(HttpServletRequest request){
		AgencyBackwardVO agencyVo = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if(agencyVo != null)
		{
			List<CompanyCredentialsPo> list = chargeAccountAO.getUnconfirmedAccount(agencyVo.getId());
//			CompanyCredentialsPo ccpo = companyCredentialsDao.checkCraatedByAgencyId(agencyVo.getId());
			resultMap.put("unconfirmList", list);
			resultMap.put("confirmStateEnums", ConfirmStateEnum.toList());
			//处理消息
			if(list != null){
				int unconfirmSize = list.size();
				if(unconfirmSize > 0){
					//request.getSession().setAttribute("unconfirmSize", 0);
					Object obj2 = request.getSession().getAttribute("msgNum");
					if(obj2 != null){
						int msgNum = (int)obj2;
						if(msgNum > 0){
							request.getSession().setAttribute("msgNum", msgNum-unconfirmSize);//设置总消息数
						}
						//request.getSession().setAttribute("unconfirm", null);//设置消息为不显示
					}
				}
			}
			return new ModelAndView("/account/unconfirm_account_list","resultMap",resultMap);
		}
		return new ModelAndView("/account/unconfirm_account_list");
	}
	/**
	 * @description: 对公账户审核信息查看页面-根据代理商
	 * @param request
	 * @param agencyId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月8日 下午1:50:05
	 */
	@RequestMapping(value=AccountURL.CONFIRM_ACCOUNT_INFO)
	public ModelAndView confirmAccountInfo(HttpServletRequest request,Integer agencyId){
		AgencyBackwardVO agencyVo = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if(agencyVo != null)
		{
			CompanyCredentialsPo companyCredentialsPo = chargeAccountAO.getCredentialByAgency(agencyId);
//			CompanyCredentialsPo ccpo = companyCredentialsDao.checkCraatedByAgencyId(agencyVo.getId());
			if(companyCredentialsPo != null){
				companyCredentialsPo.setConfirmTimeStr(DateUtil.formatAll(companyCredentialsPo.getConfirmTime()));
			}
			//查询验证用户的apikey
			AgencyBackwardPo agencyPo = agencyAO.getAgencyById(agencyId);
			if(agencyPo != null){
				resultMap.put("userApiKey", agencyPo.getUserApiKey());
			}
			resultMap.put("companyCredentialsPo", companyCredentialsPo);
			ChargeAccountPo billAccountPo = chargeAccountAO.getAccountByAgencyId(agencyId, BillTypeEnum.CORPORATE_BUSINESS.getValue());//获得对公账户余额
			resultMap.put("billAccountPo", billAccountPo);
			resultMap.put("confirmStateEnums", ConfirmStateEnum.toList());
			//处理消息
			return new ModelAndView("/account/credential_show","resultMap",resultMap);
		}
		return new ModelAndView("/account/credential_show");
	}
	
	/**
	 * @description: 开通对公账户
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月30日 下午4:03:56
	 */
	@RequestMapping(value=AccountURL.OPEN_COMPANY_ACCOUNT)
	public ModelAndView openCompanyAccount(CompanyCredentialsPo ccpo, HttpServletRequest request){
		AgencyBackwardVO agencyVo = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(agencyVo != null)
		{
			ccpo.initBase(agencyVo.getId(),agencyVo.getUserName(), agencyVo.getRootAgencyId(), ccpo.getConfirmState());
			String res = companyCredentialsAO.addCompanyCredential(ccpo);
//			chargeAccountPo.setAgencyId(agencyVo.getId());
//			String realPath=request.getSession().getServletContext().getRealPath("/");
			
//			String realPath = "";
//			try {
//				realPath = FileUpload.uploadFile(file, request);
//				System.out.println(realPath);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			chargeAccountPo.setCertificationImg(realPath);
//			int createRes = chargeAccountAO.createCompanyAccount(realPath, chargeAccountPo,file);
//			if(createRes > 0){
//				ChargeAccountPo chargeAccount =  (ChargeAccountPo)request.getSession().getAttribute("chargeAccount");
//				chargeAccount.setBillType(BillTypeEnum.CORPORATE_BUSINESS.getValue());
//				request.getSession().setAttribute("chargeAccount", chargeAccount);
//			}
			return openCompanyAccountPage(request);
		}
		return new ModelAndView("/account/open_company_account_page");
	}
	
	/**
	 * @description: 上传图片
	 * @param file
	 * @param request
	 * @param model
	 * @param response
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月21日 下午4:22:35
	 */
	@RequestMapping(value=AccountURL.UPLOAD_IMG_FILE)
	//单文件上传后台代码
	public void uploadPicture(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model, HttpServletResponse response) {
		AgencyBackwardVO agencyVo = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
//		String fileName = file.getOriginalFilename(); 
		String filePath = request.getSession().getServletContext().getRealPath("/upload/credentials");
		if(agencyVo != null){
			String json = companyCredentialsAO.uploadImgFile(file, agencyVo, filePath);
	        try {
				response.getWriter().print(json);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
//	        model.addAttribute("fileUrl", request.getContextPath()+"/upload/credentials/"+agencyVo.getUserName()+"/"+fileName);
		}
		
		//		String fileName = file.getOriginalFilename();   
//		String path =  "d:\\test\\"+fileName;
//	        try {
//	        	File targetFile = new File(path, fileName);  
//	            if(!targetFile.exists()){  
//	                targetFile.mkdirs();  
//	            }  
//	      
//	            //保存  
//	            try {  
//	                file.transferTo(targetFile);  
//	            } catch (Exception e) {  
//	                e.printStackTrace();  
//	            }  
//	            model.addAttribute("fileUrl", request.getContextPath()+"/upload/"+fileName);  
	            //拿到文件对象
//	            File file = this.getFile();
	            //第一个参数是目标文件的完整路径
	            //第二参数是webupload分片传过来的文件
	            //FileUtil的这个方法是把目标文件的指针，移到文件末尾，然后把分片文件追加进去，实现文件合并。简单说。就是每次最新的分片合到一个文件里面去。
//	            FileUpload.randomAccessFile(path, file);
	            //如果文件小与5M的话，分片参数chunk的值是null
	            //5M的这个阈值是在upload3.js中的chunkSize属性决定的，超过chunkSize设置的大小才会进行分片，否则就不分片，不分片的话，webupload传到后台的chunk参数值就是null
//	            if(StringUtils.isEmpty(chunk)){
//	                //不分片的情况
//	                outJson("0", "success", "");
//	            }else{
//	            //分片的情况
//	            //chunk 分片索引，下标从0开始
//	            //chunks 总分片数
//	                if (Integer.valueOf(chunk) == (Integer.valueOf(chunks) - 1)) {
//	                    outJson("0", "上传成功", "");
//	                } else {
//	                    outJson("2", "上传中" + fileFileName + " chunk:" + chunk, "");
//	                }
//	            }
//	        } catch (Exception e) {
////	            outJson("3", "上传失败", "");
//	        }
	    }
	/**
	 * @description: 账户信息
	 * @param request
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月3日 上午11:33:37
	 */
	@RequestMapping(value=AccountURL.ACCOUNT_INFO)
	public ModelAndView accountInfo(HttpServletRequest request){
		//重新根据当前登陆id获取一遍账户信息
		AgencyBackwardVO agencyVo = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(agencyVo == null){
			return new ModelAndView("error", "errorMsg", "系统维护之后，用户未登陆！！");
		}
		ChargeAccountPo chargeAccount = chargeAccountAO.getAccountByAgencyId(agencyVo.getId(), BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
		ChargeAccountPo chargeAccount1 = chargeAccountAO.getAccountByAgencyId(agencyVo.getId(), BillTypeEnum.CORPORATE_BUSINESS.getValue());
//		AgencyBackwardPo rootAgency = agencyAO.getAgencyById(agencyVo.getRootAgencyId());
//		if(rootAgency != null){
//			String qq = rootAgency.getOtherContact();//富代理商的qq
//			request.getSession().setAttribute("qq",qq);
//		}
//		
		Map<String,Object> resultMap = new HashMap<String, Object>();
		boolean secondAgency = agencyAO.checkSecondAgency(agencyVo.getId());
		AgencyBackwardPo rootAgency = agencyAO.getRootAgencyById(agencyVo.getId());
		resultMap.put("rootAgency",rootAgency);
		resultMap.put("secondAgency",secondAgency);
		resultMap.put("chargeAccount",chargeAccount);
		resultMap.put("chargeAccount1",chargeAccount1);
//		request.getSession().setAttribute("secondAgency",secondAgency);
//		request.getSession().setAttribute("chargeAccount",chargeAccount);
//		request.getSession().setAttribute("chargeAccount1",chargeAccount1);
//		return new ModelAndView("/account/account_info");
		return new ModelAndView("/account/account_info","resultMap",resultMap);
	}
	/**
	 * @description: 账户信息更新
	 * @param request
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月3日 上午11:56:01
	 */
//	@RequestMapping(value=AccountURL.ACCOUNT_INFO_EDIT)
//	@ResponseBody
//	public void editAccountInfo(HttpServletRequest request,ChargeAccountPo chargeAccount,HttpServletResponse response){
//		AgencyBackwardVO agencyVo = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
////		Map<String,Object> resultMap = new HashMap<String, Object>();
//		if(agencyVo != null){
//			chargeAccount.setAgencyId(agencyVo.getId());
//			int res = chargeAccountAO.updateAccount(chargeAccount);
//			try {
//				if(res > 0 )
//				{
//					//更新session中相关账户信息
//					if(chargeAccount.getBillType() == BillTypeEnum.BUSINESS_INDIVIDUAL.getValue())
//					{
////					ChargeAccountPo chargeAccount0 =  (ChargeAccountPo)request.getSession().getAttribute("chargeAccount");
////					chargeAccount0.setBillType(BillTypeEnum.CORPORATE_BUSINESS.getValue());
//						request.getSession().setAttribute("chargeAccount", chargeAccount);
//					}else if(chargeAccount.getBillType() == BillTypeEnum.BUSINESS_INDIVIDUAL.getValue())
//					{
////					ChargeAccountPo chargeAccount1 =  (ChargeAccountPo)request.getSession().getAttribute("chargeAccount1");
////					chargeAccount1.setBillType(BillTypeEnum.CORPORATE_BUSINESS.getValue());
//						request.getSession().setAttribute("chargeAccount1", chargeAccount);
//					}
//					
//					response.getWriter().print("success");
//				}
//				else
//				{
//					response.getWriter().print("error");
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		
////		return new ModelAndView("/account/account_info","resultMap",resultMap);
//	}
	
	/**
	 * @description: 审核认证信息
	 * @param ccId
	 * @param confirmState
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月24日 下午3:08:52
	 */
	@RequestMapping(value=AccountURL.VERIFY_CREDENTIALS)
	public void verifyCredentials(CompanyCredentialsPo ccpo, HttpServletResponse response, HttpServletRequest request){
//		AgencyBackwardVO agencyVo = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
//		ccpo.setConfirmAgencyId(agencyVo.getId());
			ccpo.setConfirmTime(System.currentTimeMillis());
			String res = companyCredentialsAO.updateCompanyCredential(ccpo);
		try {
			response.getWriter().print(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	public File getFile() {
//		return file;
//	}
//
//	public void setFile(File file) {
//		this.file = file;
//	}
//
//	public String getFileFileName() {
//		return fileFileName;
//	}
//
//	public void setFileFileName(String fileFileName) {
//		this.fileFileName = fileFileName;
//	}
	
}
