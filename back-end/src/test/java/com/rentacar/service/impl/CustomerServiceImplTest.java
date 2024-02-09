package com.rentacar.service.impl;

import com.rentacar.entity.Customer;
import com.rentacar.repository.CustomerRepository;
import com.rentacar.repository.RentRepository;
import com.rentacar.service.custom.CustomerService;
import com.rentacar.service.util.RentTransformer;
import com.rentacar.to.CustomerTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
//@Transactional
class CustomerServiceImplTest {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private RentRepository rentRepository;

   @Autowired
   private RentTransformer rentTransformer;

   @Autowired
   private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveCustomer() {
        CustomerTO customerTO = new CustomerTO(null, "Dakshitha 2", "Matara", "981350731V","769785581","hasundra");
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

    @Test
    void getCustomerByContact(){
        Customer customer = customerRepository.findCustomerByContactNo("0769785581");
        System.out.println(customer.getContactNo());
        assertEquals(customer.getFullName(), "Dakshitha 2");

    }
}