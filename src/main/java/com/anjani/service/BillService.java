package com.anjani.service;

import com.anjani.entity.Bill;
import com.anjani.entity.Transaction;
import com.anjani.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BillService {
    private final BillRepository repository;

    @Autowired
    public BillService(BillRepository repository) {
        this.repository = repository;
    }
    public Bill getByBillno(Long billno){
        return repository.findById(billno).orElse(null);
    }
    public List<Bill> getByDate(LocalDate date){
        return repository.findByDate(date);
    }
    public List<Bill>getCustomerUnpaidBills(Long id, Float paid){
        return repository.findCustomerUnpaidBill(id,paid);
    }
    public Bill saveBill(Bill bill){
        return repository.save(bill);
    }
    public List<Bill>getByStatus(String status){
        return repository.findByStatus(status);
    }
    public List<Bill>getByTableAndStatus(Integer table,String status){
        return repository.findByTable_IdAndStatus(table,status);
    }
    public Bill getByTableNameAndStatus(String tablename,String status){
        return repository.findByTable_TablenameAndStatus(tablename,status).orElse(new Bill());
    }
    public Optional<Bill>getClosedBillByTableid(Integer tableid){
        return repository.getClosedBillByTableid(tableid);
    }
    public Bill deleteBillTransactions(Long billno){
        Bill bill = getByBillno(billno);
        bill.setTransactions(new ArrayList<Transaction>());
        saveBill(bill);
        return bill;
    }


}
