package com.rentacar.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.groups.Default;
import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeTO implements Serializable {
    @Null(groups = {Create.class},message = "Id need to be null when creating employee")
    @NotNull(groups = {Update.class},message = "Id cannot be null;")
    private Integer id;
    @NotNull
    private String fullName;
    @NotNull
    private String address;
    @Pattern(regexp = "^(07\\d-\\d{7})|([+]947\\d{8})$",message = "error nic format")
    private String nic;
    private String email;
    private Set<String> contacts;

    public interface Create extends Default{}
    public interface Update extends Default{}

}
