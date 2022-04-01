package com.anjani.repository;

import com.anjani.entity.Item;
import com.anjani.entity.TableMaster;
import com.anjani.entity.TempTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TempTransactionRepository extends JpaRepository<TempTransaction, Long> {
    List<TempTransaction> findByTableMaster_Id(Integer id);
    TempTransaction findByItemnameAndTableMaster(String itemname, TableMaster tableMaster);

    TempTransaction findByItemnameAndTableMasterAndRate(String itemName, TableMaster tableMaster, Float rate);
    @Transactional
    List<TempTransaction> deleteByTableMaster(TableMaster tableMaster);
    @Transactional
    void deleteById(Long id);


    @Query("select DISTINCT(t.tableMaster) from TempTransaction t")
    List<TableMaster> getOpenTable();

    @Modifying
    @Query("update TempTransaction set printqty=0 where tablemasterid=:tableid")
    void setRemovePrintQuantity(@Param("tableid") int tableid);

    @org.springframework.transaction.annotation.Transactional
    @Modifying
    @Query("update TempTransaction t set t.printqty = ?1 where t.tableMaster.id = ?2")
    int updatePrintqtyByTableMaster_Id(Float printqty, Integer id);





}