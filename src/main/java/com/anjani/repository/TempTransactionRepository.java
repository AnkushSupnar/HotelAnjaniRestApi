package com.anjani.repository;

import com.anjani.entity.TempTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TempTransactionRepository extends JpaRepository<TempTransaction, Long> {
    List<TempTransaction> findByTableMaster_Id(Integer id);

    long deleteByTableMaster_Id(Integer id);




}