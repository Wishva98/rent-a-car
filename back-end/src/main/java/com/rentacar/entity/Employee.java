package com.rentacar.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,unique = true,name = "nic",length = 15)
    private String nic;

    @Column(length = 200,nullable = false,unique = true)
    private String email;

    @OneToMany(mappedBy = "id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Setter(AccessLevel.NONE)
    private Set<Contact> contacts;


}
