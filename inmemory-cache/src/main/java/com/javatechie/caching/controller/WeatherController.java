package com.javatechie.caching.controller;

import com.javatechie.caching.entity.Weather;
import com.javatechie.caching.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
public class WeatherController{

    @Autowired
    WeatherService weatherService;

    @GetMapping("/bycity/{city}")
    public ResponseEntity<?> getWeatherByCity(@PathVariable("city") String city) {
        return ResponseEntity.ok("Get Weather data : " + weatherService.getWeatherByCity(city));
    }

    @GetMapping("/allcityweather")
    public ResponseEntity<?> getWeatherByCity() {
        return ResponseEntity.ok("Get Weather data : " + weatherService.getAllCityWeather());
    }

    @PostMapping("/weatherboarding's")
    public ResponseEntity<?> saveWeather(@RequestBody Weather  weather) {
        return ResponseEntity.ok("Weather data saved : " + weatherService.saveWeather(weather));
    }


    @PutMapping("/updatebycity/{city}")
    public ResponseEntity<?> updateWeatherByCity(@PathVariable("city") String city) {
        return ResponseEntity.ok("update Weather data : " + weatherService.updateWeatherByCity(city));
    }

    @DeleteMapping("/deletebycity/{city}")
    public ResponseEntity<?> deleteWeatherByCity(@PathVariable("city") String city) {
        weatherService.deleteWeatherByCity(city);
        return ResponseEntity.ok("Delete Weather data for : " + city);
    }
}
