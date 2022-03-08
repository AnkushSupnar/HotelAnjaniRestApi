package com.anjani.repository;

import com.anjani.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
    Optional<Login> findByUsernameAndPassword(@Param("username") String username,@Param("password") String password);

    @Query("select l.username from Login l order by l.username")
    List<String> findUsernameAsc();
}