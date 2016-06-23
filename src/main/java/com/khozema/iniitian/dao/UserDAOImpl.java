package com.khozema.iniitian.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.khozema.iniitian.entity.Category;
import com.khozema.iniitian.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void add(User u) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(u);
	}

	@Override
	public User getUserByEmailAddress(String emailAddress) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM User as u WHERE u.emailAddress='"+emailAddress+ "'");
		return (User) query.uniqueResult();				
	}

}
