package com.ecommerce.services;

import java.util.List;

import com.ecommerce.beans.Product;

public interface ProductService {
	
	List<Product> getAllProducts();
	
	Product getProductById (int id);
	
	void addProduct(Product product);
	
	void editProduct(Product product);
	
	void deleteProduct(Product product);

}
