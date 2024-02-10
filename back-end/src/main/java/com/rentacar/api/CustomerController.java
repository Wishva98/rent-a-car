package com.rentacar.api;

import com.rentacar.service.custom.CustomerService;
import com.rentacar.to.CustomerTO;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.MultipartConfig;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;



    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping( consumes = "application/json" , produces = "application/json")
    public CustomerTO createNewCustomer(@Validated  CustomerTO customerTO){
        return customerTO;
    }
}
