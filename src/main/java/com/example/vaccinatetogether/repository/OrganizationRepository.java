package com.example.vaccinatetogether.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.vaccinatetogether.model.Organization;

@Repository
public interface OrganizationRepository extends PagingAndSortingRepository<Organization, UUID> {
	Page<Organization> findAll(Pageable pageable);
	
	Page<Organization> findAllByName(String name, Pageable pageable);

}
