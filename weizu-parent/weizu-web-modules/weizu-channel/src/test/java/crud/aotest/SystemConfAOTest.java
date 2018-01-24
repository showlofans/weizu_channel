package crud.aotest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.operatorPg.enums.CallBackEnum;
import com.weizu.flowsys.operatorPg.enums.InOrOutEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.agency.ao.BankAccountAO;
import com.weizu.flowsys.web.agency.ao.TransferRecAO;
import com.weizu.flowsys.web.agency.dao.BankAccountDaoInterface;
import com.weizu.flowsys.web.agency.pojo.BankAccountPo;
import com.weizu.flowsys.web.agency.pojo.TransferRecordVO;
import com.weizu.flowsys.web.system_base.ao.SystemConfAO;
import com.weizu.flowsys.web.system_base.dao.SystemConfDaoInterface;
import com.weizu.flowsys.web.system_base.pojo.SystemConfPo;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class SystemConfAOTest {
	
	@Resource
	private SystemConfDaoInterface systemConfDao;
	@Resource
	private SystemConfAO systemConfAO;
	
//	@Test
//	public void getMyBankList(){
//		SystemConfPo systemConfPo = new SystemConfPo();
////		systemConfPo
//		List<SystemConfPo> list = systemConfAO.getConf(systemConfPo);
//		for (SystemConfPo systemConfPo2 : list) {
//			System.out.println(systemConfPo2.getConfValue());
//			System.out.println(systemConfPo2.getLastAccessStr());
//		}
//	}
//	@Test
//	public void addConf(){
//		SystemConfPo systemConfPo = new SystemConfPo("chargeTelTimes_in_oneDay", "3", "一天之内一个号码最多的充值提交次数", System.currentTimeMillis());
//		int i = systemConfDao.add(systemConfPo);
//		System.out.println("添加成功 "+i);
//	}
//	
	@Test
	public void getConfByKey(){
		SystemConfPo systemConfPo =  systemConfAO.getByKey("chargeTelTimes_in_oneDay");
		System.out.println(systemConfPo == null);
	}
	
//	@Test
//	public void existBankPo(){
//		BankAccountPo bankPo = bankAccountDao.get(new WherePrams("agency_id", "=", 1).and("account_id", "=", 61).and("remittance_bank_account", "=", 123));
//		System.out.println(bankPo == null ? "Kong":bankPo.getRemittanceBankAccount());
//	}
}
