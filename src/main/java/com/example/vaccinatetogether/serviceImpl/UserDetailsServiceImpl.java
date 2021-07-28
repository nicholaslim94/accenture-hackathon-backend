package com.example.vaccinatetogether.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.vaccinatetogether.model.Account;
import com.example.vaccinatetogether.model.Operator;
import com.example.vaccinatetogether.repository.AccountRepository;
import com.example.vaccinatetogether.repository.OperatorRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private OperatorRepository operatorRepository;

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//			Account account = accountRepository
//					.findByUsername(username)
//					.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
//			return account;
//	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Account> account = accountRepository.findByUsername(username);
		if(!account.isEmpty()) {
			return account.get();
		} else {
			Operator operator = operatorRepository
					.findByUsername(username)
					.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
			return operator;
		}
	}
}
