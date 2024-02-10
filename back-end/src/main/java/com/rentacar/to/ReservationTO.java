package com.rentacar.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationTO implements Serializable {
    private Integer id;
    @NotNull(message = "Reservation date should not be null")
    private Date reservationDate;

    @NotNull(message = "Pickup date should not be null")
    private Date pickupDate;

    @NotNull(message = "Return date should not be null")
    private Date returnDate;

    @NotNull(message = "Number of days should not be null")
    private int noOfDays;

    private String cancellationDetails;
    private Boolean reservationStatus;
    @NotNull(message = "vehicle should not be null")
    private VehicleTO vehicle;

    //toDo: future dates validation part


}
