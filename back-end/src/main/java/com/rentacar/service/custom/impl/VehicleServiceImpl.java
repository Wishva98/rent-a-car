package com.rentacar.service.custom.impl;

import com.rentacar.entity.Rent;
import com.rentacar.entity.Vehicle;
import com.rentacar.exception.AppException;
import com.rentacar.repository.VehicleRepository;
import com.rentacar.service.custom.VehicleService;
import com.rentacar.service.util.VehicleTransformer;
import com.rentacar.to.RentTO;
import com.rentacar.to.VehicleTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private VehicleTransformer vehicleTransformer;
    @Override
    public VehicleTO createVehicle(VehicleTO vehicleTO,MultipartFile imageFile)
    {
        if(vehicleRepository.existsById(vehicleTO.getId()) && vehicleRepository.existsByPlateNo(vehicleTO.getPlateNo())){
            return null;
        }else {
            if (imageFile != null && !imageFile.isEmpty()) {
                try {
                    vehicleTO.setImage(imageFile.getBytes());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            vehicleRepository.save(vehicleTransformer.fromVehicleTo(vehicleTO));
            return vehicleTO;
        }
    }
    @Override
    public VehicleTO updateVehicle(VehicleTO vehicleTO,MultipartFile imageFile)
    {
        if(vehicleRepository.existsById(vehicleTO.getId())){
            if (imageFile != null && !imageFile.isEmpty()) {
                try {
                    vehicleTO.setImage(imageFile.getBytes());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            vehicleRepository.save(vehicleTransformer.fromVehicleTo(vehicleTO));
            return vehicleTO;
        }else{
            return null;
        }
    }

    @Override
    public void deleteVehicle(Integer id)
    {
        vehicleRepository.deleteById(id);
    }

    @Override
    public List<Vehicle> getAllVehicles()
    {
        return vehicleRepository.findAll();
    }

    @Override
    public VehicleTO getVehicleById(Integer id)
    {
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(id);
        if(optionalVehicle.isEmpty())throw new AppException(500,"Vehicle does not exist");
        Vehicle vehicle=optionalVehicle.get();
        return  vehicleTransformer.toVehicleTO(vehicle);
    }
    @Override
    public List<Vehicle> searchByModel(String model)
    {
          return vehicleRepository.findByModel(model);
    }
    @Override
    public List<Vehicle> searchByMillage(Integer millage)
    {
        return vehicleRepository.findByMillage(millage);
    }




}
