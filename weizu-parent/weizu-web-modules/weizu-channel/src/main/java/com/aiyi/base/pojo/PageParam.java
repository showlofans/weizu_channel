package com.aiyi.base.pojo;

/**
 * @description:分页查询参数
 * @projectName:crud
 * @className:PageParam.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月5日 下午2:45:17
 * @version 1.0
 */
public class PageParam {
	private int pageNo;			// 当前页码,第几页
	private int pageSize;		// 每页显示的记录数,每页显示多少条数据
	public PageParam() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageParam(int pageNo, int pageSize) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
