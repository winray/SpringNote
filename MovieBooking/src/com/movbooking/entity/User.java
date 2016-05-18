package com.movbooking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="user")
public class User {
	@Id
	@Column(name="username")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	public User() {}
	
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	@NotEmpty(message="鐢ㄦ埛鍚嶄笉鑳戒负绌�")
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Size(min=1, max=20, message="瀵嗙爜闀垮害搴旇鍦�1-20涔嬮棿")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User {userName=" + userName + ", password=" + password + "}";
	}
	
}