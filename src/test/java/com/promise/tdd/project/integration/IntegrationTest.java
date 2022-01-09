package com.promise.tdd.project.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.promise.tdd.project.models.Car;
import com.promise.tdd.project.services.CarService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
 class IntegrationTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	CarService carService;
	
	HttpHeaders headers = new HttpHeaders();
	
	@Test
	void getCarDetails() throws Exception{
		HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
		ResponseEntity<Car> response = restTemplate.exchange("http://localhost:" + port + "/cars/suv", HttpMethod.GET, requestEntity, Car.class);
	    
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("jeep", response.getBody().getType());
	}
	
}
