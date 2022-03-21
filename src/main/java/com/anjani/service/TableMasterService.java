package com.anjani.service;

import com.anjani.entity.TableMaster;
import com.anjani.repository.TableMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableMasterService {
    private final TableMasterRepository repository;

    @Autowired
    public TableMasterService(TableMasterRepository repository) {
        this.repository = repository;
    }
    public List<TableMaster> getAllTables(){
        return repository.findAll();
    }
    public TableMaster getById(Integer id){
        return repository.findById(id).orElse(null);
    }
    public TableMaster getByName(String name){
        return repository.findByTablename(name);
    }
    public List<String> getAllNames(){
        return repository.getAllTableNames();
    }
    public TableMaster save(TableMaster tableMaster){
        return repository.save(tableMaster);
    }

}
