package com.mc.temperature.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mc.temperature.model.TemperatureInput;

@Service("console")
public class ConsoleTemperatureInputService implements ITemperatureInputService {

	@Override
	public TemperatureInput getTemperatureInput() {
		
		TemperatureInput inputTemp = new TemperatureInput();
		
		Scanner in = new Scanner(System.in);
		
		int numberOfDays = Integer.valueOf(in.nextLine());
		inputTemp.setNumberOfDays(numberOfDays);
		
		if(0 != numberOfDays) {
			String temps = in.nextLine();
			
			if(!StringUtils.isEmpty(temps)) {
				String[] listTemp = temps.split(" ");
				
				if(null != listTemp && listTemp.length > 0) {
					List<Integer> vals = new ArrayList<>();
					Arrays.asList(listTemp).forEach(s -> vals.add(Integer.valueOf(s)));
					inputTemp.setTemperatures(vals);
				}
			}
		}
		
		in.close();
		return inputTemp;
	}

}
