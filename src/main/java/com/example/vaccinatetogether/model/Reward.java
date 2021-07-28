package com.example.vaccinatetogether.model;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Reward {
    @Id
    @GeneratedValue()
    @Column(columnDefinition = "BINARY(16)")
	private UUID id;
    
	private String name;
	
	private String description;
	
	private Date created_dt;
	
	@ManyToOne
	@JoinColumn(name="organization_id", nullable=true)
	@JsonBackReference
	private Organization organization;
	
	@OneToMany(mappedBy="reward", cascade = CascadeType.REMOVE)
	@JsonManagedReference
	@OrderColumn
	private Set<AccountReward> accountReward;
	
	public Reward() {}

	public Reward(UUID id, String name, String description, Date created_dt, Organization organization,
			Set<AccountReward> accountReward) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.created_dt = created_dt;
		this.organization = organization;
		this.accountReward = accountReward;
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

	public Date getCreated_dt() {
		return created_dt;
	}

	public void setCreated_dt(Date created_dt) {
		this.created_dt = created_dt;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Set<AccountReward> getAccountReward() {
		return accountReward;
	}

	public void setAccountReward(Set<AccountReward> accountReward) {
		this.accountReward = accountReward;
	}

	@Override
	public String toString() {
		return "Reward [id=" + id + ", name=" + name + ", description=" + description + ", created_dt=" + created_dt
				+ ", organization=" + organization + ", accountReward=" + accountReward + "]";
	}	
}
