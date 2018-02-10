package com.weizu.flowsys.web.activity.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.BusinessOneEnum;
import com.weizu.flowsys.operatorPg.enums.BusinessOperatorEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelUseStateEnum;
import com.weizu.flowsys.operatorPg.enums.LimitPriceEnum;
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ScopeCityEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.util.StringUtil2;
import com.weizu.flowsys.web.activity.ao.ChannelForShowAO;
import com.weizu.flowsys.web.activity.dao.IChannelForShowDao;
import com.weizu.flowsys.web.activity.pojo.ChannelForShowPo;
import com.weizu.flowsys.web.activity.url.ShowRateURL;
import com.weizu.flowsys.web.channel.dao.ChannelChannelDao;
import com.weizu.flowsys.web.channel.pojo.ChannelChannelPo;
import com.weizu.flowsys.web.channel.pojo.ChannelDiscountPo;
import com.weizu.flowsys.web.trade.PurchaseUtil;
import com.weizu.web.foundation.String.StringHelper;

/**
 * @description: 展示通道模块
 * @projectName:weizu-channel
 * @className:ShowRateController.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年12月30日 上午10:43:01
 * @version 1.0
 */
@Controller
@RequestMapping(value=ShowRateURL.MODOE_NAME)
public class ShowRateController {
	@Resource
	private IChannelForShowDao channelForShowDao;
	@Resource
	private ChannelForShowAO channelForShowAO;
	
	@Resource
	private ChannelChannelDao channelChannelDao;
	
	/**
	 * @description:展示通道添加页面
	 * @param request
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月30日 上午10:18:42
	 */
	@RequestMapping(value=ShowRateURL.SHOWRATE_ADD_PAGE)
	public ModelAndView showRateAddPage(HttpServletRequest request,
			@RequestParam(value="channelId",required=false)Long channelId){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		if(channelId != null){
			ChannelChannelPo channelPo = channelChannelDao.getChannelById(channelId);
			ChannelDiscountPo cdPo = channelPo.getDiscountList().get(0);
			Double channelPrice = StringUtil2.getDiscountVO(cdPo.getChannelDiscount());
			String channelPriceS = channelPrice.toString();
			String channelPriceStr = channelPriceS.substring(0, channelPriceS.indexOf("."));
			ChannelForShowPo channelForShowPo = new ChannelForShowPo(cdPo.getScopeCityCode(), cdPo.getServiceType(), cdPo.getOperatorType(), cdPo.getBillType(), channelPrice,channelPriceStr);
			resultMap.put("channelForShowPo", channelForShowPo);
		}
		resultMap.put("serviceTypeEnums", ServiceTypeEnum.toList());
		resultMap.put("scopeCityEnums", ScopeCityEnum.toList());
		resultMap.put("limitPriceEnums", LimitPriceEnum.toList());
		resultMap.put("billTypeEnums", BillTypeEnum.toList());
		resultMap.put("businessOneEnums", BusinessOneEnum.toList());
		return new ModelAndView("/activity/showRate_add_page", "resultMap", resultMap);
	}
	
	/**
	 * @description: 添加展示通道
	 * @param request
	 * @param channelForShowPo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月30日 上午10:15:49
	 */
	@ResponseBody
	@Transactional
	@RequestMapping(value=ShowRateURL.SHOWRATE_ADD)
	public String showRateAdd(HttpServletRequest request,ChannelForShowPo channelForShowPo){
		channelForShowPo.setLastAccess(System.currentTimeMillis());
		//根据商务初始化运营商参数
		String businessMan = channelForShowPo.getBussinessMan();
		Integer operatorType = BusinessOperatorEnum.getValueByDesc(businessMan);
		channelForShowPo.setOperatorType(operatorType);
		
		//初始化折扣
		channelForShowPo.setChannelPrice(StringUtil2.getDiscount(channelForShowPo.getChannelPriceStr()));
		if(StringHelper.isNotEmpty(channelForShowPo.getPrivateRateStr())){
			channelForShowPo.setPrivateRate(StringUtil2.getDiscount(channelForShowPo.getPrivateRateStr()));
		}
		if(StringHelper.isNotEmpty(channelForShowPo.getBillRateStr())){
			channelForShowPo.setBillRate(StringUtil2.getDiscount(channelForShowPo.getBillRateStr()));
		}
		channelForShowPo.setShowRateState(ChannelUseStateEnum.OPEN.getValue());
		int res = channelForShowDao.add(channelForShowPo);
		String result = "error";
		if(res > 0){
			result = "success";
		}
		return result;
	}
	/**
	 * @description:展示通道编辑页面
	 * @param request
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月30日 上午10:18:30
	 */
	@RequestMapping(value=ShowRateURL.SHOWRATE_EDIT_PAGE)
	public ModelAndView showRateEditPage(HttpServletRequest request,Long id){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		ChannelForShowPo channelForShowPo = channelForShowDao.get(id);
		
		
		String channelPriceStr = StringUtil2.getDiscountVO(channelForShowPo.getChannelPrice()).toString();
		channelPriceStr = channelPriceStr.substring(0, channelPriceStr.indexOf("."));
		channelForShowPo.setChannelPriceStr(channelPriceStr);
		if(channelForShowPo.getPrivateRate() != null && channelForShowPo.getPrivateRate() != 1.1d){
			String privateRateStr = StringUtil2.getDiscountVO(channelForShowPo.getPrivateRate()).toString();
			privateRateStr = privateRateStr.substring(0, privateRateStr.indexOf("."));
			channelForShowPo.setPrivateRateStr(privateRateStr);
		}
		if(channelForShowPo.getBillRate() != null && channelForShowPo.getBillRate() != 1.1d){
			String billRateStr = StringUtil2.getDiscountVO(channelForShowPo.getBillRate()).toString();
			billRateStr = billRateStr.substring(0, billRateStr.indexOf("."));
			channelForShowPo.setBillRateStr(billRateStr);
		}
		
		resultMap.put("channelForShowPo", channelForShowPo);
		resultMap.put("serviceTypeEnums", ServiceTypeEnum.toList());
		resultMap.put("scopeCityEnums", ScopeCityEnum.toList());
		resultMap.put("limitPriceEnums", LimitPriceEnum.toList());
		resultMap.put("billTypeEnums", BillTypeEnum.toList());
		resultMap.put("businessOneEnums", BusinessOneEnum.toList());
		return new ModelAndView("/activity/showRate_add_page", "resultMap", resultMap);
	}
	
