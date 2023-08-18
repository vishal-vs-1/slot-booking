package com.slot.api.repo;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slot.api.entity.Game;
import com.slot.api.entity.Slot;

public interface GameRepository extends JpaRepository<Game, Integer>{

	Boolean ExistByGameNameAndDate(String name, LocalDate date);
	
	Set<String> findDistinctGameName();
	
	Boolean existByGameName(String gameName);
	
	Boolean existsByGameNameAndDate(String gameName, LocalDate date);
	
	Set<LocalDate> findDistinctDateByGameName(String gameName);
	
	Set<Slot> findSlotsByGameNameAndDate(String gameName, LocalDate date);
}
