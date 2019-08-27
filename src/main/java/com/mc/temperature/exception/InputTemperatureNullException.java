package com.mc.temperature.exception;

public class InputTemperatureNullException extends AbstractBaseTemperatureException{

	private static final long serialVersionUID = 8026745951070096216L;

	public InputTemperatureNullException(String errorMessage) {
		super(errorMessage);
	}

}
