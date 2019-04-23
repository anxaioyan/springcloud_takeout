package com.jk.utils;

import java.io.Serializable;

public class PageUtil implements Serializable {

	public static final String PAGENAME = "page";
	private static final int defaultPageSize = 3;
	private static final long serialVersionUID = 8942813253131864133L;

	private Integer start;			//开始条数
	private Integer currentPage;	//当前页
	private Integer pageSize;		//每页展示条数
	private Integer totalPage;		//总页数
	private Integer totalCount;		//总条数
	
	public Integer getStart() {
		if(start == null) {
			start = 0;
		}
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getCurrentPage() {
		//设置当前页的默认值
		if(currentPage == null){
			this.currentPage = 1;
		}
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
		if(currentPage > 0) {
			this.start = (currentPage - 1) * pageSize;			
		}
	}

	public Integer getPageSize() {
		//设置每页条数的默认值
		if(pageSize == null){
			pageSize = defaultPageSize;
		}
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}


	public Integer getTotalPage() {
		if(totalPage == null) {
			this.totalPage = 1;
		}
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotalCount() {
		if(totalCount == null) {
			this.totalCount = 0;
		}
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
		if(totalCount > 0) {
			this.totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;			
		}else {
			this.totalPage = 1;
		}
	}	
	
	/**
	 * 第一个参数：currentPage，第二个参数：pageSize
	 * @param currentPage
	 * @param pageSize
	 */
	public PageUtil(String currentPage, String pageSize) {
		super();
		if(pageSize != null && !"".equals(pageSize.trim())) {
			try {
				this.pageSize = Integer.parseInt(pageSize);				
			} catch (Exception e) {
				this.pageSize = defaultPageSize;
			}
		}else {
			this.pageSize = defaultPageSize;
		}
		if(currentPage != null && !"".equals(currentPage.trim())) {
			try {
				this.currentPage = Integer.parseInt(currentPage);				
			} catch (Exception e) {
				this.currentPage = 1;
			}
		}else {
			this.currentPage = 1;
		}
		if(this.currentPage > 0) {
			this.start = (this.currentPage - 1) * this.pageSize;			
		}
	}

	@Override
	public String toString() {
		return "PageUtil [start=" + start + ", currentPage=" + currentPage + ", pageSize=" + pageSize + ", totalPage="
				+ totalPage + ", totalCount=" + totalCount + "]";
	}

	
}
