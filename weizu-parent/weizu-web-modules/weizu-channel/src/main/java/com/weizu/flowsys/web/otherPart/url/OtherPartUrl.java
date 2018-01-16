package com.weizu.flowsys.web.otherPart.url;

import com.weizu.flowsys.web.base.BaseURL;

/**
 * @description: 系统其他部分
 * @projectName:weizu-channel
 * @className:OtherPartUrl.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年1月16日 下午4:25:41
 * @version 1.0
 */
public class OtherPartUrl extends BaseURL {
	/**
	 * 系统其他部分模块
	 */
	public static final String MODEL_NAME="/flowsys/otherPart";
	
	/**
	 * 服务器文件系统
	 * <br>/flowsys/otherPart/server_file_log.do
	 */
	public static final String SERVER_FILE_LOG = "/server_file_log" + DYNAMIC_WEB_SUFFIX;
	
	/**
	 *笑话接口
	 *  <br>/flowsys/otherPart/rand_joke_list.do
	 */
	public static final String RAND_JOKE_LIST = "/rand_joke_list" + DYNAMIC_WEB_SUFFIX;
}
