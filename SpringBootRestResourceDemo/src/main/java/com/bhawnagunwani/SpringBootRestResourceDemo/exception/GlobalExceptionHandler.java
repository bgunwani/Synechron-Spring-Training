package com.bhawnagunwani.SpringBootRestResourceDemo.exception;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<String> handleEntityNotFound(ResourceNotFoundException ex) {
		return new ResponseEntity<>("Entity Not Found: " + ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
}
