package com.ecommerce.controllers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.beans.Product;
import com.ecommerce.services.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@Autowired
	private ServletContext servletContext;
	
	private String viewProducts = "products";
	private String viewProductsAdmin = "manage-products";
	private String viewProductPage = "test/viewproduct";
	private String editProductPage = "editproduct";
	private String addProductPage = "test/addproduct";
	private String redirectToView = "redirect:/viewproduct";
	
	@GetMapping("/admin")
	public String viewAdminPage(Model m){
		//m.addAttribute(new User("admin","admin","admin@admin.com","admin","admin","admin", new Address()));
		return "admin";
	}
	@GetMapping("/add-product")
	public String addProducts(Model m)
	{
		m.addAttribute("command", new Product());
		return "addproduct";
	}
	@GetMapping("/manage-products")
	public String manageProducts(Model m) {
		List<Product> productList = service.getAllProducts();
		m.addAttribute("list", productList);
		return viewProductsAdmin;
	}
	@GetMapping("/products")
	public String viewProducts(Model m) {
		List<Product> productList = service.getAllProducts();
		m.addAttribute("list", productList);
		String path = servletContext.getRealPath("/")+"WebContent\\resources\\theme1\\assets\\productpics";

		path = path.replace(".metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\", "");
		
		System.out.println(path);
		return viewProducts;
	}
	
	@GetMapping("/admin-products")
	public String viewProductsAdmin(Model m) {
		List<Product> productList = service.getAllProducts();
		m.addAttribute("list", productList);
		return viewProductsAdmin;
	}
	
	@GetMapping("/viewproduct")
	public String viewProductList(Model m) {
		List<Product> productList = service.getAllProducts();
		m.addAttribute("list", productList);
		return viewProducts;
	}
	
	@GetMapping("/addproduct")
	public String addProductForm(Model m) {
		m.addAttribute("command", new Product());
		return addProductPage;
	}
	
	@PostMapping("/addproduct")
	public String addProduct(@ModelAttribute("product") Product product, Model m) {
		service.addProduct(product);
		List<Product> productList = service.getAllProducts();
		m.addAttribute("list", productList);
		return "redirect:/"+viewProducts;
	}
	
	@GetMapping("/editproduct")
	public String editProductForm(@RequestParam("id") int id, Model m) {
		Product product = service.getProductById(id);
		product.setId(id);
		m.addAttribute("command", product);
		return editProductPage;
	}
	/*
	 * @GetMapping("/editproduct/{id}") public String editProductForm(@PathVariable
	 * int id, Model m) { Product product = service.getProductById(id);
	 * product.setId(id); m.addAttribute("command", product); return
	 * editProductPage; }
	 */
	
	@PostMapping("/editproduct")
	public String editProduct(@ModelAttribute("product") Product product) {
		service.editProduct(product);
		return redirectToView;
	}
	
	@GetMapping("/deleteproduct/{id}")    
    public String deleteProduct(Model m, @PathVariable int id){
		service.deleteProduct(id);
		List<Product> productList = service.getAllProducts();
		m.addAttribute("list", productList);
        return "redirect:/"+viewProductsAdmin;    
    }

}
