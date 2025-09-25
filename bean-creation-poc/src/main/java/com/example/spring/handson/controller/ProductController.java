package com.example.spring.handson.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController{

    @GetMapping("/getemployeebyid/{employeeId}")
    public String getEmployeebyId(@PathVariable(value="employeeId") String id){
        System.out.println("-----getEmployeebyId-----");
        System.out.println("getEmployeebyId : " + id);
        return id;
    }

    @GetMapping("/getEmployeebyIdAndCountryCode/{employeeId}")
    public String getEmployeebyIdAndCountryCode(
            @PathVariable("employeeId") Integer employeeId,
            @RequestParam(value = "countryCode" , required = true) String countryCode ){
        System.out.println("-----getEmployeebyIdAndCountryCode-----");
        System.out.println("employeeId : " + employeeId);
        System.out.println("countryCode ::" + countryCode);
        return employeeId + "".concat(countryCode);

    }

  /*  @GetMapping("/getEmployeeWithCountryCodes")
    public List<String> getEmployeebyCountryCode(
            @RequestParam List<String> countryCode){
        System.out.println("----getEmployeebyCountryCode----");
        System.out.println("countryCode ::" + countryCode);
        return countryCode;

    }*/

    @GetMapping("/getEmployeeWithCountryCodes")
    public String getEmployeeBasedOnCountryCode(
            @RequestParam String countryCode){
        System.out.println("-----getEmployeeBasedOnCountryCode-------");
        System.out.println("countryCode ::" + countryCode);
        return countryCode;

    }

    @GetMapping("/welcome")
    public String getString(){
        return "welcome!!!";
    }
}
