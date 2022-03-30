package com.anjani.controller;

import com.anjani.entity.TempTransaction;
import com.anjani.service.TempTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/temptransaction")
public class TempTransactionController {
    private final TempTransactionService service;

    @Autowired
    public TempTransactionController(TempTransactionService service) {
        this.service = service;
    }
    @GetMapping("/all")
    public ResponseEntity<List<TempTransaction>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
    @GetMapping("/bytableid/{tableid}")
    public ResponseEntity<List<TempTransaction>>getByTableId(@PathVariable("tableid") Integer tableid){
        return new ResponseEntity<>(service.getByTableId(tableid),HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<TempTransaction> save(@RequestBody TempTransaction temp){
        return new ResponseEntity<>(service.save(temp),HttpStatus.OK);
    }

    @DeleteMapping("/deletebytableid/{tableid}")
    public ResponseEntity<Map<String,Boolean>> deleteTempTransaction(@PathVariable(value ="tableid") Integer tableid){
        Map<String,Boolean>map = new HashMap<>();
        for(TempTransaction temp:service.getByTableId(tableid)){
            service.deleteTempTransaction(temp.getTableMaster().getId());
            map.put("deleted",Boolean.TRUE);
        }
        return new ResponseEntity<>(map,HttpStatus.OK);
    }
}
