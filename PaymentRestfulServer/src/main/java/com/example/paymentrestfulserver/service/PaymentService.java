package com.example.paymentrestfulserver.service;

import com.example.paymentrestfulserver.model.ProcessPayment;

public interface PaymentService {
    double CalculateFee(ProcessPayment process);


}
