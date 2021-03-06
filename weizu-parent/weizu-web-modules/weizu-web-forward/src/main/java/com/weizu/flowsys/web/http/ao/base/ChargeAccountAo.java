package com.weizu.flowsys.web.http.ao.base;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.weizu.flowsys.web.http.pojo.ChargeAccountPo;

/**
 * @description:账户管理业务
 * @projectName:crud
 * @className:ChargeAccountAo.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月6日 上午10:43:48
 * @version 1.0
 */
public interface ChargeAccountAo {
	
	/**
	 * @description:创建一个账户
	 * @param chargeAccountPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月6日 上午10:43:09
	 */
	int createAccount(ChargeAccountPo chargeAccountPo);
	
//	/**
//	 * @description: 获得所有下级没审核的账户
//	 * @param rootAgencyId
//	 * @return
//	 * @author:POP产品研发部 宁强
//	 * @createTime:2017年7月22日 下午4:56:05
//	 */
//	List<CompanyCredentialsPo> getUnconfirmedAccount(int rootAgencyId);
//	
//	/**
//	 * @description: 获得所有下级没审核的账户
//	 * @param rootAgencyId
//	 * @param confirmState
//	 * @return
//	 * @author:POP产品研发部 宁强
//	 * @createTime:2017年7月24日 下午3:49:54
//	 */
//	List<CompanyCredentialsPo> getUnconfirmedAccount(int rootAgencyId, int confirmState);
//	
	
	/**
	 * @description: 创建一个对公账户
	 * @param chargeAccountPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月30日 下午4:06:11
	 */
	Integer createCompanyAccount(String realPath, ChargeAccountPo chargeAccountPo,MultipartFile file);
	
	/**
	 * @description:更新账户
	 * @param chargeAccountPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月6日 上午10:43:21
	 */
	int updateAccount(ChargeAccountPo chargeAccountPo);
	
	/**
	 * @description:通过代理商id获得账户信息（包涵Id的简易账户信息）
	 * @param agencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月6日 上午11:09:48
	 */
//	ChargeAccountPo getAccountByAgencyId(int agencyId);
	
	/**
	 * @description: 通过代理商id和票务信息获得账户信息
	 * @param agencyId
	 * @param billType
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月1日 下午5:54:08
	 */
	ChargeAccountPo getAccountByAgencyId(int agencyId, int billType);
	
//	ChargeAccountPo getAccountByAgencyId(int agencyId);
	
	/**
	 * @description:删除账户
	 * @param chargeAccountPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月6日 上午10:43:40
	 */
//	int deleteAccount(ChargeAccountPo chargeAccountPo);

}
