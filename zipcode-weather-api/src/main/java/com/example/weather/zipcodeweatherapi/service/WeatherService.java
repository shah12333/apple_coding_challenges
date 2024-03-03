package com.example.weather.zipcodeweatherapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.weather.zipcodeweatherapi.invalid.zipcode.InvalidZipcodeException;
import com.example.weather.zipcodeweatherapi.model.WeatherForecast;

@Service
public class WeatherService {
    
	private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);
	
	
    @Cacheable(value = "weatherCache", key = "#zipcode")
    public WeatherForecast getWeatherForecast(String zipcode) {
    	
    	logger.info("Fetching weather forecast from DB for zipcode: {}", zipcode);
       
    	 if (!isValidZipcode(zipcode)) {
             throw new InvalidZipcodeException("Invalid ZIP code: " + zipcode);
         }
    	 
    	// Implement logic to fetch weather forecast from an external API
         // You can use any weather API library or make HTTP requests directly
         // For simplicity, let's assume we are returning default mock data
    	 
    	  // Mock data for weather forecasts based on ZIP codes
         if ("10001".equals(zipcode)) {
             return new WeatherForecast(20, 25, 15);
         } else if ("20001".equals(zipcode)) {
             return new WeatherForecast(30, 35, 25);
         } else {
             return new WeatherForecast(25, 30, 20);
         }
   }
    
    @CacheEvict(value = "weatherCache", key = "#zipcode")
    public String clearWeatherCache(String zipcode) {
    	logger.info("Clearing weather forecast cache for zipcode: {}", zipcode);
    	return zipcode+" "+"has been deleted";
    }
    
    private boolean isValidZipcode(String zipcode) {
        // Implement ZIP code validation logic
        // For simplicity, we assume any 5-digit number is a valid ZIP code
        return zipcode.matches("\\d{5}");
    }
}