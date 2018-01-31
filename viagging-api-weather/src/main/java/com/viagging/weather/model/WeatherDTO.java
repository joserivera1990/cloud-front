package com.viagging.weather.model;

public class WeatherDTO {
	
	private Double temp;
	private String icon;
	
	public WeatherDTO(Weather weather, Main main) {
		this.setIcon(weather.getIcon());
		this.setTemp(Double.parseDouble(main.getTemp()));
	}

	public int getTemp() {
		Double val = ((1.8 * (temp - 273.15) + 32) - 32) / 1.8;
		return val.intValue();
	}

	public void setTemp(Double temp) {
		this.temp = temp;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

}
