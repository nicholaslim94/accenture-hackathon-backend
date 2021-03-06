package com.example.vaccinatetogether.controller.dto.reward;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.vaccinatetogether.model.Reward;

public class RewardObject {
	private String id;
	private String name;
	private String description;
	private Date created_dt;
	
	public RewardObject(String id, String name, String description, Date created_dt) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.created_dt = created_dt;
	}
	
	public static List<RewardObject> fromRewardModel(List<Reward> rewards) {
		List<RewardObject> rewardObjects= new ArrayList<RewardObject>();
		for(Reward reward : rewards) {
			RewardObject rewardObject = new RewardObject(reward.getId().toString(),
					reward.getName(), reward.getDescription(), reward.getCreated_dt());
			rewardObjects.add(rewardObject);
		}
		return rewardObjects;
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
