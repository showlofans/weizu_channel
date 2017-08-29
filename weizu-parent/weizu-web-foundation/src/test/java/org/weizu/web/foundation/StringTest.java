package org.weizu.web.foundation;

import com.weizu.web.foundation.MD5;
import com.weizu.web.foundation.MD5Util;
import com.weizu.web.foundation.SHA1;

public class StringTest {

	public static void main(String[] args) {
//		String md5 = MD5Util.MD5("123");
//		String md5 = MD5Util("123");
//		MD5Util.
		testSHA1("1");
		
		
//		System.out.println(MD5.getMd5(md5));
	}
	
	private static void testSHA1(String str){
		String sha1 = SHA1.getSha1(str);
		System.out.println(sha1);
		String sha2 = SHA1.getSha1(str);
		System.out.println(sha2);
		System.out.println(sha1.equals(sha2));
	}

}
