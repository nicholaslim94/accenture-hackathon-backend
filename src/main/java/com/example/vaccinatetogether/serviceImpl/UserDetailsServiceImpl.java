package com.example.vaccinatetogether.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.vaccinatetogether.model.Account;
import com.example.vaccinatetogether.repository.AccountRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			Account account = accountRepository
					.findByUsername(username)
					.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
			return account;
	}
}
