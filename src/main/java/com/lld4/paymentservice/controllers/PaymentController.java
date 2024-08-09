package com.lld4.paymentservice.controllers;

import com.lld4.paymentservice.dtos.CreatePaymentLinkRequestDto;
import com.lld4.paymentservice.services.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/createlink")
    public String createPaymetnLink(@RequestBody CreatePaymentLinkRequestDto paymentRequestDto) {

        return paymentService.createPaymentLink(paymentRequestDto.getOrderId());
    }


    @GetMapping("{id}")
    public String getPriceByProductId(@PathVariable("id") Long productId) {

        System.out.println("Received the request form Product Microservice");
        long price = productId * 5;
        return "This price of the product " + productId + " is " + price;
    }
}
