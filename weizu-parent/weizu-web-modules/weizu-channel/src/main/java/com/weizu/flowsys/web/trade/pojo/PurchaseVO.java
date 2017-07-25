package com.weizu.flowsys.web.trade.pojo;

import com.weizu.flowsys.core.annotation.po.TempField;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;

/**
 * @description: 订单页面展示
 * @projectName:crud
 * @className:PurchaseVO.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月13日 下午12:16:36
 * @version 1.0
 */
public class PurchaseVO {
	
    private Long orderId;						//订单号
    
    private String orderIdApi;					//其他系统返回的订单id
    
    private String orderIdFrom;					//下级代理商传过来的订单号

    private String agencyName;					//代理商名称

    private String chargeTel;					//手机号

    private Integer pgSize;						//包体大小
    
    private double pgPrice;						//包体原价
    
    private Integer operatorType;				//运营商名称

    private Long orderArriveTime;				//提交时间（本平台获得该数据请求的时间）
    @TempField
    private String orderArriveTimeStr;  		// 提交时间字符串
    
    @TempField
    private String arriveEndTimeStr;			//提交开始时间字符串
    @TempField
    private String arriveStartTimeStr;			//提交结束时间字符串
    
    private Integer rootAgencyId;				//当前登陆id（外键）

    private Long orderBackTime;					//充值时间（本平台获得返回结果，或者返回给下游平台结果的时间戳）
    @TempField
    private String orderBackTimeStr;			//充值时间字符串

    private String chargeTelDetail;				//号码归属（：江西移动）

    private String chargeTelCity;				//号码归属具体城市

    private Integer orderPlatformPath;			//充值方式(0-接口，1-本平台)

    private Integer orderResult;				//结果（enum:）

    private String channelName;					//通道名称
    
    private Integer channelId;					//通道ID

    private String orderResultDetail;			//结果描述
    
    private Double orderAmount;					//扣款
    
    private ExchangePlatformPo ep;				//平台信息
    
    public String getOrderIdFrom() {
		return orderIdFrom;
	}

	public void setOrderIdFrom(String orderIdFrom) {
		this.orderIdFrom = orderIdFrom;
	}

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public ExchangePlatformPo getEp() {
		return ep;
	}

	public void setEp(ExchangePlatformPo ep) {
		this.ep = ep;
	}

	public String getOrderIdApi() {
		return orderIdApi;
	}

	public void setOrderIdApi(String orderIdApi) {
		this.orderIdApi = orderIdApi;
	}

	public Integer getRootAgencyId() {
		return rootAgencyId;
	}

	public void setRootAgencyId(Integer rootAgencyId) {
		this.rootAgencyId = rootAgencyId;
	}

	public Integer getOperatorType() {
		return operatorType;
	}

	public void setOperatorType(Integer operatorType) {
		this.operatorType = operatorType;
	}

	public Integer getPgSize() {
		return pgSize;
	}

	public void setPgSize(Integer pgSize) {
		this.pgSize = pgSize;
	}

	public double getPgPrice() {
		return pgPrice;
	}

	public void setPgPrice(double pgPrice) {
		this.pgPrice = pgPrice;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public String getOrderBackTimeStr() {
		return orderBackTimeStr;
	}

	public void setOrderBackTimeStr(String orderBackTimeStr) {
		this.orderBackTimeStr = orderBackTimeStr;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getChargeTel() {
        return chargeTel;
    }

    public void setChargeTel(String chargeTel) {
        this.chargeTel = chargeTel == null ? null : chargeTel.trim();
    }

    public Long getOrderArriveTime() {
        return orderArriveTime;
    }

    public void setOrderArriveTime(Long orderArriveTime) {
        this.orderArriveTime = orderArriveTime;
    }

    public String getArriveEndTimeStr() {
		return arriveEndTimeStr;
	}
    
	public String getOrderArriveTimeStr() {
		return orderArriveTimeStr;
	}

	public void setOrderArriveTimeStr(String orderArriveTimeStr) {
		this.orderArriveTimeStr = orderArriveTimeStr;
	}

	public void setArriveEndTimeStr(String arriveEndTimeStr) {
		this.arriveEndTimeStr = arriveEndTimeStr;
//		if(StringHelper.isNotEmpty(arriveEndTimeStr)){
//			this.orderArriveTime = DateUtil.strToDate(arriveStartTimeStr, null).getTime();
//		}
	}

	public String getArriveStartTimeStr() {
		return arriveStartTimeStr;
	}

	public void setArriveStartTimeStr(String arriveStartTimeStr) {
		this.arriveStartTimeStr = arriveStartTimeStr;//不为空
//		if(StringHelper.isNotEmpty(arriveStartTimeStr)){
//			this.orderArriveTime = DateUtil.strToDate(arriveStartTimeStr, null).getTime();
//		}
	}

	public Long getOrderBackTime() {
        return orderBackTime;
    }

    public void setOrderBackTime(Long orderBackTime) {
        this.orderBackTime = orderBackTime;
    }

    public String getChargeTelDetail() {
        return chargeTelDetail;
    }

    public void setChargeTelDetail(String chargeTelDetail) {
        this.chargeTelDetail = chargeTelDetail == null ? null : chargeTelDetail.trim();
    }

    public String getChargeTelCity() {
        return chargeTelCity;
    }

    public void setChargeTelCity(String chargeTelCity) {
        this.chargeTelCity = chargeTelCity == null ? null : chargeTelCity.trim();
    }

    public Integer getOrderPlatformPath() {
        return orderPlatformPath;
    }

    public void setOrderPlatformPath(Integer orderPlatformPath) {
        this.orderPlatformPath = orderPlatformPath;
    }

    public Integer getOrderResult() {
        return orderResult;
    }

    public void setOrderResult(Integer orderResult) {
        this.orderResult = orderResult;
    }

    public String getOrderResultDetail() {
        return orderResultDetail;
    }

    public void setOrderResultDetail(String orderResultDetail) {
        this.orderResultDetail = orderResultDetail == null ? null : orderResultDetail.trim();
    }
}
