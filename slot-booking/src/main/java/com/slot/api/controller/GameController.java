package com.slot.api.controller;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slot.api.dto.GetSlotsDto;
import com.slot.api.service.GameService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api")
public class GameController {

	private GameService service;
	
	@GetMapping("/game-list")
	ResponseEntity<Set<String>> showAvailableGames(){
		return ResponseEntity.ok(service.showAvailableGames());
	}
	
	@GetMapping("game-dates")
	public ResponseEntity<Set<LocalDate>> showAvailableDatesForGame(String gameName){
		return ResponseEntity.ok(service.showAvailableDatesForGame(gameName));
	}
	
	@GetMapping("game-slots")
	public ResponseEntity<Set<String>> showSlotsOnGameDate(GetSlotsDto details){
		return ResponseEntity.ok(service.showSlotsOnGameDate(details));
	}
	
	@PostMapping("add-game/{game}")
	public ResponseEntity<String> addGame(@PathVariable String game){
		service.addGame(game);
		return ResponseEntity.ok("Game successfully added");
	}
}
