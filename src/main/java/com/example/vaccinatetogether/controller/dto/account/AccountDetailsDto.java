package com.example.vaccinatetogether.controller.dto.account;

import java.util.Date;

import com.example.vaccinatetogether.model.Account;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDetailsDto {
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private Date firstJab;
	private Date secondJab;
	public AccountDetailsDto(Account account) {
		this.username = account.getUsername();
		this.firstName = account.getAccountDetails().getFirstName();
		this.lastName = account.getAccountDetails().getLastName();
		this.email = account.getAccountDetails().getEmail();
		this.address = account.getAccountDetails().getAddress();
		this.firstJab = account.getAccountDetails().getFirstJabDt();
		this.secondJab = account.getAccountDetails().getSecondJabDt();
	}
	public AccountDetailsDto(String username, String firstName, String lastName, String email, String address,
			Date firstJab, Date secondJab) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.firstJab = firstJab;
		this.secondJab = secondJab;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
		return "AccountDetailsDto [username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", address=" + address + ", firstJab=" + firstJab + ", secondJab=" + secondJab
				+ "]";
	}	
}
