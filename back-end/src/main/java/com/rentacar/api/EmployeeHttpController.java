package com.rentacar.api;

import com.rentacar.service.custom.EmployeeService;
import com.rentacar.to.EmployeeTO;
import org.apiguardian.api.API;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/employee")
public class EmployeeHttpController {
    @Autowired
    private EmployeeService employeeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json",produces = "application/json")
    public EmployeeTO createNewEmployee(@RequestBody @Validated(EmployeeTO.Create.class) EmployeeTO employeeTO) {
        return employeeService.saveEmployee(employeeTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(consumes = "application/json")
    public void updateEmployee(@RequestBody @Validated(EmployeeTO.Update.class) EmployeeTO employeeTO){
        employeeService.updateEmployee(employeeTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{employee-id}")
    public void deleteEmployee(@PathVariable(value = "employee-id") Integer id){
        employeeService.deleteEmployee(id);
    }

    @GetMapping(value = "/{employee-id}")
    public EmployeeTO getEmployeeDetails(@PathVariable(value = "employee-id") Integer id){
        return employeeService.getEmployeeDetails(id);
    }

    @GetMapping
    public List<EmployeeTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }


}
