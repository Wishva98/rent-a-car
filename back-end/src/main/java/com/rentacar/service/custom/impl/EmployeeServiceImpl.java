package com.rentacar.service.custom.impl;

import com.rentacar.entity.Contact;
import com.rentacar.entity.Employee;
import com.rentacar.exception.AppException;
import com.rentacar.repository.ContactRepository;
import com.rentacar.repository.EmployeeRepository;
import com.rentacar.service.custom.EmployeeService;
import com.rentacar.service.util.Transformer;
import com.rentacar.to.EmployeeTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ContactRepository contactRepository;
    private final Transformer transformer;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, Transformer transformer,ContactRepository contactRepository) {
        this.employeeRepository = employeeRepository;
        this.transformer = transformer;
        this.contactRepository = contactRepository;
    }

    @Override
    public EmployeeTO saveEmployee(EmployeeTO employeeTO) {
        Employee employee = transformer.toEmployee(employeeTO);
        employeeRepository.save(employee);
        for (String contact : employeeTO.getContacts()) {
            Contact contactEntity = new Contact(contact, employee);
            contactRepository.save(contactEntity);
        }
        return employeeTO;
    }

    @Override
    public void updateEmployee(EmployeeTO employeeTO) {
        employeeRepository.findById(employeeTO.getId()).orElseThrow(()->new AppException(404,"There is no Employess by this ID"));
        Employee employee = transformer.toEmployee(employeeTO);
        if (employeeTO.getContacts().isEmpty()){
            employeeRepository.save(employee);
        }else {
            for (String contact : employeeTO.getContacts()) {
                Contact contactEntity = new Contact(contact, employee);
                contactRepository.save(contactEntity);
            }
        }
    }

    @Override
    public void deleteEmployee(Integer id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new AppException(404, "There is no employee by this id"));
        employeeRepository.deleteById(id);

    }

    @Override
    public EmployeeTO getEmployeeDetails(Integer id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new AppException(404, "There is no employee by this id"));
        EmployeeTO employeeTO = transformer.fromEmployee(employee);

        return null;
    }

    @Override
    public List<EmployeeTO> getAllEmployees() {
        return null;
    }


}
