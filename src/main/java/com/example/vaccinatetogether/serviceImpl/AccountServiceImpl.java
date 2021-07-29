package com.example.vaccinatetogether.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.security.auth.login.AccountException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vaccinatetogether.model.Account;
import com.example.vaccinatetogether.model.AccountDetails;
import com.example.vaccinatetogether.model.AccountReward;
import com.example.vaccinatetogether.model.Reward;
import com.example.vaccinatetogether.repository.AccountRepository;
import com.example.vaccinatetogether.repository.AccountRewardRepository;
import com.example.vaccinatetogether.security.JwtUtil;
import com.example.vaccinatetogether.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private AccountRewardRepository accountRewardRepository;
	
	@Autowired
	private JwtUtil jwtUtil;

	@Override
	public String login(String username, String password) throws AccountException {
		Account account = findByUsername(username);
		if(!Account.getPasswordEncoder().matches(password, account.getPassword())) {
			throw new AccountException("Invalid password");
		}
		return jwtUtil.generateToken(account.getUsername(), null);
	}

	@Override
	public void register(Account account) throws AccountException {
		Account savedAccount = accountRepository.save(account);
		if(savedAccount == null) {
			throw new AccountException("Failed to save registered account: " + account.getUsername());
		}
	}
	
	@Override
	public List<Reward> getAccountRewards(String usernmae) throws AccountException {
		Account account = findByUsername(usernmae);
		Set<AccountReward> accountRewards = account.getAccountRewards();
		List<Reward> rewards = new ArrayList<>();
		for(AccountReward accountReward: accountRewards) {
			rewards.add(accountReward.getReward());
		}
		return rewards;
	}
	
	@Override
	public void modifyAccountDetails(String username, AccountDetails accountDetails) throws AccountException {
		Account accountModify = findByUsername(username);
		AccountDetails accountDetailsModify = accountModify.getAccountDetails();
		
		accountDetailsModify.setFirstName(accountDetails.getFirstName());
		accountDetailsModify.setLastName(accountDetails.getLastName());
		accountDetailsModify.setEmail(accountDetails.getEmail());
		accountDetailsModify.setAddress(accountDetails.getAddress());
		accountDetailsModify.setFirstJabDt(accountDetails.getFirstJabDt());
		accountDetailsModify.setSecondJabDt(accountDetails.getSecondJabDt());
		accountModify.setAccountDetails(accountDetailsModify);
		Account savedAccount = accountRepository.save(accountModify);
		
		if(savedAccount == null) {
			throw new AccountException("Failed to update account details: " + accountDetails.getFirstName());
		}
	}
	
	@Override
	public Account findByUsername(String username) throws AccountException {
		Account account = accountRepository
		.findByUsername(username)
		.orElseThrow(() -> new AccountException("Username not found"));
		return account;
	}
	
	@Override
	public void addRewardToAccount(String username, Reward reward) throws AccountException {
		Account account = findByUsername(username);
		AccountReward accountReward = new AccountReward(null, new Date(), account, reward);
		AccountReward accountRewardSaved =  accountRewardRepository.save(accountReward);
		if(accountRewardSaved == null) {
			throw new AccountException("Failed to save registered account: " + account.getUsername());
		}
	}
}
