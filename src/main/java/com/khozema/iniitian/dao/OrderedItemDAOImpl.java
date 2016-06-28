package com.khozema.iniitian.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.khozema.iniitian.entity.OrderedItem;
@Repository
public class OrderedItemDAOImpl implements OrderedItemDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void add(OrderedItem orderedItem) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(orderedItem);
	}

}
