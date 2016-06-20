package com.khozema.iniitian.controller;

import java.io.File;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.khozema.iniitian.entity.Product;
import com.khozema.iniitian.service.ProductService;
import com.khozema.iniitian.validator.ProductValidator;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private HttpServletRequest request;
	@RequestMapping(value="/listProduct")
	public ModelAndView listProduct() {		
		ModelAndView mav = new ModelAndView("admin/listProduct");
		mav.addObject("products", this.productService.getAll());
		return mav;
	}
	
	@RequestMapping(value="/product/add", method=RequestMethod.GET)
	public String createProduct(Model model) {		
		Product product = new Product();
		product.setImageUrl("no_product.jpg");
		model.addAttribute("product", product);
		model.addAttribute("categories", getCategories());		
		return "admin/product";
	}

	@RequestMapping(value="/product/add", method= RequestMethod.POST)
	public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("categories", getCategories());
			return "admin/product";
		}

		
		// call to upload the file
		if(!product.getFile().isEmpty()) {
			product.setImageUrl(uploadImage(product.getFile()));
		}
				
		if(product.getId() == 0) {			
			this.productService.add(product);
		}
		else {
			
			this.productService.update(product);
		}
				
		return "redirect:/admin/listProduct";
	}

	@RequestMapping(value="/product/edit/{id}", method=RequestMethod.GET)
	public String editProduct(@PathVariable("id") int id, Model model) {	
		model.addAttribute("product", this.productService.get(id));
		model.addAttribute("categories", getCategories());		
		return "admin/product";
	}

	@RequestMapping(value="/product/remove/{id}", method=RequestMethod.GET)
	public String removeProduct(@PathVariable("id") int id) {
		this.productService.remove(id);
		return "redirect:/admin/listProduct";
	}
		
	
	protected LinkedHashMap<Integer,String> getCategories() {
		LinkedHashMap<Integer,String> categories = new LinkedHashMap<Integer,String>();		
		categories.put(1, "Mobile");
		categories.put(2, "Laptop");
		categories.put(3, "Tablet");		
		return categories;
	}
	
	
	// helper to upload the file
	protected String uploadImage(MultipartFile multipartFile) {
		
		String folderToUpload = "/resources/images/";
		
		//1. get the filename
		String filename = multipartFile.getOriginalFilename();
		
		// 2. get the real path and create the directory
		// if it does not exists
		String realPath = request.getServletContext().getRealPath(folderToUpload);
		if(!new File(realPath).exists()) {
			new File(realPath).mkdirs();
		}
						
		// 3. transfer the file
		String filePath = realPath + filename;
		File destination = new File(filePath);
		try { multipartFile.transferTo(destination);	}
		catch(Exception ex) {}
		
		// 4. Return the filename
		return filename;
		
		
	}
	
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new ProductValidator());
	}
	
	
}
