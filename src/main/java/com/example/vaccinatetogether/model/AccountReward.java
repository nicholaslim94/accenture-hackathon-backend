package com.example.vaccinatetogether.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class AccountReward {
	@Id
	@Column(columnDefinition = "BINARY(16)")
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private UUID id;
	private Date consumed_dt;
	@ManyToOne
	@JoinColumn(name="account_id", nullable=true)
	@JsonBackReference
	private Account account;
	@ManyToOne
	@JoinColumn(name="reward_id", nullable=true)
	@JsonBackReference
	private Reward reward;
	
	public AccountReward() {}
	
	public AccountReward(UUID id , Date consumed_dt , Account account, Reward reward) {
		super();
		this.id = id;
		this.setConsumed_dt(consumed_dt);
		this.account = account;
		this.reward = reward;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public Date getConsumed_dt() {
		return consumed_dt;
	}
	public void setConsumed_dt(Date consumed_dt) {
		this.consumed_dt = consumed_dt;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Reward getReward() {
		return reward;
	}
	public void setReward(Reward reward) {
		this.reward = reward;
	}
	@Override
	public String toString() {
		return "AccountReward [id=" + id + ", consumed_dt=" + consumed_dt + ", account=" + account + ", reward="
				+ reward + "]";
	}
}
