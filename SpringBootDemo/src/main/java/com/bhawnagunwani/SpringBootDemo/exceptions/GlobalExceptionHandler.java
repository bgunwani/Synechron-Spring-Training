package com.bhawnagunwani.SpringBootDemo.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseBody
	public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex) {
		return ResponseEntity.badRequest().body(ex.getMessage());
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException ex) {
//		ErrorResponse erroResponse = new ErrorResponse(
//				LocalDateTime.now(),
//				ex.getMessage(),
//				null,
//				HttpStatus.NOT_FOUND.value());
//		return new ResponseEntity<>(erroResponse, HttpStatus.NOT_FOUND);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGenericException(GenericException ex) {
		ErrorResponse erroResponse = new ErrorResponse(
				LocalDateTime.now(),
				ex.getMessage(),
				null,
				HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<>(erroResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
