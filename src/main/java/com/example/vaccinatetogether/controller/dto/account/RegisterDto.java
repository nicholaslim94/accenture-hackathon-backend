package com.example.vaccinatetogether.controller.dto.account;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.vaccinatetogether.model.Account;
import com.example.vaccinatetogether.model.AccountDetails;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterDto {
	@NotNull
	@NotBlank
	private String username;
	@NotNull
	@NotBlank
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private Date firstJab;
	private Date secondJab;

	public RegisterDto(String username, String password, String firstName, String lastName, String email,
			String address, Date firstJab, Date secondJab) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.firstJab = firstJab;
		this.secondJab = secondJab;
	}
	public Account toAccountModel() {
		AccountDetails accountDetails = new AccountDetails(null, firstName, lastName, email, address, firstJab, secondJab);
		return new Account(null, username, password, null, true, new Date(), accountDetails);
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
		return "RegisterDto [username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", address=" + address + ", firstJab=" + firstJab
				+ ", secondJab=" + secondJab + "]";
	}
}
