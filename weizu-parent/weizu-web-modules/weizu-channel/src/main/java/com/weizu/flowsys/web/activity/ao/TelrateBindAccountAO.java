package com.weizu.flowsys.web.activity.ao;

import java.util.Map;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.web.activity.pojo.AccountActiveRateDTO;
import com.weizu.flowsys.web.activity.pojo.TelrateBindAccountVO;

/**
 * @description: 代理商账户和话费折扣绑定业务
 * @projectName:weizu-channel
 * @className:TelrateBindAccountAO.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年11月16日 下午5:12:18
 * @version 1.0
 */
public interface TelrateBindAccountAO {
	
	/**
	 * @description: 获得绑定的代理商列表和费率列表<br>
	 * 初始化话费绑定列表数据
	 * @param resultMap
	 * @param pageParam
	 * @param tbaVO
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月16日 下午5:19:24
	 */
	void getBindList(Map<String,Object> resultMap,PageParam pageParam,TelrateBindAccountVO tbaVO);
	
	/**
	 * @description: 话费价格批量绑定所有代理商
	 * @param rootAgencyId
	 * @param tbaVO
	 * @param updateBindState
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月23日 下午5:55:48
	 */
//	int batchBindAllAgency(int rootAgencyId, TelrateBindAccountVO tbaVO, int updateBindState);
	
	/**
	 * @description: 话费价格批量绑定所有代理商
	 * @param billTypeRate
	 * @param rootAgencyId
	 * @param aardto
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月20日 下午3:29:03
	 */
	int batchBindAllTelAgency( int rootAgencyId, TelrateBindAccountVO tbaVO, int updateBindState);
	
}
