package com.slot.api.service;

import java.util.List;

import com.slot.api.dto.BookingDto;
import com.slot.api.dto.RegisterDto;

public interface UserService {
	
	public String bookGame(BookingDto details, String email);
	
	public List<BookingDto> getBookingDetails(String email);
	
	public String deleteBooking(String email, int id);
}
