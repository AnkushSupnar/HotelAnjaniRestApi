package com.anjani.repository;

import com.anjani.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
    @Query("select b.name from Bank b ")
    List<String> findAllName();

    Optional<Bank> findByName(String name);


}