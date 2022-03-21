package com.anjani.controller;

import com.anjani.entity.TableGroup;
import com.anjani.repository.TableGroupRepository;
import com.anjani.service.TableGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tablegroup")
public class TableGroupController {
    private final TableGroupService service;
    @Autowired
    public TableGroupController(TableGroupService service) {
        this.service = service;
    }
    @GetMapping("/all")
    public ResponseEntity<List<TableGroup>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
    @GetMapping("/byid/{id}")
    public ResponseEntity<TableGroup> getById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(service.getById(id),HttpStatus.OK);
    }
    @GetMapping("/allnames")
    public ResponseEntity<List<String>>allGroupNames(){
        return new ResponseEntity<>(service.getAllGroupNames(),HttpStatus.OK);
    }
    @GetMapping("/byname/{name}")
    public ResponseEntity<TableGroup> getByName(@PathVariable("name") String name){
        return new ResponseEntity<>(service.getByName(name),HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<TableGroup> save(@RequestBody TableGroup group){
        return new ResponseEntity<>(service.save(group),HttpStatus.OK);
    }
}
