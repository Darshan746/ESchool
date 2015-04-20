package com.chan.Eschool.global.web;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chan.Eschool.global.model.School;
import com.chan.Eschool.global.model.User;
import com.chan.Eschool.global.service.school.SchoolService;
import com.chan.Eschool.global.service.user.UserService;
import com.chan.Eschool.global.validator.UserValidator;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private SchoolService schoolService;
	
	@Autowired
	private UserService userService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		/*Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );*/
		model.addAttribute("user", new User());
		List<School> schools = getSchoolService().getSchools();
		
		List<User> users = getUserService().getAllUsers();
		boolean thereIsAdmin = false;
		
		for(User admin : users){
			if(admin.getRole().getId() == 1){
				thereIsAdmin = true;
			}
		}
		
		if(schools != null){
			if(schools.size() == 0 && !thereIsAdmin){
				return "redirect:/register";
			}else if(schools.size() == 0 && thereIsAdmin){
				return "redirect:/login";
			}
		}
		
		return "home";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String index(){
		return "redirect:/";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String adminRegistrationPage(@ModelAttribute("user")User user) {
		
		List<School> schools = getSchoolService().getSchools();
		
		if(schools != null){
			if(schools.size() > 0){
				return "redirect:/";
			}else {
				return "redirect:/login";
			}
		}
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String adminRegistrationProcess(@ModelAttribute("user")User user, BindingResult result, ModelMap modelMap) {
		UserValidator userValidator = new UserValidator();
		
		userValidator.validate(user, result);
		
		boolean userExists = getUserService().userExists(user.getEmail());
		
		if(userExists){
			result.addError(new FieldError("user", "email", "User with the entered email already exists"));
		}
		
		if(result.hasErrors()){
			modelMap.addAttribute("user", user);
			return "register";
		}
		
		User savedUser = getUserService().addUser(user);
		if(savedUser.getId() != 0){
			System.out.println("Registered");
		}
		return "redirect:/register";
	}

	//Getters and setters
	public SchoolService getSchoolService() {
		return schoolService;
	}

	public void setSchoolService(SchoolService schoolService) {
		this.schoolService = schoolService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
