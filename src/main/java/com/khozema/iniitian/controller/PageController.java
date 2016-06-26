package com.khozema.iniitian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value ="/productList", method = RequestMethod.GET) 
	public ModelAndView products() {
		return new ModelAndView("shared/productList").addObject("view", "productList");		
	}
	@RequestMapping("/productDetail") 
	public ModelAndView productView() {
		return new ModelAndView("shared/productView").addObject("view", "productView");		
	}
	
	@RequestMapping(value = "/user/viewCart")
	public ModelAndView viewCart() {
		return new ModelAndView("public/viewCart").addObject("view", "viewCart");
	}

	
}
