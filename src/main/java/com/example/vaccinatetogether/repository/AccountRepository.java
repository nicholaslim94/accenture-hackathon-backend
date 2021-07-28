package com.example.vaccinatetogether.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vaccinatetogether.model.Account;

public interface AccountRepository extends JpaRepository<Account, UUID> {
	Optional<Account> findByUsername(String username);
	
	Optional<Account> findById(UUID id);

}
