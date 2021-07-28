package com.example.vaccinatetogether.controller.dto.reward;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.vaccinatetogether.model.Reward;

public class RewardDto {
	private String id;
	private String name;
	private String description;
	private Date created_dt;
	
	public RewardDto(String id, String name, String description, Date created_dt) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.created_dt = created_dt;
	}
	
	public static List<RewardDto> fromRewardModel(List<Reward> rewards) {
		List<RewardDto> rewardDtos= new ArrayList<RewardDto>();
		for(Reward reward : rewards) {
			RewardDto rewardDto = new RewardDto(reward.getId().toString(),
					reward.getName(), reward.getDescription(), reward.getCreated_dt());
			rewardDtos.add(rewardDto);
		}
		return rewardDtos;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreated_dt() {
		return created_dt;
	}
	public void setCreated_dt(Date created_dt) {
		this.created_dt = created_dt;
	}
	@Override
	public String toString() {
		return "GetRewardDto [id=" + id + ", name=" + name + ", description=" + description + ", created_dt="
				+ created_dt + "]";
	}

}
