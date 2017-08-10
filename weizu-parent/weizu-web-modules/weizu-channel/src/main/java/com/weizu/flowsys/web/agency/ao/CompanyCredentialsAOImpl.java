package com.weizu.flowsys.web.agency.ao;

import java.io.File;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.weizu.web.foundation.core.beans.WherePrams;

import com.weizu.flowsys.operatorPg.enums.ConfirmStateEnum;
import com.weizu.flowsys.web.agency.dao.CompanyCredentialsDao;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;
import com.weizu.flowsys.web.agency.pojo.CompanyCredentialsPo;

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
		if(res > 0){
			return "success";
		}
		return null;
	}

}
