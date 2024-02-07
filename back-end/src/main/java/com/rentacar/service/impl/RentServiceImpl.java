package com.rentacar.service.impl;

import com.rentacar.entity.Rent;
import com.rentacar.exception.AppException;
import com.rentacar.repository.CustomerRepository;
import com.rentacar.repository.RentRepository;
import com.rentacar.service.RentService;
import com.rentacar.service.util.RentTransformer;
import com.rentacar.to.RentTO;

import java.util.List;

public class RentServiceImpl implements RentService{

    private final RentTransformer rentTransformer;
    private final CustomerRepository customerRepository;
    private final RentRepository rentRepository;

    public RentServiceImpl(RentTransformer rentTransformer, CustomerRepository customerRepository, RentRepository rentRepository) {
        this.rentTransformer = rentTransformer;
        this.customerRepository = customerRepository;
        this.rentRepository = rentRepository;
    }

    @Override
    public RentTO saveRent(RentTO rentTO) {
        if(!customerRepository.existsById(rentTO.getCustomer().getId()))throw new AppException(500, "Invalid customer");
        if(rentTO.getId() != null)throw new AppException(500,"Rent id has to be null");
        //todo : check for reservation details
        Rent rent = rentTransformer.fromRentTo(rentTO);
        rentRepository.save(rent);

        return null;
    }

    @Override
    public RentTO getRentById(Integer rentId) {
        return null;
    }

    @Override
    public void updateRent(RentTO rentTO) {

    }

    @Override
    public void deleteRentById(Integer rentId) {

    }

    @Override
    public List<RentTO> getAllRents() {
        return null;
    }

    @Override
    public List<RentTO> getAllRentsByCustomerId(Integer customerId) {
        return null;
    }
}
