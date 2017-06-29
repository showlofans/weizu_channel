package com.weizu.flowsys.web.trade.pojo;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.annotation.po.TempField;
import com.weizu.flowsys.core.beans.Po;

/**
 * @description:订单实体
 * @projectName:crud
 * @className:PurchasePo.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月26日 下午5:59:42
 * @version 1.0
 */
@TableName(name="purchase")
public class PurchasePo extends Po {
	
    private Long orderId;						//订单号
    
    private String orderIdApi;					//其他系统返回的订单id

    private Integer agencyId;					//代理id（外键）
   
    private Integer rootAgencyId;				//当前登陆id（外键）

    private String chargeTel;					//手机号

    private Integer pgId;						//流量包id（外键）

    private Long orderArriveTime;				//提交时间（本平台获得该数据请求的时间）

    private Long orderBackTime;					//充值时间（本平台获得返回结果，或者返回给下游平台结果的时间戳）

    private String chargeTelDetail;				//号码归属（：江西移动）

    private String chargeTelCity;				//号码归属具体城市

    private Integer orderPlatformPath;			//充值方式(0-接口，1-本平台)

    private Integer orderResult;				//结果（enum:）(0-失败，1-成功，3-待充，4-为充)

    private Integer channelId;					//通道id（外键）

    private String orderResultDetail;			//结果描述(失败原因)
    
    private Double orderAmount;					//扣款
    
	public PurchasePo(Long orderId, String orderIdApi,Integer agencyId,Integer rootAgencyId, String chargeTel,
			Integer pgId, Long orderArriveTime, Long orderBackTime,
			String chargeTelDetail, String chargeTelCity,
			Integer orderPlatformPath, Integer orderResult, Integer channelId,
			String orderResultDetail, Double orderAmount) {
		super();
		this.orderIdApi = orderIdApi;
		this.orderId = orderId;
		this.rootAgencyId = rootAgencyId;
		this.agencyId = agencyId;
		this.chargeTel = chargeTel;
		this.pgId = pgId;
		this.orderArriveTime = orderArriveTime;
		this.orderBackTime = orderBackTime;
		this.chargeTelDetail = chargeTelDetail;
		this.chargeTelCity = chargeTelCity;
		this.orderPlatformPath = orderPlatformPath;
		this.orderResult = orderResult;
		this.channelId = channelId;
		this.orderResultDetail = orderResultDetail;
		this.orderAmount = orderAmount;
	}
	
	public PurchasePo() {
		super();
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

    public Integer getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Integer agencyId) {
        this.agencyId = agencyId;
    }

    public String getChargeTel() {
        return chargeTel;
    }

    public void setChargeTel(String chargeTel) {
        this.chargeTel = chargeTel == null ? null : chargeTel.trim();
    }

    public Integer getPgId() {
        return pgId;
    }

    public void setPgId(Integer pgId) {
        this.pgId = pgId;
    }

    public Long getOrderArriveTime() {
        return orderArriveTime;
    }

    public void setOrderArriveTime(Long orderArriveTime) {
        this.orderArriveTime = orderArriveTime;
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

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public String getOrderResultDetail() {
        return orderResultDetail;
    }

    public void setOrderResultDetail(String orderResultDetail) {
        this.orderResultDetail = orderResultDetail == null ? null : orderResultDetail.trim();
    }
}
