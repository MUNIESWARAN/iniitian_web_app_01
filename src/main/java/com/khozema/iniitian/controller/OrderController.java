package com.khozema.iniitian.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.khozema.iniitian.entity.BillingAddress;
import com.khozema.iniitian.entity.CardDetail;
import com.khozema.iniitian.entity.CartItem;
import com.khozema.iniitian.entity.OrderDetail;
import com.khozema.iniitian.entity.OrderedItem;
import com.khozema.iniitian.entity.ShippingAddress;
import com.khozema.iniitian.entity.User;
import com.khozema.iniitian.service.CardDetailService;
import com.khozema.iniitian.service.CartItemService;
import com.khozema.iniitian.service.OrderService;
import com.khozema.iniitian.service.OrderedItemService;
import com.khozema.iniitian.service.UserService;

@Component
public class OrderController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private CardDetailService cardDetailService;
	
	@Autowired
	private OrderedItemService orderedItemService;
	
	public OrderDetail initFlow() {
		User user = userService.getUserByEmailAddress(SecurityContextHolder.getContext().getAuthentication().getName());
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setUsersDetail(user);
		orderDetail.setCart(user.getCart());
		return orderDetail;
	}
	
	
	public String addShippingDetail(OrderDetail orderDetail, ShippingAddress shippingAddress) {
		//System.out.println(shippingAddress);
		shippingAddress.setUser(orderDetail.getUsersDetail());
		orderDetail.setShippingAddress(shippingAddress);
		
		return "success";
	}
	public String addBillingDetail(OrderDetail orderDetail, BillingAddress billingAddress) {
		//System.out.println(orderDetail.getShippingAddress());
		billingAddress.setUser(orderDetail.getUsersDetail());
		orderDetail.setBillingAddress(billingAddress);
		return "success";
	}
	public String confirmOrder(OrderDetail orderDetail, CardDetail cardDetail) {
		//System.out.println(orderDetail.getShippingAddress());
		//System.out.println(orderDetail.getBillingAddress());		
		// save or update the order details
		this.orderService.add(orderDetail);
		
		
		// save or update the card details		
		cardDetail.setUserId(orderDetail.getUsersDetail().getId());
		cardDetail.setTotalCost(orderDetail.getCart().getGrandTotal());	
		System.out.println(cardDetail);
		
		//this.cardDetailService.add(cardDetail);		
		// remove items from cartItem and move it to confirm orderedItem
		List<CartItem> cartItems = orderDetail.getCart().getCartItems();
		OrderedItem orderedItem = null;
		for(CartItem item : cartItems) {
			orderedItem = new OrderedItem();
			orderedItem.setOrder(orderDetail);
			orderedItem.setProduct(item.getProduct());
			orderedItem.setQuantity(item.getQuantity());
			orderedItem.setTotalPrice(item.getTotalPrice());
			orderedItem.setUser(orderDetail.getUsersDetail());
			orderedItemService.add(orderedItem);
		}
		
		this.cartItemService.removeAll(orderDetail.getCart());
		
		return "success";
	}
	
}
