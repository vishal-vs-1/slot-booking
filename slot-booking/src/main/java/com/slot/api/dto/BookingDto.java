package com.slot.api.dto;

import java.time.LocalDate;
import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookingDto {

	private int id;
	
	private String gameName;
	
	private LocalDate date;
	
	private Set<Integer> slotId;
}
