package com.anjani.controller;

import com.anjani.entity.Kirana;
import com.anjani.service.KiranaService;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import org.apache.tomcat.jni.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Slf4j
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
    public ResponseEntity<List<Kirana>>getByDateProvided(@PathVariable("date")String date){
       // System.out.println("======"+date);
        return new ResponseEntity<List<Kirana>>(service.getByDate(LocalDate.parse(date)),HttpStatus.OK);

    }
//    @GetMapping("/bydate/{date}")
//    public ResponseEntity<List<Kirana>>getByDate(@PathVariable("date")LocalDate date){
//             //@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
//        return new ResponseEntity<List<Kirana>>(service.getByDate(date),HttpStatus.OK);
//    }
    @GetMapping("/bypartyname/{name}")
    public ResponseEntity<List<Kirana>>getByPartyName(@PathVariable("name") String party){
        return new ResponseEntity<List<Kirana>>(service.getByPartyName(party),HttpStatus.OK);
    }
    @GetMapping("/unpaid")
    public ResponseEntity<List<Kirana>>getAllUnpaid(){
        return new ResponseEntity<List<Kirana>>(service.getAllUnpaid(),HttpStatus.OK);
    }
    @GetMapping("/byid/{id}")
    public ResponseEntity<Kirana> getById(@PathVariable("id") Long id){
        log.info("calling by id method");
        log.info("Kirana Response={}",service.getById(id));
        return new ResponseEntity<Kirana>(service.getById(id),HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<Kirana> save(@RequestBody Kirana kirana){
       // System.out.println(kirana);
       // return new ResponseEntity<>(kirana,HttpStatus.OK);
        return new ResponseEntity<Kirana>(service.save(kirana),HttpStatus.OK);
    }
}
