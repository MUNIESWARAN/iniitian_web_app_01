package com.khozema.iniitian.wfhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.khozema.iniitian.entity.User;
import com.khozema.iniitian.service.UserService;
import com.khozema.iniitian.validator.RegisterFormValidator;

@Component
public class RegisterHandler {

	@Autowired
	private UserService userService;
		
	public String registerUser(User user) {
		userService.add(user);
		return "success";
	}

	@InitBinder("user")
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new RegisterFormValidator());
	}
	
}
