package com.slot.api.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slot.api.entity.Slot;

public interface SlotRepository extends JpaRepository<Slot, Integer>{
}
