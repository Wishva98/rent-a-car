package com.rentacar.service.util;

import com.rentacar.entity.Employee;
import com.rentacar.to.EmployeeTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeTransformerTest {
    @Autowired
    private EmployeeTransformer employeeTransformer;
    @Test
    void toEmployee() {
        EmployeeTO employeeTO = new EmployeeTO(5, "Sanath nishantha", "puththalam", "7012313V", "sanathNisha@gmail.com", Set.of("071-231231", "076-3413532"));
        Employee employee = employeeTransformer.toEmployee(employeeTO);
        System.out.println(employee);
        assertEquals(employeeTO.getId(),employee.getId());
//        assertEquals(employeeTO.getContacts(),employee.getContacts());
    }

    @Test
    void fromEmployee() {
        Employee employee = new Employee(2, "7012313V", "sanathNisha@gmail.com", "Sanath nishantha", "puththalam");
        EmployeeTO employeeTO = employeeTransformer.fromEmployee(employee);
        System.out.println(employeeTO);
        assertNull(employeeTO.getContacts());
    }
}