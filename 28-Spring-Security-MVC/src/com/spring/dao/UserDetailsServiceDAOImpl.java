package com.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.User;

@Repository
public class UserDetailsServiceDAOImpl implements UserDetailsServiceDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User getUser(String username) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, username);
		return user;
	}

}
