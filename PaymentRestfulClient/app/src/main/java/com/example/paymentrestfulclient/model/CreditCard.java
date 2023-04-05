package com.example.paymentrestfulclient.model;

public class CreditCard {

    private String cardHolderName;

    private String cardType;

    private String cardNumber;

    private int cardCvc;

    public String getCardHolderName() {
        return cardHolderName;
    }

    public String getCardType() {
        return cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public int getCardCvc() {
        return cardCvc;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    private String expirationYear;

    private String expirationMonth;

    public CreditCard(String cardHolderName, String cardType, String cardNumber, int cardCvc, String expirationYear, String expirationMonth) {
        this.cardHolderName = cardHolderName;
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.cardCvc = cardCvc;
        this.expirationYear = expirationYear;
        this.expirationMonth = expirationMonth;
    }
}
