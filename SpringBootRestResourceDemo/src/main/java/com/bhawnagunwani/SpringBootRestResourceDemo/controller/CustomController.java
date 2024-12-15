package com.bhawnagunwani.SpringBootRestResourceDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomController {

	@GetMapping("/customProducts")
	public String customEndpoint(@RequestParam String filter) {
		return "Filtered Products: " + filter;
	}
	
}
