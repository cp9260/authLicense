package com.auth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_USER_INFOS")
public class UserModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  
	@Column(name = "pkey",unique = true,nullable=false)
	private int pkey;
	 
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "mobile")
	private String mobile;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "status")
	private int status;

	public UserModel(){
		
	}

	public UserModel(String userName2, String password2, String mobile2,
			String email2) {
		this.userName = userName2;
		this.password = password2;
		this.mobile = mobile2;
		this.email = email2;
	}

	public UserModel(int pkey2, String userName2, String password2,
			String mobile2, String email2) {
		this.pkey = pkey2;
		this.userName = userName2;
		this.password = password2;
		this.mobile = mobile2;
		this.email = email2;
	}

	public UserModel(int pkey2) {
		this.pkey = pkey2;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
