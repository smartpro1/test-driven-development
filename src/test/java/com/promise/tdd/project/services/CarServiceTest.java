package com.promise.tdd.project.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.promise.tdd.project.exceptions.CarNotFoundException;
import com.promise.tdd.project.models.Car;
import com.promise.tdd.project.repositories.CarRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.*;

import java.util.Optional;

//@ExtendWith(MockitoExtension.class)
class CarServiceTest {
	
	@Mock
	CarRepository carRepository;
    
	CarService carService ;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		carService = new CarServiceImpl(carRepository);
	}
	
	
	
	@Test
	void getCar_Details() throws Exception {
		given(carRepository.findByName(Mockito.anyString())).willReturn(Optional.of(new Car("Toyota Corolla", "Toyota")));
		Optional<Car> car = carService.getCarDetails("mycar");
		assertNotNull(car);
		assertEquals("Toyota Corolla", car.get().getName());
		assertEquals("Toyota", car.get().getType());
	}
	
	@Test
	void car_Not_Found() throws Exception {
		given(carRepository.findByName(Mockito.anyString())).willThrow(new CarNotFoundException());
		
		assertThrows(CarNotFoundException.class, ()-> carService.getCarDetails("mycar"));
	}
}
