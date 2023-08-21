package com.slot.api.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.slot.api.dto.GetSlotsDto;
import com.slot.api.entity.Game;
import com.slot.api.exception.DetailsAlreadyPresentException;
import com.slot.api.exception.DetailsNotAvailableException;
import com.slot.api.mapper.EntityMapper;
import com.slot.api.repo.GameRepository;
import com.slot.api.service.GameService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GameServiceImpl implements GameService{

	private GameRepository gameRepository;
	
	@Override
	public Set<String> showAvailableGames(){
		var gameList = gameRepository.findDistinctGameName();
		if(gameList.isEmpty())
			throw new DetailsNotAvailableException("No games available at  the moment");
		return gameList;
	}
	
	@Override
	public Set<LocalDate> showAvailableDatesForGame(String gameName) {
		if(!gameRepository.existsByGameName(gameName))
			throw new DetailsNotAvailableException("No game in database by this name");
		var dateList = gameRepository.findDistinctDateByGameName(gameName);
		if(dateList.isEmpty())
			throw new DetailsNotAvailableException("No dates available for booking yet");
		return dateList;
	}
	
	@Override
	public Set<String> showSlotsOnGameDate(GetSlotsDto details) {
		var date = details.getDate();
		var game = details.getGameName();
		if(!gameRepository.existsByGameName(game))
			throw new DetailsNotAvailableException("No game in database by this name");
		if(!gameRepository.existsByGameNameAndDate(game, date))
			throw new DetailsNotAvailableException("No such date available for selected game");
		
		var slots = gameRepository.findSlotsByGameNameAndDate(game, date);
		return slots.stream().map(c-> c.getTiming()).collect(Collectors.toSet());
	}

	@Override
	public void addGame(String game) {
		if(gameRepository.existsByGameName(game))
			throw new DetailsAlreadyPresentException("Game  is  already added");
		List<Game> list = new ArrayList<>();
		int i = 0;
		while(i<5) {
			var date = LocalDate.now().plusDays(i);
			list.add(EntityMapper.prepareGame(game, date));
			i++;
		}
		list.stream().forEach(c-> gameRepository.save(c));
	}
}