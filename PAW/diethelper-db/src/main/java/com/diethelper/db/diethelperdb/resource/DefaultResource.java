package com.diethelper.db.diethelperdb.resource;


import com.diethelper.db.diethelperdb.model.Meal;
import com.diethelper.db.diethelperdb.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class DefaultResource {
    @Autowired
    MealRepository mealRepository;

    @GetMapping(value = "/")
    private List<Meal> getAll() {
        return mealRepository.findAll();
    }

}
