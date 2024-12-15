package com.bhawnagunwani.SpringBootSpringSecurityDemo.filter;

import java.io.IOException;

import org.springframework.web.filter.OncePerRequestFilter;

import com.bhawnagunwani.SpringBootSpringSecurityDemo.util.JwtUtil;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final JwtUtil jwtUtil;
	
	
	public JwtAuthenticationFilter(JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String authHeader = request.getHeader("Authorization");
		
		if(authHeader!= null && authHeader.startsWith("Bearer ")) {
			String token = authHeader.substring(7);
			String username = jwtUtil.validateToken(token);
			
			if(username != null) {
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username,  null, null);
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}
		
		filterChain.doFilter(request, response);
		
	}
	
}
