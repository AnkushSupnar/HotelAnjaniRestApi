package com.anjani.controller;

import com.anjani.entity.TableMaster;
import com.anjani.service.TableMasterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tablemaster")
@Slf4j
public class TableMasterController {
    private final TableMasterService service;

    @Autowired
    public TableMasterController(TableMasterService service) {
        this.service = service;
    }
    @GetMapping("/all")
    public ResponseEntity<List<TableMaster>> getAllTables(){
        log.info("getAllTables={}",service.getAllTables());
        return new ResponseEntity<>(service.getAllTables(), HttpStatus.OK);
    }
    @GetMapping("/byid/{id}")
    public ResponseEntity<TableMaster> getById(@PathVariable("id") Integer id){
        log.info("Table Master getById={}",service.getById(id));
        return new ResponseEntity<>(service.getById(id),HttpStatus.OK);
    }
    @GetMapping("/byname/{name}")
    public ResponseEntity<TableMaster>getByName(@PathVariable("name")String name){
        log.info("Table Master getByName({})=",name,service.getByName(name));
        return new ResponseEntity<>(service.getByName(name),HttpStatus.OK);
    }
    @GetMapping("/allnames")
    public ResponseEntity<List<String>> getAllNames(){
        log.info("Table Master getAllNames={}",service.getAllNames());
        return new ResponseEntity<>(service.getAllNames(),HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<TableMaster> save(@RequestBody TableMaster tableMaster){
        log.info("Table Master Save=");
        return new ResponseEntity<>(service.save(tableMaster),HttpStatus.OK);
    }
}
