package com.ecommerce.services;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.beans.Product;
import com.ecommerce.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
//	private static final String LOCAL_PROJECT = "D:/GitHub Repos/ECommerceGroupSpring";
//	
//	private static final String UPLOAD_DIRECTORY = LOCAL_PROJECT + "/WebContent/resources/theme1/assets/productpics";

	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}

	public Product getProductById (int id) {
		return productDao.getProductById(id);
	}

	public void addProduct(Product product) {
		productDao.addProduct(uploadProductImage(product));
	}

	public void editProduct(Product product) {
		productDao.editProduct(uploadProductImage(product));
	}

	public void deleteProduct(int id) {
		productDao.deleteProduct(id);
	}
	
	public Product uploadProductImage(Product product) {
		String path = "D:/project3_images";
		String fileName = product.getName() + ".png";
		
		String imagePath = path + "/" + fileName;
		
		try	{
			product.getImage().transferTo(new File(imagePath));
		} catch (Exception e) {
			System.out.println(e);
		}
		
		product.setImagePath(imagePath);
		
		return product;
	}

}
