package com.khozema.iniitian.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.khozema.iniitian.dao.CartDAO;
import com.khozema.iniitian.entity.Cart;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDAO cartDAO;
	public void setCartDAO(CartDAO cartDAO) {
		this.cartDAO = cartDAO;
	}
	
	@Override
	@Transactional
	public Cart get(Long id) {		
		return this.cartDAO.get(id);		
	}

	@Override
	@Transactional
	public void update(Cart cart) {
		this.cartDAO.update(cart);
	}
}
