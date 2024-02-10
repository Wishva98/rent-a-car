package com.rentacar.service.custom.impl;

import com.rentacar.entity.Contact;
import com.rentacar.entity.Employee;
import com.rentacar.repository.ContactRepository;
import com.rentacar.repository.EmployeeRepository;
import com.rentacar.service.custom.EmployeeService;
import com.rentacar.to.EmployeeTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class EmployeeServiceImplTest {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ContactRepository contactRepository;
    @Test
    void saveEmployee() {
    }

    @Test
    void updateEmployee() {
    }

    @Test
    void deleteEmployee() {
    }

    @Test
    void getEmployeeDetails() {
        Employee employee = new Employee("9843434", "sashdukjs@gmail.com", "ishvaadhikari", "298/2,Ahasgawwa,Kurunegala");
        Employee saved = employeeRepository.save(employee);
        Contact contact1 = new Contact("078-1231243", employee);
        Contact contact2 = new Contact("072-1231243", employee);
        Contact contact3 = new Contact("074-1231243", employee);
        Contact contact4 = new Contact("075-1231243", employee);
        contactRepository.saveAll(Set.of(contact1, contact2, contact3, contact4));
        System.out.println(saved);
        EmployeeTO employeeDetails = employeeService.getEmployeeDetails(saved.getId());
        System.out.println(employeeDetails);
        assertEquals(Set.of(contact1.getContactNo(),contact2.getContactNo(),contact3.getContactNo(),contact4.getContactNo()),employeeDetails.getContacts());
        assertEquals(saved.getId(),employeeDetails.getId());

    }

    @Test
    void getAllEmployees() {
    }
}