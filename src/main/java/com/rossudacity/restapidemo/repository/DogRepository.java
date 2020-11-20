package com.rossudacity.restapidemo.repository;

import com.rossudacity.restapidemo.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog, Long> {

    @Query("SELECT d.breed from Dog d where d.id=:id")
    public String findBreedById(Long id);

    @Query("SELECT d.id, d.breed FROM Dog d")
    public List<String> findAllBreed();

    @Query("SELECT d.id, d.name FROM Dog d")
    public List<String> findAllName();

}
