package com.slot.api.service.impl;

import java.security.Principal;

import org.springframework.stereotype.Service;

import com.slot.api.dto.BookingDto;
import com.slot.api.dto.RegisterDto;
import com.slot.api.entity.UserEntity;
import com.slot.api.exception.DetailsAlreadyPresentException;
import com.slot.api.exception.InvalidGameDetailsException;
import com.slot.api.mapper.EntityMapper;
import com.slot.api.repo.GameRepository;
import com.slot.api.repo.UserRepository;
import com.slot.api.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

	private GameRepository gameRepo;
	
	private UserRepository userRepo;

	@Override
	public void registerUser(RegisterDto details) {
		if(userRepo.existByEmail(details.getEmail()))
			throw new DetailsAlreadyPresentException("User is already registered with the given email");
		userRepo.save(EntityMapper.prepareUserRegistration(details));
	}

	@Override
	public void bookGame(BookingDto details, String email) {
		if(!gameRepo.ExistByGameNameAndDate(details.getGameName(), details.getDate()))
			throw new InvalidGameDetailsException("Invalid details : No such game or available date exists");
		details.getSlots().stream().filter(null)
		var user = userRepo.findByEmail(email).get();
		
		
	}
}
