package com.weizu.flowsys.web.channel.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.web.channel.dao.IProductCodeDAO;
import com.weizu.flowsys.web.channel.pojo.ProductCodePo;
import com.weizu.web.foundation.String.StringHelper;

/**
 * @description:包体编码DAO层接口实现
 * @projectName:crud
 * @className:ProductCodeDAOImpl.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月8日 上午11:09:52
 * @version 1.0
 */
@Repository(value="productCodeDAO")
public class ProductCodeDAOImpl extends DaoImpl<ProductCodePo, Long> implements
		IProductCodeDAO {

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	/**
	 * @description:通过参数获取产品编码列表
	 * @param map
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月8日 上午11:09:42
	 */
	@Override
	public List<ProductCodePo> getProductCode(Map<String, Object> map) {
		
		return sqlSessionTemplate.selectList("getProductCode", map);
	}
	/**
	 * @description:根据参数查询编码总记录数
	 * @param map
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月8日 下午12:01:22
	 */
	@Override
	public int countProductCode(Map<String, Object> map) {
		return sqlSessionTemplate.selectOne("countProductCode", map);
	}
	/**
	 * @description: 该编码是否在该通道已经创建 
	 * @param map
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月9日 下午5:17:11
	 */
	@Override
	public int existProductCode(Integer epId, String productCode) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		if(epId != null && StringHelper.isNotEmpty(productCode) ){
			paramsMap.put("epId", epId);
			paramsMap.put("productCode", productCode);
		}
		return sqlSessionTemplate.selectOne("existProductCode", paramsMap);
	}
	/**
	 * @description: 通过参数查询一个产品编码
	 * @param map
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月10日 下午6:01:51
	 */
	@Override
	public ProductCodePo getOneProductCode(Map<String, Object> map) {
		return sqlSessionTemplate.selectOne("getOneProductCode", map);
	}

}
