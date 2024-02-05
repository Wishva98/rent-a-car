package com.rentacar.entity;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.awt.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="vehicle")
public class Vehicle implements SuperEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "plate_no",nullable = false, unique = true)
    private String plateNo;
    @Column(name = "model", nullable = false)
    private String model;
    @Column//(name = "image", nullable = false)
    @Lob
    private byte[] image;
    @Column
    private MultipartFile imageFile;
    @Column
    private int millage;
    @Column
    private String condition;
    @Column(name = "availability",nullable = false)
    private Boolean availability;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "vehicle")
    private Set<Reservation> rentSet;
}
