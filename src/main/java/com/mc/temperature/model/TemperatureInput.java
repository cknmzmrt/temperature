package com.mc.temperature.model;

import java.util.List;

public class TemperatureInput {

	private int numberOfDays;
	private List<Integer> temperatures;
	
	public int getNumberOfDays() {
		return numberOfDays;
	}
	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
	public List<Integer> getTemperatures() {
		return temperatures;
	}
	public void setTemperatures(List<Integer> temperatures) {
		this.temperatures = temperatures;
	}
	
	
}
