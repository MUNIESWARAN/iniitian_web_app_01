package com.khozema.iniitian.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.khozema.iniitian.dao.CartItemDAO;
import com.khozema.iniitian.entity.Cart;
import com.khozema.iniitian.entity.CartItem;

@Service
@Transactional
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemDAO cartItemDAO;
	public void setCartItemDAO(CartItemDAO cartItemDAO) {
		this.cartItemDAO = cartItemDAO;
	}
	
	@Override
	public void add(CartItem item) {
		this.cartItemDAO.add(item);
	}

	@Override
	public CartItem get(Long id) {
		return this.cartItemDAO.get(id);
	}

	@Override
	public CartItem getCartItemByProductId(Long id) {		
		return this.cartItemDAO.getCartItemByProductId(id);
	}

	@Override
	public void remove(CartItem item) {
		this.cartItemDAO.remove(item);
	}

	@Override
	public void removeAll(Cart cart) {
		this.cartItemDAO.removeAll(cart);
	}

}
