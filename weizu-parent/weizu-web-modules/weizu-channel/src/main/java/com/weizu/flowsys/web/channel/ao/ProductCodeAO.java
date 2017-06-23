package com.weizu.flowsys.web.channel.ao;

import java.util.List;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.channel.pojo.OneCodePo;
import com.weizu.flowsys.web.channel.pojo.OperatorPgDataPo;
import com.weizu.flowsys.web.channel.pojo.ProductCodePo;

/**
 * @description:产品编码业务层接口
 * @projectName:crud
 * @className:ProductCodeAO.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月8日 上午11:47:34
 * @version 1.0
 */
public interface ProductCodeAO {
	/**
	 * @description:获得产品编码列表
	 * @param productCodePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月8日 上午11:49:53
	 */
	Pagination<ProductCodePo> getProductCode(ProductCodePo productCodePo,PageParam pageParam);
	
	/**
	 * @description: 添加产品编码
	 * @param productCodePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月9日 上午11:51:56
	 */
	String addProduct(ProductCodePo productCodePo);
	
	/**
	 * @description: 通过流量类型和运营商类型获得流量列表
	 * @param operatorType
	 * @param serviceType
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月9日 上午10:11:56
	 */
	List<OperatorPgDataPo> initPgList(int operatorType, int serviceType);
	
	/**
	 * @description: 该编码是否在该通道已经创建
	 * @param epId
	 * @param productCode
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月9日 下午5:18:39
	 */
	boolean existProductCode(Integer epId, String productCode);
	/**
	 * @description: 通过参数查询一个产品编码
	 * @param map
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月10日 下午6:00:51
	 */
	ProductCodePo getOneProductCode(OneCodePo productCodeParams);
	
}
