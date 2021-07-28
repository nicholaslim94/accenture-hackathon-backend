package com.example.vaccinatetogether.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.vaccinatetogether.controller.dto.reward.AddModifyRewardDto;
import com.example.vaccinatetogether.controller.dto.reward.RewardDto;
import com.example.vaccinatetogether.controller.dto.reward.RewardObject;
import com.example.vaccinatetogether.exception.OrganizationException;
import com.example.vaccinatetogether.exception.RewardException;
import com.example.vaccinatetogether.model.Organization;
import com.example.vaccinatetogether.model.Reward;
import com.example.vaccinatetogether.service.OrganizationService;
import com.example.vaccinatetogether.service.RewardService;

@CrossOrigin
@RestController
public class RewardController {
	
	@Autowired
	private RewardService rewardService;
	
	@Autowired
	private OrganizationService organizationService;
	
	@GetMapping("reward/get/{id}/{page}/{size}")
	public ResponseEntity<RewardDto> getReward(@PathVariable("id") String id, 
			@PathVariable("page") int page, @PathVariable("size") int size) {
		Page<Reward> rewards = rewardService.getReward(id, page, size);
		List<RewardObject> rewardObjects = RewardObject.fromRewardModel(rewards.toList());
		return ResponseEntity.status(HttpStatus.OK)
				.body(new RewardDto(rewards.getTotalPages(), rewardObjects));
	}
	
	@GetMapping("reward/get/{page}/{size}")
	public ResponseEntity<RewardDto> getRewards(@PathVariable("page") int page,
			@PathVariable("size") int size) {
		Page<Reward> rewards = rewardService.getRewards(page, size);
		List<RewardObject> rewardObjects = RewardObject.fromRewardModel(rewards.toList());
		return ResponseEntity.status(HttpStatus.OK)
				.body(new RewardDto(rewards.getTotalPages(), rewardObjects));
	}
	
	@PostMapping("reward/add/{id}")
	public ResponseEntity<?> addReward(@RequestBody AddModifyRewardDto addModifyRewardDto, 
			@PathVariable("id") String id) 
			throws RewardException, OrganizationException {
		Organization org = organizationService.findOrg(id);
		rewardService.saveReward(org, addModifyRewardDto.toRewardModel());
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	@PutMapping("reward/modify/{id}")
	public ResponseEntity<?> modifyReward(@RequestBody AddModifyRewardDto addModifyRewardDto,
			@PathVariable("id") String id) 
			throws RewardException {
		rewardService.modifyReward(id, addModifyRewardDto.toRewardModel());
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	@DeleteMapping("reward/delete/{id}")
	public ResponseEntity<?> deleteReward(@PathVariable("id") String id) 
			throws IllegalArgumentException, RewardException {
		rewardService.removeReward(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
}
