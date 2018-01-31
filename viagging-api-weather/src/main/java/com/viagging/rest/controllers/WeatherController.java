package com.viagging.rest.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.viagging.weather.model.WeatherDTO;
import com.viagging.weather.model.WeatherObject;

@RestController
@RequestMapping("/weather")
public class WeatherController {
	
	private static final String WEATHER_KEY = "8e6c2b16e2f55e92e0e75de4a26887ba";
	
	@RequestMapping(value = "/{ciudad}", method = RequestMethod.GET)
	public WeatherDTO getWeather(@PathVariable String ciudad){
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<WeatherObject> response = restTemplate.getForEntity(
		        "http://api.openweathermap.org/data/2.5/weather?q=" + ciudad + "&appid=" + WEATHER_KEY, 
		        WeatherObject.class);
		WeatherObject res = response.getBody();
		WeatherDTO weather = new WeatherDTO(res.getWeather().get(0), res.getMain());
		return weather;
	}

}
