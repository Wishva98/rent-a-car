package com.rentacar.service.util;

import com.rentacar.entity.Customer;
import com.rentacar.entity.Rent;
import com.rentacar.repository.CustomerRepository;
import com.rentacar.repository.RentRepository;
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
@Transactional
class RentTransformerTest {

    @Autowired
    private  RentTransformer rentTransformer;

    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerTransformer customerTransformer;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void fromRentTo() {
        CustomerTO customerTO = new CustomerTO(null, "Dakshitha", "Ranawaka", "266/2", "Matara", "Sri Lanka", "981350731V");
        Customer customer = customerTransformer.fromCustomerTO(customerTO);
        customerRepository.save(customer);
        System.out.println(customer);
        customerTO = customerTransformer.toCustomerTO(customer);
        RentTO rentTO = new RentTO(null, PayMethod.BANK, new BigDecimal(1000), null, null,customerTO);
        Rent rent = rentTransformer.fromRentTo(rentTO);

         rent = rentRepository.save(rent);
        System.out.println(rent);

    }

    @Test
    void toRentTO() {
        Customer customer = new Customer(1, "Dakshitha", "Ranawaka", "266/2", "Matara", "Sri Lanka", "981350731V", null);
        Rent rent = new Rent(1, PayMethod.BANK, new BigDecimal(1000), null, null,new BigDecimal(1000),customer);
        RentTO rentTO = rentTransformer.toRentTO(rent);

        System.out.println(rentTO);
    }
}