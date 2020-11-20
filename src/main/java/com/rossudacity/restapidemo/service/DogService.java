package com.rossudacity.restapidemo.service;

import com.rossudacity.restapidemo.entity.Dog;
import com.rossudacity.restapidemo.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface DogService {

    public List<Dog> getAllDogs();

    public List<String> retrieveDogBreeds();

//    public String retrieveDogById(Long id);

    public String retrieveDogBreedById(Long id);

    public List<String> retrieveDogNames();


}
