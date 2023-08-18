package com.slot.api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slot.api.entity.Booking;
import com.slot.api.entity.UserEntity;

public interface BookingRepository extends JpaRepository<Booking, Integer>{

	List<Booking> findByUser(UserEntity user);
}
