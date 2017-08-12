package com.weizu.flowsys.web.activity.pojo;

import com.weizu.flowsys.core.annotation.po.TempField;
import com.weizu.flowsys.core.beans.Po;

/**
 * @description: 页面运营商折扣实体
 * @projectName:weizu-channel
 * @className:DiscountPo.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年7月6日 上午10:04:34
 * @version 1.0
 */
public class DiscountPo extends Po {
	 @TempField
    private String discount0;					//移动折扣（页面参数）
    @TempField
    private String discount1;					//联通折扣（页面参数）
    @TempField
    private String discount2;					//电信折扣（页面参数）
    
	public DiscountPo(String discount0, String discount1, String discount2) {
		super();
		this.discount0 = discount0;
		this.discount1 = discount1;
		this.discount2 = discount2;
	}
	public DiscountPo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getDiscount0() {
		return discount0;
	}
	public void setDiscount0(String discount0) {
		this.discount0 = discount0;
	}
	public String getDiscount1() {
		return discount1;
	}
	public void setDiscount1(String discount1) {
		this.discount1 = discount1;
	}
	public String getDiscount2() {
		return discount2;
	}
	public void setDiscount2(String discount2) {
		this.discount2 = discount2;
	}
    
    
    
}
