package com.example.vaccinatetogether.service;

import org.springframework.data.domain.Page;

import com.example.vaccinatetogether.exception.OrganizationException;
import com.example.vaccinatetogether.model.Organization;

public interface OrganizationService {
	
	Page<Organization> getOrgs(int page, int size);
	
	Page<Organization> getOrg(String name, int page, int size);
	
	void saveOrg(Organization org) throws OrganizationException;
	
	void modifyOrg(String id, Organization org) throws OrganizationException;
	
	void removeOrg(String id) throws OrganizationException, IllegalArgumentException;
	
	Organization findOrg(String id) throws OrganizationException;
}
