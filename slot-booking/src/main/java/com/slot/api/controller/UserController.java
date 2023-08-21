package com.slot.api.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slot.api.dto.BookingDto;
import com.slot.api.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/user")
public class UserController {

	private UserService service;
	
	@PostMapping("/booking")
	ResponseEntity<String> bookGame(@RequestBody BookingDto details, Principal p) {
		return new ResponseEntity<>(service.bookGame(details, p.getName()),HttpStatus.CREATED);
	}
	
	@GetMapping("/booking")
	ResponseEntity<List<BookingDto>> getBookingDetails(Principal p){
		return ResponseEntity.ok(service.getBookingDetails(p.getName()));
	}
	
	@DeleteMapping("/booking")
	ResponseEntity<String> deleteBooking(Principal p, int id){
		return new ResponseEntity<>(service.deleteBooking(p.getName(), id), HttpStatus.NO_CONTENT); 
	}
}
