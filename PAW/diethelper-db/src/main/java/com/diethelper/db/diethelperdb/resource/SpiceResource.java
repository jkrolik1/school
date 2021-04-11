package com.diethelper.db.diethelperdb.resource;

import com.diethelper.db.diethelperdb.model.Spice;
import com.diethelper.db.diethelperdb.repository.SpiceRepository;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/spice")

public class SpiceResource {
    @Autowired
    SpiceRepository spiceRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    Pair<String, Spice> addNewSpice(@RequestBody Map<String, Object> body) {
        Spice spice = new Spice();

        spice.setName(body.get("name").toString());

        return new Pair<String, Spice>("Dodano przyprawe.", spice);
    }

    @GetMapping(value = "/all")
    private List<Spice> getAll() {
        return spiceRepository.findAll();
    }

    @GetMapping(value = "/{spiceId}")
    private ResponseEntity<Spice> getSpiceById(@PathVariable("spiceId") int id) {
        Optional<Spice> opt = spiceRepository.findById(id);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{spiceId}")
    private Pair<String, Spice> editSpiceById(@RequestBody Map<String, Object> body, @PathVariable("spiceId") int id) {
        Optional<Spice> spiceToEdit = spiceRepository.findById(id);
        if (spiceToEdit.isPresent()) {
            spiceToEdit.get().setName(body.get("name").toString());
            spiceRepository.save(spiceToEdit.get());
            return new Pair<String, Spice>("Edycja pomyślna", spiceToEdit.get());
        } else {
            return new Pair<String, Spice>("Nie ma id w bazie", null);
        }
    }

    @DeleteMapping(value = "/{spiceId}")
    private String deleteSpiceById(@PathVariable("spiceId") List<Integer> id) {
        for (int i = 0; i < id.size(); ++i) {
            spiceRepository.deleteById(id.get(i));
        }
        return "Usunięto";
    }
}
