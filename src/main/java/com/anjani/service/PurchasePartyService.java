package com.anjani.service;

import com.anjani.entity.PurchaseParty;
import com.anjani.repository.PurchasePartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchasePartyService {
    private PurchasePartyRepository repository;
    @Autowired
    public PurchasePartyService(PurchasePartyRepository repository){
        this.repository = repository;
    }
    public List<PurchaseParty> getAllPurchaseParty(){return repository.findAll();}
    public List<String>getAllPartyNames(){return repository.findByNameOrderByNameAsc();}
    public PurchaseParty getById(Integer id){
        return repository.findById(id).orElse(null);
    }
    public PurchaseParty getByName(String name){
        return repository.findByName(name);
    }
    public PurchaseParty save(PurchaseParty party){
        return repository.save(party);
    }


}
