package com.wechat.dto;

import java.util.List;

/**
 * 分页工具类
 * @类名	Pager.java
 */
public class Pager<T>{
	private List<T> datas;
	private int pageOffset;// 页码
	private long totalRecord;// 总数
	private int pageSize;// 每页大小
	private long pageNum;// 总页码
	
	public int getPageOffset() {
		return pageOffset;
	}
	public void setPageOffset(int pageOffset) {
		this.pageOffset = pageOffset;
	}
	public long getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	public long getPageNum() {
		return pageNum;
	}
	public void setPageNum(long pageNum) {
		this.pageNum = pageNum;
	}
	
}
