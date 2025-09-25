package com.javatechie.transaction.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Seat{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private String movieName;
    @Version
    private int version;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getMovieName(){
        return movieName;
    }

    public void setMovieName(String movieName){
        this.movieName = movieName;
    }

    public int getVersion(){
        return version;
    }

    public void setVersion(int version){
        this.version = version;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this,ToStringStyle.JSON_STYLE);
    }

}
