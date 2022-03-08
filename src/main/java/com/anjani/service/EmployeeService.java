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

}
