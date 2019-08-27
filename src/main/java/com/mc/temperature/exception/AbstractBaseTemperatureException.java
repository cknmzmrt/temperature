package com.mc.temperature.exception;

public abstract class AbstractBaseTemperatureException extends Exception{

	private static final long serialVersionUID = 7587884286411107639L;
	protected String errorMessage;

	public AbstractBaseTemperatureException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}
	
}
