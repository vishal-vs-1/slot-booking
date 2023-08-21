package com.slot.api.mapper;

import java.time.LocalDate;
import java.util.HashSet;

import com.slot.api.dto.BookingDto;
import com.slot.api.dto.GetSlotsDto;
import com.slot.api.dto.RegisterDto;
import com.slot.api.entity.Booking;
import com.slot.api.entity.Game;
import com.slot.api.entity.UserEntity;

public class EntityMapper {
	
	public static UserEntity prepareUserRegistration(RegisterDto d) {
		return UserEntity.builder()
						 .username(d.getUsername())
						 .email(d.getEmail()).build();
	}
	
	public static Booking prepareBooking(BookingDto d) {
		return Booking.builder()
					  .gameName(d.getGameName())
					  .date(d.getDate()).build();
	}
	
	public static Game prepareGame(String name, LocalDate date) {
		return Game.builder()
				   .gameName(name)
				   .date(date)
				   .slots(new HashSet<>()).build();
	}
	
}
