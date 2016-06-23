package com.khozema.iniitian.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.khozema.iniitian.dao.RoleDAO;
import com.khozema.iniitian.dao.UserDAO;
import com.khozema.iniitian.entity.Role;
import com.khozema.iniitian.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private RoleDAO roleDAO;

	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
			
	@Override
	@Transactional
	public void add(User user) {
		//enable the user
		user.setEnabled(true);
		this.userDAO.add(user);
		
		Role role = new Role();
		role.setAuthority("ROLE_USER");
		role.setUser(user);
		this.roleDAO.add(role);
					
	}


	@Override
	@Transactional
	public User getUserByEmailAddress(String emailAddress) {		
		return this.userDAO.getUserByEmailAddress(emailAddress);
	}
	
}
