package com.example.paymentrestfulclient.model;

public class Payment {

    private long number_of_people ;

    private double fee;



    public long getNumber_of_people() {
        return number_of_people;
    }

    public void setNumber_of_people(long number_of_people) {
        this.number_of_people = number_of_people;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    private CreditCard creditCard;
}
