package com.anjani.service;

import com.anjani.entity.Customer;
import com.anjani.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }
    public List<Customer>getAllCustomer(){
        return repository.findAll();
    }
    public Customer getByName(String name){
        return repository.findByName(name);
    }
    public Customer getById(Long id){
        return repository.findById(id).orElse(null);
    }
    public Customer getByContact(String contact){
        return repository.findByContact(contact);
    }
    public Customer getByMobile(String mobile){
        return repository.findByMobile(mobile);
    }
    public List<String>getAllNames(){
        return repository.getAllNames();
    }
    public Customer save(Customer customer){

        return repository.save(customer);
    }
}
