package com.bhawnagunwani.SpringBootDemo.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex) {
		return ResponseEntity.badRequest().body(ex.getMessage());
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleUserNotFoundException(UserNotFoundException ex) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("timestamp", LocalDateTime.now());
		response.put("message", ex.getMessage());
		response.put("status", HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, Object>> handleGenericException(GenericException ex) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("timestamp", LocalDateTime.now());
		response.put("message", "An unexpected error occurred.");
		response.put("details", ex.getMessage());
		response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);	
	}

}
