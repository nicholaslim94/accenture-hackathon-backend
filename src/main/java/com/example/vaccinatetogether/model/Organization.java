package com.example.vaccinatetogether.model;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Organization {
    @Id
    @GeneratedValue()
    @Column(columnDefinition = "BINARY(16)")
	private UUID id;
	private String name;
	private String description;
	private String address;
	private String website;
	private String no;
	private Date created_dt;
	@OneToMany(mappedBy="organization", cascade = CascadeType.REMOVE)
	@JsonManagedReference
	@OrderColumn
	private Set<Reward> reward;
	
	public Organization() {}
	
	public Organization(UUID id, String name, String description, String address, String website, String no,
			Date created_dt) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.address = address;
		this.website = website;
		this.no = no;
		this.created_dt = created_dt;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
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
	public Date getCreated_dt() {
		return created_dt;
	}
	public void setCreated_dt(Date created_dt) {
		this.created_dt = created_dt;
	}
	public Set<Reward> getReward() {
		return reward;
	}
	public void setReward(Set<Reward> reward) {
		this.reward = reward;
	}

	@Override
	public String toString() {
		return "Organization [id=" + id + ", name=" + name + ", description=" + description + ", address=" + address
				+ ", website=" + website + ", no=" + no + ", created_dt=" + created_dt + ", reward=" + reward + "]";
	}	
}
