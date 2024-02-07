package com.rentacar.service.util;

import com.rentacar.entity.Employee;
import com.rentacar.to.EmployeeTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Set;


@Component
public class Transformer {
    private final ModelMapper modelMapper;

    public Transformer(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Employee toEmployee(EmployeeTO employeeTO){
        return modelMapper.map(employeeTO,Employee.class);
    }
    public EmployeeTO fromEmployee(Employee employee){
        return modelMapper.map(employee, EmployeeTO.class);
    }
}
