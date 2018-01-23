package com.weizu.flowsys.web.system_base.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.weizu.flowsys.web.system_base.ao.SystemConfAO;
import com.weizu.flowsys.web.system_base.dao.SystemConfDaoInterface;
import com.weizu.flowsys.web.system_base.pojo.SystemConfPo;
import com.weizu.flowsys.web.system_base.url.SystemConfURL;

@Controller
@RequestMapping(value=SystemConfURL.MODEL_NAME)
public class SystemConfController {
	
	@Resource
	private SystemConfDaoInterface systemConfDao;
	@Resource
	private SystemConfAO systemConfAO;
	
	/**
	 * @description: 获得参数列表
	 * @param systemConfPo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月23日 下午3:24:13
	 */
	@RequestMapping(value=SystemConfURL.SYSTEMCONF_LIST)
	public ModelAndView getConf(SystemConfPo systemConfPo){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("params", systemConfPo);
		List<SystemConfPo> list = systemConfAO.getConf(systemConfPo);
		resultMap.put("confList", list);
		return new ModelAndView("/system_conf/systemConf_list", "resultMap", resultMap);
	}
	
	/**
	 * @description: 系统参数配置页面 
	 * @param id
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月23日 下午4:06:04
	 */
	@RequestMapping(value=SystemConfURL.SYSTEMCONF_EDIT_PAGE)
	public ModelAndView editConfPage(Integer id){
//		Map<String,Object> resultMap = new HashMap<String,Object>();
		SystemConfPo systemConfPo = systemConfDao.get(id);
//		resultMap.put("systemConfPo", systemConfPo);
		return new ModelAndView("/system_conf/systemConf_edit_page", "systemConfPo", systemConfPo);
	}
	
	/**
	 * @description: 系统参数配置
	 * @param systemConfPo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月23日 下午4:05:48
	 */
	@Transactional
	@ResponseBody
	@RequestMapping(value=SystemConfURL.SYSTEMCONF_EDIT)
	public String editConf(SystemConfPo systemConfPo){
		Integer i = systemConfDao.updateLocal(systemConfPo);
		String res = "error";
		if(i > 0){
			res = "success";
		}
		return res;
	}
	
}
