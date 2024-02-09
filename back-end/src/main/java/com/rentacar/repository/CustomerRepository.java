package com.rentacar.repository;

import com.rentacar.entity.Customer;
import com.rentacar.to.CustomerTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findCustomerByContactNo(String contactNo);
}
