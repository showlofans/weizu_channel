package com.weizu.flowsys.api.singleton.orderState;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.weizu.flowsys.api.singleton.ProductDTO;
import com.weizu.flowsys.api.singleton.ProductIn;
import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.core.util.NumberTool;
import com.weizu.flowsys.operatorPg.enums.CallBackEnum;
import com.weizu.flowsys.operatorPg.enums.OrderResultEnum;
import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
import com.weizu.flowsys.util.JsonKeyEncodeUtil;
import com.weizu.flowsys.web.agency.ao.AgencyAO;
import com.weizu.flowsys.web.agency.dao.impl.AgencyBackwardDao;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
import com.weizu.flowsys.web.trade.ao.AccountPurchaseAO;
import com.weizu.flowsys.web.trade.ao.PurchaseAO;
import com.weizu.flowsys.web.trade.dao.PurchaseDao;
import com.weizu.flowsys.web.trade.pojo.PurchasePo;
import com.weizu.flowsys.web.trade.pojo.PurchaseStateParams;
import com.weizu.web.foundation.DateUtil;
import com.weizu.web.foundation.String.StringHelper;
import com.weizu.web.foundation.http.HttpRequest;

/**
 * @description: 回调控制层111
 * @projectName:weizu-channel
 * @className:CallBack111Controller.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年1月11日 上午9:33:46
 * @version 1.0
 */
@Controller
@RequestMapping(value=CallBackURL.MODOE_NAME)
public class CallBack111Controller {
	@Resource
	private AccountPurchaseAO accountPurchaseAO;
//	@Resource
//	private PurchaseAO purchaseAO;
	
	@Resource
	private PurchaseDao purchaseDAO;
	
	@Resource
	private SendCallBackUtil sendCallBack;
	
//	@Resource
//	private AgencyBackwardDao agencyBackwardDao;
	@Resource
	private AgencyAO agencyAO;
	
	private Logger logger = Logger.getLogger("CallBackController");
	
	/**
	 * @description: 流量汇后台推送
	 * @param key
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月27日 下午4:15:48
	 */
	@ResponseBody
	@RequestMapping(value=CallBackURL.LIULIANGHUI,method=RequestMethod.POST,produces="application/json;charset=UTF-8")//charset=UTF-8
	public String liuLiangHuiCallBack(@RequestBody String key){
//		System.out.println(key);
		String successTag = "success";
		String statusDetail = "";
		int myStatus = -1;
		try {  
            JSONObject obj = JSON.parseObject(key);
            Integer code = obj.getInteger("code");
            String code_desc = obj.getString("code_desc");
            String goods_id = obj.getString("goods_id");
            String mch_id = obj.getString("mch_id");
            String out_trade_no = obj.getString("out_trade_no");//本地订单号
            String phone = obj.getString("phone");
            String time = obj.getString("time");
            String transaction_id = obj.getString("transaction_id");
            String sign = obj.getString("sign");
//            System.out.println("其它参数：time-"+time+"mch_id-"+mch_id+"goods_id-"+goods_id+"phone-"+phone);
            //初始化参数
            long orderId = Long.parseLong(out_trade_no.trim());
            
            PurchasePo purchasePo = purchaseDAO.getOnePurchase(orderId);//数据库没有没有上游订单号
			if(purchasePo == null){
				successTag = "未找到该订单";
				return successTag;
			}
			Boolean hasCall = OrderResultEnum.SUCCESS.getCode().equals(purchasePo.getHasCallBack());
			String res = "";
			if(!hasCall){//上一次没有回调成功
	            //Long orderBackTime = DateUtil.strToDate(report_time, null).getTime();
	            switch (code) {
				case 0:
					myStatus = OrderStateEnum.CHARGED.getValue();
					statusDetail = OrderStateEnum.CHARGED.getDesc();
					break;
	
				default:
					myStatus = OrderStateEnum.UNCHARGE.getValue();
					statusDetail = code_desc;
					break;
				}
	            Long chargeTime = DateUtil.strToDate(time, "").getTime();
	            res = accountPurchaseAO.updatePurchaseState(new PurchasePo(orderId, transaction_id, chargeTime, myStatus,OrderResultEnum.SUCCESS.getCode() , statusDetail));
	            if(!"success".equals(res)){
	            	successTag = res;
	            }
			}
			System.out.println("code:"+code+"<--------->code_desc:"+code_desc);
            //根据订单号去更新数据库，并返回回调结果
  
        } catch (JSONException e) {  
            e.printStackTrace();  
        }  
//		System.out.println(successTag);
		return successTag;
	}
	
	
	
	
}
