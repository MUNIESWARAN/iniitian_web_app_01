package com.khozema.iniitian.dao;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.khozema.iniitian.entity.Cart;
import com.khozema.iniitian.service.OrderService;

@Repository
public class CartDAOImpl implements CartDAO {

	@Autowired
	private OrderService orderService;
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory =sessionFactory;
	}
	
	
	@Override
	public Cart get(Long id) {
		Session session = sessionFactory.getCurrentSession();		
		return session.get(Cart.class, id);
	}

	@Override
	public void update(Cart cart) {
        Long cartId = cart.getId();
        double grandTotal = orderService.getOrderGrandTotal(cartId);
        cart.setGrandTotal(grandTotal);
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cart);		
	}

    public Cart validate(Long cartId) throws IOException {
        Cart cart=get(cartId);
        if(cart==null||cart.getCartItems().size()==0) {
            throw new IOException(cartId+"");
        }
        update(cart);
        return cart;
    }

}
