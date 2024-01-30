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

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Setter(AccessLevel.NONE)
    @JoinColumn(name = "vehicle_id",referencedColumnName = "id", nullable = false)
    private Set<Vehicle> rentSet;
}
