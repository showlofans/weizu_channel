package com.weizu.flowsys.web.agency.ao;

import org.springframework.web.multipart.MultipartFile;

import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;
import com.weizu.flowsys.web.agency.pojo.CompanyCredentialsPo;

/**
 * @description: 认证实体业务层接口
 * @projectName:weizu-channel
 * @className:CompanyCredentialsAO.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年7月21日 下午3:05:02
 * @version 1.0
 */
public interface CompanyCredentialsAO {
	/**
	 * @description: 新增一个账户认证
	 * @param ccpo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月21日 下午3:09:09
	 */
	String addCompanyCredential(CompanyCredentialsPo ccpo);
	
	/**
	 * @description: 上传认证图片
	 * @param file
	 * @param agencyVo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月21日 下午4:29:35
	 */
	String uploadImgFile(MultipartFile file, AgencyBackwardVO agencyVo, String filePath);
}
