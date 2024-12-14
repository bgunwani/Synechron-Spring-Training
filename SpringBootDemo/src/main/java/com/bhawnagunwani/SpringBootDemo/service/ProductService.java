package com.bhawnagunwani.SpringBootDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhawnagunwani.SpringBootDemo.entity.Product;
import com.bhawnagunwani.SpringBootDemo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public List<Product> getAllProducts() {
		return repository.findAll();
	}
	
	public Product addProduct(Product product) {
		return repository.save(product);
	}
	
}
