package com.rentacar.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerTO implements Serializable {
//    (null, "Dakshitha", "Ranawaka", "266/2","Matara", "Sri Lanka", "981350731V")
    // Todo : ?
    @Null
    private Integer id;
    @NotBlank(message = "First name Should not be null")
    @Pattern(regexp = "^[A-Za-z ]{2,}$", message = "Invalid name")
    private String fullName;
    @NotNull(message = "House details Should not be null")
    @Length(min = 2, message = "Invalid house details")
    private String address;
    @NotBlank(message = "Driving license details Should not be null")
    @Length(min = 2, message = "Invalid license details")
    private String drivingLicenseNumber;
    @NotNull(message = "Contact number should not be null")
//    @Pattern(regexp = "^([0]?|[+]{1}94)[7]{1}[01245678]{1}[0-9]{7}$")
    private String contactNo;
    private String email;

    public String getContactNo() {
        return "0"+contactNo.substring(contactNo.length()-9);
    }
}
