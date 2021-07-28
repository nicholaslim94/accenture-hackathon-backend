package com.example.vaccinatetogether.controller.dto.organization;

import java.util.List;

public class OrgDto {
	private int totalPageNo;
	private List<OrgObject> OrgObjects;
	
	public OrgDto(int totalPageNo, List<OrgObject> orgObjects) {
		super();
		this.totalPageNo = totalPageNo;
		OrgObjects = orgObjects;
	}
	public int getTotalPageNo() {
		return totalPageNo;
	}
	public void setTotalPageNo(int totalPageNo) {
		this.totalPageNo = totalPageNo;
	}
	public List<OrgObject> getOrgObjects() {
		return OrgObjects;
	}
	public void setOrgObjects(List<OrgObject> orgObjects) {
		OrgObjects = orgObjects;
	}
	@Override
	public String toString() {
		return "OrgDto [totalPageNo=" + totalPageNo + ", OrgObjects=" + OrgObjects + "]";
	}
		
}
