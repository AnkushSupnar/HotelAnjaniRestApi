package com.anjani.repository;

import com.anjani.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByName(String name);

    Customer findByContact(String contact);

    Customer findByMobile(String mobile);

    @Query("select c.name from Customer c")
    List<String> getAllNames();




}