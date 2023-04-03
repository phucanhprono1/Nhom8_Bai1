package com.example.paymentrestfulserver.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "cardinfo")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "card_holder_name")
    private String cardHolderName;
    @Column(name = "card_type")
    private String cardType;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "cvc")
    private int cardCvc;
    @Column(name = "expiration_year")
    private String expirationYear;
    @Column(name = "expiration_month")
    private String expirationMonth;

    public CreditCard() {

    }
}
