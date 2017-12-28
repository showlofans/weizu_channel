package com.weizu.flowsys.util;

import java.net.URLDecoder;

import com.weizu.web.foundation.hash.Hash;
import com.weizu.web.foundation.hash.base64.Base64Util;

/**
 * @description: json推送结果编码转换工具类
 * @projectName:weizu-channel
 * @className:JsonKeyEncodeUtil.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年12月27日 下午5:01:56
 * @version 1.0
 */
public class JsonKeyEncodeUtil {
	public static  String getRealJsonStr(String jsonStr){
		if(jsonStr.contains("%22")){
			
			jsonStr = URLDecoder.decode(jsonStr);
		}
		return jsonStr;
	}
	public static String unescape(String src) {  
        StringBuffer tmp = new StringBuffer();  
        tmp.ensureCapacity(src.length());  
        int lastPos = 0, pos = 0;  
        char ch;  
        while (lastPos < src.length()) {  
            pos = src.indexOf("%", lastPos);  
            if (pos == lastPos) {  
                if (src.charAt(pos + 1) == 'u') {  
                    ch = (char) Integer.parseInt(src  
                            .substring(pos + 2, pos + 6), 16);  
                    tmp.append(ch);  
                    lastPos = pos + 6;  
                } else {  
                    ch = (char) Integer.parseInt(src  
                            .substring(pos + 1, pos + 3), 16);  
                    tmp.append(ch);  
                    lastPos = pos + 3;  
                }  
            } else {  
                if (pos == -1) {  
                    tmp.append(src.substring(lastPos));  
                    lastPos = src.length();  
                } else {  
                    tmp.append(src.substring(lastPos, pos));  
                    lastPos = pos;  
                }  
            }  
        }  
        return tmp.toString();  
    }  
}
