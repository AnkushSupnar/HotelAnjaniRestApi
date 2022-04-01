package com.anjani.service;

import com.anjani.entity.Item;
import com.anjani.entity.TableMaster;
import com.anjani.entity.TempTransaction;
import com.anjani.repository.TempTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;
import java.util.stream.Collectors;

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
    public TempTransaction getByItemAndTable(String itemname,TableMaster tableMaster){
        return repository.findByItemnameAndTableMaster(itemname,tableMaster);
    }
    public TempTransaction getByItemAndRateAndTable(String item,TableMaster tableMaster,Float rate){
       // System.out.println("In Service= >"+repository.findByItemAndTableMasterAndRate(item,tableMaster,rate));
        return repository.findByItemnameAndTableMasterAndRate(item,tableMaster,rate);
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
    public List<TempTransaction>getTableOrder(Integer tableid){
        return getByTableId(tableid).stream().filter(t->t.getPrintqty()>0).collect(Collectors.toList());
    }
    public int setRemovePrintQuantity(Integer tableid){

       return repository.updatePrintqtyByTableMaster_Id(0.0f,tableid);
    }
}
