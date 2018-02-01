//package crud.aotest.util;
//
//import java.io.File;
//import java.lang.management.ManagementFactory;
//import java.lang.management.OperatingSystemMXBean;
//import java.net.UnknownHostException;
//import java.util.List;
//import java.util.Map;
//
//import com.alibaba.fastjson.JSON;
//import com.weizu.flowsys.web.base.SystemInfo;
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
//		Map<String,Object> scopeMap = PurchaseUtil.getScopeCityByCarrier("江西南昌移动");
//		System.out.println(scopeMap.get("scopeCityCode").toString());
//		
////		String url1 = "http://v.juhe.cn/joke/randJoke.php?key=3163fa316ed3ffd2eb0be5340b1f11cd";//获得随机很多条笑话
////		Map<String,Object> map = PurchaseUtil.getJokeByRand(url1);
////		String url = "http://v.juhe.cn/joke/content/text.php?key=3163fa316ed3ffd2eb0be5340b1f11cd";//获得随机很多条笑话
////		List<Map<String,Object>> map = PurchaseUtil.getJokeForNow(url);
////		for (Map<String, Object> map2 : map) {
////			
////		System.out.println(map2.get("updatetime").toString());
////		System.out.println(map2.get("content").toString());
////		}
//		
////		long hourTimes = 60*60*1000;
////		long dateTimes = 24*hourTimes;
////		PurchaseUtil.todayOnhistory(System.currentTimeMillis() - 16*dateTimes);
////		PurchaseUtil.todayOnhistory(System.currentTimeMillis() - 24*hourTimes);
////		
////		File[] roots = File.listRoots();  
////		for (File _file : roots) {  
////			System.out.println(_file.getPath());  
////			//System.out.println(_file.getName());  
////			System.out.println("Free space = " + (_file.getFreeSpace()/(1024*1024))/1024+"G");  //显示GB大小
////			System.out.println("Usable space = " + _file.getUsableSpace());  
////			System.out.println("Total space = " + (double)(_file.getTotalSpace()/(1024*1024))/1024+"G");  
////			System.out.println("used space  = " + (_file.getTotalSpace()-_file.getFreeSpace()));  
////			System.out.println();  
////		}  
////		File win = new File("C:\\WINDOWS");  
////		System.out.println(win.getPath());  
////		System.out.println(win.getName());  
////		System.out.println("Free space = " + win.getFreeSpace());  
////		System.out.println("Usable space = " + win.getUsableSpace());  
////		System.out.println("Total space = " + win.getTotalSpace());  
////		System.out.println(); 
////		Map<String,Object> map = PurchaseUtil.getOperatorsByTel("136995862589");
////		System.out.println(map.get("chargeTelDetail"));
////		Map<String,Object> map = PurchaseUtil.getOperatorMapByCarrier("陕西移动");
////		System.out.println(map.get("operatorType"));
////		try {
////			System.out.println("--------------文件系统信息如下--------------------");  
////			// 文件系统信息  
////			 List<Map<String,Object>> mapList = SystemInfo.file();
////			 String jsonStr = JSON.toJSONString(mapList);
////			 System.out.println(jsonStr);
////			
//////			System.out.println("-----------System信息，从jvm获取如下-----------------------");  
//////            // System信息，从jvm获取  
//////			SystemInfo.property();  
//////             
//////            System.out.println("------------cpu信息如下----------------------");  
//////            // cpu信息  
//////			SystemInfo.cpu();  
//////			 
//////			System.out.println("------------内存信息如下----------------------");  
//////			// 内存信息  
//////			SystemInfo.memory();  
//////			
//////			System.out.println("------------操作系统信息如下----------------------");  
//////			// 操作系统信息  
//////			SystemInfo.os();  
//////			 
//////			System.out.println("-------------用户信息如下---------------------");  
//////			// 用户信息  
//////			SystemInfo.who();  
//////			 
//////			System.out.println("-----------网络信息如下-----------------------");  
//////			// 网络信息  
//////			SystemInfo.net();  
//////			
//////			System.out.println("------------以太网信息如下----------------------");  
//////			// 以太网信息  
//////			SystemInfo.ethernet();
////		} catch (Exception e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//		
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
