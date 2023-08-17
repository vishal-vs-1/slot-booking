package com.slot.api.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookingDto {
	
	private String gameName;
	
	private LocalDate date;

	private Set<SlotDto> slots = new HashSet<>();
}
