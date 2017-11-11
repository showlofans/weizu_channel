package com.weizu.flowsys.web.channel.ao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.channel.dao.ITelProductDao;
import com.weizu.flowsys.web.channel.pojo.ProductCodePo;
import com.weizu.flowsys.web.channel.pojo.TelProductPo;
import com.weizu.web.foundation.String.StringHelper;

/**
 * @description: 话费编码接口实现类
 * @projectName:weizu-channel
 * @className:TelProductAOImpl.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年11月11日 下午3:27:15
 * @version 1.0
 */
@Service(value="telProductAO")
public class TelProductAOImpl implements TelProductAO {

	@Resource
	private ITelProductDao telProductDao;
	
	@Override
	public List<TelProductPo> listParamsProductPo(TelProductPo telPo) {
		WherePrams whereParams = initWhereParams(telPo);
		List<TelProductPo> listTel = telProductDao.list(whereParams);
		return listTel;
	}
	
	/**
	 * @description: 根据实体获得查询参数
	 * @param telPo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月11日 下午3:17:57
	 */
//	private Map<String, Object> getParamsByPo(TelProductPo telPo){
//		Map<String, Object> params = new HashMap<String, Object>();
//		if(telPo.getEpId() != null){
//			params.put("epId", telPo.getEpId());
//		}
//		if(telPo.getChargeSpeed() != null){
//			params.put("chargeSpeed", telPo.getChargeSpeed());
//		}
//		if(telPo.getServiceType() != null){
//			params.put("serviceType", telPo.getServiceType());
//		}
//		if(telPo.getOperatorName() != null){
//			params.put("operatorName", telPo.getOperatorName());
//		}
//		if(StringHelper.isNotEmpty(telPo.getCityid())){
//			params.put("cityid", telPo.getCityid());
//		}
//		if(telPo.getFreeCharge()){
//			params.put("freeCharge", telPo.getFreeCharge().booleanValue());
//		}
//		return params;
//	}
	
	public WherePrams getWhereByPo(TelProductPo telPo){
		WherePrams where = new WherePrams("1", "=", 1);
		if(telPo.getChargeSpeed() != null){
			where.and("charge_speed", "=", telPo.getChargeSpeed());
		}
		if(telPo.getServiceType() != null){
			where.and("service_type", "=", telPo.getServiceType());
		}
		if(telPo.getOperatorName() != null){
			where.and("operator_name", "=", telPo.getOperatorName());
		}
		if(StringHelper.isNotEmpty(telPo.getCityid())){
			where.and("cityid", "=", telPo.getCityid());
		}
		if(telPo.getFreeCharge() != null){
			where.and("free_charge", "=", telPo.getFreeCharge().booleanValue());
		}
		if(telPo.getEpId() != null){
			where.and("ep_id", "=", telPo.getEpId());
		}
		if(StringHelper.isNotEmpty(telPo.getEpName())){
			where.and("ep_name", "like", telPo.getEpName());
		}
		if(telPo.getEpId() != null){
			where.and("charge_value", "=", telPo.getChargeValue());
		}
		
		return where;
	}
	
	/**
	 * @description: 初始化dao查询参数
	 * @param telPo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月11日 下午3:42:49
	 */
	private WherePrams initWhereParams(TelProductPo telPo){
		WherePrams where = null;
		if(telPo.getEpId() != null){
			where = new WherePrams("ep_id", "=", telPo.getEpId());
			if(telPo.getChargeSpeed() != null){
				where.and("charge_speed", "=", telPo.getChargeSpeed());
			}
			if(telPo.getServiceType() != null){
				where.and("service_type", "=", telPo.getServiceType());
			}
			if(telPo.getOperatorName() != null){
				where.and("operator_name", "=", telPo.getOperatorName());
			}
			if(StringHelper.isNotEmpty(telPo.getCityid())){
				where.and("cityid", "=", telPo.getCityid());
			}
			if(telPo.getFreeCharge()){
				where.and("free_charge", "=", telPo.getFreeCharge());
			}
		}
		return where;
	}

	@Override
	public String addTelProduct(TelProductPo telPo) {
		String result = "error";
		WherePrams where = getWhereByPo(telPo);
		Long resNum = telProductDao.count(where);
		if(resNum > 0){
			result = "exist";
		}else{
			int res = telProductDao.add(telPo);
			if(res > 0){
				result = "success";
			}
		}
		return result;
	}

	@Override
	public Pagination<TelProductPo> listTelProduct(TelProductPo telPo, PageParam pageParam) {
		WherePrams where = getWhereByPo(telPo);
		long toatalRecord = telProductDao.count(where);
		int pageSize = 10;
		Long pageNo = 1l;
		if(pageParam != null){
			pageSize = pageParam.getPageSize();
			pageNo = pageParam.getPageNoLong();
			long startLongNum = (pageNo-1)*pageSize;
			where.limit(startLongNum, pageSize);
		}
		List<TelProductPo> records = telProductDao.list(where);
		return new Pagination<TelProductPo>(records, toatalRecord, pageNo, pageSize);
//			paramsMap.put("start", (pageNo-1)*pageSize);
//			paramsMap.put("end", pageSize);
	}
}
