package com.cnu.rest.service;

import com.cnu.rest.domain.Dog;
import com.cnu.rest.domain.DogType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by schoi on 2017-05-21.
 */
@RunWith(MockitoJUnitRunner.class)
public class DogServiceTest {

    @InjectMocks
    private DogService dogService;
    @Mock
    private DogRepository dogRepository;

    @Test
    public void 강아지_이름이_david_이고_타입이_bulldog_생성성공() {
        Dog dog = new Dog("david", DogType.BULLDOG);
        when(dogRepository.save(dog)).thenReturn(dog);
        Dog result = dogService.createDog("david", DogType.BULLDOG);
        assertThat(result.getName(), is("david"));
        assertThat(result.getType(), is(DogType.BULLDOG));
    }

    @Test
    public void 강아지_두마리를_저장후_조회하면_두마리의_강아지_조회성공() {
        Dog firstDog = new Dog("1", DogType.BULLDOG);
        Dog secondDog = new Dog("2", DogType.BULLDOG);

        when(dogRepository.findAll()).thenReturn(Arrays.asList(firstDog, secondDog));

        List<Dog> result = dogService.findAllDogs();
        assertThat(result.size(), is(2));
    }
}