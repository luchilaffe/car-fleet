package com.viemed.carfleet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "cars")
public class Cars {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String brand;
	private String model;
	private Integer year;
	private Boolean onRoad;
	
	public Long getId() {
		return id;
	}
	public String getBrand() {
		return brand;
	}
	public String getModel() {
		return model;
	}
	public Integer getYear() {
		return year;
	}
	public Boolean getOnRoad() {
		return onRoad;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public void setOnRoad(Boolean onRoad) {
		this.onRoad = onRoad;
	}

}
