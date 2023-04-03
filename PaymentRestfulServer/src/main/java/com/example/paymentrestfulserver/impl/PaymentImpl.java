package com.example.paymentrestfulserver.impl;

import com.example.paymentrestfulserver.model.ProcessPayment;
import com.example.paymentrestfulserver.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentImpl implements PaymentService {
    @Override
    public double CalculateFee(ProcessPayment process){
        return process.getNumber_of_people()*100;
    }
}
