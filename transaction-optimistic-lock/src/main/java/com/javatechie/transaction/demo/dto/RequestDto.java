package com.javatechie.transaction.demo.dto;

import jakarta.persistence.Version;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


@AllArgsConstructor
@NoArgsConstructor
public class RequestDto{

    private String status;
    private String movieName;
    private int version;

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

    public String toString() {
        return ToStringBuilder.reflectionToString(this,ToStringStyle.JSON_STYLE);
    }

}
