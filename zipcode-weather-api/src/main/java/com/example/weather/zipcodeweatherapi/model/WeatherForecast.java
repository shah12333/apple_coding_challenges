package com.example.weather.zipcodeweatherapi.model;

public class WeatherForecast {

	private int currentTemperature;
    private int highTemperature;
    private int lowTemperature;
    
    public WeatherForecast(int currentTemperature, int highTemperature, int lowTemperature) {
        this.currentTemperature = currentTemperature;
        this.highTemperature = highTemperature;
        this.lowTemperature = lowTemperature;
    }

	public int getCurrentTemperature() {
		return currentTemperature;
	}

	public void setCurrentTemperature(int currentTemperature) {
		this.currentTemperature = currentTemperature;
	}

	public int getHighTemperature() {
		return highTemperature;
	}

	public void setHighTemperature(int highTemperature) {
		this.highTemperature = highTemperature;
	}

	public int getLowTemperature() {
		return lowTemperature;
	}

	public void setLowTemperature(int lowTemperature) {
		this.lowTemperature = lowTemperature;
	}
   
    
}
