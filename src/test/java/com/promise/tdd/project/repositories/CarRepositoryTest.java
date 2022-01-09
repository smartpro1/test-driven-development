package com.promise.tdd.project.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.promise.tdd.project.models.Car;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class CarRepositoryTest {
	
	@Autowired
	CarRepository carRepository;
	
	@Test
	void testFindByName() {
		
		Optional<Car> car = carRepository.findByName("lodgy");
		
		assertTrue(car.isPresent());
		
		assertEquals("lodgy", car.get().getName());
		assertEquals("suv", car.get().getType());
		
	}
	
	@Test
	void testFindByNameNotPresent() {
		Optional<Car> car = carRepository.findByName("falseName");
		
		assertTrue(car.isEmpty());
		assertFalse(car.isPresent());
	}

}
