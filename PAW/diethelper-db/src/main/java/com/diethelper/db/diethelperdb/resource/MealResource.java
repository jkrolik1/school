package com.diethelper.db.diethelperdb.resource;

import com.diethelper.db.diethelperdb.model.Meal;
import com.diethelper.db.diethelperdb.model.Product;
import com.diethelper.db.diethelperdb.repository.MealRepository;
import com.diethelper.db.diethelperdb.repository.PreparationRepository;
import com.diethelper.db.diethelperdb.repository.ProductRepository;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Files;
import java.util.*;

@RestController
@RequestMapping(value = "/meal")

public class MealResource {

    @Autowired
    MealRepository mealRepository;
    
    @Autowired
    ProductRepository productRepository;


    @GetMapping(value = "/all")
    private List<Meal> getAll() {
        return mealRepository.findAll();
    }

    @GetMapping(value = "/random")
    private Meal getRandom() {
        Random rand = new Random();
        List<Meal> newList = new ArrayList<>(mealRepository.findAll());
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
        if (opt.isPresent()) {
            return opt.get().getPreparation();
        } else {
            return "Nie ma id w bazie";
        }
    }

    @GetMapping(value = "/{mealId}/products")
    private List<Product> getMealProducts(@PathVariable("mealId") int id) {
        return productRepository.findByMeal(id);
    }

    @GetMapping(value = "/{mealId}/isHealthy")
    private String getMealHealthyProperty(@PathVariable("mealId") int id) {
        Optional<Meal> opt = mealRepository.findById(id);
        if (opt.isPresent()) {
            return mealRepository.getOne(id).getIsHealthy() == 1 ? "Zdrowe" : "Nie zdrowe";
        } else {
            return "Nie ma id w bazie";
        }
    }

    @GetMapping(value = "/proteinMeals")
    private List<Meal> getProteinMeals() {
        List<Meal> allMeals = new ArrayList<>(mealRepository.findAll());
        List<Meal> proteinMeals = new ArrayList<Meal>();
        Meal currentMeal;
        int proteins = 0, fats = 0, carbohydrates = 0;

        for (int i = 0; i < allMeals.size(); ++i) {
            currentMeal = allMeals.get(i);
            proteins = currentMeal.getProteins();
            fats = currentMeal.getFats();
            carbohydrates = currentMeal.getCarbohydrates();

            if ((proteins > fats) && (proteins > carbohydrates)) {
                proteinMeals.add(currentMeal);
            }
        }
        return proteinMeals;
    }

