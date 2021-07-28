package com.example.vaccinatetogether.security;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	
	private static final String ID = "id";
	private static final String USER = "user";
	private static final String ROLE = "role";
	
	@Value("${jwt.secret}")
	private String secret;
	
	/** 
	 * Validates Jwt token and return account username if successful.
	 * If validation fails, throws JwtException
	 * */
	public String parseTokenUsername(String token) throws JwtException {
		try {
		Claims claim = Jwts.parser()
				.setSigningKey(secret)
				.parseClaimsJws(token)
				.getBody();
		if(claim == null) {
			throw new JwtException("JWT Validation failed");
		}
		
		String id = claim.get(USER).toString();
		
		return id;
		} catch(Exception e) {
			throw new JwtException(e.getMessage());
		}
	}
	
	/** 
	 * Validates Jwt token and return account Id if successful.
	 * If validation fails, throws JwtException
	 * */
	public String parseToken(String token) throws JwtException {
		try {
		Claims claim = Jwts.parser()
				.setSigningKey(secret)
				.parseClaimsJws(token)
				.getBody();
		if(claim == null) {
			throw new JwtException("JWT Validation failed");
		}
		
		String id = claim.get(ID).toString();
		
		return id;
		} catch(Exception e) {
			throw new JwtException(e.getMessage());
		}
	}
	
	/** 
	 * Generate Jwt token with Account model.
	 * By default token's expire date is 1 day.
	 * Returns token
	 * */
	public String generateToken(String username, String role) {
		Date today = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(today);
		c.add(Calendar.DATE, 1);
		Date expiryDt = c.getTime();
		
		Claims claims = Jwts.claims().setExpiration(expiryDt);
		
		claims.put(USER, username);
		claims.put(ROLE, role);
		
		String jwtString = Jwts.builder()
			.addClaims(claims)
			.signWith(SignatureAlgorithm.HS512, secret)
			.compact();
		
		return jwtString;
	}
}
