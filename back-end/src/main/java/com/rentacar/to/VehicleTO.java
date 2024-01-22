package com.rentacar.to;

import com.rentacar.util.PayMethod;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class VehicleTO implements Serializable {
    private Integer id;
    @NotNull(message = "Plate number should not be null")
    @Length(min = 7, message = "Invalid Plate Number")
    private String plateNo;
    @NotNull(message = "Model number should not be null")
    private String model;

   // @Size(min = 1)
    private byte[] image;

    private String imagePath;

    private int millage;

    private String condition;

    @NotNull(message = "Availability should not be null")
    private Boolean availability;
}
