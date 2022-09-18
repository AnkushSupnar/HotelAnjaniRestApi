package com.anjani.repository;

import com.anjani.entity.Item;
import com.anjani.entity.TableMaster;
import com.anjani.entity.TempTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TempTransactionRepository extends JpaRepository<TempTransaction, Long> {
    List<TempTransaction> findByTableMaster_Id(Integer id);

    //long deleteByTableMaster_Id(Integer id);

  //  TempTransaction findByItemAndTableMaster(Item item, TableMaster tableMaster);

    TempTransaction findByItemnameAndTableMaster_Id(String itemname, Integer id);

    TempTransaction findByItemnameAndTableMaster_IdAndRate(String itemname, Integer id, Float rate);

  //  TempTransaction findByItemAndTableMasterAndRate(Item item, TableMaster tableMaster, Float rate);

    @Transactional
    List<TempTransaction> deleteByTableMaster(TableMaster tableMaster);






    @Transactional
    void deleteById(Long id);

    @org.springframework.transaction.annotation.Transactional
    @Modifying
    @Query("update TempTransaction t set t.printqty = 0 where t.tableMaster.id = ?1")
    int updatePrintqtyByTableMaster(int tableMaster);





}