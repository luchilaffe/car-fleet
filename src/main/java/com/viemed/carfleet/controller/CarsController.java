package com.viemed.carfleet.controller;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.viemed.carfleet.dto.CarDto;
import com.viemed.carfleet.mapper.CarsMapper;
import com.viemed.carfleet.service.ICarsService;

/**
 * Controller of the Cars
 * 
 * @author carlos.lafferriere
 *
 */
@Controller
public class CarsController {

    private ICarsService service;
    
    /**
     * The constructor
     * 
     * @param carsService to be inyected in the controller
     */
    CarsController(ICarsService carsService) {
        this.service = carsService;
    }

    /**
     * Add a new car to the fleet
     * 
     * @param car to add
     * @return the new car
     */
    public CarDto addCar(CarDto car) {
    	return CarsMapper.toCarDto(service.addCar(car));
    }
    
    /**
     * Delete the car with the given id
     * 
     * @param id of the car to be deleted
     * @return boolean that confirm the operation
     */
    public Boolean delete(Long id) {
    	return service.delete(id);
    }
    
    /**
     * Method that get all Super Heroes.
     * 
     * @return a list with all super heroes
     */
    public List<CarDto> getAll() {
        return service.getAll();
    }

    /**
     * Method that change the "onRoad" status of the car 
     * 
     * @param id of the car to change status
     * @return the updated car
     */
    public CarDto changeStatus(Long id) {
    	return CarsMapper.toCarDto(service.changeStatus(id));
    }
    
}
