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
    @Column
    private int rentPerDay;
    @Column//(name = "image", nullable = false)
    @Lob
    private byte[] image;
    @Column
    private int millage;
    @Column(name = "`condition`")
    private String condition;
    @Column(name = "`description`")
    private String description;
    @Column(name = "availability",nullable = false)
    private Boolean availability;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(mappedBy = "vehicleSet")
    private Set<Reservation> rentSet;


    public Vehicle(int id, String plateNo, String model,int rentPerDay, byte[] image, int millage, String condition,String description, Boolean availability) {
        this.id = id;
        this.plateNo = plateNo;
        this.model = model;
        this.rentPerDay=rentPerDay;
        this.image = image;
        this.millage = millage;
        this.condition = condition;
        this.description=description;
        this.availability = availability;
    }
}

