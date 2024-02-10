package com.rentacar.service.util;

import com.rentacar.entity.Reservation;
import com.rentacar.entity.Vehicle;
import com.rentacar.to.ReservationTO;
import com.rentacar.to.VehicleTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ReservationTransformer {
    private final ModelMapper mapper;
    public ReservationTransformer(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Reservation fromReservationTo(ReservationTO reservationTO){
        Reservation reservation = mapper.map(reservationTO, Reservation.class);
        return reservation;
    }

    public ReservationTO toReservationTO(Reservation reservation){
        ReservationTO reservationTO = mapper.map(reservation, ReservationTO.class);
        return reservationTO;
    }
}
