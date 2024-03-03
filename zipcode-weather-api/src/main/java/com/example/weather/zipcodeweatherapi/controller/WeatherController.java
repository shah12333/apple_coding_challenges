package com.example.weather.zipcodeweatherapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.weather.zipcodeweatherapi.model.WeatherForecast;
import com.example.weather.zipcodeweatherapi.service.WeatherService;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    
    @Autowired
    private WeatherService weatherService;
    
    @GetMapping("/{zipcode}")
    public ResponseEntity<WeatherForecast> getWeather(@PathVariable String zipcode) {
        WeatherForecast forecast = weatherService.getWeatherForecast(zipcode);
        return ResponseEntity.ok(forecast);
    }
    
    @DeleteMapping("/{zipcode}")
    public String deleteZipcode(@PathVariable String zipcode){
        return weatherService.clearWeatherCache(zipcode);
    }
}