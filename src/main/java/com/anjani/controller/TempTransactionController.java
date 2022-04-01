package com.anjani.controller;

import com.anjani.entity.TableMaster;
import com.anjani.entity.TempTransaction;
import com.anjani.service.ItemService;
import com.anjani.service.TableMasterService;
import com.anjani.service.TempTransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/byitemnameandtableid/{itemname}/{tableid}")
    public ResponseEntity<TempTransaction> getByItemAndTable(@PathVariable("itemname")String itemname,@PathVariable("tableid") Integer tableid){
        log.info("Got item {item} table {}",itemname,tableService.getById(tableid));
        return new ResponseEntity<>(service.getByItemAndTable(itemname,tableService.getById(tableid)),HttpStatus.OK);
    }
    @GetMapping("/byitemidandtableidandrate/{itemname}/{tableid}/{rate}")
    public ResponseEntity<TempTransaction> getByItemAndTable(
            @PathVariable("itemname")String itemname,
            @PathVariable("tableid") Integer tableid,
            @PathVariable("rate")Float rate){
        System.out.println(itemname+" "+tableid+" "+rate);
        //log.info("Got item {item} table {}",itemService.getById(itemid),tableService.getById(tableid));
        return new ResponseEntity<>(service.getByItemAndRateAndTable (itemname,tableService.getById(tableid),rate),HttpStatus.OK);
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

    @GetMapping("/getopentable")
    public ResponseEntity<List<TableMaster>>getOpenTable(){
        return new ResponseEntity<>(service.getOpenTable(),HttpStatus.OK);
    }
    @GetMapping("/getorder/{tableid}")
    public ResponseEntity<List<TempTransaction>>getOrder(@PathVariable("tableid") Integer tableid){
        return new ResponseEntity<>(service.getTableOrder(tableid),HttpStatus.OK);
    }
    @PutMapping("/resetPrintQuantity/{tableid}")
    public ResponseEntity<Integer>resetPrintQuantity(@PathVariable("tableid")Integer tableid)
    {
        int flag = service.setRemovePrintQuantity(tableid);
        log.info("update table {tableid} result={flag}",tableid,flag);
        return new ResponseEntity<>(flag,HttpStatus.OK);
    }

}
