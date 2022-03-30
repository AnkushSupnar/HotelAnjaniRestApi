package com.anjani.controller;
import com.anjani.entity.Customer;
import com.anjani.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService service;
    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        return new ResponseEntity<>(service.getAllCustomer(), HttpStatus.OK);
    }
    @GetMapping("/byname/{name}")
    public ResponseEntity<Customer> getByName(@PathVariable("name") String name){
        return new ResponseEntity<>(service.getByName(name),HttpStatus.OK);
    }
    @GetMapping("/bycontact/{contact}")
    public ResponseEntity<Customer> getByContact(@PathVariable("contact") String contact){
        return new ResponseEntity<>(service.getByContact(contact),HttpStatus.OK);
    }
    @GetMapping("/bymobile/{mobile}")
    public ResponseEntity<Customer> getByMobile(@PathVariable("mobile") String mobile){
        return new ResponseEntity<>(service.getByMobile(mobile),HttpStatus.OK);
    }
    @GetMapping("/allnames")
    public ResponseEntity<List<String>>getAllNames(){
        return new ResponseEntity<>(service.getAllNames(),HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<Customer> save(@RequestBody Customer customer){
        return new ResponseEntity<>(service.save(customer),HttpStatus.OK);
    }
}
