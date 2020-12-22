package com.bekerskyy.repository;

import com.bekerskyy.domain.BonusAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonusAccountRepository extends JpaRepository<BonusAccount, Integer> {
}