package com.bhawnagunwani.SpringBootSpringSecurityDemo.util;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    private static final String SECRET_KEY = "YourSecretKeyforJWTMustBeComplex";
    private static final long EXPIRATION_TIME = 86400000; // 1 day in milliseconds
    private static final byte[] SECRET_KEY_BYTES = SECRET_KEY.getBytes();

    // We create a SigningKey once to improve performance (avoid repeated calculations)
    private static final Key SIGNING_KEY = Keys.hmacShaKeyFor(SECRET_KEY_BYTES);

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SIGNING_KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    public String validateToken(String token) {
        try {
            Claims claims = Jwts.parserBuilder() // use parserBuilder() for better support with newer libraries
                    .setSigningKey(SIGNING_KEY)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            // Check if the token is expired
            if (claims.getExpiration().before(new Date())) {
                return null; // Token has expired
            }

            return claims.getSubject(); // returns the username from the token
        } catch (JwtException | IllegalArgumentException e) {
            // Log the exception (in production, you might want to log this)
            return null; // Token is invalid
        }
    }

    public String extractUsername(String token) {
        return validateToken(token); // This uses validateToken to extract the username
    }

    public boolean isTokenExpired(String token) {
        Date expirationDate = ((JwtParserBuilder) Jwts.builder())
                .setSigningKey(SIGNING_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return expirationDate.before(new Date());
    }

    public String refreshToken(String username) {
        return generateToken(username);
    }
}
