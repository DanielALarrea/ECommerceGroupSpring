package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.beans.Product;

public interface ProductDao {

	List<Product> getAllProducts();

	Product getProductById (int id);

	void addProduct(Product product);

	void editProduct(Product product);

	void deleteProduct(int id);

}
