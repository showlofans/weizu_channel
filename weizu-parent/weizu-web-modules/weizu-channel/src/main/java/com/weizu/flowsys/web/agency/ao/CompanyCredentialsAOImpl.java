package com.weizu.flowsys.web.agency.ao;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.operatorPg.enums.AgencyTagEnum;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ConfirmStateEnum;
import com.weizu.flowsys.util.UUIDGenerator;
import com.weizu.flowsys.web.agency.dao.AgencyVODaoInterface;
import com.weizu.flowsys.web.agency.dao.CompanyCredentialsDao;
import com.weizu.flowsys.web.agency.dao.impl.ChargeAccountDao;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.agency.pojo.CompanyCredentialsPo;
import com.weizu.web.foundation.String.StringHelper;

/**
 * @description: 认证实体业务层接口实现类
 * @projectName:weizu-channel
 * @className:CompanyCredentialsAOImpl.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年7月21日 下午3:09:58
 * @version 1.0
 */
@Service(value="companyCredentialsAO")
public class CompanyCredentialsAOImpl implements CompanyCredentialsAO {

	@Resource
	private CompanyCredentialsDao companyCredentialsDao;
	@Resource
	private ChargeAccountDao chargeAccountDao;
	@Resource
	private AgencyVODaoInterface agencyVODao;
	
	/**
	 * @description: 新增一个账户认证
	 * @param ccpo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月21日 下午3:10:23
	 */
	@Transactional
	@Override
	public String addCompanyCredential(CompanyCredentialsPo ccpo) {
		int agencyId = ccpo.getAgencyId();
		CompanyCredentialsPo ccpoC = companyCredentialsDao.checkCraatedByAgencyId(agencyId);
		int res = 0;
		if(ccpoC != null){//已经创建了账户认证
//			if(ccpo.getConfirmState() == ConfirmStateEnum.CONFIRM_PASS.getValue()){
//				agencyVODao.updateLocal(po)
//			}
			res = companyCredentialsDao.updateLocal(ccpo, new WherePrams("agency_id", "=", agencyId));//更新这个代理商的认证信息
		}else{
			ccpo.setCommitTime(System.currentTimeMillis());
			res = companyCredentialsDao.add(ccpo);
		}
		if(res > 0){
			return "success";
		}else{
			return "error";
		}
	}

	/**
	 * @description: 上传认证图片
	 * @param file
	 * @param agencyVo
	 * @param filePath
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月21日 下午5:00:00
	 */
	@Override
	@Transactional
	public String uploadImgFile(MultipartFile file, AgencyBackwardVO agencyVo, String filePath) {
		String fileName = file.getOriginalFilename();		//图片名字
		String json = null;
		System.out.println("开始");  
        String path = filePath +"\\"+agencyVo.getUserName()+"\\";  
        System.out.println(path);
//	        String fileName = new Date().getTime()+".jpg";  
        System.out.println(path);  
        String targetValue = fileName.substring(0,fileName.indexOf("."));
        String[] fileNameSamples = new String[]{"license","bank","idFront","idBack"};
       int tag = 0;			//看是否有匹配名字的图片
       
       for (int i = 0; i < fileNameSamples.length; i++) {
    	   if(fileNameSamples[i].equalsIgnoreCase(targetValue)){
    		   tag = i+1;
    		   break;
    	   }
       }
        if(tag > 0){
        	CompanyCredentialsPo comCredentialsPo = new CompanyCredentialsPo(agencyVo.getId(), agencyVo.getRootAgencyId(), ConfirmStateEnum.INCOMPLETE_CONFIRM.getValue());
        	File targetFile = new File(path, fileName);  
        	if(!targetFile.exists()){  
        		targetFile.mkdirs();  
        	}  
        	//保存  
        	try {  
        		file.transferTo(targetFile); 
        		String dataPath = "/upload/" +agencyVo.getUserName()+"/" +fileName;
        		switch (tag) {
				case 1:
					comCredentialsPo.setBusinessLicense(dataPath);  //设置为营业执照图片
					break;
				case 2:
					comCredentialsPo.setDepositBankPhoto(dataPath); //设置为开户行图片
					break;
				case 3:
					comCredentialsPo.setCorporateIdentityFront(dataPath); //设置为身份证正面图片
					break;
				case 4:
					comCredentialsPo.setCorporateIdentityBack(dataPath); //设置为身份证反面图片
					break;
				default:
					break;
				}
        		String res = addCompanyCredential(comCredentialsPo);
        		if("success".equals(res)){
        			json = "{\"0\":\"上传成功\"}";
        		}else{
        			json = "{\"3\":\"上传失败\"}";
        		}
        	} catch (Exception e) {  
        		json = "{\"3\":\"上传失败\"}";
        		e.printStackTrace();  
        	}
        }else{
        	json = "{\"3\":\"上传失败\"}";
        }
		return json;
	}

	/**
	 * @description:  更新账户信息
	 * @param ccpo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月24日 下午3:12:58
	 */
	@Transactional
	@Override
	public String updateCompanyCredential(CompanyCredentialsPo ccpo) {
		int res = companyCredentialsDao.updateLocal(ccpo, new WherePrams("id", "=", ccpo.getId()));//更新这个代理商的认证信息
		
		//如果确认就，给代理商增加代理商对公账户,同时把用户的等级换成认证用户
		if(ConfirmStateEnum.CONFIRM_PASS.getValue().equals(ccpo.getConfirmState()) ){
			ChargeAccountPo chargePo = new ChargeAccountPo();
			//认证通过后，设置代理商为认证用户
			int agencyId = ccpo.getAgencyId();
			AgencyBackwardPo agBackwardPo = agencyVODao.get(agencyId);
			Map<String, Object> params = new HashMap<String, Object>();
			if(agBackwardPo != null){
				if(StringHelper.isEmpty(agBackwardPo.getUserApiKey()))
				{
					UUIDGenerator generator = new UUIDGenerator();
					String userAPiKey = generator.generate().toString();
					params.put("userApiKey", userAPiKey);
				}
			}
			params.put("id", agencyId);
			params.put("agencyTag", AgencyTagEnum.DATA_USER.getValue());
			 int popTag = agencyVODao.updateAgencyTag(agencyId, params);
			 if(!AgencyTagEnum.DATA_USER.getValue().equals(agBackwardPo.getAgencyTag())){
				 chargePo.setAgencyId(agencyId);
				 chargePo.setBillType(BillTypeEnum.CORPORATE_BUSINESS.getValue());//增加一个对公账户
				 AgencyBackwardPo agencyPo = agencyVODao.get(agencyId);
				 String userName = agencyPo.getUserName();
				 chargePo.setAgencyName(userName);
				 chargePo.setCreateTime(ccpo.getConfirmTime());
				 chargePo.setRemittanceBankAccount(ccpo.getBankAccount());
				 int addCharge = chargeAccountDao.add(chargePo);
				 if(res + addCharge + popTag > 2){
					return "success";
				 }
			 }
			if(res + popTag > 1){
				return "success";
			}
		}
		if(res > 0){
			return "success";
		}
		return "error";
	}

}
