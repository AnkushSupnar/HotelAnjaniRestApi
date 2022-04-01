package com.anjani.controller;

import com.anjani.entity.Bill;
import com.anjani.service.BillService;
import com.anjani.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/bill")
public class BillController {
    private final BillService service;

    @Autowired
    public BillController(BillService service) {
        this.service = service;
    }

    @GetMapping("/bybillno/{billno}")
    public ResponseEntity<Bill> getByBillno(@PathVariable("billno") Long billno){
        return new ResponseEntity<>(service.getByBillno(billno), HttpStatus.OK);
    }
    @GetMapping("/bydate/{date}")
    public ResponseEntity<List<Bill>> getByDate(@PathVariable("date") LocalDate date){
        return new ResponseEntity<>(service.getByDate(date),HttpStatus.OK);
    }
    @GetMapping("/customerunpaid/{cid}/{paid}")
    public ResponseEntity<List<Bill>>getCustomerUnpaidBills(@PathVariable("cid") Long id,@PathVariable("paid") Float paid){
        return new ResponseEntity<>(service.getCustomerUnpaidBills(id,paid),HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<Bill> saveBill(@RequestBody Bill bill){
        return new ResponseEntity<>(service.saveBill(bill),HttpStatus.OK);
    }
    @GetMapping("/bystatus/{status}")
    public ResponseEntity<List<Bill>>getByStatus(@PathVariable("status") String status){
        return new ResponseEntity<>(service.getByStatus(status),HttpStatus.OK);
    }
    @GetMapping("/bytableandstatus/{table}/{status}")
    public ResponseEntity<Bill>getByTableStatus(@PathVariable("table")Integer table,@PathVariable("status") String status){
        return new ResponseEntity<>(service.getByTableAndStatus(table,status).get(0),HttpStatus.OK);
    }
    @GetMapping("/bytablenameandstatus/{tablename}/{status}")
    public ResponseEntity<Bill>getByTableNameAndStatus(@PathVariable("tablename")String tablename,@PathVariable("status")String status){
        return new ResponseEntity<>(service.getByTableNameAndStatus(tablename,status),HttpStatus.OK);
    }
    @GetMapping("/bytableidclosedbill/{tableid}")
    public ResponseEntity<Bill>getClosedBillByTableid(@PathVariable("tableid")Integer tableid){
        return new ResponseEntity<>(service.getClosedBillByTableid(tableid).orElse(null),HttpStatus.OK);
    }
    @GetMapping("/bybilldeletetransaction/{billno}")
    public ResponseEntity<Bill>deleteBillTransaction(@PathVariable("billno")long billno){
        return new ResponseEntity<>(service.deleteBillTransactions(billno),HttpStatus.OK);
    }
}
