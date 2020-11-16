package com.ecommerce.beans;

import javax.persistence.*;

@Entity
public class User {

	public enum ROLE {
		CUSTOMER, ADMIN
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private float userId;

	private String firstName;
	private String lastName;
	private String userEmail;
	private String username;
	private String userPass;
	private ROLE userRole;
	private String phone;

	@OneToOne
	private Address billingAddress;
	
	public User() {
		
	}

	public User(String firstName, String lastName, String userEmail, String username, String userPass,
			ROLE userRole, Address billingAddress, String phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userEmail = userEmail;
		this.username = username;
		this.userPass = userPass;
		this.userRole = userRole;
		this.billingAddress = billingAddress;
		this.phone = phone;
	}

	public float getId() {
		return userId;
	}

	public void setId(float id) {
		this.userId = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public ROLE getUserRole() {
		return userRole;
	}

	public void setUserRole(ROLE userRole) {
		this.userRole = userRole;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
