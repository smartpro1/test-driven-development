package com.promise.tdd.project.services;

import java.util.Optional;

import com.promise.tdd.project.models.Car;

public interface CarService {

	Optional<Car> getCarDetails(String name);
}
