/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.example;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Asus
 */
@WebService
public interface CreditCardPaymentService {
    @WebMethod
    String processPayment(
        @WebParam(name = "cardHolderName")String cardHolderName,
        @WebParam(name = "cardType")String cardType,
        @WebParam(name = "cardNumber")String cardNumber,
        @WebParam(name = "cvc")int cvc,
        @WebParam(name = "expirationYear")String expirationYear,
        @WebParam(name = "expirationMonth")String expirationMonth
    );
}
