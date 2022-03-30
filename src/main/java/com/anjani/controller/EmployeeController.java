package com.anjani.controller;

import com.anjani.entity.Employee;
import com.anjani.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/save")
    public ResponseEntity<Employee> save(@RequestBody Employee employee)
    {
       return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Employee>>getAllEmployee(){
        return new ResponseEntity<>(employeeService.getAllEmployees(),HttpStatus.OK);
    }
    @GetMapping("/allnamesbydesignation/{designation}")
    public ResponseEntity<List<String>>getEmployeeNamesByDesignation(@PathVariable("designation") String designation){
        return new ResponseEntity<>(employeeService.getEmployeeNamesByDesignation(designation),HttpStatus.OK);
    }
    @GetMapping("/allnicknamesbydesignation/{designation}")
    public ResponseEntity<List<String>>getEmployeeNicknamesByDesignation(@PathVariable("designation") String designation){
        return new ResponseEntity<>(employeeService.getEmployeeNicknamesByDesignation(designation),HttpStatus.OK);
    }


    @GetMapping("/byname/{name}")
    public ResponseEntity<Employee>getByName(@PathVariable("name")String name){
        return new ResponseEntity<>(employeeService.getByName(name),HttpStatus.OK);
    }


}
