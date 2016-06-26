package com.khozema.iniitian.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CartItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8693665116181503471L;
	
	@Id
	@Column(name = "cartItemId")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "cartId")
	@JsonIgnore
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;
	
	private int quantity;
	private double totalPrice;
	
	public CartItem() {
		this.id = (long)(Math.random() * 1000000000000L);
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
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	

}
