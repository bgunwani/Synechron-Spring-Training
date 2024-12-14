package com.bhawnagunwani.SpringBootDemo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhawnagunwani.SpringBootDemo.service.GreetingService;

@RestController
public class HelloWorldController implements ErrorController {
	
	private final GreetingService greetingService;
	
	@Autowired
	public HelloWorldController(GreetingService greetingService) {
		this.greetingService = greetingService;
	}
	
	@Value("${geeting.message}")
	private String greetingMessage;

	// Request URL: http://localhost:8080/
	@GetMapping("/")
	public String sayHello() {
		return "Hello, Spring Boot!";
	}
	
	// Request URL: http://localhost:8080/welcome
	@GetMapping("/welcome")
	public String Welcome() {
		return "Welcome to Spring Boot!";
	}
	
	// Request URL: http://localhost:8080/json
	@GetMapping("/json")
	public Map<String, String> jsonResponse() {
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "This is a JSON response");
		return response;
	}
	
	@GetMapping("/greet")
	public String greet(@RequestParam String name) {
		return "Hello, " + name + "!";
	}
	
	@GetMapping("/user/{id}")
	public String getUser(@PathVariable int id) {
		return "User Id: " + id;
	}
	
	@GetMapping("/greet-again")
	public String greetAgain(@RequestParam String name) {
		return greetingService.getGreeting(name);
	}
	
	@GetMapping("/custom-greet")
	public String customGreet() {
		return greetingMessage;
	}
	
	@GetMapping("/error")
	public String throwError() {
		throw new IllegalArgumentException("This is a bad request.");
	}
	
}
