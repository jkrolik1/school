package com.diethelper.db.diethelperdb.repository;

import com.diethelper.db.diethelperdb.model.Nutrients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NutrientsRepository  extends JpaRepository<Nutrients, Integer> {
}
