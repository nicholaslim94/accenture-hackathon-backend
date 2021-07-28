package com.example.vaccinatetogether.service;

import com.example.vaccinatetogether.exception.OperatorException;
import com.example.vaccinatetogether.model.Operator;

public interface OperatorService {
	String login(String username, String password) throws OperatorException;
	
	Operator findByUsername(String username) throws OperatorException;

	void register(Operator operator) throws OperatorException;

}
