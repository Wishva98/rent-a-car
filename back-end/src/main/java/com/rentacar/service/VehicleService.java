package com.rentacar.service;

import com.rentacar.entity.Vehicle;
import com.rentacar.to.VehicleTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleService {
  VehicleTO createVehicle(VehicleTO vehicleTO);
  VehicleTO updateVehicle(VehicleTO vehicleTO);
  void deleteVehicle(Integer id);
  List<Vehicle> getAllVehicles();
  VehicleTO getVehicleById(Integer id);
  List<Vehicle> searchByModel(String model);
  List<Vehicle> searchByMillage(Integer millage);
}
