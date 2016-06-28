package com.khozema.iniitian.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class ShippingAddress implements Serializable {

	@Override
	public String toString() {
		return "ShippingAddress [id=" + id + ", houseNumber=" + houseNumber + ", addressLine1=" + addressLine1
				+ ", addressLine2=" + addressLine2 + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", zipCode=" + zipCode + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1668589422022373544L;

    @Id
    @Column(name = "shippingAddressId")
    private Long id;
	private String houseNumber;
	@NotBlank( message = "Please enter address! *")
    private String addressLine1;
    private String addressLine2;
    @NotBlank( message = "Please select your city! *")
    private String city;
	@NotBlank( message = "Please select your state! *")
    private String state;
	@NotBlank( message = "Please select your country! *")
    private String country;
	@NotBlank( message = "Please enter zip code! *")
    private String zipCode;
    
    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    public ShippingAddress() {
    		
    		this.id = (long)(Math.random() * 1000000000L);
    	
    }
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
