package com.weizu.flowsys.web.agency.ao;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.weizu.flowsys.core.util.NumberTool;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.web.agency.dao.impl.ChargeAccountDao;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.agency.ao.ChargeAccountAo;

@Service("chargeAccountAO")
public class ChargeAccountAoImpl implements ChargeAccountAo {

	@Resource
	private ChargeAccountDao chargeAccountDao;
	
	@Transactional(isolation = Isolation.SERIALIZABLE)
	@Override
	public int createAccount(ChargeAccountPo chargeAccountPo) {
		chargeAccountPo.setBillType(BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
		return chargeAccountDao.add(chargeAccountPo);
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
	@Override
	public ChargeAccountPo getAccountByAgencyId(int agencyId) {
		ChargeAccountPo cpo1 = chargeAccountDao.selectByAgencyId(agencyId,BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
		ChargeAccountPo cpo2 = chargeAccountDao.selectByAgencyId(agencyId,BillTypeEnum.CORPORATE_BUSINESS.getValue());
		Double credit = 0.0d;
		Double balance = 0.0d;
		if(cpo1 != null)
		{
			credit = NumberTool.add(credit, cpo1.getAccountCredit());
			balance = NumberTool.add(balance, cpo1.getAccountBalance());
		}
		ChargeAccountPo accountPo = new ChargeAccountPo(agencyId, balance, credit);
		if(cpo2 != null)
		{
			credit = NumberTool.add(credit, cpo2.getAccountCredit());
			balance = NumberTool.add(balance, cpo2.getAccountBalance());
			accountPo.setBillType(BillTypeEnum.CORPORATE_BUSINESS.getValue());
			accountPo.setAccountBalance(balance);
			accountPo.setAccountCredit(credit);
		}
		return accountPo;
	}

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


}
