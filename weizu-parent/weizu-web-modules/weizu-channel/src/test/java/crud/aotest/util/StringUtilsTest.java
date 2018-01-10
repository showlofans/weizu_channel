//package crud.aotest.util;
//
//import java.io.UnsupportedEncodingException;
//import java.net.URLDecoder;
//import java.util.Arrays;
//import java.util.Map;
//
//import com.alibaba.fastjson.JSON;
//import com.weizu.flowsys.util.JsonKeyEncodeUtil;
//import com.weizu.flowsys.util.StringUtil2;
//import com.weizu.web.foundation.DateUtil;
//import com.weizu.web.foundation.EncodingUtil;
//import com.weizu.web.foundation.hash.Hash;
//
//public class StringUtilsTest {
//	public static void main(String[] args) {
////		Map<String,Object> map = StringUtil2.getTreeMapByStr("userPass=123456&userName=123&");
//////		for
////		System.out.println(map);
////		System.out.println(JSON.toJSONString(map));
////		String str = "%7B%22orderid%22%3A%2217122715174701520008%22%2C%22transno%22%3A%22771881783720415232%22%2C%22method%22%3A%22rw.open.dataflow.ordercallback%22%2C%22timestamp%22%3A1514363804%2C%22phone%22%3A%2213699562589%22%2C%22status%22%3A%221%22%2C%22message%22%3A%22%5Cu6210%5Cu529f%22%7D=";
////		String encode = EncodingUtil.getEncoding(str);
////		str = JsonKeyEncodeUtil.unescape(str);
////		System.out.println(str.subSequence(0, str.length()-1));
////		try {
////			System.out.println(URLDecoder.decode(str,"GB2312"));
////		} catch (UnsupportedEncodingException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//		
////		Long ts = 1514425785l;
////		ts *= 1000;
////		System.out.println(DateUtil.formatAll(ts));
////		String[]  attr = new String []{"mch_id","phone","goods_id","out_trade_no","notify_url","mch_time"};
//		String[]  attr = new String []{"mch_id","out_trade_no","time"};
//		StringUtil2.printSortedArr(attr);
//	}
//}
