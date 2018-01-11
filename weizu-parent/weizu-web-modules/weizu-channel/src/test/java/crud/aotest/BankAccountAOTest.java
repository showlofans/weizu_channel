//package crud.aotest;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.annotation.Resource;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.aiyi.base.pojo.PageParam;
//import com.weizu.flowsys.core.beans.WherePrams;
//import com.weizu.flowsys.operatorPg.enums.CallBackEnum;
//import com.weizu.flowsys.operatorPg.enums.InOrOutEnum;
//import com.weizu.flowsys.util.Pagination;
//import com.weizu.flowsys.web.agency.ao.BankAccountAO;
//import com.weizu.flowsys.web.agency.ao.TransferRecAO;
//import com.weizu.flowsys.web.agency.dao.BankAccountDaoInterface;
//import com.weizu.flowsys.web.agency.pojo.BankAccountPo;
//import com.weizu.flowsys.web.agency.pojo.TransferRecordVO;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class BankAccountAOTest {
//	
//	@Resource
//	private BankAccountAO bankAccountAO;
//	
//	@Resource
//	private BankAccountDaoInterface bankAccountDao;
//	
//	@Resource
//	private TransferRecAO transferRecAO;
//	
//	@Test
//	public void getMyBankList(){
//		Map<String,Object> resultMap = new HashMap<String,Object>();
//		bankAccountAO.getMyBankList(1, resultMap);
//		List<BankAccountPo> bankList = (List<BankAccountPo>) resultMap.get("bankList");
//		for (BankAccountPo bankAccountPo : bankList) {
//			System.out.println(bankAccountPo.getLastAccessStr());
//		}
////		System.out.println(bankList.size());
//	}
////	@Test
////	public void updateBank(){
////		BankAccountPo bankPo = new BankAccountPo();
////		bankPo.setLastAccess(System.currentTimeMillis());
////		int res = bankAccountDao.updateLocal(bankPo, new WherePrams("1", "=", 1));
////		System.out.println(res);
////	}
////	@Test
////	public void getAttachBankList(){
//////		Map<String,Object> resultMap = new HashMap<String,Object>();
//////		bankAccountAO.getAttachBankList(61, 1, resultMap);
//////		List<BankAccountPo> unattachList = (List<BankAccountPo>) resultMap.get("unattachList");
//////		List<BankAccountPo> attachList = (List<BankAccountPo>) resultMap.get("attachList");
//////		System.out.println(unattachList.size());
//////		System.out.println(attachList.size());
////		Map<String,Object> paramsMap = new HashMap<String,Object>();
////		//与该账户绑定的父级代理商银行卡
////		paramsMap.put("accountId", 2);
//////		map.put("polarity", CallBackEnum.POSITIVE.getValue());
////		paramsMap.put("useState", CallBackEnum.POSITIVE.getValue());
////		List<BankAccountPo> bankList = bankAccountDao.getAttachBankList(paramsMap);
////		for (BankAccountPo bankAccountPo : bankList) {
////			System.out.println(bankAccountPo.getRemittanceWay());
////		}
////	}
////	@Test
////	public void getPlusBankList(){
////		Map<String,Object> resultMap = new HashMap<String,Object>();
////		bankAccountAO.getPlusBankList(1, 54, resultMap);
////		List<BankAccountPo> attachList = (List<BankAccountPo>) resultMap.get("plusBankList");
////		System.out.println(attachList.size());
////	}
////	@Test
////	public void getTransferRec(){
////		Map<String,Object> resultMap = new HashMap<String,Object>();
////		PageParam pageParam = new PageParam(1l, 10);
////		transferRecAO.getTransferRec(16l, InOrOutEnum.IN.getValue(), pageParam, resultMap);
////		Pagination<TransferRecordVO> pagination = (Pagination<TransferRecordVO>) resultMap.get("pagination");
////		if(pagination != null){
////			List<TransferRecordVO> list = pagination.getRecords();
////			System.out.println(pagination.getTotalRecordLong());;
////			System.out.println(list.size());
////			for (TransferRecordVO transferRecordVO : list) {
////				System.out.println(transferRecordVO.getTransferAmount());
////			}
////		}
////	}
////	@Test
////	public void getMyOneBankAccount(){
////		BankAccountPo bankPo = bankAccountDao.getMyOneBankAccount(1, "1234154694754152", 1);
////		System.out.println(bankPo.getAccountName());
////	}
//	
////	@Test
////	public void existBankPo(){
////		BankAccountPo bankPo = bankAccountDao.get(new WherePrams("agency_id", "=", 1).and("account_id", "=", 61).and("remittance_bank_account", "=", 123));
////		System.out.println(bankPo == null ? "Kong":bankPo.getRemittanceBankAccount());
////	}
//}
