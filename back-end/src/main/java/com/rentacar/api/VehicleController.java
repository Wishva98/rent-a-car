package com.rentacar.api;

import com.rentacar.entity.Vehicle;
import com.rentacar.service.custom.VehicleService;
import com.rentacar.to.VehicleTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @PostMapping(value = "/saveVehicle")
    public ResponseEntity<VehicleTO> saveVehicle(@RequestBody VehicleTO vehicleTO,@RequestParam("imageFile") MultipartFile imageFile)
    {
        try{
            VehicleTO vehicle=vehicleService.createVehicle(vehicleTO,imageFile);
            if(vehicle!=null){
                return new ResponseEntity<>(vehicleTO,HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>(vehicleTO,HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping(value ="/updateVehicle/{id}")
    public ResponseEntity<?> updateVehicle(@PathVariable Integer id,@RequestParam("imageFile") MultipartFile imageFile)
    {
        try{
            VehicleTO vehicleTO=vehicleService.getVehicleById(id);
            VehicleTO vehicle=vehicleService.updateVehicle(vehicleTO,imageFile);
            if(vehicle!=null){
                return new ResponseEntity<>(vehicleTO, HttpStatus.OK);
            }else{
                return new  ResponseEntity<>(vehicleTO,HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value ="/deleteVehicle/{id}")
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

    @GetMapping(value ="/getAllVehicle/")
    public ResponseEntity<List<Vehicle>> getAllVehicles()
    {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        return ResponseEntity.ok(vehicles);
    }
    @GetMapping(value ="/searchByModel/{model}")
    public ResponseEntity<List<Vehicle>> getVehicleByModel(@PathVariable String model)
    {
        List<Vehicle> vehicles = vehicleService.searchByModel(model);
        return ResponseEntity.ok(vehicles);
    }
    @GetMapping(value ="/getAllVehicle/{millage}")
    public ResponseEntity<List<Vehicle>> getVehicleByMillage(@PathVariable Integer millage)
    {
        List<Vehicle> vehicles = vehicleService.searchByMillage(millage);
        return ResponseEntity.ok(vehicles);
    }
}
