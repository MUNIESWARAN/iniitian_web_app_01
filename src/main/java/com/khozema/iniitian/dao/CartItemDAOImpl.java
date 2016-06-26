package com.khozema.iniitian.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.khozema.iniitian.entity.Cart;
import com.khozema.iniitian.entity.CartItem;

@Repository
public class CartItemDAOImpl implements CartItemDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void add(CartItem item) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(item);		
	}

	@Override
	public CartItem get(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(CartItem.class, id);		
	}

	@Override
	public CartItem getCartItemByProductId(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CartItem where itemId = ?");
        query.setLong(0, id);
        session.flush();
        return (CartItem) query.uniqueResult();
	
	}
	
	@Override
	public void remove(CartItem item) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(item);	
	}

	@Override
	public void removeAll(Cart cart) {
		List<CartItem> cartItems = cart.getCartItems();
		for(CartItem item: cartItems) {
			remove(item);
		}
	}

}
