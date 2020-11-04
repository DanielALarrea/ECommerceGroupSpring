package com.cognixia.ecommerce.models;

public class User {
	
	private String email;
	private String password;
	private String role;
	private Cart cart;
	
	public User() {
		
	}
	
	public User(String email, String password, String role, Cart cart) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
		this.cart = cart;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", role=" + role + ", cart=" + cart + "]";
	}

}
