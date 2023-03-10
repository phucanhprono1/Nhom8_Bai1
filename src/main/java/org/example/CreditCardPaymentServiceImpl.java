package org.example;

import javax.jws.WebService;

@WebService(endpointInterface = "org.example.CreditCardPaymentService")
public class CreditCardPaymentServiceImpl implements CreditCardPaymentService{

    @Override
    public String processPayment(String cardHolderName, String cardType, String cardNumber, int cvc, String expirationYear, String expirationMonth) {
        return "Payment processed successfully";
    }
}
