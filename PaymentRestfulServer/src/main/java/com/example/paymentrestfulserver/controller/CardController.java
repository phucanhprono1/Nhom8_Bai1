package com.example.paymentrestfulserver.controller;

import com.example.paymentrestfulserver.model.CreditCard;
import com.example.paymentrestfulserver.model.Payment;
import com.example.paymentrestfulserver.model.ProcessPayment;
import com.example.paymentrestfulserver.repository.CreditCardRepository;
import com.example.paymentrestfulserver.repository.PaymentRepository;
import com.example.paymentrestfulserver.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CardController {
    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/addCreditCard")
    public CreditCard addCreditCard(@RequestBody CreditCard creditCard) {
        return creditCardRepository.save(creditCard);
    }


    @PostMapping("/calculate-fee")
    public Payment calculateTourFee(@RequestBody ProcessPayment process) {
        Payment payment = new Payment();
        payment.setFee(paymentService.CalculateFee(process));
        return paymentRepository.save(payment);
    }
}
