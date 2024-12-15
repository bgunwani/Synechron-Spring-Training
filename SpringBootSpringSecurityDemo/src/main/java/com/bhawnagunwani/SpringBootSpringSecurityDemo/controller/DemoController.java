package com.bhawnagunwani.SpringBootSpringSecurityDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhawnagunwani.SpringBootSpringSecurityDemo.util.JwtUtil;

@RestController
//@RequestMapping("")
public class DemoController {

	private final JwtUtil jwtUtil;
	
	public DemoController(JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}
	
	@GetMapping("/home")
	public String home() {
		return "Home";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password) {
		if("admin".equals(username) && "admin123".equals(password)) {
			System.out.println("login invoked.");
			System.out.println(jwtUtil.generateToken(username));
			return jwtUtil.generateToken(username);
		}
		return "Invalid Username and Password";
	}
}
