package com.rentacar.service.impl;

import com.rentacar.repository.CustomerRepository;
import com.rentacar.service.CustomerService;
import com.rentacar.service.util.Transformer;
import com.rentacar.to.CustomerTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

//    @Autowired
    private CustomerRepository customerRepository;
//    @Autowired
    private Transformer transformer;

    public CustomerServiceImpl(CustomerRepository customerRepository, Transformer transformer) {
        this.customerRepository = customerRepository;
        this.transformer = transformer;
    }

    @Override
    public CustomerTO saveCustomer(CustomerTO customerTO) {

        return null;
    }

    @Override
    public CustomerTO getCustomerById(Integer customerId) {
        return null;
    }

    @Override
    public List<CustomerTO> getAllCustomers() {
        return null;
    }

    @Override
    public boolean deleteCustomerById(Integer customerId) {
        return false;
    }

    @Override
    public void updateCustomer(CustomerTO customerTO) {

    }
}
