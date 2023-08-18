package com.slot.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slot.api.dto.RegisterDto;
import com.slot.api.service.AuthenticationService;

@RestController
@RequestMapping("api")
public class AtuthenticationController {

	private AuthenticationService auth;
	
	@PostMapping("/register")
	ResponseEntity<String> registerUser(RegisterDto details){
		auth.registerUser(details);
		return ResponseEntity.ok("User Successfully registered");
	}
}
