//package crud.aotest.util;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import com.alibaba.fastjson.JSON;
//import com.weizu.flowsys.core.util.NumberTool;
//import com.weizu.flowsys.util.StringUtil2;
//import com.weizu.web.foundation.DateUtil;
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
//		
////		String[]  attr = new String []{"mch_id","out_trade_no","time"};
////		StringUtil2.printSortedArr(attr);
////		ChargeStatusEnum[] enums = ChargeStatusEnum.values();
////		for (ChargeStatusEnum chargeStatusEnum : enums) {
////			System.out.println(chargeStatusEnum.getValue());
////		}
////		ChargeDTO chargeDTO = new ChargeDTO();
////		System.out.println(chargeDTO.getAjaxDoublePurchase());
////		if(chargeDTO.getAjaxDoublePurchase()){
////		}
////		
////		System.out.println(ChargeStatusEnum.SCOPE_RATE_UNDEFINED.getValue());
////		traverseFolder2("D:\\Documents\\GitHub\\weizu_channel\\weizu-parent\\weizu-web-modules\\weizu-channel");
////		traverseFolder1("D:\\Documents\\GitHub\\weizu_channel\\weizu-parent\\weizu-web-modules\\weizu-channel\\src");
////		Date date = DateUtil.strToDate("2018-01-29", "yyyy-MM-dd");
////		System.out.println(date == null);
////		System.out.println("2018-01-29".length());
//		
////		String key = "qqqqqqqqqqqqqq360111199605236014";
//////		System.out.println(key.length());
//////		double d = 3.226d;
////////		d = NumberTool.round(d, 2);//四舍五入保留两位
//////		int m = (int)(d*100);
//////		System.out.println(m);
////		Set<String> names = new HashSet<String>();
////		StringBuffer sb = new StringBuffer(key);
////		System.out.println(sb.toString().contains("qqqqqqqqqqqqqq360111199605236014")); 
//		
//		Map<String,Object> paramsMap = new HashMap<String,Object>();
//		Map<String,Object> map1 = new HashMap<String,Object>();
//		Map<String,Object> map = new HashMap<String,Object>();
//		List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
//		map.put("req_sn", "rs_100104");
//		map.put("mob_no", "13699562589");
//		map.put("prod_code", "100M_QG"); 
//		
//		map1.put("req_sn", "rs_100103");
//		map1.put("mob_no", "13699562589");
//		map1.put("prod_code", "100M_QG"); 
//		mapList.add(map1);
//		mapList.add(map);
//		
//		String jsonStr = JSON.toJSONString(mapList);
//		paramsMap.put("data", mapList);
//		paramsMap.put("code", 1);
//		String jsonStr2 = JSON.toJSONString(paramsMap);
//		System.out.println(jsonStr2);
//		
//		
////		int count = 0;
////		File[]fileList = new File("D:\\Documents\\GitHub\\weizu_channel\\weizu-parent\\weizu-web-modules\\weizu-channel").listFiles();
////		for (File file : fileList) {
////			if(file.isFile()){
////				count++;
////			}
////		}
////		System.out.println("文件个数:"+count);
//	}
////	public static void traverseFolder2(String path){
////		int count = 0;
////		File file = new File(path);
////        if (file.exists()) {
////            File[] files = file.listFiles();
////            if (files.length == 0) {
////                System.out.println("文件夹是空的!");
////                return;
////            } else {
////                for (File file2 : files) {
////                    if (file2.isDirectory()) {
//////                        System.out.println("文件夹:" + file2.getAbsolutePath());
////                        traverseFolder2(file2.getAbsolutePath());
////                    } else {
////                    	count++;
//////                        System.out.println("文件:" + file2.getAbsolutePath());
////                    }
////                }
////            }
////        } else {
////            System.out.println("文件不存在!");
////        }
////        System.out.println("文件个数:"+count);
////	}
//	/**
//	 * @description: 不递归调用查询文件个数
//	 * @param path
//	 * @author:微族通道代码设计人 宁强
//	 * @createTime:2018年1月26日 上午11:00:02
//	 */
////	public static void traverseFolder1(String path){
////		 int javaFileNum = 0, folderNum = 0,jspFileNum = 0, mapperFileNum = 0;
////	        File file = new File(path);
////	        if (file.exists()) {
////	            LinkedList<File> list = new LinkedList<File>();
////	            File[] files = file.listFiles();
////	            for (File file2 : files) {
////	                if (file2.isDirectory()) {
//////	                    System.out.println("文件夹:" + file2.getAbsolutePath());
////	                    list.add(file2);
////	                    folderNum++;
////	                } else {
////	                	String fileName = file2.getName();
////	                	if(fileName.contains("Mapper.xml")){
////	                		mapperFileNum++;
////	                	}
////	                	if(fileName.contains(".java") ){
////	                		javaFileNum++;
////	                	}
////	                	if(fileName.contains(".jsp")){
////	                		jspFileNum++;
////	                	}
//////	                	fileNum++;
//////	                    System.out.println("文件:" + file2.getAbsolutePath());
////	                }
////	            }
////	            File temp_file;
////	            while (!list.isEmpty()) {
////	                temp_file = list.removeFirst();
////	                files = temp_file.listFiles();
////	                for (File file2 : files) {
////	                    if (file2.isDirectory()) {
//////	                        System.out.println("文件夹:" + file2.getAbsolutePath());
////	                        list.add(file2);
////	                        folderNum++;
////	                    } else {
////	                    	String fileName = file2.getName();
//////		                	if(fileName.contains(".java")  || fileName.contains("Mapper.xml") || fileName.contains(".jsp") ){
//////		                		fileNum++;
//////		                	}
//////		                	if(fileName.contains(".jsp")){
//////		                		fileNum++;
//////		                	}
////		                	if(fileName.contains("Mapper.xml")){
////		                		mapperFileNum++;
////		                	}
////		                	if(fileName.contains(".java") ){
////		                		javaFileNum++;
////		                	}
////		                	if(fileName.contains(".jsp")){
////		                		jspFileNum++;
////		                	}
//////	                        System.out.println("文件:" + file2.getAbsolutePath());
//////	                        fileNum++;
////	                    }
////	                }
////	            }
////	        } else {
////	            System.out.println("文件不存在!");
////	        }
////	        String fileN = path.substring(path.lastIndexOf("\\")+1);
////	        System.out.println(fileN + "文件夹共有:" + folderNum + ",java文件共有:" + javaFileNum + ",jsp文件共有:" + jspFileNum+ ",mapper文件共有:" + mapperFileNum);
////	        System.out.println("总文件数："+ (jspFileNum + javaFileNum + mapperFileNum));
////	}
//	
//	
//}
