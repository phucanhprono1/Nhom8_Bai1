package com.example.paymentrestfulclient.model;

import java.io.Serializable;

public class ProcessPayment implements Serializable {

    private CreditCard creditCard;
    private int number_of_people ;

    public ProcessPayment(CreditCard creditCard, int number_of_people) {
        this.creditCard = creditCard;
        this.number_of_people = number_of_people;
    }
}
