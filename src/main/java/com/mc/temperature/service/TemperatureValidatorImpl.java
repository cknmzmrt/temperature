package com.mc.temperature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.mc.temperature.exception.AbstractBaseTemperatureException;
import com.mc.temperature.exception.InputTemperatureNullException;
import com.mc.temperature.exception.TemperatureInputValuesNotEnoughError;
import com.mc.temperature.model.TemperatureInput;

@Service
public class TemperatureValidatorImpl implements ITemperatureValidator {

	@Autowired
	private Environment env;
	
	@Override
	public void validateTemperatureInput(TemperatureInput input) throws AbstractBaseTemperatureException {
		if (null == input) {
			throw new InputTemperatureNullException(env.getProperty("temperature.error.input.null"));
		} else if (input.getNumberOfDays() != 0
				&& (null == input.getTemperatures() || input.getTemperatures().size() != input.getNumberOfDays())) {
			throw new TemperatureInputValuesNotEnoughError(env.getProperty("temperature.error.input.temps.not.enough"));
		}

	}

}
