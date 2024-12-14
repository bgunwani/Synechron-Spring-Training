package com.bhawnagunwani.SpringBootDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhawnagunwani.SpringBootDemo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
