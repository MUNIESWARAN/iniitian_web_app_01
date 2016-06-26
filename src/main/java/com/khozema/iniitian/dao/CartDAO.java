package com.khozema.iniitian.dao;

import java.io.IOException;

import com.khozema.iniitian.entity.Cart;

public interface CartDAO {

	public Cart get(Long id);
	public void update(Cart cart);
	public Cart validate(Long id) throws IOException;
	
}
