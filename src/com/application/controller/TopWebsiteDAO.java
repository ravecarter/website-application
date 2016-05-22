
package com.application.controller;

import java.util.List;

import javax.sql.DataSource;

public interface TopWebsiteDAO {
   /** 
    * This is the method to be used to initialize
    * database resources ie. connection.
    */
	public void setDataSource(DataSource ds);
   
	
	/** 
    * This is the method to be used to list down
    * all the records from the Website table.
    */
   
	public List<TopWebsite> listTopWebsiteByNameAsc(int limit);
	
	public List<TopWebsite> listTopWebsiteByNameDesc(int limit);
	
	public List<TopWebsite> listTopWebsiteByDateAsc(String date, int limit);
	
	public List<TopWebsite> listTopWebsiteByDateDesc(String date, int limit);
	
	public List<TopWebsite> listTopWebsiteByVisitCountAsc(int limit);
	
	public List<TopWebsite> listTopWebsiteByVisitCountDesc(int limit);
}