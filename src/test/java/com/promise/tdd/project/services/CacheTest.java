package com.promise.tdd.project.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.promise.tdd.project.models.Car;
import com.promise.tdd.project.repositories.CarRepository;

@SpringBootTest
 class CacheTest {
 
 @MockBean
 CarRepository carRepository;
 
 @Autowired
 CarService carService;
 
	@Test
	void getCar_Details() throws Exception {
		given(carRepository.findByName(Mockito.anyString())).willReturn(Optional.of(new Car("Toyota Corolla", "Toyota")));
		Optional<Car> car = carService.getCarDetails("mycar");
		assertNotNull(car.get());
		carService.getCarDetails("mycar");
		
		Mockito.verify(carRepository, Mockito.times(1)).findByName("mycar");
	}
	
}
