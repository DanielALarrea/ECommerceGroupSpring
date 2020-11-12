package com.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.ecommerce.beans.Product;
import com.ecommerce.services.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	private static String viewProductPage = "test/viewproduct";
	private static String editProductPage = "test/editproduct";
	private static String addProductPage = "test/addproduct";
	private static String redirectToView = "redirect:/viewproduct";
	
	private static final String LOCAL_PROJECT = "D:/GitHub Repos/ECommerceGroupSpring";
	
	private static final String UPLOAD_DIRECTORY = LOCAL_PROJECT + "/WebContent/resources/theme1/assets/productpics";
	
	@GetMapping("/viewproduct")
	public String viewProductList(Model m) {
		List<Product> productList = service.getAllProducts();
		m.addAttribute("list", productList);
		return viewProductPage;
	}
	
	@GetMapping("/addproduct")
	public String addProductForm(Model m) {
		m.addAttribute("command", new Product());
		return addProductPage;
	}
	
	@PostMapping("/addproduct")
	public String addProduct(@ModelAttribute("product") Product product) {
		service.addProduct(product);
		return redirectToView;
	}
	
	@GetMapping("/editproduct/{id}")
	public String editProductForm(@PathVariable int id, Model m) {
		Product product = service.getProductById(id);
		product.setId(id);
		m.addAttribute("command", product);
		return editProductPage;
	}
	
	@PostMapping("/editproduct")
	public String editProduct(@ModelAttribute("product") Product product) {
		service.editProduct(product);
		return redirectToView;
	}
	
	@GetMapping("/deleteproduct/{id}")    
    public String deleteProduct(@PathVariable int id){
		service.deleteProduct(id);
        return redirectToView;    
    }

}
