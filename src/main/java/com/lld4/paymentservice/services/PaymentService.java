package com.lld4.paymentservice.services;


import com.lld4.paymentservice.paymentgateways.PaymentGateway;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private PaymentGateway paymentGateway;

    public PaymentService(PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }

   public String createPaymentLink(Long orderId) {
        return paymentGateway.createPaymentLink(orderId);
    }
}
