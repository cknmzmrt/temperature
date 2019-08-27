package com.mc.temperature.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mc.temperature.model.TemperatureInput;

@Service("property")
public class PropertyTemperatureInputService implements ITemperatureInputService {

	@Autowired
	private Environment env;
	@Override
	public TemperatureInput getTemperatureInput() {
		TemperatureInput inputTemp = new TemperatureInput();
		inputTemp.setNumberOfDays(Integer.valueOf(env.getProperty("number.of.days")));
		if(0 != inputTemp.getNumberOfDays()) {
			String temps = env.getProperty("temperatures.of.days");
			if(!StringUtils.isEmpty(temps)) {
				String[] listTemp = temps.split(" ");
				
				if(null != listTemp && listTemp.length > 0) {
					List<Integer> vals = new ArrayList<>();
					Arrays.asList(listTemp).forEach(s -> vals.add(Integer.valueOf(s)));
					inputTemp.setTemperatures(vals);
				}
				
			}
		}
		return inputTemp;
	}

}
