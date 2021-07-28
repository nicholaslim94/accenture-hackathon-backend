package com.example.vaccinatetogether.service;

import java.util.List;

import com.example.vaccinatetogether.exception.RewardException;
import com.example.vaccinatetogether.model.Organization;
import com.example.vaccinatetogether.model.Reward;

public interface RewardService {
	List<Reward> getRewards(int page, int size);
	
	List<Reward> getReward(String id, int page, int size);
	
	void saveReward(Organization org, Reward reward) throws RewardException;
	
	void modifyReward(String id, Reward reward) throws RewardException;
	
	void removeReward(String id) throws RewardException, IllegalArgumentException;

	Reward findById(String id) throws RewardException;
	
}
