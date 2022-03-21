package com.anjani.service;

import com.anjani.entity.TableGroup;
import com.anjani.repository.TableGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TableGroupService {
    private TableGroupRepository repository;
    @Autowired
    public TableGroupService(TableGroupRepository repository){
        this.repository = repository;
    }
    public List<TableGroup>getAll(){
        return repository.findAll();
    }
    public TableGroup getById(Integer id){
        return repository.findById(id).orElse(null);
    }
    public List<String>getAllGroupNames(){
        return repository.findAllGroupname();
    }
    public TableGroup getByName(String name){
        return repository.findByGroupname(name);
    }
    public TableGroup save(TableGroup group){
        return repository.save(group);
    }

}
