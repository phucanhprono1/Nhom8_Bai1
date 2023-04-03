package com.example.paymentrestfulserver.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name="payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "number_of_people")
    private long number_of_people ;
    @Column(name = "fee")
    private double fee;
    @OneToOne
    private CreditCard creditCard;

    public Payment() {

    }
}
