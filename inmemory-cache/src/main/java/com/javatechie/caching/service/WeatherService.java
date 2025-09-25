package com.javatechie.caching.service;

import com.javatechie.caching.config.CacheInspectionManager;
import com.javatechie.caching.entity.Weather;
import com.javatechie.caching.repository.WeatherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherService{
    private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);
    @Autowired
    CacheInspectionManager cacheInspectionManager;
    @Autowired
    private WeatherRepository weatherRepository;

    @Cacheable(value = "weather", key = "#city")
    public Weather getWeatherByCity(String city){
        logger.info("Fetching weather data for city: {}",city);
        cacheInspectionManager.printCacheContent("weather");
        final Weather byCity = weatherRepository.findByCity(city);
        logger.info("trying to get all weather data from db!!!!");
        return byCity;
    }


    @Cacheable(value = "weather")
    public List<Weather> getAllCityWeather(){
        //cacheInspectionManager.printCacheContent("weather");
        final List<Weather> all = weatherRepository.findAll();
        logger.info("trying to get all weather data from db!!!!");
        return all;
    }

    @CachePut(value = "weather", key = "#weather.city")
    public Weather saveWeather(Weather weather){
        logger.info("Saving weather data for city: {}",weather.getCity());
        return weatherRepository.save(weather);
    }

    @CachePut(value = "weather", key = "#city")
    public Weather updateWeatherByCity(String city){
        logger.info("Updating weather data for city: {}",city);
        Weather existingWeather = weatherRepository.findByCity(city);
        if (existingWeather != null) {
            existingWeather.setCity(city);
            existingWeather.setForecast("summer - 27°C");
            return weatherRepository.save(existingWeather);
        }
        logger.warn("Existing weather data found for city: {}",city);
        return existingWeather; // or throw an exception
    }


    @CacheEvict(value = "weather", key = "#city")
    public void deleteWeatherByCity(String city){
        logger.info("Deleting weather data for city: {}",city);
        Weather existingWeather = weatherRepository.findByCity(city);
        if (existingWeather != null) {
            weatherRepository.delete(existingWeather);
        }
    }
}
