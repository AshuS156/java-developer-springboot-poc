package com.javatechie.caching.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Weather{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String city;

    private String forecast;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getForecast(){
        return forecast;
    }

    public void setForecast(String forecast){
        this.forecast = forecast;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this,ToStringStyle.JSON_STYLE);
    }
}
