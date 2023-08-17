package com.slot.api.service;

import com.slot.api.dto.BookingDto;
import com.slot.api.dto.RegisterDto;

public interface UserService {

	public void registerUser(RegisterDto details);
	
	public void bookGame(BookingDto details, String email);
}
