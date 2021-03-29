package com.diethelper.db.diethelperdb.resource;

import com.diethelper.db.diethelperdb.model.Meal;
import com.diethelper.db.diethelperdb.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/meal")

public class MealResource {

    @Autowired
    MealRepository mealRepository;

    @PostMapping(path = "/add")
    public String addNewMeal(@RequestBody Map<String, Object> body) {
        Meal meal = new Meal();
        meal.setName(body.get("name").toString());
        meal.setCategory(body.get("category").toString());
        meal.setFlavor(body.get("flavor").toString());
        meal.setDifficultyOfCooking(body.get("difficultyOfCooking").toString());
        meal.setCalories(Integer.parseInt(body.get("calories").toString()));
        meal.setCarbohydrates(Integer.parseInt(body.get("carbohydrates").toString()));
        meal.setProteins(Integer.parseInt(body.get("proteins").toString()));
        meal.setFats(Integer.parseInt(body.get("fats").toString()));
        meal.setIsHealthy(Integer.parseInt(body.get("isHealthy").toString()));
        meal.setPreparation(body.get("preparation").toString());
        mealRepository.save(meal);
        return "Success";
    }

    @GetMapping(value = "/all")
    private List<Meal> getAll() {
        return mealRepository.findAll();
    }

    @GetMapping(value = "/random")
    private Meal getRandom() {
        Random rand = new Random();
        List<Meal> newList = new ArrayList<>(mealRepository.findAll()) ;
        //Collections.shuffle(newList);
        int randomElement = rand.nextInt(newList.size());
        return newList.get(randomElement);
    }

    @GetMapping(value = "/{mealId}")
    private ResponseEntity<Meal> getMealById(@PathVariable("mealId") int id) {
        Optional<Meal> opt = mealRepository.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/categories/{categoryId}")
    private List<Meal> getMealByCategory(@PathVariable("categoryId") List<String> category) {
        return mealRepository.findByCategoryIn(category);
    }

    @GetMapping(value = "/flavor/{flavorId}")
    private List<Meal> getMealByFlavor(@PathVariable("flavorId") List<String> flavor) {
        return mealRepository.findByFlavorIn(flavor);
    }

    @GetMapping(value = "/proteinMeals")
    private List<Meal> getProteinMeals(){
        List<Meal> oldList = new ArrayList<>(mealRepository.findAll());
        List<Meal> newList = new ArrayList<>();

        Meal element = null;
        int proteins = 0;
        int carbohydrates = 0;
        int fats = 0;

        for (Iterator<Meal> iter = oldList.iterator(); iter.hasNext(); ) {
            element = iter.next();

            proteins = mealRepository.findByProteins(element);
            carbohydrates = mealRepository.findByCarbohydrates(element);
            fats = mealRepository.findByFats(element);

            //if ((proteins > carbohydrates) && (proteins > fats))
                newList.add(element);
        }

        return newList;
    }



    //@PostMapping(value = "/load")
    //public List<Meal> persist(@RequestBody final Meal meals) {
    //    mealRepository.save(meals);
    //    return mealRepository.findAll();
    //}
}
