package com.anjani.controller;

import com.anjani.entity.TableMaster;
import com.anjani.entity.TempTransaction;
import com.anjani.service.ItemService;
import com.anjani.service.TableMasterService;
import com.anjani.service.TempTransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.NullValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/temptransaction")
@Slf4j
public class TempTransactionController {
    private final TempTransactionService service;
    private final TableMasterService tableService;
    private final ItemService itemService;

    @Autowired
    public TempTransactionController(TempTransactionService service, TableMasterService tableService, ItemService itemService) {
        this.service = service;
        this.tableService = tableService;
        this.itemService = itemService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<TempTransaction>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
    @GetMapping("/bytableid/{tableid}")
    public ResponseEntity<List<TempTransaction>>getByTableId(@PathVariable("tableid") Integer tableid){
        return new ResponseEntity<>(service.getByTableId(tableid),HttpStatus.OK);
    }
    @GetMapping("/byitemidandtableid/{itemid}/{tableid}")
    public ResponseEntity<TempTransaction> getByItemAndTable(@PathVariable("itemid")Long itemid,@PathVariable("tableid") Integer tableid){
        log.info("Got item {item} table {}",itemService.getById(itemid),tableService.getById(tableid));
        return new ResponseEntity<>(service.getByItemAndTable(itemService.getById(itemid),tableService.getById(tableid)),HttpStatus.OK);
    }
    @GetMapping("/byitemidandtableidandrate/{itemid}/{tableid}/{rate}")
    public ResponseEntity<TempTransaction> getByItemAndTable(
            @PathVariable("itemid")Long itemid,
            @PathVariable("tableid") Integer tableid,
            @PathVariable("rate")Float rate){
        System.out.println(itemid+" "+tableid+" "+rate);
        log.info("Got item {item} table {}",itemService.getById(itemid),tableService.getById(tableid));
        return new ResponseEntity<>(service.getByItemAndRateAndTable (itemService.getById(itemid),tableService.getById(tableid),rate),HttpStatus.OK);
    }


    @PostMapping("/save")
    public ResponseEntity<TempTransaction> save(@RequestBody TempTransaction temp){
        return new ResponseEntity<>(service.save(temp),HttpStatus.OK);
    }


    @DeleteMapping("/deletebytable")
    public ResponseEntity<List<TempTransaction>>deleteByTableMaster(@RequestBody TableMaster table){
        return new ResponseEntity<>(service.deleteByTableMaster(table),HttpStatus.OK);
    }
    @DeleteMapping("/deletebyid/{id}")
    public void deleteById(@PathVariable("id")Long id){
        service.deleteById(id);
    }


}
