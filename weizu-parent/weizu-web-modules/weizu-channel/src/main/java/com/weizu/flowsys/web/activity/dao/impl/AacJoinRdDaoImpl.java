package com.weizu.flowsys.web.activity.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.weizu.flowsys.web.activity.dao.AacJoinRdDao;
import com.weizu.flowsys.web.activity.pojo.AacJoinRdPo;
import com.weizu.web.foundation.core.dao.impl.DaoImpl;

/**
 * @description: 费率折扣连接
 * @projectName:weizu-channel
 * @className:AacJoinRdDaoImpl.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年7月11日 下午2:58:15
 * @version 1.0
 */
@Repository(value="aacJoinRdDao")
public class AacJoinRdDaoImpl extends DaoImpl<AacJoinRdPo, Long> implements AacJoinRdDao {
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * @description: 批量添加
	 * @param addList
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月11日 下午2:56:34
	 */
	@Override
	public int aac_addList(List<AacJoinRdPo> addList) {
		
		return sqlSessionTemplate.insert("aac_addList", addList);
	}

}
