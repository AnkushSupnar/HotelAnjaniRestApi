package com.anjani.repository;

import com.anjani.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("select c.category from Category c")
     List<String> findAllCategoryNames();

     Category getByCategory(String category);

}