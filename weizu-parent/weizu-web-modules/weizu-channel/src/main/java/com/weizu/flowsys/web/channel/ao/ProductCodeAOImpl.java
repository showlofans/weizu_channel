package com.weizu.flowsys.web.channel.ao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.operatorPg.enums.ScopeCityEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.channel.dao.IProductCodeDAO;
import com.weizu.flowsys.web.channel.dao.impl.OperatorPgDao;
import com.weizu.flowsys.web.channel.pojo.OneCodePo;
import com.weizu.flowsys.web.channel.pojo.OperatorPgDataPo;
import com.weizu.flowsys.web.channel.pojo.ProductCodePo;
import com.weizu.web.foundation.String.StringHelper;

/**
 * @description:产品编码业务层接口实现类
 * @projectName:crud
 * @className:ProductCodeAOImpl.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月8日 上午11:50:50
 * @version 1.0
 */
@Service(value="productCodeAO")
public class ProductCodeAOImpl implements ProductCodeAO {

	@Resource
	private IProductCodeDAO productCodeDAO;
//	@Resource
//	private OperatorPgAO operatorPgAO;
	@Resource
	private OperatorPgDao operatorPgDao;
	
	/**
	 * @description:获得产品编码列表
	 * @param productCodePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月8日 上午11:50:32
	 */
	@Override
	public Pagination<ProductCodePo> getProductCode(ProductCodePo productCodePo,PageParam pageParam) {
		Map<String, Object> paramsMap = getMapByEntity(productCodePo);
		int toatalRecord = productCodeDAO.countProductCode(paramsMap);
		int pageSize = 10;
		int pageNo = 1;
		if(pageParam != null){
			pageSize = pageParam.getPageSize();
			pageNo = pageParam.getPageNo();
			paramsMap.put("start", (pageNo-1)*pageSize);
			paramsMap.put("end", pageSize);
		}
		List<ProductCodePo> records = productCodeDAO.getProductCode(paramsMap);
		
		return new Pagination<ProductCodePo>(records, toatalRecord, pageNo, pageSize);
	}

	/**
	 * @description:封装查询编码参数
	 * @param productCodePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月8日 下午12:07:40
	 */
	private Map<String, Object> getMapByEntity(ProductCodePo productCodePo) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
				
