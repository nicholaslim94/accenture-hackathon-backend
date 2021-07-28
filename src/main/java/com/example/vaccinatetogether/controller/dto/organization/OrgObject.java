package com.example.vaccinatetogether.controller.dto.organization;

import java.util.ArrayList;
import java.util.List;

import com.example.vaccinatetogether.model.Organization;

public class OrgObject {
	private String id;
	private String name;
	private String description;
	private String address;
	private String website;
	private String no;
	
	public OrgObject(String id, String name, String description, String address, String website, String no) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.address = address;
		this.website = website;
		this.no = no;
	}
	public static List<OrgObject> fromOrgModel(List<Organization> organizations) {
		List<OrgObject> orgObjects= new ArrayList<OrgObject>();
		for(Organization org : organizations) {
			OrgObject orgObject = new OrgObject(org.getId().toString(), 
					org.getName(), org.getDescription(), org.getAddress(), 
					org.getWebsite(), org.getNo());
			orgObjects.add(orgObject);
		}
		return orgObjects;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
		return "GetOrgDto [id=" + id + ", name=" + name + ", description=" + description + ", address=" + address
				+ ", website=" + website + ", no=" + no + "]";
	}
}
