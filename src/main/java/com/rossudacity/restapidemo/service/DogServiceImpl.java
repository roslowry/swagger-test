package com.rossudacity.restapidemo.service;

import com.rossudacity.restapidemo.entity.Dog;
import com.rossudacity.restapidemo.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService {

    private DogRepository dogRepository;

    @Autowired
    public void setDogRepository(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public List<Dog> getAllDogs() {
        List<Dog> listOfDogs = (List<Dog>) dogRepository.findAll();
        return listOfDogs;
    }

    public List<String> retrieveDogBreeds() {
        return (List<String>) dogRepository.findAllBreed();
    }

//    @Override
//    public String retrieveDogById(Long id) {
//        return dogRepository.findById(id);
//    }

    public String retrieveDogBreedById(Long id) {
        Optional<String> optionalBreed = Optional.ofNullable(dogRepository.findBreedById(id));
        String breed = optionalBreed.orElseThrow(DogNotFoundException::new);

        return breed;
    }

    public List<String> retrieveDogNames() {
        return (List<String>) dogRepository.findAllName();
    }

//    public Dog findDog(Long id) {
//        return dogRepository.findById(id);
//    }

//
//    @Query("SELECT * FROM Dogs")
//    public List<String> retrieveDogBreeds () {};
//
//    @Query("SELECT breed from Dogs where id = ?id ")
//    public Dog retrieveDogById (Long id) {};
//
//    @Query("SELECT name FROM Dogs")
//    public List<Dog> retrieveDogNames () {};


//    public List

}
