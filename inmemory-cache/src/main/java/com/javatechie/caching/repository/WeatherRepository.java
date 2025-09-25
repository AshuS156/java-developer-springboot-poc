package com.javatechie.caching.repository;

import com.javatechie.caching.entity.Weather;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer> {

    Weather findByCity(String city);

    void deleteByCity(String city);

    List<Weather> findAll();
}
