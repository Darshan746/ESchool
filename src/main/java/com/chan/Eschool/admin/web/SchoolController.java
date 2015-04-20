package com.chan.Eschool.admin.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.chan.Eschool.global.model.School;

@Controller
public class SchoolController {

	private static final Logger logger  = LoggerFactory.getLogger(SchoolController.class);
	
	@RequestMapping(value = "/admin/school/add" , method = RequestMethod.GET)
	public ModelAndView addSchoolPage() {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("school", new School());
		modelAndView.setViewName("addSchool");
		logger.info("returning school add page");
		return modelAndView;
	}
}
