package com.example.paymentrestfulserver.model;

import lombok.Data;

@Data

public class ProcessPayment {
    
    private CreditCard creditCard;
    private int number_of_people ;
}
