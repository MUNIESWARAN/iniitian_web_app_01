package com.khozema.iniitian.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.khozema.iniitian.entity.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {		
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Product product = (Product) obj;		
		String filename = product.getFile().getOriginalFilename().toLowerCase();		
		boolean extension = (filename.endsWith(".jpg") || filename.endsWith(".png"))? true : false; 
		if(!filename.equals("")) {						
			if(product.getFile().getSize() > 1048576) {
				errors.rejectValue("file", "product.file", "Please enter a file below 1 MB Size!");
			}
			if(!extension) {
				errors.rejectValue("file", "product.file", "Please enter a jpg or image file!");
			}
		}
	}

}
