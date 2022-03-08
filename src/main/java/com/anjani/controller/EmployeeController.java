package com.anjani.controller;

import com.anjani.entity.Employee;
import com.anjani.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/save")
    public Employee saveAll(@RequestBody Employee emloyee)
    {
       return employeeService.saveEmployee(emloyee);
    }
    @GetMapping
    public List<Employee>getAllEmployee(){
        return employeeService.getAllEmployees();
    }

}
