package com.weizu.flowsys.web.activity.pojo;

import org.weizu.web.foundation.core.annotation.po.TableName;
import org.weizu.web.foundation.core.beans.Po;

/**
 * @description: 费率折扣连接实体
 * @projectName:weizu-channel
 * @className:AacJoinRdPo.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年7月11日 上午11:39:34
 * @version 1.0
 */
@TableName(name="aac_join_rd")
public class AacJoinRdPo extends Po {
	
    private Long id;

    private Long rateDiscountId;

    private Long activeId;

    public AacJoinRdPo() {
		super();
	}

	public AacJoinRdPo(Long rateDiscountId, Long activeId) {
		super();
		this.rateDiscountId = rateDiscountId;
		this.activeId = activeId;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRateDiscountId() {
        return rateDiscountId;
    }

    public void setRateDiscountId(Long rateDiscountId) {
        this.rateDiscountId = rateDiscountId;
    }

    public Long getActiveId() {
        return activeId;
    }

    public void setActiveId(Long activeId) {
        this.activeId = activeId;
    }
}