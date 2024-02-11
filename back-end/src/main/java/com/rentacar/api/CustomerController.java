package com.rentacar.api;

import com.rentacar.service.custom.CustomerService;
import com.rentacar.to.CustomerTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping( consumes = "application/json" , produces = "application/json")
    public CustomerTO createNewCustomer(@RequestBody @Validated  CustomerTO customerTO){
        return customerService.saveCustomer(customerTO);
    }

    @GetMapping(value = "/{customer_id}",produces = "application/json")
    public CustomerTO getCustomer(@PathVariable("customer_id") Integer customerId){
        return customerService.getCustomerById(customerId);
    }

    @GetMapping(produces = "application/json")
    public List<CustomerTO> getCustomerList(){
        return customerService.getAllCustomers();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{customer_id}")
    public void deleteCustomer(@PathVariable("customer_id") Integer customerId){
        customerService.deleteCustomerById(customerId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(consumes = "application/json")
    public void updateCustomer(@RequestBody @Validated CustomerTO customerTO){

    }

}
