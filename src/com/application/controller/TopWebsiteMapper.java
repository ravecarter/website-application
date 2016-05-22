
package com.application.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class TopWebsiteMapper implements RowMapper<TopWebsite> 
{
	public TopWebsite mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		TopWebsite topWebsite = new TopWebsite();
		topWebsite.setNo(rs.getInt("no"));
		topWebsite.setName(rs.getString("name"));
		topWebsite.setDate(rs.getDate("date"));
		topWebsite.setVisitCount(rs.getInt("visit_count"));
		return topWebsite;
	}
}