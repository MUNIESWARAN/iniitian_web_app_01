package com.khozema.iniitian.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8451710539908295586L;
	@Id
	@Column(name = "userId")
	private Long id;
	@NotBlank(message = "Please enter firstname!")
	private String firstName;
	@NotBlank(message = "Please enter lastname!")
	private String lastName;
	@NotBlank(message = "Please enter email address!")
	@Column(name = "username")
	private String emailAddress;
	@NotBlank(message = "Please enter password!")
	private String password;
	@Transient
	@NotBlank(message = "Please enter confirm password!")
	private String confirmPassword;
	private boolean enabled;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cartId")
	private Cart cart;
	
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public User(){
		this.id = (long)(Math.random() * 1000000000);
	}
	
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailId(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
}
