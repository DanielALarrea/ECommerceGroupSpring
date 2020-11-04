package com.cognixia.ecommerce.models;

import java.util.List;

public class Cart {
	
	private List<Product> products;
	private float totalPrice;
	
	public Cart(List<Product> products) {
		super();
		this.products = products;
		this.totalPrice = 0;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public void addProduct(Product product) {
		this.products.add(product);
	}
	
	public void removeProduct(Product product) {
		this.products.remove(product);
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public float calculateTotalPrice() {
		float totalPrice = 0;
		for(Product product: this.products) {
			totalPrice += product.getPrice();
		}
		
		return totalPrice;
	}

	@Override
	public String toString() {
		return "Cart [products=" + products + ", totalPrice=" + totalPrice + "]";
	}

}
