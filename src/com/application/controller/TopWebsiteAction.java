
package com.application.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class TopWebsiteAction 
//extends HttpServlet
{
    private TopWebsiteJDBCTemplate topWebsiteJDBCTemplate;	
    

	public void setTopWebsiteJDBCTemplate(
			TopWebsiteJDBCTemplate topWebsiteJDBCTemplate) {
		this.topWebsiteJDBCTemplate = topWebsiteJDBCTemplate;
	}
	
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

	@RequestMapping(value = "/topWebsite", method = RequestMethod.GET)
	public ModelAndView topWebsite(@ModelAttribute("topWebsite")TopWebsite topWebsite, ModelMap model) 
	{
		
		try
		{		
			List<TopWebsite> topWebsites = null;
			
			System.out.println("TypeSearch : " +topWebsite.getTypeSearch());
			System.out.println("Order : " +topWebsite.getOrder());
			System.out.println("DateString : " +topWebsite.getDateString());
			System.out.println("Limit : " +topWebsite.getLimit());
			
			if(null != topWebsite.getTypeSearch() && null != topWebsite.getOrder())
			{		
			
				System.out.println("------ Value From View <<METHOD POST>> --------" );
				
				if (topWebsite.getTypeSearch().equalsIgnoreCase("orderByDate") && topWebsite.getOrder().equalsIgnoreCase("ascending"))
				{	
					topWebsites = topWebsiteJDBCTemplate.listTopWebsiteByDateAsc(topWebsite.getDateString(), topWebsite.getLimit());	
				}
				else if (topWebsite.getTypeSearch().equalsIgnoreCase("orderByWebsite") && topWebsite.getOrder().equalsIgnoreCase("ascending"))
				{
					topWebsites = topWebsiteJDBCTemplate.listTopWebsiteByNameAsc(topWebsite.getLimit());			
				}
				else if (topWebsite.getTypeSearch().equalsIgnoreCase("orderByVisits") && topWebsite.getOrder().equalsIgnoreCase("ascending"))
				{
					topWebsites = topWebsiteJDBCTemplate.listTopWebsiteByVisitCountAsc(topWebsite.getLimit());			
				}
				else if (topWebsite.getTypeSearch().equalsIgnoreCase("orderByDate") && topWebsite.getOrder().equalsIgnoreCase("descending"))	
				{						
					topWebsites = topWebsiteJDBCTemplate.listTopWebsiteByDateDesc(topWebsite.getDateString(), topWebsite.getLimit());
				}
				else if (topWebsite.getTypeSearch().equalsIgnoreCase("orderByWebsite") && topWebsite.getOrder().equalsIgnoreCase("descending"))
				{
					topWebsites = topWebsiteJDBCTemplate.listTopWebsiteByNameDesc(topWebsite.getLimit());
				}
				else // topWebsite.getTypeSearch().equalsIgnoreCase("orderByVisits") && topWebsite.getOrder().equalsIgnoreCase("descending")
				{
					topWebsites = topWebsiteJDBCTemplate.listTopWebsiteByVisitCountDesc(topWebsite.getLimit());
				}
					
				System.out.println("------ Listing Multiple Records <<METHOD POST>> --------" );
				for (TopWebsite record : topWebsites) 
				{
					System.out.print("No : " + record.getNo());
					System.out.print(", Name : " + record.getName() );
					System.out.print(", Date : " + record.getDate() );
					System.out.println(", VisitCount : " + record.getVisitCount());
				}
			}
			//return back to index.jsp
			ModelAndView modelAndView = new ModelAndView("topWebsite", "lists", topWebsites);
			
			return modelAndView;
		
		} 
		catch (Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		
	}
}