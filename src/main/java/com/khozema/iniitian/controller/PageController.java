package com.khozema.iniitian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping("/index") 
	public ModelAndView index() {
		return new ModelAndView("public/index").addObject("view", "index");		
	}
	@RequestMapping("/about") 
	public ModelAndView about() {
		return new ModelAndView("public/about").addObject("view", "about");		
	}
	@RequestMapping("/contact") 
	public ModelAndView contact() {
		return new ModelAndView("public/contact").addObject("view", "contact");		
	}
	@RequestMapping("/login") 
	public ModelAndView login() {
		return new ModelAndView("public/login").addObject("view", "login");		
	}
	
	@RequestMapping("/register") 
	public ModelAndView register() {
		return new ModelAndView("public/register").addObject("view", "register");		
	}
	@RequestMapping("/products") 
	public ModelAndView products() {
		return new ModelAndView("public/products").addObject("view", "products");		
	}
	@RequestMapping("/default") 
	public ModelAndView defaultTemplate() {
		return new ModelAndView("public/default").addObject("view", "products");		
	}

}
