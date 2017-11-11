package com.weizu.flowsys.web.channel.ao;

import java.util.List;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.channel.pojo.TelProductPo;

/**
 * @description: 编码业务层
 * @projectName:weizu-channel
 * @className:TelProductAO.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年11月11日 下午3:26:34
 * @version 1.0
 */
public interface TelProductAO {
	/**
	 * @description: 获得某个平台的产品列表
	 * @param telPo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月11日 下午3:14:11
	 */
	public List<TelProductPo> listParamsProductPo(TelProductPo telPo);
	
	
	
	/**
	 * @description: 获得产品列表分页
	 * @param telPo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月11日 下午4:25:00
	 */
	public Pagination<TelProductPo> listTelProduct(TelProductPo telPo, PageParam pageParam);
	
	/**
	 * @description: 添加话费产品编码
	 * @param telPo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月11日 下午4:03:37
	 */
	public String addTelProduct(TelProductPo telPo);
	
	/**
	 * @description: 初始化查询参数
	 * @param telPo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月11日 下午5:54:13
	 */
	WherePrams getWhereByPo(TelProductPo telPo);
	
	/**
	 * @description: 异步查看是否存在该编码
	 * @param telPo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月11日 下午5:59:28
	 */
//	Boolean existCode(TelProductPo telPo);
}
