package com.diethelper.db.diethelperdb.repository;

import com.diethelper.db.diethelperdb.model.HealthConditions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthConditionsRepository extends JpaRepository<HealthConditions, Integer> {
}
