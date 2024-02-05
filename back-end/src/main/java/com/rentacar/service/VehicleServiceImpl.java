package com.rentacar.service;

import com.rentacar.entity.Vehicle;
import com.rentacar.repository.VehicleRepository;
import com.rentacar.to.VehicleTO;
import com.rentacar.util.Varlist;
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
public class VehicleServiceImpl implements VehicleService{
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public VehicleTO createVehicle(VehicleTO vehicleTO)
    {
        if(vehicleRepository.exitByPlateNo(vehicleTO.getPlateNo())){
            return null;
        }else {
            MultipartFile imageFile = vehicleTO.getImageFile();
            if (imageFile != null && !imageFile.isEmpty()) {
                try {
                    vehicleTO.setImage(imageFile.getBytes());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            vehicleRepository.save(modelMapper.map(vehicleTO, Vehicle.class));
            return vehicleTO;
        }
    }
    @Override
    public VehicleTO updateVehicle(VehicleTO vehicleTO)
    {
        if(vehicleRepository.existsById(vehicleTO.getId())){
            vehicleRepository.save(modelMapper.map(vehicleTO, Vehicle.class));
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
        return optionalVehicle.map(vehicle -> modelMapper.map(vehicle, VehicleTO.class)).orElse(null);
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
