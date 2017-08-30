package org.weizu.api.forward.weizu;

import java.io.UnsupportedEncodingException;

import org.weizu.api.base.APIParams;
import org.weizu.api.base.ParamsAPIBase;

import com.weizu.web.foundation.MD5;

/**
 * @description:余额api参数
 * @projectName:testHttpInterface
 * @className:BalanceParamsAPI.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月19日 下午3:20:05
 * @version 1.0
 */
public class BalanceParamsAPI extends ParamsAPIBase implements APIParams{
	
	public BalanceParamsAPI(String username, String apikey, String url,
			String epName) {
		super(username,apikey,url,epName);
	}

	@Override
	public String toParams() {
		String sign = null;
		try {
			sign = MD5.getMd5("username="+username+"&apikey="+apikey,null,null);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "username="+username+"&sign="+sign;
	}

	
	
	
	
	
	
	
	
}
