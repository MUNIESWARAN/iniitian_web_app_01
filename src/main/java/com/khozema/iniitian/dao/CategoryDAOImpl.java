package com.khozema.iniitian.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.khozema.iniitian.entity.Category;
import com.khozema.iniitian.entity.Product;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;		
	}
	
	@Override
	public Category get(int id) {		
		Session session = sessionFactory.getCurrentSession();
		return (Category) session.get(Category.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAll() {
		Session session = sessionFactory.getCurrentSession();
		return  session.createQuery("FROM Category").list();			
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProducts(int id) {
		Session session = sessionFactory.getCurrentSession();
		List<Product> products = session.createQuery("FROM Product as p WHERE p.categoryId="+id).list();
		return products;		
	}

	@Override
	public void add(Category c) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(c);
	}

	@Override
	public void update(Category c) {
		Session session = sessionFactory.getCurrentSession();
		session.update(c);

	}

	@SuppressWarnings("unchecked")
	@Override
	public void remove(int id) {
		// Retrieve session
		Session session = sessionFactory.getCurrentSession();
		
		// Create HQL to fetch associated products
		Query query = session.createQuery("FROM Product as p WHERE p.categoryId="+id);
		List<Product> products = query.list();
		// Delete Associated Products
		for (Product product: products) {
			session.delete(product);			
		}
		
		// Fetch Category
		Category category = session.get(Category.class, id);
				
		// Delete Category
		session.delete(category);
		
	}

}
