package com.bhawnagunwani.SpringBootDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bhawnagunwani.SpringBootDemo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	// Find Products by name. (It will generate the query automatically)
	List<Product> findByName(String name);
	
	// Find Products with Price greater than a certain value.
	List<Product> findByPriceGreaterThan(double price);
	
	// Find products with name containing a certain string.
	List<Product> findByNameContaining(String namePart);
	
	// Custom JQL Query: To find products by name
	@Query("SELECT p FROM Product p WHERE p.name = :name")
	List<Product> findProductsByName(String name);
	
	// Custom JPQL Query: To find products with price less than a certain value
	@Query("SELECT p FROM Product p WHERE p.price < :price")
	List<Product> findProductsByPriceLessThan(double price);
	
}
