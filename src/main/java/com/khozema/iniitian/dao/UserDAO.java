package com.khozema.iniitian.dao;

import com.khozema.iniitian.entity.User;

public interface UserDAO {
	public void add(User u);
	public User getUserByEmailAddress(String emailAddress);
}
