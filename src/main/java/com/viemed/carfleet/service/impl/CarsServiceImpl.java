package com.viemed.carfleet.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.viemed.carfleet.dao.CarsRepository;
import com.viemed.carfleet.dto.CarDto;
import com.viemed.carfleet.exceptions.NotFoundException;
import com.viemed.carfleet.mapper.CarsMapper;
import com.viemed.carfleet.model.Cars;
import com.viemed.carfleet.service.ICarsService;

/**
 * {@inheritDoc}
 * 
 * @author carlos.lafferriere
 */
@Service
public class CarsServiceImpl implements ICarsService {

	private CarsRepository repository;

	CarsServiceImpl(CarsRepository carsRepository){
		this.repository = carsRepository;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Cars addCar(CarDto car) {
		return repository.save(CarsMapper.toCars(car));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean delete(Long id) {
		Optional<Cars> car = repository.findById(id);
		if (car.isPresent()) {
			repository.deleteById(id);
			return Boolean.TRUE;
		} else
			throw new NotFoundException("Not found ID: " + id);
	}
	
    /**
     * {@inheritDoc}
     */
    @Override
    public List<CarDto> getAll() {
        List<CarDto> response = repository.findAll().stream()
                .map(CarsMapper::toCarDto).collect(Collectors.toList());
        if (!response.isEmpty()) {
            return response;
        } else {
            throw new NotFoundException("There are no Cars.");
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Cars changeStatus(Long id) {
    	Optional<Cars> car = repository.findById(id);
		if (car.isPresent()) {
			car.get().setOnRoad(!car.get().getOnRoad());
			return repository.save(car.get());
		} else
			throw new NotFoundException("Not found ID: " + id);
    }
	
}
