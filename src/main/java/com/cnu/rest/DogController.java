package com.cnu.rest;

import com.cnu.rest.domain.Dog;
import com.cnu.rest.domain.DogType;
import com.cnu.rest.service.DogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by schoi on 2017-05-21.
 */
@RestController
@RequestMapping(value = "/dogs")
@Slf4j
public class DogController {

    @Autowired
    private DogService dogService;

    @RequestMapping(method = RequestMethod.POST)
    public Dog createMyDog(@RequestParam String name, @RequestParam DogType type) {
        return dogService.createDog(name, type);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Dog> findAll() {
        return dogService.findAllDogs();
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Dog findDogByName(@PathVariable String name) {
        log.info("Requiest path variable is {}", name);
        return dogService.findByName(name);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.PUT)
    public Dog updateDogByName(@PathVariable String name, @RequestParam String changedName, @RequestParam DogType type) {
        log.info("Requested update dog {}, new name {}, new type {}", name, changedName, type);
        return dogService.updateDog(name, changedName, type);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
    public Dog deleteDogByName(@PathVariable String name) {
        return dogService.deleteDog(name);
    }
}
