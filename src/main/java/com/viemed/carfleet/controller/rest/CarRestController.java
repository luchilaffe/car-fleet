package com.viemed.carfleet.controller.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viemed.carfleet.controller.CarsController;
import com.viemed.carfleet.dto.CarDto;

/**
 * Rest Controller that publish services of Cars
 * 
 * @author carlos.lafferriere
 */
@RestController
@RequestMapping("/cars")
public class CarRestController {
	
	private CarsController controller;
	
	/**
	 * The Contructor 
	 * 
	 * @param controller to be injected
	 */
	CarRestController(CarsController controller){
		this.controller = controller;
	}

	/**
	 * Add a new car to the float
	 * 
	 * @param car to added
	 * @return the added car
	 */
	@PostMapping
	public ResponseEntity<CarDto> addCar(@RequestBody CarDto car){
        return ResponseEntity.ok().body(controller.addCar(car));		
	}
	
	/**
	 * Delete the car with the given id
	 * 
	 * @param id of the car to be deleted
	 * @return boolean that confirm the operation
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteCar(@PathVariable Long id) {
		return ResponseEntity.ok().body(controller.delete(id));
	}
	
	/**
	 * Get the list of all the cars that belongs to the fleet
	 * 
	 * @return a list of cars
	 */
	@GetMapping
	public ResponseEntity<List<CarDto>> getAll(){
		List<CarDto> response = controller.getAll().stream()
    			.collect(Collectors.toList());
        return ResponseEntity.ok().body(response);
    }
	
	/**
	 * Change the status of the car (On Road Vs. On Garage)
	 * 
	 * @param id of the car to change status
	 * @return the updated car
	 */
	@PatchMapping("/{id}")
	public ResponseEntity<CarDto> changeStatus(@PathVariable Long id){
		return ResponseEntity.ok().body(controller.changeStatus(id));
	}
	
}
