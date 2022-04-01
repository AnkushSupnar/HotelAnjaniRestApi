package com.anjani.controller;

import com.anjani.entity.Bank;
import com.anjani.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {
    private BankService service;
    @Autowired
    public BankController(BankService service){
        this.service = service;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Bank>> getAllBank(){
        return new ResponseEntity<List<Bank>>(service.getAllBank(), HttpStatus.OK);
    }
    @GetMapping("/allname")
    public ResponseEntity<List<String>>getAllBankName(){
        return new ResponseEntity<List<String>>(service.getAllBankName(),HttpStatus.OK);
    }
    @GetMapping("/byname/{name}")
    public ResponseEntity<Bank> getByName(@PathVariable("name") String name){
        return new ResponseEntity<Bank>(service.getByName(name),HttpStatus.OK);
    }
    @GetMapping("/byid/{id}")
    public ResponseEntity<Bank> getById(@PathVariable("id") Long id){
        return new ResponseEntity<Bank>(service.getById(id),HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<Bank> save(@RequestBody Bank bank){
        return new ResponseEntity<Bank>(service.save(bank),HttpStatus.OK);
    }
    @PutMapping("/addbalance/{id}/{balance}")
    public ResponseEntity<Integer>addBankBalance(@PathVariable("id")Long id,@PathVariable("balance")Float balance){
        return new ResponseEntity<>(service.addBankBalance(id,balance),HttpStatus.OK);
    }
}
