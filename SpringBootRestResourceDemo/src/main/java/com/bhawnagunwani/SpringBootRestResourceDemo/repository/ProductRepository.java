package com.bhawnagunwani.SpringBootRestResourceDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.bhawnagunwani.SpringBootRestResourceDemo.entity.Product;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
// @RepositoryRestResource(excerptProjection = NameOnlyProjection.class)
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	// Request URL: http://localhost:8080/api/products/search/findByName?name=Wireless%20Bluetooth
	List<Product> findByName(String name);
}
