package com.slot.api.mapper;

import com.slot.api.dto.BookingDto;
import com.slot.api.dto.RegisterDto;
import com.slot.api.entity.Booking;
import com.slot.api.entity.UserEntity;

public class EntityMapper {
	
	public static UserEntity prepareUserRegistration(RegisterDto d) {
		return UserEntity.builder()
						 .username(d.getUsername())
						 .email(d.getEmail())
						 .password(d.getPassword()).build();
	}
	public static Booking prepareBooking(BookingDto d) {
		return BookingDto.builder()
	}
	
}
