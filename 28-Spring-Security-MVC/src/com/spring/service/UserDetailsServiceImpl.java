package com.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.dao.UserDetailsServiceDAO;
import com.spring.model.User;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDetailsServiceDAO userDetailsServiceDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDetailsServiceDAO.getUser(username);
		UserBuilder builder;
		if (user != null) {
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.password(user.getPassword());
			String[] strings = user.getauthorities().stream().map(x -> x.getAuthority()).toArray(String[]::new);
			builder.authorities(strings);
		} else {
			throw new UsernameNotFoundException("User not Found");
		}
		return builder.build();
	}
}
