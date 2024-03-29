package com.rentacar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "contact_no")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact implements SuperEntity{
    @Id
    private String contactNo;

    @JoinColumn(name = "employee_id",referencedColumnName = "id",nullable = false)
    @ManyToOne
    private Employee employee;
}
