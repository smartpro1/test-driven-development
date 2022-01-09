package com.promise.tdd.project.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.promise.tdd.project.models.Car;
import com.promise.tdd.project.services.CarService;

@RestController
@RequestMapping("/cars")
public class CarController {
	
	private final CarService carService;
	
	public CarController(CarService carService) {
		this.carService = carService;
	}
	
	
	@GetMapping("/{name}")
	public ResponseEntity<Optional<Car>> getCarDetails(@PathVariable String name) throws Exception {
		Optional<Car> car = carService.getCarDetails(name);
		return new ResponseEntity<>(car, HttpStatus.OK);
	}

}
