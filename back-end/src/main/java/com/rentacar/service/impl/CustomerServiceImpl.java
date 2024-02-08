package com.rentacar.service.impl;

import com.rentacar.entity.Customer;
import com.rentacar.exception.AppException;
import com.rentacar.repository.CustomerRepository;
import com.rentacar.service.CustomerService;
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
        try {
            Customer savedCustomer = customerRepository.save(customer);
            customerTO.setId(savedCustomer.getId());
            if(savedCustomer != null){
                return customerTO;
            }else {
                throw new RuntimeException("Customer Saving Incomplete");
            }
        }catch (Exception e){
            throw new AppException(500, "Could not save customer");
        }

    }

    @Override
    public CustomerTO getCustomerById(Integer customerId) {
        try{
            Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
            if(optionalCustomer.isEmpty())throw new AppException(500, "Could not find customer");
            System.out.println();
            System.out.println("This is the rent set = "+optionalCustomer.get().getRentSet());
            CustomerTO customerTO = customerTransformer.toCustomerTO(optionalCustomer.get());
            return customerTO;
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new AppException(500, "Internal Error");
        }
    }

    @Override
    public List<CustomerTO> getAllCustomers() {
        try {
            List<CustomerTO> customerTOList;
            List<Customer> customerList = customerRepository.findAll();
            customerTOList = customerList.stream().map(customer ->{
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
        if(customerRepository.existsById(customerId)){
            customerRepository.deleteById(customerId);
        }else {
            throw new AppException(500, "Customer does not exist");
        }
    }

    @Override
    public void updateCustomer(CustomerTO customerTO) {
        Optional<Customer> optCustomer = customerRepository.findById(customerTO.getId());
        if(optCustomer.isEmpty())throw new AppException(500, "Customer does not exist");
        Customer customer = optCustomer.get();//Todo :  use when considering relationships;
        customer.setFirstName(customerTO.getFirstName());
        customer.setLastName(customerTO.getLastName());
        customer.setHouse(customerTO.getHouse());
        customer.setCity(customerTO.getCity());
        customer.setCountry(customerTO.getCountry());
        customer.setDrivingLicenseNumber(customerTO.getDrivingLicenseNumber());
        customerRepository.save(customer);
    }
}
