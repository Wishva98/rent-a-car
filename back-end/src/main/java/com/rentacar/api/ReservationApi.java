package com.rentacar.api;

import com.rentacar.entity.Reservation;
import com.rentacar.service.custom.ReservationService;
import com.rentacar.to.ReservationTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/vi/reservation")
public class ReservationApi {
    @Autowired
    ReservationService reservationService;
    @PostMapping(consumes = "application/json")
    public ResponseEntity<ReservationTO> saveReservation(@RequestBody ReservationTO reservationTO)
    {
        try{
            ReservationTO reservation=reservationService.createReservation(reservationTO);
            if(reservation!=null){
                return new ResponseEntity<>(reservation, HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
            }
        }catch(Exception e){
            return  new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
           }
    }
    @PatchMapping(consumes = "application/json",produces = "application/json")
    public ResponseEntity<ReservationTO> updateReservation(@RequestBody ReservationTO reservationTO)
    {
        try{
           // ReservationTO reservationTo=reservationService.getReservationById(id);
            ReservationTO reservation=reservationService.updateReservation(reservationTO);
            if(reservation!=null){
                return new ResponseEntity<>(reservation, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
            }
        }catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping(value = "/{id}",produces ="application/json" )
    public ResponseEntity<?> deleteReservation(@PathVariable int id)
    {
        try{
            reservationService.deleteReservation(id);
            return new ResponseEntity<>("Reservation delete Successfully", HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("Failed to find vehicle",HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            return new ResponseEntity<>("An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public  ResponseEntity<ReservationTO> getReservation(@PathVariable int id)
    {
        try{
            ReservationTO reservationTo=reservationService.getReservationById(id);
            if(reservationTo!=null){
                return new ResponseEntity<>(reservationTo, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
            }
        }catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(produces ="application/json" )
    public  ResponseEntity<List<Reservation>> getAllReservation()
    {
        List <Reservation>reservationList=reservationService.getAllReservations();
        return  new ResponseEntity<>(reservationList,HttpStatus.OK);
    }
}
