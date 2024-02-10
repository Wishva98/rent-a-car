package com.rentacar.service.util;

import com.rentacar.entity.Customer;
import com.rentacar.to.CustomerTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.spi.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerTransformer {
    private final ModelMapper mapper;

    public CustomerTransformer(ModelMapper mapper) {
        this.mapper = mapper;

    }

    private static String convertContact(String contactNo) {

        return "0"+contactNo.substring(contactNo.indexOf("7"));
//        if (contactNo != null && contactNo.length() == 9) return "0" + contactNo;
//        if (contactNo != null && contactNo.length() == 10) return contactNo;
//        if (contactNo != null && contactNo.length() == 12) return "0" + contactNo.substring(3);
//        else return contactNo;
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
