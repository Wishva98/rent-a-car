package com.rentacar.service;

import com.rentacar.to.CustomerTO;

import java.util.List;

public interface CustomerService {
    CustomerTO saveCustomer(CustomerTO customerTO);
    CustomerTO getCustomerById(Integer customerId);
    List<CustomerTO> getAllCustomers();
    boolean deleteCustomerById(Integer customerId);
    void updateCustomer(CustomerTO customerTO);

}
