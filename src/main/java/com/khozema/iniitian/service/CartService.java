package com.khozema.iniitian.service;

import com.khozema.iniitian.entity.Cart;

public interface CartService {
	public Cart get(Long id);
	public void update(Cart cart);
}
