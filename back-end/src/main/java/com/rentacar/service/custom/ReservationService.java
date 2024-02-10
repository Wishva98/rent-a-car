package com.rentacar.service.custom;

import com.rentacar.entity.Reservation;
import com.rentacar.to.ReservationTO;


import java.util.List;

public interface ReservationService {
    ReservationTO createReservation(ReservationTO reservationTO);
    ReservationTO updateReservation(ReservationTO reservationTO);
    void deleteReservation(Integer id);
    List<Reservation> getAllReservations();
    ReservationTO getReservationById(Integer id);

}
