package com.weizu.flowsys.web.base;

import java.lang.reflect.Field;

public class BaseURL
{
	public static final String DYNAMIC_WEB_SUFFIX = ".do";

	/**
	 * @description: 根据url静态变量名取url值
	 * @param urlName
	 * @return
	 * @author： zhangyf
	 * @createTime：2015年7月1日 上午10:32:22
	 */
	public String getURL(String urlName)
	{
		String url = "";

		try
		{
			Field f = this.getClass().getField(urlName);

			url = f.get(null).toString();
		}
		catch (Exception e)
		{
			url = "";
		}

		return url;
	}
}
