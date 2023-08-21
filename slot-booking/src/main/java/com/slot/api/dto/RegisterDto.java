package com.slot.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegisterDto {

	private String username;
	
	private String email;
	
	private String password;

}
