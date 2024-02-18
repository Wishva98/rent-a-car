package com.rentacar.service.custom.impl;

import com.rentacar.entity.Vehicle;
import com.rentacar.repository.VehicleRepository;
import com.rentacar.to.VehicleTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class VehicleServiceImplTest {
    @Autowired
    VehicleServiceImpl vehicleService;
    @Autowired
    VehicleRepository vehicleRepository;
    private VehicleTO  vehicleTO;
    private VehicleTO  vehicleTO2;
    private VehicleTO  savedVehicleTo1;
    private VehicleTO  savedVehicleTo2;
    private MultipartFile imageFile;

    @BeforeEach
    void setUp() {
         byte[] content = "mock image content".getBytes();
         imageFile = new MockMultipartFile("imageFile", "mock.jpg", "image/jpeg", content);
         vehicleTO=new VehicleTO(1,"KQ-1234","Toyota",5000,null,20000,"about to service","good condition",true);
         savedVehicleTo1=vehicleService.createVehicle(vehicleTO,imageFile);
         vehicleTO2=new VehicleTO(2,"KO-1234","BMW",6000,null,40000,"about to service","good condition",true);
         savedVehicleTo2=vehicleService.createVehicle(vehicleTO2,imageFile);
    }

    @AfterEach
    @Transactional
    void tearDown() {
    }

    @Test
    void createVehicle() {
        byte[] content = "mock image content".getBytes();
        MultipartFile imageFile = new MockMultipartFile("imageFile", "mock.jpg", "image/jpeg", content);
        VehicleTO vehicleTO3=new VehicleTO(3,"KQ-1235","Toyota",6000,null,20000,"about to service","goog condition",true);
        VehicleTO savedVehicleTo=vehicleService.createVehicle(vehicleTO3,imageFile);
        assertNotNull(savedVehicleTo);
        assertEquals(vehicleTO3.getPlateNo(), savedVehicleTo.getPlateNo());
        VehicleTO savedVehicleTo2=vehicleService.createVehicle(vehicleTO3,imageFile);
        assertNull(savedVehicleTo2);
    }

    @Test
    void updateVehicle() {
        byte[] content = "mock image content".getBytes();
        MultipartFile imageFile = new MockMultipartFile("imageFile", "mock.jpg", "image/jpeg", content);
        VehicleTO vehicleTO=new VehicleTO(1,"KQ-1234","Toyota",6000,null,20000,"about to service","goog condition",true);
        VehicleTO updateVehicle=vehicleService.updateVehicle(vehicleTO,imageFile);
        assertNotNull(updateVehicle);
        assertEquals(vehicleTO.getPlateNo(),updateVehicle.getPlateNo());

    }

    @Test
    void deleteVehicle() {
        vehicleService.deleteVehicle(1);
        assertFalse(vehicleRepository.existsById(1));
    }

    @Test
    void getAllVehicles() {
        List<Vehicle> vehicles=vehicleService.getAllVehicles();
        System.out.println(vehicles);
        assertEquals(2,vehicles.size());

    }

    @Test
    void getVehicleById() {
        VehicleTO getVehicle=vehicleService.getVehicleById(1);
        assertNotNull(getVehicle);
        assertEquals(savedVehicleTo1.getPlateNo(),getVehicle.getPlateNo());
    }

    @Test
    void searchByModel() {
        List<Vehicle> vehicles=vehicleService.searchByModel("T");
        assertNotNull(vehicles);
        assertEquals(1,vehicles.size());

    }

    @Test
    void searchByMillage() {
        List<Vehicle> vehicles1=vehicleService.searchByMillage(20000);
        assertNotNull(vehicles1);
        assertEquals(1,vehicles1.size());
        List<Vehicle> vehicles2=vehicleService.searchByMillage(50000);
        assertNotNull(vehicles2);
        assertEquals(2,vehicles2.size());
    }
}