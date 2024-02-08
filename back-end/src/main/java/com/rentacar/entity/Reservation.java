package com.rentacar.entity;

import lombok.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="reservation")
public class Reservation implements SuperEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "reservation_date",nullable = false)
    private Date reservationDate;
    @Column(name = "pickup_date", nullable = false)
    private Date pickupDate;
    @Column(name="return_date",nullable=false)
    private Date returnDate;
    @Column(name="no_of_days",nullable=false)
    private int noOfDays;
    @Column
    private String cancellationDetails;

    @ManyToMany
    @JoinTable(name = "vehicle_reservation",joinColumns = @JoinColumn(name = "reservation_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "vehicle_id",referencedColumnName = "id"))
    private Set<Vehicle> vehicleSet;

    public Reservation(int id, Date reservationDate, Date pickupDate, Date returnDate, int noOfDays, String cancellationDetails) {
        this.id = id;
        this.reservationDate = reservationDate;
        this.pickupDate = pickupDate;
        this.returnDate = returnDate;
        this.noOfDays = noOfDays;
        this.cancellationDetails = cancellationDetails;
    }
}
