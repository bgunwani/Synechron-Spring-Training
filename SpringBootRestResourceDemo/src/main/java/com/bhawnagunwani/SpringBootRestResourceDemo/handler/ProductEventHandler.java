package com.bhawnagunwani.SpringBootRestResourceDemo.handler;

import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import com.bhawnagunwani.SpringBootRestResourceDemo.entity.Product;

@Component
@RepositoryEventHandler(Product.class)
public class ProductEventHandler {

	@HandleBeforeSave
	public void handleProductSave(Product product) {
		System.out.println("Before Saving: " + product.getName());
		// Add Some Custom Validation or Logic Here..
	}
	
}

