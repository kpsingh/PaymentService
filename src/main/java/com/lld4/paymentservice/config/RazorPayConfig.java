package com.lld4.paymentservice.config;


import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorPayConfig {
    @Value("${razorpay.key}")
    private String key;

    @Value("${razorpay.secret}")
    private String secret;

    @Bean
    public RazorpayClient razorpayClient() throws RazorpayException {

        System.out.println("Key : " + key);
        System.out.println("Secret : " + secret);
        return new RazorpayClient(key, secret);
    }
}
