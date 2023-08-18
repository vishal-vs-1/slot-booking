package com.slot.api.service.impl;

import org.springframework.stereotype.Service;

import com.slot.api.dto.RegisterDto;
import com.slot.api.exception.DetailsAlreadyPresentException;
import com.slot.api.mapper.EntityMapper;
import com.slot.api.repo.UserRepository;
import com.slot.api.service.AuthenticationService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{

	private UserRepository userRepo;
	
	@Override
	public void registerUser(RegisterDto details) {
		if(userRepo.existByEmail(details.getEmail()))
			throw new DetailsAlreadyPresentException("User is already registered with the given email");
		userRepo.save(EntityMapper.prepareUserRegistration(details));
	}
}
