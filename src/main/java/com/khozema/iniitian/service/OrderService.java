package com.khozema.iniitian.service;

import com.khozema.iniitian.entity.OrderDetail;

public interface OrderService {
	public void add(OrderDetail order);
	public double getOrderGrandTotal(Long cartId);
}
