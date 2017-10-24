//package com.weizu.flowsys.api.singleton.orderState;
//
//import com.alibaba.fastjson.JSONObject;
//import com.weizu.web.foundation.http.HttpRequest;
//
//public class SendCallBackThread extends Thread {
//
//	private String resMsg; 				//线程是否继续的标识
//	private ResponseJsonDTO rjdto;		//线程要推送的订单结果实体
//	
//	
//	@Override
//	public void run() {
//		String resMsg = "";
//		int i = 0;
//		do{
//				i++;
//				String backJson = JSONObject.toJSONString(rjdto);
//				resMsg = HttpRequest.sendPost(requestUrl, backJson);
//				if(i== CALL_BACK_TIME){
//					break;
//				}
////				if( i < 4 && !"ok".equals(resMsg) ){
////					Thread.sleep(30 * 1000 * i);//30 60 90
////				}else{
////					Thread.sleep(30 * 1000 * 10);//300s
////				}
////			} catch (InterruptedException e) {
////				e.printStackTrace();
////			}
//		}while(!"ok".equals(resMsg));
//	}
//
//	public String getResMsg() {
//		return resMsg;
//	}
//
//	public void setResMsg(String resMsg) {
//		this.resMsg = resMsg;
//	}
//
//	public ResponseJsonDTO getRjdto() {
//		return rjdto;
//	}
//
//	public void setRjdto(ResponseJsonDTO rjdto) {
//		this.rjdto = rjdto;
//	}
//	
//}
