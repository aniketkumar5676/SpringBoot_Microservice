package com.school.library;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FeeController {

	@RequestMapping("/fee_collection")
	public ModelAndView feeCollection(@RequestParam("fee")String fee ){
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("feeStatus");
		mv.addObject("status","Rs "+fee+" Collected Successfully, <br>Also Student data have been Removed from Library Database");
				
		return mv;
	}
}
