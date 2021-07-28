package com.example.vaccinatetogether.controller.dto.organization;

import java.util.Date;

import com.example.vaccinatetogether.model.Organization;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddModifyOrgDto {
	private String name;
	private String description;
	private String address;
	private String website;
	private String no;
	
	public AddModifyOrgDto(String name, String description, String address, String website, String no) {
		super();
		this.name = name;
		this.description = description;
		this.address = address;
		this.website = website;
		this.no = no;
	}
	public Organization toOrganizationModal() {
		return new Organization(null, name, description, address, website, no, new Date());
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	@Override
	public String toString() {
		return "AddOrgDto [name=" + name + ", description=" + description + ", address=" + address + ", website="
				+ website + ", no=" + no + "]";
	}
}
