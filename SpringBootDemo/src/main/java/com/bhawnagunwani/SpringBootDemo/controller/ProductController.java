package com.bhawnagunwani.SpringBootDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhawnagunwani.SpringBootDemo.entity.Product;
import com.bhawnagunwani.SpringBootDemo.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	ProductService productService;
	
	public ProductController() {
		this.productService = new ProductService();
	}
	
	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}
	
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		return "Product Deleted.";
	}
	
	
	// Request URL: http://localhost:8081/api/products/searchByName?name=Wireless%20Bluetooth
	@GetMapping("/searchByName")
	public List<Product> searchByName(@RequestParam String name) {
		return productService.getProductsByName(name);
	}
	
	// Request URL: http://localhost:8081/api/products/searchByPriceGreaterThan?price=5000
	@GetMapping("/searchByPriceGreaterThan")
	public List<Product> searchByPrice(@RequestParam double price) {
		return productService.getProductsByPriceGreaterThan(price);
	}
}
