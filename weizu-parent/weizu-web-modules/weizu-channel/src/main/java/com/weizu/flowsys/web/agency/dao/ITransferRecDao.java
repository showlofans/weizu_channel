package com.weizu.flowsys.web.agency.dao;

import java.util.List;
import java.util.Map;

import com.weizu.flowsys.core.dao.Dao;
import com.weizu.flowsys.web.agency.pojo.TransferRecordPo;
import com.weizu.flowsys.web.agency.pojo.TransferRecordVO;

public interface ITransferRecDao extends Dao<TransferRecordPo, Long> {
	
	/**
	 * @description: 获得转入转出记录
	 * @param params
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月12日 下午12:43:22
	 */
	List<TransferRecordVO> getInOutRecord(Map<String,Object> params);
	
	/**
	 * @description: 获得转入转出总记录数
	 * @param params
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月12日 下午3:24:42
	 */
	Long countInOutRecord(Map<String,Object> params);
}
