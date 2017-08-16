package com.auth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "T_AUTH_ORDER")
public class OrderModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  
	@Column(name = "pkey")
	private int pkey;
	
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "productId")
	private String productId;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "orderTime")
	private String orderTime;

	public int getPkey() {
		return pkey;
	}

	public void setPkey(int pkey) {
		this.pkey = pkey;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public OrderModel() {
	}

	public OrderModel(int pkey, String userName, String productId,
			double price, int status, String orderTime) {
		super();
		this.pkey = pkey;
		this.userName = userName;
		this.productId = productId;
		this.price = price;
		this.status = status;
		this.orderTime = orderTime;
	}

	public OrderModel(String userName, String productId, double price) {
		super();
		this.userName = userName;
		this.productId = productId;
		this.price = price;
	}

	public OrderModel(int pkey) {
		this.pkey = pkey;
	}

}
