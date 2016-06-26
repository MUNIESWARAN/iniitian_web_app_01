package com.khozema.iniitian.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.khozema.iniitian.dao.OrderDAO;
import com.khozema.iniitian.entity.Cart;
import com.khozema.iniitian.entity.CartItem;
import com.khozema.iniitian.entity.OrderDetail;
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;
	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	
	@Autowired
	private CartService cartService;
	
	@Override
	@Transactional
	public void add(OrderDetail order) {
		this.orderDAO.add(order);
	}

	@Override
	public double getOrderGrandTotal(Long cartId) {
		double grandTotal  = 0;
		
		Cart cart = cartService.get(cartId);
		List<CartItem> cartItems = cart.getCartItems();
		for(CartItem item: cartItems) {
			grandTotal += item.getTotalPrice();
		}
		return grandTotal;
	}

}
