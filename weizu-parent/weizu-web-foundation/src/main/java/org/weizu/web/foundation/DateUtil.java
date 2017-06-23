package org.weizu.web.foundation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.weizu.web.foundation.String.StringHelper;

public class DateUtil {
	
	private static final String DEFAULT_DATE_FORMAT ="yyyy-MM-dd HH:mm:ss";
	
	/**
	 * @description:获得当天的开始时间
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月14日 上午10:59:49
	 */
	public static Date getStartTime() {  
        Calendar todayStart = Calendar.getInstance();  
        todayStart.set(Calendar.HOUR_OF_DAY, 0);  
        todayStart.set(Calendar.MINUTE, 0);  
        todayStart.set(Calendar.SECOND, 0);  
        todayStart.set(Calendar.MILLISECOND, 0);  
        return todayStart.getTime();  
    }  
  
	/**
	 * @description::获得当天的结束时间
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月14日 上午11:00:16
	 */
	public static Date getEndTime() {  
        Calendar todayEnd = Calendar.getInstance();   
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);  
        todayEnd.set(Calendar.MINUTE, 59);  
        todayEnd.set(Calendar.SECOND, 59);  
        todayEnd.set(Calendar.MILLISECOND, 999);  
        return todayEnd.getTime();  
    }  
	/**
	 * @description: String转Date
	 * @param dateString
	 * @param format
	 * @return
	 * @author： POP产品研发部 付琪
	 * @createTime：2016年10月17日 下午5:38:06
	 */
	public static Date strToDate(String dateString, String format)
	{
		if(StringHelper.isEmpty(dateString))
		{
			return null;
		}
		try  
		{  
		    SimpleDateFormat sdf = new SimpleDateFormat(StringHelper.isEmpty(format)?DEFAULT_DATE_FORMAT:format);  
		    Date date = sdf.parse(dateString);  
		    return date;
		}  
		catch (ParseException e)  
		{  
		}  
		return null;
	}


	/**
	 * 普通格式化：yyyy-MM-dd
	 * @return
	 */
	public static String format(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(System.currentTimeMillis());
	}
	
	/**
	 * 普通格式化：yyyy-MM-dd
	 * @return
	 */
	public static String format(long time){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(time);
	}
	
	/**
	 * 普通格式化：yyyy-MM-dd
	 * @return
	 */
	public static String format(Date date){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(date);
	}
	
	/**
	 * 带时分秒：yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String formatAll(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return simpleDateFormat.format(System.currentTimeMillis());
	}
	
	/**
	 * 带时分秒：yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String formatAll(long time){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return simpleDateFormat.format(time);
	}
	
	/**
	 * 带时分秒：yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String formatAll(Date date){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return simpleDateFormat.format(date);
	}
	
	/**
	 * 中文：yyyy年MM月dd日
	 * @return
	 */
	public static String formatCN(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
		return simpleDateFormat.format(System.currentTimeMillis());
	}
	
	/**
	 * 中文：yyyy年MM月dd日
	 * @return
	 */
	public static String formatCN(long time){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
		return simpleDateFormat.format(time);
	}
	
	/**
	 * 中文：yyyy年MM月dd日
	 * @return
	 */
	public static String formatCN(Date date){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
		return simpleDateFormat.format(date);
	}
	
	/**
	 * 中文带时分秒：yyyy年MM月dd日 HH时mm分ss秒
	 * @return
	 */
	public static String formatCNAll(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		return simpleDateFormat.format(System.currentTimeMillis());
	}
	
	/**
	 * 中文带时分秒：yyyy年MM月dd日 HH时mm分ss秒
	 * @return
	 */
	public static String formatCNAll(long time){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		return simpleDateFormat.format(time);
	}
	
	/**
	 * 中文带时分秒：yyyy年MM月dd日 HH时mm分ss秒
	 * @return
	 */
	public static String formatCNAll(Date date){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		return simpleDateFormat.format(date);
	}
	
	/**
	 * 自定义
	 * @param pra
	 * @return
	 */
	public static String formatPramm(String pra){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pra);
		return simpleDateFormat.format(System.currentTimeMillis());
	}
	
	/**
	 * 自定义
	 * @param pra
	 * @return
	 */
	public static String formatPramm(long time, String pra){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pra);
		return simpleDateFormat.format(time);
	}
	
	/**
	 * 自定义
	 * @param pra
	 * @return
	 */
	public static String formatPramm(Date time, String pra){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pra);
		return simpleDateFormat.format(time);
	}

}
