//package crud.aotest.util;
//
//import java.io.File;
//import java.lang.management.ManagementFactory;
//import java.lang.management.OperatingSystemMXBean;
//import java.util.Map;
//
//import com.weizu.flowsys.web.trade.PurchaseUtil;
//
///**
// * @description: 下单调用接口测试
// * @projectName:weizu-channel
// * @className:PurchaseUtilTest.java
// * @author:微族通道代码设计人 宁强
// * @createTime:2018年1月15日 下午4:35:42
// * @version 1.0
// */
//public class PurchaseUtilTest {
//	public static void main(String[] args) {
////		String url1 = "http://v.juhe.cn/joke/randJoke.php?key=3163fa316ed3ffd2eb0be5340b1f11cd";//获得随机很多条笑话
////		Map<String,Object> map = PurchaseUtil.getJokeByRand(url1);
////		String url = "http://v.juhe.cn/joke/content/text.php?key=3163fa316ed3ffd2eb0be5340b1f11cd";//获得随机很多条笑话
////		Map<String,Object> map = PurchaseUtil.getJokeForNow(url);
////		System.out.println(map.get("updatetime").toString());
////		System.out.println(map.get("content").toString());
//		
////		long hourTimes = 60*60*1000;
////		long dateTimes = 24*hourTimes;
////		PurchaseUtil.todayOnhistory(System.currentTimeMillis() - 16*dateTimes);
////		PurchaseUtil.todayOnhistory(System.currentTimeMillis() - 24*hourTimes);
//		File[] roots = File.listRoots();  
//        for (File _file : roots) {  
//            System.out.println(_file.getPath());  
//            //System.out.println(_file.getName());  
//            System.out.println("Free space = " + (_file.getFreeSpace()/(1024*1024))/1024+"G");  //显示GB大小
//            System.out.println("Usable space = " + _file.getUsableSpace());  
//            System.out.println("Total space = " + (_file.getTotalSpace()/(1024*1024))/1024+"G");  
//            System.out.println("used space  = " + (_file.getTotalSpace()-_file.getFreeSpace()));  
//            System.out.println();  
//        }  
//        File win = new File("C:\\WINDOWS");  
//        System.out.println(win.getPath());  
//        System.out.println(win.getName());  
//        System.out.println("Free space = " + win.getFreeSpace());  
//        System.out.println("Usable space = " + win.getUsableSpace());  
//        System.out.println("Total space = " + win.getTotalSpace());  
//        System.out.println(); 
//		
//	}
////	 public static void getDiskInfo()
////	    {
////	        File[] disks = File.listRoots();
////	        for(File file : disks)
////	        {
////	            System.out.print(file.getPath() + "    ");
////	            System.out.print("空闲未使用 = " + file.getFreeSpace() / 1024 / 1024 + "M" + "    ");// 空闲空间
////	            System.out.print("已经使用 = " + file.getUsableSpace() / 1024 / 1024 + "M" + "    ");// 可用空间
////	            System.out.print("总容量 = " + file.getTotalSpace() / 1024 / 1024 + "M" + "    ");// 总空间
////	            System.out.println();
////	        }
////	    }
////	    
////	    public static void getMemInfo()
////	    {
////	        OperatingSystemMXBean mem = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
////	        System.out.println("Total RAM：" + mem.getTotalPhysicalMemorySize() / 1024 / 1024 + "MB");
////	        System.out.println("Available　RAM：" + mem.getFreePhysicalMemorySize() / 1024 / 1024 + "MB");
////	    }
//}
