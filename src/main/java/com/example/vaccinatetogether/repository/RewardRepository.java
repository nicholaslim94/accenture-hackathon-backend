package com.example.vaccinatetogether.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.vaccinatetogether.model.Reward;

@Repository
public interface RewardRepository extends PagingAndSortingRepository<Reward, UUID> {
	Page<Reward> findAll(Pageable pageable);
	
	@EntityGraph(value = "Reward.organization", type = EntityGraphType.FETCH)
	Page<Reward> findAllByOrganizationId(String id, Pageable pageable);
}
