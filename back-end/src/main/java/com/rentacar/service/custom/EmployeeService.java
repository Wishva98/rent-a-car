package com.rentacar.service.custom;

import com.rentacar.to.EmployeeTO;

import java.util.List;

public interface EmployeeService {
    public EmployeeTO saveEmployee(EmployeeTO employeeTO);
    void updateEmployee(EmployeeTO employeeTO);
    void deleteEmployee(Integer id);
    EmployeeTO getEmployeeDetails(Integer id);
    List<EmployeeTO> getAllEmployees();

}
