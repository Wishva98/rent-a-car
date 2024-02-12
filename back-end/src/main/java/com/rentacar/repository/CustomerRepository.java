package com.rentacar.repository;

import com.rentacar.entity.Customer;
import com.rentacar.to.CustomerTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findCustomerByContactNo(String contactNo);
    Optional<Customer> findCustomerByDrivingLicenseNumber(String drivingLicenseNumber);
    Optional<Customer> findCustomerByEmail(String email);
}
