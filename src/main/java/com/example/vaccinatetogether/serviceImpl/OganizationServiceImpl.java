package com.example.vaccinatetogether.serviceImpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.vaccinatetogether.exception.OrganizationException;
import com.example.vaccinatetogether.model.Organization;
import com.example.vaccinatetogether.repository.OrganizationRepository;
import com.example.vaccinatetogether.service.OrganizationService;

@Service
public class OganizationServiceImpl implements OrganizationService {
	
	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Override
	public Page<Organization> getOrgs(int page, int size) {
		Pageable pagable = PageRequest.of(page, size);
		Page<Organization> orgPage = organizationRepository.findAll(pagable);
		return orgPage;
	}
	
	@Override
	public Page<Organization> getOrg(String name, int page, int size) {
		Pageable pagable = PageRequest.of(page, size);
		Page<Organization> orgPage = organizationRepository.findAllByName(name, pagable);
		return orgPage;
	}
	
	@Override
	public void saveOrg(Organization org) throws OrganizationException {
		Organization savedOrg = organizationRepository.save(org);
		if(savedOrg == null) {
			throw new OrganizationException("Failed to save Organisation: "+ org.getName());
		}
	}
	
	@Override
	public void modifyOrg(String id, Organization org) throws OrganizationException {
		Organization orgUpdate = findOrg(id);
		orgUpdate.setName(org.getName());
		orgUpdate.setDescription(org.getDescription());
		orgUpdate.setAddress(org.getAddress());
		orgUpdate.setWebsite(org.getWebsite());
		orgUpdate.setNo(org.getNo());
		saveOrg(orgUpdate);
	}
	
	@Override
	public void removeOrg(String id) throws OrganizationException, IllegalArgumentException {
		Organization orgRemove = findOrg(id);
		organizationRepository.delete(orgRemove);
	}

	@Override
	public Organization findOrg(String id) throws OrganizationException {
		Organization org =  organizationRepository
				.findById(UUID.fromString(id))
				.orElseThrow(() -> new OrganizationException("Organization not found"));
		return org;
	}

}
