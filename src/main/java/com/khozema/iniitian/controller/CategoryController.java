package com.khozema.iniitian.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khozema.iniitian.entity.Category;
import com.khozema.iniitian.entity.Product;
import com.khozema.iniitian.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@RequestMapping(value = "/all")
	public @ResponseBody List<Category> getAll() {
		return this.categoryService.getAll();
	}
	@RequestMapping(value = "/{id}")
	public @ResponseBody Category get(@PathVariable("id") Long id) {
		return this.categoryService.get(id);
	}
	@RequestMapping(value = "/{id}/product")
	public @ResponseBody List<Product> getProducts(@PathVariable("id") Long id) {
		return this.categoryService.getProducts(id);
	}	
	
}
