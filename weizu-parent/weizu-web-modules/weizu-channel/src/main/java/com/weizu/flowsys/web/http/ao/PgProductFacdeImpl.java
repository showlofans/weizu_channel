package com.weizu.flowsys.web.http.ao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.weizu.api.outter.enums.ChargeStatusEnum;

import com.weizu.flowsys.api.weizu.charge.PgProductParams;
import com.weizu.flowsys.api.weizu.facet.IPgProductFacet;
import com.weizu.flowsys.operatorPg.enums.BindStateEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelUseStateEnum;
import com.weizu.flowsys.operatorPg.enums.ScopeCityEnum;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
import com.weizu.flowsys.web.channel.dao.OperatorPgDaoInterface;
import com.weizu.flowsys.web.http.entity.PgProduct;
import com.weizu.flowsys.web.http.entity.PgProductPo;

@Service("pgProductFacdeImpl")
public class PgProductFacdeImpl implements IPgProductFacet {

	@Resource
	private ValiUser valiUser;
	
	@Resource
	private OperatorPgDaoInterface operatorPgDao;
	
	@Override
	public PgProduct getPgProductList(PgProductParams pgParams) {
		PgProduct pgProduct = null;
		ChargeStatusEnum chargeEnum = null;
		
		AgencyBackwardPo backPo = valiUser.findAgency(pgParams.getUserName(), pgParams.getSign());
		//充值用户不合法
		if(backPo == null)
		{
			chargeEnum = ChargeStatusEnum.AUTHENTICATION_FAILURE;
			pgProduct = new PgProduct(chargeEnum.getValue(),chargeEnum.getDesc() , null);
			return pgProduct;
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("agencyId", backPo.getId());
		map.put("bindState", BindStateEnum.BIND.getValue());
		map.put("channelUseState", ChannelUseStateEnum.OPEN.getValue());
		
		List<PgProductPo> pgList = operatorPgDao.getProductPgList(map);
		if(pgList == null || pgList.size() == 0){
			chargeEnum = ChargeStatusEnum.SCOPE_RATE_UNDEFINED;
		}else{
			chargeEnum = ChargeStatusEnum.CHARGE_SUCCESS;
			for (PgProductPo pgProductPo : pgList) {
				ScopeCityEnum scopeEnum = ScopeCityEnum.getEnum(pgProductPo.getScopeCityCode());
				if(scopeEnum != null){
					pgProductPo.setScopeCityName(scopeEnum.getDesc());
				}
			}
		}
		pgProduct = new PgProduct(chargeEnum.getValue(),chargeEnum.getDesc() , pgList);
		return pgProduct;
	}

}