    @GetMapping(value = "/{mealId}")
    private ResponseEntity<Meal> getMealById(@PathVariable("mealId") int id) {
        Optional<Meal> opt = mealRepository.findById(id);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/{mealId}")
    private String deleteMealById(@PathVariable("mealId") List<Integer> id) {
        for (int i = 0; i < id.size(); ++i) {
            mealRepository.deleteById(id.get(i));
        }
        return "Usunięto";
    }

    @PutMapping(value = "/{mealId}")
    private Pair<String, Meal> editMealById(@RequestBody Map<String, Object> body, @PathVariable("mealId") int id) {
        Optional<Meal> mealToEdit = mealRepository.findById(id);
        if (mealToEdit.isPresent()) {
            mealToEdit.get().setName(body.get("name").toString());
            mealToEdit.get().setCategory(body.get("category").toString());
            mealToEdit.get().setFlavor(body.get("flavor").toString());
            mealToEdit.get().setDifficultyOfCooking(body.get("difficultyOfCooking").toString());
            mealToEdit.get().setCalories((Integer) body.get("calories"));
            mealToEdit.get().setCarbohydrates((Integer) body.get("carbohydrates"));
            mealToEdit.get().setProteins((Integer) body.get("proteins"));
            mealToEdit.get().setFats((Integer) body.get("fats"));
            mealToEdit.get().setIsHealthy((Integer) body.get("isHealthy"));
            mealToEdit.get().setPreparation(body.get("preparation").toString());
            mealRepository.save(mealToEdit.get());
            return new Pair<String, Meal>("Edycja pomyślna", mealToEdit.get());
        } else {
            return new Pair<String, Meal>("Nie ma id w bazie", null);
        }
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    Pair<String, Meal> addNewMeal(@RequestBody Map<String, Object> body) {
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

        return new Pair<String, Meal>("Dodano posiłek.", meal);
    }

    @DeleteMapping(value = "/nonHealthy")
    private String deleteNonHealthyMeals() {
        List<Meal> nonHealthyMeals = mealRepository.findAll();
        for (int i = 0; i < nonHealthyMeals.size(); ++i) {
            if (nonHealthyMeals.get(i).getIsHealthy() == 0) {
                mealRepository.deleteById(nonHealthyMeals.get(i).getMealId());
            }
        }
        return "Usunięto";
    }

    @PutMapping(value = "/{mealId}/nameAndPreparationUpdate")
    private Pair<String, Meal> editNameAndPreparationById(@RequestBody Map<String, Object> body, @PathVariable("mealId") int id) {
        Optional<Meal> mealToEdit = mealRepository.findById(id);
        if (mealToEdit.isPresent()) {
            mealToEdit.get().setName(body.get("name").toString());
            mealToEdit.get().setPreparation(body.get("preparation").toString());
            mealRepository.save(mealToEdit.get());
            return new Pair<String, Meal>("Edycja pomyślna", mealToEdit.get());
        } else {
            return new Pair<String, Meal>("Nie ma id w bazie", null);
        }
    }

    @GetMapping(value = "/{mealsNum}/menu")
    private List<Meal> getMenu(@PathVariable int mealsNum) {

        List<String> sniadanie = new ArrayList<String>();
        sniadanie.add("śniadanie");

        List<String> obiad = new ArrayList<String>();
        obiad.add("obiad");

        List<String> kolacja = new ArrayList<String>();
        kolacja.add("kolacja");

        List<String> allCategory = new ArrayList<String>();
        allCategory.add("śniadanie");
        allCategory.add("obiad");
        allCategory.add("kolacja");

        List<Meal> meals = new ArrayList<>();
        List<Meal> meals2;

        if (mealsNum == 0) {
            return null;
        } else if (mealsNum == 1) {
            meals2 = mealRepository.findByCategoryIn(obiad);
            Collections.shuffle(meals2);
            meals.add(meals2.get(0));
            return meals;
        } else if (mealsNum == 2) {
            meals2 = mealRepository.findByCategoryIn(sniadanie);
            Collections.shuffle(meals2);
            meals.add(meals2.get(0));

            meals2 = mealRepository.findByCategoryIn(obiad);
            Collections.shuffle(meals2);
            meals.add(meals2.get(0));

            return meals;
        } else if (mealsNum == 3) {
            meals2 = mealRepository.findByCategoryIn(sniadanie);
            Collections.shuffle(meals2);
            meals.add(meals2.get(0));

            meals2 = mealRepository.findByCategoryIn(obiad);
            Collections.shuffle(meals2);
            meals.add(meals2.get(0));

            meals2 = mealRepository.findByCategoryIn(kolacja);
            Collections.shuffle(meals2);
            meals.add(meals2.get(0));

            return meals;
        } else if (mealsNum == 4) {
            meals2 = mealRepository.findByCategoryIn(sniadanie);
            Collections.shuffle(meals2);
            meals.add(meals2.get(0));

            meals2 = mealRepository.findByCategoryIn(sniadanie);
            Collections.shuffle(meals2);
            meals.add(meals2.get(0));

            meals2 = mealRepository.findByCategoryIn(obiad);
            Collections.shuffle(meals2);
            meals.add(meals2.get(0));

            meals2 = mealRepository.findByCategoryIn(kolacja);
            Collections.shuffle(meals2);
            meals.add(meals2.get(0));

            return meals;
        } else if (mealsNum == 5) {
            meals2 = mealRepository.findByCategoryIn(sniadanie);
            Collections.shuffle(meals2);
            meals.add(meals2.get(0));

            meals2 = mealRepository.findByCategoryIn(sniadanie);
            Collections.shuffle(meals2);
            meals.add(meals2.get(0));

            meals2 = mealRepository.findByCategoryIn(obiad);
            Collections.shuffle(meals2);
            meals.add(meals2.get(0));

            meals2 = mealRepository.findByCategoryIn(kolacja);
            Collections.shuffle(meals2);
            meals.add(meals2.get(0));

            meals2 = mealRepository.findByCategoryIn(kolacja);
            Collections.shuffle(meals2);
            meals.add(meals2.get(0));

            return meals;
        } else {
            meals2 = mealRepository.findByCategoryIn(allCategory);

            Collections.shuffle(meals2);

            for (int i = 0; i < mealsNum; ++i) {
                meals.add(meals2.get(i));
            }

            return meals;
        }
    }

    /* ??? */ @PostMapping(path = "/createWithArray")
    public @ResponseBody Pair<String, Meal[]> addMealArray(@RequestBody Map<String, Object> body) {
        //Meal[] meal = new Meal[100];
        Object x = body.get("name");


       /* meal[0].setName(body.get("name"+1).toString());
        meal[0].setCategory(body.get("category"+1).toString());
        meal[0].setFlavor(body.get("flavor"+1).toString());
        meal[0].setDifficultyOfCooking(body.get("difficultyOfCooking"+1).toString());
        meal[0].setCalories(Integer.parseInt(body.get("calories"+1).toString()));
        meal[0].setCarbohydrates(Integer.parseInt(body.get("carbohydrates"+1).toString()));
        meal[0].setProteins(Integer.parseInt(body.get("proteins"+1).toString()));
        meal[0].setFats(Integer.parseInt(body.get("fats"+1).toString()));
        meal[0].setIsHealthy(Integer.parseInt(body.get("isHealthy"+1).toString()));
        meal[0].setPreparation(body.get("preparation"+1).toString());

        return new Pair<String, Meal[]>("Dodano posiłek.", meal);*/
        return null;
    }

}
