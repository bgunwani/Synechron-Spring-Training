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
	
	public Product getProductById(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public void deleteProduct(Long id) {
		repository.deleteById(id);
	}
	
	public List<Product> getProductsByName(String name) {
		return repository.findByName(name);
	}
	
	public List<Product> getProductsByPriceGreaterThan(double price) {
		return repository.findByPriceGreaterThan(price);
	}
	
	public List<Product> getProductsByNameContaining(String namePart) {
		return repository.findByNameContaining(namePart);
	}
	
	public List<Product> getProdByName(String name) {
		return repository.findProductsByName(name);
	}
	
	public List<Product> getProdByPriceLessThan(double price) {
		return repository.findProductsByPriceLessThan(price);
	}
	
}
