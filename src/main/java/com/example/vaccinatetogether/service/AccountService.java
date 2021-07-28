package com.example.vaccinatetogether.service;

import javax.security.auth.login.AccountException;

import com.example.vaccinatetogether.model.Account;
import com.example.vaccinatetogether.model.AccountDetails;

public interface AccountService {
	
	String login(String username, String password) throws AccountException;
	
	public void register(Account account) throws AccountException;

	Account findByUsername(String username) throws AccountException;

	void modifyAccountDetails(String username, AccountDetails accountDetails) throws AccountException;

}
