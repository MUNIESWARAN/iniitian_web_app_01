package com.khozema.iniitian.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class OrderDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2392248646686993779L;
	
    @Id
    private Long id;
    
	@OneToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "userId")
    private User usersDetail;

	@OneToOne
    @JoinColumn(name = "billingAddressId")
    private BillingAddress billingAddress;

    @OneToOne
    @JoinColumn(name="shippingAddressId")
    private ShippingAddress shippingAddress;

    
    public OrderDetail() {
    		this.id = (long)(Math.random() * 1000000000L);
    }
    
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public User getUsersDetail() {
		return usersDetail;
	}

	public void setUsersDetail(User usersDetail) {
		this.usersDetail = usersDetail;
	}

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	

}
