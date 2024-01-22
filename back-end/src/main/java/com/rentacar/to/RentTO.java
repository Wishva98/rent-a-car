package com.rentacar.to;

import com.rentacar.util.PayMethod;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

public class RentTO implements Serializable {
    //todo:  null or not auto generated or no?
    private Integer id;
    @NotNull(message = "Pay method should not be null")
    private PayMethod payMethod;
    @NotNull(message = "Rent price should not be null")
    private BigDecimal rentPrice;

    private BigDecimal damageCompensation = new BigDecimal(0.0);
    private BigDecimal total;
    //Todo: customer or customer id?
    @NotNull(message = "Customer should not be null")
    private CustomerTO customer;

    // Todo : should include reservation details?
}
