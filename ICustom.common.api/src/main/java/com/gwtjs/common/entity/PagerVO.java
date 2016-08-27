package com.gwtjs.common.entity;

import javax.xml.bind.annotation.XmlTransient;


/**
 * 分页组件
 * 
 * @author aGuang
 *
 */
public class PagerVO {

	private Object entityList;
	private int totalRows;
	private int curPage = 1;
	private int pageSize = 20;
	/** 配合结果模式为0取结果集与记录总，为1取记录数，为2只取结果集 */
	private int resultMode;
	private int startIndex;
	private int endIndex;
	private int totalPage;
	/* 分页表达式 */
	private String orderBy;

	public int getStartIndex() {
		return startIndex == 0?(curPage-1)*pageSize+1:startIndex;
	}
	
	@XmlTransient
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		if(endIndex-startIndex>pageSize){
			return startIndex+pageSize;
		}
		return endIndex == 0? curPage*pageSize:(endIndex-1>totalRows?totalRows:endIndex);
	}

	public int getTotalPage() {
		return totalPage%pageSize==0?totalRows/pageSize:totalRows/pageSize+1;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public Object getEntityList() {
		return entityList;
	}

	public void setEntityList(Object entityList) {
		this.entityList = entityList;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if(pageSize<=0 || pageSize>20){
			return ;
		}
		this.pageSize = pageSize;
	}

	public int getResultMode() {
		return resultMode;
	}

	public void setResultMode(int resultMode) {
		this.resultMode = resultMode;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

}
