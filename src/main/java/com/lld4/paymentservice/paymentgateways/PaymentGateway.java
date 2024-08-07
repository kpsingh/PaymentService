package com.lld4.paymentservice.paymentgateways;

public interface PaymentGateway {
    String createPaymentLink(Long orderId);
}
