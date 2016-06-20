package com.khozema.iniitian.dao;

import java.util.List;

import com.khozema.iniitian.entity.Category;
import com.khozema.iniitian.entity.Product;

public interface CategoryDAO {

	public Category get(int id);
	public List<Category> getAll();
	public List<Product> getProducts(int id);
	public void add(Category c);
	public void update(Category c);
	public void remove(int id);
	
}
