package com.delhomvi.demoSecurity.repository;

import com.delhomvi.demoSecurity.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
    //@Query() si trouve pas anotation, fait une query
    List<Customer> findByEmail (String email);



}
