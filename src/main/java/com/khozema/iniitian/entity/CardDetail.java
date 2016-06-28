package com.khozema.iniitian.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CardDetail implements Serializable {
	@Override
	public String toString() {
		return "CardDetail [id=" + id + ", cardType=" + cardType + ", cardNumber=" + cardNumber + ", expiryMonth="
				+ expiryMonth + ", expiryYear=" + expiryYear + ", cvNumber=" + cvNumber + ", nameOnCard=" + nameOnCard
				+ ", atmPin=" + atmPin + ", totalCost=" + totalCost + "]";
	}

	private static final long serialVersionUID = -8090789645980719576L;

	@Id
    @GeneratedValue
    @Column (name = "cardId")
    private Long id;
	
	@NotBlank (message = "Please select card type! *")
    private String cardType;
	
	@NotBlank (message = "The card number must not be blank! *")
    private String cardNumber;

    @NotBlank (message = "Please select expiry month! *")
    private String expiryMonth;

	@NotBlank (message = "Please select expiry year! *")
    private String expiryYear;

    @NotBlank (message = "The CVV2/CVC2 number must not be empty! *")
    private String cvNumber;

    @NotBlank (message = "The name must not be blank! *")
    private String nameOnCard;
    
    @NotBlank (message = "The ATM pin must not be empty! *")
    private String atmPin;
        
    private Long userId;
    
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	private double totalCost;
	
	public CardDetail() {
		this.id = (long)(Math.random() * 10000000000L);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpiryMonth() {
		return expiryMonth;
	}

	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public String getExpiryYear() {
		return expiryYear;
	}

	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}

	public String getCvNumber() {
		return cvNumber;
	}

	public void setCvNumber(String cvNumber) {
		this.cvNumber = cvNumber;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getAtmPin() {
		return atmPin;
	}

	public void setAtmPin(String atmPin) {
		this.atmPin = atmPin;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

}
