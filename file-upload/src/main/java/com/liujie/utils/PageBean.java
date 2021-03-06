package com.liujie.utils;

import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * 封装分页信息
 *
 */
public class PageBean<T> {
	private int currentPage;//当前页码
	private int pageSize;//每页显示记录数
	private DetachedCriteria detachedCriteria;//分页查询条件
	
	private int total;//总记录数
	private List<T> rows;//当前页展示的数据集合
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public DetachedCriteria getDetachedCriteria() {
		return detachedCriteria;
	}
	public void setDetachedCriteria(DetachedCriteria detachedCriteria) {
		this.detachedCriteria = detachedCriteria;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
