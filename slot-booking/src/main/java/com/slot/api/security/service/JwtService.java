package com.slot.api.security.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

public class JwtService {

	private String secret = "y0IJMxeQTemjLF2ajAgySFAcvdPCt5A9";
	
	public String extractEmail(String token) {
		return extractToken(token, t -> t.getSubject());
	} 
	
	public Date extractExpirationDate(String token) {
		return extractToken(token, t -> t.getExpiration());
	}
	
	public String generateToken(UserDetails ud) {
		return this.generateToken(new HashMap<>(), ud);
	}
	
	public boolean isTokenValid(String token, UserDetails ud) {
		return (!isTokenExpired(token));
	}
	
	public boolean isTokenExpired(String token) {		
		return false;
	}

	public String generateToken(Map<String, Object> extraClaims, UserDetails ud) {
		return Jwts.builder()
				   .setClaims(extraClaims)
				   .setSubject(ud.getUsername())
				   .setIssuedAt(new Date(System.currentTimeMillis()))
				   .setExpiration(new Date(System.currentTimeMillis() + 1000 *60))
				   .signWith(getSigninKey(), SignatureAlgorithm.HS256)
				   .compact();
				   
	}
	
	public <T> T extractToken(String token, Function<Claims, T> claimResolver) {
		Claims claims = extractClaims(token);
		return claimResolver.apply(claims);
	}
	
	public Claims extractClaims(String token) {
		return Jwts.parserBuilder()
				   .setSigningKey(getSigninKey())
				   .build()
				   .parseClaimsJws(token)
				   .getBody();
	}
	
	private Key getSigninKey() {
		byte[] key = Decoders.BASE64.decode(secret);
		return Keys.hmacShaKeyFor(key); 
	}
}