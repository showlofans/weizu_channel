package com.weizu.flowsys.util;

import java.util.List;

/**
 * 分页工具类
 * @author ydc
 *
 * @param <T>
 */
public class Pagination<T> {
	// 以下4个属性必须指定
	private List<T> records;	// 分页数据
	private int totalRecord;	// 总记录数
	private int pageNo;			// 当前页码,第几页
	private int pageSize;		// 每页显示的记录数,每页显示多少条数据
	
	private int totalPage;		// 总页数
	
	private int startIndex;		// 开始索引
	private int endIndex;		// 结束索引
	
	private int indexCount = 10;// 显示的索引数目,如:10的话， 则显示1-10， 2-11
	
	// public Pagination() {}
	
	public Pagination(List<T> records, int totalRecord, int pageNo, int pageSize) {
		this.records = records;
		this.totalRecord = totalRecord;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		// 根据总记录数和每页显示数计算总页数(totalRecord+pageSize->totalPage)
		totalPage = this.totalRecord / this.pageSize;
		//当总数小与pageSize的时候，将计算出来的0改为1
		totalPage = (this.totalRecord % pageSize == 0) ? totalPage : (totalPage + 1);
		// 根据索引数目，当前页，总页数计算开始索引和结束索引(indexCount+pageNo+totalPage->startIndex+endIndex)
		startIndex = indexCount/2;
		startIndex = pageNo - (indexCount%2 == 0 ? (startIndex - 1) : startIndex);
		endIndex = pageNo + indexCount/2;
		// 1 <= startIndex < pageNo < endIndex <= totalPage
		// startIndex = pageNo - indexCount/2
		// endIndex = pageNo + indexCount/2
		if(startIndex < 1) {
			startIndex = 1;
			if(totalPage >= indexCount) {
				endIndex = indexCount;
			}  else {
				endIndex = totalPage;
			}
		}
		if(endIndex > totalPage) {
			endIndex = totalPage;
			if(endIndex > indexCount) {
				startIndex = endIndex - indexCount + 1;
			} else {
				startIndex = 1;
			}
		}
	}
	
	
	/**
	 * 获取分页数据
	 * @return
	 */
	public List<T> getRecords() {
		return records;
	}

	/**
	 * 获取总记录数
	 * @return
	 */
	public int getTotalRecord() {
		return totalRecord;
	}

	/**
	 * 当前页数(第几页)
	 * @return
	 */
	public int getPageNo() {
		return pageNo;
	}
	
	/**
	 * 每页显示数据记录数
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}
	
	/**
	 * 总页数
	 * @return
	 */
	public int getTotalPage() {
		return totalPage;
	}

	/**
	 * 起始索引
	 * @return
	 */
	public int getStartIndex() {
		return startIndex;
	}

	/**
	 * 结束索引
	 * @return
	 */
	public int getEndIndex() {
		return endIndex;
	}
	/****************************************************************/
	/************************get/set方法******************************/
	/****************************************************************/

	public int getIndexCount() {
		return indexCount;
	}
	
	public void setIndexCount(int indexCount) {
		this.indexCount = indexCount;
	}
}

