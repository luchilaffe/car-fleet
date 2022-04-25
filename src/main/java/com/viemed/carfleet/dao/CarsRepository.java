package com.viemed.carfleet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viemed.carfleet.model.Cars;

/**
 * Car's repository
 * 
 * @author carlos.lafferriere
 */
@Repository
public interface CarsRepository extends JpaRepository<Cars, Long> {

}