		if(productCodePo != null){
			/*if(productCodePo.getEpId() != null){
				paramsMap.put("epId", productCodePo.getEpId());
			}*/
			if(productCodePo.getOperatorType() != null){
				paramsMap.put("operatorType", productCodePo.getOperatorType());
			}
			if(productCodePo.getServiceType() != null){
				paramsMap.put("serviceType", productCodePo.getServiceType());
			}
			if(productCodePo.getPgSize() != null){
				paramsMap.put("pgSize", productCodePo.getPgSize());
			}
			if(StringHelper.isNotEmpty(productCodePo.getEpName())){
				paramsMap.put("epName", productCodePo.getEpName());
			}
			if(productCodePo.getCirculateWay() != null)
			{
				paramsMap.put("circulateWay", productCodePo.getCirculateWay());
			}
			if(productCodePo.getPgType() != null)
			{
				paramsMap.put("pgType", productCodePo.getPgType());
			}
			if(StringHelper.isNotEmpty(productCodePo.getPgValidity()))
			{
				paramsMap.put("pgValidity", productCodePo.getPgValidity());
			}
			if(StringHelper.isNotEmpty(productCodePo.getProductName())){
				paramsMap.put("productName", productCodePo.getProductName());
			}
			if(StringHelper.isNotEmpty(productCodePo.getProductCode())){
				paramsMap.put("productCode", productCodePo.getProductCode());
			}
			if(StringHelper.isNotEmpty(productCodePo.getScopeCityCode())){
				paramsMap.put("scopeCityCode", productCodePo.getScopeCityCode());
			}
			
		}
		return paramsMap;
	}

	/**
	 * @description: 通过流量类型和运营商类型获得流量列表
	 * @param operatorType
	 * @param serviceType
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月9日 上午10:13:31
	 */
	@Override
	public List<OperatorPgDataPo> initPgList(OneCodePo pgCodeParams) {
//		OperatorPgDataPo operatorPgPo = new OperatorPgDataPo();
//		operatorPgPo.setOperatorType(operatorType);
//		operatorPgPo.setServiceType(serviceType);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("serviceType", pgCodeParams.getServiceType());
		params.put("operatorType", pgCodeParams.getOperatorType());
		params.put("pgType", pgCodeParams.getPgType());
		params.put("circulateWay", pgCodeParams.getCirculateWay());
		params.put("pgValidity", pgCodeParams.getPgValidity());
		params.put("epId", pgCodeParams.getEpId());
		params.put("scopeCityCode", pgCodeParams.getScopeCityCode());
		
		List<OperatorPgDataPo> pgList = operatorPgDao.listPgListNotInPcode(params);
		return pgList;
	}
	

	/**
	 * @description: 添加产品编码
	 * @param productCodePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月9日 上午11:52:21
	 */
	@Transactional
	@Override
	public String addProduct(ProductCodePo productCodePo) {
		String pName = initProductName(productCodePo);
		productCodePo.setProductName(pName);
		
		int result = productCodeDAO.add(productCodePo);
		if(result > 0){
			return "success";
		}else{
			return "error";
		}
	}

	/**
	 * @description:生成编码名称
	 * @param productCodePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月9日 下午12:08:04
	 */
	private String initProductName(ProductCodePo productCodePo) {
		StringBuffer resub = new StringBuffer();
		
		
//		for (Map<String,Object> map : ScopeCityEnum.toList()) {
//			if(productCodePo.getScopeCityCode().equals(map.get("value").toString())){
//				resub.append(map.get("desc").toString());
//				break;
//			}
//		}
//		for (Map<String,Object> map : OperatorTypeEnum.toList()) {
//			int operatorType = Integer.parseInt(map.get("value").toString());
//			if(productCodePo.getOperatorType() == operatorType){
//				resub.append(map.get("desc").toString());
//				break;
//			}
//		}
		return resub.toString();
		
	}

	/**
	 * @description: 该编码是否在该通道已经创建
	 * @param epId
	 * @param productCode
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月9日 下午5:19:17
	 */
	@Override
	public boolean existProductCode(ProductCodePo productCodePo) {
		if(productCodeDAO.existProductCode(productCodePo) > 0){
			return false;
		}
		return true;
	}

	/**
	 * @description: 通过参数查询一个产品编码
	 * @param productCodeParams
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月10日 下午6:06:46
	 */
	@Override
	public ProductCodePo getOneProductCode(OneCodePo paramsPo) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		if(paramsPo.getPgId() != null){
			paramsMap.put("pgId", paramsPo.getPgId());
		}else{
			paramsMap.put("operatorType", paramsPo.getOperatorType());
			paramsMap.put("serviceType", paramsPo.getServiceType());
			paramsMap.put("pgSize", paramsPo.getPgSize());
			paramsMap.put("pgType", paramsPo.getPgType());
			paramsMap.put("pgValidity", paramsPo.getPgValidity());
			paramsMap.put("circulateWay", paramsPo.getCirculateWay());
		}
		paramsMap.put("scopeCityCode", paramsPo.getScopeCityCode());
		paramsMap.put("epId", paramsPo.getEpId());
		return productCodeDAO.getOneProductCode(paramsMap);
	}

	/**
	 * @description: 删除产品编码
	 * @param codeId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月1日 下午3:42:18
	 */
	@Transactional
	@Override
	public int deleteProductCode(String codeId) {
		Long id = Long.parseLong(codeId);
		return productCodeDAO.del(id);
	}

}
