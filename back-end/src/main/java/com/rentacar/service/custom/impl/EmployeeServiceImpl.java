package com.rentacar.service.custom.impl;

import com.rentacar.entity.Contact;
import com.rentacar.entity.Employee;
import com.rentacar.exception.AppException;
import com.rentacar.repository.ContactRepository;
import com.rentacar.repository.EmployeeRepository;
import com.rentacar.service.custom.EmployeeService;
import com.rentacar.service.util.EmployeeTransformer;
import com.rentacar.to.EmployeeTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ContactRepository contactRepository;
    private final EmployeeTransformer employeeTransformer;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeTransformer employeeTransformer, ContactRepository contactRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeTransformer = employeeTransformer;
        this.contactRepository = contactRepository;
    }

    @Override
    public EmployeeTO saveEmployee(EmployeeTO employeeTO) {
        Employee employee = employeeTransformer.toEmployee(employeeTO);
        employeeRepository.save(employee);
        for (String contact : employeeTO.getContacts()) {
            Contact contactEntity = new Contact(contact, employee);
            contactRepository.save(contactEntity);
        }
        return employeeTO;
    }

    @Override
    public void updateEmployee(EmployeeTO employeeTO) {
        employeeRepository.findById(employeeTO.getId()).orElseThrow(()->new AppException(404,"There is no Employees by this ID"));
        Employee employee = employeeTransformer.toEmployee(employeeTO);
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
        employeeRepository.findById(id).orElseThrow(() -> new AppException(404, "There is no employee by this id"));
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeTO getEmployeeDetails(Integer id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new AppException(404, "There is no employee by this id"));
        return addContacts(employee);
    }

    @Override
    public List<EmployeeTO> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();

        return employeeList.stream().map(this::addContacts).collect(Collectors.toList());
    }

    private EmployeeTO addContacts(Employee employee){
        Set<Contact> contactByEmployee = contactRepository.findContactByEmployee(employee);
        EmployeeTO employeeTO = employeeTransformer.fromEmployee(employee);
        if (!contactByEmployee.isEmpty()){
            HashSet<String> contactSet = new HashSet<>();
            for (Contact contact : contactByEmployee) {
                contactSet.add(contact.getContactNo());
            }
            employeeTO.setContacts(contactSet);
            return employeeTO;
        }else return employeeTO;

    }


}
