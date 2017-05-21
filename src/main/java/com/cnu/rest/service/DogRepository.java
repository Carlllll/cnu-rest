package com.cnu.rest.service;

import com.cnu.rest.domain.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by schoi on 2017-05-22.
 */
public interface DogRepository extends JpaRepository<Dog, Integer> {
    Dog findByName(String name);
}
