package com.auth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;

@Entity
@Table(name = "T_SYS_PRODUCT")
public class ProductModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  
	@Column(name = "pkey")
	private int pkey;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "imageUrl")
	private String imageUrl;
	
	@Column(name = "beizhu")
	private String beizhu;
	

	public int getPkey() {
		return pkey;
	}

	public void setPkey(int pkey) {
		this.pkey = pkey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public ProductModel() {
		super();
	}

	public ProductModel(int pkey, String name, String imageUrl, String beizhu) {
		super();
		this.pkey = pkey;
		this.name = name;
		this.imageUrl = imageUrl;
		this.beizhu = beizhu;
	}

	public ProductModel(String name, String imageUrl, String beizhu) {
		super();
		this.name = name;
		this.imageUrl = imageUrl;
		this.beizhu = beizhu;
	}

	public ProductModel(int pkey) {
		super();
		this.pkey = pkey;
	}

}
