package com.weizu.flowsys.web.activity.ao;

import java.util.List;

import com.weizu.flowsys.web.activity.pojo.OperatorDiscountPo;
import com.weizu.flowsys.web.activity.pojo.RateBackwardVo;


/**
 * @description:费率操作业务层接口
 * @projectName:crud
 * @className:OperatorDiscountAO.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月18日 下午4:42:00
 * @version 1.0
 */
public interface OperatorDiscountAO {
	/**
	 * @description:批量添加费率
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月18日 下午4:36:46
	 */
	int disccount_addList(RateBackwardVo rateBackwardVo,Integer rootAgencyId);
	
	/**
	 * @description:查询登录用户是否有该费率名称(添加费率时)
	 * @param rateName
	 * @param rootAgencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月19日 下午3:22:53
	 */
	int checkRateName (String rateName, Integer rootAgencyId);
	
	/**
	 * @description:通过条件查询费率列表（每条详细费率表）
	 * @param operatorDiscountPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月27日 下午3:42:05
	 */
	List<OperatorDiscountPo> listDiscountByPo(OperatorDiscountPo operatorDiscountPo);
}
