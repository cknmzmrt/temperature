package com.mc.temperature.exception;

public class TemperatureInputValuesNotEnoughError extends AbstractBaseTemperatureException{

	private static final long serialVersionUID = -8425158291888946635L;

	public TemperatureInputValuesNotEnoughError(String errorMessage) {
		super(errorMessage);
	}

}
