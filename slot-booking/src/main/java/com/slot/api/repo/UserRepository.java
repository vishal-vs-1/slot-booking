package com.slot.api.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slot.api.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

	 Boolean existByEmail(String email);
	 Optional<UserEntity> findByEmail(String email);
}
