
package com.weather.weatherapp.controller;

import java.text.ParseException;
import java.util.List;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.weather.weatherapp.models.Example;
import com.weather.weatherapp.models.Forecast2;
import com.weather.weatherapp.services.WeatherService;
import com.weather.weatherapp.models.Air;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class WeatherController {

	private final WeatherService weatherService;

	@Autowired
	public WeatherController(WeatherService weatherService) {
		this.weatherService = weatherService;
	}

	@RequestMapping("/")
	String home() {
		return "Hello Partha!";
	}

	@RequestMapping("forecast/{city}")
	public List<Example> getWeatherForFive(
			@PathVariable String city) throws ParseException {
		return this.weatherService.getWeatherForFive(city);
	}

	@RequestMapping("weather/{city}")
	public List<Example> getWeather(
			@PathVariable String city) {
		return this.weatherService.getWeather(city);
	}

	@RequestMapping("airpollution/{city}")
	public List<Air> getairpollution(
			@PathVariable String city) {
		return this.weatherService.getairpollution(city);
	}

	@RequestMapping("forecast2/{city}")
	public List<Forecast2> getWeatherForFive2(
			@PathVariable String city) {
		return this.weatherService.getWeatherForFive2(city);
	}

}
