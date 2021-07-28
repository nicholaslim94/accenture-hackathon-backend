package com.example.vaccinatetogether.controller.dto.reward;

import java.util.List;

public class RewardDto {
	private int totalPageNo;
	private List<RewardObject> rewardObject;
	
	public RewardDto(int totalPageNo, List<RewardObject> rewardObject) {
		super();
		this.totalPageNo = totalPageNo;
		this.rewardObject = rewardObject;
	}
	public int getTotalPageNo() {
		return totalPageNo;
	}
	public void setTotalPageNo(int totalPageNo) {
		this.totalPageNo = totalPageNo;
	}
	public List<RewardObject> getRewardObject() {
		return rewardObject;
	}
	public void setRewardObject(List<RewardObject> rewardObject) {
		this.rewardObject = rewardObject;
	}
	@Override
	public String toString() {
		return "RewardDto [totalPageNo=" + totalPageNo + ", rewardObject=" + rewardObject + "]";
	}
	
}
