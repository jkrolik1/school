package com.diethelper.db.diethelperdb.resource;

import com.diethelper.db.diethelperdb.model.Nutrients;
import com.diethelper.db.diethelperdb.repository.NutrientsRepository;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/nutrients")

public class NutrientsResource {
    @Autowired
    NutrientsRepository nutrientsRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    Pair<String, Nutrients> addNewNutrients(@RequestBody Map<String, Object> body) {
        Nutrients nutrients = new Nutrients();

        nutrients.setName(body.get("name").toString());

        return new Pair<String, Nutrients>("Dodano składnik odżywczy.", nutrients);
    }

    @GetMapping(value = "/all")
    private List<Nutrients> getAll() {
        return nutrientsRepository.findAll();
    }

    @GetMapping(value = "/{nutrientsId}")
    private ResponseEntity<Nutrients> getNutrientsById(@PathVariable("nutrientsId") int id) {
        Optional<Nutrients> opt = nutrientsRepository.findById(id);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{nutrientsId}")
    private Pair<String, Nutrients> editNutrientsById(@RequestBody Map<String, Object> body, @PathVariable("nutrientsId") int id) {
        Optional<Nutrients> nutrientsToEdit = nutrientsRepository.findById(id);
        if (nutrientsToEdit.isPresent()) {
            nutrientsToEdit.get().setName(body.get("name").toString());
            nutrientsRepository.save(nutrientsToEdit.get());
            return new Pair<String, Nutrients>("Edycja pomyślna", nutrientsToEdit.get());
        } else {
            return new Pair<String, Nutrients>("Nie ma id w bazie", null);
        }
    }

    @DeleteMapping(value = "/{nutrientsId}")
    private String deleteNutrientsById(@PathVariable("nutrientsId") List<Integer> id) {
            for (int i = 0; i < id.size(); ++i) {
            nutrientsRepository.deleteById(id.get(i));
        }
        return "Usunięto";
    }

}
