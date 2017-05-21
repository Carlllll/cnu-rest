package com.cnu.rest;

import com.cnu.rest.domain.Dog;
import com.cnu.rest.domain.DogType;
import com.cnu.rest.service.DogService;
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
public class DogControllerTest {

    @InjectMocks
    private DogController dogController;
    @Mock
    private DogService dogService;

    @Test
    public void 강아지생성_성공() {
        Dog dog = new Dog("david", DogType.BULLDOG);
        when(dogService.createDog("david", DogType.BULLDOG)).thenReturn(dog);
        Dog result = dogController.createMyDog("david", DogType.BULLDOG);
        assertThat(result.getName(), is("david"));
    }

    @Test
    public void 강아지들조회_성공() {
        Dog firstDog = new Dog("1", DogType.BULLDOG);
        when(dogService.findAllDogs()).thenReturn(Arrays.asList(firstDog));

        List<Dog> result = dogController.findAll();
        assertThat(result.size(), is(1));
        assertThat(result.get(0).getName(), is("1"));
    }

}