	/**
	 * @description: 展示通道更新
	 * @param request
	 * @param channelForShowPo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月30日 上午10:15:49
	 */
	@ResponseBody
	@RequestMapping(value=ShowRateURL.SHOWRATE_EDIT)
	public String showRateEdit(HttpServletRequest request,ChannelForShowPo channelForShowPo){
		channelForShowPo.setLastAccess(System.currentTimeMillis());
		//根据商务初始化运营商参数
		String businessMan = channelForShowPo.getBussinessMan();
		Integer operatorType = BusinessOperatorEnum.getValueByDesc(businessMan);
		channelForShowPo.setOperatorType(operatorType);
		
		//初始化折扣
		channelForShowPo.setChannelPrice(StringUtil2.getDiscount(channelForShowPo.getChannelPriceStr()));
		if(StringHelper.isNotEmpty(channelForShowPo.getPrivateRateStr())){
			channelForShowPo.setPrivateRate(StringUtil2.getDiscount(channelForShowPo.getPrivateRateStr()));
		}else{
			channelForShowPo.setPrivateRate(1.1D);
		}
		if(StringHelper.isNotEmpty(channelForShowPo.getBillRateStr())){
			channelForShowPo.setBillRate(StringUtil2.getDiscount(channelForShowPo.getBillRateStr()));
		}else{
			channelForShowPo.setBillRate(1.1d);
		}
		int res = channelForShowDao.updateLocal(channelForShowPo);
		String result = "error";
		if(res > 0){
			result = "success";
		}
		return result;
	}
	/**
	 * @description: 删除流量展示通道
	 * @param request
	 * @param id
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月30日 上午10:16:47
	 */
	@ResponseBody
	@RequestMapping(value=ShowRateURL.DEL_SHOWRATE)
	public String delShowRate(HttpServletRequest request,Long id){
		int res = channelForShowDao.del(id);
		String result = "error";
		if(res > 0){
			result = "success";
		}
		return result;
	}
	/**
	 * @description: 更新展示通道维护状态
	 * @param request
	 * @param id
	 * @param showRateState
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月2日 下午4:46:38
	 */
	@Transactional
	@ResponseBody
	@RequestMapping(value=ShowRateURL.UPDATE_SHOWRATE_STATE)
	public String updateShowRate(HttpServletRequest request,Long id, Integer showRateState){
		int res = channelForShowDao.updateLocal(new ChannelForShowPo(id, showRateState,System.currentTimeMillis()));
		String result = "error";
		if(res > 0){
			result = "success";
		}
		return result;
	}
	
	/**
	 * @description: 展示通道列表
	 * @param channelForShowPo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月30日 上午10:36:13
	 */
	@RequestMapping(value=ShowRateURL.SHOWRATE_LIST)
	public ModelAndView listShowRate(ChannelForShowPo channelForShowPo,@RequestParam(value="showModel",required=false)Integer showModel){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		List<ChannelForShowPo> showRateList = channelForShowAO.listShowRate(channelForShowPo);
		resultMap.put("showRateList", showRateList);
		resultMap.put("operatorTypeEnums", OperatorTypeEnum.toList());
		resultMap.put("searchParam", channelForShowPo);
		resultMap.put("serviceTypeEnums", ServiceTypeEnum.toList());
		resultMap.put("scopeCityEnums", ScopeCityEnum.toList());
		resultMap.put("limitPriceEnums", LimitPriceEnum.toList());
		resultMap.put("billTypeEnums", BillTypeEnum.toList());
		resultMap.put("businessOneEnums", BusinessOneEnum.toList());
		resultMap.put("channelUseStateEnums", ChannelUseStateEnum.toList());
		
		resultMap.put("showModel", showModel);
		return new ModelAndView("/activity/showRate_list", "resultMap", resultMap);
	}
}
