package com.example.vaccinatetogether.serviceImpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.vaccinatetogether.exception.RewardException;
import com.example.vaccinatetogether.model.Organization;
import com.example.vaccinatetogether.model.Reward;
import com.example.vaccinatetogether.repository.RewardRepository;
import com.example.vaccinatetogether.service.RewardService;

@Service
public class RewardServiceImpl implements RewardService {
	
	@Autowired
	private RewardRepository rewardRepository;
	
	@Override
	public Page<Reward> getRewards(int page, int size) {
		Pageable pagable = PageRequest.of(page, size);
		Page<Reward> rewardPage = rewardRepository.findAll(pagable);
		return rewardPage;
	}
	
	@Override
	public Page<Reward> getReward(String id, int page, int size) {
		Pageable pagable = PageRequest.of(page, size);
		Page<Reward> rewardPage = rewardRepository.findAllByOrganizationId(UUID.fromString(id), pagable);
		return rewardPage;
	}
	
	@Override
	public void saveReward(Organization org, Reward reward) throws RewardException {
		reward.setOrganization(org);
		Reward savedReward = rewardRepository.save(reward);
		if(savedReward == null) {
			throw new RewardException("Failed to save reward: "+ reward.getName() + " to Organiszation: " + org.getName());
		}
	}
	
	@Override
	public void modifyReward(String id, Reward reward) throws RewardException {
		Reward rewardUpdate = rewardRepository
		.findById(UUID.fromString(id))
		.orElseThrow(() -> new RewardException("Reward not found"));
		rewardUpdate.setName(reward.getName());
		rewardUpdate.setDescription(id);
		Reward savedReward = rewardRepository.save(rewardUpdate);
		if(savedReward == null) {
			throw new RewardException("Failed to save reward: "+ reward.getName());
		}
	}
	
	@Override
	public void removeReward(String id) throws RewardException, IllegalArgumentException {
		Reward rewardDelete = findById(id);
		rewardRepository.delete(rewardDelete);
	}
	
	@Override
	public Reward findById(String id) throws RewardException {
		Reward reward =  rewardRepository
				.findById(UUID.fromString(id))
				.orElseThrow(() -> new RewardException("Reward not found"));
		return reward;
	}

}
