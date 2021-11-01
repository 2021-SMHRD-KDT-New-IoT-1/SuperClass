package com.model;

public class WeatherArduinoVO {
	
	int WeatherArduino;
	
	public WeatherArduinoVO(int WeatherArduino) {
		this.WeatherArduino = WeatherArduino;
	}

	public int getWeatherArduino() {
		return WeatherArduino;
	}

	public void setWeatherArduino(int WeatherArduino) {
		this.WeatherArduino = WeatherArduino;
	}

	@Override
	public String toString() {
		return "WeatherArduinoVO [WeatherArduino=" + WeatherArduino + "]";
	}
	

}
