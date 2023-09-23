package com.slot.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slot.api.dto.LoginDto;
import com.slot.api.dto.RegisterDto;
import com.slot.api.service.AuthenticationService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api")
public class AtuthenticationController {

	private AuthenticationService auth;
	
	private AuthenticationManager manager;
	
	@PostMapping("/register")
	ResponseEntity<String> registerUser(@RequestBody RegisterDto details){
		auth.registerUser(details);
		return new ResponseEntity<>("User Successfully registered", HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	ResponseEntity<String> login(@RequestBody LoginDto details){
		Authentication authentication = manager.authenticate(
					new UsernamePasswordAuthenticationToken(details.getEmail(), details.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return ResponseEntity.ok("login successfully!");
	}
}
