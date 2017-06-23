package com.weizu.flowsys.web.channel.ao;

import java.util.List;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;

/**
 * @description:上级对接平台业务层接口
 * @projectName:crud
 * @className:ExchangePlatformAO.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月11日 下午12:40:30
 * @version 1.0
 */
public interface ExchangePlatformAO {
	/**
	 * @description:通过平台名查找平台对象
	 * @param name
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月11日 下午12:45:57
	 */
	ExchangePlatformPo getEpByEpName(String epName);
	
	/**
	 * @description:通过id得到平台信息
	 * @param id
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月17日 上午11:07:43
	 */
	ExchangePlatformPo getEpById(Integer id);
	
	/**
	 * @description:获得所有平台名称
	 * @param name
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月11日 下午12:50:57
	 */
	List<ExchangePlatformPo> getSimpleEp();
	/**
	 * @description:获得所有平台
	 * @param name
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月11日 下午12:50:57
	 */
	Pagination<ExchangePlatformPo> getEp(int agencyId,ExchangePlatformPo ep,PageParam pageParam);
	/**
	 * @description:平台添加
	 * @param exchangePlatformPo
	 * @param agencyId
	 * @param agencyName
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月8日 下午6:20:40
	 */
	String addEp(ExchangePlatformPo exchangePlatformPo,int agencyId,String agencyName);
}
