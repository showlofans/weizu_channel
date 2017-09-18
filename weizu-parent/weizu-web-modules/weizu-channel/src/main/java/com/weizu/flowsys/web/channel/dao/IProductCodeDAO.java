package com.weizu.flowsys.web.channel.dao;

import java.util.List;
import java.util.Map;

import com.weizu.flowsys.core.dao.Dao;
import com.weizu.flowsys.web.channel.pojo.ProductCodePo;

/**
 * @description:包体编码DAO层接口
 * @projectName:crud
 * @className:IProductCodeDAO.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月8日 上午11:02:26
 * @version 1.0
 */
public interface IProductCodeDAO extends Dao<ProductCodePo, Long> {
	
	/**
	 * @description:通过参数获取产品编码列表
	 * @param map
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月8日 上午11:07:32
	 */
	List<ProductCodePo> getProductCode(Map<String,Object> map);//findByParms
	/**
	 * @description:通过参数获取产品编码记录数
	 * @param map
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月8日 上午11:07:32
	 */
	int countProductCode(Map<String,Object> map);//findByParms
	
	/**
	 * @description:该编码是否在该通道已经创建 
	 * @param epId
	 * @param productCode
	 * @param serviceType
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月18日 下午12:05:28
	 */
	int existProductCode(ProductCodePo productCodePo);
	
	/**
	 * @description: 通过参数查询一个产品编码
	 * @param map
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月10日 下午6:00:51
	 */
	ProductCodePo getOneProductCode(Map<String,Object> map);
}
