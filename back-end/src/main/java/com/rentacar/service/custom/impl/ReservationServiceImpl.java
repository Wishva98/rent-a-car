package com.rentacar.service.custom.impl;

import com.rentacar.entity.Reservation;
import com.rentacar.exception.AppException;
import com.rentacar.repository.ReservationRepository;
import com.rentacar.service.custom.ReservationService;
import com.rentacar.service.util.ReservationTransformer;
import com.rentacar.to.ReservationTO;
import com.rentacar.to.VehicleTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private ReservationTransformer reservationTransformer;
    @Override
    public ReservationTO createReservation(ReservationTO reservationTO)
    {
        if(reservationRepository.existsById(reservationTO.getId())){
            return  null;
        }else{
            reservationRepository.save(reservationTransformer.fromReservationTo(reservationTO));
            return reservationTO;
        }
    }
    @Override
    public ReservationTO updateReservation(ReservationTO reservationTO)
    {
        if(reservationRepository.existsById(reservationTO.getId())){
            reservationRepository.save(reservationTransformer.fromReservationTo(reservationTO));
            return reservationTO;
        }else{
            return null;
        }
    }
    @Override
    public void deleteReservation(Integer id){
        reservationRepository.deleteById(id);
    }
    @Override
    public List<Reservation> getAllReservations()
    {
       return reservationRepository.findAll();
    }
    @Override
    public ReservationTO getReservationById(Integer id){
        Optional<Reservation> optionalReservation=reservationRepository.findById(id);
        if(optionalReservation.isEmpty()) throw new AppException(500,"Reservation does not exist");
        Reservation reservation=optionalReservation.get();
        return  reservationTransformer.toReservationTO(reservation);
    }

}
