package com.example.spring.aop.service;

import com.example.spring.aop.dto.Employee;
import com.example.spring.aop.repository.EmployeeDB;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmpoyeeServiceImpl{

    public List<Employee> getAllEmp() throws IOException{
        return  EmployeeDB.getAllEmployee();
    }

    public Employee saveEmployee(Employee employee) {
        return  employee;
    }

    public Employee getEmployeeById(Integer employeeId) throws IOException{
        return EmployeeDB.getAllEmployee().stream().filter(employee ->
         Integer.parseInt(employee.getEmployeeId()) == employeeId
        ).findFirst().orElseThrow(() ->  new RuntimeException("Employee Not found"));
    }

}

