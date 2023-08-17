package com.slot.api.repo;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slot.api.entity.Game;

public interface GameRepository extends JpaRepository<Game, Integer>{

	Boolean ExistByGameNameAndDate(String name, LocalDate date);
}
