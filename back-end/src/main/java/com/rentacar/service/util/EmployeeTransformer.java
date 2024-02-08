package com.rentacar.service.util;

import com.rentacar.entity.Employee;
import com.rentacar.to.EmployeeTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class EmployeeTransformer {
    private final ModelMapper modelMapper;

    public EmployeeTransformer(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Employee toEmployee(EmployeeTO employeeTO){
        return modelMapper.map(employeeTO,Employee.class);
    }
    public EmployeeTO fromEmployee(Employee employee){
        return modelMapper.map(employee, EmployeeTO.class);
    }
}
