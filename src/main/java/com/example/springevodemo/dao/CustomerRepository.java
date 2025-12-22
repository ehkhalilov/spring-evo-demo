package com.example.springevodemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

    @Query(value = "select * from customers where name = ? and birthdate = ?", nativeQuery = true)
    Optional<CustomerEntity> test(String name, LocalDate birthdate);
}
