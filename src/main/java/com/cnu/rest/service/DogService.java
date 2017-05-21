package com.cnu.rest.service;

import com.cnu.rest.domain.Dog;
import com.cnu.rest.domain.DogType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by schoi on 2017-05-21.
 */
@Service
@Slf4j
public class DogService {

    @Autowired
    private DogRepository dogRepository;

    public Dog createDog(String name, DogType type) {
        Dog dog = new Dog(name, type);
        dogRepository.save(dog);
        log.info("Saved dog with name {}, type {}", name, type);
        return dog;
    }

    public List<Dog> findAllDogs() {
        return dogRepository.findAll();
    }

    public Dog findByName(String name) {
        return dogRepository.findByName(name);
    }

    public Dog updateDog(String name, String changedName, DogType type) {
        Dog dog = dogRepository.findByName(name);
        dog.setName(changedName);
        dog.setType(type);
        return dogRepository.save(dog);
    }

    public Dog deleteDog(String name) {
        Dog dog = dogRepository.findByName(name);
        if (dog != null) {
            dogRepository.delete(dog);
        }
        return dog;
    }
}
