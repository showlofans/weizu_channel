package com.weizu.flowsys.web.http.entity;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.beans.Po;
import com.weizu.flowsys.operatorPg.enums.OrderResultEnum;

/**
 * @description: 传单日志实体
 * @projectName:weizu-channel
 * @className:PurchaseLog.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年1月2日 下午3:02:42
 * @version 1.0
 */
@TableName(name="purchase_log")
public class PurchaseLog extends Po {
	
	
	/**传单参数*/
//	private String userName;			//用户账号
//	private Integer billType;			//是否带票0-不带票，1-带票*******
	
	
//	private Integer flowsize;			//流量大小
//	private Integer scope;				//业务范围()
//	private Integer pgType;				//流量类型（1-流量包，2-流量池）*****
//	private Integer channelType;		//通道类型（1-普通通道包，2-红包通道，3-转移包，4-共享包）********
//    private String pgValidity;			//流量有效期(PgValidityEnum)********
    
    private Long id;					//主键
    private Integer accountId;			//传单账户id
    private Integer pgId;				//传单包体id
    
    private String number;				//充值号码
    private String sign;				//用户签名
    private String orderIdFrom;			//用户传过来的订单号***********
    private String reportUrl;			//回调地址
    private Long orderArriveTime;		//传单时间
    
    /**充值参数*/
    private Long orderId;				//平台流水号
    private int tipCode;				//结果码
    private String tipMsg;				//结果描述
    private Integer recAddTag ;			//账户扣款情况
    private Integer supperRecAddTag;	//超管账户扣款情况
    private String recAddTagDesc;		//账户扣款描述
    
    public PurchaseLog() {
		super();
	}
    
	public PurchaseLog(Integer accountId, Integer pgId, String number,
			String sign, String orderIdFrom, String reportUrl,
			Long orderArriveTime, Long orderId, int tipCode, String tipMsg) {
		super();
		this.accountId = accountId;
		this.pgId = pgId;
		this.number = number;
		this.sign = sign;
		this.orderIdFrom = orderIdFrom;
		this.reportUrl = reportUrl;
		this.orderArriveTime = orderArriveTime;
		this.orderId = orderId;
		this.tipCode = tipCode;
		this.tipMsg = tipMsg;
	}



	@Override
	public String toString() {
		return "PurchaseLog [accountId=" + accountId + ", pgId=" + pgId
				+ ", number=" + number + ", sign=" + sign + ", orderIdFrom="
				+ orderIdFrom + ", reportUrl=" + reportUrl
				+ ", orderArriveTime=" + orderArriveTime + ", orderId="
				+ orderId + ", tipCode=" + tipCode + ", tipMsg=" + tipMsg
				+ ", recAddTag=" + recAddTag + ", supperRecAddTag="
				+ supperRecAddTag + ", recAddTagDesc=" + recAddTagDesc + "]";
	}



	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Integer getPgId() {
		return pgId;
	}

	public void setPgId(Integer pgId) {
		this.pgId = pgId;
	}

	public Integer getRecAddTag() {
		return recAddTag;
	}

	public void setRecAddTag(Integer recAddTag) {
		this.recAddTag = recAddTag;
	}

	public Integer getSupperRecAddTag() {
		return supperRecAddTag;
	}

	public void setSupperRecAddTag(Integer supperRecAddTag) {
		this.supperRecAddTag = supperRecAddTag;
	}

	public String getRecAddTagDesc() {
		return recAddTagDesc;
	}

	public void setRecAddTagDesc(String recAddTagDesc) {
		this.recAddTagDesc = recAddTagDesc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderArriveTime() {
		return orderArriveTime;
	}

	public void setOrderArriveTime(Long orderArriveTime) {
		this.orderArriveTime = orderArriveTime;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public int getTipCode() {
		return tipCode;
	}

	public void setTipCode(int tipCode) {
		this.tipCode = tipCode;
	}

	public String getTipMsg() {
		return tipMsg;
	}



	public void setTipMsg(String tipMsg) {
		this.tipMsg = tipMsg;
	}



	public String getReportUrl() {
		return reportUrl;
	}

	public void setReportUrl(String reportUrl) {
		this.reportUrl = reportUrl;
	}


	public String getOrderIdFrom() {
		return orderIdFrom;
	}

	public void setOrderIdFrom(String orderIdFrom) {
		this.orderIdFrom = orderIdFrom;
	}

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
}
