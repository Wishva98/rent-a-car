package com.rentacar.service.custom.impl;

import com.rentacar.service.custom.EmployeeService;
import com.rentacar.to.EmployeeTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public EmployeeTO saveEmployee() {
        return null;
    }
}
