package com.khozema.iniitian.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.khozema.iniitian.entity.User;
import com.khozema.iniitian.service.UserService;
import com.khozema.iniitian.validator.RegisterFormValidator;

@Controller
public class AuthController {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET ) 
	public String login(Model model) {
		return "public/login";
	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    //You can redirect wherever you want, but generally it's a good practice to show login screen again.
	    return "redirect:/index";
	}	
	
	@RequestMapping(value = "/register", method=RequestMethod.GET) 
	public String register(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("view", "register");
		return "public/register";			
	}
	
	@RequestMapping(value = "/register", method=RequestMethod.POST) 
	public String  addUser(@Valid @ModelAttribute("user") User user, BindingResult results) {
		
		if(results.hasErrors()) {
			return "public/register";
		}
		
		User exist = userService.getUserByEmailAddress(user.getEmailAddress());
		if(exist !=null) {
			results.addError(new FieldError("user", "emailAddress", "Email address already exists!"));
			return "public/register";
		}
		
		// add the user with role
		userService.add(user);
		
		return "redirect:/login";		
	}
	
	
	
	@RequestMapping("/accessdenied") 
	public String error403() {		
		return "403Page";
	}

	@RequestMapping("/loginError") 
	public String loginError(Model model) {
		model.addAttribute("error", "Invalid Login Details!");		
		return "public/login";		
	}
	
	@InitBinder("user")
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new RegisterFormValidator());
	}
	
}
