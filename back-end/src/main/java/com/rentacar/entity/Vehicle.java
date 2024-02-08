package com.rentacar.entity;

import lombok.*;

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
    @Column(name = "plate_no",nullable = false, unique = true,length = 12)
    private String plateNo;
    @Column(name = "model", nullable = false,length = 100)
    private String model;
    @Column//(name = "image", nullable = false)
    @Lob
    private byte[] image;
    @Column(length = 400)//(name = "image_path", nullable = false)
    private String imagePath;
    @Column(length = 10)
    private int millage;
    @Column(name = "`condition`",length = 100)
    private String condition;
    @Column(name = "availability",nullable = false)
    private Boolean availability;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(mappedBy = "vehicleSet")
    private Set<Reservation> rentSet;


    public Vehicle(int id, String plateNo, String model, byte[] image, String imagePath, int millage, String condition, Boolean availability) {
        this.id = id;
        this.plateNo = plateNo;
        this.model = model;
        this.image = image;
        this.imagePath = imagePath;
        this.millage = millage;
        this.condition = condition;
        this.availability = availability;
    }
}

