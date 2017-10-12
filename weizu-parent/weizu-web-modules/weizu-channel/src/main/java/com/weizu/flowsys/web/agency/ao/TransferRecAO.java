package com.weizu.flowsys.web.agency.ao;

import java.util.List;
import java.util.Map;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.web.agency.pojo.TransferRecordPo;

/**
 * @description: 银行卡转账接口
 * @projectName:weizu-channel
 * @className:TransferRecAO.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年10月12日 上午11:14:45
 * @version 1.0
 */
public interface TransferRecAO {
	/**
	 * @description: 添加转账记录
	 * @param transferPo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月12日 上午11:15:12
	 */
	String transferBank(TransferRecordPo transferPo);
	
	/**
	 * @description: 根据银行卡，查询银行卡的转账记录
	 * @param bankId
	 * @param direction
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月12日 上午11:48:29
	 */
	void getTransferRec(Long bankId, Integer direction,PageParam pageParam, Map<String,Object> resultMap);
	
	/**
	 * @description: 转账审核
	 * @param id
	 * @param confirmState
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月12日 下午5:40:01
	 */
	String confirmTransfer(Long id, Integer confirmState);
	
	/**
	 * @description: 根据代理商id找到未审核转账列表
	 * @param to_agency_id
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月12日 下午6:25:49
	 */
	List<Map<String,Object>> getMapList(Integer to_agency_id);
}
