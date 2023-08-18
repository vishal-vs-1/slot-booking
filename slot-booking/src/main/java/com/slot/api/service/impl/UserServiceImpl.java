package com.slot.api.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.slot.api.dto.BookingDto;
import com.slot.api.dto.RegisterDto;
import com.slot.api.entity.UserEntity;
import com.slot.api.exception.DetailsAlreadyPresentException;
import com.slot.api.exception.DetailsNotAvailableException;
import com.slot.api.exception.InvalidBookingDetailsException;
import com.slot.api.exception.InvalidGameDetailsException;
import com.slot.api.mapper.DtoMapper;
import com.slot.api.mapper.EntityMapper;
import com.slot.api.repo.BookingRepository;
import com.slot.api.repo.GameRepository;
import com.slot.api.repo.SlotRepository;
import com.slot.api.repo.UserRepository;
import com.slot.api.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

	private GameRepository gameRepo;
	
	private UserRepository userRepo;
	
	private SlotRepository slotRepo;
	 
	private BookingRepository bookRepo;

	@Override
	public String bookGame(BookingDto details, String email) {
		if(!gameRepo.ExistByGameNameAndDate(details.getGameName(), details.getDate()))
			throw new InvalidGameDetailsException("Invalid details : No such game or available date exists");
		
		var booking = EntityMapper.prepareBooking(details);
		booking.setSlots(new HashSet<>());
		List<Integer> notExist = new ArrayList<>();
		details.getSlotId()
			   .stream().forEach(c-> slotRepo.findById(c)
									.ifPresentOrElse(s-> booking.getSlots().add(s)
									, ()-> notExist.add(c)));
									
		var user = getUser(email);
		booking.setUser(user);
		
		var b = bookRepo.save(booking);
		return "Booked sucessfully with booking id : " + b.getId();
	}

	@Override
	public List<BookingDto> getBookingDetails(String email) {
		var user = getUser(email);
		var list = bookRepo.findByUser(user);
		if(list.isEmpty())
			throw new DetailsNotAvailableException("No bookings present for your account");
		var dtoList = list.stream().map(c-> DtoMapper.prepareBookingDto(c))
								.collect(Collectors.toList());
		return dtoList;
	}

	
	@Override
	public String deleteBooking(String email, int id) {
		var booking = bookRepo.findById(id)
							.orElseThrow(() -> new DetailsNotAvailableException
									("No booking exist By the given id"));
		
		var user = getUser(email);
		if(booking.getUser() != user)
			throw new InvalidBookingDetailsException("Booking id doesn't belong to your account");
		
		bookRepo.delete(booking);
		
		return "booking successfully deleted for  id : " + id;
	}
	
	
	
	private UserEntity getUser(String email) {
		return userRepo.findByEmail(email).get();
	}
}
