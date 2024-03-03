package com.example.weather.zipcodeweatherapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ZipcodeWeatherApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipcodeWeatherApiApplication.class, args);
	}

}
