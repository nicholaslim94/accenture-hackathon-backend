package com.example.vaccinatetogether.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vaccinatetogether.model.AccountReward;

public interface AccountRewardRepository extends JpaRepository<AccountReward, UUID> {

}
