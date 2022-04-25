package com.viemed.carfleet.dto;

import lombok.Data;

@Data
public class CarDto {

	private String brand;
	private String model;
	private Integer year;
	private Boolean onRoad;
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Boolean getOnRoad() {
		return onRoad;
	}
	public void setOnRoad(Boolean onRoad) {
		this.onRoad = onRoad;
	}
}
