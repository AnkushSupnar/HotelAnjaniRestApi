package com.anjani.repository;

import com.anjani.entity.TableGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TableGroupRepository extends JpaRepository<TableGroup, Integer> {
    @Query("select t.groupname from TableGroup t")
    List<String> findAllGroupname();

    TableGroup findByGroupname(String groupname);



}