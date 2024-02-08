package com.rentacar.service.impl;

import com.rentacar.entity.Rent;
import com.rentacar.repository.RentRepository;
import com.rentacar.service.CustomerService;
import com.rentacar.service.RentService;
import com.rentacar.service.util.RentTransformer;
import com.rentacar.to.CustomerTO;
import com.rentacar.to.RentTO;
import com.rentacar.util.PayMethod;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
//@Transactional
class CustomerServiceImplTest {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private RentRepository rentRepository;

   @Autowired
   private RentTransformer rentTransformer;

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

    @Test
    void testSaveCustomer() {
    }

    @Test
    void getCustomerById() {
//        CustomerTO customerTO = new CustomerTO(null, "Dakshitha 2", "Ranawaka", "266/2", "Matara", "Sri Lanka", "981350731V");
//        CustomerTO savedCustomerTO = customerService.saveCustomer(customerTO);
//        RentTO rentTO = new RentTO(null, PayMethod.BANK, new BigDecimal(1000), null, null,customerTO);
//        Rent rent = rentTransformer.fromRentTo(rentTO);
//        rent = rentRepository.save(rent);

        CustomerTO customerById = customerService.getCustomerById(7);

    }

    @Test
    void getAllCustomers() {
    }

    @Test
    void deleteCustomerById() {
    }

    @Test
    void updateCustomer() {
    }
}