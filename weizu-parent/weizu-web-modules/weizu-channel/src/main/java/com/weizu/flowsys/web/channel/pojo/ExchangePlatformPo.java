package com.weizu.flowsys.web.channel.pojo;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.annotation.po.TempField;
import com.weizu.flowsys.core.beans.Po;

/**
 * @description:上级对接平台管理实体
 * @projectName:crud
 * @className:ExchangePlatformPo.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月10日 上午10:49:19
 * @version 1.0
 */
@TableName(name="exchange_platform")
public class ExchangePlatformPo extends Po {
	
    private Integer id;					//平台ID

    private String epName;				//平台名称

    private String epPurchaseIp;		//流量订购地址

    private String productListIp;		//产品列表地址

    private String pgdataCheckIp;		//流量查询地址

    private String epBalanceIp;			//余额查询地址

    private String epUserName;			//账号

    private String epUserPass;			//密码

    private Double epBalance;			//平台余额

    private String epApikey;			//apikey

    private String epIp;				//平台官网地址
    
    private String epEngId;				//平台英文标识
    
    private Long lastAccess;			//最后更新时间
    
    @TempField
    private String lastAccessStr;		//页面展示时间
    
    public Long getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(Long lastAccess) {
		this.lastAccess = lastAccess;
	}

	public String getLastAccessStr() {
		return lastAccessStr;
	}

	public void setLastAccessStr(String lastAccessStr) {
		this.lastAccessStr = lastAccessStr;
	}

	public String getEpEngId() {
		return epEngId;
	}

	public void setEpEngId(String epEngId) {
		this.epEngId = epEngId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEpName() {
        return epName;
    }

    public void setEpName(String epName) {
        this.epName = epName == null ? null : epName.trim();
    }

    public String getEpPurchaseIp() {
        return epPurchaseIp;
    }

    public void setEpPurchaseIp(String epPurchaseIp) {
        this.epPurchaseIp = epPurchaseIp == null ? null : epPurchaseIp.trim();
    }

    public String getProductListIp() {
        return productListIp;
    }

    public void setProductListIp(String productListIp) {
        this.productListIp = productListIp == null ? null : productListIp.trim();
    }

    public String getPgdataCheckIp() {
        return pgdataCheckIp;
    }

    public void setPgdataCheckIp(String pgdataCheckIp) {
        this.pgdataCheckIp = pgdataCheckIp == null ? null : pgdataCheckIp.trim();
    }

    public String getEpBalanceIp() {
        return epBalanceIp;
    }

    public void setEpBalanceIp(String epBalanceIp) {
        this.epBalanceIp = epBalanceIp == null ? null : epBalanceIp.trim();
    }

    public String getEpUserName() {
        return epUserName;
    }

    public void setEpUserName(String epUserName) {
        this.epUserName = epUserName == null ? null : epUserName.trim();
    }

    public String getEpUserPass() {
        return epUserPass;
    }

    public void setEpUserPass(String epUserPass) {
        this.epUserPass = epUserPass == null ? null : epUserPass.trim();
    }

    public Double getEpBalance() {
        return epBalance;
    }

    public void setEpBalance(Double epBalance) {
        this.epBalance = epBalance;
    }

    public String getEpApikey() {
        return epApikey;
    }

    public void setEpApikey(String epApikey) {
        this.epApikey = epApikey == null ? null : epApikey.trim();
    }

    public String getEpIp() {
        return epIp;
    }

    public void setEpIp(String epIp) {
        this.epIp = epIp == null ? null : epIp.trim();
    }

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}


}
