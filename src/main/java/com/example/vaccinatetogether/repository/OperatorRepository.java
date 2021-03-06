package com.example.vaccinatetogether.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vaccinatetogether.model.Operator;

@Repository
public interface OperatorRepository extends JpaRepository<Operator, UUID> {
	Optional<Operator> findByUsername(String username);
	
	Optional<Operator> findById(UUID id);
}
