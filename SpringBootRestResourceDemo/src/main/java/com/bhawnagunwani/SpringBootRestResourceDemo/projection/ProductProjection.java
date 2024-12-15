package com.bhawnagunwani.SpringBootRestResourceDemo.projection;

import org.springframework.data.rest.core.config.Projection;

import com.bhawnagunwani.SpringBootRestResourceDemo.entity.Product;

@Projection(name= "nameOnly", types = { Product.class } )
public interface ProductProjection {
	
	String getName();
	
}
