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

//    private String pgdataCheckIp;		//订单状态查询地址

    private String epBalanceIp;			//余额查询地址
    
    private String epOrderStateIp;			//订单状态查询地址
    
    private String epCallBackIp;			//订单状态回调地址
    

    private String epUserName;			//账号

    private String epUserPass;			//密码

    private Double epBalance;			//平台余额

    private String epApikey;			//apikey

    private String epIp;				//平台官网地址
    
    private String epEngId;				//平台英文标识
    
    private Long lastAccess;			//最后更新时间
    
    private Integer epCallBack;			//是否支持回调（1-不支持，0-支持）
    
    private String epOtherParams;		//平台其他参数
    
    private Integer epFor;				//PgServiceTypeEnum 平台类型
    
    private Integer epEncodeType;			//EpCodeTypeEnum 平台编码类型
    
    @TempField
    private String lastAccessStr;		//页面展示时间
    
	public Integer getEpEncodeType() {
		return epEncodeType;
	}

	public void setEpEncodeType(Integer epEncodeType) {
		this.epEncodeType = epEncodeType;
	}

	public Integer getEpFor() {
		return epFor;
	}

	public void setEpFor(Integer epFor) {
		this.epFor = epFor;
	}

	public Integer getEpCallBack() {
		return epCallBack;
	}

	public void setEpCallBack(Integer epCallBack) {
		this.epCallBack = epCallBack;
	}

	public String getEpOtherParams() {
		return epOtherParams;
	}

	public void setEpOtherParams(String epOtherParams) {
		this.epOtherParams = epOtherParams;
	}

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

    public String getEpOrderStateIp() {
		return epOrderStateIp;
	}

	public void setEpOrderStateIp(String epOrderStateIp) {
		this.epOrderStateIp = epOrderStateIp == null ? null : epOrderStateIp.trim() ;
	}

	public String getEpCallBackIp() {
		return epCallBackIp;
	}

	public void setEpCallBackIp(String epCallBackIp) {
		this.epCallBackIp = epCallBackIp == null ? null : epCallBackIp.trim();
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
		return "ExchangePlatformPo [epName=" + epName + ", epPurchaseIp="
				+ epPurchaseIp + ", productListIp=" + productListIp
				+ ", epBalanceIp=" + epBalanceIp + ", epUserName=" + epUserName
				+ ", epUserPass=" + epUserPass + ", epApikey=" + epApikey
				+ ", epEngId=" + epEngId + ", epOtherParams=" + epOtherParams
				+ ", epFor=" + epFor + "]";
	}


}
