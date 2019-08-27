package com.mc.temperature.service;

import java.util.OptionalDouble;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.mc.temperature.exception.AbstractBaseTemperatureException;
import com.mc.temperature.model.TemperatureInput;

@Service
public class TemperatureCalculateServiceImpl implements ITemperatureCalculateService {

	@Autowired
	private Environment env;
	@Autowired
	private ITemperatureValidator inputValidator;
	
	@Override
	public String calculateTemperatureOutput(TemperatureInput input) throws AbstractBaseTemperatureException{
		
		inputValidator.validateTemperatureInput(input);
		
		String rtnMessage = null;
		if(input.getNumberOfDays() == 0) {
			rtnMessage = env.getProperty("temperature.nodata");
		}else {
			
			OptionalDouble average = input.getTemperatures().stream().mapToInt(i->i).average();
			long aboveAverageTemp =  0;
			if(average.isPresent()) {
				aboveAverageTemp = input.getTemperatures().stream().filter(x -> x > average.getAsDouble()).count();
				rtnMessage = String.format(env.getProperty("message.format"), average.getAsDouble(), aboveAverageTemp);
			}
		}
		
  
		return rtnMessage;
	}

}
