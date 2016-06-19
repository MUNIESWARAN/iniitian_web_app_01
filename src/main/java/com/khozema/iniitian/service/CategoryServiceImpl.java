package com.khozema.iniitian.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.khozema.iniitian.dao.CategoryDAO;
import com.khozema.iniitian.entity.Category;
import com.khozema.iniitian.entity.Product;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;
	
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
	
	@Override
	@Transactional
	public Category get(Long id) {
		return this.categoryDAO.get(id);
	}

	@Override
	@Transactional
	public List<Category> getAll() {
		return this.categoryDAO.getAll();
	}

	@Override
	@Transactional
	public List<Product> getProducts(Long id) {
		return this.categoryDAO.getProducts(id);
	}

	@Override
	@Transactional
	public void add(Category c) {
		this.categoryDAO.add(c);
	}

	@Override
	@Transactional
	public void update(Category c) {
		this.categoryDAO.update(c);
	}

	@Override
	@Transactional
	public void remove(Long id) {
		this.categoryDAO.remove(id);
	}

}
