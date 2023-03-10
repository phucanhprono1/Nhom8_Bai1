package org.example;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class CreditCardPaymentServicePublisher {
    public static void main(String[] args) {
        CreditCardPaymentServiceImpl serviceimpl = new CreditCardPaymentServiceImpl();
        JaxWsServerFactoryBean svrFactoryBean = new JaxWsServerFactoryBean();
        svrFactoryBean.setServiceClass(CreditCardPaymentService.class);
        svrFactoryBean.setAddress("http://localhost:8080/CreditCardPaymentService");
        svrFactoryBean.setServiceBean(serviceimpl);
        svrFactoryBean.create();
    }
}
