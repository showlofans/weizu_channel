package com.weizu.flowsys.web.http.entity;

import java.util.List;

import com.weizu.flowsys.web.channel.pojo.PgDataPo;

/**
 * @description: 流量产品实体
 * @projectName:weizu-channel
 * @className:PgProductPo.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年11月9日 上午10:44:57
 * @version 1.0
 */
public class PgProductPo {
	
	private String channelName;							//通道名称：分组参数
		
	private String scopeCityName;						//返回实体
	
	private String scopeCityCode;						//查询结果实体：分组参数
	
	private List<PgDataProduct> pgDataList;					//返回实体：

	public String getScopeCityCode() {
		return scopeCityCode;
	}

	public void setScopeCityCode(String scopeCityCode) {
		this.scopeCityCode = scopeCityCode;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getScopeCityName() {
		return scopeCityName;
	}

	public void setScopeCityName(String scopeCityName) {
		this.scopeCityName = scopeCityName;
	}

	public List<PgDataProduct> getPgDataList() {
		return pgDataList;
	}

	public void setPgDataList(List<PgDataProduct> pgDataList) {
		this.pgDataList = pgDataList;
	}
}
