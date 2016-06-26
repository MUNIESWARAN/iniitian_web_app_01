package com.khozema.iniitian.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.khozema.iniitian.entity.OrderDetail;

@Repository
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory (SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
		
	@Override
	public void add(OrderDetail order) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(order);
	}

}
