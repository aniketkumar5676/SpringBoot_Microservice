package com.school.library;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@Component
public class LoginController {
	
	@RequestMapping("/login")
	public ModelAndView login (@RequestParam("userid") String userid ,@RequestParam
			("password") String password) 
	{
		ModelAndView mv = new ModelAndView();
		Map<String,String> admin = new HashMap<>();
		admin.put("admin", "admin");
		admin.put("user001", "password");
		admin.put("user002", "password");

		if(admin.containsKey(userid)) {
			
			
			if(admin.get(userid).equals(password)) {
				
			mv.setViewName("Admin");
				
		      return mv;
				
			}
			
			
			
		}
			
		  return null;
			
				
	}
	
	
	

}
