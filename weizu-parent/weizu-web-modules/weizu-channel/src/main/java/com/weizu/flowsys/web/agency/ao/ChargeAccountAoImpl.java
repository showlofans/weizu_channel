package com.weizu.flowsys.web.agency.ao;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.web.agency.dao.AgencyVODaoInterface;
import com.weizu.flowsys.web.agency.dao.ChargeAccountDaoInterface;
import com.weizu.flowsys.web.agency.dao.CompanyCredentialsDao;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.agency.pojo.CompanyCredentialsPo;
import com.weizu.web.foundation.DateUtil;

@Service("chargeAccountAO")
public class ChargeAccountAoImpl implements ChargeAccountAo {

	@Resource
	private ChargeAccountDaoInterface chargeAccountDao;
	
	@Resource
	private CompanyCredentialsDao companyCredentialsDao;
	@Resource
	private AgencyVODaoInterface agencyVODao;
	
	@Transactional(isolation = Isolation.SERIALIZABLE)
	@Override
	public int createAccount(ChargeAccountPo chargeAccountPo) {
		ChargeAccountPo accountPo = getAccountByAgencyId(chargeAccountPo.getAgencyId(), chargeAccountPo.getBillType());
		if(accountPo == null){
			return chargeAccountDao.add(chargeAccountPo);
		}else{
			return -1;
		}
	}
	
	/**
	 * @description: 获得所有下级没审核的账户
	 * @param rootAgencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月22日 下午4:57:14
	 */
	@Override
	public List<CompanyCredentialsPo> getUnconfirmedAccount(int rootAgencyId) {
		List<CompanyCredentialsPo> list = companyCredentialsDao.list(new WherePrams("confirm_agency_id", "=", rootAgencyId).orderBy("commit_time desc"));
		for (CompanyCredentialsPo companyCredentialsPo : list) {
			if(companyCredentialsPo.getCommitTime() != null){
				String commitTimeStr = DateUtil.formatAll(companyCredentialsPo.getCommitTime());
				companyCredentialsPo.setCommitTimeStr(commitTimeStr);
			}
			if(companyCredentialsPo.getConfirmTime() != null){
				String confirmTimeStr = DateUtil.formatAll(companyCredentialsPo.getConfirmTime());
				companyCredentialsPo.setConfirmTimeStr(confirmTimeStr);
			}
		}
		return list;
	}
	
	/**
	 * @description: 获得所有下级没审核的账户
	 * @param rootAgencyId
	 * @param confirmState
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月24日 下午3:51:36
	 */
	@Override
	public List<CompanyCredentialsPo> getUnconfirmedAccount(int rootAgencyId,
			int confirmState) {
		List<CompanyCredentialsPo> list = companyCredentialsDao.list(new WherePrams("confirm_agency_id", "=", rootAgencyId).and("confirm_state", "=", confirmState));
		return list;
	}

	@Transactional(isolation = Isolation.SERIALIZABLE)
	@Override
	public int updateAccount(ChargeAccountPo chargeAccountPo) {

		return chargeAccountDao.updateByAgencyId(chargeAccountPo);
	}

	/**
	 * @description:通过代理商id获得账户信息（包涵Id的简易账户信息）
	 * @param agencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月8日 上午9:43:55
	 */
//	@Override
//	public ChargeAccountPo getAccountByAgencyId(int agencyId) {
//		ChargeAccountPo cpo1 = chargeAccountDao.selectByAgencyId(agencyId,BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
//		ChargeAccountPo cpo2 = chargeAccountDao.selectByAgencyId(agencyId,BillTypeEnum.CORPORATE_BUSINESS.getValue());
//		Double credit = 0.0d;
//		Double balance = 0.0d;
//		if(cpo1 != null)
//		{
//			credit = NumberTool.add(credit, cpo1.getAccountCredit());
//			balance = NumberTool.add(balance, cpo1.getAccountBalance());
//		}
//		ChargeAccountPo accountPo = new ChargeAccountPo(agencyId, balance, credit);
//		if(cpo2 != null)
//		{
//			credit = NumberTool.add(credit, cpo2.getAccountCredit());
//			balance = NumberTool.add(balance, cpo2.getAccountBalance());
//			accountPo.setBillType(BillTypeEnum.CORPORATE_BUSINESS.getValue());
//			accountPo.setAccountBalance(balance);
//			accountPo.setAccountCredit(credit);
//		}
//		return accountPo;
//	}

	/**
	 * @description: 创建一个对公账户
	 * @param chargeAccountPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @throws IOException 
	 * @throws IllegalStateException 
	 * @createTime:2017年6月30日 下午4:06:40
	 */
	@Override
	public Integer createCompanyAccount(String realPath ,ChargeAccountPo chargeAccountPo,MultipartFile file) {
        // 判断用户是否登录
        /*User user=(User) session.getAttribute("user");
        if (user==null) {
            resultData.setCode(40029);
            resultData.setMsg("用户未登录");
            return resultData;
        }*/
//        try {
//			if (file!=null) {// 判断上传的文件是否为空
//			    String path=null;// 文件路径
//			    String type=null;// 文件类型
//			    String fileName=file.getOriginalFilename();// 文件原名称
//			    System.out.println("上传的文件原名称:"+fileName);
//			    // 判断文件类型
//			    type=fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
//			    if (type!=null) {// 判断文件类型是否为空
//			        if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
//			            // 项目在容器中实际发布运行的根路径
//			            // 自定义的文件名称
//			            String trueFileName=String.valueOf(System.currentTimeMillis())+fileName;
//			            // 设置存放图片文件的路径
//			            path=realPath+/*System.getProperty("file.separator")+*/trueFileName;
//			            System.out.println("存放图片文件的路径:"+path);
//			            // 转存文件到指定的路径
//			            file.transferTo(new File(path));
//			            System.out.println("文件成功上传到指定目录下");
//			        }else {
//			            System.out.println("不是我们想要的文件类型,请按要求重新上传");
//			            return null;
//			        }
//			    }else {
//			        System.out.println("文件类型为空");
//			        return null;
//			    }
//			}else {
//			    System.out.println("没有找到相对应的文件");
//			    return null;
//			}
//		} catch (IllegalStateException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
		chargeAccountPo.setBillType(BillTypeEnum.CORPORATE_BUSINESS.getValue());
		return chargeAccountDao.add(chargeAccountPo);
	}

	/**
	 * @description: 通过代理商id和票务信息获得账户信息
	 * @param agencyId 
	 * @param billType
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月1日 下午5:55:20
	 */
	@Override
	public ChargeAccountPo getAccountByAgencyId(Integer agencyId, Integer billType) {
		ChargeAccountPo accountPo = chargeAccountDao.get(new WherePrams("agency_id", "=", agencyId).and("bill_type", "=", billType));
		return accountPo;
	}

	@Override
	public ChargeAccountPo getRootAccountById(int accountId, int billType) {
		return chargeAccountDao.getRootAccountById(accountId, billType);
	}

	@Override
	public ChargeAccountPo getAccountById(int accountId) {
		
		return chargeAccountDao.get(accountId);
	}

}
