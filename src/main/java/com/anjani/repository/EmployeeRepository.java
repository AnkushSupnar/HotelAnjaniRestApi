package com.anjani.repository;

import com.anjani.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("select e.name from Employee e where e.designation = ?1 and upper(e.status) = upper('Active')")
    List<String> findNamesByDesignation(String designation);


    @Query("select e.nickname from Employee e where e.designation = ?1 and upper(e.status) = upper('Active')")
    List<String> findNicknamesByDesignation(String designation);


    Employee findByName(String name);



}