package com.weizu.flowsys.core.beans;

import com.weizu.flowsys.core.annotation.po.TempField;



/**
 * POԼ����
 * @author ��ʤ��
 * @time 2016��5��3������2:51:21
 * @email 719348277@qq.com
 */
public class Po {
//	@TempField
	private Long lastAccess;			//最后更新时间

	public Long getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(Long lastAccess) {
		this.lastAccess = lastAccess;
	}
	
}
