package com.rentacar.service.custom.impl;

import com.rentacar.entity.Customer;
import com.rentacar.entity.Rent;
import com.rentacar.exception.AppException;
import com.rentacar.repository.CustomerRepository;
import com.rentacar.repository.RentRepository;
import com.rentacar.service.custom.RentService;
import com.rentacar.service.util.RentTransformer;
import com.rentacar.to.RentTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
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
        try {
            rentRepository.save(rent);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new AppException(500, "could not save rent");
        }
        RentTO savedRentTO = rentTransformer.toRentTO(rent);
        return savedRentTO;
    }

    @Override
    public RentTO getRentById(Integer rentId) {
        Optional<Rent> optRent = rentRepository.findById(rentId);
        if(optRent.isEmpty())throw new AppException(500,"Rent does not exist");
        Rent rent = optRent.get();
        RentTO rentTO = rentTransformer.toRentTO(rent);
        return rentTO;
    }

    @Override
    public void updateRent(RentTO rentTO) {
//        Optional<Rent> optRent = rentRepository.findById(rentTO.getId());
        if(!rentRepository.existsById(rentTO.getId()))throw new AppException(500,"Rent does not exist");
        if(!customerRepository.existsById(rentTO.getCustomer().getId()))throw new AppException(500,"Customer associated with rent does not exist");
        Rent rent = rentTransformer.fromRentTo(rentTO);
        Rent newRent = rentRepository.save(rent);
    }

    @Override
    public void deleteRentById(Integer rentId) {
        if(!rentRepository.existsById(rentId))throw new AppException(500,"Rent does not exist");
        rentRepository.deleteById(rentId);
    }

    @Override
    public List<RentTO> getAllRents() {
        List<Rent> rentList = rentRepository.findAll();
        List<RentTO> rentTOList = rentList.stream().map(rent -> {
            return rentTransformer.toRentTO(rent);
        }).collect(Collectors.toList());
        return rentTOList;
    }

    @Override
    public List<RentTO> getAllRentsByCustomerId(Integer customerId) {
        Optional<Customer> optCustomer = customerRepository.findById(customerId);
        if(optCustomer.isEmpty()) throw new AppException(500,"Customer does not exist");
        Set<Rent> rentSet = optCustomer.get().getRentSet();
        List<RentTO> rentTOList = rentSet.stream().map(rent -> {
            return rentTransformer.toRentTO(rent);
        }).collect(Collectors.toList());
        return rentTOList;
    }
}
