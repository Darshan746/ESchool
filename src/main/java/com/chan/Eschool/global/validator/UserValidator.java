package com.chan.Eschool.global.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.chan.Eschool.global.model.User;

public class UserValidator implements Validator {

	private Pattern pattern;
	private Matcher matcher;
	private static String emailPattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	/*private static String unamePattern = "^[A-Za-z]"; 
	private static String mobileNumPattern = "^(?:0091|\\+91|0)[7-9][0-9]{9}$";
	private static String yearPattern = "^\\d{4}$";
	private static String zipPattern = "^\\d{3}\\s?\\d{3}$";*/
	/*private static String urlPattern = "/^[http://]+[www]?.[0-9a-z_.]+.[a-z.]{2,5}$/i";*/
	
	private boolean patternMatcher(String input,String regexPattern){
		boolean matched = false;
		if(!input.isEmpty() && input != null){
			pattern = Pattern.compile(regexPattern);
			matcher = pattern.matcher(input);
			if(matcher.matches()){
				matched = true;
			}
		}
		return matched;
	}
	
	@Override
	public boolean supports(Class<?> target) {
		return User.class.equals(target);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		if(user.getName().isEmpty()){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "noCode","Enter name");
		}else if (user.getName().length() > 35) {
			errors.rejectValue("name", "noCode", "Name should not exceed 35 Characters");
		}
		
		if(user.getEmail().isEmpty()){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "noCode","Enter email");
		}else if (!patternMatcher(user.getEmail(), emailPattern)) {
			errors.rejectValue("email", "noCode", "Enter valid email");
		}
		
		if(user.getPassword().isEmpty()){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "noCode","Enter password");
		}else if (user.getPassword().length() < 8) {
			errors.rejectValue("password", "noCode", "Password must contain min. 8 characters");
		}else if (user.getPassword().length() > 25) {
			errors.rejectValue("password", "noCode", "Password must contain min. 8 characters");
		}
		
		if(user.getConfirmPassword().isEmpty()){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "noCode","Enter password again");
		}else if (!user.getConfirmPassword().equals(user.getPassword()) && !user.getPassword().isEmpty()) {
			errors.rejectValue("confirmPassword", "noCode", "Password mismatch");
		}
	}

}
