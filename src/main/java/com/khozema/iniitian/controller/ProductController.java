package com.khozema.iniitian.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khozema.iniitian.entity.Product;
import com.khozema.iniitian.service.ProductService;


@Controller
@RequestMapping(value="/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}	
	
	@RequestMapping(value = "/all")
	public @ResponseBody List<Product> getAll() {
		return this.productService.getAll();
	}

	@RequestMapping(value = "/{id}")
	public @ResponseBody Product get(@PathVariable("id") Long id) {
		return this.productService.get(id);
	}
	
	@RequestMapping(value = "/{id}/category")
	public @ResponseBody HashMap<String,Object> getCategory(@PathVariable("id") int id) {
		HashMap<String,Object> test = new HashMap<String,Object>();
		test.put("category", productService.getCategory(id));
		test.put("product", productService.getProductsByCategory(id));
		return test;
	}
	
}
