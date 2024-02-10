package com.rentacar.service.custom.impl;

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

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class VehicleServiceImplTest {
    @Autowired
    VehicleServiceImpl vehicleService;
    @Autowired
    VehicleRepository vehicleRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createVehicle() {
        byte[] content = "mock image content".getBytes();
        MultipartFile imageFile = new MockMultipartFile("imageFile", "mock.jpg", "image/jpeg", content);
        VehicleTO vehicleTO=new VehicleTO(null,"KQ-1234","Toyota",5000,null,20000,"about to service","goog condition",true);
        VehicleTO savedVehicleTo=vehicleService.createVehicle(vehicleTO,imageFile);
        System.out.println(savedVehicleTo);
        assertNotNull(savedVehicleTo);
        assertEquals(vehicleTO.getPlateNo(), savedVehicleTo.getPlateNo());
    }

    @Test
    void updateVehicle() {
    }

    @Test
    void deleteVehicle() {
    }

    @Test
    void getAllVehicles() {
    }

    @Test
    void getVehicleById() {
    }

    @Test
    void searchByModel() {
    }

    @Test
    void searchByMillage() {
    }
}