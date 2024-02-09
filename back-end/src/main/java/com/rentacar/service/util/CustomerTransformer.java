package com.rentacar.service.util;

import com.rentacar.entity.Customer;
import com.rentacar.to.CustomerTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class CustomerTransformer {
    private final ModelMapper mapper;

    public CustomerTransformer(ModelMapper mapper) {
        this.mapper = mapper;
//        mapper.typeMap(CustomerTO.class, Customer.class).addMapping(customerTO->{
////            System.out.println(customerTO);
////            String contactNo = customerTO.getContactNo();
////            if(contactNo.length()==9)return "0"+contactNo;
////            if(contactNo.length()==10)return contactNo;
////            else return "0"+contactNo.substring(3);
//            return "100";
//        },(customer,o) -> customer.setContactNo((String) o));

//        mapper.typeMap(CustomerTO.class, Customer.class).addMapping(CustomerTO::getContactNo,(customer, o) -> customer.setContactNo(convertContact((String) o)));

//        mapper.typeMap(CustomerTO.class, Customer.class).setConverter(ctx->{
//            String contactNo = ctx.getSource().getContactNo();
//            ctx.getDestination().setContactNo(contactNo);
//            return ctx.getDestination();
//        });

//        mapper.addMappings(new PropertyMap<CustomerTO, Customer>() {
//            @Override
//            protected void configure() {
//                map().setContactNo(convertContact(source.getContactNo()));
//            }
//        });
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
