package com.chan.Eschool.global.web;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.chan.Eschool.global.model.School;
import com.chan.Eschool.global.model.User;
import com.chan.Eschool.global.service.school.SchoolService;
import com.chan.Eschool.global.service.user.UserService;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService; 
	
	@Autowired
	private SchoolService schoolService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView LoginPage(@ModelAttribute("user")User user,@RequestParam(value = "logout" , required = false)String logout, @RequestParam(value = "sessionExp" , required = false)String sessionExp){
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", user);
		if(logout != null){
			logout = "You Have Been Successfully Logged Out";
			modelAndView.addObject("logout", logout);
		}
		
		if(sessionExp != null){
			sessionExp = "Your Session Expired! Login Again";
			modelAndView.addObject("sessionExp", sessionExp);
		}
		
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping(value = "/postLoginAction" , method = RequestMethod.GET)
	public String processLoginAction(Principal principal, ModelMap modelMap, HttpSession httpSession){
		User loggedInUser = null;
		if(principal != null){
			
			logger.info("logged in user : "+principal.getName());
			loggedInUser = getUserService().findUserByEmail(principal.getName());
			
			if(loggedInUser.getRole().getAuthority().equals("ROLE_ADMIN")){
				
				httpSession.setAttribute("user", loggedInUser);
				List<School> schools = getSchoolService().getSchools();
				
				if(schools != null){
					if(schools.size() == 0){
						return "redirect:/admin/dashboard?schoolExists="+0;
					}
				}
				
				return "redirect:/admin/dashboard";
			}else if(loggedInUser.getRole().getAuthority().equals("ROLE_FACULTY")){
				
				httpSession.setAttribute("user", loggedInUser);
				return "redirect:/faculty/dashboard";
			}else if(loggedInUser.getRole().getAuthority().equals("ROLE_PARENT")){
				
				httpSession.setAttribute("user", loggedInUser);
				return "redirect:/parent/dashboard";
			}
			
			modelMap.addAttribute("loggedInUser", principal.getName());
			return "success";
		}else {
			return "redirect:/login";
		}
	}

	//Getters and setters
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public SchoolService getSchoolService() {
		return schoolService;
	}

	public void setSchoolService(SchoolService schoolService) {
		this.schoolService = schoolService;
	}
}
