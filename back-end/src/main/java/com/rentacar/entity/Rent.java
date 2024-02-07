package com.rentacar.entity;

import com.rentacar.util.PayMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rent")
public class Rent implements SuperEntity{
    @Id
    private int id;
    @Column(nullable = false, columnDefinition = "ENUM('VISA', 'CASH', 'BANK')")
    @Enumerated(EnumType.STRING)
    private PayMethod method;
    @Column(name = "rent_price",nullable = false)
    private BigDecimal rentPrice;
    @Column(name = "damage_compensation")
    private BigDecimal damageCompensation;
    @Column(name = "damage_details")
    private String damageDetails;
    @Column
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "id", nullable = false)
    private Customer customer;
 
}
