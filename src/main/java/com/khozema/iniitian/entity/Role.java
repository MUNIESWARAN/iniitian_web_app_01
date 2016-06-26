package com.khozema.iniitian.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class Role implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6745614742604718121L;
	
	@Id
	@Column(name = "authorityId")
	private Long id;
	private String authority;	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User user;
	
	public Role() {
		this.id = (long)(Math.random() * 10000000);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
