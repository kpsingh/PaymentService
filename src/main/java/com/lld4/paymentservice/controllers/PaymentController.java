package com.lld4.paymentservice.controllers;

import com.lld4.paymentservice.dtos.CreatePaymentLinkRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {


    @PostMapping("/createlink")
    public String createPaymetnLink(@RequestBody CreatePaymentLinkRequestDto paymentRequestDto) {

        return null;
    }
}