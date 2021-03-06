package com.anjani.repository;

import com.anjani.entity.TableMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TableMasterRepository extends JpaRepository<TableMaster, Integer> {
    @Query("select tablename from TableMaster")
    List<String>getAllTableNames();

    TableMaster findByTablename(String tablename);

    Optional<TableMaster> findByTablenameAndTableGroup_Groupname(String tablename, String groupname);

    List<TableMaster> findByTableGroup_GroupnameOrderByTablenameAsc(String groupname);

    List<TableMaster> findByTableGroup_GroupnameOrderByIdAsc(String groupname);




    //TableMaster findByTablenameAndTableGroup_Groupname(String tablename, String groupname);




}