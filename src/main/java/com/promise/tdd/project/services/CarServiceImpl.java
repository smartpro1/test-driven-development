package com.promise.tdd.project.services;

import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.promise.tdd.project.models.Car;
import com.promise.tdd.project.repositories.CarRepository;

@Service
public class CarServiceImpl implements CarService {
	private final CarRepository carRepository;
	
	public CarServiceImpl(CarRepository carRepository) {
		this.carRepository = carRepository;
	}
	
	@Override
	@Cacheable("cars")
	public Optional<Car> getCarDetails(String name) {
		Optional<Car> car = carRepository.findByName(name);
		return car;
	}

}
