package com.rentacar.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,columnDefinition ="ENUM('super_admin','admin','guest')")
    @Enumerated
    private String name;

    @ManyToMany
    @JoinTable(name="employee_role",
         joinColumns =@JoinColumn(name="role_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="employee_id",referencedColumnName = "id")
    )
    Set<Employee> employeeSet;

}
