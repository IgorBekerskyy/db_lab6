package com.bekerskyy.repository;

import com.bekerskyy.domain.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalonRepository extends JpaRepository<Salon, Integer> {
}
