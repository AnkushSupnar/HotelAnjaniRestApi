package com.anjani.service;

import com.anjani.entity.TempTransaction;
import com.anjani.repository.TempTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;

@Service
public class TempTransactionService {
    private final TempTransactionRepository repository;

    @Autowired
    public TempTransactionService(TempTransactionRepository repository) {
        this.repository = repository;
    }

    public List<TempTransaction>getAll(){
        return repository.findAll();
    }

    public List<TempTransaction>getByTableId(Integer tableid){
        return repository.findByTableMaster_Id(tableid);
    }
    public TempTransaction save(TempTransaction temp){
        return repository.save(temp);
    }

    public Long deleteTempTransaction(Integer tableid){
         return repository.deleteByTableMaster_Id(tableid);

    }
}
