package com.mc.temperature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import com.mc.temperature.service.ITemperatureCalculateService;
import com.mc.temperature.service.ITemperatureInputService;

@SpringBootApplication
public class TemperatureApplication implements CommandLineRunner{
	
	private ITemperatureInputService inputService;
	@Autowired
	private ITemperatureCalculateService calculateService;
	@Autowired
    private ApplicationContext appContext;
	@Autowired
	private Environment env;
	
	public static void main(String[] args) {
		SpringApplication.run(TemperatureApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.inputService = (ITemperatureInputService)appContext.getBean(env.getProperty("temperature.input.mode"));
		System.out.print(calculateService.calculateTemperatureOutput(inputService.getTemperatureInput()));
	}

}
