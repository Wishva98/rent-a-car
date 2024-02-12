package com.rentacar.to;

import com.rentacar.util.PayMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentTO implements Serializable {
    //todo:  null or not auto generated or no?
    private Integer id;
    @NotNull(message = "Pay method should not be null")
    private PayMethod payMethod;
    @NotNull(message = "Rent price should not be null")
    private BigDecimal rentPrice;
    private BigDecimal damageCompensation;
    private String damageDetails;
    private BigDecimal total;
    //Todo: customer or customer id?
    @NotNull(message = "Customer should not be null")
    private CustomerTO customer;
    @NotNull(message = "Reservation should not be null")
    private ReservationTO reservation;

    // Todo : should include reservation details?


    public RentTO(Integer id, PayMethod payMethod, BigDecimal rentPrice, BigDecimal damageCompensation, String damageDetails, CustomerTO customer) {
        this.id = id;
        this.payMethod = payMethod;
        this.rentPrice = rentPrice;
        this.damageCompensation = damageCompensation;
        if(damageCompensation == null)damageCompensation=new BigDecimal(0.0);
        this.damageDetails = damageDetails;
        this.customer = customer;
        this.total = rentPrice.add(damageCompensation);
    }
}
