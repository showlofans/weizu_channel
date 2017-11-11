//package crud.aotest;
//
//import java.io.UnsupportedEncodingException;
//
//import javax.annotation.Resource;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONException;
//import com.alibaba.fastjson.JSONObject;
//import com.weizu.flowsys.api.weizu.charge.PgProductParams;
//import com.weizu.flowsys.api.weizu.facet.IPgProductFacet;
//import com.weizu.flowsys.core.beans.WherePrams;
//import com.weizu.flowsys.operatorPg.enums.OrderResultEnum;
//import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
//import com.weizu.flowsys.web.agency.dao.AgencyVODaoInterface;
//import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
//import com.weizu.flowsys.web.http.ao.ValiUser;
//import com.weizu.flowsys.web.http.entity.PgProduct;
//import com.weizu.flowsys.web.trade.pojo.PurchasePo;
//import com.weizu.web.foundation.MD5;
//import com.weizu.web.foundation.hash.Hash;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class APITest {
//	@Resource
//	private IPgProductFacet pgProductFacdeImpl;
//	
//	@Resource
//	private ValiUser valiUser;
//	@Resource
//	private AgencyVODaoInterface agencyVODao;
//	
//	@Test
//	public void testProductList(){
//		String userName = "123";
//		AgencyBackwardPo agencyPo = agencyVODao.get(new WherePrams("user_name", "=", userName));
//		//得到密码
//		String userPass = Hash.BASE_UTIL.decode(agencyPo.getUserPass());
//		String rightSign = null;
//		try {
//			rightSign = MD5.getMd5("userName="+agencyPo.getUserName()+"&userPass="+userPass+"&apikey="+agencyPo.getUserApiKey(),null,null);
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		//签名和用户名都正确
//		PgProduct pgP = pgProductFacdeImpl.getPgProductList(new PgProductParams(rightSign, userName));
//		String jsonStr = JSON.toJSON(pgP).toString();
//		printProductJson(jsonStr);
//	}
//	
//	/**
//	 * @description: 解析产品列表
//	 * @param jsonStr
//	 * @throws JSONException
//	 * @author:微族通道代码设计人 宁强
//	 * @createTime:2017年11月9日 下午2:36:02
//	 */
//	private void printProductJson(String jsonStr) throws JSONException{
//		System.out.println(jsonStr);
//		
//        JSONObject obj = JSON.parseObject(jsonStr);
//        Integer errcode = obj.getInteger("tipCode");
//        String tipMsg = obj.getString("tipMsg");
////        JSONObject pgProduct = obj.getJSONObject("PgProduct");
////        pgProduct
//        JSONArray jsonArr = obj.getJSONArray("pgList");
//        for (Object pgProduct : jsonArr) {
//        	JSONObject jsonObj = (JSONObject)pgProduct;
//        	
//        	StringBuffer sb = new StringBuffer();
//        	String channelName = jsonObj.get("channelName").toString();
//        	String scopeCityName = jsonObj.get("scopeCityName").toString();
//        	sb.append("通道标注："+ channelName);
//        	sb.append("\t地区："+scopeCityName);
//        	sb.append("\r");
//        	sb.append("包体信息:");
//        	
////        	JSONArray jsonArr2 = jsonObj.getJSONArray("pgDataList");
////        	for (Object pgProductPo : jsonArr2) {
////        		JSONObject jsonObj2 = (JSONObject)pgProductPo;
////        		String productCode = jsonObj2.get("productCode").toString();
////        		sb.append("\t产品编码：" + productCode);
////        		String operatorName = jsonObj2.get("operatorName").toString();
////        		sb.append("\t运营商：" + operatorName);
////        		String pgSize = jsonObj2.get("pgSize").toString();
////        		sb.append("\t包体大小：" + pgSize);
////        		String pgName = jsonObj2.get("pgName").toString();
////        		sb.append("\t包体名称：" + pgName);
////        		
////        		System.out.println(sb.toString());
////			}
//        	JSONArray jsonArr2 = jsonObj.getJSONArray("pgDataList");
//        	for (Object pgProductPo : jsonArr2) {
//        		JSONObject jsonObj2 = (JSONObject)pgProductPo;
//        		String productCode = jsonObj2.get("productCode").toString();
//        		sb.append(productCode + "-");
//        		String pgSize = jsonObj2.get("pgSize").toString();
//        		sb.append( pgSize + "M-");
//        		String operatorName = jsonObj2.get("operatorName").toString();
//        		sb.append(operatorName + "\t");
////        		String pgName = jsonObj2.get("pgName").toString();
////        		sb.append("\t包体名称：" + pgName);
//        	}
////        	sb.append("]");
//        	System.out.println(sb.toString());
//        	System.out.println();
//		}
//        System.out.println("********************打印格式********************");
//        System.out.println("通道标注\t地区");
//        System.out.println("产品编码-流量大小-运营商");
//	}
//	
////	@Test
////	public void testAccountAPI(){
////		String requestUrl = "http://139.224.70.161:32001/api/v1/getBalance";
////		String username = "CS111111";
////		String apikey = "722c16de0a83e5bd2f988e3c7bc9fee8";
////		String sign = MD5.getMd5("username="+username+"&apikey="+ apikey);
////		String params = "username="+username+"&sign="+ sign;
////		String resultStr = HttpRequest.sendGet(requestUrl, params);
////		System.out.println(resultStr);
////	}
////	@Test
////	public void testChargeAPI(){
////		String requestUrl = "http://127.0.0.1:8080/weizuAPI/chargePg.do";
////		String sign = MD5.getMd5("402880ef5cd2b925015cd2b925b90000");
////		String params = "userName=456&number=15858343638&pgSize=6144&scope=0&sign="+ sign;
////		String resultStr = HttpRequest.sendGet(requestUrl, params);
////		System.out.println(resultStr);
////	}
////	@Test
////	public void testOrderStateAPI(){
////		String requestUrl = "http://127.0.0.1:8080/weizuAPI/myOrderState.do";
////		String sign = MD5.getMd5("402880ef5cd2b925015cd2b925b90000");
////		String params = "userName=456&sign="+ sign+"&orderId=705162055119802368&number=15858343638";
////		String resultStr = HttpRequest.sendGet(requestUrl, params);
////		System.out.println(resultStr);
////	}
//}
