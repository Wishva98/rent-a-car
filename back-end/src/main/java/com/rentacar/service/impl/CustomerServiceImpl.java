package com.rentacar.service.impl;

import com.rentacar.repository.CustomerRepository;
import com.rentacar.service.CustomerService;
import com.rentacar.to.CustomerTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

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
