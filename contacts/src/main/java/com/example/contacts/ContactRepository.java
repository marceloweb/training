package com.example.contacts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Long> {
    List<Contact> findByNameContainingIgnoreCase(String name);
}
