package com.rentacar.service.custom.impl;

import com.rentacar.to.ReservationTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ReservationServiceImplTest {

    @Autowired
    ReservationTO reservationTO;
    @Autowired
    ReservationServiceImpl reservationService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createReservation() throws ParseException {
        ReservationTO reservationTO = new ReservationTO();
        reservationTO.setId(1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date reservationDate = sdf.parse("2024-02-15");
        reservationTO.setReservationDate(reservationDate);
        Date pickupDate = sdf.parse("2024-02-18");
        reservationTO.setPickupDate(pickupDate);
        Date returnDate = sdf.parse("2024-02-20");
        reservationTO.setReturnDate(returnDate);
        reservationTO.setNoOfDays(5);
        reservationTO.setCancellationDetails("Cancellation details");
        reservationTO.setReservationStatus(true);
        ReservationTO savedReservation = reservationService.createReservation(reservationTO);
        assertNotNull(savedReservation);
        assertEquals(reservationTO.getId(), savedReservation.getId());
    }

    @Test
    void updateReservation() {
    }

    @Test
    void deleteReservation() {
    }

    @Test
    void getAllReservations() {
    }

    @Test
    void getReservationById() {
    }
}