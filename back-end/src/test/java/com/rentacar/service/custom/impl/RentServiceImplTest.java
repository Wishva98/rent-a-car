package com.rentacar.service.custom.impl;

import com.rentacar.entity.Customer;
import com.rentacar.entity.Rent;
import com.rentacar.repository.CustomerRepository;
import com.rentacar.repository.RentRepository;
import com.rentacar.repository.ReservationRepository;
import com.rentacar.service.custom.RentService;
import com.rentacar.service.util.CustomerTransformer;
import com.rentacar.to.RentTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class RentServiceImplTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private RentService rentService;

    @Autowired
    private CustomerTransformer customerTransformer;





    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveRent() {
        Optional<Customer> customerByContactNo = customerRepository.findCustomerByContactNo("0769785581");

    }

    @Test
    void getRentById() {
    }

    @Test
    void updateRent() {
    }

    @Test
    void deleteRentById() {
    }

    @Test
    void getAllRents() {
    }

    @Test
    void getAllRentsByCustomerId() {
    }
}