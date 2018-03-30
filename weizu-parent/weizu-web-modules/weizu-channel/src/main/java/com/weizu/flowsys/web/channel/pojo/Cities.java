package com.weizu.flowsys.web.channel.pojo;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.beans.Po;

/**
 * @description: 城市编码实体
 * @projectName:weizu-channel
 * @className:Cities.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年11月9日 下午5:25:59
 * @version 1.0
 */
@TableName(name="cities")
public class Cities extends Po{
	
	private Integer id;						//id
	
	private String cityid;					//城市编码
	
	private String city;					//城市编码
	
	private String provinceid;				//省份编码

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	
}
