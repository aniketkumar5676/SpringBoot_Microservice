package com.school.library;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Component
public class Admin {

	String id, name, classname, book, issuedate, returndate;
	ModelAndView mv = new ModelAndView();

         
    Map<String,Student> map = new HashMap<>();
    
	@RequestMapping("/addbook")
	public ModelAndView adminPanel(HttpServletRequest request) {

			
		mv.setViewName("bookingConfirm");
	
		
		map.put(request.getParameter("studentid"),new Student(request.getParameter("student"),
				        request.getParameter("class"),
						request.getParameter("book"),
						request.getParameter("issuedate"),
						request.getParameter("returndate")));
		
			
	

		mv.addObject("id", request.getParameter("studentid"));
		mv.addObject("name", request.getParameter("student"));
		mv.addObject("classname", request.getParameter("class"));
		mv.addObject("book", request.getParameter("book"));
		mv.addObject("issuedate", request.getParameter("issuedate"));
		mv.addObject("returndate", request.getParameter("returndate"));

		return mv;
	}

	
	  @RequestMapping("/studentfee") public ModelAndView
	  feeCoollection(@RequestParam("studentid2") String id) {
	  	  
	  if(map.containsKey(id)) {
		  
	  mv.setViewName("feeCollection");
	  mv.addObject("id", map.get(id));

	  //removes student data from database
	  map.remove(id);
	  
	  }else {
	   mv.setViewName("Admin"); 
	   mv.addObject("status", "Record Not Available or Fee have been Paid"); 
	   return mv; 
	   }
	  
	  return mv; 
	  
	  }
	 
	 
}
