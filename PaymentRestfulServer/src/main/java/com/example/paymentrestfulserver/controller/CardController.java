package com.example.paymentrestfulserver.controller;

import com.example.paymentrestfulserver.model.CreditCard;
import com.example.paymentrestfulserver.model.Payment;
import com.example.paymentrestfulserver.model.ProcessPayment;
import com.example.paymentrestfulserver.repository.CreditCardRepository;
import com.example.paymentrestfulserver.repository.PaymentRepository;
import com.example.paymentrestfulserver.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    @GetMapping("/getAllCreditCard")
    public List<CreditCard> getAllCreditCard() {
       return creditCardRepository.findAll();
    }

    @PostMapping("/calculate-fee")
    public double calculateTourFee(@RequestBody ProcessPayment process) {
        Payment payment = new Payment();
        payment.setFee(paymentService.CalculateFee(process));
        payment.setNumber_of_people(process.getNumber_of_people());
        payment.setCreditCard(process.getCreditCard());
        paymentRepository.save(payment);
        return payment.getFee();
    }
}
