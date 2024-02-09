package com.rentacar.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerTO implements Serializable {
//    (null, "Dakshitha", "Ranawaka", "266/2","Matara", "Sri Lanka", "981350731V")
    // Todo : ?
    private Integer id;
    @NotBlank(message = "First name Should not be null")
    @Pattern(regexp = "^[A-Za-z ]{2,}$", message = "Invalid name")
    private String fullName;
    @NotBlank(message = "House details Should not be null")
    @Length(min = 2, message = "Invalid house details")
    private String address;
    @NotBlank(message = "Driving license details Should not be null")
    @Length(min = 2, message = "Invalid license details")
    private String drivingLicenseNumber;
}
