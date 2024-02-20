package com.rentacar.repository;

import com.rentacar.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query("SELECT e from Employee e WHERE e.email=: email")
    public Employee getEmployeeByEmail(@Param("email") String email);
}
