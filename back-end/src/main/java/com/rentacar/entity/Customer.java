package com.rentacar.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name",nullable = false,length = 300)
    private String fullName;
    @Column(length = 300)
    private String address;
    @Column(name = "driving_license",nullable = false,length = 20)
    private String drivingLicenseNumber;
    @Column(name = "contact_no", nullable = false, unique = true,length = 15)
    private String contactNo;
    @Column(unique = true, length = 100)
    private String email;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "customer")
    private Set<Rent> rentSet;

}
