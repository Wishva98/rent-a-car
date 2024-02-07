package com.rentacar.service.impl;

import com.rentacar.service.CustomerService;
import com.rentacar.to.CustomerTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class CustomerServiceImplTest {

    @Autowired
    private CustomerService customerService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveCustomer() {
        CustomerTO customerTO = new CustomerTO(null, "Dakshitha 2", "Ranawaka", "266/2", "Matara", "Sri Lanka", "981350731V");
        CustomerTO savedCustomerTO = customerService.saveCustomer(customerTO);
        System.out.println(savedCustomerTO);
    }
}