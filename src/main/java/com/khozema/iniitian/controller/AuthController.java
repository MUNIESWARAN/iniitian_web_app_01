package com.khozema.iniitian.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {

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
	
	@RequestMapping("/accessdenied") 
	public String error403() {		
		return "403Page";
	}

	@RequestMapping("/loginError") 
	public String loginError(Model model) {
		model.addAttribute("error", "Invalid Login Details!");		
		return "public/login";		
	}
	
}
