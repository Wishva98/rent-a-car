package com.rentacar.api;

import com.rentacar.entity.Rent;
import com.rentacar.service.custom.RentService;
import com.rentacar.to.RentTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/rents")
public class RentController {
    @Autowired
    private RentService rentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    public RentTO createRent(@RequestBody @Validated RentTO rentTO){
        rentService.saveRent(rentTO);
        return null;
    }

    @GetMapping(value = "/{rent_id}", produces = "application/json")
    public RentTO getRent(@PathVariable("rent_id") Integer rentId){
        RentTO rentTO = rentService.getRentById(rentId);
        return rentTO;
    }

    @GetMapping(produces = "application/json")
    public List<RentTO> getRents(){
        return rentService.getAllRents();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{rent_id}")
    public void deleteRent(@PathVariable Integer rentId){
        rentService.deleteRentById(rentId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(consumes = "application/json")
    public void updateRent(@RequestBody @Validated RentTO rentTO){
        rentService.updateRent(rentTO);
    }


}
