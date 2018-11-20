package com.spring.dao;

import com.spring.model.User;

public interface UserDetailsServiceDAO {

	public User getUser(String username);
}
