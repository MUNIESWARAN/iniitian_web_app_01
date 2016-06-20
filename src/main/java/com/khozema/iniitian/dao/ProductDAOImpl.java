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
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {		
		this.sessionFactory = sessionFactory;
	}
		
	@Override
	public Product get(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Product.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Product");
		return query.list();
	}

	@Override
	public Category getCategory(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Category as c WHERE c.id="+id);
		return (Category) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProductsByCategory(int id) {
		Session session = sessionFactory.getCurrentSession();
		List<Product> products = session.createQuery("FROM Product as p WHERE p.categoryId="+id).list();
		return products;		
	}
	
	
	@Override
	public void add(Product c) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(c);
	}

	@Override
	public void update(Product c) {
		Session session = sessionFactory.getCurrentSession();
		session.update(c);
	}

	@Override
	public void remove(int id) {
		Session session = sessionFactory.getCurrentSession();		
		Product product = session.get(Product.class, id);
		session.delete(product);		
	}

}
