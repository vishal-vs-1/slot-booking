package com.slot.api.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetSlotsDto {
	
	private String gameName;
	
	private LocalDate date;
}
