package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.UserDetailsDAO;
import com.spring.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDetailsDAO userDetailsDAO; 

	@Override
	public List<User> getUsers() {
		return userDetailsDAO.getUsers();
	}

}
