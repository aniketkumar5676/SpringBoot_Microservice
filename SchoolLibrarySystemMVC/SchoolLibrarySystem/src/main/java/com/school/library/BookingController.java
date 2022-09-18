package com.school.library;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookingController {
	
	
	@RequestMapping("/backToAdmin")
	public ModelAndView backToAdminPanel() {
		ModelAndView mv = new ModelAndView();
        mv.setViewName("Admin");
		return mv;
	}

}
