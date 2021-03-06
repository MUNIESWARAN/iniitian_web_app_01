package com.khozema.iniitian.service;

import java.util.List;

import com.khozema.iniitian.entity.Category;
import com.khozema.iniitian.entity.Product;

public interface ProductService {
	public Product get(int id);
	public List<Product> getAll();
	public Category getCategory(int id);
	public List<Product> getProductsByCategory(int id);
	public void add(Product c);
	public void update(Product c);
	public void remove(int id);	

}
