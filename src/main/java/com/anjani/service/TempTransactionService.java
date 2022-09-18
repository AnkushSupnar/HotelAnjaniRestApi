package com.anjani.service;

import com.anjani.entity.TableMaster;
import com.anjani.entity.TempTransaction;
import com.anjani.repository.TempTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public TempTransaction findByItemnameAndTableMaster_Id(String item,int tableMaster){
        return repository.findByItemnameAndTableMaster_Id(item,tableMaster);
    }
    public TempTransaction getByItemAndRateAndTable(String item,int tableId,Float rate){
       // System.out.println("In Service= >"+repository.findByItemAndTableMasterAndRate(item,tableMaster,rate));
        return repository.findByItemnameAndTableMaster_IdAndRate(item,tableId,rate);
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
    public List<TableMaster>getOpenTables(){
      List<TempTransaction> tempList = repository.findAll();
        Set<TableMaster>tableSet = new HashSet<>();
        for(TempTransaction temp:repository.findAll()){
            tableSet.add(temp.getTableMaster());
        }
        return new ArrayList<>(tableSet);
    }

    public List<TempTransaction>getTableOrder(int tableId){
        return repository.findByTableMaster_Id(tableId);
    }

    public int setRemovePrintQuantity(int tableMaster){
        return repository.updatePrintqtyByTableMaster(tableMaster);
    }
}
