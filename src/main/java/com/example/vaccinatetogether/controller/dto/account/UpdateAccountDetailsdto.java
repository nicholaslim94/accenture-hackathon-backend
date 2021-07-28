package com.example.vaccinatetogether.controller.dto.account;

import java.util.Date;

import com.example.vaccinatetogether.model.AccountDetails;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateAccountDetailsdto {
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private Date firstJab;
	private Date secondJab;
	public UpdateAccountDetailsdto(String firstName, String lastName, String email, String address,
			Date firstJab, Date secondJab) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.firstJab = firstJab;
		this.secondJab = secondJab;
	}
	public AccountDetails toAccountDetailsModel() {
		return new AccountDetails(null, firstName, lastName, email, address, firstJab, secondJab);
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
	public Date getFirstJab() {
		return firstJab;
	}
	public void setFirstJab(Date firstJab) {
		this.firstJab = firstJab;
	}
	public Date getSecondJab() {
		return secondJab;
	}
	public void setSecondJab(Date secondJab) {
		this.secondJab = secondJab;
	}
	@Override
	public String toString() {
		return "UpdateAccountDetailsdto [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", address=" + address + ", firstJab=" + firstJab + ", secondJab=" + secondJab + "]";
	}
}
