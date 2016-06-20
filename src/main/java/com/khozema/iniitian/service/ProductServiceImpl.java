package com.khozema.iniitian.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.khozema.iniitian.dao.ProductDAO;
import com.khozema.iniitian.entity.Category;
import com.khozema.iniitian.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	@Override
	@Transactional
	public Product get(int id) {
		return this.productDAO.get(id);
	}

	@Override
	@Transactional
	public List<Product> getAll() {
		return this.productDAO.getAll();
	}

	@Override
	@Transactional
	public Category getCategory(int id) {
		return this.productDAO.getCategory(id);
	}

	@Override
	@Transactional
	public void add(Product c) {
		this.productDAO.add(c);
	}

	@Override
	@Transactional
	public void update(Product c) {
		this.productDAO.update(c);
	}

	@Override
	@Transactional
	public void remove(int id) {
		this.productDAO.remove(id);
	}

	@Override
	@Transactional
	public List<Product> getProductsByCategory(int id) {		
		return this.productDAO.getProductsByCategory(id);
	}

}
