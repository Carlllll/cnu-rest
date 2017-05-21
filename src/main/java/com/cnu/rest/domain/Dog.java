package com.cnu.rest.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by schoi on 2017-05-21.
 */
@Data
@NoArgsConstructor
@Entity
public class Dog {

    @Id
    @GeneratedValue
    private int id;
    @Column(unique = true)
    private String name;
    private DogType type;

    public Dog(String name, DogType type) {
        this.name = name;
        this.type = type;
    }
}
