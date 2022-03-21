package com.anjani.repository;

import com.anjani.entity.TableMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TableMasterRepository extends JpaRepository<TableMaster, Integer> {
    @Query("select tablename from TableMaster")
    List<String>getAllTableNames();

    TableMaster findByTablename(String tablename);


}