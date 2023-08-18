package com.slot.api.service;

import com.slot.api.dto.RegisterDto;

public interface AuthenticationService {

	public void registerUser(RegisterDto details);
}
