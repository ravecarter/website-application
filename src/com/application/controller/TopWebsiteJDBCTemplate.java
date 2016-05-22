
package com.application.controller;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class TopWebsiteJDBCTemplate implements TopWebsiteDAO 
{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource) 
	{
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public List<TopWebsite> listTopWebsiteByNameAsc(int limit) 
	{
		String SQL = "SELECT @curRow := @curRow + 1 AS NO, DATE, NAME, VISIT_COUNT FROM mnlf_db.tbl_top_website JOIN (SELECT @curRow := 0) r ORDER BY NAME asc, DATE asc, VISIT_COUNT asc LIMIT ?";
		List <TopWebsite> topWebsite = jdbcTemplateObject.query(SQL, new Object[]{limit}, new TopWebsiteMapper());
		return topWebsite;
	}
	
	public List<TopWebsite> listTopWebsiteByNameDesc(int limit)
	{
		String SQL = "SELECT @curRow := @curRow + 1 AS NO, DATE, NAME, VISIT_COUNT FROM mnlf_db.tbl_top_website JOIN (SELECT @curRow := 0) r ORDER BY NAME desc, DATE asc, VISIT_COUNT asc LIMIT ?";
		List <TopWebsite> topWebsite = jdbcTemplateObject.query(SQL, new Object[]{limit}, new TopWebsiteMapper());
		return topWebsite;
	}
	
	public List<TopWebsite> listTopWebsiteByDateAsc(String date, int limit)
	{
		String SQL = "SELECT @curRow := @curRow + 1 AS NO, DATE, NAME, VISIT_COUNT FROM mnlf_db.tbl_top_website JOIN (SELECT @curRow := 0) r WHERE DATE = ? ORDER BY DATE asc, NAME asc, VISIT_COUNT asc LIMIT ?";
		List <TopWebsite> topWebsite = jdbcTemplateObject.query(SQL, new Object[]{date,limit}, new TopWebsiteMapper());
		return topWebsite;
	}
	
	public List<TopWebsite> listTopWebsiteByDateDesc(String date, int limit)
	{
		String SQL = "SELECT @curRow := @curRow + 1 AS NO, DATE, NAME, VISIT_COUNT FROM mnlf_db.tbl_top_website JOIN (SELECT @curRow := 0) r WHERE DATE = ? ORDER BY DATE desc, NAME asc, VISIT_COUNT asc LIMIT ?";
		List <TopWebsite> topWebsite = jdbcTemplateObject.query(SQL, new Object[]{date,limit}, new TopWebsiteMapper());
		return topWebsite;
	}
	
	public List<TopWebsite> listTopWebsiteByVisitCountAsc(int limit)
	{
		String SQL = "SELECT @curRow := @curRow + 1 AS NO, DATE, NAME, VISIT_COUNT FROM mnlf_db.tbl_top_website JOIN (SELECT @curRow := 0) r ORDER BY VISIT_COUNT asc, NAME asc, DATE asc LIMIT ?";
		List <TopWebsite> topWebsite = jdbcTemplateObject.query(SQL, new Object[]{limit}, new TopWebsiteMapper());
		return topWebsite;
	}
	
	public List<TopWebsite> listTopWebsiteByVisitCountDesc(int limit)
	{
		String SQL = "SELECT @curRow := @curRow + 1 AS NO, DATE, NAME, VISIT_COUNT FROM mnlf_db.tbl_top_website JOIN (SELECT @curRow := 0) r ORDER BY VISIT_COUNT desc, NAME asc, DATE asc LIMIT ?";
		List <TopWebsite> topWebsite = jdbcTemplateObject.query(SQL, new Object[]{limit}, new TopWebsiteMapper());
		return topWebsite;
	}
}