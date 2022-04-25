package com.viemed.carfleet.mapper;

import com.viemed.carfleet.dto.CarDto;
import com.viemed.carfleet.model.Cars;

/**
 * Car's mapper
 * 
 * @author carlos.lafferriere
 */
public class CarsMapper {

	/**
	 * Constructor
	 */
	private CarsMapper() {}
	
	/**
	 * Map a given car to a Car DTO.
	 * 
	 * @param car to map
	 * @return the car as DTO
	 */
	public static CarDto toCarDto(Cars car) {
		CarDto response = new CarDto();
		response.setModel(car.getModel());
		response.setBrand(car.getBrand());
		response.setYear(car.getYear());
		response.setOnRoad(car.getOnRoad());
		return response;
	}

	/**
	 * Map a given carDto to a Car.
	 * 
	 * @param carDto to map
	 * @return the car
	 */
	public static Cars toCars(CarDto carDto) {
		Cars response = new Cars();
		response.setModel(carDto.getModel());
		response.setBrand(carDto.getBrand());
		response.setYear(carDto.getYear());
		response.setOnRoad(carDto.getOnRoad());
		return response;
	}
	
}
