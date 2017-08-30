package com.weizu.web.foundation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

/**
 * MD5计算类
 * @author 郭胜凯
 * @time 2016年3月15日下午1:12:00
 * @email 719348277@qq.com
 */
public class MD5 {
	public final static int UPPERCASE = 1;  		//大写
	public final static int LOWERCASE = 0;  		//小写
	public final static String ENCODE = "utf-8";  		//默认编码：utf-8
	
	
	public static String getMd5(byte[] b,int stringCase){
		String s = null;  
		char hexDigits[] = { // 用来将字节转换成 16 进制表示的字符
				'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			md.update(b);
			byte tmp[] = md.digest(); // MD5 的计算结果是一个 128 位的长整数，
			// 用字节表示就是 16 个字节
			char str[] = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符，
			// 所以表示成 16 进制需要 32 个字符
			int k = 0; // 表示转换结果中对应的字符位置
			for (int i = 0; i < 16; i++) { // 从第一个字节开始，对 MD5 的每一个字节
				// 转换成 16 进制字符的转换
				byte byte0 = tmp[i]; // 取第 i 个字节
				str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换,
				// >>> 为逻辑右移，将符号位一起右移
				str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
			}
			if(UPPERCASE == stringCase ){
				s = new String(str).toUpperCase(); // 换后的结果转换为大写字符串
			}else if(LOWERCASE == stringCase){
				s = new String(str).toLowerCase(); // 换后的结果转换为小写字符串
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;

	}
	
	/**
	 * @description: 指定编码格式md5编码 和大小写
	 * @param text
	 * @param stringCase
	 * @param encode
	 * @return
	 * @throws UnsupportedEncodingException
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月30日 上午10:18:38
	 */
	public static String getMd5(String text,Integer stringCase,String encode) throws UnsupportedEncodingException{
		if (encode != null) {
			if(stringCase != null){
				return getMd5(text.getBytes(encode),stringCase);
			}else{
				return getMd5(text.getBytes(encode),UPPERCASE);		//默认大写
			}
		}else{
			if(stringCase != null){
				return getMd5(text.getBytes(ENCODE),stringCase);
			}else{
				return getMd5(text.getBytes(ENCODE),UPPERCASE);		//默认大写 utf-8编码
			}
		}
		
	}
	
	public static String getMd5(File file){
		String value = null;
		FileInputStream in = null;
	    try {
	        in = new FileInputStream(file);
	        MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
	        MessageDigest md5 = MessageDigest.getInstance("MD5");
	        md5.update(byteBuffer);
	        BigInteger bi = new BigInteger(1, md5.digest());
	        value = bi.toString(16);
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	            if(null != in) {
	                try {
	                in.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    return value;

	}
}
