package com.weizu.web.foundation;

import java.util.Random;

import org.springframework.stereotype.Service;

/**
 * @description: (验证码生成)
 * @projectName:crud
 * @className:VerifyCodeUtils.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月23日 下午3:45:22
 * @version 1.0
 */
public class VerifyCodeUtils {
	//使用到Algerian字体，系统里没有的话需要安装字体，字体只显示大写，去掉了1,0,i,o几个容易混淆的字符
    public static final String VERIFY_CODES = "23456789ABCDEFGHJKLMNPQRSTUVWXYZ";
    public static final int DEFAULT_SIZE = 4;//默认字符数
    private static Random random = new Random();
    
     
    
 
    /**
     * 使用系统默认字符源生成验证码
     * @param verifySize    验证码长度
     * @return
     */
    public static String generateVerifyCode(int verifySize){
    	//通过了代理商表中代理商名称和邀请码验证，就可以
        return generateVerifyCode(verifySize, VERIFY_CODES);
    }
    /**
     * 使用指定源生成验证码
     * @param verifySize    验证码长度
     * @param sources   验证码字符源
     * @return
     */
    public static String generateVerifyCode(int verifySize, String sources){
        if(sources == null || sources.length() == 0){
            sources = VERIFY_CODES;
        }
        int codesLen = sources.length();
        Random rand = new Random(System.currentTimeMillis());
        StringBuilder verifyCode = new StringBuilder(verifySize);
        for(int i = 0; i < verifySize; i++){
            verifyCode.append(sources.charAt(rand.nextInt(codesLen-1)));
        }
        return verifyCode.toString();
    }
}
