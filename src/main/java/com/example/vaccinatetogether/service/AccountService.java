package com.example.vaccinatetogether.service;

import java.util.Set;

import javax.security.auth.login.AccountException;

import com.example.vaccinatetogether.model.Account;
import com.example.vaccinatetogether.model.AccountDetails;
import com.example.vaccinatetogether.model.AccountReward;
import com.example.vaccinatetogether.model.Reward;

public interface AccountService {
	
	String login(String username, String password) throws AccountException;
	
	public void register(Account account) throws AccountException;

	Account findByUsername(String username) throws AccountException;

	void modifyAccountDetails(String username, AccountDetails accountDetails) throws AccountException;

	void addRewardToAccount(String username, Reward reward) throws AccountException;

	Set<AccountReward> getAccountRewards(String usernmae) throws AccountException;

}
