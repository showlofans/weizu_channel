package com.weizu.flowsys.web.channel.pojo;

import java.util.List;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.annotation.po.TempField;
import com.weizu.flowsys.core.beans.Po;

/**
 * @description: 省份编码实体
 * @projectName:weizu-channel
 * @className:Provinces.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年11月9日 下午5:21:14
 * @version 1.0
 */
@TableName(name="provinces")
public class Provinces extends Po {
	
	private Integer id;						//id
	
	private String provinceid;				//省份编码
	
	private String province;				//省份名称
	@TempField
	private List<Cities> cities;			//城市列表
	
	public List<Cities> getCities() {
		return cities;
	}

	public void setCities(List<Cities> cities) {
		this.cities = cities;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
	
}
