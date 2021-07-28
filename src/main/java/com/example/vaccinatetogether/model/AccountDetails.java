package com.example.vaccinatetogether.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class AccountDetails {
	@Id
	@Column(columnDefinition = "BINARY(16)")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private UUID id;
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private Date firstJabDt;
	private Date secondJabDt;
	
	public AccountDetails() {}
	
	public AccountDetails(UUID id, String firstName, String lastName, String email, String address, Date firstJabDt,
			Date secondJabDt) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.firstJabDt = firstJabDt;
		this.secondJabDt = secondJabDt;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getFirstJabDt() {
		return firstJabDt;
	}
	public void setFirstJabDt(Date firstJabDt) {
		this.firstJabDt = firstJabDt;
	}
	public Date getSecondJabDt() {
		return secondJabDt;
	}
	public void setSecondJabDt(Date secondJabDt) {
		this.secondJabDt = secondJabDt;
	}
	@Override
	public String toString() {
		return "AccountDetails [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", address=" + address + ", firstJabDt=" + firstJabDt + ", secondJabDt=" + secondJabDt + "]";
	}
}
