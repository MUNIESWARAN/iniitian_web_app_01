package com.khozema.iniitian.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5458313429441313892L;
	@Id
	@Column(name="productId")
	private Long id;
	@NotBlank(message = "Please enter a name! *")
	private String name;
	@NotBlank(message = "Please enter brand name! *")
	private String brand;
	private double price;
	@NotBlank(message = "Please enter description! *")
	private String description;
	private String imageUrl;
	@Range(min = 1 , message = "Please select a category! *")
	private int categoryId;	
	
	@Transient
	private boolean newProduct;
	
	public boolean isNewProduct() {
		return newProduct;
	}

	public void setNewProduct(boolean newProduct) {
		this.newProduct = newProduct;
	}

	@Transient
	@JsonIgnore
	private MultipartFile file;
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public int getCategoryId() {
		return categoryId;
	}
	
	public Product() {
		this.id =(long)(Math.random() * 1000000);
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", price=" + price 
				+ ", description=" + description + ", imageUrl=" + imageUrl + ", categoryId=" + categoryId
				+ "]";
	}
	
	
	
}
