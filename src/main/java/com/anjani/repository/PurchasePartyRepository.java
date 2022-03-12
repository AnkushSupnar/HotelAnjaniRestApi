package com.anjani.repository;

import com.anjani.entity.PurchaseParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchasePartyRepository extends JpaRepository<PurchaseParty, Integer> {
    @Query("select p.name from PurchaseParty p order by p.name")
    List<String> findByNameOrderByNameAsc();

    PurchaseParty findByName(String name);




}