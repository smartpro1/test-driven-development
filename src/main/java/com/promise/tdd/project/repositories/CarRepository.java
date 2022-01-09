package com.promise.tdd.project.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.promise.tdd.project.models.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
   Optional<Car> findByName(String name);
   
}
