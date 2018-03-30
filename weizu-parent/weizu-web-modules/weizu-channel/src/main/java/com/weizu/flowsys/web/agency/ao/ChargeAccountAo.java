package com.weizu.flowsys.web.agency.ao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.weizu.flowsys.web.agency.pojo.AccountBalanceSumPo;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.agency.pojo.CompanyCredentialsPo;

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
	
	/**
	 * @description: 获得所有下级没审核的账户
	 * @param rootAgencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月22日 下午4:56:05
	 */
	List<CompanyCredentialsPo> getUnconfirmedAccount(int rootAgencyId);
	
	/**
	 * @description: 根据代理商id和当前登陆代理商查询子代理商审核信息
	 * @param agencytId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月8日 下午1:52:08
	 */
	CompanyCredentialsPo getCredentialByAgency(int agencyId, int confirmAgencyId);
	
	/**
	 * @description: 根据代理商id查询审核信息
	 * @param agencyId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年2月26日 下午4:54:01
	 */
	CompanyCredentialsPo getCredentialByAgency(int agencyId);
	/**
	 * @description: 获得所有下级待审核的账户
	 * @param rootAgencyId
	 * @param confirmState
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月24日 下午3:49:54
	 */
	List<CompanyCredentialsPo> getUnconfirmedAccount(int rootAgencyId, int confirmState);
	
	/**
	 * @description: 下级待审核的账户个数
	 * @param rootAgencyId
	 * @param confirmState
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月6日 上午11:11:32
	 */
	Integer countUnconfirmedAccount(int rootAgencyId, int confirmState);
	
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
	int updateAccount(Integer id, Double editBalance);
	
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
	ChargeAccountPo getAccountByAgencyId(Integer agencyId, Integer billType);
	
	/**
	 * @description: 获得父级代理商相关账户
	 * @param accountId
	 * @param billType
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月26日 上午11:38:37
	 */
	ChargeAccountPo getRootAccountById(int accountId, int billType);
	
	/**
	 * @description: 通过账户id获得账户信息
	 * @param accountId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月27日 上午10:29:00
	 */
	ChargeAccountPo getAccountById(int accountId);
	
	
	/**
	 * @description: 统计真实平台余额
	 * @param agencyId
	 * @param isRootAgency
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年3月7日 下午2:54:42
	 */
	List<AccountBalanceSumPo> getBalanceSumByAgencyId(Integer agencyId, boolean isRootAgency);
	
	
	
	
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
