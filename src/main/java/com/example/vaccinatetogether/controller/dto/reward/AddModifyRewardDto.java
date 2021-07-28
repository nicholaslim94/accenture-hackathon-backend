package com.example.vaccinatetogether.controller.dto.reward;

import java.util.Date;

import com.example.vaccinatetogether.model.Reward;

public class AddModifyRewardDto {
	private String name;
	private String description;
	
	public AddModifyRewardDto(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	public Reward toRewardModel() {
		return new Reward(null, name, description, new Date(), null, null);
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
	@Override
	public String toString() {
		return "AddModifyRewardDto [name=" + name + ", description=" + description + "]";
	}
	
}
