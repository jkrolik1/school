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

    @GetMapping(value = "/categories/{categoryId}")
    private List<Meal> getMealByCategory(@PathVariable("categoryId") List<String> category) {
        return mealRepository.findByCategoryIn(category);
    }

    @GetMapping(value = "/flavor/{flavorId}")
    private List<Meal> getMealByFlavor(@PathVariable("flavorId") List<String> flavor) {
        return mealRepository.findByFlavorIn(flavor);
    }

    @GetMapping(value = "/difficultyOfCooking/{difficultyId}")
    private List<Meal> getMealByDifficultyOfCooking(@PathVariable("difficultyId") List<String> difficultyOfCooking) {
        return mealRepository.findByDifficultyOfCookingIn(difficultyOfCooking);
    }

    @GetMapping(value = "/{mealId}/preparation")
    private String getMealPreparation(@PathVariable("mealId") int id) {
        Optional<Meal> opt = mealRepository.findById(id);
        if (opt.isPresent())
            return opt.get().getPreparation();
        else
            return "Nie ma id w bazie";
    }

    @GetMapping(value = "/{mealId}/isHealthy")
    private String getMealHealthyProperty(@PathVariable("mealId") int id) {
        Optional<Meal> opt = mealRepository.findById(id);
        if (opt.isPresent())
            return mealRepository.getOne(id).getIsHealthy() == 1 ? "Zdrowe" : "Nie zdrowe";
        else
            return "Nie ma id w bazie";
    }

    @GetMapping(value = "/proteinMeals")
    private List<Meal> getProteinMeals() {
        List<Meal> allMeals = new ArrayList<>(mealRepository.findAll());
        List<Meal> proteinMeals = new ArrayList<Meal>();
        Meal currentMeal;
        int proteins = 0, fats = 0, carbohydrates = 0;

        for (int i=0; i<allMeals.size(); ++i){
            currentMeal = allMeals.get(i);
            proteins = currentMeal.getProteins();
            fats = currentMeal.getFats();
            carbohydrates = currentMeal.getCarbohydrates();

            if ((proteins > fats) && (proteins > carbohydrates))
                proteinMeals.add(currentMeal);
        }
        return proteinMeals;
    }

    @GetMapping(value = "/{mealId}")
    private ResponseEntity<Meal> getMealById(@PathVariable("mealId") int id) {
        Optional<Meal> opt = mealRepository.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/{mealId}")
    private String deleteMealById(@PathVariable("mealId") int id) {
        mealRepository.deleteById(id);
        return "Usunięto";
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addNewMeal(@RequestBody Map<String, Object> body) {
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

        List<String> names = new ArrayList<String>();
        names.add(meal.getName());

        List<Meal> mealIds = mealRepository.findByNameIn(names);

        String returnIds = "";

        for (int i=0; i<mealIds.size(); ++i){
            returnIds += mealIds.get(i).getMealId();
            returnIds += " ";
        }


        return "Dodano posiłek. Jego id to " + returnIds;
    }
    
}
