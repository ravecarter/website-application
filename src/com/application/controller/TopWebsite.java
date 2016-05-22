
package com.application.controller;

import java.util.Date;

public class TopWebsite 
{
	private Integer no;
	private String name;
	private Date date;
	private String dateString;
	private Integer visitCount;
	private String typeSearch;
	private String order;
	private Integer limit;
	
	
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public String getDateString() {
		return dateString;
	}
	public void setDateString(String dateString) {
		this.dateString = dateString;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getVisitCount() {
		return visitCount;
	}
	public void setVisitCount(Integer visitCount) {
		this.visitCount = visitCount;
	}
	public String getTypeSearch() {
		return typeSearch;
	}
	public void setTypeSearch(String typeSearch) {
		this.typeSearch = typeSearch;
	}
}
