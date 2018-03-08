//package crud.aotest;
//
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
//import com.alibaba.fastjson.JSON;
//import com.weizu.flowsys.api.weizu.charge.ChargeParams;
//import com.weizu.flowsys.core.beans.WherePrams;
//import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
//import com.weizu.flowsys.operatorPg.enums.ChannelTypeEnum;
//import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
//import com.weizu.flowsys.web.activity.ao.RateDiscountAO;
//import com.weizu.flowsys.web.activity.dao.RateDiscountDao;
//import com.weizu.flowsys.web.activity.pojo.RateDiscountPo;
//import com.weizu.flowsys.web.agency.ao.ChargeAccountAo;
//import com.weizu.flowsys.web.agency.dao.AgencyVODaoInterface;
//import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
//import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
//import com.weizu.flowsys.web.channel.pojo.ChargeChannelParamsPo;
//import com.weizu.flowsys.web.trade.PurchaseUtil;
//import com.weizu.flowsys.web.trade.pojo.RatePgPo;
//import com.weizu.web.foundation.hash.Hash;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class RateDiscountDaoTest {
//	@Resource
//	private RateDiscountDao rateDiscountDao;
//	
//	@Resource
//	private RateDiscountAO rateDiscountAO;
//	@Resource
//	private ChargeAccountAo chargeAccountAO;
//	
//	
//	@Resource
//	private AgencyVODaoInterface agencyVODao;
//	
////	@Resource
////	private AgencyActiveChannelAO agencyActiveChannelAO;
//	
////	@Test
////	public void testGetDiscountList(){
//////		RateDiscountPo ratePo = new RateDiscountPo(0, 0,,null, null, null, null);
////		List<RateDiscountPo> resList = rateDiscountDao.getListByCDiscountId(13l,1);
//////		RateDiscountPo ratePo = new RateDiscountPo();
//////		ratePo.setChannelId(12l);
//////		List<RateDiscountPo> resList = rateDiscountDao.getRateDiscountList(ratePo);
////		System.out.println(resList.size());
////	}
//	
////	@Test
////	public void testGetDisocuntRateList(){
////		RateDiscountPo ratePo = new RateDiscountPo(0, 0, null, null, null);
////		Map<String,Object> mapt = rateDiscountAO.getOperatorListRate(ratePo);
//////		Pagination<AgencyActiveChannelPo> pagination = agencyActiveChannelAO.listActiveRate(new PageParam(1, 10), ratePo);
//////		List<AgencyActiveChannelPo> records = pagination.getRecords();
////		
////		
//////		for(Map<String,Object> scope: ScopeCityEnum.toList()){
//////			Map<String,Object> map = mapt.get(scope.get("value"));
//////			if(map == null){
//////				
//////			}else{
//////				System.out.println(scope.get("value").toString());;//获得折扣
//////			}
//////		}
////	}
//	
////	@Test
////	public void testGetListByCDiscountId(){
////		List<RateDiscountPo> rateList = rateDiscountDao.getListByCDiscountId(13l,0);
////		System.out.println(rateList.size());
////	}
////	@Test
////	public void testCountRateDisocunt(){
////		RateDiscountPo ratePo = new RateDiscountPo();
//////		ratePo.setActiveDiscount(0.9);
////		ratePo.setBillType(0);
////		ratePo.setActiveId(46l);
////		ratePo.setChannelDiscountId(13l);
////		String t = rateDiscountAO.addRateDiscount(ratePo);//添加一定要有billType，通道折扣id和费率折扣
////		System.out.println(t);
////	}
//	
////	@Test
////	public void testGetShowRate(){
//////		Map<String,Object>  dtoMap = rateDiscountAO.getShowRate(4);
//////		RateDiscountShowDTO dto = (RateDiscountShowDTO) dtoMap.get("billDTO");
//////		RateDiscountShowDTO dto1 = (RateDiscountShowDTO) dtoMap.get("noDTO");
//////		if(dto != null){
//////			System.out.println(dto.getBillType());;
//////			System.out.println(dto.getDiscountPo().getDiscount0());;
//////			System.out.println(dto.getDiscountPo().getDiscount1());;
//////			System.out.println(dto.getDiscountPo().getDiscount2());;
//////		}
//////		if(dto1 != null){
//////			System.out.println(dto1.getBillType());;
//////			System.out.println(dto1.getDiscountPo().getDiscount0());;
//////			System.out.println(dto1.getDiscountPo().getDiscount1());;
//////			System.out.println(dto1.getDiscountPo().getDiscount2());;
//////		}
////		
////		List<RateDiscountShowDTO> dtoList = rateDiscountAO.getIndexShowRate(2);
////		if(dtoList != null && dtoList.size() > 0){
////			for (RateDiscountShowDTO rateDiscountShowDTO : dtoList) {
////				System.out.println("serviceType:"+rateDiscountShowDTO.getServiceType()+"\tbillType:"+rateDiscountShowDTO.getBillType());
////			}
////		}
////	}
////	@Test
////	public void updateRateDiscountByCDId(){
////		int res = rateDiscountDao.updateRateDiscountByCDId(19l, 0.1);
////		System.out.println(res);
////	}
////	@Test
////	public void getChannelByAgency(){
////		List<Long> channelList= rateDiscountDao.getChannelByAgency(2);
////		for (Long channelId : channelList) {
////			System.out.println("chanelId:"+channelId);
////		}
////	}
////	@Test
////	public void getPgListForPurchase(){
////		List<PgDataPo> pgList = rateDiscountAO.getPgListForPurchase(new ChargeChannelParamsPo("陕西移动", ServiceTypeEnum.PROVINCE.getValue(), PgTypeEnum.PGDATA.getValue(), PgValidityEnum.MONTH_DAY_DATA.getValue(), ChannelTypeEnum.ORDINARY.getValue()), 101, true);
////		String listJsonStr = JSON.toJSONString(pgList);
////		System.out.println(listJsonStr);
////	}
////	
////	@Test
////	public void getPriceByPg(){
////	   RateDiscountPo ratePo = rateDiscountDao.getPriceByPg(2, 41, 49l);
////	   System.out.println(ratePo.getActiveDiscount());
////	}
////	@Test
////	public void testAddMyRate(){
////		RateDiscountPo ratePo = new RateDiscountPo();
////		ratePo.setId(46L);
//////		ratePo.setActiveDiscount(0.99);
////		ratePo.setBillType(0);
////		String res = rateDiscountAO.updateRateDiscount(ratePo);
////		System.out.println(res);
////	}
////	@Test
////	public void testUpdateMyRate(){
////		RateDiscountPo ratePo = new RateDiscountPo();
////		ratePo.setId(46L);
//////		ratePo.setActiveDiscount(0.99);
////		ratePo.setBillType(0);
////		String res = rateDiscountAO.updateRateDiscount(ratePo);
////		System.out.println(res);
////	}
////	@Test
////	public void testGetMyRateList(){
////		RateDiscountPo ratePo = new RateDiscountPo();
////		Pagination<RateDiscountPo>  pagination = rateDiscountAO.getMyRateList(ratePo,4, new PageParam(1, 10));
////		List<RateDiscountPo> records = pagination.getRecords();
////		if(records != null && records.size() > 0){
////			System.out.println(records.size());
////			for (RateDiscountPo rateDiscountPo : records) {
////				System.out.println(rateDiscountPo.getServiceType());
////			}
////		}
////	}
////	@Test
////	public void countMyRate(){
////		Map<String,Object>  params = new HashMap<String, Object>();
////		params.put("channelUseState", 0);
////		params.put("bindState", 0);
////		params.put("agencyId", 4);
////		int i =rateDiscountDao.countMyRate(params);
////		System.out.println(i);
////	}
////	@Test
////	public void testCheckScopeIsAccept(){
////		boolean isAccept = rateDiscountAO.checkScopeIsAccept(4, "江西");
////		if (isAccept) {
////			System.out.println("1");
////		}else{
////			System.out.println("0");
////		}
////		
////	}
//	@Test
//	public void testGetRateForCharge(){
//		
////		ChargeAccountPo accountPo = chargeAccountAo.getAccountByAgencyId(233, BillTypeEnum.CORPORATE_BUSINESS.getValue());//233
//		
////		String userName = "haiyi";
////		AgencyBackwardPo agencyPo = agencyVODao.get(new WherePrams("user_name", "=", userName));
////		String userPass = Hash.BASE_UTIL.decode(agencyPo.getUserPass());
////		System.out.println("decodePass:"+userPass);
////		ChargeAccountPo accountPo = chargeAccountAO.getAccountByAgencyId(agencyPo.getId(), BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
////		System.out.println(accountPo.getId());
////		ChargeParams chargeParams = new ChargeParams(2, 1024, 1, ChannelTypeEnum.ORDINARY.getValue(), "30");
////		RateDiscountPo ratePo = rateDiscountAO.getRateForCharge(new ChargeChannelParamsPo("内蒙古移动", chargeParams.getScope(), chargeParams.getPgType(), chargeParams.getPgValidity(), chargeParams.getChannelType(),chargeParams.getFlowsize()), accountPo.getId(),false);
////		System.out.println(ratePo== null);
//		Map<String, Object> resMap = PurchaseUtil.getOperatorsByTel("14747360019");
//		System.out.println(resMap.get("chargeTelDetail").toString());
//		Map<String, Object> params = PurchaseUtil.getOperatorMapByCarrier(resMap.get("chargeTelDetail").toString());
//		System.out.println(params == null);
////		System.out.println("accountId:"+accountPo.getId());
////		RateDiscountPo ratePo = rateDiscountAO.getRateForCharge(new ChargeChannelParamsPo("上海移动",ServiceTypeEnum.PROVINCE.getValue(),null,null,null,1024), accountPo.getId(), true);
////		//{operatorType=0, channelState=0, billTypeRate=0, channelUseState=0, bindState=0, scopeCityCode=19, serviceType=1, agencyId=4}
////		if(ratePo != null){
////			System.out.println(ratePo.getActiveDiscount());
////			System.out.println("success");
////		}else{
////			
////			System.out.println("error");
////		}
//	}
////	@Test
////	public void testGetRatePgForCharge(){
////		ChargeAccountPo accountPo = chargeAccountAo.getAccountByAgencyId(231, BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
////		System.out.println("accountId:"+accountPo.getId());
////		List<RatePgPo> ratePgList = rateDiscountAO.getRatePgForCharge(new ChargeChannelParamsPo("陕西渭南移动",ServiceTypeEnum.PROVINCE_ROAMING.getValue(),null,null,null,null), accountPo.getId(), true);
////		//{operatorType=0, channelState=0, billTypeRate=0, channelUseState=0, bindState=0, scopeCityCode=19, serviceType=1, agencyId=4}
////		System.out.println(ratePgList == null);
////		if(ratePgList != null){
////			int PICKEROTHERSIZE = 9;
////			int ratePgSize = ratePgList.size();
////			List<RatePgPo> rateShowList = ratePgList.subList(0, PICKEROTHERSIZE-1);//1-9(到第9个)
////			List<RatePgPo> pickerList = ratePgList.subList(PICKEROTHERSIZE-1,ratePgSize);//9-12(从第9个开始)
////			for (RatePgPo ratePgPo : pickerList) {
//////				System.out.println(ratePgPo.getPgSize() + "M,折扣价："+ ratePgPo.getPgDiscountPrice()+"\t1");
////				System.out.println("id："+ ratePgPo.getPgId()+"\t1");
////			}
////			for (RatePgPo ratePgPo : rateShowList) {
////				System.out.println("id："+ ratePgPo.getPgId()+"\t2");
//////				System.out.println(ratePgPo.getPgSize() + "M,折扣价："+ ratePgPo.getPgDiscountPrice()+"\t2");
////			}
////			for (RatePgPo ratePgPo : ratePgList) {
////				System.out.println("id："+ ratePgPo.getPgId()+"\t3\tpgSizeStr:"+ratePgPo.getPgSizeStr());
//////				System.out.println(ratePgPo.getPgSize() + "M,折扣价："+ ratePgPo.getPgDiscountPrice()+"\t2");
////			}
////			System.out.println(JSON.toJSONString(ratePgList));
////			System.out.println("pickerSize="+pickerList.size()+"\tshowSize="+rateShowList.size()+"\trateSize="+ratePgList.size());
////		}
////	}
////	@Test
////	public void testGetMyChildRate(){
////		Map<String,Object> pMap = new HashMap<String, Object>();
//////		pMap.put("bindState", BindStateEnum.BIND.getValue());
//////		pMap.put("channelUseState", ChannelUseStateEnum.OPEN.getValue());
////		pMap.put("activeId", 74);
////		pMap.put("accountId", 64);
////		pMap.put("bindState", BindStateEnum.BIND.getValue());
////		RateDiscountPo childRatePo = rateDiscountDao.getMyChildRate(pMap);
////		System.out.println(childRatePo == null?"null":childRatePo.getActiveDiscount());
////	}
//}
