//package crud.aotest.util;
//
//import java.util.Map;
//
//import org.dom4j.Document;
//import org.dom4j.DocumentException;
//import org.dom4j.DocumentHelper;
//import org.dom4j.Element;
//
//import com.weizu.flowsys.web.trade.WXPayUtil;
//
//public class WXPayUtilTest {
//	public static void main(String[] args) {
////		String nonceStr = WXPayUtil.getNonce_str();
////		System.out.println("nonceStr:" + nonceStr);
//		
//		String xml = "<?xml version='1.0' encoding='UTF-8' standalone='yes'?><response><code>00</code><desc>交易成功</desc><status>success</status><balance>0</balance></response>";
////		String xml = "<servlet><description></description><display-name>TestServlet</display-name><servlet-name>TestServlet</servlet-name><servlet-class>test.TestServlet</servlet-class></servlet>";
////		Map<String,Object> map = WXPayUtil.readStringXmlOut(xml);
////		for (String key : map.keySet()) {
////			String value = map.get(key).toString();
////			System.out.println(key + ":" + value);
////		}
//		
//		try {
//			// 将字符串转为XML
//			Document doc = DocumentHelper.parseText(xml);
//			// 获取根节点
//			Element rootElt = doc.getRootElement();
//			String code = rootElt.element("code").getText();
//			String desc = rootElt.element("desc").getText();
//			System.out.println(code+":"+desc);
//		} catch (DocumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//	}
//}
