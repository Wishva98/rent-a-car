package com.rentacar.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements SuperEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,unique = true,name = "nic",length = 15)
    private String nic;

    @Column(length = 200,nullable = false,unique = true)
    private String email;
    @Column(length = 300,nullable = false,name = "full_name")
    private String fullName;
    @Column(name = "address",nullable = false,length = 300)
    private String address;

    @OneToMany(mappedBy = "contactNo")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Setter(AccessLevel.NONE)
    private Set<Contact> contacts;


}
