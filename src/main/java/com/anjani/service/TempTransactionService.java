package com.anjani.service;

import com.anjani.entity.Item;
import com.anjani.entity.TableMaster;
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
    public TempTransaction getByItemAndTable(Item item,TableMaster tableMaster){
        return repository.findByItemAndTableMaster(item,tableMaster);
    }
    public TempTransaction getByItemAndRateAndTable(Item item,TableMaster tableMaster,Float rate){
       // System.out.println("In Service= >"+repository.findByItemAndTableMasterAndRate(item,tableMaster,rate));
        return repository.findByItemAndTableMasterAndRate(item,tableMaster,rate);
    }

    public TempTransaction save(TempTransaction temp){
        return repository.save(temp);
    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }
    public List<TempTransaction>deleteByTableMaster(TableMaster tableMaster){
        return repository.deleteByTableMaster(tableMaster);
    }
    public List<TableMaster>getOpenTable(){
        return repository.getOpenTable();
    }
}
