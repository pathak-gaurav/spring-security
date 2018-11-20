package com.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_generator")
	@SequenceGenerator(name = "user_id_generator", allocationSize = 1, initialValue = 101, sequenceName = "user_id_sequ")
	@Column(name = "USER_ID")
	private int userId;

	@Id
	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ENABLED")
	private String enabled;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
	private List<Authority> authorities;

	public User(String username, String password, String enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public User() {
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public List<Authority> getauthorities() {
		return authorities;
	}

	public void setauthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	
	public void addAuthorities(Authority tempAuthority){
		if(authorities==null){
			authorities =  new ArrayList<>();
		}
		authorities.add(tempAuthority);
		tempAuthority.setUsers(this);
	}
}
