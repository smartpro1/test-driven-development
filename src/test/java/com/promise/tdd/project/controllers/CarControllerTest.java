package com.promise.tdd.project.controllers;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.promise.tdd.project.exceptions.CarNotFoundException;
import com.promise.tdd.project.models.Car;
import com.promise.tdd.project.services.CarService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CarController.class)
class CarControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	CarService carService;
	
	@Test
	@DisplayName("Get Car Details Test")
	void getCar_Details() throws Exception {
		given(carService.getCarDetails(Mockito.anyString())).willReturn(Optional.of(new Car("scala", "Car")));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/cars/scala"))
		  .andExpect(status().isOk())
		  .andExpect(jsonPath("$").isMap())
		  .andExpect(jsonPath("name").value("scala"))
		  .andExpect(jsonPath("type").value("Car"));
	}
	
	@Test
	 void Car_NotFound_HttpStatus() throws Exception {
		given(carService.getCarDetails(Mockito.anyString())).willThrow(new CarNotFoundException());
	
	    mockMvc.perform(MockMvcRequestBuilders.get("/cars/scala"))
	      .andExpect(status().isNotFound());
	}
}
