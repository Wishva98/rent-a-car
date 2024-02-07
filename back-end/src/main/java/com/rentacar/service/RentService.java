package com.rentacar.service;

import com.rentacar.to.RentTO;

import java.util.List;

public interface RentService {
    RentTO saveRent(RentTO rentTO);
    RentTO getRentById(Integer rentId);
    void updateRent(RentTO rentTO);
    void deleteRentById(Integer rentId);
    List<RentTO> getAllRents();
    List<RentTO> getAllRentsByCustomerId(Integer customerId);

}
