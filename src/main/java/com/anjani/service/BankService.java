package com.anjani.service;

import com.anjani.entity.Bank;
import com.anjani.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {
    private BankRepository repository;
    @Autowired
    public BankService(BankRepository repository){
        this.repository = repository;
    }
    public List<Bank> getAllBank(){
        return repository.findAll();
    }
    public List<String>getAllBankName(){
        return repository.findAllName();
    }
    public Bank getByName(String name){
        return repository.findByName(name).orElse(null);
    }
    public Bank getById(Long id){
        return repository.findById(id).orElse(null);
    }
    public Bank save(Bank bank){
        return repository.save(bank);
    }
    public Integer addBankBalance(Long id,Float bal){
        return repository.addBankBalance(id,bal);
    }
}
