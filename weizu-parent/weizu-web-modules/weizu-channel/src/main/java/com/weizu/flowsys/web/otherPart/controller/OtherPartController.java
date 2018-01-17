package com.weizu.flowsys.web.otherPart.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.weizu.flowsys.web.base.SystemInfo;
import com.weizu.flowsys.web.otherPart.url.OtherPartUrl;
import com.weizu.flowsys.web.trade.PurchaseUtil;

@Controller
@RequestMapping(value=OtherPartUrl.MODEL_NAME)
public class OtherPartController {

	/**
	 * @description: 服务器文件系统查看
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月16日 下午5:30:07
	 */
	@RequestMapping(value=OtherPartUrl.SERVER_FILE_LOG)
	public ModelAndView getOtherPart(){
		Map<String,Object> resultMap = new HashMap<String, Object>();
		try {
			List<Map<String,Object>> mapList = SystemInfo.file();
			resultMap.put("systemFileList", mapList);
			List<Map<String,Object>> map = PurchaseUtil.getJokeForNow("http://v.juhe.cn/joke/content/text.php?key=3163fa316ed3ffd2eb0be5340b1f11cd");
			resultMap.put("jokeContentMapList", map);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView("/otherPart/otherPart", "resultMap", resultMap);
	}
}
