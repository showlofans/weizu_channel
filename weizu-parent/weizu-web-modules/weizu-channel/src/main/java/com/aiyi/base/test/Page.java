package com.aiyi.base.test;

public class Page {
	private int numPerPage = 5; // 页大小

	private int totalRows; // 总记录数

	private int totalPages; // 总页数

	private int currentPage; // 起始页

	private int startIndex; // 起始行数

	private int lastIndex; // 结束行数

	private boolean hasNext; // 是否有下一页

	private boolean hasPrev; // 是否有上一页

	private int offset = 0; // 偏移量

	private String baseUrl = ""; // 转向的地址

	public Page() {
	}

	public Page(int currentPage, int totalRows) {
		init(this.numPerPage, currentPage, totalRows, 0);
	}

	public Page(int currentPage, int totalRows, int numPerPage) {
		init(numPerPage, currentPage, totalRows, 0);
	}

	public Page(int currentPage, int totalRows, int numPerPage, int offset) {
		init(numPerPage, currentPage, totalRows, offset);
	}

	// 初始化Page
	private void init(int numPerPage, int currentPage, int totalRows, int offset) {
		this.numPerPage = numPerPage;
		this.currentPage = currentPage;
		this.totalRows = totalRows;
		this.offset = offset;
		this.setTotalPages();
		this.setHasNext();
		this.setHasPrev();
		this.setStartIndex();
		this.setLastIndex();
	}

	// 构造分页导航条 最后的字符串显示到页面上
	public String getNav() {
		String navStr = "";
		if (this.isHasPrev()) {
			navStr += "<a href=/" + this.getBaseUrl() + "&pageNum="
					+ (this.getCurrentPage() - 1) + "/>上一页" + "</a> ";

		}
		if (this.hasNext) {
			navStr += "<a href=/" + this.getBaseUrl() + "&pageNum="
					+ (this.getCurrentPage() + 1) + "/>下一页" + "</a> ";
		}
		if (this.getTotalPages() > 0) {
			navStr += "第" + this.getCurrentPage() + "页/共"
					+ this.getTotalPages() + "页";
		}
		return navStr;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages() {
		if (totalRows % numPerPage == 0) { // 正好n页
			totalPages = totalRows / numPerPage;
		} else {
			totalPages = totalRows / numPerPage + 1;
		}

		if (currentPage > totalPages) {
			if (totalPages > 0) {
				currentPage = totalPages;
			} else {
				currentPage = 1;
			}
		}

		if (currentPage < 1) {
			currentPage = 1;
		}
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex() {
		startIndex = (currentPage - 1) * numPerPage + 1;
	}

	public int getLastIndex() {
		return lastIndex;
	}

	public void setLastIndex() {
		lastIndex = currentPage * numPerPage;
		// lastIndex=startIndex+numPerPage-1
		if (lastIndex > totalRows) {
			lastIndex = totalRows;
		}
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public void setHasNext() {
		if (totalPages > currentPage) {
			hasNext = true;
		} else {
			hasNext = false;
		}
	}

	public boolean isHasPrev() {
		return hasPrev;
	}

	public void setHasPrev() {
		if (currentPage > 1) {
			hasPrev = true;
		} else {
			hasPrev = false;
		}
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	// 设置“上一页”“下一页”转向的地址。url:请求项目名，param:请求参数（名值对）

	/**
	 * @description:如果参数末尾的参数是pageNum就直接去掉
	 * @param url
	 * @param param：其他查询参数（避免使用pageNum的参数-函数的保留参数）
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月4日 下午6:01:45
	 */
	public void setBaseUrl(String url, String param) {
		int index = param.indexOf("pageNum") - 1;
		System.out.println(index);
		if (index > 0) {
			// 清除先前的页面参数对，这里只处理页面信息在参数串末尾的情况。
			param = param.substring(0, index);
		}
		this.baseUrl = url + "?" + param;
	}
//	public static void main(String[] args) {
//		Page page = new Page(2, 50, 10);//原始页
////		page.setBaseUrl("http://blog.csdn.net/u013410747/article/details/48622293", "fds=78");
////		System.out.println("nav:"+page.getNav());
////		page.setCurrentPage(3);//翻了一页
////		System.out.println("nav:"+page.getNav());
//		page.setBaseUrl("http://blog.csdn.net/u013410747/article/details/48622293", "fds=78&pageNum=10");
//		System.out.println("nav:"+page.getNav());
//		page.setCurrentPage(3);//翻了一页
//		System.out.println("nav:"+page.getNav());
//	}

}
