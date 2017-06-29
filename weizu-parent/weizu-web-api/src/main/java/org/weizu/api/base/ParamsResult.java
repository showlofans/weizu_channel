package org.weizu.api.base;

/**
 * @description:参数结果转换接口
 * @projectName:testHttpInterface
 * @className:ParamsResult.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月19日 下午4:40:07
 * @version 1.0
 */
public interface ParamsResult {
	
	/**
	 * @description:初始化参数
	 * @param pp
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月19日 下午4:24:13
	 */
	APIParams initParams(PageParams pp);
	
	/**
	 * @description:获得结果
	 * @param apir
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月19日 下午6:12:34
	 */
	PageResult resetResult(APIResult apir);
	
}
