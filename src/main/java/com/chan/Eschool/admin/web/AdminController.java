package com.chan.Eschool.admin.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@RequestMapping(value = "/admin/dashboard" , method = RequestMethod.GET)
	public ModelAndView adminDashboard(@RequestParam(value = "schoolExists" , required = false)String schoolExists){
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/dashboard");
		if(schoolExists != null){
			modelAndView.addObject("schoolExists", schoolExists);
		}
		logger.info("returning admin dashboard");
		return modelAndView;
	}
}
