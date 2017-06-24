package com.weizu.flowsys.web.activity.dao;

import java.util.List;
import java.util.Map;

import com.weizu.flowsys.web.activity.pojo.OperatorDiscountPo;

public interface IOperatorDiscountDao {
	
	/**
	 * @description:批量添加费率
	 * @param list
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月18日 下午4:31:55
	 */
	int disccount_addList(List<OperatorDiscountPo> list);
	
	/**
	 * @description:通过登录用户id查询费率列表
	 * @param rootAgencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月19日 下午3:06:42
	 */
//	List<OperatorDiscountPo> selectByAgencyId(Integer rootAgencyId);
	
	/**
	 * @description:通过登录用户id查询费率列表总数
	 * @param rootAgencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月19日 下午3:43:14
	 */
	int countByAgencyId(Map<String, Object> paramsMap);
	
	/**
	 * @description:查询登录用户是否有该费率名称(添加费率时)
	 * @param rateName
	 * @param rootAgencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月19日 下午3:09:04
	 */
	int checkRateName(String rateName, Integer rootAgencyId);
	
	/**
	 * @description:通过条件查询费率列表（每条详细费率表）
	 * @param operatorDiscountPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月27日 下午12:59:07
	 */
	List<OperatorDiscountPo> selectDiscountByPo(OperatorDiscountPo operatorDiscountPo);
	
	/**
	 * @description: 通过部分查询整体
	 * @param operatorDiscountPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月24日 下午4:14:23
	 */
	public OperatorDiscountPo selectOneDiscountByPo(OperatorDiscountPo operatorDiscountPo);
	
}
