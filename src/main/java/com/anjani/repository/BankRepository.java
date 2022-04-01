package com.anjani.repository;

import com.anjani.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
    @Query("select b.name from Bank b ")
    List<String> findAllName();

    Optional<Bank> findByName(String name);

    @Transactional
    @Query("update Bank set balance=:amount where id=:id")
    Integer addBankBalance(@Param("")Long id,Float amount);
}