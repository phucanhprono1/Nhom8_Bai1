package com.example.paymentrestfulserver.model;

import lombok.Data;

@Data

public class ProcessPayment {
    private Integer id;
    private CreditCard creditCard;
    private long number_of_people ;
}
