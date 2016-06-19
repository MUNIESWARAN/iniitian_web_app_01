package com.khozema.iniitian.service;

import java.util.List;

import com.khozema.iniitian.entity.Category;
import com.khozema.iniitian.entity.Product;

public interface ProductService {
	public Product get(Long id);
	public List<Product> getAll();
	public Category getCategory(Long id);
	public List<Product> getProductsByCategory(Long id);
	public void add(Product c);
	public void update(Product c);
	public void remove(Long id);	

}
