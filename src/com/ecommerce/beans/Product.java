package com.ecommerce.beans;

import javax.persistence.*;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	
	private String productName;
	private String productDescription;
	private float productPrice;
	private String productImagePath;
	
	public Product() {
		
	}
	
	public Product(String productName, String productDescription, float productPrice) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productImagePath = "";
	}

	public Product(String productName, String productDescription, float productPrice, String productImagePath) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productImagePath = productImagePath;
	}

	public int getId() {
		return productId;
	}

	public void setId(int id) {
		this.productId = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductImagePath() {
		return productImagePath;
	}

	public void setProductImagePath(String productImagePath) {
		this.productImagePath = productImagePath;
	}
	
}
