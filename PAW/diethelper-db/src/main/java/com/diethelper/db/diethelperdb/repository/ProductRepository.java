package com.diethelper.db.diethelperdb.repository;

import com.diethelper.db.diethelperdb.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product, Integer> {
}
