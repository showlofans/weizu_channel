package com.aiyi.base.pojo;

import org.weizu.web.foundation.core.annotation.po.FieldName;
import org.weizu.web.foundation.core.annotation.po.TableName;
import org.weizu.web.foundation.core.annotation.po.TempField;
import org.weizu.web.foundation.core.beans.Po;

@TableName(name="q_test_table1")
public class TestUserPo extends Po {

	private int id;
	
	@FieldName(name="img_id")
	private int imgId;
	
	private String name;
	
	@TempField
	private String imgUrl;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getImgId() {
		return imgId;
	}

	public void setImgId(int imgId) {
		this.imgId = imgId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	
}
