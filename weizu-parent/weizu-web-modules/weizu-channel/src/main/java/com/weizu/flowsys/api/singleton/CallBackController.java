package com.weizu.flowsys.api.singleton;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weizu.flowsys.api.base.CallBackURL;

/**
 * @description: 回调控制层
 * @projectName:weizu-channel
 * @className:CallBackController.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年8月26日 上午10:32:16
 * @version 1.0
 */
@Controller(value=CallBackURL.MODOE_NAME)
public class CallBackController {
	
	public void weizuCallBack(){
		
	}
	
	/**
	 * @description:丽荣科技回调: http://www.weizutec.top:28445/flowsys/callBack/li_rong.do
	 * @param taskId
	 * @param orderId
	 * @param mobile
	 * @param actualPrice
	 * @param status
	 * @param error
	 * @param reportTime
	 * @return ok
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月26日 上午10:34:58
	 */
	@RequestMapping(value=CallBackURL.LIRONG)
	public String LiRongCallBack(int taskId,String orderId,String mobile,Double actualPrice,int status, String error,int reportTime){
		
		
		return "ok";
	}
}
