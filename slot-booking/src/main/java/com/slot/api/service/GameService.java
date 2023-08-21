package com.slot.api.service;

import java.time.LocalDate;
import java.util.Set;

import com.slot.api.dto.GetSlotsDto;

public interface GameService{

	public Set<String> showAvailableGames();
	
	public Set<LocalDate> showAvailableDatesForGame(String gameName);
	
	public Set<String> showSlotsOnGameDate(GetSlotsDto details);
	
	public void addGame(String game);
}
