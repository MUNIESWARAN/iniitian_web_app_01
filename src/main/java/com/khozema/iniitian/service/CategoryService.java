package com.khozema.iniitian.service;

import java.util.List;

import com.khozema.iniitian.entity.Category;
import com.khozema.iniitian.entity.Product;

public interface CategoryService {
	public Category get(Long id);
	public List<Category> getAll();
	public List<Product> getProducts(Long id);
	public void add(Category c);
	public void update(Category c);
	public void remove(Long id);
}
