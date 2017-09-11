package com.weizu.flowsys.api.singleton.orderState;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
import com.weizu.web.foundation.String.StringHelper;
import com.weizu.web.foundation.http.HttpRequest;

/**
 * @description: 推送订单结果工具类
 * @projectName:weizu-channel
 * @className:SendCallBackUtil.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年9月7日 下午2:40:36
 * @version 1.0
 */
public class SendCallBackUtil {
	private final static int CALL_BACK_TIME = 6;			//回调次数
	
	/**
	 * @description: 向下游推送结果方法
	 * @param rjdto
	 * @param status
	 * @param statusDetail
	 * @param url
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月4日 下午1:08:42
	 */
	public static String sendCallBack(ResponseJsonDTO rjdto,AgencyBackwardPo agencyPo){
		String requestUrl = agencyPo.getCallBackIp();
		if(StringHelper.isNotEmpty(requestUrl)){
			String resMsg = "";
			int i = 0;
			do{
				i++;
				String backJson = JSONObject.toJSONString(rjdto);
				resMsg = HttpRequest.sendPost(requestUrl, backJson);
				if(i== CALL_BACK_TIME){
					return "error";
				}
			}while(!"ok".equals(resMsg));
			
			return "success";
		}else{
			System.out.println("回调地址不存在");
			return "error";
		}
	}
}
