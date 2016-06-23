package com.khozema.iniitian.service;

import com.khozema.iniitian.entity.User;

public interface UserService {
	public void add(User u);
	public User getUserByEmailAddress(String emailAddress);
	
}
