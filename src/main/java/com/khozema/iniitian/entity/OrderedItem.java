package com.khozema.iniitian.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderedItem implements Serializable {

	private static final long serialVersionUID = 7998354775759364734L;

	@Id
	@Column(name = "orderedItemId")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	@JsonIgnore
	private User user;

	@ManyToOne
	@JoinColumn(name = "orderId")
	@JsonIgnore
	private OrderDetail order;
		
	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;
		
	private int quantity;
	private double totalPrice;
	
	public OrderedItem() {
		this.id = (long)(Math.random() * 10000000000L);
	}
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public OrderDetail getOrder() {
		return order;
	}
	public void setOrder(OrderDetail order) {
		this.order = order;
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
