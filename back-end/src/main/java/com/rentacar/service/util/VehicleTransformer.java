package com.rentacar.service.util;

import com.rentacar.entity.Vehicle;
import com.rentacar.to.VehicleTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VehicleTransformer {
    private final ModelMapper mapper;

    public VehicleTransformer(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Vehicle fromVehicleTo(VehicleTO vehicleTO){
        Vehicle vehicle = mapper.map(vehicleTO, Vehicle.class);
        return vehicle;
    }

    public VehicleTO toVehicleTO(Vehicle vehicle){
        VehicleTO vehicleTO = mapper.map(vehicle, VehicleTO.class);
        return vehicleTO;
    }
}
