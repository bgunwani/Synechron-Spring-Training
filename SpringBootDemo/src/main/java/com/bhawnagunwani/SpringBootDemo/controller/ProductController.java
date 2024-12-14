package com.bhawnagunwani.SpringBootDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
}
