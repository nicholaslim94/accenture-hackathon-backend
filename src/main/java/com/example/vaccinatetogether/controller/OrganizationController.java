package com.example.vaccinatetogether.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.vaccinatetogether.controller.dto.organization.AddModifyOrgDto;
import com.example.vaccinatetogether.exception.OrganizationException;
import com.example.vaccinatetogether.model.Organization;
import com.example.vaccinatetogether.service.OrganizationService;

@CrossOrigin
@RestController
public class OrganizationController {
	
	@Autowired
	private OrganizationService organizationService;
	
	@GetMapping("organization/get/{name}/{page}/{size}")
	public ResponseEntity<List<Organization>> getOrg(@PathVariable("name") String name, 
			@PathVariable("page") int page, @PathVariable("size") int size) {
		List<Organization> org = organizationService.getOrg(name, page, size);
		return ResponseEntity.status(HttpStatus.OK).body(org);
	}
	
	@GetMapping("organization/get/{page}/{size}")
	public ResponseEntity<?> getOrgs(@PathVariable("page") int page, @PathVariable("size") int size) {
		List<Organization> org = organizationService.getOrgs(page, size);
		return ResponseEntity.status(HttpStatus.OK).body(org);
	}
	
	@PostMapping("organization/add")
	public ResponseEntity<?> addOrg(@RequestBody AddModifyOrgDto addModifyOrgDto) throws OrganizationException {
		organizationService.saveOrg(addModifyOrgDto.toOrganizationModal());
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	@PutMapping("organization/modify/{id}")
	public ResponseEntity<?> modifyOrg(@RequestBody AddModifyOrgDto addModifyOrgDto, @PathVariable("id") String id) throws OrganizationException {
		organizationService.modifyOrg(id, addModifyOrgDto.toOrganizationModal());
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	@DeleteMapping("organization/delete/{id}")
	public ResponseEntity<?> deleteOrg(@PathVariable("id") String id) throws IllegalArgumentException, OrganizationException {
		organizationService.removeOrg(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

}
