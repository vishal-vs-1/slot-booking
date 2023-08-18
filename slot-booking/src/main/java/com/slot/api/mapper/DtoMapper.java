package com.slot.api.mapper;

import com.slot.api.dto.BookingDto;
import com.slot.api.entity.Booking;

public class DtoMapper {
	
	public static BookingDto prepareBookingDto(Booking d) {
		var obj = BookingDto.builder()
					  .gameName(d.getGameName())
					  .id(d.getId())
					  .date(d.getDate()).build();
		d.getSlots().stream()
					.forEach(c-> obj.getSlotId().add(c.getId()));
		return obj;
	}
}
