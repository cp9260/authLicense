package com.auth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "T_SYS_AUTH")
public class AuthModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  
	@Column(name = "pkey")
	private int pkey;
	
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "ip")
	private String ip;
	
	@Column(name = "domain")
	private String domain;
	
	@Column(name = "licenseKey")
	private String licenseKey;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "productId")
	private String productId;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getLicenseKey() {
		return licenseKey;
	}

	public void setLicenseKey(String licenseKey) {
		this.licenseKey = licenseKey;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getPkey() {
		return pkey;
	}

	public void setPkey(int pkey) {
		this.pkey = pkey;
	}

	public AuthModel(int pkey) {
		super();
		this.pkey = pkey;
	}

	public AuthModel() {
		// TODO Auto-generated constructor stub
	}

	public AuthModel(int pkey, String userName, String ip, String domain,
			String licenseKey, String status, String productId) {
		super();
		this.pkey = pkey;
		this.userName = userName;
		this.ip = ip;
		this.domain = domain;
		this.licenseKey = licenseKey;
		this.status = status;
		this.productId = productId;
	}

	public AuthModel(String userName, String ip, String domain,
			String licenseKey, String status, String productId) {
		super();
		this.userName = userName;
		this.ip = ip;
		this.domain = domain;
		this.licenseKey = licenseKey;
		this.status = status;
		this.productId = productId;
	}
	
	

}
