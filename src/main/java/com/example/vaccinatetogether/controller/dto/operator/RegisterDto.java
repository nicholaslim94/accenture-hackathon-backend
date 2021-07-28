package com.example.vaccinatetogether.controller.dto.operator;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.vaccinatetogether.model.Operator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterDto {
	@NotNull
	@NotBlank
	private String username;
	@NotNull
	@NotBlank
	private String password;

	public RegisterDto(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public Operator toOperatorModel() {
		return new Operator(null, username, password, true, new Date());
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
	@Override
	public String toString() {
		return "RegisterDto [username=" + username + ", password=" + password + "]";
	}
}

