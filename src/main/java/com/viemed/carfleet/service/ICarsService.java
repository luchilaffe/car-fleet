package com.viemed.carfleet.service;

import java.util.List;

import com.viemed.carfleet.dto.CarDto;
import com.viemed.carfleet.model.Cars;

/**
 * Car's service
 * 
 * @author carlos.lafferriere
 *
 */
public interface ICarsService {

	/**
	 * Add a new Car to fleet
	 * 
	 * @param car to add
	 * @return the added car
	 */
	Cars addCar(CarDto car);

	/**
	 * Delete the car with the given Id
	 * 
	 * @param id of the car to be deleted
	 * @return boolean that confirm the operation
	 */
	Boolean delete(Long id);
	
    /**
     * Service that returns all Cars
     * 
     * @return a list of Cars Dto with all of them
     */
    List<CarDto> getAll();
    
    /**
     * Change the status of the given car
     * 
     * @param id of the car to change status
     * @return the car with the updated status
     */
    Cars changeStatus(Long id);

}
