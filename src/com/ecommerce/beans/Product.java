package com.ecommerce.beans;

import javax.persistence.*;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {
	
	@Id
	private int id;
	private String name;
	private String imagePath;
	private String description;
	private double price;
	private int stock;
	private boolean inStock;
	
	private MultipartFile image;
	
	public Product() {
		
	}
	
	public Product(int id, String name, String imagePath, String description, double price, int stock,
			boolean inStock) {
		super();
		this.id = id;
		this.name = name;
		this.imagePath = imagePath;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.inStock = inStock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}
}
