package com.aiyi.base.pojo;

/**
 * @description:分页基本信息
 * @projectName:crud
 * @className:PageTag.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月5日 上午9:40:15
 * @version 1.0
 */
public class PageTag {
	private int pageIndex;// 当前页数
	private int totalPage;// 总页数
	private int pageSize = 10;// 每页条数
	private int totalRows;// 总条数
	
	
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
		setTotalPage();
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage() {
		if (totalRows % pageSize == 0) { // 正好n页
			totalPage = totalRows / pageSize;
		} else {
			totalPage = totalRows / pageSize + 1;
		}

		if (pageIndex > totalPage) {
			if (totalPage > 0) {
				pageIndex = totalPage;
			} else {
				pageIndex = 1;
			}
		}

		if (pageIndex < 1) {
			pageIndex = 1;
		}
	
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
