package com.khozema.iniitian.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.khozema.iniitian.entity.User;
import com.khozema.iniitian.service.UserService;

public class RegisterFormValidator implements Validator {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		User user = (User) obj;
		 
		if(!user.getEmailAddress().equals("")) {
			if(!Pattern.matches(EMAIL_PATTERN, user.getEmailAddress())) {
				errors.rejectValue("emailAddress", "user.emailAddress", "Please enter proper email id!");
				return;
			}
		}
		
		if(!user.getPassword().equals("")) {
			if(!user.getPassword().equals(user.getConfirmPassword())) {
				errors.rejectValue("confirmPassword", "user.confirmPassword", "Entered password does not match confirm password!");
			}			
		}
	}

}
