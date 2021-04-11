package com.diethelper.db.diethelperdb.repository;

import com.diethelper.db.diethelperdb.model.Preparation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasoningRepository extends JpaRepository<Preparation, Integer> {
}
