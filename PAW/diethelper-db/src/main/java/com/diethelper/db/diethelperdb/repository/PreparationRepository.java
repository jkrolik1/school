package com.diethelper.db.diethelperdb.repository;

import com.diethelper.db.diethelperdb.model.Meal;
import com.diethelper.db.diethelperdb.model.Preparation;
import com.diethelper.db.diethelperdb.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface PreparationRepository extends JpaRepository<Preparation, Integer> {
}
