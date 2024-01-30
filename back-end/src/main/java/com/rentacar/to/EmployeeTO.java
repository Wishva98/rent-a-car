package com.rentacar.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeTO implements Serializable {
    private Integer id;
    private String fullName;
    private String address;
    private String nic;
    private String email;
    private Set<String> contacts;

}
