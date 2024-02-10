package com.rentacar.service.util;

import com.rentacar.entity.Rent;
import com.rentacar.to.RentTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RentTransformer {
    private final ModelMapper mapper;

//   rentTo =>  Integer id, PayMethod payMethod, BigDecimal rentPrice, BigDecimal damageCompensation, CustomerTO customer

    public RentTransformer(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Rent fromRentTo(RentTO rentTO){
        Rent rent = mapper.map(rentTO, Rent.class);
        return rent;
    }

    public RentTO toRentTO(Rent rent){
        RentTO rentTO = mapper.map(rent, RentTO.class);
        return rentTO;
    }
}
