package com.rentacar.service.custom.impl;

import com.rentacar.entity.Customer;
import com.rentacar.exception.AppException;
import com.rentacar.repository.CustomerRepository;
import com.rentacar.service.custom.CustomerService;
import com.rentacar.service.util.CustomerTransformer;
import com.rentacar.to.CustomerTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    //    @Autowired
    private CustomerRepository customerRepository;
    //    @Autowired
    private CustomerTransformer customerTransformer;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerTransformer customerTransformer) {
        this.customerRepository = customerRepository;
        this.customerTransformer = customerTransformer;
    }

    @Override
    public CustomerTO saveCustomer(CustomerTO customerTO) {
        Customer customer = customerTransformer.fromCustomerTO(customerTO);

        //BY contact Number
        Optional<Customer> existingCustomer = customerRepository.findCustomerByContactNo(customer.getContactNo());
        if (existingCustomer.isPresent() && existingCustomer.get().getDrivingLicenseNumber().equals(customer.getDrivingLicenseNumber()) && existingCustomer.get().getEmail().equals(customer.getEmail()))
            throw new AppException(500, "Customer already registered");
        if (!existingCustomer.isEmpty()) throw new AppException(500, "Contact number already registered");

        //By Driving License Number
        existingCustomer = customerRepository.findCustomerByDrivingLicenseNumber(customer.getDrivingLicenseNumber());
        if (!existingCustomer.isEmpty()) throw new AppException(500, "Driving license number already registered");

        //By email
        existingCustomer = customerRepository.findCustomerByEmail(customer.getEmail());
        if (!existingCustomer.isEmpty()) throw new AppException(500, "Email address already registered");

        Customer savedCustomer;
        try {
            savedCustomer = customerRepository.save(customer);
        } catch (Exception e) {
            throw new AppException(500, "Could not save customer");
        }

        if (savedCustomer != null) {
            customerTO.setId(savedCustomer.getId());
            return customerTO;
        } else {
            throw new RuntimeException("Customer Saving Incomplete");
        }

    }

    @Override
    public CustomerTO getCustomerById(Integer customerId) {
            Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
            if (optionalCustomer.isEmpty()) throw new AppException(500, "Could not find customer");
            CustomerTO customerTO = customerTransformer.toCustomerTO(optionalCustomer.get());
            return customerTO;
    }

    @Override
    public List<CustomerTO> getAllCustomers() {
        try {
            List<CustomerTO> customerTOList;
            List<Customer> customerList = customerRepository.findAll();
            customerTOList = customerList.stream().map(customer -> {
                CustomerTO customerTO = customerTransformer.toCustomerTO(customer);
                return customerTO;
            }).collect(Collectors.toList());
            return customerTOList;
        } catch (Exception e) {
            throw new AppException(500, "Failed to fetch customers");
        }
    }

    @Override
    public void deleteCustomerById(Integer customerId) {
        if (customerRepository.existsById(customerId)) {
            customerRepository.deleteById(customerId);
        } else {
            throw new AppException(500, "Customer does not exist");
        }
    }

    @Override
    public void updateCustomer(CustomerTO customerTO) {
        Optional<Customer> optCustomer = customerRepository.findById(customerTO.getId());
        if (optCustomer.isEmpty()) throw new AppException(500, "Customer does not exist");
        Customer customer = optCustomer.get();//Todo :  use when considering relationships;
//        customer.setFirstName(customerTO.getFirstName());
//        customer.setLastName(customerTO.getLastName());
//        customer.setHouse(customerTO.getHouse());
//        customer.setCity(customerTO.getCity());
//        customer.setCountry(customerTO.getCountry());
        customer.setDrivingLicenseNumber(customerTO.getDrivingLicenseNumber());
        customerRepository.save(customer);
    }
}
