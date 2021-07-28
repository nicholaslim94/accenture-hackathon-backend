package com.example.vaccinatetogether.service;

import org.springframework.data.domain.Page;

import com.example.vaccinatetogether.exception.RewardException;
import com.example.vaccinatetogether.model.Organization;
import com.example.vaccinatetogether.model.Reward;

public interface RewardService {
	Page<Reward> getRewards(int page, int size);
	
	Page<Reward> getReward(String id, int page, int size);
	
	void saveReward(Organization org, Reward reward) throws RewardException;
	
	void modifyReward(String id, Reward reward) throws RewardException;
	
	void removeReward(String id) throws RewardException, IllegalArgumentException;

	Reward findById(String id) throws RewardException;
	
}
