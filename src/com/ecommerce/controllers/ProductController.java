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
	
	@GetMapping("/viewproduct")
	public String viewProductList(Model m) {
		List<Product> productList = service.getAllProducts();
		m.addAttribute("list", productList);
		return "viewproduct";
	}
	
	@GetMapping("/addproduct")
	public String addProductForm(Model m) {
		m.addAttribute("command", new Product());
		return "addproduct";
	}
	
	@PostMapping("/addproduct")
	public String addProduct(@ModelAttribute("product") Product product) {
		service.addProduct(product);
		return "redirect:/viewproduct";
	}
	
	@GetMapping("/editproduct/{id}")
	public String editProductForm(@PathVariable int id, Model m) {
		Product product = service.getProductById(id);
		product.setId(id);
		m.addAttribute("command", product);
		return "editproduct";
	}
	
	@PostMapping("/editproduct")
	public String editProduct(@ModelAttribute("product") Product product) {
		service.editProduct(product);
		return "redirect:/viewproduct";
	}
	
	@GetMapping("/deleteproduct/{id}")    
    public String deleteProduct(@PathVariable int id){
		service.deleteProduct(id);
        return "redirect:/viewproduct";    
    }

}
