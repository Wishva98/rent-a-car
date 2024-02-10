package com.rentacar.service.custom;

import com.rentacar.entity.Vehicle;
import com.rentacar.to.VehicleTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface VehicleService {
  VehicleTO createVehicle(VehicleTO vehicleTO, MultipartFile imageFile);
  VehicleTO updateVehicle(VehicleTO vehicleTO,MultipartFile imageFile);
  void deleteVehicle(Integer id);
  List<Vehicle> getAllVehicles();
  VehicleTO getVehicleById(Integer id);
  List<Vehicle> searchByModel(String model);
  List<Vehicle> searchByMillage(Integer millage);
}
