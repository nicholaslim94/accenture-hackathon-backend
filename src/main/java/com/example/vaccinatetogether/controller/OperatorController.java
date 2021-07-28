package com.example.vaccinatetogether.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.vaccinatetogether.controller.dto.operator.RegisterDto;
import com.example.vaccinatetogether.controller.dto.operator.JwtDto;
import com.example.vaccinatetogether.controller.dto.operator.LoginDto;
import com.example.vaccinatetogether.exception.OperatorException;
import com.example.vaccinatetogether.service.OperatorService;

@CrossOrigin
@RestController
public class OperatorController {
	
	@Autowired
	private OperatorService operatorService;
	
	@PostMapping("/operator/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginDto loginDto) throws OperatorException {
		String token = operatorService.login(loginDto.getUsername(), loginDto.getPassword());
		return ResponseEntity.status(HttpStatus.OK).body(new JwtDto(token));
	}
	
	@PostMapping("/operator/register")
	public ResponseEntity<?> register(@Valid @RequestBody RegisterDto registerDto) throws OperatorException {
		operatorService.register(registerDto.toOperatorModel());
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
}
