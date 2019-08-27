package com.mc.temperature.service;

import com.mc.temperature.exception.AbstractBaseTemperatureException;
import com.mc.temperature.model.TemperatureInput;

public interface ITemperatureCalculateService {

	String calculateTemperatureOutput(TemperatureInput input) throws AbstractBaseTemperatureException;
}
