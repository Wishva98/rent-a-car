package com.rentacar.service.util;

import com.rentacar.entity.Customer;
import com.rentacar.to.CustomerTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class CustomerEmployeeTransformerTest {
    @Autowired
    private CustomerTransformer customerTransformer;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void fromCustomerTO() {
    }

    @Test
    void toCustomerTO() {
//        Customer customer = new Customer(1, "Dakshitha", "Ranawaka", "266/2", "Matara", "Sri Lanka", "981350731V", null);
//        CustomerTO customerTO = customerTransformer.toCustomerTO(customer);
//        System.out.println(customerTO);
//        assertEquals(customerTO.getId(),1);
//        assertEquals(customerTO.getFirstName(), customer.getFirstName());
//        assertEquals(customerTO.getLastName(), customer.getLastName());
//        assertEquals(customerTO.getHouse(), customer.getHouse());
    }
}