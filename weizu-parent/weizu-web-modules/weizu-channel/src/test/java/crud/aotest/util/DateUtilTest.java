//package crud.aotest.util;
//
//import java.util.Date;
//
//import com.weizu.web.foundation.DateUtil;
//
//public class DateUtilTest {
//	public static void main(String[] args) {
//		//
////		Date date = DateUtil.strToDate("2017-12-10", "yyyy-MM-dd");
////		System.out.println(date == null?"":date.getTime());
//		//
//		long hourTimes = 60*60*1000;
//		long times = System.currentTimeMillis() - hourTimes*2;
//		long eighteenth = DateUtil.getEndTime().getTime() - hourTimes * 6 ;
//		long lastEighteenth = DateUtil.getEndTime().getTime() - hourTimes * (6+24) ;
//		System.out.println(DateUtil.formatAll(times));//前面两小时
//		System.out.println(DateUtil.formatAll(eighteenth));//当天的18:00
//		System.out.println(DateUtil.formatAll(lastEighteenth));//昨天的18:00
//	}
//	
//	
//}