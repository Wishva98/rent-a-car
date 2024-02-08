package com.rentacar.repository;

import com.rentacar.entity.Contact;
import com.rentacar.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface ContactRepository extends JpaRepository<Contact, String> {
    Set<Contact> findContactByEmployee(Employee employee);
}
