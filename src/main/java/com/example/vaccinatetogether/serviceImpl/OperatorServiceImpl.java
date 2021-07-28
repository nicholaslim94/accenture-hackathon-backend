package com.example.vaccinatetogether.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vaccinatetogether.exception.OperatorException;
import com.example.vaccinatetogether.model.Operator;
import com.example.vaccinatetogether.repository.OperatorRepository;
import com.example.vaccinatetogether.security.JwtUtil;
import com.example.vaccinatetogether.service.OperatorService;

@Service
public class OperatorServiceImpl implements OperatorService {
	
	@Autowired
	private OperatorRepository operatorRepository;
	
	@Autowired
	private JwtUtil jwtUtil;

	@Override
	public String login(String username, String password) throws OperatorException {
		Operator operator = findByUsername(username);
		if(!Operator.getPasswordEncoder().matches(password, operator.getPassword())) {
			throw new OperatorException("Invalid password");
		}
		return jwtUtil.generateToken(operator.getUsername(), null);
	}

	@Override
	public void register(Operator operator) throws OperatorException {
		Operator savedOperator = operatorRepository.save(operator);
		if(savedOperator == null) {
			throw new OperatorException("Failed to save operator account: " + operator.getUsername());
		}
	}
	
	@Override
	public Operator findByUsername(String username) throws OperatorException {
		Operator operator = operatorRepository
				.findByUsername(username)
				.orElseThrow(() -> new OperatorException("Username not found"));
		return operator;
	}
	
	
}
