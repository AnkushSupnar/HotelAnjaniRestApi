package com.anjani.controller;

import com.anjani.entity.Item;
import com.anjani.entity.PurchaseParty;
import com.anjani.service.PurchasePartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchaseparty")
public class PurchasePartyController {

    private PurchasePartyService service;
    @Autowired
    public PurchasePartyController(PurchasePartyService service){
        this.service = service;
    }
    @GetMapping("/all")
    public ResponseEntity<List<PurchaseParty>>getAllPurchaseParty(){
        return new ResponseEntity<List<PurchaseParty>>(service.getAllPurchaseParty(), HttpStatus.OK);
    }
    @GetMapping("/allname")
    public ResponseEntity<List<String>>getAllPartyNames(){
        return new ResponseEntity<List<String>>(service.getAllPartyNames(),HttpStatus.OK);
    }
    @GetMapping("/byname/{name}")
    public ResponseEntity<PurchaseParty>getByName(@PathVariable("name")String name){
        return new ResponseEntity<PurchaseParty>(service.getByName(name),HttpStatus.OK);
    }
    @GetMapping("/byid/{id}")
    public ResponseEntity<PurchaseParty>getById(@PathVariable("id")Integer id){
        return new ResponseEntity<PurchaseParty>(service.getById(id),HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<PurchaseParty>saveItem(@RequestBody PurchaseParty party){
        return new ResponseEntity<PurchaseParty>(service.save(party),HttpStatus.OK);
    }

}
