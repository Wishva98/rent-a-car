package com.rentacar.api;

import com.rentacar.entity.Vehicle;
import com.rentacar.service.custom.VehicleService;
import com.rentacar.to.ReservationTO;
import com.rentacar.to.VehicleTO;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/vi/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;
    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<VehicleTO> saveVehicle( @RequestPart("vehicleTo")  VehicleTO vehicleTo,
                                                   @RequestPart("imageFile") MultipartFile imageFile)
    {
        try{
            VehicleTO vehicle=vehicleService.createVehicle(vehicleTo,imageFile);
            if(vehicle!=null){
                return new ResponseEntity<>(vehicle,HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PatchMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> updateVehicle( @RequestPart("vehicleTo") VehicleTO vehicleTo,
                                             @RequestPart("imageFile") MultipartFile imageFile)
    {
        try{
           // VehicleTO vehicleTO=vehicleService.getVehicleById(id);
            VehicleTO vehicle=vehicleService.updateVehicle(vehicleTo,imageFile);
            if(vehicle!=null){
                return new ResponseEntity<>(vehicleTo, HttpStatus.OK);
            }else{
                return new  ResponseEntity<>(vehicleTo,HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value ="/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Integer id)
    {
        try{
            vehicleService.deleteVehicle(id);
            return new ResponseEntity<>("Vehicle delete Successfully", HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("Failed to find vehicle",HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            return new ResponseEntity<>("An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/{id}")
    public  ResponseEntity<VehicleTO> getVehicle(@PathVariable int id)
    {
        try{
             VehicleTO vehicleTO=vehicleService.getVehicleById(id);
            if(vehicleTO!=null){
                return new ResponseEntity<>(vehicleTO, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
            }
        }catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles()
    {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        return ResponseEntity.ok(vehicles);
    }
    @GetMapping(value ="/{model}")
    public ResponseEntity<List<Vehicle>> getVehicleByModel(@PathVariable String model)
    {
        List<Vehicle> vehicles = vehicleService.searchByModel(model);
        return ResponseEntity.ok(vehicles);
    }
    @GetMapping(value ="/{millage}")
    public ResponseEntity<List<Vehicle>> getVehicleByMillage(@PathVariable Integer millage)
    {
        List<Vehicle> vehicles = vehicleService.searchByMillage(millage);
        return ResponseEntity.ok(vehicles);
    }
}
