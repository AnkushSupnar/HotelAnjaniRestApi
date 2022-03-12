package com.anjani.controller;

import com.anjani.entity.Kirana;
import com.anjani.service.KiranaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/kirana")
public class KiranaController {
    private KiranaService service;
    public KiranaController(KiranaService service)
    {
        this.service = service;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Kirana>> getAllKirana(){
        return new ResponseEntity<List<Kirana>>(service.getAllKirana(), HttpStatus.OK);
    }
    @GetMapping("/bydate/{date}")
    public ResponseEntity<List<Kirana>>getByDate(@PathVariable("date")LocalDate date){
        return new ResponseEntity<List<Kirana>>(service.getByDate(date),HttpStatus.OK);
    }
    @GetMapping("/bypartyname/{name}")
    public ResponseEntity<List<Kirana>>getByPartyName(@PathVariable("name") String party){
        return new ResponseEntity<List<Kirana>>(service.getByPartyName(party),HttpStatus.OK);
    }
    public ResponseEntity<List<Kirana>>getAllUnpaid(){
        return new ResponseEntity<List<Kirana>>(service.getAllUnpaid(),HttpStatus.OK);
    }
    @GetMapping("/byid/{id}")
    public ResponseEntity<Kirana> getById(@PathVariable("id") Long id){
        return new ResponseEntity<Kirana>(service.getById(id),HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<Kirana> save(@RequestBody Kirana kirana){
        return new ResponseEntity<Kirana>(service.save(kirana),HttpStatus.OK);
    }
}
