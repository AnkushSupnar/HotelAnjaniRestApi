package com.anjani.service;

import com.anjani.entity.Bill;
import com.anjani.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {
    private TransactionRepository repository;
    @Autowired BillService billService;
    @Autowired
    public TransactionService(TransactionRepository repository){
        this.repository = repository;
    }
    public Optional<Bill> deleteByBill(long billNo){
        Bill bill = billService.getByBillno(billNo);
        repository.deleteByBill(bill);
        return Optional.ofNullable(bill);
    }
}
