package com.rentacar.to;

import com.rentacar.entity.Vehicle;
import com.rentacar.util.PayMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.domain.Example;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleTO implements Serializable {
    private Integer id;
    @NotNull(message = "Plate number should not be null")
    @Length(min = 7, message = "Invalid Plate Number")
    private String plateNo;
    @NotNull(message = "Model number should not be null")
    private String model;

   // @Size(min = 1)
    private byte[] image;

    private MultipartFile imageFile;

    private int millage;

    private String condition;

    @NotNull(message = "Availability should not be null")
    private Boolean availability;

}
