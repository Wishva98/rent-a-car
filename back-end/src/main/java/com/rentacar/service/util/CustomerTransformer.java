package com.rentacar.service.util;

import com.rentacar.entity.Customer;
import com.rentacar.to.CustomerTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerTransformer {
    private final ModelMapper mapper;

    public CustomerTransformer(ModelMapper mapper) {
        this.mapper = mapper;

    }

    public Customer fromCustomerTO(CustomerTO customerTO) {
        Customer customer = mapper.map(customerTO, Customer.class);
        return customer;
    }

    public CustomerTO toCustomerTO(Customer customer) {
        CustomerTO customerTO = mapper.map(customer, CustomerTO.class);
        return customerTO;
    }
}
