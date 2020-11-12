package com.ecommerce.beans;

import java.util.List;

public class Cart {
	
	private User customer;
	private List<Product> cartItems;
	private float totalPrice;
		
	public Cart() {
		
	}

	public Cart(User customer, List<Product> cartItems) {
		super();
		this.customer = customer;
		this.cartItems = cartItems;
		calculateTotalPrice();
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public List<Product> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<Product> cartItems) {
		this.cartItems = cartItems;
	}
	
	public void addToCart(Product product) {
		this.cartItems.add(product);
		calculateTotalPrice();
	}
	
	public void removeFromCart(Product product) {
		this.cartItems.remove(product);
		calculateTotalPrice();
	}
	
	public void calculateTotalPrice() {
		float totalPrice = 0;
		for(Product product: this.cartItems) {
			totalPrice += product.getPrice();
		}
		this.totalPrice = totalPrice;
	}
	
	public float getTotalPrice() {
		return this.totalPrice;
	}
}
