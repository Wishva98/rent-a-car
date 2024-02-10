package com.rentacar.repository;

import com.rentacar.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehicleRepository extends  JpaRepository<Vehicle,Integer>{
    boolean  existsByPlateNo(String plateNo);
    @Query("SELECT vehicle FROM Vehicle vehicle WHERE LOWER(vehicle.model) LIKE LOWER(:model || '%')")
    List<Vehicle> findByModel(@Param("model") String model);
    @Query("SELECT vehicle FROM Vehicle vehicle WHERE vehicle.millage<=:millage ")
    List<Vehicle> findByMillage(@Param("millage") Integer millage);

}
