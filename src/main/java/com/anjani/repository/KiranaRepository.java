package com.anjani.repository;

import com.anjani.entity.Kirana;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface KiranaRepository extends JpaRepository<Kirana, Long> {
    //@Query("select k from Kirana k where k.date = :date")
    //List<Kirana> findByDate(@Param("date") LocalDate date);
    List<Kirana> findByDate( LocalDate date);

    List<Kirana> findByParty_NameOrderByDateAsc(String name);

    @Query("select k from Kirana k where k.paid <= 0")
    List<Kirana> findUnPaid();






}