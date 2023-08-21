package com.slot.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slot.api.dto.RegisterDto;
import com.slot.api.service.AuthenticationService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api")
public class AtuthenticationController {

	private AuthenticationService auth;
	
	@PostMapping("/register")
	ResponseEntity<String> registerUser(@RequestBody RegisterDto details){
		auth.registerUser(details);
		return new ResponseEntity<>("User Successfully registered", HttpStatus.CREATED);
	}
}
