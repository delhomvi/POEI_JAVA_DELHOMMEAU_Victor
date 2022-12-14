package com.example.demosogetisecurity.repository;

import com.example.demosogetisecurity.model.Customer;

import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {


    List<Customer> findByEmail(String email);



}
