package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.Authority;
import com.spring.model.User;

@Repository
public class UserDetailsDAOImpl implements UserDetailsDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<User> getUsers() {
		Session session = sessionFactory.getCurrentSession();
		List<User> list = session.createQuery("from User",User.class).getResultList();
		if(list.isEmpty()){
			User user = new User("gaurav","{bcrypt}$2a$04$KeBnW9Xxtr7HLGGIaRdB2.oQ0EqLFVwc24MgSo4pN8YWQGCjVXaEy","true");
			session.save(user);
			Authority authority = new Authority("ADMIN");
			user.addAuthorities(authority);
			session.save(authority);
		}
		return list;
	}

}
