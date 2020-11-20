package com.rossudacity.restapidemo.web;

import com.rossudacity.restapidemo.entity.Dog;
import com.rossudacity.restapidemo.service.DogService;
import com.rossudacity.restapidemo.service.DogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {

    private DogService dogService;

    @Autowired
    public void getDogService(DogServiceImpl dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/allDogs")
    public ResponseEntity<List<Dog>> getAllDogs() {
        List<Dog> allDogs = dogService.getAllDogs();
        return new ResponseEntity<List<Dog>>(allDogs, HttpStatus.OK);
    }

    @GetMapping("/dogBreed")
    public ResponseEntity<String> getDogBreedsById(@RequestParam(name = "id") Long id) {
        String breed = dogService.retrieveDogBreedById(id);
//        if (breed == null) {
//            return ResponseEntity
//                    .status(HttpStatus.NOT_FOUND)
//                    .body("There is no dog with the id you provided");
//        }
        return new ResponseEntity<String>(breed, HttpStatus.OK);
    }


    @GetMapping("/dogBreeds")
    public ResponseEntity<List<String>> getDogBreeds() {
        List<String> dogBreeds = dogService.retrieveDogBreeds();
        return new ResponseEntity<List<String>>(dogBreeds, HttpStatus.OK);
    }

    @GetMapping("/dogNames")
    public ResponseEntity<List<String>> getDogNames() {
        List<String> dogNames = dogService.retrieveDogNames();
        return new ResponseEntity<List<String>>(dogNames, HttpStatus.OK);
    }

}
