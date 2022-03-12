package com.anjani.repository;

import com.anjani.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("select i.itemname from Item i ")
    List<String> findAllItemName();

    Optional<Item> findByItemname(String itemname);

    List<Item> findByCatid_IdOrderByItemnameAsc(Long id);

    @Query("select i.itemname from Item i where i.catid.category = ?1")
    List<String> findItemNameByCategoryName(String category);





}