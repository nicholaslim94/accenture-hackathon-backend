package com.example.vaccinatetogether.controller;

import javax.security.auth.login.AccountException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.vaccinatetogether.controller.dto.account.AccountDetailsDto;
import com.example.vaccinatetogether.controller.dto.account.JwtDto;
import com.example.vaccinatetogether.controller.dto.account.LoginDto;
import com.example.vaccinatetogether.controller.dto.account.RegisterDto;
import com.example.vaccinatetogether.controller.dto.account.UpdateAccountDetailsdto;
import com.example.vaccinatetogether.exception.RewardException;
import com.example.vaccinatetogether.model.Account;
import com.example.vaccinatetogether.model.Reward;
import com.example.vaccinatetogether.security.JwtUtil;
import com.example.vaccinatetogether.service.AccountService;
import com.example.vaccinatetogether.service.RewardService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private RewardService rewardService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginDto loginDto) throws AccountException {
		String token = accountService.login(loginDto.getUsername(), loginDto.getPassword());
		return ResponseEntity.status(HttpStatus.OK).body(new JwtDto(token));
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody RegisterDto registerDto) throws AccountException {
		accountService.register(registerDto.toAccountModel());
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	@GetMapping("/account/get/details")
	public ResponseEntity<AccountDetailsDto> getAccountDetails(@RequestHeader("Authorization") String auth) throws AccountException {
		String token = auth.substring(7);
		String userId = jwtUtil.parseToken(token);
		Account account = accountService.findByUsername(userId);
		return ResponseEntity.status(HttpStatus.OK).body(new AccountDetailsDto(account));
	}
	
	@PostMapping("/account/update/details")
	public ResponseEntity<?> modifyAccountDetails(@RequestHeader("Authorization") String auth,
			@RequestBody UpdateAccountDetailsdto updateAccountDetailsdto) throws AccountException {
		String token = auth.substring(7);
		String username = jwtUtil.parseTokenUsername(token);
		accountService.modifyAccountDetails(username, updateAccountDetailsdto.toAccountDetailsModel());
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	@PostMapping("/account/add/rewards/{id}")
	public ResponseEntity<?> addRewardsToAccount(@RequestHeader("Authorization") String auth,
			@PathVariable("id") String id ) throws RewardException, AccountException {
		String token = auth.substring(7);
		String username = jwtUtil.parseTokenUsername(token);
		Reward reward = rewardService.findById(id);
		accountService.addRewardToAccount(username, reward);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

}
