package com.anjani.repository;

import com.anjani.entity.Bill;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
    List<Bill> findByDate(LocalDate date);

    @Query("select b from Bill b where b.customer.id = ?1 and b.paid <= ?2 order by b.date")
    List<Bill> findCustomerUnpaidBill(Long id, Float paid);

    List<Bill> findByStatus(String status);
    List<Bill> findByTable_IdAndStatus(Integer id, String status);

    Optional<Bill> findByTable_TablenameAndStatus(String tablename, String status);

    @Query("select b from Bill b where b.table.id = ?1 and b.status = 'closed'")
    Optional<Bill> getClosedBillByTableid(Integer id);

    List<Bill> findByOrderByIdDesc(Pageable pageable);









}