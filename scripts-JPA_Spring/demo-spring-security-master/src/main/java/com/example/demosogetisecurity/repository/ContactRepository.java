package com.example.demosogetisecurity.repository;

import com.example.demosogetisecurity.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {






}
