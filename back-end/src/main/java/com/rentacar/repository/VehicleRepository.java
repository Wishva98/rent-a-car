package com.rentacar.repository;

import com.rentacar.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
public interface VehicleRepository extends  JpaRepository<Vehicle,Integer>{
}
