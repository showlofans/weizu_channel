package com.weizu.web.foundation;

import java.security.MessageDigest;

public class SHA1 {
	 public static String getSha1(String str, int stringCase){
	        if(str==null||str.length()==0){
	            return null;
	        }
	        char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9',
	                'a','b','c','d','e','f'};
	        try {
	            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
	            mdTemp.update(str.getBytes("UTF-8"));

	            byte[] md = mdTemp.digest();
	            int j = md.length;
	            char buf[] = new char[j*2];
	            int k = 0;
	            for (int i = 0; i < j; i++) {
	                byte byte0 = md[i];
	                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
	                buf[k++] = hexDigits[byte0 & 0xf];      
	            }
	            if(MD5.LOWERCASE == stringCase){
	            	return new String(buf).toLowerCase();
	            }else if(MD5.UPPERCASE == stringCase){
	            	return new String(buf).toUpperCase();
	            }else{
	            	return new String(buf);
	            }
	        } catch (Exception e) {
	            // TODO: handle exception
	            return null;
	        }
	    }
}
