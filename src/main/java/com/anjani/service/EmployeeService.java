package com.anjani.service;

import com.anjani.entity.Employee;
import com.anjani.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private
    EmployeeRepository repository;
    public Employee saveEmployee(Employee employee)
    {
         repository.save(employee);
         return employee;
    }
    public List<Employee>getAllEmployees(){
        return repository.findAll();
    }
    public List<Employee>saveAll(){
        List<Employee>list = new ArrayList<>();

        list.add(new Employee(1L," AMkuSa saavaLorama saupanar","AMkuSa","AmaLnaor","9960855742","Manager",5000.0f,"Monthly","Active"));
        repository.saveAll(list);
        return list;
    }
    public List<String>getEmployeeNamesByDesignation(String designation){
        return repository.findNamesByDesignation(designation);
    }
    public List<String>getEmployeeNicknamesByDesignation(String designation){
        return repository.findNicknamesByDesignation(designation);
    }
    public Employee getByName(String name){
        return repository.findByName(name);
    }

}
